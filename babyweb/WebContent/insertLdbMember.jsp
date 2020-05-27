<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAO" %>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAOImpl" %>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO" %>

<%@ page import = "java.util.ArrayList" %>
 

<% 
	String lname = request.getParameter("lname");
	String lid = request.getParameter("lid");
	String lpw = request.getParameter("lpw");
	String lhp = request.getParameter("lhp");
	String lbirth = request.getParameter("lbirth");
	String lemail = request.getParameter("lemail");
	String lpostno = request.getParameter("lpostno");
	String laddr = request.getParameter("laddr");

	LdbMemberDAO ldao = new LdbMemberDAOImpl();
	LdbMemberVO lvo = null;
	lvo = new LdbMemberVO();
	
	lvo.setLname(lname);
	lvo.setLid(lid);
	lvo.setLpw(lpw);
	lvo.setLhp(lhp);
	lvo.setLbirth(lbirth);
	lvo.setLemail(lemail);
	lvo.setLpostno(lpostno);
	lvo.setLaddr(laddr);
	
	
	boolean bFlag = ldao.insertLdbMember(lvo);
	
	if(bFlag){
%>
		<script>
		 	alert("success");
		 	location.href = "/babyweb/selectLdbMember.jsp";
		</script>

<%
	}else{
%>
		<script>
			alert("fail");
			location.href = "/babyweb/member.html";
		</script>
			
<%
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>³Ö±â</title>
	</head>
	<body>
	
	</body>
	
</html>


