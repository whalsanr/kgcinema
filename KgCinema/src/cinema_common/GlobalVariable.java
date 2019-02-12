package cinema_common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class GlobalVariable {
	Connection CN;
	Statement ST, ST3;
	PreparedStatement PST;
	CallableStatement CS;
	ResultSet RS, RS3;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
	
	String msg, msg3;
	int Gtotal2=27, Sbtotal;
	
	 String title, subtitle, type, date, director, actor, genre, story;
	 String file1, file2, file3, file4, file5, file6;	//file1은 포스터 2~6은 스틸컷
	 int Gtotal=0, Stotal=0, Rtotal=0;
}
