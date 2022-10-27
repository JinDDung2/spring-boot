package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

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

}


