package bitcamp.java142.ch5.ldbjf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.java142.ch5.ldbjf.common.LdbCheabunClass;
import bitcamp.java142.ch5.ldbjf.common.LdbConnProperty;
import bitcamp.java142.ch5.ldbjf.sql.LdbSqlQueryMap;
import bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO;


public class LdbMemberDAOImpl implements LdbMemberDAO {

   @Override
   public boolean insertLdbMember(LdbMemberVO i_lvo) {
      
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.insertLdbMember(LdbMemberVO i_lvo) �Լ� ����  ");
       
      System.out.println("i_lvo �������� �ּҰ� : " + i_lvo );
      
      System.out.println(" " + i_lvo.getLname() + " " +  i_lvo.getLid()+ " " + i_lvo.getLpw()+ " " + i_lvo.getLhp()
                   + " " +  i_lvo.getLbirth() + " " + i_lvo.getLemail() + " " + i_lvo.getLpostno() + " " +  i_lvo.getLaddr());

         
      Connection con = null;
      PreparedStatement pstmt = null;
      
      int nCnt = 0;
      
      try{
         //connetion ���ϱ�
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ���� "); 
         con = LdbConnProperty.getConnection();
         System.out.println("DB �ּ� ����  >>> " + con);
         
         System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
         con.setAutoCommit(false);
         System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
         
         System.out.println("(log) LdbMemberScr.LdbSqlQueryMap.getInsertQuery() �Լ� ���� "); 
         pstmt = con.prepareStatement(LdbSqlQueryMap.getInsertQuery());
         System.out.println("EciSqlQueryMap.getInsertQuery() : \n" 
               + LdbSqlQueryMap.getInsertQuery());    
         
         pstmt.setString(1, LdbCheabunClass.commonNo_LDB_MEMBER());
         pstmt.setString(2, i_lvo.getLname());
         pstmt.setString(3, i_lvo.getLid());
         pstmt.setString(4, i_lvo.getLpw());
         pstmt.setString(5, i_lvo.getLhp());
         pstmt.setString(6, i_lvo.getLbirth());
         pstmt.setString(7, i_lvo.getLemail());
         pstmt.setString(8, i_lvo.getLpostno());
         pstmt.setString(9, i_lvo.getLaddr());
         pstmt.setString(10, "Y");
         
         System.out.println("(log) LdbMemberScr.pstmt.executeUpdate() �Լ� ���� "); 
         nCnt = pstmt.executeUpdate();
         
         System.out.println("���� Ȯ�� >>> " + nCnt);
         
         if(!con.getAutoCommit()) con.commit();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{LdbConnProperty.conClose(con, pstmt);}
         catch(Exception e2){}
      }
      if(nCnt == 0 ) return false;
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.insertLdbMember(LdbMemberVO i_lvo) �Լ� ���� ");
      return true;
   }

   @Override
   public boolean updateLdbMember(LdbMemberVO i_lvo) {
      
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.updateLdbMember(LdbMemberVO i_lvo) �Լ� ����");
      System.out.println(" i_lvo �������� �ּҰ� : " + i_lvo );
      System.out.println(i_lvo.getLpw() + " " +  i_lvo.getLmem());
      
      //�������� �ʱ�ȭ      
      Connection con = null;
      PreparedStatement pstmt = null;
      
      int nCnt = 0;
      
      try
      {   
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ���� "); 
         con = LdbConnProperty.getConnection();
         System.out.println("DB �ּ� ����  >>> " + con);
         
         System.out.println("(log) LdbMemberScr.LdbSqlQueryMap.getUpdateQuery() �Լ� ���� "); 
         pstmt = con.prepareStatement(LdbSqlQueryMap.getUpdateQuery());
         System.out.println("EciSqlQueryMap.getInsertQuery() : \n" 
               + LdbSqlQueryMap.getUpdateQuery());    
         
         pstmt.setString(1, i_lvo.getLpw());
         pstmt.setString(2, i_lvo.getLmem());
         System.out.println(i_lvo.getLpw() + " " + i_lvo.getLmem());
         
         System.out.println("(log) LdbMemberScr.pstmt.executeUpdate() �Լ� ���� "); 
         nCnt = pstmt.executeUpdate();
         System.out.println("nCnt  >>> : " + nCnt);
         
         if(!con.getAutoCommit()) con.commit();
         System.out.println("���� �Ǿ����ϴ� >>> " + nCnt);
         
      }catch(Exception e){
         System.out.println("�����߻�!" + e.getMessage());
      }finally{
         try{LdbConnProperty.conClose(con, pstmt);}catch(Exception e2){
         }
      }
      
      if (nCnt == 0) return false;
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.updateLdbMember(LdbMemberVO i_lvo) �Լ� ����");
      return true;
   }

