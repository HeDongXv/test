<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>商品信息列表</title>
<style type="text/css">
	.table{
		border-top:1px solid #ccc;
		border-left:1px solid #ccc;
		width:90%;
	}
	.table th,td{
		border-bottom:1px solid #ccc;
		border-right:1px solid #ccc;
		text-align:center;
	}
</style>
</head>
<body>
	<h1>商品信息列表</h1>
	<hr>
	<table class="table" align="center" cellspacing="0">
		<tr>
			<th>序号</th><th>商品名称</th><th>商品类别</th><th>商品型号</th><th>商品价格</th><th>商品品牌</th><th>商品产地</th><th>商品详情</th><th>删除</th>
		</tr>
		<c:forEach items="${goods}" var="g" varStatus="i">
			<tr>
				<td>${i.index+1}</td>
				<td>${g.name}</td>
				<td>${g.kname}</td>
				<td>${g.size}</td>
				<td>${g.price}</td>
				<td>${g.brand}</td>
				<td>${g.addr}</td>
				<td><a href="goods.do?id=${g.id}">详情</a></td>
				<td><a href="goodsremove.do?id=${g.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>