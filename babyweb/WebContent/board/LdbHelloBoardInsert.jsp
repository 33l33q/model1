<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import =  "bitcamp.java142.board.dao.LdbHelloBoardDAO" %>
<%@ page import =  "bitcamp.java142.board.dao.LdbHelloBoardDAOImpl" %>
<%@ page import =  "bitcamp.java142.board.vo.LdbHelloBoardVO" %>

<%@ page import = "java.util.ArrayList" %>

<%
	request.setCharacterEncoding("EUC-KR");
%>

<%

	System.out.println("LdbHelloBoardInsert.jsp ����");

	String isudType = request.getParameter("ISUD_TYPE");
	String chkInBno = request.getParameter("chkInBno");
	String lno 		= request.getParameter("lno");
	String lsubject = request.getParameter("lsubject");
	String lname 	= request.getParameter("lname");
	String lpw 		= request.getParameter("lpw");
	String lmemo 	= request.getParameter("lmemo");
	 
	System.out.println(" " + isudType+ " "  + " " + lno + " " + lsubject + " "  + lname + " " + lpw + " " + lmemo );
	
	if( isudType !=  null){
		System.out.println("isudType >>> : " + isudType);
		boolean boo1 = "I".equals(isudType.toUpperCase());
			
		if (boo1){
			
			LdbHelloBoardDAO lbdao = new LdbHelloBoardDAOImpl();
			System.out.println("lbdao >>> : " + lbdao);
			
			LdbHelloBoardVO lbvo = null;
					
			lbvo = new LdbHelloBoardVO();
			
			lbvo.setLsubject(lsubject);
			lbvo.setLname(lname);
			lbvo.setLpw(lpw);
			lbvo.setLmemo(lmemo);
			lbvo.setLdeleteyn("Y");
			
			int nCnt = lbdao.boardInsert(lbvo);
			
			if(nCnt >= 1){
		%>
				<script>
					alert("�Խñ� �Է� ����!");
					location.href = "/babyweb/board/LdbHelloBoardSelect.jsp";
				</script>
		
		<%
			}else {
				
		%>
				<script>
					alert("�Խñ� �Է� ����");
					location.href = "/babyweb/board/LdbHelloBoard.html";
				</script>
		<%
			}
		}else{
			out.println("ISUD_TYPE�� �� �ѱ⼼��");
		}
		
}
	%>
    
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� �Է�</title>
</head>
<body>

</body>
</html>