package com.example.slambook.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "memories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID slamBookId;

    @Column(columnDefinition = "TEXT")
    private String photoUrl;

    @Column(columnDefinition = "TEXT")
    private String text;

    private String capsuleDate;
}
