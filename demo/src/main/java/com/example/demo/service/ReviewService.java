package com.example.demo.service;

import com.example.demo.data.request.HealthRequestDTO;
import com.example.demo.data.request.ReviewRequestDTO;
import com.example.demo.data.response.HealthResponseDTO;
import com.example.demo.data.response.ReviewResponseDTO;
import com.example.demo.domain.HealthInfo;
import com.example.demo.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public boolean reviewSaver(Long id, ReviewRequestDTO reviewRequestDTO);
    public List findReview(Long id);
    public ReviewResponseDTO reviewFindOne(Long id) ;

    //수정
    boolean updateReview(ReviewRequestDTO reviewRequestDTO);

    public boolean reviewDelete(Long id);

}
