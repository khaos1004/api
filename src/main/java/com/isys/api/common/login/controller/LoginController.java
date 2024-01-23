package com.isys.api.common.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/test/api")
    public String test(){
        return "Success";
    }
}
