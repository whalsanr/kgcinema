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


@WebServlet("/noticeEdit.do")
public class NoticeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out=response.getWriter();
			
			
			int a=Integer.parseInt(request.getParameter("e_nno"));
			
			String b=request.getParameter("e_nloc");
			String c=request.getParameter("e_ntitle");
			String d=request.getParameter("e_ncontent");
			System.out.println(a+"/"+b+"/"+c+"/"+d);
				
			DBbean bean=new DBbean();
			DBDAO  dao=new DBDAO();
			//	bean.setNno(a);
				bean.setNloc(b);
				bean.setNtitle(c);
				bean.setNcontent(d);
	
			dao.noticeEdit(bean, a);
			response.sendRedirect("noticemglist.do?idx="+a); 
		
		}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response);
	}

}
