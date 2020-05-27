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
		<title>search</title>
	</head>
	<body>
<%
	String lmem = request.getParameter("lmem");

	LdbMemberDAO ldao = new LdbMemberDAOImpl();
	LdbMemberVO lvo_S = new LdbMemberVO();
	lvo_S.setLmem(lmem);
	
	ArrayList<LdbMemberVO> aList = ldao.searchLdbMember(lvo_S);
	
	if(aList.size() == 0){
		
%>

		<script>
			alert("fail");
			location.href = "/babyweb/member.html";
		</script>
	
<%
	}else{
%>

	<table border ="1">
	<tr>
		<td colspan ="16" align = "center"><h3>회원정보</h3></td>
	</tr>
	<tr>
		<td>회원번호</td>
		<td>이름</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>전화번호</td>
		<td>이메일</td>
		<td>생년월일</td>
		<td>우편번호</td>
		<td>주소</td>
		<td>저장여부</td>
		<td>등록일</td>
		<td>수정일</td>
	</tr>
	
<%

		for(int i = 0 ; i < aList.size() ; i++){
			LdbMemberVO lvo = aList.get(i);
				
%>

	<tr>
		<td><%=lvo.getLmem()%></td>
		<td><%=lvo.getLname()%></td>
		<td><%=lvo.getLid()%></td>
		<td><%=lvo.getLpw()%></td>
		<td><%=lvo.getLhp()%></td>
		<td><%=lvo.getLbirth()%></td>
		<td><%=lvo.getLemail() %></td>
		<td><%=lvo.getLpostno()%></td>
		<td><%=lvo.getLaddr() %>
		<td><%=lvo.getLdeleteYN()%></td>
		<td><%=lvo.getLinsertdate()%></td>
		<td><%=lvo.getLupdatedate()%></td>
	</tr>
<%
			}
	}
%>
		</table>		
	</body>
</html>
