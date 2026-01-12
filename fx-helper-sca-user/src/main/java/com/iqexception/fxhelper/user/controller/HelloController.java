package com.iqexception.fxhelper.user.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Tags(value = {@Tag(name = "Hello")})
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
