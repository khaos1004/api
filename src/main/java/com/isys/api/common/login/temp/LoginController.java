package com.isys.api.common.login.temp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class LoginController {

    private LoginService loginService;

    @GetMapping("/login")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public EntityResponse<?> Login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        String name = loginRequestDTO.getName();
        String password = loginRequestDTO.getPassword();
        LoginRequestDTO result = loginService.auth(name, password)
        return
    }
}
