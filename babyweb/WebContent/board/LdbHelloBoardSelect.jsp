<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import =  "bitcamp.java142.board.dao.LdbHelloBoardDAO" %>
<%@ page import =  "bitcamp.java142.board.dao.LdbHelloBoardDAOImpl" %>
<%@ page import =  "bitcamp.java142.board.vo.LdbHelloBoardVO" %>

<%@ page import = "java.util.ArrayList" %>

<%
	request.setCharacterEncoding("EUC-KR");
	response.setContentType("text/html; charset=EUC-KR");
%>

<!-- readonly(사용불가, 데이터 서버로 전송가능) -disable(사용불가, 데이터 서버로 전송불가)  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>게시글 목록</title>
		<style type="text/css">
			.tt{
			text-align : center;
			font-weight : bold;
			}
		</style>
		<script type = "text/javascript">
			function boardFunction(str){
				var strValue = str ;
				alert(strValue);
				
				if('I' == strValue){
					document.boardForm.action =
						"/babyweb/board/LdbHelloBoard.html";
					alert('I >>> : ' + document.boardForm.action);
		
				}
				if ('S' == strValue){
					document.boardForm.ISUD_TYPE.value = "S";
					document.boardForm.action = "/babyweb/board/LdbHelloBoardSelect.jsp"
					alert(' S >>> : ' + document.boardForm.action);
				}			
				if ('U' == strValue){
					document.boardForm.ISUD_TYPE.value = "U";
					document.boardForm.action = "/babyweb/board/LdbHelloBoardUpdate.jsp"
					alert(' U >>> : ' + document.boardForm.action);
				}
				if ('D' == strValue){
					document.boardForm.ISUD_TYPE.value = "D";
					document.boardForm.action = "/babyweb/board/LdbHelloBoardDelete.jsp"
					alert(' D >>> : ' + document.boardForm.action);				
				}
				
				if ('H' == strValue){
					document.boardForm.ISUD_TYPE.value = "D";
					document.boardForm.action = "/babyweb/index.html"
					alert(' D >>> : ' + document.boardForm.action);				
				}
				
				document.boardForm.submit();
			}
		</script>
	</head>
	<body>
<%
		LdbHelloBoardDAO lbdao = new LdbHelloBoardDAOImpl();
		ArrayList aListAll = lbdao.boardSelectAll();
		System.out.println("lbdao >>> : " + lbdao);
		int nCnt = aListAll.size();
	
%>
	<center>
			<form name="boardForm" method="POST">
		<table border="1" align="center" width = "1000px">
			<thead>
			<tr>
				<td colspan="10" align="center">
					<h2>게시판</h2>
				</td>
			</tr>
			<tr>				
				<td colspan="10" align="right">																					
					<input type="button" value="글쓰기" onclick="boardFunction('I')">
					<input type="button" value="글목록" onclick="boardFunction('SALL')">
					<input type="button" value="글수정" onclick="boardFunction('U')">
					<input type="button" value="글삭제" onclick="boardFunction('D')">														
				</td>								
			</tr>					
			<tr>
				<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
				<td class="tt">글번호</td>
				<td class="tt">제목</td>
				<td class="tt">이름</td>
				<td class="tt">내용</td>
				<td class="tt">입력일</td>
				<td class="tt">수정일</td>			
			</tr>
			</thead>
				 
<%				  							
			for (int i=0; i < nCnt; i++)
			{
				LdbHelloBoardVO lbVo = (LdbHelloBoardVO)aListAll.get(i);						
%>
				<tbody>
				<tr>
					<td align="center">
						<input type="checkbox" name="chkInBno" 
								id="chkInBno"  value=<%= lbVo.getLno()%>
						 	    onclick="checkOnly(this)">
					</td>
					<td align="center"><%= lbVo.getLno() %></td>
					<td align="center"><%= lbVo.getLsubject() %></td>
					<td align="center"><%= lbVo.getLname() %></td>
					<td align="center"><%= lbVo.getLmemo() %></td>		
					<td align="center"><%= lbVo.getLinsertdate() %></td>
					<td align="center"><%= lbVo.getLupdatedate() %></td>			
				</tr>			
<% 			  						 
			}	
		
%>
				<tr>
					<td colspan="10" align="right">	
						<input type="hidden" name="ISUD_TYPE">		
						
						<input type="button" value="홈페이지" onclick="boardFunction('H')">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																
						<input type="button" value="글쓰기" onclick="boardFunction('I')">
						<input type="button" value="글목록" onclick="boardFunction('SALL')">
						<input type="button" value="글수정" onclick="boardFunction('U')">
						<input type="button" value="글삭제" onclick="boardFunction('D')">					
					</td>					
				</tr>
				</tbody>								
		</table>
		</form>
	
	</center>

	</body>
</html>