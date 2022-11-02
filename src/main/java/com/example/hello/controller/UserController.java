package com.example.hello.controller;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.User;
import com.example.hello.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi")
@Slf4j
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    // 기본값 환영으로 받아주기
    @GetMapping("/")
    public String welcome() {
        log.info("welcome 호출합니다.");
        return "Welcome our pages";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            User user = this.userDao.findById(id);
            return ResponseEntity.ok()
                    .body(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Integer> add(@RequestBody UserDto userDto) {
        User user = new User(userDto.getId(), userDto.getName(), userDto.getPassword(), userDto.getEmail());
        return ResponseEntity
                .ok()
                .body(userDao.save(user));
    }

    @PostMapping("/user")
    public User addAndGet() {
        userDao.save(new User("0", "Heo", "Jin", "hyuck@naver.com"));
        log.info("addAndGet 호출합니다.");
        return userDao.findById("0");
    }

    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(userDao.deleteById(id));
    }
}
