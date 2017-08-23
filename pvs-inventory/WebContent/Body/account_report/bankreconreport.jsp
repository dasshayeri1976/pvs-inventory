<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.OutputStream" %>
<%@page import="com.connection.account.ConnectionDAO" %>
<%@page import="com.helper.account.NumToWord" %> 
<%@ page import="java.sql.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String from=request.getParameter("formbean.frmdate");
String to=request.getParameter("formbean.todate");
String ac=request.getParameter("formbean.accname");
String ccase=request.getParameter("formbean.case1");
String type=request.getParameter("formbean.type");
//out.print("Value got "+from+","+to+","+ac+","+ccase+","+type);
%>

<label>From Date: <%=from %></label><br>
<label>To Date: <%=to %></label><br>
<label>Account: <%=ac %></label><br>
<label>Cheque Case: <%=ccase %></label><br>
<label>Type: <%=type %></label><br>
</body>
</html>