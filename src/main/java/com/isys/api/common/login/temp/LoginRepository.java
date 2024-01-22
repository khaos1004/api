package com.isys.api.common.login.temp;

import com.isys.api.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserInfoEntity, Integer> {

    UserInfoEntity findByName(String name);
}
