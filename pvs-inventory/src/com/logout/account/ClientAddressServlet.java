package com.logout.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

//import java.util.ArrayList;
//import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.account.FormBean;
import com.connection.account.*;

import java.io.IOException;
//import java.io.PrintWriter;

public class ClientAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String sql = null;
        //
        // Get client's IP address
        //
        String clientIP = request.getRemoteAddr();

    	HttpSession session = request.getSession();
    	//.out.println(session.getId()); //
        // Get client's host name
        //
        //String clintHost = request.getRemoteHost();

        /*response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("IP  : " + clientIP);
        out.println("Host: " + clintHost);*/
    	Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
    	
		sql = "insert into userstatus(sessionid,username,clientip) values ('"
				+ session.getId()
				+ "','"		
				+ session.getAttribute("user")
				+ "','"
				+ clientIP+"');";
		
		ConnectionDAO.executeUpdate(stm, sql);
		
		sql = "update loginstatus set SessionId = '"+session.getId()+"',UserIp ='"+clientIP+"' where UserName='"+session.getAttribute("user")+"'";
		
		ConnectionDAO.executeUpdate(stm, sql);
		
		
				
		//System.out.println("Avijit");
		ConnectionDAO.closeConnection(conn);
        
        response.sendRedirect("loader1");
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}