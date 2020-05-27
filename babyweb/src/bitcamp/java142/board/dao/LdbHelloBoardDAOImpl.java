package bitcamp.java142.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.java142.board.common.ConnProperty;
import bitcamp.java142.board.common.LdbChaebunClass;
import bitcamp.java142.board.sql.LdbHelloBoardSqlMap;
import bitcamp.java142.board.vo.LdbHelloBoardVO;
import bitcamp.java142.ch5.ldbjf.common.LdbConnProperty;

public class LdbHelloBoardDAOImpl implements LdbHelloBoardDAO {

	//insert

	@Override
	public int boardInsert(LdbHelloBoardVO i_lvo) {
		
		System.out.println("(log) BoradTest.LdbHelloBoardDAO.boardInsertr(LdbHelloBoardVO i_lvo) �Լ� ����  ");
		
		System.out.println("i_lvo �������� �ּҰ� : " + i_lvo);
		
		System.out.println(" " + i_lvo.getLsubject() + " " + i_lvo.getLname() +  " " +  i_lvo.getLpw() +  " " + i_lvo.getLmemo() );
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int nCnt = 0;
		
		try {
			
			System.out.println("(log) BoradTest.ConnProperty.getConnection() �Լ� ���� "); 
			con = ConnProperty.getConnection();
			System.out.println("DB �ּ� ����  >>> " + con);
			
			System.out.println("(log) BoradTest.prepareStatement.getInsertQuery() �Լ� ���� "); 
			pstmt = con.prepareStatement(LdbHelloBoardSqlMap.getInsertQuery());
			System.out.println("LdbHelloBoardSqlMap.getInsertQuery() : \n"  + LdbHelloBoardSqlMap.getInsertQuery());
			
			pstmt.setString(1, LdbChaebunClass.commNo_LDB_BOARD());
			pstmt.setString(2, i_lvo.getLsubject());
			pstmt.setString(3, i_lvo.getLname());
			pstmt.setString(4, i_lvo.getLpw());
			pstmt.setString(5, i_lvo.getLmemo());
			pstmt.setString(6, "Y");
			
			
			System.out.println("LdbChaebunClass.commNo_LDB_BOARD() " + LdbChaebunClass.commNo_LDB_BOARD());

			
			System.out.println("(log) BoradTest.pstmt.executeUpdate() �Լ� ���� ");
			System.out.println(LdbChaebunClass.commNo_LDB_BOARD() +  " " +  
		 			i_lvo.getLsubject() + " " +
		 			i_lvo.getLname() + " " + 
		 			i_lvo.getLpw() + " " +
		 			i_lvo.getLmemo() + " ");
			nCnt = pstmt.executeUpdate();
			
			
			if(!con.getAutoCommit()) con.commit();
		}catch(Exception e){
			e.getMessage();
		}finally{
			try{ ConnProperty.conClose(con, pstmt);
			}catch(Exception e2){
			}
		}
		

		System.out.println("��Ȯ���ϱ� >>> : " + nCnt);
		
		System.out.println("(log) BoradTest.LdbHelloBoardDAO.boardInsertr(LdbHelloBoardVO i_lvo) �Լ� ���� "); 

		return nCnt;
		
	} //end of boardInsert
	
	
	public int boardUpdate(LdbHelloBoardVO i_lvo){
		
		System.out.println("(log) borad.LdbHelloBoardDAO.boardUpdate(LdbHelloBoardVO i_lvo) �Լ� ���� "); 
		System.out.println("i_lvo �������� �ּҰ� : " +  i_lvo );
		System.out.println("�������� �� Ȯ���ϱ� " + i_lvo.getLsubject() + " " + i_lvo.getLmemo() + " " + i_lvo.getLno());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int nCnt = 0;
		
		try{
			
			System.out.println("(log) borad.ConnProperty.getConnection() �Լ����� ");
			con = ConnProperty.getConnection();
			System.out.println("(log) borad.LdbHelloBoardSqlMap.getUpdateQuery() �Լ� ȣ��");
			pstmt = con.prepareStatement(LdbHelloBoardSqlMap.getUpdateQuery());
			
			
			pstmt.setString(1, i_lvo.getLsubject());
			pstmt.setString(2, i_lvo.getLmemo());
			pstmt.setString(3, i_lvo.getLno());
			
			System.out.println(" " + i_lvo.getLsubject() + " " + i_lvo.getLmemo() + " " + i_lvo.getLno());
			
			System.out.println("(log) borad pstmt.executeUpdate() �Լ� ȣ��");
			nCnt = pstmt.executeUpdate();
			
			System.out.println("(log) commit");
			if(!con.getAutoCommit()) { con.commit();}
			System.out.println("�����Ǿ����ϴ� >>> "  + nCnt);
			
		}catch(Exception e){
			System.out.println("�����߻�! " + e.getMessage());
			
		}finally{
			try{
				LdbConnProperty.conClose(con, pstmt);
				
			}catch(Exception e2){
			}
		
		}
		System.out.println("(log) borad.LdbHelloBoardDAO.boardUpdate(LdbHelloBoardVO i_lvo) �Լ� ���� "); 
		return nCnt;
	}//end of ����

