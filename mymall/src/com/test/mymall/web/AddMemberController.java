package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;


@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	//1. 라우터 역활.
	//2. 모델이 생성되도록 호출.
	//3. view rendering.
	private MemberDao memberDao;
	
	//회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/addMember/jsp").forward(request,response);
	}
	//회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		request.setCharacterEncoding("utf-8");
	}

}
