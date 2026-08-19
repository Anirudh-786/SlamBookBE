package com.example.slambook.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "slam_books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlamBook {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    private String nickname;

    private String gender;

    private LocalDate dateOfBirth;

    private String favoriteColor;

    @Column(length = 1000)
    private String aboutMe;

    private Integer friendshipRating;

    private Boolean bestFriend;

    private LocalDate friendshipSince;
}
