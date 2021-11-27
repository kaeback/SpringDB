package com.spring.db.dao;

import java.util.ArrayList;

import com.spring.db.vo.Member;

public interface MemberMapper {
	// 전체 회원정보 검색
	public ArrayList<Member> selectMemberList();
	// 회원가입 처리
	public int insertMember(Member member);
	// ID로 회원정보 검색
	public Member selectMemberById(String id);
	// 로그인 처리를 위한 회원정보 검색
	public Member selectMember(Member member);
}
