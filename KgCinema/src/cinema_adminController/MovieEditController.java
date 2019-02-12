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

import cinema_common.MovieDAO;
import cinema_common.Moviebean;




@WebServlet("/movieEdit.do")
public class MovieEditController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
   response.setContentType("text/html;charset=UTF-8"); 
   PrintWriter out=response.getWriter();
 
   //////////////////////////////////////////////////////
   int data = Integer.parseInt(request.getParameter("idx"));
    MovieDAO dao=new MovieDAO();
    Moviebean bean=dao.MovieEdit(data);
   request.setAttribute("bean", bean);
   RequestDispatcher dis=request.getRequestDispatcher("movieEdit.jsp");
   dis.forward(request, response);
  }//doUser end
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
   doUser(request,response); //꼭꼭꼭기술
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
   doUser(request,response); //꼭꼭꼭기술
  }//end
}//MovieEditController class END