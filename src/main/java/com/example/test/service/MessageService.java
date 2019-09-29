package com.example.test.service;

import com.example.test.model.dto.MessageDTO;

public interface MessageService {
	public void addMessage(MessageDTO dto);  //메세지를 추가할 때의 처리
	public MessageDTO readMessage(String userid, int mid); //메세지를 읽을 때의 처리
}
