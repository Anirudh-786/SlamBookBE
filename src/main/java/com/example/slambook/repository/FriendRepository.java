package com.example.slambook.repository;

import com.example.slambook.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FriendRepository extends JpaRepository<Friend, UUID> {
    List<Friend> findBySlamBookId(UUID slamBookId);
}
