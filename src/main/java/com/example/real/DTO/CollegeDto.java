package com.example.real.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollegeDto {

    @NotEmpty(message = "college name cant be empty")
    private String name;
    private String location;
    private String department;
    private String universityName;
}
