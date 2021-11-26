package com.spring.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.db.service.MemberService;
import com.spring.db.vo.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping(value = "joinMember", method = RequestMethod.POST)
	public String joinMember(Member member) {
		logger.debug("member : {}", member);
		
		service.inserMember(member);
		
		return "redirect:/";
		
	}
}
