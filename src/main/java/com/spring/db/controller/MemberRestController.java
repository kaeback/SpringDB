package com.spring.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.db.service.MemberService;

@RestController
public class MemberRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "idDuplicateCheck", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public boolean idDuplicateCheck(String id) {
		boolean result = false;
		
		logger.debug("id : {}", id);
		result = service.idDuplicateCheck(id); 
		logger.debug("result : {}", result);
		
		return result; 
		
	}
}
