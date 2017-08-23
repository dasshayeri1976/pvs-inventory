package com.logout.account;

import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import com.connection.account.*;

public class SessionCounterListener implements HttpSessionListener {
 
  private static int totalActiveSessions;
  
 
  public static int getTotalActiveSession(){
	return totalActiveSessions;
  }
 
  
  public void sessionCreated(HttpSessionEvent arg0) {
	
	String sql=null;
	
	totalActiveSessions++;
	
	HttpSession session = arg0.getSession();
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	
	sql = "insert into logintime(sessionid,starttime) values ('"
			+ session.getId()
			+ "','"		
			+ getTime()+"');";
			
			
	
	ConnectionDAO.executeUpdate(stm, sql);
	
	sql = "insert into sessionstatus(SessionId,status) values ('"
			+ session.getId()
			+ "','"		
			+ "Image/login.gif"+"');";
			
			
	
	ConnectionDAO.executeUpdate(stm, sql);
	ConnectionDAO.closeConnection(conn);
	
	
	////System.out.println(session.getId());
	////System.out.print(getTime() + " (session) Created:");
    ////System.out.println("ID=" + session.getId() + " MaxInactiveInterval="
//+ session.getMaxInactiveInterval());
	//System.out.println("sessionCreated - add one session into counter");
	////System.out.println(session.getAttribute("user"));
  }
 
 
  public void sessionDestroyed(HttpSessionEvent arg0) {
	totalActiveSessions--;
	String sql=null;
	
	HttpSession session = arg0.getSession();
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	
	sql = "update logintime set endtime = '"+getTime()+"' where sessionid='"+session.getId()+"'";
	
	ConnectionDAO.executeUpdate(stm, sql);
	
	sql = "update sessionstatus set status = '"+"Image/logoff.gif"+"' where SessionId='"+session.getId()+"'";
	
	ConnectionDAO.executeUpdate(stm, sql);
	ConnectionDAO.closeConnection(conn);		
	
	
	//System.out.println("sessionDestroyed - deduct one session from counter");
  }	
 
  private String getTime()
  {
      return new Date(System.currentTimeMillis()).toString();
  }
  
}