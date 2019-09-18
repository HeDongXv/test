<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品类别信息</title>
<style>
	.table{
		border-top:1px solid #ccc;
		border-left:1px solid #ccc;
		width:90%;
	}
	.table td,th{
		border-bottom:1px solid #ccc;
		border-right:1px solid #ccc;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>商品类别列表</h1>
	<hr>
	<table class="table" align="center" cellspacing="0">
		<tr>
			<th>序号</th><th>类别名称</th><th>编辑</th><th>删除</th>
		</tr>
		<c:forEach items="${kinds}" var="k" varStatus="i">
			<tr>
				<td>${i.index+1}</td>
				<td>${k.name }</td>
				<td><a href="kind.do?id=${k.id }">编辑</a></td>
				<td><a href="kindremove.do?id=${k.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align:center">
		<a href="kind.jsp">添加商品类别</a>
	</div>
</body>
</html>