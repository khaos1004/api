package com.isys.api.common.login.temp;

import com.isys.api.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private LoginRepository loginRepository;

    public UserInfoEntity auth(LoginRequestDTO loginRequestDTO){
        UserInfoEntity findUser = loginRepository.findByName(loginRequestDTO.getName());
        if (findUser != null){
            LoginRequestDTO result = loginRequestDTO.
        }
            return findUser;
    }
}
