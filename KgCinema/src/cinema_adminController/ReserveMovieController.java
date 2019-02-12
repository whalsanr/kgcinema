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
import cinema_common.ScheduleDAO;
import cinema_common.Schedulebean;
import cinema_common.TheaterDAO;
import cinema_common.Theaterbean;
import cinema_common.UserDAO;
import cinema_common.Userbean;


@WebServlet("/reserveMovie.do")
public class ReserveMovieController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<h1>ReserveMovieController.java컨트롤 문서<h1>");
      
      String theater = request.getParameter("theater");
      
      
      MovieDAO dao = new MovieDAO();
      
      String movieNo = request.getParameter("no");

      Moviebean mbean = new Moviebean();
      
      if(movieNo == null || movieNo.equals("")) {
    	  
      } else {
    	  int no = Integer.parseInt(movieNo);
          mbean = dao.MovieDetail(no);
          
          request.setAttribute("mbean", mbean);
      }
      
      String date = request.getParameter("date");
      
      if(mbean.getTitle() == null) {
    	  mbean.setTitle("");
      }
      
      
      ScheduleDAO sDao = new ScheduleDAO();
      ArrayList<Schedulebean> scheduleList = sDao.scheduleSelect(date, theater, mbean.getTitle());
      System.out.println(date + "..." + theater + "...." + mbean.getTitle());
      
      
      
      ArrayList<Moviebean> movieList = dao.movieSelect();
      
      TheaterDAO tDao = new TheaterDAO();
      ArrayList<Theaterbean> theaterList = tDao.theaterSelect();
      
      request.setAttribute("tbean", theater);
      request.setAttribute("theater", theaterList);
      request.setAttribute("movie", movieList);
      request.setAttribute("date", date);
      request.setAttribute("schedule", scheduleList);
      
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