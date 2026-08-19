package com.example.slambook.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateFriendRequest {

    private String name;

    private String nickname;

    @Size(
            max = 1000,
            message = "Message cannot exceed 1000 characters"
    )
    private String message;

    @Size(
            max = 2000,
            message = "Memory cannot exceed 2000 characters"
    )
    private String memory;

    private String songDedication;

    private String favoriteThing;

    public UpdateFriendRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getSongDedication() {
        return songDedication;
    }

    public void setSongDedication(String songDedication) {
        this.songDedication = songDedication;
    }

    public String getFavoriteThing() {
        return favoriteThing;
    }

    public void setFavoriteThing(String favoriteThing) {
        this.favoriteThing = favoriteThing;
    }
}