	public int boardDelete(LdbHelloBoardVO i_lvo){
		
		System.out.println("(log) borad.LdbHelloBoardDAO.boardDelete(LdbHelloBoardVO i_lvo) �Լ� ���� "); 
		System.out.println("i_lvo �������� �ּҰ� : " +  i_lvo );
		System.out.println("�������� �� Ȯ���ϱ� " + i_lvo.getLno());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int nCnt = 0;
		
		try{
			con = ConnProperty.getConnection();
			pstmt = con.prepareStatement(LdbHelloBoardSqlMap.getDeleteQuery());
			System.out.println("LdbHelloBoardSqlMap.getDeleteQuery() : \n"  + LdbHelloBoardSqlMap.getDeleteQuery());
			
			pstmt.setString(1, i_lvo.getLno() );
			
			System.out.println("sql�� Ȯ��" + i_lvo.getLno());
			
			System.out.println("(log) borad pstmt.executeUpdate() �Լ� ȣ��");
			nCnt = pstmt.executeUpdate();
			
			if(!con.getAutoCommit()) {con.commit();}
			System.out.println(" ���� �Ϸ�! >>> "  + nCnt);
			
		}catch(Exception e){
			
		}finally{
			try{
				LdbConnProperty.conClose(con, pstmt);
				
			}catch(Exception e2){
			}
		
		}
		System.out.println("(log) borad.LdbHelloBoardDAO.boardDelete(LdbHelloBoardVO i_lvo) �Լ� ���� "); 
		return nCnt;
	}
	
	
	public ArrayList<LdbHelloBoardVO> boardSelectAll(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LdbHelloBoardVO> aList = null;
		LdbHelloBoardVO lbvo = null;
		
		try {
		
			con = ConnProperty.getConnection();
			
			pstmt = con.prepareStatement(LdbHelloBoardSqlMap.getSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			
			
			if(rsRs != null){
				aList = new ArrayList<LdbHelloBoardVO>();
				while(rsRs.next()){
					lbvo = new LdbHelloBoardVO();
					lbvo.setLno(rsRs.getString("LNO"));
					lbvo.setLsubject(rsRs.getString("LSUBJECT"));
					lbvo.setLname(rsRs.getString("LNAME"));
					lbvo.setLpw(rsRs.getString("LPW"));
					lbvo.setLmemo(rsRs.getString("LMEMO"));
					lbvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lbvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lbvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					aList.add(lbvo);
				}
				System.out.println("aList.size() >>> : " + aList );
			}else{
				System.out.println("�����Ͱ� �����ϴ�.");
			}
			
			
		}catch(Exception e){
			System.out.println("������ >>> : " + e.getMessage());
		}finally{
			ConnProperty.conClose(con, pstmt, rsRs);
			try{ConnProperty.conClose(con, pstmt, rsRs);
			}catch(Exception e2){
				System.out.println("������ �߻��߽��ϴ� >>> : " + e2.getMessage());
			}
		}

		return aList;
		
		
	}
	
	

	
	public ArrayList<LdbHelloBoardVO> boardSelect(LdbHelloBoardVO i_lvo){
		
		System.out.println("(log) board.LdbHelloBoardDAO.boardUpdate(LdbHelloBoardVO i_lvo) �Լ� ���� "); 
		System.out.println("i_lvo �������� �ּҰ�" + i_lvo);
		System.out.println("�Ű����� Ȯ��" + i_lvo.getLno());
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LdbHelloBoardVO> aList = null;
		LdbHelloBoardVO lbvo = null;
		
		try{
			con = ConnProperty.getConnection();
			pstmt = con.prepareStatement(LdbHelloBoardSqlMap.getSelectQuery());
			
			pstmt.setString(1, i_lvo.getLno());
			System.out.println("i_lvo.getLno()" + i_lvo.getLno());
			
			rsRs = pstmt.executeQuery();
			
			if(rsRs != null){
				
				aList = new ArrayList<LdbHelloBoardVO>();
				
				while(rsRs.next()){
					lbvo = new LdbHelloBoardVO();
					lbvo.setLno(rsRs.getString("LNO"));
					lbvo.setLsubject(rsRs.getString("LSUBJECT"));
					lbvo.setLname(rsRs.getString("LNAME"));
					lbvo.setLpw(rsRs.getString("LPW"));
					lbvo.setLmemo(rsRs.getString("LMEMO"));
					lbvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lbvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lbvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					aList.add(lbvo);
				}
				System.out.println("aList.size() >>> : " + aList );
			}else{
				System.out.println("�����Ͱ� �����ϴ�.");
			}
			
			LdbConnProperty.conClose(con, pstmt, rsRs);

		}catch(Exception e){
			System.out.println("������ �߻��߽��ϴ� " + e.getMessage());
		}finally{
			LdbConnProperty.conClose(con, pstmt, rsRs);
		}
		
		return aList;
	}


	
}//end of class
