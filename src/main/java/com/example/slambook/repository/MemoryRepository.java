package com.example.slambook.repository;

import com.example.slambook.entity.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, UUID> {
    List<Memory> findBySlamBookId(UUID slamBookId);
}
