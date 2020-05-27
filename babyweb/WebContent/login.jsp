<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAO" %>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAOImpl" %>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO" %>

<%@ page import = "java.util.ArrayList" %>

	<% 
 	request.setCharacterEncoding("EUC-KR");
 %>
 

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	System.out.println("id >>> :" + id); 
	System.out.println("pw >>> :" + pw); 
	
	//웹과 백엔드를 연결하는 것
	
	LdbMemberDAO ldao = new LdbMemberDAOImpl(); 
	//dao호출시 lvo값이 null값인지 불러오는 값이 null인지 아닌지 체크해줘야함
	LdbMemberVO lvo = null;
	lvo = new LdbMemberVO();
	lvo.setLid(id);
	lvo.setLpw(pw);
	
	System.out.println("lvo.getLid() >>> : " + lvo.getLid());
	System.out.println("lvo.getLpw() >>> : " + lvo.getLpw());
	
	
	ArrayList<LdbMemberVO> aList = ldao.loginLdbMember(lvo);
	System.out.println(""+ aList.size());
	
	if (aList.size() == 1) {
%> 
	<script> 
			alert("login success  !!");
			location.href="/babyweb/index.html";
	</script>

<% 
	}

	if (aList.size() == 0) {
%>
	<script>
			alert("login fail!");

			location.href="/babyweb/html5.html";
	</script>

<% } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>

	</body>
</html>




