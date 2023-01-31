package com.example.demo.controller;

import com.example.demo.data.request.HealthRequestDTO;
import com.example.demo.data.request.ReviewRequestDTO;
import com.example.demo.data.response.ReviewResponseDTO;
import com.example.demo.domain.HealthInfo;
import com.example.demo.domain.Review;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    public final ReviewService reviewService;

    // 저장 페이지. 구현 중
    @GetMapping("/review/save")
    public String writePage(@RequestParam Long id){
        System.out.println(id);
        return "reviewSave";
    }

    //저장 기능 구현 중
    @PostMapping("/review/saver{id}")
    public String reviewSave(@PathVariable Long id, ReviewRequestDTO reviewRequestDTO){
        reviewService.reviewSaver(id, reviewRequestDTO);
        return "redirect:/review";

    }

    @GetMapping("/review/delete")
    public String reviewDeleter(@RequestParam Long id){
        reviewService.reviewDelete(id);
        return "redirect:/review";
    }

    //리뷰 수정페이지 보여주기
    @GetMapping("/review/reviewModify{id}")
    public String reviewModifyPage(Review review, Model model) {
        model.addAttribute(reviewService.reviewFindOne(review.getId()));
        return "reviewModify";
    }

    //리뷰 수정.
    @PostMapping("/review/modified/update")
    public String reviewModified(ReviewRequestDTO reviewRequestDTO) {
        reviewService.updateReview(reviewRequestDTO);
        return "redirect:/review";
    }

}
