package com.example.slambook.controller;

import com.example.slambook.dto.request.CreateSlamBookRequest;
import com.example.slambook.dto.request.UpdateSlamBookRequest;
import com.example.slambook.dto.response.ApiResponse;
import com.example.slambook.dto.response.SlamBookResponse;
import com.example.slambook.service.SlamBookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/slam")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SlamBookController {


    private final SlamBookService slamBookService;

    public SlamBookController(
            SlamBookService slamBookService) {

        this.slamBookService = slamBookService;
    }

    @PostMapping
    public ResponseEntity<SlamBookResponse> create(
            @Valid @RequestBody
            CreateSlamBookRequest request) {

        SlamBookResponse response =
                slamBookService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<java.util.List<SlamBookResponse>> getAll() {
        return ResponseEntity.ok(
                slamBookService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlamBookResponse> getById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                slamBookService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlamBookResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody
            UpdateSlamBookRequest request) {

        SlamBookResponse response =
                slamBookService.update(id, request);

        return ResponseEntity.ok(response);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable UUID id) {

        slamBookService.delete(id);

        ApiResponse<Void> response =
                new ApiResponse<>(
                        true,
                        "SlamBook Deleted Successfully...",
                        null
                );

        return ResponseEntity.ok(response);
    }
}