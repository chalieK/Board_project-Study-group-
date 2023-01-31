package com.example.demo.data.request;

import com.example.demo.domain.HealthInfo;
import com.example.demo.domain.Review;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
public class ReviewRequestDTO {

    private Long id;
    private String title;
    private String contents;
    private HealthInfo healthInfo;


    //dto를 엔티티로
    public static Review toEntity(ReviewRequestDTO reviewRequestDTO){
        return Review.builder()
                .id(reviewRequestDTO.getId())
                .title(reviewRequestDTO.getTitle())
                .contents(reviewRequestDTO.getContents())
                .healthInfo(reviewRequestDTO.getHealthInfo())
                .build();
    }
}
