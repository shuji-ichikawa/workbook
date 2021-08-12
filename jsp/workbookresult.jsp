<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%int totalscore = (int)session.getAttribute("totalscore");
int total = (int)session.getAttribute("total");
String title = (String)session.getAttribute("title");
int No = (int)session.getAttribute("No");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/workbook/css/style2.css">
<title>採点</title>
</head>
<body>
<div class="dodai">
<h1>テスト結果</h1>
<br>
<table border="1">
<tr>
<th></th>
<%for(int i = 1; i <= 25; i++){%>
	<th height="20" width="50">問<%=i %></th>
<%}%>
</tr>
<tr>
<td  height="20" width="50">解答</td>
<c:forEach var="answerlistitem" items="${answerlist }" begin="1" end="25" step="1">
	<td height="20" width="50"><c:out value="${ answerlistitem }" /></td>
</c:forEach>
</tr>
<tr>
<td  height="20" width="50">正解</td>
<c:forEach var="newworkbooklist" items="${newworkbooklist }" begin="0" end="24" step="1">
	<td height="20" width="50"><c:out value="${ newworkbooklist.answer }"/></td>
</c:forEach>
</tr>
<tr>
<td  height="20" width="50">判定</td>
<c:forEach var="judglist" items="${ judglist }" begin="0" end="24" step="1">
	<td height="20" width="50"><c:out value="${ judglist }"/></td>
</c:forEach>
</tr>
<tr>
<td  height="20" width="50">点数</td>
<c:forEach var="newworkbooklist" items="${newworkbooklist }" begin="0" end="24" step="1">
	<td height="20" width="50"><c:out value="${ newworkbooklist.score }"/></td>
</c:forEach>
</tr>
</table>
<table border="1">
<tr>
<th></th>
<%for(int i = 26; i <= 50; i++){%>
	<th height="20" width="50">問<%=i %></th>
<%}%>
</tr>
<tr>
<td  height="20" width="50">解答</td>
<c:forEach var="answerlistitem" items="${answerlist }" begin="26" end="50" step="1">
	<td height="20" width="50"><c:out value="${ answerlistitem }"/></td>
</c:forEach>
</tr>
<tr>
<td  height="20" width="50">正解</td>
<c:forEach var="newworkbooklist" items="${newworkbooklist }" begin="25" end="49" step="1">
	<td height="20" width="50"><c:out value="${ newworkbooklist.answer }"/></td>
</c:forEach>
</tr>
<tr>
<td  height="20" width="50">判定</td>
<c:forEach var="judglist" items="${ judglist }" begin="25" end="49" step="1">
	<td height="20" width="50"><c:out value="${ judglist }"/></td>
</c:forEach>
</tr>
<tr>
<td  height="20" width="50">点数</td>
<c:forEach var="newworkbooklist" items="${newworkbooklist }" begin="25" end="49" step="1">
	<td height="20" width="50"><c:out value="${ newworkbooklist.score }" /></td>
</c:forEach>
</tr>
<tr>
<td height="20" width="50">合計点数</td>
<td height="20" width="50" colspan="2"><%=totalscore %>/<%=total %></td>
</tr>
</table>
<a href="/workbook/jsp/toppage.jsp" class="button">終了</a>
</div>
</body>
</html>