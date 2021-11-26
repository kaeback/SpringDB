package com.spring.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.dao.MemberDAO;
import com.spring.db.vo.Member;

@Service
public class MemberService {
	
	@Autowired MemberDAO dao;
	
	public boolean idDuplicateCheck(String id) {
		boolean result = false;
		
		Member member = dao.selectMemberById(id);
		if (member == null) result = true;
		
		return result;
	}
	
	public boolean inserMember(Member member) {
		boolean result = false;
		
		int cnt = dao.insertMember(member);
		
		if (cnt > 0) result = true;
		
		return result;
	}
}
