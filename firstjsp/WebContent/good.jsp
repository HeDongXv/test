<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>商品信息录入</title>
</head>
<body>
	<h2>商品信息录入</h2>
	<hr>
	<form action="goods.do" method="post">
		<input name="id" type="hidden" value="${good.id}">
		<label>商品名称</label>
		<input name="name" value="${good.name}" placeholder="请输入商品名称"><hr>
		<label>商品类别</label>
		<select name="kid">
			    <option value="0">请选择商品类别</option>
				<option value="7">通讯设备</option>
				<option value="8">服饰</option>
				<option value="9">玩具</option>
				<option value="10">电脑</option>
				<option value="12">食物</option>
		</select><hr>
		<label>商品型号</label>
		<input name="size" value="${good.size}" placeholder="请输入商品型号"><hr>
		<label>商品价格</label>
		<input name="price"value="${good.price}" placeholder="请输入商品价格"><hr>
		<label>商品品牌</label>
		<input name="brand"value="${good.brand}" placeholder="请输入商品品牌"><hr>
		<label>商品产地</label>
		<input name="addr" value="${good.addr}"placeholder="请输入商品产地"><hr>
		<label>商品详情</label>
		<input name="info" value="${good.info}"placeholder="请输入商品详情"><hr>
		<button>保存</button>
	</form>
</body>
</html>