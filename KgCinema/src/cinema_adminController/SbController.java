package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema_common.UserDAO;


@WebServlet("/sb.do")
public class SbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>SbController.java컨트롤 문서<h1>");
		
		String id = request.getParameter("userid");
		
		UserDAO dao = new UserDAO();
		request.setAttribute("count", dao.userSb(id));
		
		RequestDispatcher dis = request.getRequestDispatcher("openSb.jsp");
		dis.forward(request, response);

//		response.sendRedirect("openSb.jsp"); // ListController.java실행

	} // end

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doUser(request, response); // 꼭꼭꼭기술
	} // end

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response); // 꼭꼭꼭기술
	} // end

} // JoinController class END
