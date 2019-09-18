<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Ajax</title>
<script type="text/javascript" src="js/jquery 3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btn').click(function(){
			var a = $('#a').val();
			var b = $('#b').val();
			$.get('calc.do',{a:a,b:b},function(data){
				$("#c").val(data);
			})
		})
	})
</script>
</head>
<body> 
	
		<input id="a">+<input id="b">
		<button id="btn">=</button>
		<input id="c">

</body>
</html>