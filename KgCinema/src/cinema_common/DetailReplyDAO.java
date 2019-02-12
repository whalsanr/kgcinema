package cinema_common;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DetailReplyDAO extends GlobalVariable {
	
    public DetailReplyDAO() {
	  CN=DB.getConnection();
	}
	
	public void replyInsert(String drid, String dravg, String drcontent) {
	  try {
	    msg="insert into detailreply values(detailreply_seq.nextval, ?, sysdate, ?, ?)";
	    PST=CN.prepareStatement(msg);
	      
	      PST.setString(1, drid);
	      PST.setString(2, dravg);
	      PST.setString(3, drcontent);
	    PST.executeUpdate();
	    System.out.println("reply Insert(ReplyBean bean) OK!!");
	  }catch(Exception ex) {
		  System.out.println("Error: " + ex);
	  }
	}
	
	public ArrayList<DetailReplybean> replySelect(int Rdata) {
	  ArrayList<DetailReplybean> rlist = new ArrayList<DetailReplybean>();
	  try {
		msg="select rownum rn, m.sabun, dr.num, r.writer, dr.content from movie m inner join detailreply dr on m.sabun=r.sabun and dr.sabun="+Rdata ;
		// StringBuffer sb=new StringBuffer();
	    // 	sb.append(" select  rownum rn, g.sabun,r.num,r.writer,r.content from guest g  ") ;
	    // 	sb.append(" inner join guestreply r") ;
	    // 	sb.append(" on  g.sabun=r.sabun ") ;
	    // 	sb.append(" and r.sabun="+Rdata) ;
	     	
		ST=CN.createStatement();
		RS=ST.executeQuery(msg);
		while(RS.next()) {
			DetailReplybean drbean = new DetailReplybean();
			drbean.setDrno(RS.getInt("dr_no"));
			drbean.setDrid(RS.getString("dr_id"));
			drbean.setDrdate(RS.getDate("dr_date"));
			drbean.setDravg(RS.getString("dr_avg"));
			drbean.setDrcontent(RS.getString("dr_content"));
			rlist.add(drbean);
		}
		
	  }catch(Exception ex) {
		System.out.println("Error: " + ex);
	  }
	  return rlist;
	}
	
	public void replyDelete(int data) {
		  try {
			msg="delete from detailreply where dr_no = " + data;
			ST=CN.createStatement();
			ST.executeUpdate(msg);
			System.out.println("replydelete ()삭제성공");
		  }catch(Exception ex) {
			System.out.println("Error: " + ex);
		  }
		}
	
	
}
