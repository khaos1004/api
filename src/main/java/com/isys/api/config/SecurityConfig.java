//package com.isys.api.config;
//
//import com.isys.api.common.login.filter.JwtAuthenticationFilter;
//import com.isys.api.common.login.filter.JwtTokenProvider;
//import com.isys.api.common.login.filter.LoginFilter;
//import com.isys.api.common.login.jwt.JwtUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    //AuthenticationManager가 인자로 받을 AuthenticationConfiguraion 객체 생성자 주입
//    private final AuthenticationConfiguration authenticationConfiguration;
//    private final JwtUtil jwtUtil;
//    private final JwtTokenProvider jwtTokenProvider;
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public CorsConfigurationSource apiConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.setAllowedOrigins(Arrays.asList("*")); // 허용할 Origin 설정
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST")); // 허용할 HTTP 메소드 설정
//        configuration.setAllowedHeaders(Arrays.asList("*")); // 허용할 헤더 설정
//        configuration.setAllowCredentials(true); // Credential 허용 설정
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration); // 모든 경로에 대해 적용
//        return source;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        //csrf disable
//        http
//                .csrf((auth) -> auth.disable())
//                .cors((cors) -> cors.configurationSource(apiConfigurationSource()))
//
//                //From 로그인 방식 disable
//                .formLogin((auth) -> auth.disable())
//
//                //http basic 인증 방식 disable
//                .httpBasic((auth) -> auth.disable())
//
//                //경로별 인가 작업
//                .authorizeHttpRequests((auth) -> auth
//                        .requestMatchers("/api/login", "/api/join").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
//                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil), UsernamePasswordAuthenticationFilter.class)
//                //세션 설정
//                .sessionManagement((session) -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();
//    }
//}
