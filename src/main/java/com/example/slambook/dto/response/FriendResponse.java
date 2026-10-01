package com.example.slambook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendResponse {

    private UUID id;

    private UUID slamBookId;

    private String name;

    private String nickname;

    private String message;

    private String memory;

    private String songDedication;

    private String favoriteThing;

//    public FriendResponse() {
//    }
//
//    public FriendResponse(
//            UUID id,
//            UUID slamBookId,
//            String name,
//            String nickname,
//            String message,
//            String memory,
//            String songDedication,
//            String favoriteThing) {
//
//        this.id = id;
//        this.slamBookId = slamBookId;
//        this.name = name;
//        this.nickname = nickname;
//        this.message = message;
//        this.memory = memory;
//        this.songDedication = songDedication;
//        this.favoriteThing = favoriteThing;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public UUID getSlamBookId() {
//        return slamBookId;
//    }
//
//    public void setSlamBookId(UUID slamBookId) {
//        this.slamBookId = slamBookId;
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
