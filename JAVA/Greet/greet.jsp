<%@page language="java" %>
<%@page import="java.util.*,java.text.*" %>
<%
	
	String name = request.getParameter("name");
	
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("HH");
	
	String str = sdf.format(d);
	int time = Integer.parseInt(str);
	
	if(time>=6 && time<=12)
		out.print("Good Morning "+name);
		
	else if(time>=12 && time<=3)
		out.print("Good Afternoon "+name);
		
	else if(time>=3 && time<=8)
		out.print("Good Evening "+name);
		
	else 
		out.print("Good Night "+name);
	

%>
