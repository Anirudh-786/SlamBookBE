package com.example.slambook.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;



public class SlamBookResponse {

    private UUID id;

    private String fullName;

    private String nickname;

    private String gender;

    private LocalDate dateOfBirth;

    private String favoriteColor;

    private String aboutMe;

    private Integer friendshipRating;

    private Boolean bestFriend;

    private LocalDate friendshipSince;

    public SlamBookResponse() {
    }

    public SlamBookResponse(
            UUID id,
            String fullName,
            String nickname,
            String gender,
            LocalDate dateOfBirth,
            String favoriteColor,
            String aboutMe,
            Integer friendshipRating,
            Boolean bestFriend,
            LocalDate friendshipSince) {

        this.id = id;
        this.fullName = fullName;
        this.nickname = nickname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.favoriteColor = favoriteColor;
        this.aboutMe = aboutMe;
        this.friendshipRating = friendshipRating;
        this.bestFriend = bestFriend;
        this.friendshipSince = friendshipSince;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Integer getFriendshipRating() {
        return friendshipRating;
    }

    public void setFriendshipRating(Integer friendshipRating) {
        this.friendshipRating = friendshipRating;
    }

    public Boolean getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(Boolean bestFriend) {
        this.bestFriend = bestFriend;
    }

    public LocalDate getFriendshipSince() {
        return friendshipSince;
    }

    public void setFriendshipSince(LocalDate friendshipSince) {
        this.friendshipSince = friendshipSince;
    }
}
