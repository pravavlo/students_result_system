package com.example.real.controller;

import com.example.real.DTO.StudentDto;
import com.example.real.Exceptions.CustomException;
import com.example.real.constants.PathConstant;
import com.example.real.entity.Student;
import com.example.real.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(PathConstant.ADD_STUDENT)
    public Student savestudent(@RequestBody StudentDto student) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException {
        return studentService.savestudent(student);
    }
@GetMapping(PathConstant.GET_ALL_STUDENT)
    public ResponseEntity<List<StudentDto>> fetchCollege() {
        return new ResponseEntity<>(studentService.fetchCollege(), HttpStatus.ACCEPTED);
    }
@GetMapping(PathConstant.GET_STUDENT_BY_ID)
    public Student fetchById(@PathVariable("id") Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException {
        return studentService.fetchById(fetchId);
    }
}
