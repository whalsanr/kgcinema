package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cinema_common.UserDAO;


@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	response.setContentType("text/html;charset=UTF-8"); 
	PrintWriter out=response.getWriter();

	out.println("<h1>LoginAjaxController.java컨트롤문서</h1> <br>");
	String uid = request.getParameter("userid");
    String upwd = request.getParameter("userpw");
    System.out.println(uid);
    System.out.println(upwd);

    HttpSession session = request.getSession();

    session.invalidate();
    response.sendRedirect("index.do");
	
  }//doUser end
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end
}//LoginController class END



