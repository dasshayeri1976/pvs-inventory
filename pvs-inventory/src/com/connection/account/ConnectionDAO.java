package com.connection.account;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.*;
import javax.sql.*;


public class ConnectionDAO {
private static Connection connection;
private static Statement stmt;

public static Connection getConnectionObject() {
String userName = "root";
String password = "";
//String url = "jdbc:mysql://198.15.127.158:3306/bossmivision";
//String url = "jdbc:mysql://162.144.70.81:3306/bossmivision";
String url = "jdbc:mysql://localhost:3306/pvs_inventory";
//String userName = "riptindi_root";
//String password = "";

try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

try {
connection = DriverManager.getConnection(url, userName, password);
	 /*Context ctx=new InitialContext();
     DataSource dataSource=(DataSource)ctx.lookup("java:/comp/env/jdbc/TestDB");
     connection = dataSource.getConnection();*/
	
} catch (Exception e) {
e.printStackTrace();
}
if (connection != null)
return connection;
return null;
}

public static Statement createStatement(Connection con) {
try {
stmt = con.createStatement();
if (stmt != null) {
return stmt;
}
} catch (SQLException e) {
e.printStackTrace();
}
System.out.println("Statement has null");
return null;
}

public static boolean executeUpdate(Statement stm, String sql) {
try {
stm.execute(sql);
return true;
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}

public static boolean closeConnection(Connection conn) {
boolean result = false;
try {
conn.close();
result = true;
} catch (SQLException e) {
e.printStackTrace();
}
return result;
}

}