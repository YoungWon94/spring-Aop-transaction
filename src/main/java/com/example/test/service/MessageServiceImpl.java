package com.example.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.model.dao.MessageDAO;
import com.example.test.model.dao.PointDAO;
import com.example.test.model.dto.MessageDTO;


@Service("messageService2")
public class MessageServiceImpl implements MessageService {

	@Resource(name="messageDao2")
	MessageDAO messageDao;
	
	@Resource(name="pointDao2")
	PointDAO pointDao;
	
	@Transactional
	@Override
	public void addMessage(MessageDTO dto) {
		
		//로그확인(공통업무) -> aop 적용...
		
		//핵심업무
		messageDao.create(dto); //메세지를 테이블에 저장
		System.out.println("메세지를 테이블에 인서트 하였음");
		pointDao.updatePoint(dto.getSender(), 10); //메세지를 발송한 회원에게 10포인트 추가

	}

	@Override
	public MessageDTO readMessage(String userid, int mid) {
		
		return null;
	}

}
