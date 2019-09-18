var service = {
				query:function(){
					$('#tb').empty();
					let that = this;
					$.getJSON("kind/query.do",function(data){
						$.each(data,function(i,k){
							$tr = $('<tr></tr>');
							$td1 = $("<td>"+(i+1)+"</td>");
							$td2 = $("<td>"+k.name+"</td>");
							$td3 = $("<td>"+k.icon+"</td>");
							$td4 = $("<td>"+k.info+"</td>");
							$td5 = $("<td class='text-center'></td>");
							$btn1 = $("<button class='btn btn-info btn-sm'>编辑</button>");
							$btn1.click(function(){
								$('#id').val(k.id);
								$('#name').val(k.name);
								$('#icon').val(k.icon);
								$('#info').val(k.info);
							})
							$btn1.appendTo($td5);
							$td6 = $("<td class='text-center'></td>");
							$btn2 = $("<button class='btn btn-danger btn-sm'>删除</button>");
							$btn2.click(function(){
								that.remove(k.id);
							})
							$btn2.appendTo($td6);
							$tr.append($td1);
							$tr.append($td2);
							$tr.append($td3);
							$tr.append($td4);
							$tr.append($td5);
							$tr.append($td6);
							$tr.appendTo("#tb")
						})
					})
				},
				remove:function(id){
					let that = this;
					$.get('kind/remove.do',{id:id},function(data){
						if(data){
							that.query();
						}else{
							$('#msg').text("保存失败，请重试！")
						}
					})
				},
				save:function(kind){
					let that = this;
					that.clear();
					//判断json中是否为空
						$.post("kind/save.do", kind, function(data) {
							if (data) {
								that.query();
							} else {
								$('#msg').text("保存失败，请重试！")
							}
						})	
					
				},
				clear:function(){
					$('#id').val('');
					$('#name').val('');
					$('#icon').val('');
					$('#info').val('');
				}
		}
		$(function(){
			service.query();
			$('#btnsave').click(function(){
				var kind = {
						id:$('#id').val(),
						name:name,
						icon:$('#icon').val(),
						info:$('#info').val()
					}
				service.save(kind);
			})
			
		})