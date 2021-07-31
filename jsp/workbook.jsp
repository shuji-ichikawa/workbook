<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%String title = (String)session.getAttribute("title");
int No = (int)session.getAttribute("No");
String problem = (String)session.getAttribute("problem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/workbook/css/style2.css">
<title><%=title %></title>
</head>
<body>
<div class="dodai">
<form method="post" action="/workbook/workbook_Controller">
<h1><%=title %><input type="hidden" name="title" value="<%=title %>" /></h1>
<br>
<h2>問<%=No %><input type="hidden" name="No" value="<%=No %>" /></h2>
<c:forEach var="problemlistitem" items="${ problemlist}" begin="<%=No-1 %>" end="<%=No-1 %>" step="1">
	<p><input type="hidden" name="shohin_mei" value="${ problemlistitem.problem }" />
		<c:out value="${ problemlistitem.problem }" /></p>
</c:forEach>
<p><input type="radio" name="answer" value="A">A
   <input type="radio" name="answer" value="B">B
   <input type="radio" name="answer" value="C">C
   <input type="radio" name="answer" value="D">D</p>
<%if(No==50){%>
<button>選択</button>
<a href="/workbook/workbook_result_Controller?No=<%=No %>&title=<%=title %>" class="button">終了</a>
<%}else{%>
<button>次へ</button>
<a href="/workbook/workbook_result_Controller?No=<%=No %>&title=<%=title %>" class="button">終了</a>
<%}%>
</form>
<br>
<table border="1">
<tr>
<%for(int i = 1; i <= 25; i++){%>
	<th><a href="/workbook/workbook_move_Controller?No=<%=i %>&title=<%=title %>">問<%=i %></a></th>
<%}%>
</tr>
<tr>
<c:forEach var="answerlistitem" items="${answerlist }" begin="1" end="25" step="1">
	<td height="20"><c:out value="${ answerlistitem }" /></td>
</c:forEach>
</tr>
<tr>
<%for(int i = 26; i <= 50; i++){%>
	<th><a href="/workbook/workbook_move_Controller?No=<%=i %>&title=<%=title %>">問<%=i %></a></th>
<%}%>
</tr>
<tr>
<c:forEach var="answerlistitem" items="${answerlist }" begin="26" end="50" step="1">
	<td height="20"><c:out value="${ answerlistitem }" /></td>
</c:forEach>
</tr>
</table>
</div>
</body>
</html>