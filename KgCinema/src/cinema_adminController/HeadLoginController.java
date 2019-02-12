package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cinema_common.UserDAO;
import cinema_common.Userbean;

@WebServlet("/headlogin.do")
public class HeadLoginController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	response.setContentType("text/html;charset=UTF-8"); 
	PrintWriter out=response.getWriter();
	//////////////////////////////////////////////////////
	
	HttpSession session = request.getSession();
	
	if(session.getAttribute("temp") == null ) { // 원래 == 인데 세션설정안했기에 !=으로 설정함

	     response.sendRedirect("index.jsp");

	} else {

		String data = request.getParameter("userid");
		System.out.println("넘어온 data : " + data);
	    UserDAO dao=new UserDAO();
	    Userbean bean=dao.userMypage(data);
	    request.setAttribute("bean", bean);
	    
	    //RequestDispatcher dis=request.getRequestDispatcher("guestDetail.jsp");
		//dis.forward(request, response);
	    RequestDispatcher dis=request.getRequestDispatcher("headLogin.jsp");
	  	dis.forward(request, response);

	}
	
	
  }//doUser end
  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end
}//DetailController class END