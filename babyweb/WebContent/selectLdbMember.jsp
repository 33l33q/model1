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

		<center>		
			<table border ="1" width="800px">
					<tr>
						<td colspan ="15" align = "center" ><h3>ȸ������</h3></td>
					</tr>
					<tr>
						<td>ȸ����ȣ</td>
						<td>�̸�</td>
						<td>���̵�</td>
						<td>��й�ȣ</td>
						<td>��ȭ��ȣ</td>
						<td>�̸���</td>
						<td>�������</td>
						<td>�����ȣ</td>
						<td>�ּ�</td>
						<td>�����</td>
						<td>������</td>
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
						<td><%=lvo.getLemail()%></td>
						<td><%=lvo.getLbirth()%></td>
						<td><%=lvo.getLpostno()%></td>
						<td><%=lvo.getLaddr() %>
						<td><%=lvo.getLinsertdate()%></td>
						<td><%=lvo.getLupdatedate()%></td>
					</tr>
					
<%
					}
				}
%>
							
					<tr>
						<td colspan="12" align="right"> 
								<a href="../../babyweb/board/LdbHelloBoardSelect.jsp">�Խ���</a> <a href="../babyweb/html5.html">Ȩ������</a>
						</td>
					</tr>
				</table>
		</center>
	</body>
</html>