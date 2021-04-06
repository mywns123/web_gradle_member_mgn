package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dao.impl.MemberService;
import web_gradle_member_mgn.dto.Member;

@WebServlet("/memberDelList")
public class MemberDelList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
   
    public MemberDelList() {
    	service = new MemberService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("id");
		
		Member m = new Member(id);
		
		service.DeleteMember(m);
		
		request.getRequestDispatcher("memberList").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
