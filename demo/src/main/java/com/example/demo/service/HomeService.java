package com.example.demo.service;

import com.example.demo.data.request.HealthRequestDTO;
import com.example.demo.data.response.HealthResponseDTO;
import com.example.demo.domain.HealthInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HomeService {

        public boolean saveHealth(HealthRequestDTO healthRequestDTO);
        public List<HealthInfo> HealthList();
        public HealthResponseDTO healthView(Long id) ;
        public boolean updateHealth(HealthRequestDTO healthRequestDTO);

        public boolean healthDelete(Long id);
        Page<HealthInfo> healthList(Pageable pageable);
}