   @Override
   public boolean deleteLdbMember(LdbMemberVO i_lvo) {
      System.out.print("(log) LdbMemberScr.LdbMemberDAO.deleteLdbMember(LdbMemberVO i_lvo) �Լ� ����");
      System.out.println(" i_lvo �������� �ּҰ� : " + i_lvo );
      System.out.println(i_lvo.getLmem());
      
      //�������� �ʱ�ȭ
      Connection   con         = null;
      PreparedStatement pstmt = null;
      
      int nCnt = 0;
      
      try{
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ���� "); 
         con = LdbConnProperty.getConnection();
         System.out.println("DB �ּ� ����  >>> " + con);
         
         System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
         con.setAutoCommit(false);
         System.out.println("con.getAutoCommit() >>>  " + con.getAutoCommit());
         
         System.out.println("(log) LdbMemberScr.LdbSqlQueryMap.getDeleteQuery() �Լ� ���� "); 
         pstmt = con.prepareStatement(LdbSqlQueryMap.getDeleteQuery());
         System.out.println("EciSqlQueryMap.getDeleteQuery() : \n" 
               + LdbSqlQueryMap.getDeleteQuery());    
                  
         pstmt.setString(1, i_lvo.getLmem());
         
         System.out.println("i_lvo.getLmem() >>> : " + i_lvo.getLmem() );
         System.out.println("i_lvo.getLpw() >>> : " + i_lvo.getLpw());

         
         
         System.out.println("(log) LdbMemberScr.pstmt.executeUpdate() �Լ� ���� "); 
         nCnt = pstmt.executeUpdate();
         System.out.println("nCnt  >>> : " + nCnt);
         
         if (!con.getAutoCommit()) con.commit(); 
            System.out.println("delete �� �Ǿ��� >>> : " + nCnt);
            
            LdbConnProperty.conClose(con, pstmt);

      }catch(Exception e){
      }finally{
         LdbConnProperty.conClose(con, pstmt);
         try{
            LdbConnProperty.conClose(con, pstmt);
         }catch(Exception e2){
            System.out.println("������ �߻��߽��ϴ� >>> : " + e2.getMessage());
         }
            }
      if (nCnt == 0) return false;
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.deleteLdbMember(LdbMemberVO i_lvo) �Լ� ����");
      return true;
   }
   

   @Override
   public ArrayList<LdbMemberVO> selectLdbMember() {
      
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.selectLdbMember() �Լ� ����");

      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rsRs = null;
      ArrayList<LdbMemberVO> aList = null;
      LdbMemberVO lvo = null;
      
      
      try {
         
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ���� ");
         con = LdbConnProperty.getConnection();
         System.out.println(" con >>> : " + LdbConnProperty.getConnection());
         
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getSelectQuery() �Լ� ���� ");
         pstmt = con.prepareStatement(LdbSqlQueryMap.getSelectQuery());
           System.out.println(" LdbSqlQueryMap.getSelectQuery() :: \n" 
                  + LdbSqlQueryMap.getSelectQuery());   
            
          
           System.out.println("(log) LdbMemberScr.pstmt.executeQuery() �Լ� ���� "); 
         rsRs = pstmt.executeQuery();
         System.out.println(" rsRs >>> : " +  rsRs);
         
         if(rsRs != null){
            aList = new ArrayList<LdbMemberVO>();
            while(rsRs.next()){
               lvo = new LdbMemberVO();
               lvo.setLmem(rsRs.getString("LMEM"));
               lvo.setLname(rsRs.getString("LNAME"));
               lvo.setLid(rsRs.getString("LID"));
               lvo.setLpw(rsRs.getString("LPW"));
               lvo.setLhp(rsRs.getString("LHP"));
               lvo.setLbirth(rsRs.getString("LBIRTH"));
               lvo.setLemail(rsRs.getString("LEMAIL"));
               lvo.setLpostno(rsRs.getString("LPOSTNO"));
               lvo.setLaddr(rsRs.getString("LADDR"));
               lvo.setLdeleteYN(rsRs.getString("LDELETEYN"));
               lvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
               lvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
               aList.add(lvo);
            }
            System.out.println("aList.size() >>> : " + aList.size());
         }else{
            System.out.println("�����Ͱ� �����ϴ�");
         }
         
         LdbConnProperty.conClose(con, pstmt, rsRs);
         
      }catch(Exception e){
         System.out.println("������ >>> : " + e.getMessage());
      }finally{
         LdbConnProperty.conClose(con, pstmt, rsRs);
         try{LdbConnProperty.conClose(con, pstmt, rsRs);
         }catch(Exception e2){
            System.out.println("������ �߻��߽��ϴ� >>> : " + e2.getMessage());
         }
      }
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.selectLdbMember() �Լ� ����");
      return aList;
   }

