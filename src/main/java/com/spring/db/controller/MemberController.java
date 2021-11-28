package com.spring.db.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.db.service.MemberService;
import com.spring.db.vo.Member;

@Controller
@RequestMapping("/member")
@SessionAttributes("login_info")
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
		return "member/joinMemberForm";
	}
	
	/**
	 * 회원가입 처리
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "joinMember", method = RequestMethod.POST)
	public String joinMember(Member member) {
		logger.debug("member : {}", member);
		
		service.insertMember(member);
		
		return "redirect:/";
		
	}
	
	/**
	 * 로그인 폼 이동
	 * @return
	 */
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginMemberForm";
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
	
	/**
	 * 회윈정보 수정 폼 이동
	 * @return
	 */
	@RequestMapping(value = "updateMemberForm", method = RequestMethod.GET)
	public String updateMemberForm(@ModelAttribute("login_info") HashMap<String, String> login_info, Model model) {
		logger.debug("login_data : {}", login_info);
		
		Member member = service.selectMemberById(login_info.get("id"));
		
		model.addAttribute("member", member);
		
		return "member/updateMemberForm";
	}
	
	@RequestMapping(value = "updateMember", method = RequestMethod.POST)
	public String updateMember(@ModelAttribute("login_info") HashMap<String, String> login_info, Member member, Model model) {
		member.setId(login_info.get("id"));
		logger.debug("updateMember : {}", member);
		
		service.updateMember(member);
		
		// 세션에 저장된 login_info 업데이트
		Member member_info = service.selectMemberById(login_info.get("id"));
		login_info.put("name", member_info.getName());
		model.addAttribute("login_info", login_info);
		
		return "redirect:/";
	}
}
