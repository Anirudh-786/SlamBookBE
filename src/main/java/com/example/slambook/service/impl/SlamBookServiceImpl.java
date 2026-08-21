package com.example.slambook.service.impl;

import com.example.slambook.dto.request.CreateSlamBookRequest; // Make sure to import your actual request DTO
import com.example.slambook.dto.request.UpdateSlamBookRequest;
import com.example.slambook.dto.response.SlamBookResponse;
import com.example.slambook.entity.SlamBook;
import com.example.slambook.exception.ResourceNotFoundException;
import com.example.slambook.repository.SlamBookRepository;
import com.example.slambook.service.SlamBookService;
import org.springframework.transaction.annotation.Transactional; // Preferred over jakarta.transaction for Spring
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SlamBookServiceImpl implements SlamBookService {

    private final SlamBookRepository slamBookRepository;

    public SlamBookServiceImpl(SlamBookRepository slamBookRepository) {
        this.slamBookRepository = slamBookRepository;
    }

    @Override
    public SlamBookResponse create(CreateSlamBookRequest request) { // Use the concrete class type here
        SlamBook slamBook = SlamBook.builder()
                .fullName(request.getFullName())
                .nickname(request.getNickname())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .favoriteColor(request.getFavoriteColor())
                .aboutMe(request.getAboutMe())
                .friendshipRating(request.getFriendshipRating())
                .bestFriend(request.getBestFriend())
                .friendshipSince(request.getFriendshipSince())
                .profilePhotoUrl(request.getProfilePhotoUrl())
                .capsulePhotoUrl(request.getCapsulePhotoUrl())
                .capsuleText(request.getCapsuleText())
                // .id(UUID.randomUUID()) // Uncomment this if you manually generate IDs instead of DB auto-generation
                .build();

        // FIX: Use the lower-case instance variable 'slamBookRepository'
        SlamBook saved = slamBookRepository.save(slamBook);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public SlamBookResponse getById(UUID id) {
        SlamBook slamBook = slamBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "SLAM Book not found with id: " + id
                ));
        return mapToResponse(slamBook);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SlamBookResponse> getAll() {
        return slamBookRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }



    @Override
    public SlamBookResponse update(
            UUID id,
            UpdateSlamBookRequest request) {

        SlamBook slamBook =
                slamBookRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "SLAM Book not found with id: "
                                                + id
                                )
                        );

        slamBook.setFullName(request.getFullName());
        slamBook.setNickname(request.getNickname());
        slamBook.setGender(request.getGender());
        slamBook.setDateOfBirth(request.getDateOfBirth());
        slamBook.setFavoriteColor(request.getFavoriteColor());
        slamBook.setAboutMe(request.getAboutMe());
        slamBook.setFriendshipRating(
                request.getFriendshipRating()
        );
        slamBook.setBestFriend(
                request.getBestFriend()
        );
        slamBook.setFriendshipSince(
                request.getFriendshipSince()
        );
        // New fields
        if (request.getProfilePhotoUrl() != null) slamBook.setProfilePhotoUrl(request.getProfilePhotoUrl());
        if (request.getCapsulePhotoUrl() != null) slamBook.setCapsulePhotoUrl(request.getCapsulePhotoUrl());
        if (request.getCapsuleText() != null) slamBook.setCapsuleText(request.getCapsuleText());

        SlamBook updated =
                slamBookRepository.save(slamBook);

        return mapToResponse(updated);
    }



    @Override
    public void delete(UUID id) {

        SlamBook slamBook =
                slamBookRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "SLAM Book not found with id: "
                                                + id
                                )
                        );

        slamBookRepository.delete(slamBook);
    }

    private SlamBookResponse mapToResponse(SlamBook slamBook) {
        return new SlamBookResponse(
                slamBook.getId(),
                slamBook.getFullName(),
                slamBook.getNickname(),
                slamBook.getGender(),
                slamBook.getDateOfBirth(),
                slamBook.getFavoriteColor(),
                slamBook.getAboutMe(),
                slamBook.getFriendshipRating(),
                slamBook.getBestFriend(),
                slamBook.getFriendshipSince()
                                ,
                                slamBook.getProfilePhotoUrl(),
                                slamBook.getCapsulePhotoUrl(),
                                slamBook.getCapsuleText()
        );
    }
}
