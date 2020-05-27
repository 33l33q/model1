package bitcamp.java142.ch5.ldbjf.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import bitcamp.java142.ch5.ldbjf.sql.LdbSqlQueryMap;

public abstract class LdbCheabunClass {
	
	public static final String MEM_GUBUN = "M";
	
	public static String dFormat(){
		
		Date d = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
		String date = dt.format(d);
		
		String df = MEM_GUBUN + date;
		return df;
		}

	public static String commonNo_LDB_MEMBER(){
		
		System.out.println("(log) LdbMemberScr.LdbCheabunClass ���� ");
		
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet	rsRs 		= null;
	
	String commNO = "";
		
		
	try{
		System.out.println("(log) LdbMemberScr.LdbCheabunClass.LdbConnProperty.getConnection() �Լ� ���� ");
		conn = LdbConnProperty.getConnection();
		System.out.println("DB �ּ� ����  >>> " + conn);
		
		System.out.println("(log) LdbMemberScr.LdbCheabunClass.LdbConnProperty.prepareStatement.LDB_MEMBER_LMEM_CHEABUM ���� ���� ");
		pstmt = conn.prepareStatement(LdbSqlQueryMap.LDB_MEMBER_LMEM_CHEABUM);
		System.out.println("EciSqlQueryMap.LDB_MEMBER_LMEM_CHEABUM : \n" 
				+ LdbSqlQueryMap.LDB_MEMBER_LMEM_CHEABUM);
		
		System.out.println("(log) LdbMemberScr.LdbCheabunClass.LdbConnProperty.executeQuery() �Լ� ���� ");
		rsRs = pstmt.executeQuery();
		
		
	
		if(rsRs.next()){
			commNO = String.valueOf(rsRs.getInt("commNO"));
		}
		System.out.println("commNO >>> : " +  commNO);
			
		if(1 == commNO.length()){
			commNO = LdbCheabunClass.dFormat() + "000" + commNO;
		}
		
		
		if(2 == commNO.length()){
			commNO = LdbCheabunClass.dFormat() + "00" + commNO;
		}
		
		
		if(3 == commNO.length()){
			commNO = LdbCheabunClass.dFormat() + "0" + commNO;
		}
		
		if(4 == commNO.length()){
			commNO = LdbCheabunClass.dFormat() + commNO;
		}
				
		
	}catch(Exception e){
		System.out.println("DB���� " + e.getMessage());
	
	}finally{
		try{
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
	System.out.println("(log) LdbMemberScr.LdbCheabunClass.LdbConnProperty.getConnection() �Լ� ���� ");
	return commNO;
	
	}//end of commonNo_LDB_MEMBER()

}//end of class
