package com.ssafy.edu.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.edu.model.IMemberService;
import com.ssafy.edu.model.MemberServiceImpl;
import com.ssafy.edu.model.MembersDto;

@WebServlet("/member")
public class MembersServlet extends HttpServlet {

	IMemberService mservice;

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
		mservice = MemberServiceImpl.getInstance();
		
		String path = "";
		String root = request.getContextPath();
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("registry")) {
			path = root + "/member/registry.jsp";
			response.sendRedirect(path);
		} else if (action.equalsIgnoreCase("registryaf")) {
			path = "message.jsp";
			
			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			String email_id = request.getParameter("email_id");
			String email_domain = request.getParameter("email_domain");
			String student_no = request.getParameter("student_no");
			int flag = 0;
			
			boolean isS = mservice.registry(new MembersDto(user_id, user_name, user_password, email_id, email_domain, student_no, flag));
			
			if (isS) { 
				path = root + "/member/signin.jsp";
			} else {
				path = root + "/member/registry.jsp";
			}

			response.sendRedirect(path);
		} else if (action.equalsIgnoreCase("home")) { 
			response.sendRedirect(root + "/index.jsp");
		} else if (action.equalsIgnoreCase("loginaf")) { 
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");			
			MembersDto login = mservice.login(new MembersDto(user_id, user_password));
			
			HttpSession session = request.getSession();
			
			if (login != null) { // 5
				session.setAttribute("login", login);
				response.sendRedirect(root + "/member?action=home");
			} else {
				session.invalidate();
				request.setAttribute("mti", "다시 로그인하기");
				request.setAttribute("msg", "로그인에 실패했습니다.");
				request.setAttribute("url", root + "/member/signin.jsp");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}

		} else if (action.equalsIgnoreCase("signout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(root + "/member?action=home");
		} else if (action.equalsIgnoreCase("signin")) { 
			response.sendRedirect(root + "/member/signin.jsp");
		} else if(action.equalsIgnoreCase("findpassword")) {
			path="message.jsp";
			
			String student_no = request.getParameter("student_no");
			String password = mservice.findpassword(student_no);
			HttpSession session = request.getSession();
						
			request.setAttribute("mti", "로그인 페이지로 이동");
			request.setAttribute("msg", "회원님의 비밀번호는 "+password+"입니다.");
			request.setAttribute("url", root+"/member/signin.jsp");

			RequestDispatcher dispatcher=request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("memberlist")) {
			request.setAttribute("members", mservice.memberlist());
			RequestDispatcher dispatcher = request.getRequestDispatcher("./member/adminpage.jsp");
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("detail")) {
			String user_id = request.getParameter("user_id");			
			request.setAttribute("member", mservice.memberDetail(user_id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("./member/memberupdate.jsp");
			dispatcher.forward(request, response);
		} else if (action.equalsIgnoreCase("delete")) {
			String user_name = request.getParameter("user_name");			
			mservice.memberDelete(user_name);
			response.sendRedirect(root + "/member?action=memberlist");
		} else if (action.equalsIgnoreCase("updateGo")) {
			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");
			String email_id = request.getParameter("user_id");
			String email_domain = request.getParameter("email_domain");
			String join_date = request.getParameter("join_date");
			String student_no = request.getParameter("student_no");

			mservice.memberUpdate(new MembersDto(user_id, user_name, user_password, 
					email_id, email_domain, join_date, student_no));

			response.sendRedirect(root + "/member?action=memberlist");
		}
	}
}
