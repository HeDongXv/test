<%@ page pageEncoding="UTF-8" import="cn.lore.Person,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="money" value="1999" scope="page"/>
	<c:set var="money" value="500" scope="request"/>
	<c:set var="money" value="1999" scope="session"/>
	<c:if test="${pageScope.money>=1000}">
		<button>我是按钮</button>
	</c:if>
	
	<%List<Person> persons = new ArrayList<Person>();
	Person p1 = new Person("张三","女",20);
	Person p2 = new Person("刘备","男",10);
	Person p3 = new Person("赵云","女",24);
	Person p4 = new Person("关羽","男",22);
	Person p5 = new Person("朱古力","女",18);
	Person p6 = new Person("诸葛亮","男",16);
	persons.add(p1);
	persons.add(p2);
	persons.add(p3);
	persons.add(p4);
	persons.add(p5);
	persons.add(p6);
	pageContext.setAttribute("persons", persons);
	%>
	<table border="1" width="80%" align="center">
		<tr>
			<th>序号</th><th>姓名</th><th>性别</th><th>年龄</th>
			<c:forEach items="${persons}" var="bean" varStatus="i">
				<tr>
					<td>${i.index}</td>
					<td>${bean.name}</td>
					<td>${bean.sex}</td>
					<td>${bean.age}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>