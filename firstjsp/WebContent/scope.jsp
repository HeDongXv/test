<%@ page pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
	<h2>JSP的4个作用域</h2>
	<ol>
		<li>页面作用域        pageConext</li>
		<li>请求作用域        request</li>
		<li>会话作用域        session</li>
		<li>应用程序作用域 application</li>
	</ol>
	<%
		/*
		request.setAttribute("", arg1);
		request.getAttribute("");
		request.removeAttribute("");
		
		session.setAttribute("", arg1);
		session.getAttribute("");
		session.removeAttribute("");
		
		application.setAttribute("", arg1);
		application.getAttribute("");
		application.removeAttribute("");
		*/
	%>
	<hr>
	<% 
		Integer money = (Integer)pageContext.getAttribute("money");
		if(money==null){
			money = 1;
		}else{
			money = money+1;
		}
		out.print("页面作用域中的Money:"+money);
		pageContext.setAttribute("money", money);
		out.print("<br/>");
		
		Integer money2 = (Integer)request.getAttribute("money2");
		if(money2==null){
			money2 = 1;
		}else{
			money2 = money2+1;
		}
		out.print("请求作用域中的Money:"+money2);
		request.setAttribute("money2", money2);
		out.print("<br/>");
		
		Integer money3 = (Integer)session.getAttribute("money3");
		if(money3==null){
			money3 = 1;
		}else{
			money3 = money3+1;
		}
		out.print("会话作用域中的Money:"+money3);
		session.setAttribute("money3", money3);
		out.print("<br/>");
		
		Integer money4 = (Integer)application.getAttribute("money4");
		if(money4==null){
			money4 = 1;
		}else{
			money4 = money4+1;
		}
		out.print("全局作用域中的Money:"+money4);
		application.setAttribute("money4", money4);
		out.print("<br/>");
	%>
<%@ include file="footer.jsp"%>