package com.test.mymall.service;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController에서  MemberService.removeMember()호출
	public void removeMember(int no) {
		Connection conn = null;
		try {
		conn = DBHelper.getConnection();
		conn.setAutoCommit(false);	//자동 commit 되지 않는다.
		//1 function
		memberDao = new MemberDao();
		memberDao.deleteMember(no);
		//2 function
		memberItemDao = new MemberItemDao();
		memberItemDao.deleteMemberItem(no);
		conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1){
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		}
	}
	
	public void addMember(Member member) {
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
