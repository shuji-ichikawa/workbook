<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/workbook/css/style.css">
<title>新規問題集作成ページ</title>
</head>
<body>
<%int No = (int)session.getAttribute("No");%>
<div class="dodai">
<p>・問題作成を完了する場合は［完了］、中止する場合は［中止］、継続する場合は［継続］をクリックしてください。</p>
<p>・［完了］をクリックすると作成中の問題を保存してトップページへ戻ります。</p>
<p>・［中止］をクリックすると作成中の問題を保存せずにトップページへ戻ります。</p>
<p>・［継続］をクリックすると新規問題集作成ページへ戻り、引き続き問題を作成できます。</p>
<a href="/workbook/newworkbook_Controller?pattern=1" class="button">完了</a>
<a href="/workbook/newworkbook_Controller?pattern=2" class="button">中止</a>
<c:choose>
	<c:when test="${No > 50}"></c:when>
	<c:otherwise><a href="/workbook/newworkbook_Controller?pattern=3" class="button">継続</a></c:otherwise>
</c:choose>
</div>
</body>
</html>