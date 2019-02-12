package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import cinema_common.DBDAO;
import cinema_common.DBbean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/eventInsert.do")
public class EventInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String path=request.getSession().getServletContext().getRealPath("./storage");
	      System.out.println("경로path: " + path);
	      int size=1024*1024*7;
	      
	      DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
	      MultipartRequest mr = new MultipartRequest(request,path,size,"UTF-8");
	      
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
	
		  String b=mr.getParameter("etitle");
		  String c=mr.getParameter("eperiod");
		  String d=mr.getFilesystemName("econtent");
		  String e=mr.getFilesystemName("efile");
		  System.out.println(b+" "+c+" "+d+" "+e);
		  
		  DBbean bean = new DBbean();
		  DBDAO dao = new DBDAO();
		  	
		  	bean.setEtitle(b);
		  	bean.setEperiod(c);
		  	bean.setEcontent(d);
		  	bean.setEfile(e);
		  	
		  dao.eventInsert(bean);
		  response.sendRedirect("eventlist.do"); 
		  
		 
		
		}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response);
	}

}
