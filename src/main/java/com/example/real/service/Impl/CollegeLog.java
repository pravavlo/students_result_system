package com.example.real.service.Impl;

import com.example.real.DTO.CollegeDto;
import com.example.real.entity.College;
import com.example.real.entity.University;
import com.example.real.repository.CollegeRepository;
import com.example.real.repository.UniversityRepository;
import com.example.real.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Service
public class CollegeLog implements CollegeService {
    @Autowired
    CollegeRepository collegeRepository;
    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public College saveCollege(CollegeDto collegeDto){
        University university = universityRepository.findByName(collegeDto.getUniversityName());
        College college = College.builder()
                .name(collegeDto.getName())
                .department(collegeDto.getDepartment())
                .location(collegeDto.getLocation())
                .university(university)
                .build();
        return collegeRepository.save(college);
    }


    @Override
    public List<College> fetchCollege() {
        return collegeRepository.findAll();
    }

    @Override
    public College fetchById(Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return collegeRepository.findById(fetchId).get();
    }
}
