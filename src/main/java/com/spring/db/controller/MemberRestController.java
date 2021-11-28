package com.spring.db.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.db.service.MemberService;
import com.spring.db.vo.Member;

@RequestMapping("/member")
@RestController
public class MemberRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
	
	@Autowired
	MemberService service;
	
	/**
	 * 아이디 중복 확인
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "idDuplicateCheck", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public boolean idDuplicateCheck(String id) {
		boolean result = false;
		
		logger.debug("id : {}", id);
		result = service.idDuplicateCheck(id); 
		logger.debug("result : {}", result);
		
		return result; 
		
	}
	
	/**
	 * 로그인 처리
	 * @param member
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public boolean login(Member member, HttpSession session) {
		boolean result = false;
		logger.debug("id : {}, pw : {}", member);
		
		Member member_info = service.login(member);
		if (member_info != null) {
			// 세션에 담을 로그인 정보를 HashMap으로 만든다.
			HashMap<String, String> login_info = new HashMap<>();
			login_info.put("id", member_info.getId());
			login_info.put("name", member_info.getName());
			session.setAttribute("login_info", login_info);
			
			result = true;
		} 
		
		return result;
	}
	
	
	public boolean updateMember(Member member, HttpSession session) {
		boolean result = false;
		logger.debug("member : {}", member);
		return result;
	}
}
