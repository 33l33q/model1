package bitcamp.java142.board.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bitcamp.java142.board.sql.LdbHelloBoardSqlMap;


public abstract class LdbChaebunClass {
	
	public static final String MEM_GUBUN = "M";
	
	public static String commNo_LDB_BOARD(){
	
		System.out.println("(log) board.common.LdbCheabunClass ���� ");
		
	Connection conn 		= null;
	PreparedStatement pstmt = null;
	ResultSet rsRs			= null;
	
	String commNO = "";
	
	try{
		System.out.println("(log) insert.LdbChaebunClass.LdbConnProperty.getConnection() �Լ� ���� ");
		conn 	= ConnProperty.getConnection();
		System.out.println("DB �ּ� ����  >>> " + conn);
		
		System.out.println("(log) BoardTest.LdbCheabunClass.LdbConnProperty.prepareStatement.LDB_HELLO_BOARD_CHEABUN ���� ���� ");
		pstmt	= conn.prepareStatement(LdbHelloBoardSqlMap.LDB_HELLO_BOARD_CHEABUN);

		
		System.out.println("(log) pstmt.executeQuer() �Լ� ���� ");
		rsRs	= pstmt.executeQuery();
		
		if(rsRs.next()){
			commNO = String.valueOf(rsRs.getInt("commNO"));
		}
		
		System.out.println("commNO >>> : " +  commNO);
		
		if( 1 == commNO.length()){
			commNO = MEM_GUBUN + "000" + commNO;
		}
		
		if( 2 == commNO.length()){
			commNO = MEM_GUBUN +  "00" + commNO;
		}
		
		if( 3 == commNO.length()){
			commNO = MEM_GUBUN + "0" + commNO;
		}
		
		if( 4 == commNO.length()){
			commNO = MEM_GUBUN + commNO;
		}
				
	}catch(Exception e){
		System.out.println("DB����" + e.getMessage());
		
	}finally{
		try{
		}catch(Exception e2){
			e2.printStackTrace();
		}
		ConnProperty.conClose(conn, pstmt, rsRs);
	}
	
	System.out.println("(log) BoardTest.LdbChaebunClass.LdbConnProperty.getConnection() �Լ� ���� ");
	
	System.out.println("commNO >>> :  " + commNO );
	return commNO;
	
	}
		
		
		
}
