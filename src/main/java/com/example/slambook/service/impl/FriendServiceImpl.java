package com.example.slambook.service.impl;

import com.example.slambook.dto.request.CreateFriendRequest;
import com.example.slambook.dto.request.UpdateFriendRequest;
import com.example.slambook.dto.response.FriendResponse;
import com.example.slambook.entity.Friend;
import com.example.slambook.entity.SlamBook;
import com.example.slambook.exception.ResourceNotFoundException;
import com.example.slambook.repository.FriendRepository;
import com.example.slambook.repository.SlamBookRepository;
import com.example.slambook.service.FriendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;

    private final SlamBookRepository slamBookRepository;

    public FriendServiceImpl(
            FriendRepository friendRepository,
            SlamBookRepository slamBookRepository) {

        this.friendRepository = friendRepository;
        this.slamBookRepository = slamBookRepository;
    }

    // =========================
    // CREATE FRIEND
    // =========================

    @Override
    public FriendResponse create(
            UUID slamBookId,
            CreateFriendRequest request) {

        SlamBook slamBook =
                slamBookRepository.findById(slamBookId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "SLAM Book not found with id: "
                                                + slamBookId
                                )
                        );

        Friend friend = new Friend();

        friend.setSlamBook(slamBook);
        friend.setName(request.getName());
        friend.setNickname(request.getNickname());
        friend.setMessage(request.getMessage());
        friend.setMemory(request.getMemory());
        friend.setSongDedication(
                request.getSongDedication()
        );
        friend.setFavoriteThing(
                request.getFavoriteThing()
        );

        Friend saved =
                friendRepository.save(friend);

        return mapToResponse(saved);
    }

    // =========================
    // GET FRIENDS
    // =========================

    @Override
    @Transactional(readOnly = true)
    public List<FriendResponse> getBySlamBookId(
            UUID slamBookId) {

        if (!slamBookRepository.existsById(slamBookId)) {

            throw new ResourceNotFoundException(
                    "SLAM Book not found with id: "
                            + slamBookId
            );
        }

        return friendRepository
                .findBySlamBookId(slamBookId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // =========================
    // UPDATE FRIEND
    // =========================

    @Override
    public FriendResponse update(
            UUID friendId,
            UpdateFriendRequest request) {

        Friend friend =
                friendRepository.findById(friendId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Friend not found with id: "
                                                + friendId
                                )
                        );

        friend.setName(request.getName());
        friend.setNickname(request.getNickname());
        friend.setMessage(request.getMessage());
        friend.setMemory(request.getMemory());
        friend.setSongDedication(
                request.getSongDedication()
        );
        friend.setFavoriteThing(
                request.getFavoriteThing()
        );

        Friend updated =
                friendRepository.save(friend);

        return mapToResponse(updated);
    }

    // =========================
    // DELETE FRIEND
    // =========================

    @Override
    public void delete(UUID friendId) {

        Friend friend =
                friendRepository.findById(friendId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Friend not found with id: "
                                                + friendId
                                )
                        );

        friendRepository.delete(friend);
    }

    // =========================
    // MAPPER
    // =========================

    private FriendResponse mapToResponse(
            Friend friend) {

        return new FriendResponse(
                friend.getId(),
                friend.getSlamBook().getId(),
                friend.getName(),
                friend.getNickname(),
                friend.getMessage(),
                friend.getMemory(),
                friend.getSongDedication(),
                friend.getFavoriteThing()
        );
    }
}