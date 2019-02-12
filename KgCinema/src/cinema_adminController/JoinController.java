package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema_common.UserDAO;
import cinema_common.Userbean;


@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>JoinController.java컨트롤 문서<h1>");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String juso1 = request.getParameter("juso1");
		String juso2 = request.getParameter("juso2");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String num3 = request.getParameter("num3");
		String email = request.getParameter("email");
		System.out.println(id + name + pwd + juso1 + year + month + num1 + email);
		
		Userbean bean = new Userbean();
		UserDAO dao = new UserDAO();
			bean.setId(id);
			bean.setName(name);
			bean.setPwd(pwd);
			bean.setJuso1(juso1);
			bean.setJuso2(juso2);
			bean.setBirth(year + "-" + month + "-" + day);
			bean.setPhone(num1 + "-" + num2 + "-" + num3);
			bean.setEmail(email);
		dao.userJoin(bean);
		
		//response.sendRedirect("guestList.jsp"); // 제목만 출력 //에러
		response.sendRedirect("index.jsp"); // ListController.java실행

	} // end

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doUser(request, response); // 꼭꼭꼭기술
	} // end

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response); // 꼭꼭꼭기술
	} // end

} // JoinController class END
