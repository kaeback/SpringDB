package com.spring.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.dao.MemberDAO;
import com.spring.db.vo.Member;

@Service
public class MemberService {
	
	@Autowired MemberDAO dao;
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return
	 */
	public boolean idDuplicateCheck(String id) {
		boolean result = false;
		
		Member member = dao.selectMemberById(id);
		if (member == null) result = true;
		
		return result;
	}
	
	/**
	 * 회원가입 처리
	 * @param member
	 * @return
	 */
	public boolean insertMember(Member member) {
		boolean result = false;
		
		int cnt = dao.insertMember(member);
		
		if (cnt > 0) result = true;
		
		return result;
	}

	/**
	 * 로그인 처리를 위한 회원정보 검색	
	 * @param member
	 * @return
	 */
	public Member login(Member member) {
		Member member_info = null;;
		
		member_info = dao.selectMember(member);
		
		return member_info;
	}
	
	public Member selectMemberById(String id) {
		Member member_info = null;
		
		member_info = dao.selectMemberById(id);
		
		return member_info;
	}
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @return
	 */
	public boolean updateMember(Member member) {
		boolean result = false;
		
		if (dao.updateMember(member) > 0) {
			result = true;
		}
		
		return result;
	}
}
