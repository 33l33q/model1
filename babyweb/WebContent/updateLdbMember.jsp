<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAO" %>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.dao.LdbMemberDAOImpl" %>
<%@ page import =  "bitcamp.java142.ch5.ldbjf.vo.LdbMemberVO" %>

<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>회원정보업데이트</title>
	</head>
	<body>
<%
			String lmem = request.getParameter("lmem");
			String lpw = request.getParameter("lpw");
			
			LdbMemberDAO ldao = new LdbMemberDAOImpl();
			LdbMemberVO lvo = new LdbMemberVO();
			
			lvo.setLmem(lmem);
			lvo.setLpw(lpw);
		
			boolean bFlag = ldao.updateLdbMember(lvo);
			
			if(bFlag){
%>
				<script>
					alert("success"); 
					location.href = "/babyweb/searchLdbMember.jsp?lmem=<%=lmem%>";
					alert(location.href);
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
			
	</body>
</html>

