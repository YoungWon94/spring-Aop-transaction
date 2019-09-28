package com.example.test.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.test.model.dto.MessageDTO;
import com.example.test.service.MessageService;

/*
 * @Controller
 * @RestController : ������ 4.0���� ��� ����
 * 
 * @RequestBody: Ŭ���̾�Ʈ -> ������ json �����Ͱ� �Էµ� ��
 * @ResponseBody: �������� -> Ŭ���̾�Ʈ�� json �����͸� ������ ��
 * 
 * ResponseEntitiy Ŭ���� : Http Status Code(http �����ڵ�) + ������ �ѹ��� �� ������
 * 
 * 
 * REST uri
REST : REpresentational State Transfer
-> �ϳ��� uri�� �ϳ��� ������ ���ҽ��� ��ǥ�ϵ��� ����� ����
REST ����� �ƴ� �Ķ���ͷ� ǥ�õǴ� uri �ּҴ� �Ѱ������� �Ķ������ ���� ���� �������� �ٲ��... http://localhost:8080/spring02/reply/list?bno=1 http://localhost:8080/spring02/reply/list?bno=2 http://localhost:8080/spring02/reply/list?bno=3
REST ����� uri �Ѱ��� �ּҰ� �ϳ��� ���ҽ�(������)�� ��ǥ�ϵ���(��������) �Ѵ�. http://localhost:8080/spring02/reply/list/1 http://localhost:8080/spring02/reply/list/2 http://localhost:8080/spring02/reply/list/3
ResponseEntity : ��Ʈ�ѷ��� ȣ���Ͽ� �����Ϳ� http ���� �ڵ带 ���ÿ� ���� �����ϰ� ��
��Ʈ�ѷ��� json data�� �����ϴ� �׽�Ʈ�� ���� ũ�ҿ� Ȯ�� ���α׷� ��ġ http://gogle.com ���� Advanced REST client �˻� �Էµ����͸� json���� ������ ���� ��� put : ��ü ���� delete : ���� patch : �Ϻκ� ����
 * 
 * 
 */
@Controller
public class MessageController {

	@Resource(name="messageService2")
	MessageService messageService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/messages/", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageDTO dto){
		ResponseEntity<String> entity = null;
		
		try {
			messageService.addMessage(dto);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
}
