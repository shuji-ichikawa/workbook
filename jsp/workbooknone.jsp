<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String title = (String)session.getAttribute("title");
int No = (int)session.getAttribute("No");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/workbook/css/style2.css">
<title><%=title %></title>
</head>
<body>
<div class="dodai" style="width:800px;">
<h2>問<%=No %></h2>
<form method="post" action="/workbook/workbook_Controller">
<p>問題が登録されていません。</p>
<a href="/workbook/workbook_move_Controller?No=<%=No-1 %>&title=<%=title %>" class="button">問題文に戻る</a>

<a href="/workbook/workbook_result_Controller?No=<%=No %>&title=<%=title %>" class="button">終了</a>
</form>
</div>
</body>
</html>