   @Override
   public ArrayList<LdbMemberVO> searchLdbMember(LdbMemberVO i_lvo) {
      System.out.print("(log) LdbMemberScr.searchLdbMember() �Լ� ����");
      System.out.println("i_lvo �������� �ּҰ� : " + i_lvo );
      System.out.println("�Ű����� Ȯ�� : " + i_lvo.getLmem() );
       
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rsRs = null;
      ArrayList<LdbMemberVO> aList = null;
      LdbMemberVO lvo = null;
      
      try{
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ����");
         con = LdbConnProperty.getConnection();
         System.out.println("con >>> : " + con);
         
         System.out.println("(log) LdbMemberScr.LdbConnProperty.prepareStatement.getSearchQuery() �Լ� ����");
         pstmt = con.prepareStatement(LdbSqlQueryMap.getSearchQuery());
           System.out.println("LdbSqlQueryMap.getSearchQuery() :: \n" 
                  + LdbSqlQueryMap.getSearchQuery());
           
           
           pstmt.setString(1, i_lvo.getLmem());
           System.out.println(i_lvo.getLmem());
          
           System.out.println("(log) LdbMemberScr.pstmt.executeQuery() �Լ� ���� "); 
         rsRs = pstmt.executeQuery();
         System.out.println(" rsRs >>> : " +  rsRs);
         
            if(rsRs != null){
               
               aList = new ArrayList<LdbMemberVO>();
               
               while(rsRs.next()){
                  lvo = new LdbMemberVO();
                  lvo.setLmem(rsRs.getString("LMEM"));
                  lvo.setLname(rsRs.getString("LNAME"));
                  lvo.setLid(rsRs.getString("LID"));
                  lvo.setLpw(rsRs.getString("LPW"));
                  lvo.setLhp(rsRs.getString("LHP"));
                  lvo.setLbirth(rsRs.getString("LBIRTH"));
                  lvo.setLemail(rsRs.getString("LEMAIL"));
                  lvo.setLpostno(rsRs.getString("LPOSTNO"));
                  lvo.setLaddr(rsRs.getString("LADDR"));
                  lvo.setLdeleteYN(rsRs.getString("LDELETEYN"));
                  lvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
                  lvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
                  aList.add(lvo);
               }
               System.out.println("aList.size() >>> : " + aList.size());
            }else{
               System.out.println("�����Ͱ� �����ϴ�");
            }
            LdbConnProperty.conClose(con, pstmt, rsRs);
            
            
      }catch(Exception e){
         System.out.println("������ �߻��߽��ϴ� " +  e.getMessage());
      }finally{
         LdbConnProperty.conClose(con, pstmt, rsRs);
      }
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.searchLdbMember() �Լ� ����");
      
      return aList;
   }//end of search

