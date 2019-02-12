package cinema_common;

import java.util.ArrayList;

public class MovieDAO extends GlobalVariable {
   
   public MovieDAO() {
      CN = DB.getConnection();
   } // 생성자 end
   
   public ArrayList<Moviebean> movieSelect() {
      ArrayList<Moviebean> list = new ArrayList<Moviebean>();
      try {
         msg = "select * from movie where m_premiere < sysdate order by m_premiere desc";
         ST = CN.createStatement();
         RS = ST.executeQuery(msg);
         while(RS.next()) {
            Moviebean bean = new Moviebean();
            bean.setNo(RS.getInt("m_no"));
            bean.setTitle(RS.getString("m_title"));
            bean.setSubtitle(RS.getString("m_subtitle"));
            bean.setGrade(RS.getInt("m_grade"));
            bean.setType(RS.getString("m_type"));
            bean.setPremiere(RS.getDate("m_premiere"));
            bean.setDirector(RS.getString("m_director"));
            bean.setActor(RS.getString("m_actor"));
            bean.setGenre(RS.getString("m_genre"));
            bean.setStory(RS.getString("m_story"));
            bean.setPoster(RS.getString("m_poster"));
            bean.setSteal1(RS.getString("m_steal1"));
            bean.setSteal2(RS.getString("m_steal2"));
            bean.setSteal3(RS.getString("m_steal3"));
            bean.setSteal4(RS.getString("m_steal4"));
            bean.setSteal5(RS.getString("m_steal5"));
            
            list.add(bean);
         }
      } catch (Exception e) {
         System.out.println("Error : " + e);
      }
      return list;
   } // movieSelect() end
   
   
   public ArrayList<Moviebean> nextMovieSelect() {
         ArrayList<Moviebean> list = new ArrayList<Moviebean>();
         try {
            msg = "select * from movie where m_premiere > sysdate order by m_premiere desc";
            ST = CN.createStatement();
            RS = ST.executeQuery(msg);
            while(RS.next()) {
               Moviebean bean = new Moviebean();
               bean.setNo(RS.getInt("m_no"));
               bean.setTitle(RS.getString("m_title"));
               bean.setSubtitle(RS.getString("m_subtitle"));
               bean.setGrade(RS.getInt("m_grade"));
               bean.setType(RS.getString("m_type"));
               bean.setPremiere(RS.getDate("m_premiere"));
               bean.setDirector(RS.getString("m_director"));
               bean.setActor(RS.getString("m_actor"));
               bean.setGenre(RS.getString("m_genre"));
               bean.setStory(RS.getString("m_story"));
               bean.setPoster(RS.getString("m_poster"));
               bean.setSteal1(RS.getString("m_steal1"));
               bean.setSteal2(RS.getString("m_steal2"));
               bean.setSteal3(RS.getString("m_steal3"));
               bean.setSteal4(RS.getString("m_steal4"));
               bean.setSteal5(RS.getString("m_steal5"));
               
               list.add(bean);
            }
         } catch (Exception e) {
            System.out.println("Error : " + e);
         }
         return list;
      } // movieSelect() end
   
   
   public void movieInsert(Moviebean mbean) {
        try {
          msg="insert into movie values(movie_seq.nextval, ?, ?, ?, ?, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          PST=CN.prepareStatement(msg);
            PST.setString(1, mbean.getTitle());
            PST.setString(2, mbean.getSubtitle());
            PST.setInt(3, mbean.getGrade());
            PST.setString(4, mbean.getPoint());
            PST.setString(5, mbean.getType());
            PST.setString(6, sdf.format(mbean.getPremiere()));
            PST.setString(7, mbean.getDirector());
            PST.setString(8, mbean.getActor());
            PST.setString(9, mbean.getGenre());
            PST.setString(10, mbean.getAudience());
            PST.setString(11, mbean.getStory());
            PST.setString(12, mbean.getPoster());
            PST.setString(13, mbean.getSteal1());
            PST.setString(14, mbean.getSteal2());
            PST.setString(15, mbean.getSteal3());
            PST.setString(16, mbean.getSteal4());
            PST.setString(17, mbean.getSteal5());
            
          PST.executeUpdate();
          System.out.println("movieInsert (dbbean bean) 저장성공");
        }catch(Exception ex) {
           System.out.println("Error: " + ex);
        }
      }
   
