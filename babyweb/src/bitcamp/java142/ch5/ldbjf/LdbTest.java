package bitcamp.java142.ch5.ldbjf;

import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAO;
import bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAOImpl;
import bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO;
//import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LdbTest {
	
	
	  public static void dp(ArrayList<LdbMemberVO> aList){
		  for(int i = 0 ; i < aList.size() ; i++){
		  	LdbMemberVO lvo = aList.get(i);
		  	System.out.print("[" + (i+1) + "] ��³��� >>> " + lvo.getLmem());
		  	System.out.print(" " + lvo.getLname());
		  	System.out.print(" " + lvo.getLid() );
		  	System.out.print(" " + lvo.getLpw());
		  	System.out.print(" " + lvo.getLhp());
		  	System.out.print(" " + lvo.getLbirth());
		  	System.out.print(" " + lvo.getLemail());
		  	System.out.print(" " + lvo.getLpostno());
		  	System.out.print(" " + lvo.getLaddr());
		  	System.out.print(" " + lvo.getLdeleteYN());
		  	System.out.print(" " + lvo.getLinsertdate());
		  	System.out.print(" " + lvo.getLupdatedate() + "\n");
		  }	
	  }
	 public static void main(String args[]){
		 
		 
//		 //�α���
//		System.out.println("(log) LdbMemberScr.main() �α��� ���� ");		 
//		 
//		System.out.println("(log) LdbMemberScr.main() ���� ���� �� �ʱ�ȭ ");
//		String id = "dltoal";
//		String pw = "dltoal1234";
//		
//		System.out.println("(log) LdbMemberScr.�α���() ������ ȣ�� ");
//		LdbMemberDAO ldao = new LdbMemberDAOImpl();
//		LdbMemberVO lvo = null;
//		lvo = new LdbMemberVO();
//		lvo.setLid(id);
//		lvo.setLpw(pw);
//		
//		
//		System.out.println("(log) LdbMemberScr.main() �Լ� ȸ��");
//		System.out.println("(log) LdbMemberScr.main() ������ ���");
//		
//		
//		ArrayList<LdbMemberVO> aList = ldao.loginLdbMember(lvo);
//		System.out.println(""+ aList.size());
//		
//		
//		
//		if(aList.size() == 1) {
//		System.out.println("�α��� ����");
//		}else{
//		System.out.println("�α��� ����");
//		}
		 
		 //��ü ��ȸ
		 
//		 System.out.println("(log) LdbMemberScr.main() �α��� ���� ");	
//		 LdbMemberDAO ldao = new LdbMemberDAOImpl();
//		 
//		 System.out.println("(log) LdbMemberScr.main.��ü��ȸ() ������ ȣ�� ");
//		 ArrayList<LdbMemberVO> aList = ldao.selectLdbMember();
//		 
//		 System.out.println("(log) LdbMemberScr.main() �Լ� ȸ��");
//		 System.out.println("(log) LdbMemberScr.main() ������ ���");
//		 
//		 if(aList.size() == 0){
//			 System.out.println("NO DATA");
//		 }else{
//			 
//			for(int i = 0 ; i < aList.size(); i++){
//				LdbMemberVO lvo = aList.get(i);
//			  	System.out.print("[" + (i+1) + "] ��³��� >>> " + lvo.getLmem());
//			  	System.out.print(" " + lvo.getLname());
//			  	System.out.print(" " + lvo.getLid() );
//			  	System.out.print(" " + lvo.getLpw());
//			  	System.out.print(" " + lvo.getLhp());
//			  	System.out.print(" " + lvo.getLbirth());
//			  	System.out.print(" " + lvo.getLmail());
//			  	System.out.print(" " + lvo.getLpostnum());
//			  	System.out.print(" " + lvo.getLjuso());
//			  	System.out.print(" " + lvo.getLdeleteYN());
//			  	System.out.print(" " + lvo.getLinsertdate());
//			  	System.out.print(" " + lvo.getLupdatedate() + "\n");
//	  
//		  }
//		 
//		 }
//		//�Է�
		 
//		//�˻�
//		 
//		 	System.out.println("�˻��� ȸ�� ��ȣ�� �Է��ϼ���");
//		 	Scanner sc = new Scanner(System.in);
//		 	
//		 	String lmem = sc.nextLine();
//		 			 	
//			LdbMemberDAO ldao = new LdbMemberDAOImpl();
//			LdbMemberVO lvo_S = new LdbMemberVO();
//			lvo_S.setLmem(lmem);
//			
//			ArrayList<LdbMemberVO> aList = ldao.searchLdbMember(lvo_S);
//			
//			if(aList.size() == 0){
//				System.out.println("fail");
//				
//			}else{
//				for(int i = 0 ; i < aList.size() ;i++){
//					LdbMemberVO lvo = aList.get(i);
//				  	System.out.print("[" + (i+1) + "] ��³��� >>> " + lvo.getLmem());
//				  	System.out.print(" " + lvo.getLname());
//				  	System.out.print(" " + lvo.getLid() );
//				  	System.out.print(" " + lvo.getLpw());
//				  	System.out.print(" " + lvo.getLhp());
//				  	System.out.print(" " + lvo.getLbirth());
//				  	System.out.print(" " + lvo.getLmail());
//				  	System.out.print(" " + lvo.getLpostnum());
//				  	System.out.print(" " + lvo.getLjuso());
//				  	System.out.print(" " + lvo.getLdeleteYN());
//				  	System.out.print(" " + lvo.getLinsertdate());
//				  	System.out.print(" " + lvo.getLupdatedate() + "\n");
//					
//				}
//			}
//		 
		
		 //������Ʈ
		 
		 
		Scanner sc = new Scanner(System.in);
		String strV = sc.nextLine();
		
		String str[] = strV.split(",");
		String lmem  = str[0].toString();
		String lpw   = str[1].toString();
		
		LdbMemberDAO ldao = new LdbMemberDAOImpl();
		LdbMemberVO lvo = new LdbMemberVO();
		
		lvo.setLmem(lmem);
		lvo.setLpw(lpw);
		
		boolean bFlag = ldao.updateLdbMember(lvo);
		
		System.out.println("(log)" + lvo.getLpw() + " : " + lvo.getLmem());
		
		if(bFlag){
			System.out.println("���� ����!");
		}else{
			System.out.println("���� ����!");
		}
		
		
		
		 
		 
		 
		 
		 
		 		 
	 }//end of main

}//end of class
