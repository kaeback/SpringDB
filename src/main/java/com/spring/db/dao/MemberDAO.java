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
	
	
	public ArrayList<Member> selectMemberList() {
		ArrayList<Member> memberList = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		memberList = mapper.selectMemberList();
		
		return memberList;
	}
	
	
	public int insertMember(Member member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		result = mapper.insertMember(member);
		
		return result;
	}
	
	public Member selectMemberById(String id) {
		Member member = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		mapper.selectMemberById(id);
		
		return member;
	}
	
}
