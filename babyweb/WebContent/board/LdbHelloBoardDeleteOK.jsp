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
	String isudType = request.getParameter("ISUD_TYPE");
	String chkInBno = request.getParameter("chkInBno");
	String lno		= request.getParameter("lno");
	String lsubject = request.getParameter("lsubject");
	String lname 	= request.getParameter("lname");
	String lpw		= request.getParameter("lpw");
	String lmemo	= request.getParameter("lmemo");

	if("DOK".equals(isudType.toUpperCase())){
		System.out.println(" ISUD_TYPE >>> : " + isudType);
	
		LdbHelloBoardDAO lbdao = new LdbHelloBoardDAOImpl();
		
		LdbHelloBoardVO lbvo = null;
		lbvo = new LdbHelloBoardVO();
		
		lbvo.setLno(lno);
		
		int nCntD = lbdao.boardDelete(lbvo);
		
		if(nCntD == 1){
			System.out.println(" 삭제 성공 페이지로 보내기!");
			
			
%>
		<script>
				alert("게시판 글 삭제 성공!");
				location.href = "/babyweb/board/LdbHelloBoardSelect.jsp";
		</script>
			
<%
		}else{
			out.println("에러페이지로 보내기");
		}//end of nCntD ==1
	}//end of DOK if
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>글 삭제 완료</title>
	</head>
	<body>
	
	</body>
</html>