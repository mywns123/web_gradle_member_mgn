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
		service.InsertMember(member);
		
		HttpSession session = request.getSession();
		String mem =(String)session.getAttribute("id");
//		System.out.println("mem :"+mem);		

		if(mem=="admin") {
			request.getRequestDispatcher("memberList").forward(request, response);
		}else {
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
