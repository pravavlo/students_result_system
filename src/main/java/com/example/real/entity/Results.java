package com.example.real.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "results")
@Entity
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresult")
    private long idresult;
    @Column(name = "percentage")
    private float  percentage;
    @Column(name = "published", columnDefinition = "BIT(1) default 1")
    private Boolean published;
    @Column(name = "outcome")
    private Boolean outcome;
    @Column(name = "marks")
    private Integer marks;
    @Column(name = "checked")
    private String checked;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name ="fk_student", referencedColumnName = "id")
    private Student student;

}
