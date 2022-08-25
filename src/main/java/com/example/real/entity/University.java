package com.example.real.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "nation")
    private String nation;
}
