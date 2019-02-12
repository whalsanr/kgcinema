package cinema_common;

import java.util.ArrayList;

public class ScheduleDAO extends GlobalVariable {
	public ScheduleDAO() {
		CN = DB.getConnection();
	} // 생성자 end

	public void scheduleInsert(Schedulebean sbean) {
		try {
			msg="insert into schedule values(schedule_seq.nextval, ?, ?, ?,to_date(?,'yyyy-mm-dd hh24:mi'),to_date(?,'yyyy-mm-dd hh24:mi'))";
			PST=CN.prepareStatement(msg);
			PST.setString(1, sbean.getTheater());
			PST.setString(2, sbean.getScrno());
			PST.setString(3, sbean.getTitle());
			PST.setString(4, sdf.format(sbean.getStarthour()));
			PST.setString(5, sdf.format(sbean.getEndhour()));
			PST.executeUpdate();
		}catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
	} // scheduleInsert() end
	
	public ArrayList<Schedulebean> scheduleSelect(String date, String theater, String movie) {
	      ArrayList<Schedulebean> list = new ArrayList<Schedulebean>();
	      try {
	         msg = "select * from schedule where theater like '"+theater+"' and title like '%"+movie+"%' and starthour like to_date('"+date+"','yyyy-mm-dd') and starthour > sysdate";
	         ST = CN.createStatement();
	         RS = ST.executeQuery(msg);
	         while(RS.next()) {
	        	 Schedulebean bean = new Schedulebean();
	            bean.setId(RS.getInt("schedule_id"));
	            bean.setTheater(RS.getString("theater"));
	            bean.setScrno(RS.getString("scrno"));
	            bean.setTitle(RS.getString("title"));
	            bean.setStarthour(RS.getTime("starthour"));
	            bean.setEndhour(RS.getTime("endhour"));
	            bean.setDate(RS.getDate("starthour"));

	            list.add(bean);
	         }
	      } catch (Exception e) {
	         System.out.println("Error 스케줄셀렉트: " + e);
	      }
	      return list;
	   } // scheduleSelect() end
	
	public Schedulebean scheduleDetail(int data) {
		Schedulebean bean = new Schedulebean();
		try {
	         msg = "select * from schedule where schedule_id="+data;
	         ST = CN.createStatement();
	         RS = ST.executeQuery(msg);
	         if(RS.next()) {
	            bean.setId(RS.getInt("schedule_id"));
	            bean.setTheater(RS.getString("theater"));
	            bean.setScrno(RS.getString("scrno"));
	            bean.setTitle(RS.getString("title"));
	            bean.setStarthour(RS.getTime("starthour"));
	            bean.setEndhour(RS.getTime("endhour"));
	            bean.setDate(RS.getDate("starthour"));
	         }
	      } catch (Exception e) {
	         System.out.println("Error 스케줄셀렉트: " + e);
	      }
		return bean;
	}
	
}
