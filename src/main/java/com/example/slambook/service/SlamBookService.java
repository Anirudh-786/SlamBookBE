package com.example.slambook.service;

import com.example.slambook.dto.request.CreateSlamBookRequest;
import com.example.slambook.dto.request.UpdateSlamBookRequest;
import com.example.slambook.dto.response.SlamBookResponse;
import com.example.slambook.entity.SlamBook;

import java.util.UUID;

public interface SlamBookService {

    SlamBookResponse create(
            CreateSlamBookRequest request
    );


    SlamBookResponse getById(
            UUID uuid
    );

    java.util.List<SlamBookResponse> getAll();

    SlamBookResponse update(
            UUID id,
            UpdateSlamBookRequest request
    );

    void delete(
            UUID id
    );

}
