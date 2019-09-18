<%@ page  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/kind.js"></script>
<title>商品类别管理</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top:15px">
			<div class="col-md-1">
				类别名称
			</div>
			<div class="col-md-4">
				<input type="hidden" id="id">
				<input class="form-control" id="name">
			</div>
			<div class="col-md-1">
				备注信息
			</div>
			<div class="col-md-4">
				<input class="form-control" id="info">
			</div>
			<div class="col-md-2">
				<button id="btn-save" class="btn btn-default">保存</button>
			</div>
		</div>
		<div class="row" style="margin-top:15px">
			<div class="col-md-12">
				<div class="table-responsive">
					<table id="tab" class="table table-bordered">
						<tr>
							<th class="text-center">序号</th>
							<th>类别名称</th>
							<th>备注</th>
							<th class="text-center">编辑</th>
							<th class="text-center">删除</th>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>