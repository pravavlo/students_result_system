package com.example.real.service;



import com.example.real.DTO.StudentDto;
import com.example.real.Exceptions.CustomException;
import com.example.real.entity.Student;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;


public interface StudentService {
    Student savestudent(StudentDto student) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException;
    List<StudentDto>fetchCollege();
    Student  fetchById(Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException;
}
