package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema_common.DBDAO;
import cinema_common.DBbean;


@WebServlet("/noticeInsert.do")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
	
		  String b=request.getParameter("nloc");
		  String c=request.getParameter("ntitle");
		  String d=request.getParameter("ncontent");
		  
	//	  System.out.println(b+" "+c+" "+d);
		  
		  DBbean bean = new DBbean();
		  DBDAO dao = new DBDAO();
		  	
		  	bean.setNloc(b);
		  	bean.setNtitle(c);
		  	bean.setNcontent(d);
		  	
		  dao.noticeInsert(bean);
		  response.sendRedirect("noticemglist.do"); 
		
		}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response);
	}

}
