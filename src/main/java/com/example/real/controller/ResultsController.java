package com.example.real.controller;

import com.example.real.DTO.Dto;
import com.example.real.DTO.ResultDto;
import com.example.real.Exceptions.CustomException;
import com.example.real.constants.PathConstant;
import com.example.real.entity.Results;
import com.example.real.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
public class ResultsController {
    @Autowired
    private ResultsService resultsService;
    @Autowired
    private com.example.real.service.Impl.serviceDTO serviceDTO;
    @GetMapping("/dto")
    public List<Dto> getAllUsersLocation(){
        return serviceDTO.getAllInfo();
    }

    @PostMapping(PathConstant.ADD_RESULT)
    public Results saveResults(@RequestBody ResultDto results) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException {
        return resultsService.saveCollege(results);
    }

    @GetMapping(PathConstant.GET_ALL_RESULT)
    public List<Results> fetchResults() {
        return resultsService.fetchResults();
    }

    @GetMapping(PathConstant.GET_RESULT_BY_ID)
    public Results fetchById(@PathVariable("id") Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException {
        return resultsService.fetchById(fetchId);
    }
}
