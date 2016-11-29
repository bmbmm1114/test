package com.mydomain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.mydomain.model.service.HealthService;

@Controller
@RequestMapping("/member/")
public class HealthController {
	@Autowired
	private HealthService service; //주입을 받아야 한다.
	
	/*@RequestMapping("findById")
	@ResponseBody //
	
		@ResponseBody : Handler 메소드 선언부에 추가하는 Annotation
		-Handler 메소드가 return 하는 값을 바로 HTTP 응답 body 에 넣어서 응답하도록 처리(View 를 찾니 않는다.)
		-Return 해주는 값을 HTTP 응답 메세지에 맞게 변환해서 출력한다. -> HttpMessageConverter 사용.
		-리턴값의 종류에 따라 다양한 HttpMessageConverter 가 제공됨.
		
		응답메세지로 바꿔주는 아이.
		-JSON 문자열 응답시
			-MappingJackson2HttpMessageConverter 사용.
			-<mvc:annotation-driven/> 선언시 자동으로 등록됨. 단 classpath 상에 Jackson API 가 있는 경우.
			return : VO -> {}
					List/배열 -> []
	
	//이것을 바꿀때 사용하는 API 가 존재하지 않는다 즉 String 은 제공하는데 JSON 은 바꿔주지 않는다.
	//JSONOBject 역할을 하는 역할을 등록 Jackson 사용 --> 메세지 컨버터를 등록해준다. 
	public Member findById(String id) //요청파라미터 조회.
	{
		System.out.println("ID 는 " + id);
		//Business Logic - MemberService.getMemberById(id) 호출
		Member member = service.getMemberById(id);
		System.out.println(member);
		return member;
	} 
	
	@RequestMapping("getList")
	@ResponseBody
	public List getList()
	{
		List list = service.getMemberList();
		System.out.println(list);
		return list;
	}*/
	
	
}










