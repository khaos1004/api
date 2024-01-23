package com.isys.api;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class ApiApplicationTests {

	// QueryDsl
	@Autowired EntityManager em;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Querydsl 테스트")
	public void startQuerydsl() {
//		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//		QUserInfo userInfo = QUserInfo.userInfo;
//
//		UserInfo findMember = (UserInfo) queryFactory
//				.select(userInfo)
//				.from(userInfo)
//				.where(userInfo.name.eq("Keri"))
//				.fetch();
//
//		System.out.println(findMember);
	}


	}
