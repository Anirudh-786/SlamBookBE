package com.example.slambook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slam_book_id", nullable = false)
    private SlamBook slamBook;

    @Column(nullable = false)
    private String name;

    private String nickname;

    @Column(length = 1000)
    private String message;

    @Column(length = 2000)
    private String memory;

    private String songDedication;

    private String favoriteThing;

//    // No-argument constructor
//    public Friend() {
//    }
//
//    // Getters and Setters
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public SlamBook getSlamBook() {
//        return slamBook;
//    }
//
//    public void setSlamBook(SlamBook slamBook) {
//        this.slamBook = slamBook;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNickname() {
//        return nickname;
//    }
//
//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getMemory() {
//        return memory;
//    }
//
//    public void setMemory(String memory) {
//        this.memory = memory;
//    }
//
//    public String getSongDedication() {
//        return songDedication;
//    }
//
//    public void setSongDedication(String songDedication) {
//        this.songDedication = songDedication;
//    }
//
//    public String getFavoriteThing() {
//        return favoriteThing;
//    }
//
//    public void setFavoriteThing(String favoriteThing) {
//        this.favoriteThing = favoriteThing;
//    }
}