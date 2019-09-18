<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="kind.do" method="post">
		<input name="id" type="hidden" value="${kind.id}">
		<label>请输入商品类别：</label>
		<input name="name" value="${kind.name }" placeholder="请输入商品类别名称">
		<button>保存</button>
	</form>
</body>
</html>