package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PostMapping("/domain")
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach((map) -> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberV2(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping("/member3")
    public ResponseEntity<MemberDto> postMemberV3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
