package com.isys.api.common.login.repository;

import com.isys.api.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
    Optional<UserInfoEntity> findByName(String name);

    Boolean existsByName(String username);


}
