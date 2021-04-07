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


@WebServlet("/loginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		id=1&pass=11111111
		
		String id= request.getParameter("id");
		String password= request.getParameter("password");
		
//		System.out.printf("id : %s, pass : %s%n", id, password);
		
		
		Member loginMember = new Member(id, password);
		Member result = service.loginMember(loginMember);
		
//		System.out.printf("loginMember : %s,%n result: %s", loginMember,result);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", result.getId());
			request.getRequestDispatcher("admin/main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
