package web_gradle_member_mgn.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dao.impl.MemberService;
import web_gradle_member_mgn.dto.Member;

@WebServlet("/memberUpdateList")
public class MemberUpdateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();

    public MemberUpdateList() {
    	service = new MemberService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String name= request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender= request.getParameter("gender");
		String email= request.getParameter("email");
		
		Member m = new Member(id,name,age,gender,email);
		
		service.UPdateMember(m);
		
		request.getRequestDispatcher("memberList").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
