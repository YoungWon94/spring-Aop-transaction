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




//JUnit Test Case�� �ϱ� ���ؼ� ���� Ŭ����
//JUnit 4 �������� �׽�Ʈ

//@RunWith : JUnit �����ӿ�ũ �׽�Ʈ ���� ����� Ȯ���� �� ����ϴ� ������̼�
//SpringJUnit4ClassRunner��� JUnit�� �׽�Ʈ ���ؽ�Ʈ �����ӿ�ũ Ȯ�� Ŭ������ �������ָ�
//JUnit�� �׽�Ʈ�� �����ϴ� �߿�
//�׽�Ʈ�� ����� ���ø����̼� ���ؽ�Ʈ�� ������ְ� �����ϴ� �۾��� �������ش�.


//@ContextConfiguration�� �ڵ����� ������� ���ø����̼� ���ؽ�Ʈ�� �������� ��ġ�� ������ ���̴�.
//�������� JUnit Ȯ������ �׽�Ʈ�� ����Ǳ� ���� �� �ѹ��� ���ø����̼� ���ؽ�Ʈ�� ������ְ�,
//�׽�Ʈ ������Ʈ�� ������� ������
//Ư���� ����� �̿��� ���ø����̼� ���ؽ�Ʈ �ڽ��� �׽�Ʈ ������Ʈ�� Ư�� �ʵ忡 ������ �ִ� ���̴�.



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
	
	//�α��� ���� ����
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
			logger.info("mybatis���� ����");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
