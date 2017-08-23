<%@page import="java.sql.*"%>
<%@ page import="com.connection.account.*" %>
<%
	
	String brand=request.getParameter("count");
	//System.out.println("a/c got:- "+brand);
    
   ResultSet rs;
   Connection conn;
    
 	//String buffer="Place Added Successfully";
 	String buffer="<select name='formbean.partforcontra'><option value=''></option>";
 	String x="";
 	Connection con=ConnectionDAO.getConnectionObject();
	Statement smt=ConnectionDAO.createStatement(con);
			
			String sql = "select ledgerid from ledgermaster where ledgername like '%"+brand+"%' ";
			String k="";
			rs=smt.executeQuery(sql);
			while(rs.next())
			{
				//System.out.println(rs.getString(1));
				x=rs.getString(1).substring(0,2);
			}
			
			//System.out.println(x);
			
			if(x.equals("BA"))
			{
				rs=smt.executeQuery("select ledgername from ledgermaster where ledgerid like '%CH%' or ledgerid like '%BA%' and ledgername <> '"+brand+"' ");
				while(rs.next())
				{
					buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
				}
			}
			
			if(x.equals("CH"))
			{
				rs=smt.executeQuery("select ledgername from ledgermaster where ledgerid like '%BA%' or ledgerid like '%CH%' and ledgername <> '"+brand+"' ");
				while(rs.next())
				{
					buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
				}
			}
			buffer=buffer+"</select>";
			response.getWriter().println(buffer); 
 %>