package cinema_common;

import java.util.ArrayList;

public class TheaterDAO extends GlobalVariable {
	public TheaterDAO() {
		CN = DB.getConnection();
	} // 생성자 end
	
	public ArrayList<Theaterbean> theaterSelect() {
	      ArrayList<Theaterbean> list = new ArrayList<Theaterbean>();
	      try {
	         msg = "select * from theater order by t_theater";
	         ST = CN.createStatement();
	         RS = ST.executeQuery(msg);
	         while(RS.next()) {
	            Theaterbean bean = new Theaterbean();
	            bean.setNo(RS.getInt("t_no"));
	            bean.setTheater((RS.getString("t_theater")));
	            bean.setJuso1(RS.getString("t_juso1"));
	            bean.setJuso2(RS.getString("t_juso2"));
	            
	            list.add(bean);
	         }
	      } catch (Exception e) {
	         System.out.println("Error : " + e);
	      }
	      return list;
	   } // theaterSelect() end
	
}
