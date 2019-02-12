package cinema_common;

import java.util.ArrayList;

public class UserDAO extends GlobalVariable {
	
	public UserDAO() {
		CN = DB.getConnection();
	} // 생성자 end
	
	
	// userJoin 회원가입 메서드 insert into문에서 날짜형식 입력예시 to_date('2018-09-01','yyyy-mm-dd')
	public void userJoin(Userbean bean) {
		try {
	        msg="insert into join values(join_seq.nextval,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,null)";
	        PST=CN.prepareStatement(msg);
	         PST.setString(1,bean.getId());
	         PST.setString(2, bean.getName());
	         PST.setString(3, bean.getPwd());
	         PST.setString(4, bean.getJuso1());
	         PST.setString(5, bean.getJuso2());
	         PST.setString(6, bean.getBirth());
	         PST.setString(7, bean.getPhone());
	         PST.setString(8, bean.getEmail());
	         PST.executeUpdate();
	         System.out.println(bean.getId() + "가입완료");
	      }catch(Exception ex){System.out.println("Error: "+ex);}
	   }
	
	// userMypage 유저상세 메서드
	public Userbean userMypage(String data) {
		Userbean bean = new Userbean();
		try {
			msg = "select * from join where j_id='"+data+"'";
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			if(RS.next()) {
				bean.setId(RS.getString("j_id"));
				bean.setName(RS.getString("j_name"));
				bean.setPwd(RS.getString("j_pwd"));
				bean.setJuso1(RS.getString("j_juso1"));
				bean.setJuso2(RS.getString("j_juso2"));

				java.util.Date date = RS.getDate("j_birth");
				
				bean.setBirth(String.valueOf(date));
				bean.setPhone(RS.getString("j_phone"));
				bean.setEmail(RS.getString("j_email"));
				bean.setFile(RS.getString("j_file1"));
			}
		} catch(Exception e) {
			System.out.println("Error : " + e);
		}
		return bean;
	}
	
	// userEdit 개인정보수정 메서드
	public void userEdit(Userbean bean) {
		try {
	        msg="update join set j_juso1=?,j_juso2=?,j_birth=to_date(?,'yyyy-mm-dd'),j_phone=?,j_email=?,j_file1=? where j_id=?";
	        PST=CN.prepareStatement(msg);
	         PST.setString(1, bean.getJuso1());
	         PST.setString(2, bean.getJuso2());
	         PST.setString(3, bean.getBirth());
	         PST.setString(4, bean.getPhone());
	         PST.setString(5, bean.getEmail());
	         PST.setString(6, bean.getFile());
	         PST.setString(7, bean.getId());
	         PST.executeUpdate();
	         System.out.println(bean.getId() + "수정완료");
	      }catch(Exception ex){System.out.println("Error: "+ex);}
	   }
	
	// userDelete 회원탈퇴 메서드
	
	// userCount ??
	
	// userSb 아이디중복체크 메서드
	public int userSb(String id) {
		try {
			msg = "select count(*) as cnt from join where j_id='" + id +"'";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			if(RS.next()) {
				Sbtotal = RS.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("Error : " + e);
		}
		return Sbtotal;
	}
	
	// userLogin 로그인 메서드
	public int userLogin(String id, String pw) {
		int total = 0;
		try {
			msg = "select count(*) as cnt from join where j_id='"+id+"' and j_pwd='"+pw+"'";
			ST = CN.createStatement();
			RS = ST.executeQuery(msg);
			if(RS.next()) {
				total = RS.getInt("cnt");
			}
		} catch(Exception e) {
			System.out.println("Error : " + e);
		}
		return total;
	}
	
	public ArrayList textOutput() {
		ArrayList test = new ArrayList();
		try {
			msg = "select text from test1";
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			while(RS.next()) {
				test.add(RS.getString("text"));				
			}
			
		} catch(Exception e) {
			System.out.println("Error : " + e);
		}
		return test;
	}
}
