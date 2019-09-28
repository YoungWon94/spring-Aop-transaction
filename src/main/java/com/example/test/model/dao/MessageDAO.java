package com.example.test.model.dao;

import com.example.test.model.dto.MessageDTO;

public interface MessageDAO {
	
	public void create(MessageDTO dto); //메세지 보내기
	public MessageDTO readMessage(int mid);//메세지 읽기
	public void updateState(int mid); //상태변경
}
