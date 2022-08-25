package com.example.real.controller;

import com.example.real.DTO.CollegeDto;
import com.example.real.constants.PathConstant;
import com.example.real.entity.College;
import com.example.real.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping(PathConstant.ADD_COLLEGE)
    public College saveCollege(@Valid @RequestBody CollegeDto college) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return collegeService.saveCollege(college);
    }

    @GetMapping(PathConstant.GET_ALL_COLLEGE)
    @RolesAllowed({ "ROLE_VIEW", "ROLE_ADMIN" })
    public List<College> fetchCollege() {
        return collegeService.fetchCollege();
    }

    @GetMapping(PathConstant.GET_COLLEGE_BY_ID)
    public College fetchById(@PathVariable("id") Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return collegeService.fetchById(fetchId);
    }
}
