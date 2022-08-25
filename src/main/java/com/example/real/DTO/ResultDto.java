package com.example.real.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDto {
    private float  percentage;
    private Boolean published;
    private Boolean outcome;
    private Integer marks;
    private String checked;
    private String studentName;
}
