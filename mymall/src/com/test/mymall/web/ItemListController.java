package com.test.mymall.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Item;


@WebServlet("/ItemListController")
public class ItemListController extends HttpServlet {
	private ItemService itemService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemListController doGet");
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		this.itemService=new ItemService();
		List<Item> list=this.itemService.selectItemList(map);
		request.setAttribute("itemList", list);
		request.setAttribute("paging", map);
		request.getRequestDispatcher("/WEB-INF/view/itemList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
