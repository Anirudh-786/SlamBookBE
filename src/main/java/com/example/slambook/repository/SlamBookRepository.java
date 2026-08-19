package com.example.slambook.repository;

import com.example.slambook.entity.SlamBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SlamBookRepository extends JpaRepository<SlamBook, UUID> {
}
