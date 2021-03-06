package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;


@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	//1. 라우터 역활.
	//2. 모델이 생성되도록 호출.
	//3. view rendering.
	private MemberService memberService;
	
	//회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/addMember/jsp").forward(request,response);
	}
	//회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String level = request.getParameter("level");
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(Integer.parseInt(level));
		this.memberService = new MemberService();
		this.memberService.addMember(member);
		response.sendRedirect(request.getContextPath()+"/LoginController");
		
	}

}
