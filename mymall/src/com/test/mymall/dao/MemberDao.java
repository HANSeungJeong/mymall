package com.test.mymall.dao;

import java.sql.*;
import javax.naming.*;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;


public class MemberDao {

	
	// 로그인 실패시 -> null
	// 로그인 성공시 -> 성공한 Member객체
	public Member login(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao login");
    	
 		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", member);
	}
	//회원탈퇴 처리
	public void deleteMember(Connection conn, int no) {
		System.out.println("MemberDao deleteMember");
	}
	
	//회원가입처리
    public void insertMember(SqlSession sqlSession, Member member) throws SQLException {
    	System.out.println("MemberDao insertMember");
    	sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	    }
    }
