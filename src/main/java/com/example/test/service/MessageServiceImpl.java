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
		
		//�α�Ȯ��(�������) -> aop ����...
		
		//�ٽɾ���
		messageDao.create(dto); //�޼����� ���̺� ����
		System.out.println("�޼����� ���̺� �μ�Ʈ �Ͽ���");
		pointDao.updatePoint(dto.getSender(), 10); //�޼����� �߼��� ȸ������ 10����Ʈ �߰�

	}

	@Override
	public MessageDTO readMessage(String userid, int mid) {
		
		return null;
	}

}
