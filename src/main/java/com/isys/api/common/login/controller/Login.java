package com.isys.api.common.login.controller;

import com.isys.api.common.login.dto.LoginRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Login {

//    @PostMapping("/login")
//    public ResponseEntity<?> login (@RequestBody LoginRequestDto loginRequestDto){
//           return ResponseEntity.ok(200);
//    }

    @GetMapping("/login")
    public ResponseEntity<?> loginSuccess(Principal principal) {
        // Principal 객체에서 로그인한 사용자의 정보를 가져올 수 있습니다.
        String username = principal.getName();
        // 여기서 사용자 정보를 조회하고 반환하는 로직을 구현할 수 있습니다.
        // 예: 사용자 이름, 역할, 기타 정보 등

        // 사용자 정보를 JSON 형태로 반환
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", username);
        // 기타 필요한 정보 추가
        return ResponseEntity.ok(userInfo);
    }
}
