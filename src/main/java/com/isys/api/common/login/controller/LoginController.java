package com.isys.api.common.login.controller;

import com.isys.api.common.login.dto.JwtToken;
import com.isys.api.common.login.dto.LoginRequest;
import com.isys.api.common.login.repository.UserInfoRepository;
import com.isys.api.common.login.service.CustomUserDetailsService;
import com.isys.api.common.login.service.UserinfoServiceImpl;
import com.isys.api.entity.UserInfoEntity;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class LoginController {
    private final UserinfoServiceImpl loginService;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserInfoRepository userInfoRepository;

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        String username = loginRequest.getId();
        String password = loginRequest.getPassword();
        Map<String, Object> obj = new HashMap<>();

        Optional<UserInfoEntity> userinfo = userInfoRepository.findByName(loginRequest.getId());

        if (userinfo.isPresent()) {
            JwtToken jwtToken = loginService.signIn(loginRequest);
            log.info("request username = {}, password = {}", username, password);
            log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());

            // create a cookie
            Cookie cookieAccessToken = new Cookie("AccessToken", jwtToken.getAccessToken());
            Cookie cookieRefreshToken = new Cookie("RefreshToken", jwtToken.getRefreshToken());

            // set cookie properties and add them to the response
            cookieAccessToken.setMaxAge(60 * 60 * 10);
            cookieRefreshToken.setMaxAge(60 * 60 * 20); // expires in 10 hours
            cookieAccessToken.setPath("/");
            cookieRefreshToken.setPath("/");
            cookieAccessToken.setHttpOnly(true);
            cookieRefreshToken.setHttpOnly(true);

            response.addCookie(cookieAccessToken);
            response.addCookie(cookieRefreshToken);

            obj.put("OK","true");
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
        obj.put("OK", "false");
        obj.put("message", "인증 실패.");
        return ResponseEntity.status(401).body(obj.toString());
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // 기존의 AccessToken 및 RefreshToken 쿠키를 찾아서 만료시킴
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("AccessToken") || cookie.getName().equals("RefreshToken")) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0); // 쿠키를 즉시 만료시킴
                    response.addCookie(cookie); // 변경된 쿠키를 응답에 추가
                }
            }
        }
        return ResponseEntity.ok("로그아웃 성공");
    }
    @PostMapping("/test")
    public String test() {
        return "success";
    }

}

