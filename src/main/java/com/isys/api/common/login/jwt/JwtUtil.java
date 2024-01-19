//package com.isys.api.common.login.jwt;
//
//import io.jsonwebtoken.Jwts;
//import jakarta.persistence.Column;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//
//
///**
// * jwt access token, refresh token create class
// */
//@Component
//public class JwtUtil {
//    private SecretKey secretKey;
//
//
//    /**
//     * application.properties 에 설정된 jwt key 값을 가져와서 일시적 사용자 키 생성
//     * @param secret
//     */
//    public JwtUtil(@Value("${spring.jwt.secret}")String secret) {
//        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
//    }
//
//    public String getUsername(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("username", String.class);
//    }
//
//    /**
//     * 추후 개발 예정, 인가 기능
//     * @param token
//     * @return
//     */
//    public String getRole(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role", String.class);
//    }
//
//    /**
//     * 추후 개발 예정, 토큰 만료 체크
//     * @param token
//     * @return
//     */
//    public Boolean isExpired(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
//    }
//
//    public String createJwt(String name, String password, Long expiredMs) {
//
//        return Jwts.builder()
//                .claim("name", name)
//                .claim("password", password)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + expiredMs))
//                .signWith(secretKey)
//                .compact();
//    }
//}
