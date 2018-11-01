package com.test.mymall.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberItemDao {
	public void deleteMemberItem(Connection conn, int no) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("");
	}
	
	//Member INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNO) {
		Connection conn;
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql ="";
		/*
		 * select mi.no, mi.order_date, mi.item_no, i.name, i.price
			from member_item mi inner join item
			on mi.item_no = i.no
			where mi.member_no = ?
		 
		while(rs.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("itemPrice", rs.getInt("i.price"));
			list.add(map);
		}
		*/
		return list;
	}
}
