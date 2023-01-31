package com.example.demo.controller;

import com.example.demo.data.request.HealthRequestDTO;
import com.example.demo.data.response.HealthResponseDTO;
import com.example.demo.data.response.ReviewResponseDTO;
import com.example.demo.domain.HealthInfo;
import com.example.demo.repository.HealthRepository;
import com.example.demo.service.HomeService;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@Slf4j
public class HomeController {
    private final HealthRepository healthRepository;
    private final HomeService homeService;
    private final ReviewService reviewService;


    //기본형태 사용안함.
    @GetMapping("/home") //url localhost:8080/home
    public String home(Model model) {
        model.addAttribute("list", healthRepository.findAll());
        return "home";

    }
    //상세페이지
    @GetMapping("/home/view")
    public String homeRead(Model model,@RequestParam Long id){
        HealthResponseDTO healthResponseDTO = homeService.healthView(id);
        model.addAttribute("healthInfo", healthResponseDTO);

        List<ReviewResponseDTO> reviews = reviewService.findReview(id);

        model.addAttribute("reviews", reviews);

        return "healthview";
    }

    @GetMapping("/home/review")
    public String reviewRead(Model model, @RequestParam Long id){
        HealthResponseDTO dto = homeService.healthView(id);
        List<ReviewResponseDTO> reviews = dto.getReviews();
        // 리뷰
        if(reviews != null && !reviews.isEmpty()){
            model.addAttribute("reviews", reviews);
        }

        return "review";
    }
    // 저장 페이지.
    @GetMapping("/save")
    public String writeView(){
        return "save";
    }

    //저장 기능 구현.
    @PostMapping("/home/save")
    // requestDTO에 Setter를 열어서 form데이터 바인딩.
    public String homeSave(HealthRequestDTO healthRequestDTO){
        homeService.saveHealth(healthRequestDTO);

        return "redirect:/page"; //prg패턴.
    }

    //삭제기능.
    @GetMapping("/home/delete")
    public String healthDelete(@RequestParam Long id){
        homeService.healthDelete(id);
        return "redirect:/page";
    }

    //상세 페이지 내 수정페이지 보여주기
    @GetMapping("/home/modified")
    public String modifiedView(@RequestParam Long id, Model model) {
        model.addAttribute(HealthResponseDTO
                .toEntity(homeService.healthView(id)));
        return "modified";
    }


    //상세 페이지 내 수정 기능
    @PostMapping("/home/modified/update")
    public String homeModified(HealthRequestDTO healthRequestDTO) {
            homeService.updateHealth(healthRequestDTO);
        return "redirect:/page";
    }

    @GetMapping("/page")
    public String pageHome(Model model, Pageable pageable) {

        Page<HealthInfo> healthInfoPage = homeService.healthList(pageable);
        model.addAttribute("pages",healthInfoPage);
        model.addAttribute("maxPage",5);

        return "page";
    }

}
