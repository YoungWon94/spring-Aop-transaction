package com.example.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




//JUnit Test Case를 하기 위해서 만든 클래스
//JUnit 4 버전으로 테스트

//@RunWith : JUnit 프레임워크 테스트 실행 방법을 확장할 때 사용하는 어노테이션
//SpringJUnit4ClassRunner라는 JUnit용 테스트 컨텍스트 프레임워크 확장 클래스를 지정해주면
//JUnit이 테스트를 진행하는 중에
//테스트가 사용할 애플리케이션 컨텍스트를 만들어주고 관리하는 작업을 진행해준다.


//@ContextConfiguration은 자동으로 만들어줄 애플리케이션 컨텍스트의 설정파일 위치를 지정한 것이다.
//스프링의 JUnit 확장기능은 테스트가 실행되기 전에 딱 한번만 애플리케이션 컨텍스트를 만들어주고,
//테스트 오브젝트가 만들어질 때마다
//특별한 방법을 이용해 애플리케이션 컨텍스트 자신을 테스트 오브젝트의 특정 필드에 주입해 주는 것이다.



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
	
	//로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	
	@Test
	public void testFactory() {
		logger.info("sqlFactory: "+sqlFactory);
	}
	
	@Test
	public void testSession() {
		try(SqlSession sqlSession = sqlFactory.openSession()){
			logger.info("sqlSession : " + sqlSession);
			logger.info("mybatis 연결성공");
		}catch(Exception e) {
			logger.info("mybatis 연결성공");
			e.printStackTrace();
			
		}
	}
}
