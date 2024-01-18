package com.isys.api.common.login.repository;

import com.isys.api.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserInfoEntity, Integer> {

    Boolean existsByName(String username);

    UserInfoEntity findByName(String name);
}