       //무비 디테일 
       public Moviebean MovieDetail(int data) {
       Moviebean bean = new Moviebean();
       try{
         msg="select * from movie where m_no = " + data;
         ST=CN.createStatement( );
         RS=ST.executeQuery(msg);
         RS.next();
         bean.setNo(RS.getInt("m_no"));
         bean.setTitle(RS.getString("m_title"));
         bean.setSubtitle(RS.getString("m_subtitle"));
         bean.setGrade(RS.getInt("m_grade"));
         bean.setPoint(RS.getString("m_point"));
         bean.setType(RS.getString("m_type"));
         bean.setPremiere(RS.getDate("m_premiere"));
         bean.setDirector(RS.getString("m_director"));
         bean.setActor(RS.getString("m_actor"));
         bean.setGenre(RS.getString("m_genre"));
         bean.setAudience(RS.getString("m_audience"));
         bean.setStory(RS.getString("m_story"));
         bean.setPoster(RS.getString("m_poster"));
         bean.setSteal1(RS.getString("m_steal1"));
         bean.setSteal2(RS.getString("m_steal2"));
         bean.setSteal3(RS.getString("m_steal3"));
         bean.setSteal4(RS.getString("m_steal4"));
         bean.setSteal5(RS.getString("m_steal5"));
      }catch(Exception ex){System.out.println("Error: "+ex);}
         return bean;
      }
       
       public Moviebean MovieDetail(String data) {
           Moviebean bean = new Moviebean();
           try{
             msg="select * from movie where m_title = '" + data+"'";
             ST=CN.createStatement( );
             RS=ST.executeQuery(msg);
             RS.next();
             bean.setNo(RS.getInt("m_no"));
             bean.setTitle(RS.getString("m_title"));
             bean.setSubtitle(RS.getString("m_subtitle"));
             bean.setGrade(RS.getInt("m_grade"));
             bean.setPoint(RS.getString("m_point"));
             bean.setType(RS.getString("m_type"));
             bean.setPremiere(RS.getDate("m_premiere"));
             bean.setDirector(RS.getString("m_director"));
             bean.setActor(RS.getString("m_actor"));
             bean.setGenre(RS.getString("m_genre"));
             bean.setAudience(RS.getString("m_audience"));
             bean.setStory(RS.getString("m_story"));
             bean.setPoster(RS.getString("m_poster"));
             bean.setSteal1(RS.getString("m_steal1"));
             bean.setSteal2(RS.getString("m_steal2"));
             bean.setSteal3(RS.getString("m_steal3"));
             bean.setSteal4(RS.getString("m_steal4"));
             bean.setSteal5(RS.getString("m_steal5"));
          }catch(Exception ex){System.out.println("Error: "+ex);}
             return bean;
          }
   
   
      
      

      //공지사항게시판리스트
      public ArrayList movieSelect(int start, int end, String skey, String sval) {
           ArrayList<Moviebean> list3=new ArrayList<Moviebean>();
           String sqry=" where "+skey+" like '%"+sval+"%'";
           try {
             
              String x=" select * from ( ";
              //select row_number() over (order by n_no desc) as rn , n_no,n_loc,n_title,n_redate from notice
              String y=" select row_number() over (order by m_no desc) as rn, m_no,m_title,m_type,m_genre,m_premiere,m_subtitle,m_grade,m_director,m_actor,m_story,m_poster,m_steal1,m_steal2,m_steal3,m_steal4,m_steal5 from movie ";
              String z=" ) where rn between "+start+" and " +end;
             
            msg=x+y+z;
            ST=CN.createStatement();
            RS=ST.executeQuery(msg);
            while(RS.next()) {
             Moviebean mbean = new Moviebean();
              mbean.setNo(RS.getInt("m_no"));
              mbean.setTitle(RS.getString("m_title"));
              mbean.setType(RS.getString("m_type"));
              mbean.setGenre(RS.getString("m_genre"));
              mbean.setPremiere(RS.getDate("m_premiere"));
              mbean.setSubtitle(RS.getString("m_subtitle"));
              mbean.setGrade(RS.getInt("m_grade"));
              mbean.setDirector(RS.getString("m_director"));
              mbean.setActor(RS.getString("m_actor"));
              mbean.setStory(RS.getString("m_story"));
              mbean.setPoster(RS.getString("m_poster"));
              mbean.setSteal1(RS.getString("m_steal1"));
              mbean.setSteal2(RS.getString("m_steal2"));
              mbean.setSteal3(RS.getString("m_steal3"));
              mbean.setSteal4(RS.getString("m_steal4"));
              mbean.setSteal5(RS.getString("m_steal5"));
              
              list3.add(mbean); 
            }
           }catch(Exception ex) {
            System.out.println("Error: " + ex);
           }
           return list3;
         }
      
