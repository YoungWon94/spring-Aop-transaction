package com.example.test.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //스프링에서 관리하는 bean
@Aspect //공통적인 업무를 지원하는 bean
public class LogAdvice {
	
	//로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//@Before, @After, @Around 사용할때 포인트컷 적어줘야함. Before, After, Around 자체는 조인 포인트임.
	@Around(//포인트컷. 정규표현식으로 작성. 
			"execution(* com.example.test.controller..*Controller.*(..))"
			+" or execution(* com.example.test.model.dao..*DAOImpl.*(..))"
			+" or execution(* com.example.test.service..*ServiceImpl.*(..))"
			)
	public Object logPrint(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		
		
		Object result = pjp.proceed(); //핵심업무를 실행해라.. //Before나 After 일때는 이 문장 필요없음. pjp클래스 말고 jp클래스 쓰면됨
		
		String type = pjp.getSignature().getDeclaringTypeName(); //클래스 이름 가져옴.
		String name="";
		
		if(type.indexOf("Controller")>-1) {
			name="Controller \t";
		}else if(type.indexOf("Service")>-1) {
			name="ServiceImpl \t";
		}else if(type.indexOf("DAO")>-1) {
			name="DAOImple \t";
		}
				
		
		logger.info(name + type + "." + pjp.getSignature().getName()); //메서드 이름 가져옴.
		logger.info(Arrays.toString(pjp.getArgs())); // 메서드에 넘어가는 파라미터 값 가져옴
		
		long end = System.currentTimeMillis();
		long time = end - start;
		
		logger.info("실행시간 : "+time);
		
		return result;
		
	}
}