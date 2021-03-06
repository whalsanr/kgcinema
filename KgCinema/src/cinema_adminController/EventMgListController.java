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



@WebServlet("/eventmglist.do")
public class EventMgListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
		  int start, end ;  
		  int pagecount;  
		  int pageNUM ;   
		  int startpage, endpage; 
		  String pnum;  
		  int temp; 
		  int num; 
		  
		
		  String sqry; 
		  String skey, sval; 
		  String returnpage;
		  String AA="", BB="";
		  
		  skey="e_title";
		  sval=request.getParameter("keyword");
		  if(sval=="" || sval==null) {
			   
			  skey="e_title"; sval="";
		  }
		  
	//	  if(skey.equals("name")) {
	//		  AA=skey;
		  if(skey.equals("e_title")){
			  BB=skey;
		  }
		  returnpage="&keyfield="+skey+"&keyword="+sval ; 
		  
		  pnum=request.getParameter("pageNum");
		  if(pnum==null || pnum=="") {
			  pnum="1";
		  }
		  pageNUM=Integer.parseInt(pnum);	
		  
		 
		  start=(pageNUM-1)*8+1; //start
		  end=pageNUM*8; //end
		  
		 
		  DBDAO dao = new DBDAO();
		  int Gtotal = dao.eventCount();
		  int Stotal=dao.eventCountSearch(skey, sval);
		  if(Stotal%10==0){ pagecount=Stotal/10; 
		  }else { 
				pagecount=(Stotal/10)+1; 
		  }
		  
		  
		  temp=(pageNUM-1)%10;
		  startpage=pageNUM-temp;
		  endpage=startpage+9;
		  if(endpage>pagecount) {
			  endpage=pagecount;
		  }
		  
		  
		  ArrayList<DBbean> edb2 = dao.eventSelect(start, end, skey, sval); 
		  request.setAttribute("edb2", edb2);
		  
		  request.setAttribute("startpage", startpage);
		  request.setAttribute("endpage", endpage);
		  request.setAttribute("pageNUM", pageNUM);	
		  request.setAttribute("pagecount", pagecount); 
		  request.setAttribute("Gtotal", Gtotal);
		  request.setAttribute("Stotal", Stotal);
		  request.setAttribute("returnpage", returnpage);
		  request.setAttribute("AA", AA);
		  request.setAttribute("BB", BB);
		  request.setAttribute("sval", sval);
		 
	//	  request.setAttribute("num", num);
		  RequestDispatcher dis = request.getRequestDispatcher("eventManagement.jsp");
		  dis.forward(request, response);
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response);
	}

}
