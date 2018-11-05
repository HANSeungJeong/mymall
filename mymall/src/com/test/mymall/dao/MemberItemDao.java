package com.test.mymall.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.MemberItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberItemDao {
	public void deleteMemberItem(SqlSession sqlSession, int no){
	}
	//주문리스트처리
	//Member INNER JOIN item
	public List<HashMap<String, Object>> selectMemberList(SqlSession sqlSession, int MemberNo){
		System.out.println("MemberItemDao selectMemberList");
		return sqlSession.selectList("com.test.mymall.dao.MemberItemMapper.selectMemberList");
		
	}
	//주문 갯수
	public int selectMemberItemListCount(SqlSession sqlSession, int MemberNo) {
		System.out.println("MemberItemDao selectMemberItemListCount");
		return sqlSession.selectOne("com.test.mymall.dao.MemberItemMapper.selectMemberItemListCount", MemberNo);
		
	}
	//주문처리
	public void insertMemberItem(SqlSession sqlSession, MemberItem memberitem){
		System.out.println("MemberItemDao insertMemberItem");
		sqlSession.insert("com.test.mymall.dao.MemberItemMapper.insertMemberItem", memberitem);
	}
}