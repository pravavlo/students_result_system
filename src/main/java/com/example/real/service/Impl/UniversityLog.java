package com.example.real.service.Impl;

import com.example.real.entity.University;
import com.example.real.repository.UniversityRepository;
import com.example.real.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Service
public class UniversityLog implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;
    @Override

    public University saveUniversity(University university) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return universityRepository.save(university);
    }

    @Override
    @Transactional
    public List<University> fetchUniversity() {
        return universityRepository.findAll();
    }

    @Override
    public University fetchById(Long fetchId) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidKeySpecException, IOException {
        return universityRepository.findById(fetchId).get();
    }

    @Override
    @Transactional
    public String insert(University universe) {
        University safe = universityRepository.save(universe);
        if (safe.getID() == 3) {
            int a = 1 / 0;
            System.out.println("The value of A is : " + a);
        }
        return "inserted successfully";
    }
}
