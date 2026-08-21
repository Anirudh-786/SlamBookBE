package com.example.slambook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoryResponse {
    private String id;
    private String slamBookId;
    private String photoUrl;
    private String text;
    private String capsuleDate;
}
