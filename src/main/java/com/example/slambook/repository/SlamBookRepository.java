package com.example.slambook.repository;

import com.example.slambook.entity.SlamBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SlamBookRepository extends JpaRepository<SlamBook, UUID> {
}
