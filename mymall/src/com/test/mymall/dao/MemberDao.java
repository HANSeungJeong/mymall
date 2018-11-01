package com.test.mymall.dao;

import java.sql.*;
import javax.naming.*;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;


public class MemberDao {
	//회원 탈퇴
	public void deleteMember(int no) {
		
	}
	
	public Member login(String id, String pw) {
		System.out.println("MemberDao login");
		Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	Member member = null;
    	 try {
         	conn=DBHelper.getConnection();
     		stmt=conn.prepareStatement("SELECT id, pw, level FROM mall.member WHERE id = ? AND pw = ?");
     		stmt.setString(1, id);
     		stmt.setString(2, pw);
     		rs=stmt.executeQuery();
     		if(rs.next()) {
     			member=new Member();
     			member.setId(rs.getString("id"));
     			member.setPw(rs.getString("pw"));
     			member.setLevel(rs.getInt("level"));
     		}
         } catch(Exception e) {
         	e.printStackTrace();
         } finally {
         	DBHelper.close(rs, stmt, conn);	
         }
 		return member;
	}
	//회원가입처리
    public void insertMember(Member member) {
    	System.out.println("MemberDao insertMember");
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    } try {
    	conn = DBHelper.getConnection();
    	stmt=conn.prepareStatement("INSERT INTO mall.member(id, pw, level) VALUES (?, ?, ?)");
    	stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		stmt.setInt(3, member.getLevel());
		stmt.executeUpdate();
    } catch(Exception e) {
    	e.printStackTrace();
    } finally {
    	DBHelper.close(rs, stmt, conn);
    }
    
}
