package com.example.real.DTO;

import com.example.real.entity.College;
import com.example.real.entity.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private String name;
//    @DateTimeFormat
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dob;

    private String email;

    private String password;

    private Gender gender;

    private String collegeName;
}
