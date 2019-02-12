package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema_common.MovieDAO;
import cinema_common.Moviebean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/movieInsert.do")
public class MovieInsertController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String path=request.getSession().getServletContext().getRealPath("./storage");
      System.out.println("경로path: " + path);
      int size=1024*1024*7;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
      DefaultFileRenamePolicy dfr = new DefaultFileRenamePolicy();
      MultipartRequest mr = new MultipartRequest(request,path,size,"UTF-8");
      
      
      
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String a=mr.getParameter("title");
        String b=mr.getParameter("subtitle");
        String c=mr.getParameter("grade");
        String d=mr.getParameter("type");
        String e=mr.getParameter("premiere");
        String f=mr.getParameter("director");
        String g=mr.getParameter("actor");
        String h=mr.getParameter("genre");
        String i=mr.getParameter("story");
        String j=mr.getFilesystemName("poster");
        String k=mr.getFilesystemName("steal1");
        String l=mr.getFilesystemName("steal2");
        String m=mr.getFilesystemName("steal3");
        String n=mr.getFilesystemName("steal4");
        String o=mr.getFilesystemName("steal5");
   //     System.out.println(b+" "+c+" "+d);
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("l = " + l);
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("o = " + o);
        
        Moviebean mbean = new Moviebean();
        MovieDAO mdao = new MovieDAO();
           
           mbean.setTitle(a);
           mbean.setSubtitle(b);
           mbean.setGrade(Integer.parseInt(c));
           mbean.setType(d);
           Date ee = null;
      try {
         ee = sdf.parse(e);
      } catch (ParseException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
          mbean.setPremiere(ee);
           mbean.setDirector(f);
           mbean.setActor(g);
           mbean.setGenre(h);
           mbean.setStory(i);
           mbean.setPoster(j);
           mbean.setSteal1(k);
           mbean.setSteal2(l);
           mbean.setSteal3(m);
           mbean.setSteal4(n);
           mbean.setSteal5(o);
           
        mdao.movieInsert(mbean);
        response.sendRedirect("moviemglist.do"); 
      
      }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request, response);
   }

   
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doUser(request, response);
   }

}