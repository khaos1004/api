package com.isys.api.common.login.repository;

import com.isys.api.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
    Boolean existsByName(String username);

    //username을 받아 DB 테이블에서 회원을 조회하는 메소드 작성
    UserInfoEntity findByName(String username);
}
