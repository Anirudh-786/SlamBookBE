package com.example.slambook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:8081", "https://slam-book-fe-ten.vercel.app"})
public class UploadController {

    @Value("${supabase.url:}")
    private String supabaseUrl;

    @Value("${supabase.key:}")
    private String supabaseKey;

    @Value("${supabase.bucket:images}")
    private String supabaseBucket;

    private final RestTemplate restTemplate;

    public UploadController() {
        this.restTemplate = new RestTemplate();
    }

    @PostMapping("/uploads")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                return ResponseEntity.badRequest().body("No file provided");
            }

            if (supabaseUrl == null || supabaseUrl.isBlank() || supabaseKey == null || supabaseKey.isBlank()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Supabase is not configured on the server.");
            }

            String original = file.getOriginalFilename();
            if (original == null) {
                return ResponseEntity.badRequest().body("Invalid file");
            }

            // Extract file extension
            String ext = "";
            if (original.contains(".")) {
                ext = original.substring(original.lastIndexOf('.'));
            }

            // Generate unique filename
            String filename = UUID.randomUUID().toString() + ext;

            // Construct Supabase Storage URL
            String uploadUrl = String.format("%s/storage/v1/object/%s/%s", supabaseUrl, supabaseBucket, filename);

            // Prepare headers
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(supabaseKey);
            headers.set("apikey", supabaseKey);
            
            // Set Content-Type
            String contentType = file.getContentType();
            if (contentType == null) {
                contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
            }
            headers.setContentType(MediaType.parseMediaType(contentType));

            // Execute request
            HttpEntity<byte[]> requestEntity = new HttpEntity<>(file.getBytes(), headers);
            ResponseEntity<String> supabaseResponse;
            try {
                supabaseResponse = restTemplate.exchange(
                        uploadUrl,
                        HttpMethod.POST,
                        requestEntity,
                        String.class
                );
            } catch (org.springframework.web.client.HttpStatusCodeException e) {
                return ResponseEntity.status(e.getStatusCode())
                        .body("Supabase error: " + e.getResponseBodyAsString());
            }

            if (supabaseResponse.getStatusCode().is2xxSuccessful()) {
                // Return the public URL
                String publicUrl = String.format("%s/storage/v1/object/public/%s/%s", supabaseUrl, supabaseBucket, filename);
                return ResponseEntity.ok().body(Map.of("url", publicUrl));
            } else {
                return ResponseEntity.status(supabaseResponse.getStatusCode())
                        .body("Failed to upload to Supabase: " + supabaseResponse.getBody());
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }
}