      //공지사항 상세
      public DBbean noticeDetail(int data) {
         DBbean bean= new DBbean();
         try {
           msg="select * from notice where n_no="+data;
           ST=CN.createStatement();
           RS=ST.executeQuery(msg);
          if(RS.next()){
            bean.setNtitle(RS.getString("n_title"));
            bean.setNloc(RS.getString("n_loc"));
            bean.setNdate(RS.getDate("n_redate"));
            bean.setNcontent(RS.getString("n_content"));
           }
             
         }catch(Exception ex) {
            System.out.println("Error: " + ex);
         }
         return bean;
      }
      
      public void movieDelete(int data) {
        try {
         msg="delete from movie where m_no = " + data;
         ST=CN.createStatement();
         ST.executeUpdate(msg);
         
        }catch(Exception ex) {
         System.out.println("Error: " + ex);
        }
      }
      
      public Moviebean MovieEdit(int data) {
        Moviebean bean = new Moviebean();
        try {
        msg="select * from movie where m_no="+ data ;
        ST=CN.createStatement();
        RS=ST.executeQuery(msg);
        RS.next();
          bean.setNo(RS.getInt("m_no"));
          bean.setTitle(RS.getString("m_title"));
          bean.setSubtitle(RS.getString("m_subtitle"));
          bean.setGrade(RS.getInt("m_grade"));
          bean.setType(RS.getString("m_type"));
          bean.setPremiere(RS.getDate("m_premiere"));
          bean.setDirector(RS.getString("m_director"));
          bean.setActor(RS.getString("m_actor"));
          bean.setGenre(RS.getString("m_genre"));
          bean.setStory(RS.getString("m_story"));
          bean.setPoster(RS.getString("m_poster"));
          bean.setSteal1(RS.getString("m_steal1"));
          bean.setSteal2(RS.getString("m_steal2"));
          bean.setSteal3(RS.getString("m_steal3"));
          bean.setSteal4(RS.getString("m_steal4"));
          bean.setSteal5(RS.getString("m_steal5"));
        }catch(Exception ex){System.out.println("Error: " + ex);}
        return bean;
     }
      
      
      public void movieEditSave(Moviebean mbean, int data) {
           try {
              msg="update movie set m_title=?,m_subtitle=?,m_grade=?,m_type=?,m_premiere=to_date(?,'yyyy-mm-dd'),m_director=?,m_actor=?,m_genre=?,m_story=?,m_poster=?,m_steal1=?,m_steal2=?,m_steal3=?,m_steal4=?,m_steal5=? where m_no="+data;
              PST=CN.prepareStatement(msg);
                 PST.setString(1, mbean.getTitle());
                  PST.setString(2, mbean.getSubtitle());
                  PST.setInt(3, mbean.getGrade());
                  PST.setString(4, mbean.getType());                  
                  PST.setString(5, sdf.format(mbean.getPremiere()));
                  PST.setString(6, mbean.getDirector());
                  PST.setString(7, mbean.getActor());
                  PST.setString(8, mbean.getGenre());
                  PST.setString(9, mbean.getStory());
                  PST.setString(10, mbean.getPoster());
                  PST.setString(11, mbean.getSteal1());
                  PST.setString(12, mbean.getSteal2());
                  PST.setString(13, mbean.getSteal3());
                  PST.setString(14, mbean.getSteal4());
                  PST.setString(15, mbean.getSteal5());
                  PST.executeUpdate();
                System.out.println("movieEidtSave() 성공"); 
           }catch(Exception ex) {
            System.out.println("Error: " + ex);
           }
         }
      
      public int movieCount() {
        try {
         msg="select count(*) as cnt from movie ";
         ST=CN.createStatement();
         RS=ST.executeQuery(msg);
         if(RS.next()) {
            Gtotal=RS.getInt("cnt");
         }
        }catch(Exception ex) {
         System.out.println("Error: " + ex);
        }
        return Gtotal;
      }
      
      //공지사항 검색 카운트
      public int movieCountSearch(String skey, String sval) {
           try {
            msg="select count(*) as cnt from movie where "+skey+" like '%"+sval+"%'";
            ST=CN.createStatement();
            RS=ST.executeQuery(msg);
            RS.next();
            Stotal=RS.getInt("cnt");
           }catch(Exception ex) {
            System.out.println("Error: " + ex);
           }
           return Stotal;
      }
   
}