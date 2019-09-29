package com.example.test;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String name="chmp1408";
	private static final String password="1408";
	
	@Test
	public void oracle() throws Exception{
		Class.forName(driver);
		
		try(Connection conn = DriverManager.getConnection(url, name, password)) {
			logger.info("oracle연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("oracle연결 실패");
			e.printStackTrace();
		}
	}

}
