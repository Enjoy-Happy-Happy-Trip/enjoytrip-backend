package com.ssafy.edu.tour;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.edu.model.ITourService;
import com.ssafy.edu.model.TourServiceImpl;

@WebServlet("/tour")
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ITourService tservice;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String root = request.getContextPath();
		
		tservice = TourServiceImpl.getInstance();
		
		String action = request.getParameter("action");
		
		
	}
}
