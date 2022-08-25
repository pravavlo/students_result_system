package com.example.real.service.Impl;

import com.example.real.DTO.Dto;
import com.example.real.entity.Results;
import com.example.real.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class serviceDTO {
    @Autowired
    private ResultsRepository resultsRepository;
    public List<Dto> getAllInfo(){
        return resultsRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
    private Dto convertEntityToDto(Results some){
        Dto dto = new Dto();
        dto.setIdresult(some.getIdresult());
        dto.setPercentage(some.getPercentage());
        dto.setMarks(some.getMarks());
        dto.setName(some.getStudent().getName());
        dto.setDob(some.getStudent().getDob());
        return dto;
    }
}
