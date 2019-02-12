package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cinema_common.UserDAO;
import cinema_common.Userbean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/edit.do")
public class EditController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
	  
        String path=request.getSession().getServletContext().getRealPath("./storage");
		System.out.println("경로path: " + path);
		int size=1024*1024*7;
		
		DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
		MultipartRequest mr = new MultipartRequest(request,path,size,"UTF-8");
		

	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  out.println("<h1>JoinController.java컨트롤 문서<h1>");

	  String id = mr.getParameter("id");
	  String pwd = mr.getParameter("pwd");
	  String juso1 = mr.getParameter("juso1");
	  String juso2 = mr.getParameter("juso2");
	  String year = mr.getParameter("year");
	  String month = mr.getParameter("month");
	  String day = mr.getParameter("day");
	  String num1 = mr.getParameter("num1");
	  String num2 = mr.getParameter("num2");
	  String num3 = mr.getParameter("num3");
	  String email = mr.getParameter("email");
	  String file= mr.getFilesystemName("file");
	  String file2=mr.getParameter("filename");
	  System.out.println(id + pwd + juso1 + year + month + num1 + email + file + file2);
	  
	  if(file == null) {
		  file = file2;
	  }

	  Userbean bean = new Userbean();
	  UserDAO dao = new UserDAO();
	  bean.setId(id);
	  bean.setPwd(pwd);
	  bean.setJuso1(juso1);
	  bean.setJuso2(juso2);
	  bean.setBirth(year + "-" + month + "-" + day);
	  bean.setPhone(num1 + "-" + num2 + "-" + num3);
	  bean.setEmail(email);
	  bean.setFile(file);
	  dao.userEdit(bean);

	  //response.sendRedirect("guestList.jsp"); // 제목만 출력 //에러
	  response.sendRedirect("index.do"); // ListController.java실행
	
  }//doUser end
  
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end
}//EditController class END



