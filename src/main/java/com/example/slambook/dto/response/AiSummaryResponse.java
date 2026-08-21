package com.example.slambook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiSummaryResponse {
    private String slamBookId;
    private String summary;
    private String sentiment;
}
