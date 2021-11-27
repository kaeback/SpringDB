package com.spring.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.db.vo.*;
import java.util.*;

@Repository
@EnableTransactionManagement
public class MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 전체 회원정보 검색
	 * @return
	 */
	public ArrayList<Member> selectMemberList() {
		ArrayList<Member> memberList = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		memberList = mapper.selectMemberList();
		
		return memberList;
	}
	
	/**
	 * 회원가입 처리
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		result = mapper.insertMember(member);
		
		return result;
	}
	
	/**
	 * 아이디로 회원정보 검색
	 * @param id
	 * @return
	 */
	public Member selectMemberById(String id) {
		Member member = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		member = mapper.selectMemberById(id);
		
		return member;
	}
	
	
	public Member selectMember(Member member) {
		Member member_info = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		member_info = mapper.selectMember(member);
		
		return member_info;
	}
}
