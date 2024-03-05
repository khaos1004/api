package com.isys.api.common.login.repository;

import com.isys.api.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
    Boolean existsByName(String name);

    Optional<UserInfoEntity> findByName(String name);
}
