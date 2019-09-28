package com.example.test.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //���������� �����ϴ� bean
@Aspect //�������� ������ �����ϴ� bean
public class LogAdvice {
	
	//�α��� ���� ����
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//@Before, @After, @Around ����Ҷ� ����Ʈ�� ���������.
	@Around(//����Ʈ��. ����ǥ�������� �ۼ�. 
			"execution(* com.example.test.controller..*Controller.*(..))"
			+" or execution(* com.example.test.model.dao..*DAOImpl.*(..))"
			+" or execution(* com.example.test.service..*ServiceImpl.*(..))"
			)
	public Object logPrint(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		
		
		Object result = pjp.proceed(); //�ٽɾ����� �����ض�.. //Before�� After �϶��� �� ���� �ʿ����. pjpŬ���� ���� jpŬ���� �����
		
		String type = pjp.getSignature().getDeclaringTypeName(); //Ŭ���� �̸� ������.
		String name="";
		
		if(type.indexOf("Controller")>-1) {
			name="Controller \t";
		}else if(type.indexOf("Service")>-1) {
			name="ServiceImpl \t";
		}else if(type.indexOf("DAO")>-1) {
			name="DAOImple \t";
		}
				
		
		logger.info(name + type + "." + pjp.getSignature().getName()); //�޼��� �̸� ������.
		logger.info(Arrays.toString(pjp.getArgs())); // �޼��忡 �Ѿ�� �Ķ���� �� ������
		
		long end = System.currentTimeMillis();
		long time = end - start;
		
		logger.info("����ð� : "+time);
		
		return result;
		
	}
}
 