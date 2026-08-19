package com.example.slambook.service;

import com.example.slambook.dto.request.CreateFriendRequest;
import com.example.slambook.dto.request.UpdateFriendRequest;
import com.example.slambook.dto.response.FriendResponse;

import java.util.List;
import java.util.UUID;

public interface FriendService {

    FriendResponse create(
            UUID slamBookId,
            CreateFriendRequest request
    );

    List<FriendResponse> getBySlamBookId(
            UUID slamBookId
    );

    FriendResponse update(
            UUID friendId,
            UpdateFriendRequest request
    );

    void delete(
            UUID friendId
    );
}