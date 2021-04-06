package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_gradle_member_mgn.dao.impl.MemberService;
import web_gradle_member_mgn.dto.Member;

@WebServlet("/joinProcess")
public class JoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id= request.getParameter("id");
		String password= request.getParameter("password");
		String name= request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender= request.getParameter("gender");
		String email= request.getParameter("email");
		
		Member member= new Member(id, password, name, age, gender, email);
//		System.out.println("member :"+member);
		service.InsertMember(member);
		
		HttpSession session = request.getSession();
		Member mem =(Member)session.getAttribute("mem");
		String s =mem.getId();
		System.out.println("s :"+s);
//		if(mem.getId().equals("admin")) {
////		response.sendRedirect("memberList");
//			request.getRequestDispatcher("memberList").forward(request, response);
//		}
//		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		request.getRequestDispatcher("admin/main.jsp").forward(request, response);
////		response.sendRedirect("main.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
