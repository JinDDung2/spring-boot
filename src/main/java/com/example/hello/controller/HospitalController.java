package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.domain.dto.HospitalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/hospital")
public class HospitalController {

    private final HospitalDao hospitalDao;

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable int id) {
        Hospital findHospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(findHospital);

        if( !opt.isEmpty() ) {
            return ResponseEntity.ok().body(findHospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
    }
}
