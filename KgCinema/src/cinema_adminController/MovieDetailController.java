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

import cinema_common.MovieDAO;
import cinema_common.Moviebean;
import cinema_common.UserDAO;
import cinema_common.Userbean;	


@WebServlet("/moviedetail.do")
public class MovieDetailController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<h1>IndexController.java컨트롤 문서<h1>");
      
      HttpSession session = request.getSession();
      
      if(session.getAttribute("temp") == null) {
    	  
    	  
         
      } else {
         UserDAO dao = new UserDAO();
         Userbean bean = dao.userMypage((String)session.getAttribute("temp"));
         request.setAttribute("bean", bean);
      }

      
      
      
      int data=Integer.parseInt(request.getParameter("idx"));
      System.out.println(data);
      MovieDAO dao = new MovieDAO();
      Moviebean bean=dao.MovieDetail(data);
      
      request.setAttribute("movie", bean);
      
      // LG, count 지역변수데이터를 view문서로 넘겨요
      // 페이지영역 데이터전송 request활용, guestList.jsp문서 호출을 포워딩
      RequestDispatcher dis = request.getRequestDispatcher("movieDetail.jsp");
      dis.forward(request, response);

   } // end

   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      doUser(request, response); // 꼭꼭꼭기술
   } // end

   
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      doUser(request, response); // 꼭꼭꼭기술
   } // end

} // JoinController class END