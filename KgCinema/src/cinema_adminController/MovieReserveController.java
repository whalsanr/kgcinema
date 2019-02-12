package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cinema_common.MovieDAO;
import cinema_common.Moviebean;
import cinema_common.TheaterDAO;
import cinema_common.Theaterbean;
import cinema_common.UserDAO;
import cinema_common.Userbean;


@WebServlet("/reserve.do")
public class MovieReserveController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<h1>ReserveController.java컨트롤 문서<h1>");

      MovieDAO dao = new MovieDAO();
      ArrayList<Moviebean> movieList = dao.movieSelect();
      
      TheaterDAO tDao = new TheaterDAO();
      ArrayList<Theaterbean> theaterList = tDao.theaterSelect();
      
      Calendar cal = Calendar.getInstance();
      String year = String.valueOf(cal.get(Calendar.YEAR));
      String month = String.valueOf(cal.get(Calendar.MONTH)+1);
      String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
      
      if(Integer.parseInt(month) <10) {
    	  month = "0" + month;
      } else if(Integer.parseInt(day) < 10) {
    	  day = "0" + day;
      }
      
      String today = year + "-" + month + "-" + day;
      
      request.setAttribute("date", today);
      request.setAttribute("theater", theaterList);
      request.setAttribute("movie", movieList);
      
      // LG, count 지역변수데이터를 view문서로 넘겨요
      // 페이지영역 데이터전송 request활용, guestList.jsp문서 호출을 포워딩
      RequestDispatcher dis = request.getRequestDispatcher("movieReserve.jsp");
      dis.forward(request, response);

   } // end

   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      doUser(request, response); // 꼭꼭꼭기술
   } // end

   
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      doUser(request, response); // 꼭꼭꼭기술
   } // end

} // ReserveController class END