package com.test.mymall.commons;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.sql.ResultSet;

public class DBHelper {
	public static SqlSession getsqlSession() throws Exception{
		InputStream inputStream = null; 
		  try {
		   String resource = "mybatis-config.xml";
		   inputStream = Resources.getResourceAsStream(resource);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  
		  SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream); 
		  SqlSession sqlSession = sqlSessionFactory.openSession();
		  
		  return sqlSession;
		 }
	}

