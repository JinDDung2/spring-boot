package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hospital")
public class HospitalController {

    private final HospitalDao hospitalDao;

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable int id) {
        try {
            Hospital findHospital = hospitalDao.findById(id);
            return ResponseEntity.ok()
                    .body(findHospital);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
