package com.isys.api.common.login.dto;

import com.isys.api.entity.UserInfoEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails  implements UserDetails {
    private final UserInfoEntity userInfoEntity;

    public CustomUserDetails(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                //return userGroupEntity.getRole();
                return "";
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {

        return userInfoEntity.getPassword();
    }

    @Override
    public String getUsername() {

        return userInfoEntity.getName();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
