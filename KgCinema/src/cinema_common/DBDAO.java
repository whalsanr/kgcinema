package cinema_common;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBDAO extends GlobalVariable {
	
    public DBDAO() {
	  CN=DB.getConnection();
	}
	
	public void movieInsert(DBbean bean) {
	  try {
	    msg="insert into movie values(movie_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    PST=CN.prepareStatement(msg);
	      PST.setString(1, bean.getTitle());
	      PST.setString(2, bean.getSubtitle());
	      PST.setString(3, bean.getType());
	      PST.setString(4, bean.getDate());
	      PST.setString(5, bean.getDirector());
	      PST.setString(6, bean.getActor());
	      PST.setString(7, bean.getGenre());
	      PST.setString(8, bean.getStory());
	      PST.setString(9, bean.getFile1());
	      PST.setString(10, bean.getFile2());
	      PST.setString(11, bean.getFile3());
	      PST.setString(12, bean.getFile4());
	      PST.setString(13, bean.getFile5());
	      PST.setString(14, bean.getFile6());
	      
	    PST.executeUpdate();
	    System.out.println("movieInsert (dbbean bean) 저장성공");
	  }catch(Exception ex) {
		  System.out.println("Error: " + ex);
	  }
	}
	// 공지사항과 관리자 공지사항 DB공유
	public void noticeInsert(DBbean bean) {
		  try {
		    msg="insert into notice values(notice_seq.nextval, ?, ?, sysdate, ?)";
		    PST=CN.prepareStatement(msg);
		      PST.setString(1, bean.getNloc());
		      PST.setString(2, bean.getNtitle());
		      PST.setString(3, bean.getNcontent());
	
		      
		    PST.executeUpdate();
		    System.out.println("noticeInsert (dbbean bean) 저장성공");
		  }catch(Exception ex) {
			  System.out.println("Error: " + ex);
		  }
		}
	

	//공지사항게시판리스트
	public ArrayList noticeSelect(int start, int end, String skey, String sval) {
		  ArrayList<DBbean> list=new ArrayList<DBbean>();
		  String sqry=" where "+skey+" like '%"+sval+"%'";
		  try {
			  /*+ sqry+*/
			  String x=" select * from ( ";
			  //select row_number() over (order by n_no desc) as rn , n_no,n_loc,n_title,n_redate from notice
			  String y=" select row_number() over (order by n_no desc) as rn, n_no,n_loc,n_title,n_redate,n_content from notice "+ sqry;
			  String z=" ) where rn between "+start+" and " +end;
			 
			msg=x+y+z;
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			while(RS.next()) {
			 DBbean bean = new DBbean();
			  bean.setNrn(RS.getInt("rn"));
			  bean.setNno(RS.getInt("n_no"));
			  bean.setNloc(RS.getString("n_loc"));
			  bean.setNtitle(RS.getString("n_title"));
			  bean.setNdate(RS.getDate("n_redate"));
			  bean.setNcontent(RS.getString("n_content"));
			  	
			  list.add(bean); 
			}
		  }catch(Exception ex) {
			System.out.println("Error: " + ex);
		  }
		  return list;
		}
	
	//공지사항 상세
	public DBbean noticeDetail(int data) {
		DBbean bean= new DBbean();
		try {
		  msg="select * from notice where n_no="+data;
		  System.out.println(data);
		  ST=CN.createStatement();
		  RS=ST.executeQuery(msg);
		 if(RS.next()){
			bean.setNtitle(RS.getString("n_title"));
			bean.setNloc(RS.getString("n_loc"));
			bean.setNdate(RS.getDate("n_redate"));
			bean.setNcontent(RS.getString("n_content"));
			System.out.print("detail 성공");
		  }
		    
		}catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
		return bean;
	}
	
	public void noticeDelete(int data) {
	  try {
		msg="delete from notice where n_no = " + data;
		ST=CN.createStatement();
		ST.executeUpdate(msg);
		
	  }catch(Exception ex) {
		System.out.println("Error: " + ex);
	  }
	}
	
	public void noticeEdit(DBbean bean, int data) {
		  try {
			 
			  msg="update notice set n_loc=?,n_title=?,n_redate=sysdate,n_content=? where n_no="+data;
			  PST=CN.prepareStatement(msg);
			    PST.setString(1, bean.getNloc());
			    PST.setString(2, bean.getNtitle());
			    PST.setString(3, bean.getNcontent()); 
			    PST.executeUpdate();
			    System.out.println("noticeEidt() 성공"); 
		  }catch(Exception ex) {
			System.out.println("Error: " + ex);
		  }
		}
	
	public int noticeCount() {
	  try {
		msg="select count(*) as cnt from notice ";
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
	public int noticeCountSearch(String skey, String sval) {
		  try {
			msg="select count(*) as cnt from notice where "+skey+" like '%"+sval+"%'";
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			RS.next();
			Stotal=RS.getInt("cnt");
		  }catch(Exception ex) {
			System.out.println("Error: " + ex);
		  }
		  return Stotal;
	}
	
	//이벤트게시판
	public void eventInsert(DBbean bean) {
		  try {
			  
		    msg="insert into event values(event_seq.nextval, ?, ?, ?, sysdate, ?)";
		    PST=CN.prepareStatement(msg);
		      PST.setString(1, bean.getEtitle());	//이벤트 제목
		      PST.setString(2, bean.getEperiod());	//이벤트 기간
		      PST.setString(3, bean.getEcontent()); //이벤트 내용
		      PST.setString(4, bean.getEfile());	//이벤트 메인이미지
	
		      
		    PST.executeUpdate();
		    System.out.println("eventInsert (dbbean bean) 저장성공");
		  }catch(Exception ex) {
			  System.out.println("Error: " + ex);
		  }
	}
	
	public ArrayList eventSelect(int start, int end, String skey, String sval) {
		  ArrayList<DBbean> list=new ArrayList<DBbean>();
		  String sqry=" where "+skey+" like '%"+sval+"%'";
		  try {
			  /*+ sqry+*/
			  String x=" select * from ( ";
			  String y=" select row_number() over (order by e_no desc) as rn, e_no,e_title,e_period,e_content,e_date,e_file from event "+ sqry;
			  String z=" ) where rn between "+start+" and " +end;
			 
			msg=x+y+z;
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			while(RS.next()) {
			 DBbean bean = new DBbean();
			  bean.setErn(RS.getInt("rn"));
			  bean.setEno(RS.getInt("e_no"));
			  bean.setEtitle(RS.getString("e_title"));
			  bean.setEperiod(RS.getString("e_period"));
			  bean.setEcontent(RS.getString("e_content"));
			  bean.setEdate(RS.getDate("e_date"));
			  bean.setEfile(RS.getString("e_file"));	
			  list.add(bean); 
			}
		  }catch(Exception ex) {
			System.out.println("Error: " + ex);
		  }
		  return list;
		}
	
	public DBbean eventDetail(int data) {
		DBbean bean= new DBbean();
		try {
		  msg="select * from event where e_no="+data;
		  ST=CN.createStatement();
		  RS=ST.executeQuery(msg);
		 if(RS.next()){
			bean.setEcontent(RS.getString("e_content"));
			bean.setEfile(RS.getString("e_file"));
			
		  }
		    
		}catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
		return bean;
	}
	
	public int eventCount() {
		  try {
			msg="select count(*) as cnt from event ";
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
	
	public int eventCountSearch(String skey, String sval) {
		  try {
			msg="select count(*) as cnt from event where "+skey+" like '%"+sval+"%'";
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			RS.next();
			Stotal=RS.getInt("cnt");
		  }catch(Exception ex) {
			System.out.println("Error: " + ex);
		  }
		  return Stotal;
	}
	
	public void dbtest() {
	  try {
		//기본틀 (복붙용)
	  }catch(Exception ex) {
		System.out.println("Error: " + ex);
	  }
	}
}
