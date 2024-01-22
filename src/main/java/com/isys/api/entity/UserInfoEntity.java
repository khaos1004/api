package com.isys.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "user_info")
public class UserInfoEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "USERGROUP_FK", columnDefinition = "DECIMAL")
    private UserGroupEntity userGroupEntity;

    @Column(name = "OFFICENUM", columnDefinition = "DECIMAL")
    private int officeNum;

    @Column(name = "PASSWORD")
    private String passWord;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CENTEROFFICE_MRFK", columnDefinition = "DECIMAL")
    private int genterOfficeMrFx;

    @Column(name = "WORKCLASSTYPE_FK", columnDefinition = "DECIMAL")
    private int workClassTypeFk;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
