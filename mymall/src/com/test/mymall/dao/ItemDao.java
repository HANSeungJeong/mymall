package com.test.mymall.dao;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.Member;

public class ItemDao {
	//로그인 실패시 -> null
	//로그인 성공시 -> 성공한 Member객체
	
	//상품리스트 처리
	public List<Item> selectItemList(SqlSession sqlSession, HashMap<String, Object>map) throws SQLException{
		System.out.println("ItemDao selectItemList");
		return sqlSession.selectList("com.test.mymall.dao.ItemMapper.selectItemList", map);		
	}
	
	//상품 총 갯수
	public int selectItemListCount(SqlSession sqlSession) {
		System.out.println("ItemDao selectItemListCount");
	
		return sqlSession.selectOne("com.test.mymall.dao.ItemMapper.selectItemCount");
		
	}
	
}
