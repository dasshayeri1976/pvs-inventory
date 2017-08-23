<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String name=" subir ";
	String ch[]={ "A","B","C","D","E","F","G","H","I","J",
				 "K","L","M","N","O","P","Q","R","S","T","U",
				 "V","W","X","Y","Z","0","1","2","3","4","5",
				 "6","7","8","9" 
				 };//35 character from 0 to 35
	
	String name1=name.trim();
	String up=name1.toUpperCase();
	char name_first=up.charAt(0);
	for(int i=0; i<=35; i++)
	{
		out.println(name_first+ch[i].length());
	}
	/*String name2="college";
	for(int j=0;j<name2.length();j++)
	{
		out.println(name2.charAt(j));
		out.println();
	}
	*/
	String name3="SA";
	int val=25;
	String f="0";
	for(int i=1;i<=val;i++)
	{
		if(val > 0 && val < 10)
		{
			f="00";
		}
		else
		if(val > 9 && val < 100 )
		{
			f="0";
		}
	}
	out.println(name3+f+val);
	String s="sourav";
	out.println(s.substring(0,4));
	
%>
</body>
</html>