package com.example.real.service.Impl;

import com.example.real.DTO.ResultDto;
import com.example.real.Exceptions.CustomException;
import com.example.real.config.RSA;
import com.example.real.entity.Results;
import com.example.real.repository.ResultsRepository;
import com.example.real.repository.StudentRepository;
import com.example.real.service.ResultsService;
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
public class ResultsLog implements ResultsService {
    @Autowired
    ResultsRepository resultsRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    RSA rsa;
    @Override
    public Results saveCollege(ResultDto resultDto) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeySpecException, IOException, InvalidKeyException, CustomException {
        resultDto.setChecked(rsa.encrypt(resultDto.getChecked()));
        Results results = Results.builder()
                .published(resultDto.getPublished())
                .checked(resultDto.getChecked())
                .marks(resultDto.getMarks())
                .percentage(resultDto.getPercentage())
                .outcome(resultDto.getOutcome())
                .student(studentRepository.findByName(resultDto.getStudentName()))
                .build();

        return resultsRepository.save(results);
    }

    @Override
    public List<Results> fetchResults() {
        return resultsRepository.findAll();
    }

    @Override
    public Results fetchById(Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException {
      Results result= resultsRepository.findById(fetchId).get();
        result.setChecked(rsa.decrypt(result.getChecked()));
        return result;
    }
}
