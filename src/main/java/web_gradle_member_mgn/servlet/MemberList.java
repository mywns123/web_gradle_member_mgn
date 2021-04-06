package web_gradle_member_mgn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dao.impl.MemberService;
import web_gradle_member_mgn.dto.Member;

@WebServlet("/memberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();	
	
	public MemberList() {
		service = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> list= service.showMember();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/member_List.jsp").forward(request, response);
//		response.sendRedirect("member_List.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
