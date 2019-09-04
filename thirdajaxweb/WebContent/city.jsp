<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("city.do",function(data){
			$.each(data,function(i,c){
				$op = $("<option></option>")
				$op.text(c.name);
				$op.val(c.id);
				$('#city').append($op);
			})
		})
		$('#city').change(function(){
			$.getJSON("area.do",{cid:this.value},function(data){
				$('#area').find("option:gt(0)").remove();
				$.each(data,function(i,a){
					$op = $("<option></option>")
					$op.text(a.name);
					$op.val(a.id);
					$('#area').append($op);
				})
			})
		})
	})
</script>
</head>
<body>
	<select id="city">
		<option>请选择城市</option>
	</select>
	<select id="area">
		<option>请选择区县</option>
	</select>
</body>
</html>