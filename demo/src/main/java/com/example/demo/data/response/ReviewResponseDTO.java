package com.example.demo.data.response;

import com.example.demo.domain.HealthInfo;
import com.example.demo.domain.Review;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ReviewResponseDTO {
    private Long id;
    private String title;
    private String contents;
    private Long healthId;
    private HealthInfo healthInfo;

    public ReviewResponseDTO(Review review){
        this.id = review.getId();
        this.title = review.getTitle();
        this.contents = review.getContents();
        this.healthId = review.getHealthInfo().getId();

    }

    public static Review toEntity(ReviewResponseDTO reviewResponseDTO){
        return Review.builder()
                .id(reviewResponseDTO.getId())
                .title(reviewResponseDTO.getTitle())
                .contents(reviewResponseDTO.getContents())
                .healthInfo(reviewResponseDTO.getHealthInfo())
                .build();
    }
}
