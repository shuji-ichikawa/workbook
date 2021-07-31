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
<div class="dodai">
<p><a href="/workbook/jsp/toppage.jsp">トップページへ戻る</a></p>
<h1>新規問題集作成ページ</h1>
<form method="post" action="/workbook/newworkbook_Controller">
<h2>問題集作成欄</h2>
	<p>・下記を入力して［次へ］をクリックしてください。問題数は最大50問まで作成可能です。</p>
	<p>・問題は選択問題が作成できます。選択肢はA～Dの4つの選択肢を設定できます。</p>
	<br><br>
<h2>タイトル記入欄</h2>
	<p>・問題集のタイトルを記入してください。</p>
	<ul>
		<li>
			タイトル：<input type="text" name="title" placeholder="50文字以内で入力してください。">
			<div class="check"><c:out value="${ msgtitle1 }" /><c:out value="${ msgtitle2 }" /><c:out value="${ msgtitle3 }" /></div>
		</li>
	</ul>
	<br><br>
<h2>問題内容記入欄</h2>
	<p>・問題文の記入と選択肢A～Dの設定をしてください。</p>
	<p>・文字はスペースを含めて2000文字まで入力できます。</p>
	<br><br>
	<h2 style="width:20%; font-size:15pt; margin:0% 0% 5% 0%;"><%int No = Integer.parseInt(request.getParameter("No"));%>
	問<%=No %><input type="hidden" name="No" value="<%=No %>" /></h2>
	<p style="width:20%; margin:0% 0% 0% 0%;">問題文：</p>
	<textarea name="problem" style="width:100%; height:150px" placeholder=
	"例：プロジェクトの特徴として，適切なものはどれか。

     A:期間を限定して特定の目標を達成する。
     B:固定したメンバで，チームを構成し，全工程をそのチームが担当する。
     C:終了時点は決めないで開始し，進捗状況を見ながらそれを決める。
     D:定常的な業務として繰り返し実行される。"></textarea>
	<div class="check"><c:out value="${ msgproblem1 }" /><c:out value="${ msgproblem2 }" /></div>
	<br><br>
<h2>解答設定欄</h2>
	<p>・解答A～Dの内、どれか一つを選択してください。</p>
	<br>
	<input type="radio" name="answer" value="A" class="answer"><label class="answer" for="A">A</label>
	<input type="radio" name="answer" value="B" class="answer"><label class="answer" for="B">B</label>
	<input type="radio" name="answer" value="C" class="answer"><label class="answer" for="C">C</label>
	<input type="radio" name="answer" value="D" class="answer"><label class="answer" for="D">D</label>
	<div class="check"><c:out value="${ msganswer }" /></div>
	<br><br>
<h2>点数</h2>
	<p>・半角数字1～2桁で入力してください。</p>
	<ul>
		<li>
			点数：<input type="text" name="score" style="width:50px;">
			<div class="check"><c:out value="${ msgscore }" /></div>
		</li>
	</ul>
	<br><br>
<%int totalscore = 0;
totalscore = Integer.parseInt(request.getParameter("totalscore"));%>
<p style="font-size: 25px;">現在の合計点数:<%=totalscore %><input type="hidden" name="totalscore" value="<%=totalscore %>" /></p>
<br><br>
<button>次へ</button>
</form>
</div>
</body>
</html>