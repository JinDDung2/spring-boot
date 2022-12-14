package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
@Slf4j
public class PostController {

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
        log.info("postMemberV2 요청을 했습니다. name:{}, email:{}, organization:{}",
                memberDto.getName(), memberDto.getEmail(), memberDto.getOrganization());
        return memberDto.toString();
    }
}
