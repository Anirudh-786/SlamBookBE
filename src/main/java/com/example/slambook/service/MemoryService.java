package com.example.slambook.service;

import com.example.slambook.dto.request.CreateMemoryRequest;
import com.example.slambook.dto.response.MemoryResponse;
import java.util.List;
import java.util.UUID;

public interface MemoryService {
    MemoryResponse create(UUID slamBookId, CreateMemoryRequest request);
    List<MemoryResponse> getBySlamBookId(UUID slamBookId);
    void delete(UUID memoryId);
}
