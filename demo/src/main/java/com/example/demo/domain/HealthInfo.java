package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "health_info")
public class HealthInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String brand_name;
        private String category;

        private String land_number;

        private String road_number;



        public void modifyHealthInfo(String brand_name,String land_number,String road_number, String category){
                this.brand_name=brand_name;
                this.category=category;
                this.land_number=land_number;
                this.road_number=road_number;

        }

        @Builder.Default
        @OrderBy("id asc")// 댓글 정렬
        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "healthInfo")
        private List<Review> reviews = new ArrayList<>();
                //댓글이 없는 경우에 null에러 예외를 방지하고자 이렇게 선언한다.
        public void addReview(Review review){
                reviews.add(review);
                review.setTitle(review.getTitle());
                review.setContents(review.getContents());
                review.setHealthInfo(review.getHealthInfo());
        }


}
