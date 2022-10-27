package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @RequestMapping(name = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName() {
        return "Jinhyuck Heo";
    }

    @GetMapping("/variable1/{variable}")
    public String getVariableV1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariableV2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping("/request1")
    public String getVariableV3(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return String.format("name: %s, email: %s, organization: %s", name, email, organization);
    }

    @GetMapping("/request2")
    public String getVariableV5(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map) -> {
            System.out.printf("key: %s, value: %s\n",map.getKey(), map.getValue());
        });
        return "request2 호출";
    }

    @GetMapping("/request3")
    public String getRequestParam(MemberDto memberDto) {
            return memberDto.toString();
        }

}


