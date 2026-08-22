package com.example.slambook.controller;

import com.example.slambook.dto.request.CreateFriendRequest;
import com.example.slambook.dto.request.UpdateFriendRequest;
import com.example.slambook.dto.response.ApiResponse;
import com.example.slambook.dto.response.FriendResponse;
import com.example.slambook.service.FriendService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FriendController {


    private final FriendService friendService;

    public FriendController(
            FriendService friendService) {

        this.friendService = friendService;
    }

    // =========================
    // ADD FRIEND
    // =========================

    @PostMapping("/slam/{slamBookId}/friends")
    public ResponseEntity<FriendResponse> create(
            @PathVariable UUID slamBookId,
            @Valid @RequestBody
            CreateFriendRequest request) {

        FriendResponse response =
                friendService.create(
                        slamBookId,
                        request
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // =========================
    // GET FRIENDS
    // =========================

    @GetMapping("/slam/{slamBookId}/friends")
    public ResponseEntity<List<FriendResponse>> getFriends(
            @PathVariable UUID slamBookId) {

        return ResponseEntity.ok(
                friendService.getBySlamBookId(
                        slamBookId
                )
        );
    }

    // =========================
    // UPDATE FRIEND
    // =========================

    @PutMapping("/friends/{friendId}")
    public ResponseEntity<FriendResponse> update(
            @PathVariable UUID friendId,
            @Valid @RequestBody
            UpdateFriendRequest request) {

        return ResponseEntity.ok(
                friendService.update(
                        friendId,
                        request
                )
        );
    }

    // =========================
    // DELETE FRIEND
    // =========================

    @DeleteMapping("/friends/{friendId}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable UUID friendId) {

        friendService.delete(friendId);

        ApiResponse<Void> response =
                new ApiResponse<>(
                        true,
                        "Friend deleted Successfully....",
                        null
                );
        return ResponseEntity.ok(response);

    }
}