   @Override
   public ArrayList<LdbMemberVO> likeSearchLdbMember(LdbMemberVO i_lvo) {
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.likeSearchLdbMember() �Լ� ����");
      System.out.println("i_lvo �������� �ּҰ� : " + i_lvo );
      System.out.println("�Ű����� Ȯ�� : " + i_lvo.getLmem() );
       
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rsRs = null;
      ArrayList<LdbMemberVO> aList = null;
      LdbMemberVO lvo = null;
      
      try{
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ����");
         con = LdbConnProperty.getConnection();
         System.out.println("con >>> : " + con);
         
         System.out.println("(log) LdbMemberScr.LdbConnProperty.prepareStatement.getLikeSearchQuery() �Լ� ����");
         pstmt = con.prepareStatement(LdbSqlQueryMap.getLikeSearchQuery());
           System.out.println("LdbSqlQueryMap.getLikeSearchQuery() :: \n" 
                  + LdbSqlQueryMap.getLikeSearchQuery());
           
           
           pstmt.setString(1, i_lvo.getLmem());
           System.out.println(i_lvo.getLmem());
          
           System.out.println("(log) LdbMemberScr.pstmt.executeQuery() �Լ� ���� "); 
         rsRs = pstmt.executeQuery();
         
            if(rsRs != null){
               
               aList = new ArrayList<LdbMemberVO>();
               
               while(rsRs.next()){
                  
                  lvo = new LdbMemberVO();
                  lvo.setLmem(rsRs.getString("LMEM"));
                  lvo.setLname(rsRs.getString("LNAME"));
                  lvo.setLid(rsRs.getString("LID"));
                  lvo.setLpw(rsRs.getString("LPW"));
                  lvo.setLhp(rsRs.getString("LHP"));
                  lvo.setLbirth(rsRs.getString("LBIRTH"));
                  lvo.setLemail(rsRs.getString("LEMAIL"));
                  lvo.setLpostno(rsRs.getString("LPOSTNO"));
                  lvo.setLaddr(rsRs.getString("LADDR"));
                  lvo.setLdeleteYN(rsRs.getString("LDELETEYN"));
                  lvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
                  lvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
                  aList.add(lvo);
               }
               System.out.println("aList >>> : " + aList);
               System.out.println("aList.size() >>> : " + aList.size());
            }else{
               System.out.println("�����Ͱ� �����ϴ�");
            }
            
            LdbConnProperty.conClose(con, pstmt, rsRs);
         
      }catch(Exception e){
         System.out.println("������ �߻��߽��ϴ� " +  e.getMessage());
      }finally{
         LdbConnProperty.conClose(con, pstmt, rsRs);
      }

      System.out.println("(log) LdbMemberScr.LdbMemberDAO.likeSearchLdbMember() �Լ� ����");
      
      return aList;
   }

   //�α���
   public ArrayList<LdbMemberVO> loginLdbMember(LdbMemberVO i_lvo){
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.loginLdbMember() �Լ� ����");
      System.out.println("i_lvo �������� �ּҰ� : " + i_lvo );
      System.out.println("�Ű����� Ȯ�� : " + i_lvo.getLid() + " / " + i_lvo.getLpw() );
      
      
      Connection con = null;
      ResultSet rsRs = null;
      PreparedStatement pstmt= null;
      
      ArrayList<LdbMemberVO> aList = null;
      LdbMemberVO lvo = null;
      
      try{
         System.out.println("(log) LdbMemberScr.LdbConnProperty.getConnection() �Լ� ����");
         con = LdbConnProperty.getConnection();
         
         System.out.println("(log) LdbMemberScr.LdbConnProperty.prepareStatement.getLoginQuery() �Լ� ����");
         
         
         
         pstmt = con.prepareStatement(LdbSqlQueryMap.getLoginQuery());
         
         System.out.println("LdbSqlQueryMap.getLoginQuery() >>> " +  LdbSqlQueryMap.getLoginQuery());
         
         pstmt.setString(1, i_lvo.getLid());
         pstmt.setString(2, i_lvo.getLpw());
         
         
         
         System.out.println("���� Ȯ�� " + i_lvo.getLid() + " / " + i_lvo.getLpw() );

         System.out.println("(log) LdbMemberScr.pstmt.executeQuery() �Լ� ���� "); 
         rsRs = pstmt.executeQuery();
         
         if(rsRs != null){
            
            aList = new ArrayList<LdbMemberVO>();
            
            while(rsRs.next()){
               lvo = new LdbMemberVO();
               
               lvo.setLid(rsRs.getString(1));
               lvo.setLpw(rsRs.getString(2));
               lvo.setLdeleteYN(rsRs.getString(3));
               
               aList.add(lvo);
            }
            System.out.println("aList >>> : " + aList);
            System.out.println("aList.size() >>> : " + aList.size());
         }else{
            System.out.print("�����Ͱ� �������� �ʽ��ϴ�!");
         }
         
         
      }catch(Exception e){
         System.out.println("���� �߻� >>> : " + e.getMessage());
      }finally{
         LdbConnProperty.conClose(con, pstmt, rsRs);
      }
      
      System.out.println("(log) LdbMemberScr.LdbMemberDAO.loginLdbMember() �Լ� ����");
      return aList;

   }//end of login
   
}//end of class

