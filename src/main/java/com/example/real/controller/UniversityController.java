package com.example.real.controller;

import com.example.real.constants.PathConstant;
import com.example.real.entity.University;
import com.example.real.service.UniversityService;
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
@CrossOrigin("*")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @PostMapping(PathConstant.ADD_UNIVERSITY)
    public University saveUniversity(@RequestBody University university) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return universityService.saveUniversity(university);
    }

    @GetMapping(PathConstant.GET_ALL_UNIVERSITY)
    public List<University> fetchUniversity() {
        return universityService.fetchUniversity();
    }

    @GetMapping(PathConstant.GET_UNIVERSITY_BY_ID)
    public University fetchById(@PathVariable("id") Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return universityService.fetchById(fetchId);
    }

    @PostMapping(PathConstant.TRANS_UNIVERSITY)
    public String insert(@RequestBody University universe) {
        return universityService.insert(universe);
    }
}
