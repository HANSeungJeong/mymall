package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DBHelper {
	public static Connection getConnection() throws Exception{
		Connection conn=null;
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf8", "root", "java0000");
		return conn;
	}
	//객체 종료를 위한 공통메서드
	public static void close(ResultSet rs ,Statement stmt, Connection conn) {
		if(rs != null) {
			try {rs.close();} catch(Exception exception) {exception.printStackTrace();}
		}
		if(stmt != null) {
			try {stmt.close();} catch(Exception exception) {exception.printStackTrace();}
		}
		if(conn != null) {
			try {conn.close();} catch(Exception exception) {exception.printStackTrace();}
		}
	}
	
}
