package com.example.slambook.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendshipRecapResponse {
    private String slamBookId;
    private Integer totalFriends;
    private String averageRating;
    private Integer bestFriendsCount;
    private String summary;
}
