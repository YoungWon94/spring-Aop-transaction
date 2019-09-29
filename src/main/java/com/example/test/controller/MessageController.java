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
 * @RestController : 스프링 4.0부터 사용 가능
 * 
 * @RequestBody: 클라이언트 -> 서버로 json 데이터가 입력될 때
 * @ResponseBody: 서버에서 -> 클라이언트로 json 데이터를 가져올 때
 * 
 * ResponseEntitiy 클래스 : Http Status Code(http 상태코드) + 데이터 한번에 다 가져옴
 * 
 * 
 * REST uri
REST : REpresentational State Transfer
-> 하나의 uri가 하나의 고유한 리소스를 대표하도록 설계된 개념
REST 방식이 아닌 파라미터로 표시되는 uri 주소는 한개이지만 파라미터의 값에 따라 페이지가 바뀐다... http://localhost:8080/spring02/reply/list?bno=1 http://localhost:8080/spring02/reply/list?bno=2 http://localhost:8080/spring02/reply/list?bno=3
REST 방식의 uri 한개의 주소가 하나의 리소스(페이지)를 대표하도록(가지도록) 한다. http://localhost:8080/spring02/reply/list/1 http://localhost:8080/spring02/reply/list/2 http://localhost:8080/spring02/reply/list/3
ResponseEntity : 컨트롤러를 호출하여 데이터와 http 상태 코드를 동시에 리턴 가능하게 함
컨트롤러에 json data를 전달하는 테스트를 위해 크롬에 확장 프로그램 설치 http://gogle.com 에서 Advanced REST client 검색 입력데이터를 json으로 보내기 위해 사용 put : 전체 수정 delete : 삭제 patch : 일부분 수정
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
