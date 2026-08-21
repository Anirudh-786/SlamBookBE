package com.example.slambook.controller;

import com.example.slambook.dto.request.CreateMemoryRequest;
import com.example.slambook.dto.response.AiSummaryResponse;
import com.example.slambook.dto.response.ApiResponse;
import com.example.slambook.dto.response.FriendshipRecapResponse;
import com.example.slambook.dto.response.MemoryResponse;
import com.example.slambook.service.MemoryService;
import com.example.slambook.service.RecapService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:8081"})
public class MemoryController {

    private final MemoryService memoryService;
    private final RecapService recapService;

    public MemoryController(MemoryService memoryService, RecapService recapService) {
        this.memoryService = memoryService;
        this.recapService = recapService;
    }

    // ========================
    // MEMORIES
    // ========================

    @PostMapping("/slam/{slamBookId}/memories")
    public ResponseEntity<MemoryResponse> addMemory(
            @PathVariable UUID slamBookId,
            @Valid @RequestBody CreateMemoryRequest request) {
        MemoryResponse response = memoryService.create(slamBookId, request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/slam/{slamBookId}/memories")
    public ResponseEntity<List<MemoryResponse>> getMemories(
            @PathVariable UUID slamBookId) {
        return ResponseEntity.ok(memoryService.getBySlamBookId(slamBookId));
    }

    @DeleteMapping("/memories/{memoryId}")
    public ResponseEntity<ApiResponse<Void>> deleteMemory(
            @PathVariable UUID memoryId) {
        memoryService.delete(memoryId);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Memory deleted successfully", null)
        );
    }

    // ========================
    // RECAP
    // ========================

    @GetMapping("/slam/{slamBookId}/recap")
    public ResponseEntity<FriendshipRecapResponse> getRecap(
            @PathVariable UUID slamBookId) {
        return ResponseEntity.ok(recapService.getFriendshipRecap(slamBookId));
    }

    // ========================
    // AI SUMMARY
    // ========================

    @PostMapping("/slam/{slamBookId}/ai-summary")
    public ResponseEntity<AiSummaryResponse> generateAiSummary(
            @PathVariable UUID slamBookId) {
        return ResponseEntity.ok(recapService.generateAiSummary(slamBookId));
    }
}
