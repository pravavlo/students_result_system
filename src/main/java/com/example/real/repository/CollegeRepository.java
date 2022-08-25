package com.example.real.repository;

import com.example.real.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Long> {
    College findByName(String college);
}
