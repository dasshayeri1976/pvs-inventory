<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).keypress(function(e) {
	var x;
	var l="./Body/hello.jsp";
	if(e.which)
	{
		x=e.which;
	}
	  if(e.altKey)
		{
		  if(String.fromCharCode(x)=="c")
			{
			  l += '?param=cashpurchase';
			  window.location.href=l;
			}
		}
	});
</script>
</head>
<%
try
{
	
	Vector<String> vct=new Vector<String>();
	Vector<String> qual=new Vector<String>();
	Vector<String> board=new Vector<String>();
	Vector<String> year1=new Vector<String>();
	
	String x="FEBRUARY - 2017";
	//out.println(x.charAt(x.length()-4));
	String xx=x.substring(x.length()-4,x.length());
	out.println( x.substring(x.length()-4,x.length()) );
	
	double s=Integer.parseInt(xx) % 4;
	if(Integer.parseInt(xx) % 4==0)
	{	
		out.println("lipyear");
		out.println(s);
	}
	else
	{
		out.println("not");
		out.println(s);
	}
	String xxx="ab";
	out.println(xxx.substring(0,2)); 
	String va="sourav";
	out.print(va.substring( 0,va.length()-1) );
}
catch(Exception g)
{
	System.out.println("error on "+g);
}
%>
<br>
<%
try
{
	String main="HB1@100,HB2@200";
	String ar[]=main.split(",");
	for(int i=0;i<ar.length;i++)
	{
		String ar1[]=ar[i].split("@");
		for(int j=0;j<ar1.length;j++)
		{
			out.print(ar1[j]+" ");
		}
		%><br><%
	}
	
}
catch(Exception f)
{
	
}
%>
</html>