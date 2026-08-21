package com.example.slambook.service.impl;

import com.example.slambook.dto.request.CreateMemoryRequest;
import com.example.slambook.dto.response.MemoryResponse;
import com.example.slambook.entity.Memory;
import com.example.slambook.exception.ResourceNotFoundException;
import com.example.slambook.repository.MemoryRepository;
import com.example.slambook.service.MemoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemoryServiceImpl implements MemoryService {

    private final MemoryRepository memoryRepository;

    public MemoryServiceImpl(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public MemoryResponse create(UUID slamBookId, CreateMemoryRequest request) {
        Memory memory = Memory.builder()
                .slamBookId(slamBookId)
                .photoUrl(request.getPhotoUrl())
                .text(request.getText())
                .capsuleDate(request.getCapsuleDate())
                .build();

        Memory saved = memoryRepository.save(memory);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemoryResponse> getBySlamBookId(UUID slamBookId) {
        return memoryRepository.findBySlamBookId(slamBookId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID memoryId) {
        Memory memory = memoryRepository.findById(memoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Memory not found with id: " + memoryId
                ));
        memoryRepository.delete(memory);
    }

    private MemoryResponse mapToResponse(Memory memory) {
        return MemoryResponse.builder()
                .id(memory.getId().toString())
                .slamBookId(memory.getSlamBookId().toString())
                .photoUrl(memory.getPhotoUrl())
                .text(memory.getText())
                .capsuleDate(memory.getCapsuleDate())
                .build();
    }
}
