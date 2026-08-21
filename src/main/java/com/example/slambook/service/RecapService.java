package com.example.slambook.service;

import com.example.slambook.dto.response.AiSummaryResponse;
import com.example.slambook.dto.response.FriendshipRecapResponse;
import java.util.UUID;

public interface RecapService {
    FriendshipRecapResponse getFriendshipRecap(UUID slamBookId);
    AiSummaryResponse generateAiSummary(UUID slamBookId);
}
