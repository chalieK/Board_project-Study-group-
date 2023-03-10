package com.example.demo.service;

import com.example.demo.data.request.HealthRequestDTO;
import com.example.demo.data.response.HealthResponseDTO;
import com.example.demo.domain.HealthInfo;
import com.example.demo.repository.HealthRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
public interface HealthService {

    public HealthResponseDTO read(Long id);

    public boolean saveHealth(HealthRequestDTO healthRequestDTO);

    public boolean updateHealth(HealthRequestDTO healthRequestDTO);

    public boolean deleteHealth(Long id);

    Page<HealthInfo> healthList(Pageable pageable);
}

