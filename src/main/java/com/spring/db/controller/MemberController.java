package com.spring.db.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.db.service.MemberService;
import com.spring.db.vo.Member;

@Controller
@RequestMapping("/member")
@SessionAttributes("login_data")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService service;
	
	/**
	 * 회원가입 폼 이동
	 * @return 
	 */
	@RequestMapping(value = "joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	
	/**
	 * 회원가입 처리
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "joinMember", method = RequestMethod.POST)
	public String joinMember(Member member) {
		logger.debug("member : {}", member);
		
		service.inserMember(member);
		
		return "redirect:/";
		
	}
	
	/**
	 * 로그인 폼 이동
	 * @return
	 */
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	/**
	 * 회윈정보 수정 폼 이동
	 * @return
	 */
	@RequestMapping(value = "updateMemberForm", method = RequestMethod.GET)
	public String updateMemberForm() {
		return "member/updateMemberForm";
	}
}
