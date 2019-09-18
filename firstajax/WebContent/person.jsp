<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery 3.4.1.js"></script>
<script type="text/javascript">
	$.getJSON('person.do',function(data){
		$.each(data,function(i,p){
			$('div').eq(i).find('input:eq(0)').val(p.name);
			$('div').eq(i).find('input:eq(1)').val(p.sex);
			$('div').eq(i).find('input:eq(2)').val(p.age);
			$('div').eq(i).find('input:eq(3)').val(p.addr);
		})
	})
</script>
</head>
<body>
	<div id="p1">
		<input><br>
		<input><br>
		<input><br>
		<input><br>
	</div>
	<div id="p2">
		<input><br>
		<input><br>
		<input><br>
		<input><br>
	</div>
	<div id="p3">
		<input><br>
		<input><br>
		<input><br>
		<input><br>
	</div>
</body>
</html>