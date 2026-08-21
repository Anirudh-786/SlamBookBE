package com.example.slambook.service.impl;

import com.example.slambook.dto.response.AiSummaryResponse;
import com.example.slambook.dto.response.FriendshipRecapResponse;
import com.example.slambook.entity.Friend;
import com.example.slambook.entity.SlamBook;
import com.example.slambook.exception.ResourceNotFoundException;
import com.example.slambook.repository.FriendRepository;
import com.example.slambook.repository.SlamBookRepository;
import com.example.slambook.service.RecapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class RecapServiceImpl implements RecapService {

    private final SlamBookRepository slamBookRepository;
    private final FriendRepository friendRepository;

    public RecapServiceImpl(SlamBookRepository slamBookRepository, FriendRepository friendRepository) {
        this.slamBookRepository = slamBookRepository;
        this.friendRepository = friendRepository;
    }

    @Override
    public FriendshipRecapResponse getFriendshipRecap(UUID slamBookId) {
        // Verify the slam book exists
        SlamBook slamBook = slamBookRepository.findById(slamBookId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "SLAM Book not found with id: " + slamBookId
                ));

        List<Friend> friends = friendRepository.findBySlamBookId(slamBookId);
        int totalFriends = friends.size();
        
        // Get the friendship rating from the slam book owner's perspective
        Integer rating = slamBook.getFriendshipRating();
        String avgRating = rating != null ? rating.toString() : "0";
        
        // Count best friend flag
        int bestFriendCount = slamBook.getBestFriend() != null && slamBook.getBestFriend() ? 1 : 0;

        String summary = String.format(
                "You have %d wonderful friends with an average friendship rating of %s. %d marked as best friends!",
                totalFriends, avgRating, bestFriendCount
        );

        return FriendshipRecapResponse.builder()
                .slamBookId(slamBookId.toString())
                .totalFriends(totalFriends)
                .averageRating(avgRating)
                .bestFriendsCount(bestFriendCount)
                .summary(summary)
                .build();
    }

    @Override
    public AiSummaryResponse generateAiSummary(UUID slamBookId) {
        // Verify the slam book exists
        SlamBook slamBook = slamBookRepository.findById(slamBookId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "SLAM Book not found with id: " + slamBookId
                ));

        List<Friend> friends = friendRepository.findBySlamBookId(slamBookId);
        
        // Generate a summary based on available data
        StringBuilder summary = new StringBuilder("📖 Friendship Summary:\n");
        
        if (friends.isEmpty()) {
            summary.append("No friends have signed your SLAM book yet. Start adding some!");
        } else {
            summary.append(String.format("✨ You have %d wonderful friends!\n", friends.size()));
            
            int messagesCount = (int) friends.stream()
                    .filter(f -> f.getMessage() != null && !f.getMessage().isEmpty())
                    .count();
            summary.append(String.format("💬 %d have left heartfelt messages.\n", messagesCount));
            
            int songCount = (int) friends.stream()
                    .filter(f -> f.getSongDedication() != null && !f.getSongDedication().isEmpty())
                    .count();
            summary.append(String.format("🎵 %d have dedicated songs.\n", songCount));
            
            int favoriteThings = (int) friends.stream()
                    .filter(f -> f.getFavoriteThing() != null && !f.getFavoriteThing().isEmpty())
                    .count();
            summary.append(String.format("🌟 %d have shared favorite things.\n", favoriteThings));
        }

        return AiSummaryResponse.builder()
                .slamBookId(slamBookId.toString())
                .summary(summary.toString())
                .sentiment("positive")
                .build();
    }
}
