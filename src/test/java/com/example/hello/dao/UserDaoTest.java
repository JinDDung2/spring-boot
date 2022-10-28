package com.example.hello.dao;
import com.example.hello.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao.deleteAll();
    }

    @Test
    void saveAndFindById() {
        User user = new User("100", "chin", "1234", "homidle");
        userDao.save(user);
        User findUser = userDao.findById("100");
        assertEquals("chin", findUser.getName());
    }
}