package com.example.demo.data.response;

import com.example.demo.data.request.HealthRequestDTO;
import com.example.demo.domain.HealthInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@ToString
public class HealthResponseDTO {

    private Long id;
    private String brand_name;
    private String land_number;
    private String road_number;
    private String category;
    private List<ReviewResponseDTO> reviews; //엔티티간 무한참조 방지.

    public void HealthResponseDTO(HealthInfo healthInfo){
        this.id = healthInfo.getId();
        this.brand_name = healthInfo.getBrand_name();
        this.category = healthInfo.getCategory();
        this.land_number = healthInfo.getLand_number();
        this.road_number = healthInfo.getRoad_number();
        this.reviews = healthInfo.getReviews().stream().map(ReviewResponseDTO::new).collect(Collectors.toList());

    }

    public static HealthInfo toEntity(HealthResponseDTO healthResponseDTO){
        return HealthInfo.builder()
                .id(healthResponseDTO.getId())
                .brand_name(healthResponseDTO.getBrand_name())
                .category(healthResponseDTO.getCategory())
                .land_number(healthResponseDTO.getLand_number())
                .road_number(healthResponseDTO.getRoad_number())
                .build();
    }

}
