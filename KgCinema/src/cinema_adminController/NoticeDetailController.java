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

import cinema_common.DBDAO;
import cinema_common.DBbean;


@WebServlet("/noticedetail.do")
public class NoticeDetailController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
		  int data=Integer.parseInt(request.getParameter("idx"));
		  DBDAO dao = new DBDAO();
		  DBbean bean = dao.noticeDetail(data);
		  request.setAttribute("notice", bean);
		  //RequestDispatcher dis = request.getRequestDispatcher("guestDetail.jsp");
		  //dis.forward(request, response);
		  
		  RequestDispatcher dis = request.getRequestDispatcher("noticeDetail.jsp");	//���⼭ ������ reply.do�� �ѱ��
		  dis.forward(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response);
	}

}
