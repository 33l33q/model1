<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="bitcamp.java142.board.dao.LdbHelloBoardDAO"%>
<%@ page import="bitcamp.java142.board.dao.LdbHelloBoardDAOImpl"%>
<%@ page import="bitcamp.java142.board.vo.LdbHelloBoardVO"%>

<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("EUC-KR");
%>

<%
	String isudType = request.getParameter("ISUD_TYPE");
	String chkInBno = request.getParameter("chkInBno");
	System.out.println("isudType >>> : " + chkInBno );
	
	if(isudType != null){
		System.out.println("isudType >>> : " + isudType );
		boolean bool = "D".equals(isudType.toUpperCase());
		
		if(bool){
			LdbHelloBoardDAO lbdao = new LdbHelloBoardDAOImpl();
			System.out.println("lbdao >>> " + lbdao);
			
			LdbHelloBoardVO lbvo = null;
			lbvo = new LdbHelloBoardVO();
			lbvo.setLno(chkInBno);
			
			ArrayList<LdbHelloBoardVO> aListS = lbdao.boardSelect(lbvo);
			int nCnt = aListS.size();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>�� ����</title>
		<script type = "text/javascript">
				function boardDeleteFunction(str){
					var strValue = str;
					alert("strValue >>> : " + strValue);
			
					if('DOK' == strValue){
						document.boardDelete.action ="/babyweb/board/LdbHelloBoardDeleteOK.jsp";
						alert("/babyweb/board/LdbHelloBoardDeleteOK.jsp");
						alert("UOK >> " + document.boardDelete.action);
					}//end of strValue == dok
					
					if('S' == strValue){
						document.boardDelete.action = "/babyweb/board/LdbHelloBoardSelect.jsp";
						alert("/babyweb/board/LdbHelloBoardSelect.jsp");
						alert('S >>> : ' + document.boardDelete.action);
						
					}//end of strValue == sall
					
						document.boardDelete.submit();
					
					}//end of srtValue
			</script>	

	</head>
	<body>
		<center>
		<form name = "boardDelete" method = "POST">
			<table border = "1" align = "center">
<%
			if( 1 >= nCnt) {
				for(int i = 0 ; i < nCnt ; i++){
				LdbHelloBoardVO lbVo = aListS.get(i);
%>
				<tr>
					<td colspan = "2" align = "center">�� �����ϱ�</td>
				</tr>
				<tr>
					<td align = "center"> �۹�ȣ </td>
					<td><input type = "text" name = "lno" id = "lno" size = "20"
					readonly value =<%=lbVo.getLno()%>></td>
				</tr>
				<tr>
					<td align = "center">����</td>
					<td><input type = "text" name = "lsubject" id = "lsubject" size = "53" value=<%=lbVo.getLsubject()%>></td>
				</tr>
				<tr>
					<td align = "center">�̸�</td>
					<td><input type="text" name="lname" id="lname" size="53" disabled value=<%=lbVo.getLname()%>></td>
				</tr>
				<tr>
					<td align = "center">�Է���</td>
					<td><input type="text" name="linsertdate" id="linsertdate" size="53" disabled value=<%=lbVo.getLinsertdate()%>></td>
				</tr>
				<tr>
					<td align = "center">������</td>
					<td><input type="text" name="lupdatedate" id="lupdatedate" size="53" disabled value=<%=lbVo.getLupdatedate()%>></td>
				</tr>
				<tr>
					<td align = "center">����</td>
					<td><textarea name="lmemo" id="lmemo" size = "50" cols = "50" rows = "10" ><%=lbVo.getLmemo()%></textarea></td>
				</tr>
				<tr>
					<td align = "center">��й�ȣ</td>
					<td><input type="password" name="lpw" id="lpw" size="20" >
						<input type="button" id="lpwChek" value="��й�ȣȮ��">
					</td>
				</tr>
<% 		
			}//end of nCnt if		
%>			
	
				<tr>
					<td colspan="2" align = "center">
					<input type = "hidden" name = "ISUD_TYPE" value="DOK">
						<input type = "button" value = "�ۻ���"
						onclick = "boardDeleteFunction('DOK')">
						<input type = "button" value = "�۸��"
						onclick = "boardDeleteFunction('S')">
						
					</td>
				</tr>
	
			</table>
		</form>
<%
			}else{
%>
				<script>
					alert("������ �����Ͱ� �����ϴ�");
				</script>
<% 
						}//end of function
			}else{
					
			}//end of bool if
	}else{
	}//end of isudType if 
%>
		
	</body>
</html>