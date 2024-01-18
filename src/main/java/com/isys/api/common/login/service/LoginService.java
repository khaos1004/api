package com.isys.api.common.login.service;

import com.isys.api.common.login.CustomUserDetails;
import com.isys.api.common.login.repository.LoginRepository;
import com.isys.api.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        //DB에서 조회
        UserInfoEntity userData = loginRepository.findByName(name);

        if (userData != null) {

            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
