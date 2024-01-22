package com.isys.api.common.login.temp;

import com.isys.api.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private LoginRepository loginRepository;

    public String auth(LoginRequestDTO loginRequestDTO){
        UserInfoEntity findUser = loginRepository.findByName(loginRequestDTO.getName());
        if (findUser != null){

        }
            return "";
    }
}
