package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController에서  MemberService.removeMember()호출
	public void removeMember(int no) {
		SqlSession sqlSession;
		try {
			sqlSession = DBHelper.getsqlSession();
			sqlSession.setAutoCommit(false);	//자동 commit 되지 않는다.
			//1 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			//2 function
			memberDao = new MemberDao();
			memberDao.deleteMember(conn, no);
			conn.commit();
		} catch(Exception e) {
				try {
					sqlSession.rollback();
				} catch(SQLException e1){
					e1.printStackTrace();
				} 
			e.printStackTrace();
		} finally {
			sqlSession.close(null, null, conn);
		}
	}
	//로그인 처리 서비스
	public Member login(Member member) {
		System.out.println("MemberService.login");
		Connection conn = null;
		Member resultMember = null;
		try {
			conn=DBHelper.getConnection();
			this.memberDao = new MemberDao();
			resultMember = this.memberDao.login(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
	} finally {
		DBHelper.close(null, null, conn);
	}
		return resultMember;
	}
	//회원가입 입력처리 서비스
	public void addMember(Member member) {
		System.out.println("MemberService addMember");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			this.memberDao = new MemberDao();
			this.memberDao.insertMember(null, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
	}
}
