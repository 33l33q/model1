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
		<title>select</title>
	</head>
	<body>
	
<%
	LdbMemberDAO ldao = new LdbMemberDAOImpl();
	
	ArrayList<LdbMemberVO> aList = ldao.selectLdbMember();
	
	if(aList.size() == 0) {
	
%>
<table border = "1">
	<tr>
		<td>NO DATA</td>
	</tr>
</table>

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
	for ( int i = 0 ; i < aList.size() ; i++){
		LdbMemberVO lvo = aList.get(i);
%>
	<tr>
		<td><%=lvo.getLmem()%></td>
		<td><%=lvo.getLname()%></td>
		<td><%=lvo.getLid()%></td>
		<td><%=lvo.getLpw()%></td>
		<td><%=lvo.getLhp()%></td>
		<td><%=lvo.getLbirth()%></td>
		<td><%=lvo.getLemail()%></td>
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


			<a href="../../babyweb/board/LdbHelloBoardSelect.jsp">게시판</a><br>
			<a href="../babyweb/html5.html">홈페이지</a><br>
</table>
	</body>
</html>