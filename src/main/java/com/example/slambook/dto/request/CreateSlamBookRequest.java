package com.example.slambook.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Data

public class CreateSlamBookRequest {

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String nickname;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String favoriteColor;

    @Size(
            max = 1000,
            message = "About me cannot exceed 1000 characters"
    )
    private String aboutMe;

    @Min(
            value = 1,
            message = "Friendship rating must be at least 1"
    )
    @Max(
            value = 10,
            message = "Friendship rating cannot exceed 10"
    )
    private Integer friendshipRating;

    private Boolean bestFriend;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate friendshipSince;
    
    // New: profile and capsule images/text
    private String profilePhotoUrl;

    private String capsulePhotoUrl;

    private String capsuleText;


    // No-argument constructor
    public CreateSlamBookRequest() {
    }

    // Getters and Setters

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

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getCapsulePhotoUrl() {
        return capsulePhotoUrl;
    }

    public void setCapsulePhotoUrl(String capsulePhotoUrl) {
        this.capsulePhotoUrl = capsulePhotoUrl;
    }

    public String getCapsuleText() {
        return capsuleText;
    }

    public void setCapsuleText(String capsuleText) {
        this.capsuleText = capsuleText;
    }
}
