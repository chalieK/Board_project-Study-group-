package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "health_id")
    private HealthInfo healthInfo;


    public void modifyReview(String title,String contents,HealthInfo healthInfo){
        this.title=title;
        this.contents=contents;
        this.healthInfo=healthInfo;

    }
}
