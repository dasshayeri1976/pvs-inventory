<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show data what got</title>
</head>
<body>
<%
	try
	{
		String name[]=request.getParameterValues("name");
		String add[]=request.getParameterValues("add");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		Statement smt=con.createStatement();
		ResultSet rs;
		
		for(int i=0;i<name.length;i++)
		{
			System.out.println(name[i]+"		"+add[i]);	
			System.out.println();
			smt.executeUpdate("insert into test(name, address) values('"+name[i]+"', '"+add[i]+"')");
		}		
	}  
	catch(Exception h)	 
	{
		System.out.println(h);
	}
%>
</body>
</html>