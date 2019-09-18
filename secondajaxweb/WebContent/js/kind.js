function query(){
	$.getJSON('kinds.do',function(data){
		var $tab = $('#tab');
		$tab.find('tr:gt(0)').remove();
		$.each(data,function(i,k){
			var $tr = $('<tr></tr>');
			$("<td class='text-center'>"+(i+1)+'</td>').appendTo($tr);
			$('<td>'+k.name+'</td>').appendTo($tr);
			$('<td>'+k.info+'</td>').appendTo($tr);
			var $a = $("<a href='#'>编辑</a>");
			$a.click(function(){
				get(k.id,k.name,k.info)
			})
			var $td = $('<td class=\"text-center\"></td>');
			$a.appendTo($td);
			$td.appendTo($tr);
			//$("<td class='text-center'><a onclick=\"get("+k.id+",'"+k.name+"','"+k.info+"'"+")\">编辑</a></td>").appendTo($tr);
			$("<td class='text-center'><a onclick='kinddel("+k.id+")'>删除</a></td>").appendTo($tr);
			$('#tab').append($tr);
		})
	})
}

function get(id,name,info){
	$('#id').val(id);
	$('#name').val(name);
	$('#info').val(info)
}

function kinddel(id){
	$.get("kinddel.do",{id:id},function(data){
		if(data){
			query();
		}
	})
}

function save(param){
	$.post("kindsave.do",param,function(data){
		if(data){
			$('#id').val('');
			$('#name').val('');
			$('#info').val('');
			query();
		}
	})
}
$(function(){
	query();
	$("#btn-save").click(function(){
		var id = $('#id').val();
		var name = $('#name').val();
		var info = $('#info').val();
		var param = {
				id:id,name:name,info:info
		}
		save(param);
	})
})