package com.example.real.service.Impl;

import com.example.real.DTO.StudentDto;
import com.example.real.Exceptions.CustomException;
import com.example.real.config.AEsEncryptDecrypt;
import com.example.real.entity.Student;
import com.example.real.repository.CollegeRepository;
import com.example.real.repository.StudentRepository;
import com.example.real.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentLog implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private AEsEncryptDecrypt aes;
    @Autowired
    CollegeRepository collegeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Student savestudent(StudentDto studentDto) throws  CustomException {
        studentDto.setEmail(aes.encrypt("AES/CBC/PKCS5Padding",studentDto.getEmail()));

        Student student = Student.builder()
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .password(passwordEncoder.encode(studentDto.getPassword()))
                .dob(studentDto.getDob())
                .gender(studentDto.getGender())
                .college(collegeRepository.findByName(studentDto.getCollegeName()))
                .build();
        return studentRepository.save(student);
    }



    @Override
    public List<StudentDto> fetchCollege()  {
        List<Student> student =studentRepository.findAll();
        return  student.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    private StudentDto entityToDto(Student student){
        return StudentDto.builder()
                .name(student.getName())
                .email(student.getEmail())
                .password(student.getPassword())
                .dob(student.getDob())
                .gender(student.getGender())
                .collegeName(student.getCollege().getName())
                .build();
    }

    @Override
    public Student fetchById(Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException, CustomException {
        Student student = studentRepository.findById(fetchId).get();
        student.setEmail(aes.decrypt("AES/CBC/PKCS5Padding",student.getEmail()));
        return student;
    }
}
