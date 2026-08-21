package com.example.slambook.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMemoryRequest {
    private String photoUrl;
    private String text;
    private String capsuleDate;
}
