<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/workbook/css/style.css">
<title>トップページ</title>
</head>
<body>
<div class="dodai">
<h1>トップページ</h1>
<h2>問題集一覧</h2>
<p><a href="/workbook/jsp/newworkbook.jsp?No=1&totalscore=0" class="button" style="font-size:15px;">新規問題集作成</a></p>
<br>
	<c:forEach var="titlelistitem" items="${ titlelist }">
		<input type="hidden" name="title" value="${ titlelistitem.title }" />
		<p><a href="/workbook/workbook_Controller?title=${ titlelistitem.title }&No=1&answer=null"><c:out value="${ titlelistitem.title }" /></a></p>
		<br>
	</c:forEach>
</div>
</body>
</html>