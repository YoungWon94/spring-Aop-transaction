package com.example.test.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pointDao2")
public class PointDAOImpl implements PointDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void updatePoint(String userid, int point) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userid",userid);
		map.put("point",point);
		sqlSession.update("point.updatePoint",map); //두개 이상 넘겨야 할때는 맵으로

	}

}
