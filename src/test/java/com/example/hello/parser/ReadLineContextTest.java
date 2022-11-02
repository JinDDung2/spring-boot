package com.example.hello.parser;

import com.example.hello.dao.HospitalDao;
import com.example.hello.domain.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReadLineContextTest {
    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;
    @Autowired
    HospitalDao hospitalDao;

    @Test
    // 20분 걸림 (10만개조금넘개 넣는데 이렇게오래걸림)
    void saveData() throws IOException {
        hospitalDao.deleteAll();
        String filename = "/Users/jinhyuck/Downloads/fulldata_01_01_02_P_의원.csv";
        List<Hospital> hospitals = hospitalReadLineContext.readByLine(filename);
        for (Hospital hospital : hospitals) {
            hospitalDao.save(hospital);
        }
        assertEquals(hospitals.size(), hospitalDao.getCount());
    }
}