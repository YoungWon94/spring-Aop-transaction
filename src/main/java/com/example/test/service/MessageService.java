package com.example.test.service;

import com.example.test.model.dto.MessageDTO;

public interface MessageService {
	public void addMessage(MessageDTO dto); //�޼����� �߰��� ���� ó��
	public MessageDTO readMessage(String userid, int mid); //�޼����� ���� ���� ó��
}
