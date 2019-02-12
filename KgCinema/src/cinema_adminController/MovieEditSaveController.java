package cinema_adminController;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import cinema_common.MovieDAO;
import cinema_common.Moviebean;


@WebServlet("/movieEditSave.do")
public class MovieEditSaveController extends HttpServlet {
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
        PrintWriter out=response.getWriter();
         
         
         int a=Integer.parseInt(mr.getParameter("ed_nno"));      
         String b=mr.getParameter("ed_title");
         String c=mr.getParameter("ed_subtitle");
         String d=mr.getParameter("ed_grade");
         String e=mr.getParameter("ed_type");
         String f=mr.getParameter("ed_premiere");
         String g=mr.getParameter("ed_director");
         String h=mr.getParameter("ed_actor");
         String i=mr.getParameter("ed_genre");
         String j=mr.getParameter("ed_story");
         // 이미지 비교용 (수정이미지)
         String k=mr.getFilesystemName("ed_poster");
         String k2=mr.getParameter("ed_poster2");
         String l=mr.getFilesystemName("ed_steal1");
         String l2=mr.getParameter("ed_steal11");
         String m=mr.getFilesystemName("ed_steal2");
         String m2=mr.getParameter("ed_steal22");
         String n=mr.getFilesystemName("ed_steal3");
         String n2=mr.getParameter("ed_steal33");
         String o=mr.getFilesystemName("ed_steal4");
         String o2=mr.getParameter("ed_steal44");
         String p=mr.getFilesystemName("ed_steal5");
         String p2=mr.getParameter("ed_steal55");
         
         
         if(k == null || k =="") {
            k = k2;
         }
         if(l == null || l =="") {
            l = l2;
         }
         if(m == null || m =="") {
            m = m2;
         }
         if(n == null || n =="") {
            n = n2;
         }
         if(o == null || o =="") {
            o = o2;
         }
         if(p == null || p =="") {
            p = p2;
         }
         
         System.out.println(a);
         System.out.println(b);
         System.out.println(c);
         System.out.println(d);
         System.out.println(e);
         System.out.println(f);
         System.out.println(g);
         System.out.println(h);
         System.out.println(i);
         System.out.println(j);
         System.out.println(k);
         System.out.println(k2);
         System.out.println(l);
         System.out.println(m);
         System.out.println(n);
         System.out.println(o);
         System.out.println(p);
         
         // 이미지 비교용(수정전 이미지)
            
         Moviebean mbean=new Moviebean();
         MovieDAO  mdao=new MovieDAO();
         //   bean.setNno(a);
            mbean.setTitle(b);
            mbean.setSubtitle(c);
            mbean.setGrade(Integer.parseInt(d));
            mbean.setType(e);
            java.util.Date ff = null;
            try {
            ff = sdf.parse(f);
         } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
            mbean.setPremiere(ff);
            mbean.setDirector(g);
            mbean.setActor(h);
            mbean.setGenre(i);
            mbean.setStory(j);
            mbean.setPoster(k);
            mbean.setSteal1(l);
            mbean.setSteal2(m);
            mbean.setSteal3(n);
            mbean.setSteal4(o);
            mbean.setSteal5(p);
            mbean.setPoster2(k2);
            mbean.setSteal12(l);
            mbean.setSteal22(m);
            mbean.setSteal32(n);
            mbean.setSteal42(o);
            mbean.setSteal52(p);
   
         mdao.movieEditSave(mbean, a);
         response.sendRedirect("moviemglist.do?idx="+a); 
      
      }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request, response);
   }

   
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doUser(request, response);
   }

}