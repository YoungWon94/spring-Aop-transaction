package com.example.test.model.dao;

import com.example.test.model.dto.MessageDTO;

public interface MessageDAO {
	
	public void create(MessageDTO dto); //�޼��� ������
	public MessageDTO readMessage(int mid);//�޼��� �б�
	public void updateState(int mid); //���º���
}
