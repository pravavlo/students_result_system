package com.example.real.repository;

import com.example.real.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Long> {
    University findByName(String universityName);
}
