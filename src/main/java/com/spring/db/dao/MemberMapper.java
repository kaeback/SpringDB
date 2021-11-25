package com.spring.db.dao;

import java.util.ArrayList;

import com.spring.db.vo.Member;

public interface MemberMapper {
	public ArrayList<Member> selectMemberList();
	public int insertMember(Member member);
	public int insertMemberDetail(Member member);
	public Member selectMemberById(String id);
}
