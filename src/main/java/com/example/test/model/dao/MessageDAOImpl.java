package com.example.test.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.test.model.dto.MessageDTO;


@Repository("messageDao2") //스프링 컨테이너가 관리하는 (DAO)빈으로 등록
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(MessageDTO dto) {
		sqlSession.insert("message.create",dto);
		
	}

	@Override
	public MessageDTO readMessage(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(int mid) {
		// TODO Auto-generated method stub

	}

}
