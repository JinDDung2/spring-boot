package com.example.hello.controller;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import com.example.hello.domain.dto.HospitalResponseDto;
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
    public ResponseEntity<HospitalResponseDto> findById(@PathVariable int id) {
        HospitalResponseDto dto = new HospitalResponseDto();
        return ResponseEntity.ok(
                dto.from(hospitalDao.findById(id)));
    }
}
