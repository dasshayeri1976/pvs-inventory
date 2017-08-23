package com.helper.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.connection.account.*;
import com.opensymphony.xwork2.ActionContext;
import com.bean.account.FormBean;
import org.apache.commons.lang.ArrayUtils;

public class FormHelper 
{	static String g_ledgername="";
	static String getdate="";
	static String g_ledgernameforcashonly=""; 
	public static List<FormBean> userlist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select * from logins order by Name asc";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
			{
				String x="";
				ResultSet rs = stm.executeQuery(sql);
				FormBean usBean;
				while (rs.next()) 
					{
						usBean = new FormBean();

						usBean.setId(rs.getInt(1));
						usBean.setUsername(rs.getString(2));
						usBean.setUserpass(rs.getString(3));
						int k=rs.getInt(4);
						if(k==0)
						usBean.setUserstatus("Disable");
						else
						usBean.setUserstatus("Enable");	
						//usBean.setBranch(rs.getString(5));
						usBean.setName(rs.getString(6));
						usBean.setPon(rs.getString(7));
						//usBean.setCtype(rs.getString(9));
						x=userroll(rs.getInt(1));
						usBean.setRoll(x);
						
						l1.add(usBean);
					}
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	public static String  userroll(int x) 
	{
		String x1="";
		String sql = "select * from roles where ROLE_ID="+x;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
			{
				ResultSet rs = stm.executeQuery(sql);
				
				while (rs.next()) 
					{
						x1=rs.getString(3);
					}
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return x1;
	}
	
	public static boolean usercreation(FormBean FormBean) {
		boolean result = false;
		// Connect to database and save the FormBean object to database table
		String sql = null;				
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);			
				if (FormBean.getId() != null) 
				{					
					String brand= FormBean.getBname();
					brand=brand.replaceAll(" ", "");
					String brand1[]=brand.split(",");				
					sql = "update logins set USERNAME ='"+FormBean.getUsername()+"', PASSWORD = '"+FormBean.getUserpass()+"',NAME ='"+FormBean.getName()+"',ENABLED='"+FormBean.getUserstatus()+"',PHONE='"+FormBean.getPon()+"' where LOGIN_ID ="+FormBean.getId();
					//System.out.println(sql);	
					result = ConnectionDAO.executeUpdate(stm, sql);					
					sql = "update roles set ROLE ='"+FormBean.getRoll()+"' where LOGIN_ID ="+FormBean.getId();
					//System.out.println(sql);	
					result = ConnectionDAO.executeUpdate(stm, sql);				
					sql = "update loginstatus set UserName ='"+FormBean.getUsername()+"' where Loginid ="+FormBean.getId();
					//System.out.println(sql);	
					result = ConnectionDAO.executeUpdate(stm, sql);																
					}				
				else
				{					
					sql = "select * from logins order by LOGIN_ID";
					int k=0;				
					try 
					{
						ResultSet rs = stm.executeQuery(sql);
						while (rs.next()) 
							{								
								k=rs.getInt(1);							
							}
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}			
					/*sql = "insert into idstatus(user,countlead) values ('"
							+ FormBean.getUsername()
							+ "','"		
							+ 0
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);*/
					
				
					
					sql = "insert into logins(LOGIN_ID,USERNAME,PASSWORD,ENABLED,BRANCH,NAME,PHONE,COMPANY) values ('"
							+ (k+1)
							+ "','"		
							+ FormBean.getUsername()
							+ "','"
							+ FormBean.getUserpass()
							+ "','"
							+ FormBean.getUserstatus()
							+"','"
							+ "Park Circus"
							+ "','"		
							+ FormBean.getName()
							+ "','"
							+FormBean.getPon()
							+"','"
							+"Account"
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql = "insert into roles(ROLE_ID,LOGIN_ID,ROLE) values ('"
							+ (k+1)
							+ "','"		
							+ (k+1)
							+ "','"
							+ FormBean.getRoll()
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql = "insert into loginstatus(SessionId,UserName,UserIp,Center,Loginid) values ('"
							+"abcd"
							+"','"
							+ FormBean.getUsername()
							+ "','"		
							+ "127.0.0.1"
							+ "','"
							+ "ParkCircus"
							+ "','"
							+ (k+1)
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);			
				}
				return result;
		}	
	/*group master creation*/
	//grpmastercreate
	public static boolean acgroupcreation(FormBean FormBean)
	{
		boolean result=false;
		String sql=null;
		Connection conn=ConnectionDAO.getConnectionObject();
		//Statement stm1 = ConnectionDAO.createStatement(conn1);
		Statement smt=ConnectionDAO.createStatement(conn);
		ResultSet rs;
		/*get variable*/
		String mg_name=FormBean.getGname();
		String classy=FormBean.getClassy().trim();
		String yy="A";
		//System.out.println("test got "+yy.charAt(0));
		char cat=classy.charAt(0);
		//System.out.println(cat);
		char cat1=Character.toUpperCase(cat);
		char catg='0';
		char catg1='0';
		if((cat=='A')||(cat=='L'))
		{
			//System.out.println("Yes");
			catg='B';
		}
		else
		{
			catg=FormBean.getCatforinex().charAt(0);
			catg1=Character.toUpperCase(catg);
		}
		
		//System.out.println("got category "+catg);
		
		String p_text=FormBean.getPtext();
		int sch_name=FormBean.getSchname();
		//System.out.println("schedule name got: "+sch_name);
		String detail_req=FormBean.getDetailreq();
		//System.out.println("Detail: "+detail_req);
		
		String getcode="";
		if(FormBean.getId() != null)
		{	
			try
			{				
				sql = "update groupmaster set groupname ='"+mg_name+"', incomeexpencetype = '"+catg+"', groupcategory ='"+cat+"',sequenceno='"+sch_name+"',detailinbs='"+detail_req+"',  printingtext='"+p_text+"' where id ="+FormBean.getId();
				
				result = ConnectionDAO.executeUpdate(smt, sql);
			}
			catch(Exception f)
			{
				System.out.println(f);
			}
		}
		else
		{	
						String ch[]={ "A","B","C","D","E","F","G","H","I","J",
								      "K","L","M","N","O","P","Q","R","S","T","U",
								      "V","W","X","Y","Z","0","1","2","3","4","5",
								      "6","7","8","9" 
								    };//35 character from 0 to 35
						
						String trim_name=mg_name.trim();
						String upper_name=trim_name.toUpperCase();
						
						try
						{
							String x="",code="";
							int count=0;
							for(int i=0;i<FormBean.getGname().length();i++)
							{
								for(int j=i;j<35;j++)
								{
								 code=FormBean.getGroup().toUpperCase().charAt(i)+ch[j];
								 //System.out.println(code);
								 sql="select count(groupcode) from materialgroupmaster where groupcode='"+code+"'";
								// System.out.println(sql);
								 rs=smt.executeQuery(sql);
								 while(rs.next())
								 {
									count=rs.getInt(1);
									//System.out.println("got "+count);
									if(count == 0)
									{
										x="1";
										break;
									}
								 }
								 if(x.equals("1"))
								 {
									break;
								 }
								}
								if(x.equals("1"))
								 {
									break;
								 }
							}						
								//System.out.println("code is "+x);
								
								String sql2="insert into groupmaster(groupcode, groupname, incomeexpencetype,  groupcategory, sequenceno, detailinbs, printingtext, standardhead) values('"+code+"','"+mg_name+"', '"+catg+"', '"+cat1+"',  '"+sch_name+"', '"+detail_req+"', '"+p_text+"', '0' ) ";
								result = ConnectionDAO.executeUpdate(smt, sql2);
								//System.out.println("Result: "+result);
						}
						catch(Exception t)
						{
							t.printStackTrace();;
						}
		}	
		ConnectionDAO.closeConnection(conn);
		return result;
	}
/*group master creation ends*/
//subgroup creation
	public static boolean subgroupcreation(FormBean FormBean) 
	{
		boolean result = false;
		// Connect to database and save the FormBean object to database table
		String sql = null;				
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		String des= FormBean.getSubgroupdes();
		String main=FormBean.getMgrpname();
		//System.out.println(des+"    "+main);
				if (FormBean.getId() != null) 
				{								
					sql = "update subgroupmaster set subgroupname ='"+FormBean.getName()+"' where id ="+FormBean.getId();
					//System.out.println(sql);	
					result = ConnectionDAO.executeUpdate(stm, sql);																			
				}				
				else
				{					
					sql = "select groupcode from groupmaster where groupname='"+main+"'";
					String k="";				
					try 
					{
						ResultSet rs = stm.executeQuery(sql);
						while (rs.next()) 
							{								
								k=rs.getString(1);							
							}
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}			
					sql = "insert into logins(LOGIN_ID,USERNAME,PASSWORD,ENABLED,BRANCH,NAME,PHONE,COMPANY) values ('"
							+ (k+1)
							+ "','"		
							+ FormBean.getUsername()
							+ "','"
							+ FormBean.getUserpass()
							+ "','"
							+ FormBean.getUserstatus()
							+"','"
							+ "Park Circus"
							+ "','"		
							+ FormBean.getName()
							+ "','"
							+FormBean.getPon()
							+"','"
							+"Account"
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql = "insert into roles(ROLE_ID,LOGIN_ID,ROLE) values ('"
							+ (k+1)
							+ "','"		
							+ (k+1)
							+ "','"
							+ FormBean.getRoll()
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql = "insert into loginstatus(SessionId,UserName,UserIp,Center,Loginid) values ('"
							+"abcd"
							+"','"
							+ FormBean.getUsername()
							+ "','"		
							+ "127.0.0.1"
							+ "','"
							+ "ParkCircus"
							+ "','"
							+ (k+1)
							+"');";
					
					result = ConnectionDAO.executeUpdate(stm, sql);
					
				
							
							
						
					
					
				}
				ConnectionDAO.closeConnection(conn);
				return result;
		}	
	
//master group delete
	public static boolean acgroupdelete(int id) 
	{
		boolean result = false;
		String sql1="select standardhead from groupmaster where id='"+id+"'";//check wheather standardhead is active
		String x="";
		String sql = "delete from groupmaster where id = " + id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try
		{
			ResultSet rs=stm.executeQuery(sql1);
			while(rs.next())
			{
				x=rs.getString(1);
			}
			if(x.equals("1"))
			{
				x="1";
			}
			if(x.equals("0"))
			{
				result = ConnectionDAO.executeUpdate(stm, sql);
				x="0";
			}
		}
		catch(Exception s)
		{
			System.out.println("error found in:- "+s);
		}
		//result = ConnectionDAO.executeUpdate(stm, sql);
		ConnectionDAO.closeConnection(conn);
		return result;
	}
	
//subgroup delete
		public static boolean grpnamedelete(int id) 
		{
			boolean result = false;
			String sql="";
			String sql1="select standardhead from subgroupmaster where id='"+id+"'";//check wheather standardhead is active		
			String x="";
			String code="";
			int srno=0;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try
			{
				ResultSet rs=stm.executeQuery(sql1);
				while(rs.next())
				{
					x=rs.getString(1);
				}
				if(x.equals("1"))
				{
					x="1";
					result=false;
				}
				if(x.equals("0"))
				{
					sql="select * from subgroupmaster where id='"+id+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						code=rs.getString(2);
					}
					sql="select subgroupserialno from groupmaster where groupcode='"+code.substring(0,2)+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						srno=rs.getInt(1);
					}
					sql="update groupmaster set subgroupserialno='"+(srno-1)+"' where groupcode='"+code.substring(0,2)+"'";
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql = "delete from subgroupmaster where id = " + id;
					result=ConnectionDAO.executeUpdate(stm, sql);
					x="0";
				}
			}
			catch(Exception s)
			{
				System.out.println("error found in:- "+s);
			}
			//result = ConnectionDAO.executeUpdate(stm, sql);
			ConnectionDAO.closeConnection(conn);
			return result;
		}
/*master group update*/
	public static FormBean acgroupupdate(int id) 
	{
		FormBean usBean = new FormBean();
		String sql = "select id,groupname,incomeexpencetype,groupcategory,sequenceno,detailinbs,printingtext from groupmaster where id = " + id;
		//String sql1="select * from roles where LOGIN_ID = " + id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
		{
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) 
			{
				usBean.setId(rs.getInt(1));
				
				usBean.setGname(rs.getString(2));
				
				usBean.setClassy(rs.getString(3));
				
				usBean.setcat(rs.getString(4));
				
				usBean.setSchname(rs.getInt(5));
				
				//usBean.setBranchall(rs.getString(5));
				usBean.setDetailreq(rs.getString(6));
				
				usBean.setPtext(rs.getString(7));
			}
		rs = stm.executeQuery(sql);
		while (rs.next()) 
		{	
			usBean.setRoll(rs.getString(3));		
		}
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}

//group master edit	
	public static FormBean acgroupedit(int id) {
		FormBean usBean = new FormBean();
		String sql = "select * from groupmaster where id = " + id;
		//String sql1="select * from roles where LOGIN_ID = " + id;
		//String k="";
		//String sql1 = "select * from appoinment where id = " + id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try {
			
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) 
		{
			usBean.setId(rs.getInt(1));
			usBean.setGname(rs.getString(3));
			//usBean.setCatforinex(rs.getString(7));
			usBean.setClassy(rs.getString(8));
			
			if(rs.getString(7).equals("B"))
			{
				usBean.setcat("Balance Sheet");
			}
			else
			{
				//System.out.println(rs.getString(7));
				usBean.setCatforinex(rs.getString(7));
			}
			usBean.setSchname(rs.getInt(10));
			usBean.setDetailreq(rs.getString(11));
		    usBean.setPtext(rs.getString(12));
		}
		rs = stm.executeQuery(sql);
		while (rs.next()) 
		{
			
			usBean.setRoll(rs.getString(3));
			
		}
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}
//subgroup edit/update
	public static FormBean grpnameedit(int id) {
		FormBean usBean = new FormBean();
		String sql = "select * from subgroupmaster where id = " + id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try {
		String sgcode="";	
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) 
		{
			usBean.setId(rs.getInt(1)); 
			usBean.setName(rs.getString(3));
			sgcode=rs.getString(2);
		}
		rs=stm.executeQuery("select groupname from groupmaster where groupcode like '"+sgcode.substring(0,2)+"' ");
		while(rs.next())
		{
			usBean.setSname(rs.getString(1));
		}
		rs = stm.executeQuery(sql); 
		while (rs.next()) 
		{
			
			usBean.setRoll(rs.getString(3));
			
		}
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}
	
	public static FormBean useredit(int id) {
		FormBean usBean = new FormBean();
		String sql = "select * from logins where LOGIN_ID = " + id;
		String sql1="select * from roles where LOGIN_ID = " + id;
		//String k="";
		//String sql1 = "select * from appoinment where id = " + id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try {
			
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) 
		{
			usBean.setId(rs.getInt(1));
			usBean.setUsername(rs.getString(2));
			usBean.setUserpass(rs.getString(3));
			usBean.setUserstatus(rs.getString(4));
			//usBean.setBranchall(rs.getString(5));
			usBean.setName(rs.getString(6));
			usBean.setPon(rs.getString(7));
		
			
		}
		rs = stm.executeQuery(sql1);
		while (rs.next()) 
		{
			
			usBean.setRoll(rs.getString(3));
			
		}
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}
	
	public static boolean userdelete(int id) {
		boolean result = false;
		
		
		String sql = "delete from logins where LOGIN_ID = " + id;
		String sql1 = "delete from roles where LOGIN_ID = " + id;
		String sql2 = "delete from loginstatus where Loginid = " + id;
		
				
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
			
		
		result = ConnectionDAO.executeUpdate(stm, sql1);
		result = ConnectionDAO.executeUpdate(stm, sql2);
		result = ConnectionDAO.executeUpdate(stm, sql);
	
		
		
		ConnectionDAO.closeConnection(conn);
		return result;
		}
	
	// Group Master Coding......................................................................//
	
	public static List<FormBean> acgrouplist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select id,groupname,incomeexpencetype,groupcategory,sequenceno,detailinbs,printingtext from groupmaster order by id desc";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
			{
				String x="";
				ResultSet rs = stm.executeQuery(sql);
				FormBean usBean;
				while (rs.next()) 
					{
						usBean = new FormBean();
						/*usBean.setId(rs.getInt(1));
						usBean.setUsername(rs.getString(2));
						usBean.setUserpass(rs.getString(3));
						int k=rs.getInt(4);*/
						//usBean.setId(rs.getInt(1));
						
						usBean.setId(rs.getInt(1));
						usBean.setGname(rs.getString(2));
						
						usBean.setClassy(rs.getString(3));
						if(rs.getString(3).equals("B"))
						{
							usBean.setClassy("Balance Sheet");
						}
						else if(rs.getString(3).equals("M"))
						{
							usBean.setClassy("Manufacturing Account");
						}
						else if(rs.getString(3).equals("P"))
						{
							usBean.setClassy("Profit & Loss");
						}
						else if(rs.getString(3).equals("T"))
						{
							usBean.setClassy("Trading Account");
						}
						usBean.setcat(rs.getString(4));
						if(rs.getString(4).equals("A"))
						{
							usBean.setcat("Asset");
						}	
						else if(rs.getString(4).equals("L"))
						{
							usBean.setcat("Liability");
						}
						else if(rs.getString(4).equals("I"))
						{
							usBean.setcat("Income");
						}
						else if(rs.getString(4).equals("E"))
						{
							usBean.setcat("Expenditure");
						}
						usBean.setSchname(rs.getInt(5));
						usBean.setDetailreq(rs.getString(6));
						usBean.setPtext(rs.getString(7));
						
						/*if(k==0)
						usBean.setUserstatus("Disable");
						else
						usBean.setUserstatus("Enable");	
						//usBean.setBranch(rs.getString(5));
						usBean.setName(rs.getString(6));
						usBean.setPon(rs.getString(7));
						//usBean.setCtype(rs.getString(9));
						x=userroll(rs.getInt(1));
						usBean.setRoll(x);
						*/
						l1.add(usBean);
					}
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//grpname display bottom
	public static List<FormBean> grpnamelistdisp() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select * from subgroupmaster order by id desc";//subgroupmaster
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String x2="";
		try
		{
			FormBean usBean;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				usBean=new FormBean();
				usBean=new FormBean();
				usBean.setId(rs.getInt(1));
				usBean.setSubgroupdes(rs.getString(3));
				String c3=findgroup(rs.getString(2));
				usBean.setMgrpname1(c3);
				l1.add(usBean);
			}
		}
		catch(Exception g)
		{
			g.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//grpnamelist for mastergroup list
	public static List<FormBean> grpnamelist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select * from groupmaster";
		//String sql1="select * from subgroupmaster";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";
		try 
			{
				ResultSet rs = stm.executeQuery(sql);
				
				FormBean usBean=new FormBean();
				FormBean usBean1=new FormBean();
				
				while (rs.next()) 
					{
					x=rs.getString(3);
					usBean = new FormBean();
					usBean.setId(rs.getInt(1));//for id
					usBean.setSubgroupdes(rs.getString(3));//for list view at bottom
					usBean.setSname(rs.getString(3));//for main group list
					l1.add(usBean);	
					}			
				//FormBean usBean1;				
				/*ResultSet rs1 = stm.executeQuery(sql1);//subgroup master
				while(rs1.next())
				{
					usBean1=new FormBean();
					x1=rs1.getString(3);
					x2=rs1.getString(2).substring(0,2);
					System.out.println("code generated "+x2);
					String c3=findgroup(x2);
					//usBean1.setSubgroupdes(x1);
					//l1.add(usBean1);					
					//buffer=j;	
					//System.out.println("What Find out "+buffer);
					usBean.setMgrpname1(c3);
					//System.out.println("Name Find out "+usBean.setSubgroupdes(buffer));
				}*/				
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//function for grpnamelist	
	public static String findgroup(String x2)
	{
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String x3="",x1="";
		try
		{
		
		x2=x2.substring(0, 2);
		ResultSet rs2 = stm.executeQuery("select * from groupmaster where groupcode like'"+x2+"%'");
		//System.out.println("select * from groupmaster where groupcode like'"+x2+"%' ");
		String j="";	
			while(rs2.next())
			{
				//System.out.println(rs2.getString(3)+"\r");
				x3=rs2.getString(3);	
			}			
		}
		catch(Exception f)
		{
			System.out.println(f);
		}
		ConnectionDAO.closeConnection(conn);
		return x3;
	}	
	
//subgroup creation
	
	public static boolean mgrpcreation(FormBean FormBean) {
		boolean result = false;
		// Connect to database and save the FormBean object to database table
		String sql = null;			
		String sql1 = null;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);		
		String sname= FormBean.getSname();
		String mgrpname=FormBean.getName().trim();
		//System.out.println(sname);
				if (FormBean.getId() != null) 
				{
					sql = "select groupcode,subgroupserialno from groupmaster where groupname='"+sname+"'";
			        //System.out.println(sql);
					String k="";
					int k1=0;
					String finalcode="";
					String f="0";
					try 
					{
						ResultSet rs = stm.executeQuery(sql);						
						while (rs.next()) 
							{								
								k=rs.getString(1);
								k1=rs.getInt(2);//for code
							}	
						int code=0;
						sql="select count(subgroupcode) from subgroupmaster where subgroupcode like '"+k+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							code=rs.getInt(1);
						}
						if(code==0)
						{
							finalcode=k+"00"+(code+1);
						}
						else if(code > 0 && code < 9)
						{
							finalcode=k+"00"+(code+1);
						}
						else if(code > 8 && code < 99)
						{
							finalcode=k+"0"+(code+1);
						}
						else if(code > 98 && code < 999)
						{
							finalcode=k+(code+1);
						}
					
					sql = "update subgroupmaster set subgroupname ='"+FormBean.getName()+"',subgroupcode='"+finalcode+"' where id ="+FormBean.getId();		
					result = ConnectionDAO.executeUpdate(stm, sql);	
					}
					catch(Exception aa)
					{
						System.out.println("error in subgroup update "+aa);
					}
				}				
				else
				{					
					sql = "select groupcode,subgroupserialno from groupmaster where groupname='"+sname+"'";
			        //System.out.println(sql);
					String k="";
					int k1=0;
					String finalcode="";
					String f="0";
					try 
					{
						ResultSet rs = stm.executeQuery(sql);						
						while (rs.next()) 
							{								
								k=rs.getString(1);
								k1=rs.getInt(2);//for code
								//System.out.println(rs.getString(2));
								/*for(int i=1;i<=k1;i++)
								{
									if(k1 > 0 && k1 < 10)
									{
										f="00";
									}
									else
									{
									if(k1 > 9 && k1 < 100)
									{
										f="0";
									}
									}
								}*/
							}	
						int code=0;
						sql="select count(subgroupcode) from subgroupmaster where subgroupcode like '"+k+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							code=rs.getInt(1);
						}
						if(code==0)
						{
							finalcode=k+"00"+(code+1);
						}
						else if(code > 0 && code < 9)
						{
							finalcode=k+"00"+(code+1);
						}
						else if(code > 8 && code < 99)
						{
							finalcode=k+"0"+(code+1);
						}
						else if(code > 98 && code < 999)
						{
							finalcode=k+(code+1);
						}
						sql="insert into subgroupmaster(subgroupcode,subgroupname,standardhead) values('"+finalcode+"','"+mgrpname+"','0')";
						//System.out.println(sql);
						result = ConnectionDAO.executeUpdate(stm, sql);
						//k1++;
						sql="update groupmaster set subgroupserialno='"+(k1+1)+"' where groupcode='"+finalcode.substring(0, 2)+"'";
						//System.out.println(sql);
						result = ConnectionDAO.executeUpdate(stm, sql);
					} 
				catch (SQLException e) 
					{
						e.printStackTrace();
					}			
				}
				ConnectionDAO.closeConnection(conn);
				return result;
		}
//narration creation
	public static boolean narrationcreation(FormBean FormBean) {
		boolean result = false;
		// Connect to database and save the FormBean object to database table
		String sql = null;	
		String sql1 = null;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		
				if (FormBean.getId() != null) 
				{					
					String brand= FormBean.getBname();
							
					sql = "update narrationmaster set narrationname ='"+FormBean.getName()+"', narrationdetail = '"+FormBean.getDesc1()+"' where id ="+FormBean.getId();
					//System.out.println(sql);	
					result = ConnectionDAO.executeUpdate(stm, sql);					
					//result = ConnectionDAO.executeUpdate(stm, sql);																
					}				
				else
				{	
					sql = "SELECT Max(id) FROM narrationmaster";
					//sql1="select id from narrationmaster";
					String codef="NA";//codefirst
					int k;
					int id=0;
					//int k1=0;//code zero
					String k1="";
					String code="";
					int z=0;
					try 
					{
						ResultSet rs = stm.executeQuery(sql);
						//ResultSet rs1=stm.executeQuery(sql1);
						while (rs.next()) 
							{								
								k=rs.getInt(1);
								if(k > 0 && k < 10 )
								{
									k1="0000000";
									z++;
									code=codef+k1+k;
								}
								else
								if(k > 9 && k < 100)
								{
									k1="000000";
									code=codef+k1+k;
								}
								else
								if(k > 99 && k < 1000)
								{
									k1="00000";
									code=codef+k1+k;
								}
								else
								if(k > 999 && k < 10000)
								{
									k1="0000";
									code=codef+k1+k;
								}
								else
								if(k > 9999 && k < 100000)
								{
									k1="000";
									code=codef+k1+k;
								}
								else
								if(k > 99999 && k < 1000000)
								{
									k1="00";
									code=codef+k1+k;
								}
								else
								if(k > 999999 && k < 10000000)
								{
									k1="0";
									code=codef+k1+k;
								}		
							}						
						sql = "insert into narrationmaster(narrationid, narrationname, narrationdetail) values('"+code+"','"+FormBean.getName()+"','"+FormBean.getDesc1()+"')";//insert				
						result = ConnectionDAO.executeUpdate(stm, sql);							
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}													
				}
				ConnectionDAO.closeConnection(conn);
				return result;
		}
//narration list
	public static List<FormBean> narrationlist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select * from narrationmaster order by id desc";
		
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
			{
				ResultSet rs = stm.executeQuery(sql);
				FormBean usBean;
				while (rs.next()) 
					{
					usBean = new FormBean();
					
					usBean.setId(rs.getInt(1));//for id
					usBean.setName(rs.getString(3));//for list view at bottom
					usBean.setDesc1(rs.getString(4));
					//usBean.setSname(rs.getString(3));//for main group list
					
					l1.add(usBean);		
					}
				
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//narration edit
	public static FormBean narrationedit(int id) {
		FormBean usBean = new FormBean();
		String sql = "select * from narrationmaster where id =" + id;
		//System.out.println(sql);
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try {
			
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) 
			{
		//	System.out.println(rs.getString(2)+"   "+rs.getString(3));
			usBean.setId(rs.getInt(1));
			usBean.setName(rs.getString(3));
			usBean.setDesc1(rs.getString(4));
			}
		}
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}
//narration delete
	public static boolean narrationdelete(int id) {
		boolean result = false;		
		String sql = "delete from narrationmaster where id = " + id;				
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		result = ConnectionDAO.executeUpdate(stm, sql);	
		ConnectionDAO.closeConnection(conn);
		return result;
		}
//ledger
//ledger subgroup list dropdown
	public static List<FormBean> ledgersublist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql1="select * from subgroupmaster";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";	
		try 
			{
				ResultSet rs = stm.executeQuery(sql1);		
				FormBean usBean=new FormBean();
				//FormBean usBean1=new FormBean();			
				while (rs.next()) 
					{
						x=rs.getString(3);
						usBean = new FormBean();
						//usBean.setId(rs.getInt(1));//for id
						usBean.setSname(rs.getString(3));//for sub group list  change			
						l1.add(usBean);	
					}		
			}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//ledger list
	public static List<FormBean> ledgerlist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select * from ledgermaster order by id desc";//change
		String sql1="select * from subgroupmaster";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";	
		try 
			{
				ResultSet rs = stm.executeQuery(sql1);		
				FormBean usBean=new FormBean();
				ResultSet rs1 = stm.executeQuery(sql);//change
				while(rs1.next())
					{
						usBean=new FormBean();
						usBean.setId(rs1.getInt(1));//id needed for update delete
						usBean.setName(rs1.getString(3));
						String abc=findsubgroup(rs1.getString(2));
						//System.out.println("subgroup got "+abc);
						usBean.setSubs(abc);
						usBean.setAlias(rs1.getString(4)); 
						usBean.setAdd(rs1.getString(10));
						usBean.setMaintainbal(rs1.getString(5));
						if(rs1.getString(5).equals("N"))
						{
							usBean.setMaintainbal("No");
						}
						else if(rs1.getString(5).equals("Y"))
						{
							usBean.setMaintainbal("Yes");
						}
						
						usBean.setInventoryval(rs1.getString(6));
						if(rs1.getString(6).equals("N"))
						{
							usBean.setInventoryval("No");
						}
						else if(rs1.getString(6).equals("Y"))
						{
							usBean.setInventoryval("Yes");
						}
						
						usBean.setCost(rs1.getString(7));
						if(rs1.getString(7).equals("N"))
						{
							usBean.setCost("No");
						}
						else if(rs1.getString(7).equals("Y"))
						{
							usBean.setCost("Yes");
						}
						
						
						usBean.setPrebal(rs1.getString(18).replace("-",""));
						String xx="";
						//usBean.setOpedc(rs1.getString(19));
						if(rs1.getString(19).equals("D"))
						{
							//usBean.setOpedc("Dr");
							xx="Dr";
						}
						else if(rs1.getString(19).equals("C"))
						{
							//usBean.setOpedc("Cr");
							xx="Cr";
						}
						usBean.setOpebal("<span style='float:right;'>"+rs1.getString(17).replace("-","")+" "+xx+"</span>");
						l1.add(usBean);	
					}
			}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//ledger edit
	public static FormBean ledgeredit(int id) {
		
		FormBean usBean = new FormBean();
		FormBean usBean1;
		String sql = "select * from ledgermaster where id =" + id;
		String ledgerid="";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
		{	
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) 
			{
				usBean1=new FormBean();
				//ledger section starts from here
				usBean.setId(rs.getInt(1));//for id
				usBean.setName(rs.getString(3));
				usBean.setAlias(rs.getString(4));
				
				//usBean.setMaintainbal(rs.getString(5));
				if(rs.getString(5).equals("Y"))
				{
					usBean.setMaintainbal("1");
				}
				else if(rs.getString(5).equals("N"))
				{
					usBean.setMaintainbal("2");
				}
				
				usBean.setInventoryval(rs.getString(6));
				if(rs.getString(6).equals("Y"))
				{
					usBean.setInventoryval("1");
				}
				else if(rs.getString(6).equals("N"))
				{
					usBean.setInventoryval("2");
				}
				
				if(rs.getString(7).equals("Y"))
				{
					usBean.setCost("1");
				}	
				else if(rs.getString(7).equals("N"))
				{
					usBean.setCost("2");
				}
				usBean.setOpebal(rs.getString(17).replace(".00", ""));
				usBean.setPrebal(rs.getString(18));
				usBean.setOpedc(rs.getString(19));
				ledgerid=rs.getString(2);
				//for mailing information starts from here
				usBean.setMailto(rs.getString(9));
				usBean.setAdd(rs.getString(10));
				usBean.setPlace(rs.getString(11));//for place
				usBean.setContname(rs.getString(14));
				usBean.setPhno(rs.getString(15));
				usBean.setEmail(rs.getString(16));
				usBean.setPan1(rs.getString(12));
				usBean.setVat(rs.getString(13));
				usBean.setPhno1(rs.getString(24));
				usBean.setEmail1(rs.getString(25));
				//System.out.println("address got "+rs.getString(11));
			}
			sql="select subgroupname from subgroupmaster where subgroupcode like '"+ledgerid.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			String sgname="";
			while(rs.next())
			{
				sgname=rs.getString(1);
			}
			usBean.setSname(sgname);
			
			sql="select groupname from groupmaster where groupcode like '"+ledgerid.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			String gname="";
			while(rs.next())
			{
				gname=rs.getString(1);
			}
			usBean.setMaingroup(gname);
			
			//for dynamic popup
			sql="select * from outstandingledger where ledgerid='"+ledgerid+"' ";
			rs=stm.executeQuery(sql);
			Vector<String> voucher=new Vector<String>();
			Vector<String> refno=new Vector<String>();
			Vector<String> refdate=new Vector<String>();
			Vector<String> gross=new Vector<String>();
			Vector<String> pread=new Vector<String>();
			Vector<String> due=new Vector<String>();
			while(rs.next())
			{
				voucher.add(rs.getString(3).substring(0,2));
				refno.add(rs.getString(4));
				refdate.add(rs.getString(5));
				gross.add(rs.getString(6));
				pread.add(rs.getString(9));
				due.add(rs.getString(8));
			}
			String ar1[]=new String[1];
			String ar2[]=new String[1];
			String ar3[]=new String[1];
			String ar4[]=new String[1];
			String ar5[]=new String[1];
			String ar6[]=new String[1];
			if(voucher.size()!=0)
			{
			String[] voucher1=new String[voucher.size()];
			String[] refno1=new String[refno.size()];
			String[] refdate1=new String[refdate.size()];
			String[] gross1=new String[gross.size()];
			String[] pread1=new String[pread.size()];
			String[] due1=new String[due.size()];
			for(int i=0;i<voucher.size();i++)
			{ 
				//System.out.println("Values got:- ");
				//System.out.println(voucher.get(i)+"  "+refdate.get(i)+"  "+gross.get(i)+"  "+pread.get(i)+"  "+due.get(i));
				voucher1[i]=voucher.get(i);
				refno1[i]=refno.get(i);
				refdate1[i]=refdate.get(i);
				gross1[i]=gross.get(i);
				pread1[i]=pread.get(i);
				due1[i]=due.get(i);
			}
			usBean.setVtype(voucher1);
			usBean.setParti(refno1); 
			usBean.setDt(refdate1);
			usBean.setGross(gross1);
			usBean.setPre(pread1);
			usBean.setDue(due1);
			}//end if voucher!=0
			else if(voucher.size()==0)
			{
				usBean.setVtype(ar1);
				usBean.setParti(ar2); 
				usBean.setDt(ar3);
				usBean.setGross(ar4);
				usBean.setPre(ar5);
				usBean.setDue(ar6);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}
//ledger delete
	public static boolean ledgerdelete(int id) {
		boolean result = false;		
		//System.out.println("i am in ledger delete");
		//String sql1="select standardhead from ledgermaster where id="+id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String s="select standardhead from ledgermaster where id='"+id+"' ";
		String st="";
		try
		{
			ResultSet rs1=stm.executeQuery(s);
			while(rs1.next())
			{
				st=rs1.getString(1);
			}
		}
		catch(Exception d)
		{
			
		}
		//System.out.println("Standard Head "+st);
		if(st.equals("0"))
		{
			String sql = "delete from ledgermaster where id='"+id+"'  ";	
			String sql1="select ledgerid from ledgermaster where id='"+id+"' ";
			String led="";
			try
			{
				ResultSet rs=stm.executeQuery(sql1);
				while(rs.next())
				{
					led=rs.getString(1);
				}
				sql1="delete from outstandingledger where ledgerid='"+led+"' ";
			}
			catch(Exception f)
			{
				System.out.println("Outstanding ledger delete error:= "+f);
			}
			result = ConnectionDAO.executeUpdate(stm, sql);	
			result=ConnectionDAO.executeUpdate(stm, sql1);
		}
		else
		{
			
		}
		ConnectionDAO.closeConnection(conn);
		return result;
		}
//ledger creation
	public static boolean ledgercreation(FormBean FormBean) {
		boolean result = false;
		// Connect to database and save the FormBean object to database table
		String sql = null;	
		String sql1 = null;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		
				if (FormBean.getId() != null) 
				{		
					String vtype[]=FormBean.getVtypehidden();
					String parti[]=FormBean.getPartihidden();
					String dt[]=FormBean.getDthidden();
					String gross[]=FormBean.getGrosshidden();
					String prea[]=FormBean.getPrehidden();
					String due[]=FormBean.getDuehidden();
					String ss="select ledgerid from ledgermaster where id='"+FormBean.getId()+"'";
					String id="",voucherno="",refno="";
					String brand= FormBean.getBname();
					String bill=FormBean.getMaintainbal();
					String inventory=FormBean.getInventoryval();
					String cost=FormBean.getCost();
					ResultSet rs;
					if(bill.equals("1"))
					{
						bill="Y";
					}
					else if(bill.equals("2"))
					{
						bill="N";
					}
					
					if(inventory.equals("1"))
					{
						inventory="Y";
					}
					else if(inventory.equals("2"))
					{
						inventory="N";
					}
					
					if(cost.equals("1"))
					{
						cost="Y";
					}
					else if(cost.equals("2"))
					{
						cost="N";
					}
					double ope=0.00,cur=0.00;
					double finalcur=0.00;
					double pre=Double.parseDouble(FormBean.getOpebal());
					try
					{
						ResultSet rse=stm.executeQuery(ss);
						while(rse.next())
						{
							id=rse.getString(1);
						}
						String xx=id.substring(5, id.length());
						String yy="",subgroupcode="";
						sql="select subgroupcode from subgroupmaster where subgroupname='"+FormBean.getSname()+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							subgroupcode=rs.getString(1);
						}
						sql="select * from outstandingledger";
						rse=stm.executeQuery(sql);
						while(rse.next())
						{
							voucherno=rse.getString(3);
							refno=rse.getString(4);
						}
						//System.out.println("ref no "+refno);
						sql="select openingbalance,currentbalance from ledgermaster where id='"+FormBean.getId()+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							ope=rs.getDouble(1);
							cur=rs.getDouble(2);
						}	
						finalcur=(cur-ope)+pre;
					
					sql = "update ledgermaster set ledgerid='"+(subgroupcode+xx)+"', ledgername ='"+FormBean.getName()+"', aliasname = '"+FormBean.getAlias()+"', billbybill ='"+bill+"', inventoryvalue ='"+inventory+"', costcenter ='"+cost+"', mailingname ='"+FormBean.getMailto()+"', address ='"+FormBean.getAdd()+"', placecode='"+FormBean.getPlace()+"', panno ='"+FormBean.getPan1()+"', staxno ='"+FormBean.getVat()+"', contactperson ='"+FormBean.getContname()+"', mobileno ='"+FormBean.getPhno()+"', emailid ='"+FormBean.getEmail()+"', openingbalance ='"+FormBean.getOpebal()+"', currentbalance ='"+finalcur+"', drcr ='"+FormBean.getOpedc()+"', altermobileno='"+FormBean.getPhno1()+"', alteremailid='"+FormBean.getEmail1()+"' where id ='"+FormBean.getId()+"' ";
					//System.out.println(sql);
					result = ConnectionDAO.executeUpdate(stm, sql);	
					
					sql="delete from outstandingledger where ledgerid='"+id+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					String sn=FormBean.getSname();
					String ma=FormBean.getMaintainbal();
					//System.out.println("bal "+ma);
					if(sn.substring(0,3).equals("SUN") && FormBean.getOpebal()!="" && ma.equals("1"))
					{
					for(int i=0;i<vtype.length;i++)
					{
						if(vtype[i].equals(""))
						{
							vtype[i]="00";
						}
						if(parti[i].equals(""))
						{
							parti[i]="00";
						}
						if(dt[i].equals(""))
						{
							dt[i]="0000-00-00";
						}
						if(gross[i].equals(""))
						{
							gross[i]="00";
						}
						if(prea[i].equals(""))
						{
							prea[i]="00";
						}
						if(due[i].equals(""))
						{
							due[i]="00";
						}
						
						if(vtype[i]!="")
						{
							sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount, vouchertype) values('"+id+"', '"+voucherno+"', '"+parti[i]+"', '"+dt[i]+"', '"+gross[i]+"', '"+prea[i]+"', '"+due[i]+"', '"+prea[i]+"', '"+FormBean.getDc()+"') ";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
						else if(vtype[i].equals(""))
						{
							sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount, vouchertype) values('"+0+"', '"+00000+"', '"+00000+"', '"+(0000-00-00)+"', '"+(0.00)+"', '"+(0.00)+"', '"+(0.00)+"', '"+(0.00)+"', '"+0+"') ";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
					}
					}
					sql="delete from outstandingledger where referenceno like '0%'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					}
					catch(Exception h)
					{
						System.out.println("ledger update error:- "+h);
					}
				}				
				else
				{	
					sql = "SELECT Max(id) FROM ledgermaster";
					sql1="select subgroupcode from subgroupmaster where subgroupname like '%"+FormBean.getSname()+"%' ";
					String billbybill=FormBean.getMaintainbal();
					String inventoryval=FormBean.getInventoryval();
					String costcenter=FormBean.getCost();
					String opebal=FormBean.getOpebal();
					String crbal=FormBean.getPrebal();
					String ope="";
					//System.out.println("Bill by bill:- "+billbybill+'\r'+"Inventory:- "+inventoryval+'\r'+"Cost:- "+costcenter);
					if(FormBean.getOpedc().equals(""))
					{
						ope="D";
					}
					else
					{
						ope=FormBean.getOpedc();
					}
					if(crbal.equals(""))
					{
						crbal="0";
					}
					
					if(opebal.equals(""))
					{
						opebal="0";
					}
					
					if(billbybill.equals("1"))
					{
						billbybill="Y";
					}
					else if(billbybill.equals("2"))
					{
						billbybill="N";
					}
					
					if(inventoryval.equals("1"))
					{
						inventoryval="Y";
					}
					else if(inventoryval.equals("2"))
					{
						inventoryval="N";
					}
					
					if(costcenter.equals("1"))
					{
						costcenter="Y";
					}
					else if(costcenter.equals("2"))
					{
						costcenter="N";
					}
					//sql1="select id from narrationmaster";
					String codef="LE";//codefirst
					int k;
					int id=0;
					//int k1=0;//code zero
					String k1="";
					String code="";
					String x="";
					int z=0;
					int z1=1;
					try 
					{
						ResultSet rs1=stm.executeQuery(sql1);
						while(rs1.next())
						{
							x=rs1.getString(1);
						}
						
						ResultSet rs = stm.executeQuery(sql);
						//ResultSet rs1=stm.executeQuery(sql1);
						while (rs.next()) 
							{								
								k=rs.getInt(1);
								//System.out.println("code got is:- "+k);
								/*if(k==0)
								{
									k1="0000";
									code=x+k1+1;
								}*/
								if(k > 0 && k < 10 )
								{
									k1="000";
									z++;
									code=x+k1+(k+1);
								}
								else
								if(k > 9 && k < 100)
								{
									k1="00";
									code=x+k1+k;
								}
								else
								if(k > 99 && k < 1000)
								{
									k1="0";
									code=x+k1+k;
								}
								else
								if(k > 999 && k < 10000)
								{
									k1="0";
									code=x+k1+k;
								}
								else
								if(k > 9999 && k < 100000)
								{	
									code=x+k;
								}				
							}	
						String xx=opebal;
						if(FormBean.getOpedc().equals("C"))
						{
							xx="-"+opebal;
							//System.out.println("change for c:- "+xx);
						}
						else if(FormBean.getOpedc().equals("D"))
						{
							xx=opebal;
						}
						//String cfirst="";
						String y="1718";
						
						String vtype[]=FormBean.getVtype();
						String parti[]=FormBean.getParti();
						String dt[]=FormBean.getDt();
						String gross[]=FormBean.getGross();
						String pre[]=FormBean.getPre();
						String due[]=FormBean.getDue();
						sql="insert into ledgermaster(ledgerid, ledgername, aliasname, billbybill, inventoryvalue, costcenter, mailingname, address, placecode, panno, staxno, contactperson, mobileno, emailid, openingbalance, currentbalance, drcr, altermobileno, alteremailid, standardhead) values('"+code+"', '"+FormBean.getName()+"', '"+FormBean.getAlias()+"', '"+billbybill+"', '"+inventoryval+"', '"+costcenter+"', '"+FormBean.getMailto()+"', '"+FormBean.getAdd()+"', '"+FormBean.getPlace()+"', '"+FormBean.getPan1()+"', '"+FormBean.getVat()+"', '"+FormBean.getContname()+"', '"+FormBean.getPhno()+"', '"+FormBean.getEmail()+"', '"+opebal+"', '"+xx+"', '"+ope+"', '"+FormBean.getPhno1()+"', '"+FormBean.getEmail1()+"', '0')";//insert				
						result=ConnectionDAO.executeUpdate(stm, sql);	
						
						//for outstandingledger table
						int count=0;
						for(int i=0;i<vtype.length;i++)
						{
							if(vtype[i].equals(""))
							{
								vtype[i]="00";
							}
							
							if(dt[i].equals(""))
							{
								dt[i]="0000-00-00";
							}
							if(gross[i].equals(""))
							{
								gross[i]="00";
							}
							if(pre[i].equals(""))
							{
								pre[i]="00";
							}
							if(due[i].equals(""))
							{
								due[i]="00";
							}
							
						if(vtype[i]!="")
						{
							sql="select count(voucherno) from outstandingledger where voucherno like '"+vtype[i]+"%' ";
							//System.out.println(sql);
							String finalcode="";
							String finalcode1="";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								count=(rs.getInt(1)+1); 
							}
							String zero="";
							if(count > 0 && count < 10)
							{
								zero="0000";
								finalcode=vtype[i]+y+y+zero+count;
								finalcode1=zero+count;
							}
							else if(count > 9 && count < 100)
							{
								zero="000";
								finalcode=vtype[i]+y+y+zero+count;
								finalcode1=zero+count;
							}
							else if(count > 99 && count < 1000)
							{
								zero="00";
								finalcode=vtype[i]+y+y+zero+count;
								finalcode1=zero+count;
							}
							else if(count > 999 && count < 10000)
							{
								zero="0";
								finalcode=vtype[i]+y+y+zero+count;
								finalcode1=zero+count;
							}
							else if(count > 9999 && count < 100000)
							{
								finalcode=vtype[i]+y+y+count;
								finalcode1=Integer.toString(count);
							}
							if(parti[i].equals(""))
							{
								sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount, vouchertype) values('"+code+"', '"+finalcode+"', '"+(vtype[i]+"/"+y+"/"+finalcode1)+"', '"+dt[i]+"', '"+gross[i]+"', '"+pre[i]+"', '"+due[i]+"', '"+pre[i]+"', '"+FormBean.getDc()+"') ";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							else
							{
								sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount, vouchertype) values('"+code+"', '"+finalcode+"', '"+parti[i]+"', '"+dt[i]+"', '"+gross[i]+"', '"+pre[i]+"', '"+due[i]+"', '"+pre[i]+"', '"+FormBean.getDc()+"') ";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
						}//if section ends
						}//for loop ends
						Map<String,Object> lsession=ActionContext.getContext().getSession();
						if(code.substring(0, 2).equals("CH") || code.substring(0, 2).equals("BA"))
						{
							g_ledgername=FormBean.getName();
							lsession.put("top", ""+FormBean.getName());
						}
						else
						{
							lsession.put("down", ""+FormBean.getName());
						}
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					
				}
				ConnectionDAO.closeConnection(conn);
				return result;
		}
//ledger ends
//payment starts
//payment creation
	public static boolean paymentcreation(FormBean FormBean) {
		boolean result=false;		
		String sql = null;	
		String sql1 = null;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		
		if (FormBean.getId() != null) 
		{					
			//String brand= FormBean.getBname();
			//System.out.println("hello");
			//System.out.println("id= "+FormBean.getId());
			//System.out.println("id "+FormBean.getId());     id comming  properly
			String s1[]=FormBean.getContra1();
			String s2[]=FormBean.getCredithidden();
			//System.out.println("amount size "+s2.length);
			String s3[]=FormBean.getNarration1();
			double oldamount=0.00;
			String ledger="",voucher="";
			Vector<String> voucherno=new Vector<String>();
			String entry="";
			sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
			try
			{
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledger=rs.getString(1);
					oldamount=rs.getDouble(2);
					voucher=rs.getString(3);
					entry=rs.getString(4);
				}
				String contradate="";
				if(FormBean.getContradate().equals(""))
				{
					contradate="0000-00-00";
				}
				else
				{
					contradate=FormBean.getContradate();
				}
				sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//resetting
				//ledger
				double ledbal=0.00;
				sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledbal=rs.getDouble(1);
				}
				//update ledgermaster
				sql="update ledgermaster set currentbalance='"+(ledbal+oldamount) +"' where ledgerid='"+ledger+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				double subgroupbal=0.00;
				while(rs.next())
				{
					subgroupbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(subgroupbal+oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				double grpbal=0.00;
				while(rs.next())
				{
					grpbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(grpbal+oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				String abcd="";
				double amou=0.00;
				
				Vector<String> ld=new Vector<String>();
				sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ld.add(rs.getString(1));
				}
				//System.out.println("length "+s2.length);
				for(int i=0;i<ld.size();i++)//particular hidden array
				{
					if(i!=0)
					{
					sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					Vector<String> am=new Vector<String>();
					while(rs.next()) 
					{
						amou=rs.getDouble(1);//accountdetails
						am.add(rs.getString(1));
					}
					//System.out.println("part amount got "+amou);
					Vector<String> gt=new Vector<String>();
					
					//resetting ledgermaster,subgroupmaster,groupmaster
					//ledgermaster
					sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
					//System.out.println(sql);
					double ledgerbal=0.00;
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledgerbal=rs.getDouble(1);
					}
					sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//subgroupmaster
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					double subbal=0.00;
					while(rs.next())
					{
						subbal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//groupmaster
					sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					double gpbal=0.00;
					while(rs.next())
					{
						gpbal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					//resetting ends
				}
				}
				
				sql="delete from accountdetails where voucherno='"+voucher+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//update to ledger
				sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
				rs=stm.executeQuery(sql);
				double newled=0.00;
				while(rs.next())
				{
					newled=rs.getDouble(1);
				}
				//System.out.println("new led bal "+newled);
				sql="update ledgermaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//update to subgroup
				sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					newled=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//update group
				sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					newled=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				String led="",sql3="";
				double total=0.00;
				for(int i=0;i<s2.length;i++)
				{
					sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						led=rs.getString(1);
					}
					//System.out.println("ledgerid "+led);
					sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s3[i]+"') ";
					//System.out.println(sql3);
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
					rs=stm.executeQuery(sql);
					double bal=0.00;
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					total=bal+Double.parseDouble(s2[i]);
					sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
				
					//getting voucherno from outstandingledger
					sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						voucherno.add(rs.getString(1));
					}	
					
					//deleting outstanding ledger
					sql="delete from outstandingledger where ledgerid='"+led+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//deleting adjustmentdetails ledger
					sql="delete from adjustmentdetails where ledgerid='"+led+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				int count=0;
				Vector<String> first=new Vector<String>();
				Vector<String> second=new Vector<String>();
				Vector<String> third=new Vector<String>();
				Vector<String> fourth=new Vector<String>();
				Vector<String> fifth=new Vector<String>();
				Vector<String> sixth=new Vector<String>();
				Vector<String> seventh=new Vector<String>();
				for(int j=0;j<s1.length;j++)
				{
					String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
					//System.out.println("found "+sql6);
					ResultSet rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						abcd=rs2.getString(1);
					}
					sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
					//System.out.println(sql6);
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						count=rs2.getInt(1);
					}
					if(count > 0)
					{
					for(int j1=1;j1<=count;j1++)
					{
						sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							first.add(rs2.getString(2));
							second.add(rs2.getString(3));
							third.add(rs2.getString(4));
							fourth.add(rs2.getString(5));
							fifth.add(rs2.getString(6));
							sixth.add(rs2.getString(7));
							seventh.add(rs2.getString(8));
						}
						//insert outstandingledger
						sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"', '"+seventh.get(j1-1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
						
						//insert adjustmentdetails
						sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
					}
					}
					else
					{}
				}
				
			}
			catch(Exception f)
			{
				System.out.println("payment update error= "+f);
			}
		}
		else
		{
			
			String s1[]=FormBean.getNarration();
			String s2[]=FormBean.getDebit();
			String s3[]=FormBean.getPartforcontra();
			String receipt="PC";
			String receipt1="PB";
			String receipt2="1617";
			String zero="";
			int aa=0;
			String ledgerid="";
			String finalcode="";
			String abcd="";
			Vector<String> voucherno=new Vector<String>();
			sql="select count(id) from accounttransaction where voucherno like 'PC%' or voucherno like 'PB%'";
			sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
			try
			{
				ResultSet rs1=stm.executeQuery(sql1);
				while(rs1.next())
				{
					ledgerid=rs1.getString(1);
				}
				
				if(ledgerid.substring(0,2).equals("CH"))
				{
					receipt="PC"; 
				}
				else if(ledgerid.substring(0,2).equals("BA"))
				{
					receipt="PB";
				}
				
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					aa=rs.getInt(1);//got id
				}
				
				if(aa==0)
				{
					zero="0000";
					finalcode=receipt+receipt2+receipt2+zero+1;
					//System.out.println("code generated() "+finalcode);
				}
				else if(aa > 0 && aa < 9)
				{
					zero="0000";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					//System.out.println("code generated(single) "+finalcode);
				}
				else if(aa > 8 && aa < 99)
				{
					zero="000";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					//System.out.println("code generated(double) "+finalcode);
				}
				else if(aa > 98 && aa < 999)
				{
					zero="00";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					//System.out.println("code generated(triple) "+finalcode);
				}
				else if(aa > 998 && aa < 9999)
				{
					zero="0";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					//System.out.println("code generated(quadra) "+finalcode);
				}
				else if(aa > 9998 && aa < 99999)
				{
					finalcode=receipt+receipt2+receipt2+(aa+1);
					//System.out.println("code generated(penta) "+finalcode);
				}
				String contradate="";
				if(FormBean.getContradate().equals(""))
				{
					contradate="0000-00-00";
				}
				else
				{
					contradate=FormBean.getContradate();
				}
				
				sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','cr')";//insert				
				result = ConnectionDAO.executeUpdate(stm, sql);
				
				String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+"-"+FormBean.getTotal()+"') ";
				//System.out.println(sql3);
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
				
					String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'cr') ";
					result=ConnectionDAO.executeUpdate(stm, sql2);
				
				
				//update for ledgermaster
				String forledger="";
				sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getPart1()+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					forledger=rs.getString(1);
				}
				sql1="select currentbalance from ledgermaster where ledgerid='"+forledger+"' ";
				rs=stm.executeQuery(sql1);
				double curbal=0.00;
				while(rs.next())
				{
					curbal=rs.getDouble(1);
				}
				double total=Double.parseDouble(FormBean.getTotal());
				sql="update ledgermaster set currentbalance='"+(curbal-total)+"' where ledgerid='"+forledger+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//update subgroup master
				sql="select currentbalance from subgroupmaster where subgroupcode='"+forledger.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					curbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(curbal-total)+"' where subgroupcode='"+forledger.substring(0,5)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//update groupmaster
				sql="select closingbalance from groupmaster where groupcode='"+forledger.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					curbal=rs.getDouble(1);
				}
				//System.out.println("group bal:- "+curbal);
				sql="update groupmaster set closingbalance='"+(curbal-total)+"' where groupcode='"+forledger.substring(0,2)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				String part=FormBean.getPart();
				String led="";
				
				for(int i=0;i<s2.length;i++)
				{
					String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
					result=ConnectionDAO.executeUpdate(stm, sql4);
					
					sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
					rs=stm.executeQuery(sql);
					String ledger="";
					while(rs.next())
					{
						ledger=rs.getString(1);
					}
					sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+s2[i]+"', '"+s1[i]+"') ";
					//System.out.println("aaa "+sql3);
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						led=rs.getString(1);
					}
					sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
					rs=stm.executeQuery(sql);
					double bal=0.00;
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					total=bal+Double.parseDouble(s2[i]);
					sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//getting voucherno from outstandingledger
					sql="select voucherno from outstandingledger where ledgerid='"+abcd+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						voucherno.add(rs.getString(1));
					}	
					
					//deleting outstanding ledger
					sql="delete from outstandingledger where ledgerid='"+ledger+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//deleting adjustmentdetails ledger
					sql="delete from adjustmentdetails where ledgerid='"+ledger+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				int count=0;
				Vector<String> first=new Vector<String>();
				Vector<String> second=new Vector<String>();
				Vector<String> third=new Vector<String>();
				Vector<String> fourth=new Vector<String>();
				Vector<String> fifth=new Vector<String>();
				Vector<String> sixth=new Vector<String>();
				Vector<String> seventh=new Vector<String>();
				for(int j=0;j<s1.length;j++)
				{
					String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
					//System.out.println("found "+sql6);
					ResultSet rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						abcd=rs2.getString(1);
					}
					sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
					//System.out.println(sql6);
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						count=rs2.getInt(1);
					}
					if(count > 0)
					{
					for(int j1=0;j1<count;j1++)
					{
						sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							first.add(rs2.getString(2));
							second.add(rs2.getString(3));
							third.add(rs2.getString(4));
							fourth.add(rs2.getString(5));
							fifth.add(rs2.getString(6));
							sixth.add(rs2.getString(7));
							seventh.add(rs2.getString(8));
						}
						if(first.size()>0)
						{
						//insert outstandingledger
						sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"', '"+seventh.get(j1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
						
						//insert adjustmentdetails
						sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
						}
					}
					}
					else
					{}
				}
			}
			catch(Exception f)
			{
				System.out.println("error payment creation:- "+f);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
		}
//payment list
//set part1
	public static FormBean setpart() 
	{
		//System.out.println("ledger "+g_ledgername);
		FormBean usBean1=new FormBean();
		usBean1.setPart1(g_ledgername);
		return usBean1;
	}
	public static List<FormBean> paymentlist() 
	{
		//System.out.println("ledger created "+g_ledgername); 
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "select * from accounttransaction where voucherno like 'PC%' or voucherno like 'PB%' order by id desc";
		//String sql1="select max(id) from accountdetails";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String le="";
		try 
			{
				ResultSet rs = stm.executeQuery(sql);
				FormBean usBean;
				while (rs.next()) 
					{
					usBean = new FormBean();
					usBean.setId(rs.getInt(1));//for id
					usBean.setShowdate(rs.getString(2));//entry date
					usBean.setContraref(rs.getString(4));//ref no
					usBean.setContradate(rs.getString(5));//ref date
					usBean.setTotal(rs.getString(7).replace("-", ""));
					String vno=findfirsthead(rs.getString(3));
					usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
					usBean.setPart1(findledger(vno));
					l1.add(usBean);		
					}
				
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//payment update
	public static FormBean paymentedit(int id) {
		FormBean usBean = new FormBean();
		String sql = "select voucherno,ledgerid,entrydate,id from accounttransaction where id =" + id;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try 
		{
			String ledgerid="",voucherno="",entrydate="";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledgerid=rs.getString(2);
				voucherno=rs.getString(1);
				entrydate=rs.getString(3);
				usBean.setId(rs.getInt(4));
			}
			usBean.setSrno(voucherno.substring( voucherno.length()-1,voucherno.length() ) );
			usBean.setShowdate(entrydate);
			sql="select ledgername from ledgermaster where ledgerid = '"+ledgerid+"' ";
			rs=stm.executeQuery(sql);
			String ledgername="";
			while(rs.next())
			{
				ledgername=rs.getString(1);
			}
			usBean.setPart1(ledgername);
			
			sql="select narration from accountnarration where voucherno = '"+voucherno+"' ";
			rs=stm.executeQuery(sql);
			String narration="";
			while(rs.next())
			{
				narration=rs.getString(1);
			}
			usBean.setDesc1(narration);
			String total="";
			sql="select referenceno,referencedate,totalamount,entrydate from accounttransaction where voucherno = '"+voucherno+"' ";
			rs=stm.executeQuery(sql);
			String refno="",refdate="",entry="";
			while(rs.next())
			{
				refno=rs.getString(1);
				refdate=rs.getString(2);
				total=rs.getString(3);
				entry=rs.getString(4);
			}
			//System.out.println("entry date "+entry);
			usBean.setShowdate(entry);
			usBean.setContraref(refno);
			usBean.setContradate(refdate);
			usBean.setTotal(total.replace("-",""));
			//for dynamic
			sql="select ledgerid,amount,narration from accountdetails where voucherno = '"+voucherno+"'";
			rs=stm.executeQuery(sql);
			Vector<String> nar=new Vector<String>();
			ArrayList<String> narshow=new ArrayList<String>();
			while(rs.next())
			{
				nar.add(rs.getString(3));
			}
			for(int i=1;i<nar.size();i++)
			{
				narshow.add(nar.get(i)); 
			}
			
			sql="select voucherno from accounttransaction where id='"+id+"' ";
				
				String voucherno1="";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno1=rs.getString(1);
				}
				sql="select ledgerid,amount,narration from accountdetails where voucherno='"+voucherno1+"' ";
				rs=stm.executeQuery(sql);
				Vector<String> vledger=new Vector<String>();
				Vector<String> vledger1=new Vector<String>();
				Vector<String> vamount=new Vector<String>();
				Vector<String> vnarration=new Vector<String>();
				while(rs.next())
				{
					vledger.add(rs.getString(1));
					vamount.add(rs.getString(2));
					vnarration.add(rs.getString(3));
				}
				String ledgergot="";
				String[] nar1=new String[vnarration.size()-1];
				String[] amount1=new String[vamount.size()-1];
				String[] ledger1=new String[vledger.size()-1];
				for(int i=1;i<vnarration.size();i++)
				{
						nar1[i-1]=vnarration.get(i);
						String tot=vamount.get(i);
						amount1[i-1]=tot.replaceAll("-", "");
						//amount1[i-1]=vamount.get(i);
						
						sql="select ledgername from ledgermaster where ledgerid='"+vledger.get(i)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							ledger1[i-1]=rs.getString(1);
							//System.out.println("ledger got:- "+rs.getString(1));
							//vledger1.add(rs.getString(1));
						}
						//ledger1[i-1]=vledger1.get(i); 
						//System.out.println("hello "+ledger1[0]);
				}
				//System.out.println("hello "+ledger1);
				//usBean=new FormBean();
				usBean.setNarration(nar1);
				usBean.setDebit(amount1);
				
				usBean.setQuantity(ledger1);
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
		}
//payment delete
	public static String paymentdelete(int id) {
		boolean result = false;		
		String sql = "select voucherno,ledgerid from accounttransaction where id='"+id+"' ";
		String sql1="",sql3="";
		String a="",b="",c="",aaa="";
		double aaaa=0.00;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try
		{
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				a=rs.getString(1);//voucherno
				aaa=rs.getString(1);//voucherno
				b=rs.getString(2);//ledgerid
			}
			
			sql="select amount from accountdetails where ledgerid='"+b+"' ";//getting total amount 
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				a=rs.getString(1);
			}
			
			sql="select currentbalance from ledgermaster where ledgerid='"+b+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				c=rs.getString(1); 
			}
			double cc=Double.parseDouble(c);
			double aa=Double.parseDouble(a);
			sql1="update ledgermaster set currentbalance='"+(cc+aa)+"' where ledgerid='"+b+"' ";//have to change
			result = ConnectionDAO.executeUpdate(stm, sql1);
			
			sql="select currentbalance from subgroupmaster where subgroupcode like '"+b+"%' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				c=rs.getString(1);
			}
			cc=Double.parseDouble(c);//subgroup cr bal
			sql1="update subgroupmaster set currentbalance='"+(cc+aa)+"' where subgroupcode like '"+b+"%' ";
			result = ConnectionDAO.executeUpdate(stm, sql1);
			
			sql="select closingbalance from groupmaster where groupcode like '"+b+"%' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				c=rs.getString(1);
			}
			cc=Double.parseDouble(c);//subgroup cr bal
			sql1="update groupmaster set closingbalance='"+(cc+aa)+"' where groupcode like '"+b+"%' ";
			result = ConnectionDAO.executeUpdate(stm, sql1);
			
			sql3="select ledgerid from accountdetails where voucherno like '"+aaa+"' ";
			
			rs=stm.executeQuery(sql3);
			Vector<String> vct = new Vector<String>();
			
			while(rs.next())
			{
				vct.add((String)rs.getString(1));
			}
			for(int i=1;i<vct.size();i++)
			{
				sql="select amount from accountdetails where ledgerid like '"+vct.get(i)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					aaaa=rs.getDouble(1);//credit amount
				}
				
				sql="select currentbalance from ledgermaster where ledgerid like '"+vct.get(i)+"' ";
				rs=stm.executeQuery(sql);
				double val=0.00;  
				while(rs.next())
				{
					val=rs.getDouble(1);
				}
				
				sql="update ledgermaster set currentbalance='"+(val-aaaa)+"' where ledgerid like '"+vct.get(i)+"' ";
				result = ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode like '"+vct.get(i).substring(0,2)+"%' ";
				rs=stm.executeQuery(sql);
				double val1=0.00;
				while(rs.next())
				{
					val1=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(val1-aaaa)+"' where subgroupcode like '"+vct.get(i).substring(0,2)+"%' ";
				result = ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode like '"+vct.get(i).substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				double val2=0.00;
				while(rs.next())
				{
					val2=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(val2-aaaa)+"' where groupcode like '"+vct.get(i).substring(0,2)+"' ";
				result = ConnectionDAO.executeUpdate(stm, sql);
			}
		}
		
		catch(Exception g)
		{
			System.out.println("payment delete error on:- "+g);
		}
		
		sql="delete from accounttransaction where id='"+id+"' ";
		result = ConnectionDAO.executeUpdate(stm, sql);	
		
		String sql22="delete from accountnarration where voucherno like '"+aaa+"' ";
		result = ConnectionDAO.executeUpdate(stm, sql22);	
		
		String sql33="delete from accountdetails where voucherno like '"+aaa+"' ";
		result = ConnectionDAO.executeUpdate(stm, sql33);	
		ConnectionDAO.closeConnection(conn);
		
		String x=findledger(b);
		return result+"con"+x+"con"+aaa.substring(10, aaa.length());
		}
//payment particulars list
	public static List<FormBean> paymentpartlist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		//System.out.println("hello");
		String sql1="select * from ledgermaster where ledgerid not like 'BA%' or ledgerid not like 'CH%' order by ledgername asc";
		//System.out.println(sql1);
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";	
		try 
			{
				ResultSet rs = stm.executeQuery(sql1);		
				FormBean usBean=new FormBean();	
				usBean.setPart("");
				l1.add(usBean);
				while (rs.next()) 
					{
						x=rs.getString(3);
						usBean = new FormBean();
						usBean.setPart(rs.getString(3));//for ledger particular list	
						//System.out.println(rs.getString(3));
						l1.add(usBean);	
					}		
			}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	public static List<FormBean> paymentpartlist5() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		//System.out.println("paymentpartlist");
		String sql1="select * from ledgermaster";  //have to change to 'BA'
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";	
		try 
			{
				ResultSet rs = stm.executeQuery(sql1);		
				FormBean usBean=new FormBean();
				usBean.setPart1("");
				l1.add(usBean);
				while (rs.next()) 
					{
						x=rs.getString(3);
						usBean = new FormBean();
						usBean.setPart1(rs.getString(3));//for ledger particular list1		
						//System.out.println("hello "+rs.getString(3));
						l1.add(usBean);	
					}		
			}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//payment partlist1
	public static List<FormBean> paymentpartlist1() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		//System.out.println("paymentpartlist");
		String sql1="select * from ledgermaster where ledgerid like 'CH%' or ledgerid like 'BA%' order by ledgername asc";  //have to change to 'BA'
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";	
		try 
			{
				ResultSet rs = stm.executeQuery(sql1);		
				FormBean usBean=new FormBean();
				usBean.setPart1("");
				l1.add(usBean);
				while (rs.next()) 
					{
						x=rs.getString(3);
						usBean = new FormBean();
						usBean.setPart1(rs.getString(3));//for ledger particular list1		
						//System.out.println("hello "+rs.getString(3));
						l1.add(usBean);	
					}		
			}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//payment ends
//report edit top a/c starts
	public static List<FormBean> reportedit() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		//System.out.println("paymentpartlist");
		String sql1="select * from ledgermaster order by ledgername asc";  //have to change to 'BA'
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String buffer,x="",x1="",x2="";	
		try 
			{
				ResultSet rs = stm.executeQuery(sql1);		
				FormBean usBean=new FormBean();
				usBean.setPart1("");
				l1.add(usBean);
				while (rs.next()) 
					{
						x=rs.getString(3);
						usBean = new FormBean();
						usBean.setPart1(rs.getString(3));//for ledger particular list1		
						//System.out.println("hello "+rs.getString(3));
						l1.add(usBean);	
					}		
			}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//report edit top a/c ends	
//receipt starts
	//receipt creation
		public static boolean receiptcreation(FormBean FormBean) {
			boolean result=false;		
			String sql = null;	
			String sql1 = null;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);	
			
			if (FormBean.getId() != null) 
			{					
				String s1[]=FormBean.getContra1();
				String s2[]=FormBean.getCredithidden();
				String s3[]=FormBean.getNarration1();
				double oldamount=0.00;
				String ledger="",voucher="";
				String entry="";
				sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
				try
				{
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledger=rs.getString(1);
						oldamount=rs.getDouble(2);
						voucher=rs.getString(3);
						entry=rs.getString(4);
					}
					String contradate="";
					if(FormBean.getContradate().equals(""))
					{
						contradate="0000-00-00";
					}
					else
					{
						contradate=FormBean.getContradate();
					}
					sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//resetting
					//ledger
					double ledbal=0.00;
					sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledbal=rs.getDouble(1);
					}
					//update ledgermaster
					sql="update ledgermaster set currentbalance='"+(ledbal-oldamount) +"' where ledgerid='"+ledger+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					double subgroupbal=0.00;
					while(rs.next())
					{
						subgroupbal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(subgroupbal-oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					double grpbal=0.00;
					while(rs.next())
					{
						grpbal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(grpbal-oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					String abcd="";
					double amou=0.00;
					
					Vector<String> ld=new Vector<String>();
					sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ld.add(rs.getString(1));
					}

					for(int i=0;i<ld.size();i++)//particular hidden array
					{
						if(i!=0)
						{
						sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						Vector<String> am=new Vector<String>();
						while(rs.next()) 
						{
							amou=rs.getDouble(1);//accountdetails
							am.add(rs.getString(1));
						}
						//System.out.println("part amount got "+amou);
						Vector<String> gt=new Vector<String>();
						
						//resetting ledgermaster,subgroupmaster,groupmaster
						//ledgermaster
						sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						double ledgerbal=0.00;
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							ledgerbal=rs.getDouble(1);
						}
						sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//subgroupmaster
						sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						double subbal=0.00;
						while(rs.next())
						{
							subbal=rs.getDouble(1);
						}
						sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//groupmaster
						sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						double gpbal=0.00;
						while(rs.next())
						{
							gpbal=rs.getDouble(1);
						}
						sql="update groupmaster set closingbalance='"+(gpbal-amou)+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						//resetting ends
						}
					}//loop ends
					
					sql="delete from accountdetails where voucherno='"+voucher+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//update to ledger
					sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
					rs=stm.executeQuery(sql);
					double newled=0.00;
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					//System.out.println("new led bal "+newled);
					sql="update ledgermaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					//update to subgroup
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
					//update group
					sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
					
					String led="",sql3="";
					double total=0.00;
					Vector<String> voucherno=new Vector<String>();
					for(int i=0;i<s2.length;i++)
					{
						//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
						//result=ConnectionDAO.executeUpdate(stm, sql4);
						
						sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							led=rs.getString(1);
						}
						
						sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+"-"+s2[i]+"', '"+s3[i]+"') ";
						//System.out.println(sql3);
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
						rs=stm.executeQuery(sql);
						double bal=0.00;
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						total=bal-Double.parseDouble(s2[i]);
						sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//getting voucherno from outstandingledger
						sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							voucherno.add(rs.getString(1));
						}	
						
						//deleting outstanding ledger
						sql="delete from outstandingledger where ledgerid='"+led+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//deleting adjustmentdetails ledger
						sql="delete from adjustmentdetails where ledgerid='"+led+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
					}
					int count=0;
					Vector<String> first=new Vector<String>();
					Vector<String> second=new Vector<String>();
					Vector<String> third=new Vector<String>();
					Vector<String> fourth=new Vector<String>();
					Vector<String> fifth=new Vector<String>();
					Vector<String> sixth=new Vector<String>();
					Vector<String> seventh=new Vector<String>();
					for(int j=0;j<s1.length;j++)
					{
						String b="";
						sql="select * from ledgermaster where ledgername='"+s1[j]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							b=rs.getString(5);
						}
						if(b.equals("Y"))
						{
							sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount,duesamount)values((select ledgerid from ledgermaster where ledgername='"+s3[j]+"'), '"+voucher+"', '"+FormBean.getContraref()+"', '"+FormBean.getContradate()+"', '"+s2[j]+"','"+s2[j]+"')";
							result=ConnectionDAO.executeUpdate(stm, sql);
							//System.out.println(sql);
						}
						String sql6="select ledgerid from ledgermaster where ledgername='"+s1[j]+"' ";
						//System.out.println("found "+sql6);
						ResultSet rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							abcd=rs2.getString(1);
						}
						sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
						//System.out.println(sql6);
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							count=rs2.getInt(1);
						}
						if(count >0)
						{
						for(int j1=1;j1<=count;j1++)
						{
							sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
							rs2=stm.executeQuery(sql6);
							while(rs2.next())
							{
								first.add(rs2.getString(2));
								second.add(rs2.getString(3));
								third.add(rs2.getString(4));
								fourth.add(rs2.getString(5));
								fifth.add(rs2.getString(6));
								sixth.add(rs2.getString(7));
								seventh.add(rs2.getString(8));
							}
							//insert outstandingledger
							sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"', '"+seventh.get(j1-1)+"')";
							//System.out.println(sql6);
							result=ConnectionDAO.executeUpdate(stm, sql6);
							
							//insert adjustmentdetails
							sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
							//System.out.println(sql6);
							result=ConnectionDAO.executeUpdate(stm, sql6);
							
							first.removeAllElements();
							second.removeAllElements();
							third.removeAllElements();
							fourth.removeAllElements();
							fifth.removeAllElements();
							sixth.removeAllElements();
							seventh.removeAllElements();
						}
						}
						else
						{}
					}
					
				}
				catch(Exception f)
				{
					System.out.println("receipt update error= "+f);
				}
			}
			else
			{
				//System.out.println("Date:- "+FormBean.getShowdate());
				String s1[]=FormBean.getNarration();
				String s2[]=FormBean.getCredit();
				String s3[]=FormBean.getPartforcontra();
				
				String receipt="RC";
				String receipt1="RB";
				String receipt2="1617";
				String voucher="";
				Vector<String> voucherno=new Vector<String>();
				String vno="";
				String zero="";
				int aa=0;
				String ledgerid="";
				String finalcode="";
				sql="select count(id) from accounttransaction where voucherno like 'RC%' or voucherno like 'RB%' ";
				sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
				try
				{
					ResultSet rs1=stm.executeQuery(sql1);
					while(rs1.next())
					{
						ledgerid=rs1.getString(1);
					}
					
					if(ledgerid.substring(0,2).equals("CH"))
					{
						receipt="RC"; 
					}
					else if(ledgerid.substring(0,2).equals("BA"))
					{
						receipt="RB";
					}
					
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						aa=rs.getInt(1);//got id
					}
					
					if(aa==0)
					{
						zero="0000";
						finalcode=receipt+receipt2+receipt2+zero+1;
					}
					else if(aa > 0 && aa < 9)
					{
						zero="0000";
						finalcode=receipt+receipt2+receipt2+zero+(aa+1);
						//System.out.println("max id is in 1-9,final code generated:- "+finalcode);
					}
					else if(aa > 8 && aa < 99)
					{
						zero="000";
						finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					}
					else if(aa > 98 && aa < 999)
					{
						zero="00";
						finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					}
					else if(aa > 998 && aa < 9999)
					{
						zero="0";
						finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					}
					else if(aa > 9998 && aa < 99999)
					{
						finalcode=receipt+receipt2+receipt2+(aa+1);
					}
					double abcd1=0.00,abcd2=0.00,abcd3=0.00,codeforsub=0.00;
					String abcd="";
					String contradate="";
					if(FormBean.getContradate().equals(""))
					{
						contradate="0000-00-00";
					}
					else
					{
						contradate=FormBean.getContradate();
					}
					sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','dr')";//insert				
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+FormBean.getTotal()+"') ";
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					//System.out.println("Narration details "+FormBean.getPrenar());
						
						String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'dr') ";
						//System.out.println(sql2);
						result=ConnectionDAO.executeUpdate(stm, sql2);
					
					
					//update to ledger
					ResultSet rs5=stm.executeQuery("select currentbalance from ledgermaster where ledgerid like '"+ledgerid+"' ");
					//System.out.println("select currentbalance from ledgermaster where ledgerid like '"+ledgerid+"' ");
					while(rs5.next())
					{
						abcd3=rs5.getDouble(1);
					}
					//System.out.println("receipt ledger cr bal: "+abcd3);
					double ii=Double.parseDouble(FormBean.getTotal());
					//System.out.println("receipt ledger: "+(abcd3+ii));	
					sql3="update ledgermaster set currentbalance='"+(abcd3+ii)+"' where ledgerid like '"+ledgerid+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					//for subgroupmaster 
					sql3="select currentbalance from subgroupmaster where subgroupcode like '"+ledgerid.substring(0,2)+"%' ";
					//System.out.println(sql3);
					ResultSet rs6=stm.executeQuery(sql3);
					while(rs6.next())
					{
						codeforsub=rs6.getDouble(1);
						//System.out.println("subgroup bal(receipt):- "+codeforsub);
					}

					double onlyforsub=codeforsub+ii;
					String sql33="update subgroupmaster set currentbalance='"+onlyforsub+"' where subgroupcode= '"+ledgerid.substring(0,5)+"' ";
				
					result=ConnectionDAO.executeUpdate(stm, sql33);
					
					//for groupmaster
					sql3="select closingbalance from groupmaster where groupcode like '"+ledgerid.substring(0,2)+"' ";
					rs6=stm.executeQuery(sql3);
					while(rs6.next())
					{
						codeforsub=rs6.getDouble(1);
					}
					
					sql3="update groupmaster set closingbalance='"+(codeforsub+ii)+"' where groupcode like '"+ledgerid.substring(0,2)+"%' ";
					
					result=ConnectionDAO.executeUpdate(stm, sql3);
					//System.out.println("part length:- "+s3.length);
					
					for(int i=0;i<s1.length;i++)
					{
						String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
						result=ConnectionDAO.executeUpdate(stm, sql4);
						
						//System.out.println("hello "+s3[i]);
						String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[i]+"' ";
						//System.out.println("found "+sql6);
						ResultSet rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							abcd=rs2.getString(1);
						}
						sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+abcd+"', '"+"-"+s2[i]+"', '"+s1[i]+"') ";
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						ResultSet rs3=stm.executeQuery("select currentbalance from ledgermaster where ledgerid like '"+abcd+"' ");
						while(rs3.next())
						{
							abcd1=rs3.getDouble(1);
						}
						//System.out.println("ledger bal got "+abcd1);
						ResultSet rs4=stm.executeQuery("select amount from accountdetails where ledgerid like '"+abcd+"' ");
						while(rs4.next())
						{
							abcd2=rs4.getDouble(1);
						}
						//System.out.println("accountdetails bal got "+abcd2);
						double test=(abcd1+abcd2);
						//System.out.println("final amount:- "+test);
						sql3="update ledgermaster set currentbalance='"+test+"' where ledgerid like '"+abcd+"' ";
						//System.out.println(sql3);
						result = ConnectionDAO.executeUpdate(stm, sql3);
						
						double subpart=0.00;
						
						// subgroup update for particulars
						sql33="select currentbalance from subgroupmaster where subgroupcode= '"+abcd.substring(0,5)+"' "; 
		                //System.out.println(sql33);
						rs4=stm.executeQuery(sql33); 
						while(rs4.next())
						{
							subpart=rs4.getDouble(1);//subgroup current bal
						}
						//System.out.println("subgroup bal: "+subpart);
						
						double temp=Double.parseDouble(s2[i]);
						String led="";
						//System.out.println("subgroup bal will be for array: = "+(subpart-temp));
						sql3="update subgroupmaster set currentbalance='"+(subpart-temp)+"' where subgroupcode like '"+abcd.substring(0,5)+"' ";
						//System.out.println(sql3);
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						//group update for particulars
						sql33="select closingbalance from groupmaster where groupcode like '"+abcd.substring(0,2)+"%' ";
						//System.out.println(sql33);
						rs4=stm.executeQuery(sql33); 
						while(rs4.next())
						{
							subpart=rs4.getDouble(1);//group closing bal
						}
						//System.out.println("group closing bal got:- "+subpart);
						sql3="select ledgerid from ledgermaster where ledgername like '"+s3[i]+"%' ";
						//System.out.println("getting ledger id from ledger master:- "+sql3);
						rs4=stm.executeQuery(sql3);
						while(rs4.next())
						{
							led=rs4.getString(1).substring(0,2);
						}
						//System.out.println("2ch id got:- "+led); 
						sql3="update groupmaster set closingbalance='"+(subpart-temp)+"' where groupcode= '"+led+"' ";		
						//System.out.println("update for group:- "+sql3);
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						//getting voucherno from outstandingledger
						sql="select voucherno from outstandingledger where ledgerid='"+abcd+"'";
						rs4=stm.executeQuery(sql);
						while(rs4.next())
						{
							voucherno.add(rs4.getString(1));
							//System.out.println();
						}	
						
						//deleting outstanding ledger
						sql="delete from outstandingledger where ledgerid='"+abcd+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//deleting adjustmentdetails ledger
						sql="delete from adjustmentdetails where ledgerid='"+abcd+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
					}//loop end
					
					int count=0;
					Vector<String> first=new Vector<String>();
					Vector<String> second=new Vector<String>();
					Vector<String> third=new Vector<String>();
					Vector<String> fourth=new Vector<String>();
					Vector<String> fifth=new Vector<String>();
					Vector<String> sixth=new Vector<String>();
					Vector<String> seventh=new Vector<String>();
					for(int j=0;j<s1.length;j++)
					{
						String b="";
						sql="select * from ledgermaster where ledgername='"+s3[j]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							b=rs.getString(5);
						}
						if(b.equals("Y"))
						{
							sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount,duesamount)values((select ledgerid from ledgermaster where ledgername='"+s3[j]+"'), '"+finalcode+"', '"+FormBean.getContraref()+"', '"+FormBean.getContradate()+"', '"+s2[j]+"','"+s2[j]+"')";
							result=ConnectionDAO.executeUpdate(stm, sql);
							//System.out.println(sql);
						}
						String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
						//System.out.println("found "+sql6);
						ResultSet rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							abcd=rs2.getString(1);
						}
						sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
						//System.out.println(sql6);
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							count=rs2.getInt(1);
						}
						//System.out.println("count value "+count);
						if(count > 0)
						{
						for(int j1=0;j1<count;j1++)
						{
							//System.out.println("loop value "+j1);
							sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
							//System.out.println(sql6);
							rs2=stm.executeQuery(sql6);
							while(rs2.next())
							{
								first.add(rs2.getString(2));
								second.add(rs2.getString(3));
								third.add(rs2.getString(4));
								fourth.add(rs2.getString(5));
								fifth.add(rs2.getString(6));
								sixth.add(rs2.getString(7));
								seventh.add(rs2.getString(8));
							}
							//insert outstandingledger
							sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, preadjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"', '"+seventh.get(j1)+"') ";
							//System.out.println(sql6);
							result=ConnectionDAO.executeUpdate(stm, sql6);
							
							//insert adjustmentdetails
							sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
							//System.out.println(sql6);
							result=ConnectionDAO.executeUpdate(stm, sql6);
							
							first.removeAllElements();
							second.removeAllElements();
							third.removeAllElements();
							fourth.removeAllElements();
							fifth.removeAllElements();
							sixth.removeAllElements();
							seventh.removeAllElements();
						}
						
						}
						else if(count==0)
						{
							//System.out.println("count 0");
						}
					}
					
				}
				catch(Exception f)
				{
					System.out.println("error on receipt creation:- "+f);
				}
			}
			ConnectionDAO.closeConnection(conn);
			return result;
			}
//findfirsthead
private static String findfirsthead(String abcd)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	Vector<String> vct=new Vector<String>();
	String sql="";
	try
	{
		sql="select * from accountdetails where voucherno='"+abcd+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			vct.add(rs.getString(4));
		}
	}
	catch(Exception gh)
	{
		System.out.println("error in findfirsthead "+gh);
	}
	ConnectionDAO.closeConnection(conn);
	return vct.get(1);
}
	//receipt list
		public static List<FormBean> receiptlist() 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			String sql = "select * from accounttransaction where voucherno like 'RC%' or voucherno like 'RB%' order by id desc";
			//String sql1="select max(id) from accountdetails";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			String le="";
			/*Map<String, Object> s4cf = ActionContext.getContext().getSession();
			String valu=(String) s4cf.get("fin");
			String array[]=valu.split("-");
			System.out.println("ultimate "+array[0].substring(2, 4)+array[1].substring(2, 4));*/
			try 
				{
					ResultSet rs = stm.executeQuery(sql);
					FormBean usBean,usBean1;
					while (rs.next()) 
						{
						usBean = new FormBean();
						usBean.setId(rs.getInt(1));//for id
						usBean.setShowdate(rs.getString(2));//entry date
						usBean.setContraref(rs.getString(4));//ref no
						usBean.setContradate(rs.getString(5));//ref date
						usBean.setTotal(rs.getString(7));
						
						String vno=findfirsthead(rs.getString(3));
						usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
						usBean.setPart1(findledger(vno));
						l1.add(usBean);		
						}
				} 
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
//function for transaction
public static String findledger(String xx)
{
	String x3="",x1="";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		String sql="select ledgername from ledgermaster where ledgerid='"+xx+"'";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			x3=rs.getString(1);
		}
		//System.out.println("ledger name got "+x3);
	}
	catch(Exception hh)
	{
		System.out.println("error in transaction ledger function "+hh);
	}
	ConnectionDAO.closeConnection(conn);
	return x3;
}
	//receipt delete
		public static boolean receiptdelete(int id) {
			boolean result = false;		
			String sql = "select voucherno,ledgerid from accounttransaction where id='"+id+"' ";
			String sql1="",sql3="";
			String a="",b="",c="",aaa="";
			double aaaa=0.00;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try
			{
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					a=rs.getString(1);//voucherno
					aaa=rs.getString(1);//voucherno
					b=rs.getString(2);//ledgerid
				}
				
				sql="select amount from accountdetails where ledgerid='"+b+"' ";//getting total amount 
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					a=rs.getString(1);
				}
				
				sql="select currentbalance from ledgermaster where ledgerid='"+b+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getString(1); 
				}
				double cc=Double.parseDouble(c);
				double aa=Double.parseDouble(a);
				sql1="update ledgermaster set currentbalance='"+(cc-aa)+"' where ledgerid='"+b+"' ";//have to change
				result = ConnectionDAO.executeUpdate(stm, sql1);
				
				sql="select currentbalance from subgroupmaster where subgroupcode like '"+b+"%' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getString(1);
				}
				cc=Double.parseDouble(c);//subgroup cr bal
				sql1="update subgroupmaster set currentbalance='"+(cc-aa)+"' where subgroupcode like '"+b+"%' ";
				result = ConnectionDAO.executeUpdate(stm, sql1);
				
				sql="select closingbalance from groupmaster where groupcode like '"+b+"%' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getString(1);
				}
				cc=Double.parseDouble(c);//subgroup cr bal
				sql1="update groupmaster set closingbalance='"+(cc-aa)+"' where groupcode like '"+b+"%' ";
				result = ConnectionDAO.executeUpdate(stm, sql1);
				
				sql3="select ledgerid from accountdetails where voucherno like '"+aaa+"' ";
				
				rs=stm.executeQuery(sql3);
				Vector<String> vct = new Vector<String>();
				
				while(rs.next())
				{
					vct.add((String)rs.getString(1));
				}
				for(int i=1;i<vct.size();i++)
				{
					sql="select amount from accountdetails where ledgerid like '"+vct.get(i)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						aaaa=rs.getDouble(1);//credit amount
					}
					
					sql="select currentbalance from ledgermaster where ledgerid like '"+vct.get(i)+"' ";
					rs=stm.executeQuery(sql);
					double val=0.00;  
					while(rs.next())
					{
						val=rs.getDouble(1);
					}
					
					sql="update ledgermaster set currentbalance='"+(val+aaaa)+"' where ledgerid like '"+vct.get(i)+"' ";
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode like '"+vct.get(i).substring(0,2)+"%' ";
					rs=stm.executeQuery(sql);
					double val1=0.00;
					while(rs.next())
					{
						val1=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(val1+aaaa)+"' where subgroupcode like '"+vct.get(i).substring(0,2)+"%' ";
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode like '"+vct.get(i).substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					double val2=0.00;
					while(rs.next())
					{
						val2=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(val2+aaaa)+"' where groupcode like '"+vct.get(i).substring(0,2)+"' ";
					result = ConnectionDAO.executeUpdate(stm, sql);
				}
			}
			
			catch(Exception g)
			{
				System.out.println("receipt delete error on:- "+g);
			}
			
			/*sql="delete from accounttransaction where id='"+id+"' ";
			result = ConnectionDAO.executeUpdate(stm, sql);	
			
			String sql22="delete from accountnarration where voucherno like '"+aaa+"' ";
			result = ConnectionDAO.executeUpdate(stm, sql22);	
			
			String sql33="delete from accountdetails where voucherno like '"+aaa+"' ";
			result = ConnectionDAO.executeUpdate(stm, sql33);	
			ConnectionDAO.closeConnection(conn);*/
			return result;
			}
//receipt ends here
		
//contra starts here
//contra creation
		public static boolean contracreation(FormBean FormBean) {
			boolean result=false;	
			String sql = null;	
			String sql1 = null;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);	
			
			if (FormBean.getId() != null) 
			{					
				//String brand= FormBean.getBname();
				//System.out.println("hello");
				//System.out.println("id= "+FormBean.getId());
				//System.out.println("id "+FormBean.getId());     id comming  properly
				String s1[]=FormBean.getContra1();
				String s2[]=FormBean.getCredithidden();
				String s3[]=FormBean.getNarration1();
				double oldamount=0.00;
				String ledger="",voucher="";
				String entry="";
				sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
				try
				{
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledger=rs.getString(1);
						oldamount=rs.getDouble(2);
						voucher=rs.getString(3);
						entry=rs.getString(4);
					}
					String contradate="";
					if(FormBean.getContradate().equals(""))
					{
						contradate="0000-00-00";
					}
					else
					{
						contradate=FormBean.getContradate();
					}
					sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
					result=ConnectionDAO.executeUpdate(stm, sql);
					//resetting
					//ledger
					double ledbal=0.00;
					sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledbal=rs.getDouble(1);
					}
					//update ledgermaster
					sql="update ledgermaster set currentbalance='"+(ledbal-oldamount) +"' where ledgerid='"+ledger+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					double subgroupbal=0.00;
					while(rs.next())
					{
						subgroupbal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(subgroupbal-oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					double grpbal=0.00;
					while(rs.next())
					{
						grpbal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(grpbal-oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					String abcd="";
					double amou=0.00;
					
					Vector<String> ld=new Vector<String>();
					sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ld.add(rs.getString(1));
					}
					//System.out.println("length "+s2.length);
					for(int i=0;i<ld.size();i++)//particular hidden array
					{
						
						//System.out.println("Vector: "+ld.size());
						//int k=1;
						if(i!=0)
						{
						sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						Vector<String> am=new Vector<String>();
						while(rs.next()) 
						{
							amou=rs.getDouble(1);//accountdetails
							am.add(rs.getString(1));
						}
						//System.out.println("part amount got "+amou);
						Vector<String> gt=new Vector<String>();
						
						//resetting ledgermaster,subgroupmaster,groupmaster
						//ledgermaster
						sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						double ledgerbal=0.00;
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							ledgerbal=rs.getDouble(1);
						}
						sql="update ledgermaster set currentbalance='"+(ledgerbal+amou)+"' where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//subgroupmaster
						sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						double subbal=0.00;
						while(rs.next())
						{
							subbal=rs.getDouble(1);
						}
						sql="update subgroupmaster set currentbalance='"+(subbal+amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//groupmaster
						sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						double gpbal=0.00;
						while(rs.next())
						{
							gpbal=rs.getDouble(1);
						}
						sql="update groupmaster set closingbalance='"+(gpbal+amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						//resetting ends
					}
					}
					
					sql="delete from accountdetails where voucherno='"+voucher+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//update to ledger
					sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
					rs=stm.executeQuery(sql);
					double newled=0.00;
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					//System.out.println("new led bal "+newled);
					sql="update ledgermaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//update to subgroup
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//update group
					sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					String led="",sql3="";
					double total=0.00;
					for(int i=0;i<s2.length;i++)
					{
						//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
						//result=ConnectionDAO.executeUpdate(stm, sql4);
						
						sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							led=rs.getString(1);
						}
						
						sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+"-"+s2[i]+"', '"+s3[i]+"') ";
						//System.out.println(sql3);
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
						rs=stm.executeQuery(sql);
						double bal=0.00;
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						total=bal-Double.parseDouble(s2[i]);
						sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql);
					}
					
				}
				catch(Exception f)
				{
					System.out.println("contra update error= "+f);
				}
			}
			else
			{
				//System.out.println("Date:- "+FormBean.getShowdate());
				String s1[]=FormBean.getNarration();
				String s2[]=FormBean.getCredit();
				String s3[]=FormBean.getPartforcontra();
				String cont="CO";
				String cont1="1617";
				String zero="";
				int aa=0;
				String abcd="";
				double abcd1=0.00,abcd2=0.00,abcd3=0.00,codeforsub=0.00;
				String ledgerid="";
				String finalcode="";
				sql="select count(id) from accounttransaction where voucherno like 'CO%'";
				sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
				try
				{
					ResultSet rs1=stm.executeQuery(sql1);
					while(rs1.next())
					{
						ledgerid=rs1.getString(1);
					}
					//System.out.println("ledgerid got from contra is:- "+ledgerid);
					
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						aa=rs.getInt(1);
					}
					
					//checking starts for id
					if(aa==0)
					{
						zero="0000";
						finalcode=cont+cont1+cont1+zero+1;
						
					}
					else if(aa > 0 && aa < 9)
					{
						zero="0000";
						finalcode=cont+cont1+cont1+zero+(aa+1);
					}
					else if(aa > 8 && aa < 99)
					{
						zero="000";
						finalcode=cont+cont1+cont1+zero+(aa+1);
					}
					else if(aa > 98 && aa < 999)
					{
						zero="00";
						finalcode=cont+cont1+cont1+zero+(aa+1);
					}
					else if(aa > 998 && aa < 9999)
					{
						zero="0";
						finalcode=cont+cont1+cont1+zero+(aa+1);
					}
					else if(aa > 9998 && aa < 99999)
					{
						finalcode=cont+cont1+cont1+(aa+1);
					}
					//checking ends
						//top debit a/c
						String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+FormBean.getTotal()+"') ";
						result=ConnectionDAO.executeUpdate(stm, sql3);
						String contraref="",contradate="";
						
						if(FormBean.getContradate().equals(""))
						{
							contradate="0000-00-00";
						}
						else
						{
							contradate=FormBean.getContradate();
						}
						sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','dr')";//insert				
						//System.out.println(sql);
						result = ConnectionDAO.executeUpdate(stm, sql);
						
						
							String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'dr') ";
							result=ConnectionDAO.executeUpdate(stm, sql2);
						
						
						ResultSet rs5=stm.executeQuery("select currentbalance from ledgermaster where ledgerid like '"+ledgerid+"' ");
						while(rs5.next())
						{
							abcd3=rs5.getDouble(1);
						}
						double ii=Double.parseDouble(FormBean.getTotal());
						sql3="update ledgermaster set currentbalance='"+(abcd3+ii)+"' where ledgerid like '"+ledgerid+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						//for subgroupmaster 
						sql3="select currentbalance from subgroupmaster where subgroupcode like '"+ledgerid.substring(0,2)+"%' ";
						//System.out.println(sql3);
						ResultSet rs6=stm.executeQuery(sql3);
						while(rs6.next())
						{
							codeforsub=rs6.getDouble(1);
							//System.out.println("subgroup bal:- "+codeforsub);
						}
						//System.out.println("subgroup bal will be:- "+(codeforsub+ii));
						double onlyforsub=codeforsub+ii;
						String sql33="update subgroupmaster set currentbalance='"+onlyforsub+"' where subgroupcode= '"+ledgerid.substring(0,5)+"' ";
						//System.out.println(sql33);
						result=ConnectionDAO.executeUpdate(stm, sql33);
						
						//for groupmaster
						sql3="select closingbalance from groupmaster where groupcode like '"+ledgerid.substring(0,2)+"' ";
						rs6=stm.executeQuery(sql3);
						while(rs6.next())
						{
							codeforsub=rs6.getDouble(1);
						}
						sql3="update groupmaster set closingbalance='"+(codeforsub+ii)+"' where groupcode like '"+ledgerid.substring(0,2)+"%' ";
						//System.out.println("groupmaster debit:- "+sql3);
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						
						for(int i=0;i<s1.length;i++)
						{
							String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
							result=ConnectionDAO.executeUpdate(stm, sql4);
							
							String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[i]+"' ";
							
							ResultSet rs2=stm.executeQuery(sql6);
							while(rs2.next())
							{
								abcd=rs2.getString(1);
							}
							sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+abcd+"', '"+"-"+s2[i]+"', '"+s1[i]+"') ";
							result=ConnectionDAO.executeUpdate(stm, sql3);
							
							ResultSet rs3=stm.executeQuery("select currentbalance from ledgermaster where ledgerid like '"+abcd+"' ");
							while(rs3.next())
							{
								abcd1=rs3.getDouble(1);
							}
							//System.out.println("ledger bal got "+abcd1);
							ResultSet rs4=stm.executeQuery("select amount from accountdetails where ledgerid like '"+abcd+"' ");
							while(rs4.next())
							{
								abcd2=rs4.getDouble(1);
							}
							//System.out.println("accountdetails bal got "+abcd2);
							double test=(abcd1+abcd2);
							//System.out.println("final amount:- "+test);
							sql3="update ledgermaster set currentbalance='"+test+"' where ledgerid like '"+abcd+"' ";
							result = ConnectionDAO.executeUpdate(stm, sql3);
							
							double subpart=0.00;
							
							// subgroup update for particulars
							sql33="select currentbalance from subgroupmaster where subgroupcode= '"+abcd.substring(0,5)+"' "; 
			                //System.out.println(sql33);
							rs4=stm.executeQuery(sql33); 
							while(rs4.next())
							{
								subpart=rs4.getDouble(1);//subgroup current bal
							}
							//System.out.println("subgroup bal: "+subpart);
							
							double temp=Double.parseDouble(s2[i]);
							String led="";
							//System.out.println("subgroup bal will be for array: = "+(subpart-temp));
							sql3="update subgroupmaster set currentbalance='"+(subpart-temp)+"' where subgroupcode like '"+ledgerid.substring(0,2)+"%' ";
							result=ConnectionDAO.executeUpdate(stm, sql3);
							
							//group update for particulars
							sql33="select closingbalance from groupmaster where groupcode like '"+abcd.substring(0,2)+"%' ";
							rs4=stm.executeQuery(sql33); 
							while(rs4.next())
							{
								subpart=rs4.getDouble(1);//group closing bal
							}
							sql3="select ledgerid from ledgermaster where ledgername like '"+s3[i]+"%' ";
							rs4=stm.executeQuery(sql3);
							while(rs4.next())
							{
								led=rs4.getString(1).substring(0,2);
							}
							sql3="update groupmaster set closingbalance='"+(subpart-temp)+"' where groupcode like '"+led+"%' ";						
							result=ConnectionDAO.executeUpdate(stm, sql3);
							
						}//loop end			 	 
				}
				catch(Exception f)
				{
					System.out.println("error on contra creation:- "+f);
				}
			}
			ConnectionDAO.closeConnection(conn);
			return result;
		}
//contra narration list
		public static List<FormBean> contranar() 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			String sql="select * from narrationmaster";
			try
			{
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next()) 
				{
					FormBean usBean=new FormBean();
					usBean.setPrenar(rs.getString(3));
					l1.add(usBean);
				}
			}
			catch(Exception j)
			{
				
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
//contra list
		public static List<FormBean> contralist() 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			String sql = "select * from accounttransaction where voucherno like 'CO%' order by id desc";
			//String sql1="select max(id) from accountdetails";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			String le="";
			try 
				{
					ResultSet rs = stm.executeQuery(sql);
					FormBean usBean;
					while (rs.next()) 
						{
						usBean = new FormBean();
						
						usBean.setId(rs.getInt(1));//for id
						usBean.setShowdate(rs.getString(2));//entry date
						usBean.setContraref(rs.getString(4));//ref no
						usBean.setContradate(rs.getString(5));//ref date
						usBean.setTotal(rs.getString(7));
						
						String vno=findfirsthead(rs.getString(3));
						usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
						usBean.setPart1(findledger(vno));
						l1.add(usBean);		
						}
				} 
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
			
		}
//contra contradynamiclist
		public static List<FormBean> contradynamiclist(int id)
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			//copying from here
			String sql="select voucherno from accounttransaction where id='"+id+"' ";
			try
			{	
				FormBean usBean;
				String voucherno="";
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				sql="select ledgerid,amount,narration from accountdetails where voucherno='"+voucherno+"' ";
				rs=stm.executeQuery(sql);
				Vector<String> vledger=new Vector<String>();
				Vector<String> vamount=new Vector<String>();
				Vector<String> vnarration=new Vector<String>();
				while(rs.next())
				{
					vledger.add(rs.getString(1));
					vamount.add(rs.getString(2));
					vnarration.add(rs.getString(3));
				}
				//System.out.println(vnarration.size());
				String[] nar=new String[vnarration.size()];
				for(int i=0;i<vnarration.size();i++)
				{
						nar[i]=vnarration.get(i);
						//System.out.println("hello= "+nar[i]);
				}
				usBean=new FormBean();
				usBean.setNarration(nar);
				//copy upto here
				l1.add(usBean);
			}
			catch(Exception f)
			{
				System.out.println("contra dynamic table edit error:- "+f);
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
//contra update
		public static FormBean contraedit(int id) {
			FormBean usBean = new FormBean();
			String sql = "select id,voucherno,ledgerid,entrydate,totalamount from accounttransaction where id =" + id;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try 
			{
				String ledgerid="",voucherno="",entrydate="",total="";
				ResultSet rs=stm.executeQuery(sql);
				//double total=0.00;
				
				while(rs.next())
				{
					usBean.setId(rs.getInt(1));
					ledgerid=rs.getString(3);
					voucherno=rs.getString(2);
					entrydate=rs.getString(4);
					total=rs.getString(5);
				}
				//System.out.println("Total: "+total);
				
				usBean.setSrno( voucherno.substring( voucherno.length()-1,voucherno.length() ) );
				usBean.setTotal(total);
				usBean.setShowdate(entrydate);
				sql="select ledgername from ledgermaster where ledgerid = '"+ledgerid+"' ";
				rs=stm.executeQuery(sql);
				String ledgername="";
				while(rs.next())
				{
					ledgername=rs.getString(1);
				}
				usBean.setPart1(ledgername);
				
				sql="select narration from accountnarration where voucherno = '"+voucherno+"' ";
				rs=stm.executeQuery(sql);
				String narration="";
				while(rs.next())
				{
					narration=rs.getString(1);
				}
				usBean.setDesc1(narration);
				
				sql="select referenceno,referencedate from accounttransaction where voucherno = '"+voucherno+"' ";
				rs=stm.executeQuery(sql);
				String refno="",refdate="";
				while(rs.next())
				{
					refno=rs.getString(1);
					refdate=rs.getString(2);
				}
				//System.out.println("test "+refno+"   "+refdate);
				usBean.setContraref(refno);
				usBean.setContradate(refdate);
				
				//for dynamic
				sql="select ledgerid,amount,narration from accountdetails where voucherno = '"+voucherno+"'";
				rs=stm.executeQuery(sql);
				Vector<String> nar=new Vector<String>();
				ArrayList<String> narshow=new ArrayList<String>();
				while(rs.next())
				{
					nar.add(rs.getString(3));
				}
				for(int i=1;i<nar.size();i++)
				{
					narshow.add(nar.get(i)); 
				}
				
				sql="select voucherno from accounttransaction where id='"+id+"' ";
					
					String voucherno1="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						voucherno1=rs.getString(1);
					}
					sql="select ledgerid,amount,narration from accountdetails where voucherno='"+voucherno1+"' ";
					rs=stm.executeQuery(sql);
					Vector<String> vledger=new Vector<String>();
					Vector<String> vledger1=new Vector<String>();
					Vector<String> vamount=new Vector<String>();
					Vector<String> vnarration=new Vector<String>();
					while(rs.next())
					{
						vledger.add(rs.getString(1));
						vamount.add(rs.getString(2));
						vnarration.add(rs.getString(3));
					}
					String ledgergot="";
					String[] nar1=new String[vnarration.size()-1];
					String[] amount1=new String[vamount.size()-1];
					String[] ledger1=new String[vledger.size()-1];
					for(int i=1;i<vnarration.size();i++)
					{
							nar1[i-1]=vnarration.get(i);
							String tot=vamount.get(i);
							amount1[i-1]=tot.replaceAll("-", "");
							
							sql="select ledgername from ledgermaster where ledgerid='"+vledger.get(i)+"' ";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								ledger1[i-1]=rs.getString(1);
								//System.out.println("ledger got:- "+rs.getString(1));
								//vledger1.add(rs.getString(1));
							}
							//ledger1[i-1]=vledger1.get(i); 
							//System.out.println("hello "+ledger1[0]);
					}
					
					//usBean=new FormBean();
					usBean.setNarration(nar1);
					usBean.setCredit(amount1);
					
					usBean.setQuantity(ledger1);
					
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			ConnectionDAO.closeConnection(conn);
			return usBean;
			
		}
//contra delete
		public static String contradelete(int id) {
			boolean result = false;		
			String sql = "select voucherno,ledgerid from accounttransaction where id='"+id+"' ";
			String sql1="",sql3="";
			String a="",b="",c="",aaa="";
			double aaaa=0.00;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try
			{
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					a=rs.getString(1);//voucherno
					aaa=rs.getString(1);//voucherno
					b=rs.getString(2);//ledgerid
				}
				
				sql="select amount from accountdetails where ledgerid='"+b+"' ";//getting total amount 
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					a=rs.getString(1);
				}
				
				sql="select currentbalance from ledgermaster where ledgerid='"+b+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getString(1); 
				}
				double cc=Double.parseDouble(c);
				double aa=Double.parseDouble(a);
				sql1="update ledgermaster set currentbalance='"+(cc-aa)+"' where ledgerid='"+b+"' ";//have to change
				result = ConnectionDAO.executeUpdate(stm, sql1);
				
				sql="select currentbalance from subgroupmaster where subgroupcode like '"+b+"%' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getString(1);
				}
				cc=Double.parseDouble(c);//subgroup cr bal
				sql1="update subgroupmaster set currentbalance='"+(cc-aa)+"' where subgroupcode like '"+b+"%' ";
				result = ConnectionDAO.executeUpdate(stm, sql1);
				
				sql="select closingbalance from groupmaster where groupcode like '"+b+"%' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getString(1);
				}
				cc=Double.parseDouble(c);//subgroup cr bal
				sql1="update groupmaster set closingbalance='"+(cc-aa)+"' where groupcode like '"+b+"%' ";
				result = ConnectionDAO.executeUpdate(stm, sql1);
				
				sql3="select ledgerid from accountdetails where voucherno like '"+aaa+"' ";
				
				rs=stm.executeQuery(sql3);
				Vector<String> vct = new Vector<String>();
				
				while(rs.next())
				{
					vct.add((String)rs.getString(1));
				}
				for(int i=1;i<vct.size();i++)
				{
					sql="select amount from accountdetails where ledgerid like '"+vct.get(i)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						aaaa=rs.getDouble(1);//credit amount
					}
					
					sql="select currentbalance from ledgermaster where ledgerid like '"+vct.get(i)+"' ";
					rs=stm.executeQuery(sql);
					double val=0.00;  
					while(rs.next())
					{
						val=rs.getDouble(1);
					}
					
					sql="update ledgermaster set currentbalance='"+(val-aaaa)+"' where ledgerid like '"+vct.get(i)+"' ";
					//System.out.println(sql);
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode like '"+vct.get(i).substring(0,2)+"%' ";
					rs=stm.executeQuery(sql);
					double val1=0.00;
					while(rs.next())
					{
						val1=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(val1-aaaa)+"' where subgroupcode like '"+vct.get(i).substring(0,2)+"%' ";
					result = ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode like '"+vct.get(i).substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					double val2=0.00;
					while(rs.next())
					{
						val2=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(val2-aaaa)+"' where groupcode like '"+vct.get(i).substring(0,2)+"' ";
					result = ConnectionDAO.executeUpdate(stm, sql);
				}
			}
			catch(Exception g)
			{
				System.out.println("contra delete error on:- "+g);
			}
			
			sql="delete from accounttransaction where id='"+id+"' ";
			result = ConnectionDAO.executeUpdate(stm, sql);	
			
			String sql22="delete from accountnarration where voucherno like '"+aaa+"' ";
			result = ConnectionDAO.executeUpdate(stm, sql22);	
			
			String sql33="delete from accountdetails where voucherno like '"+aaa+"' ";
			result = ConnectionDAO.executeUpdate(stm, sql33);	
			ConnectionDAO.closeConnection(conn);
			
			String l=findledger(b);
			return result+"con"+l+"con"+aaa.substring(10,aaa.length());
			}
//contra first time particular list
		public static List<FormBean> partlist() 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			String sql1="select * from ledgermaster";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			String buffer,x="",x1="",x2="";	
			
			try 
				{
					ResultSet rs = stm.executeQuery(sql1);		
					FormBean usBean=new FormBean();	
					
					usBean = new FormBean();
					usBean.setPart1("");	
					l1.add(usBean);	
					
					while (rs.next()) 
						{
							x=rs.getString(3);
							usBean = new FormBean();
							usBean.setPart1(rs.getString(3));	
							l1.add(usBean);	
						}		
				}
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
		
//contra edit		
		public static List<FormBean> partlist1(int id) 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			String sql="select voucherno from accounttransaction where id='"+id+"' ";
			String sql1="";
			String getledgerid="";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			String buffer,x="",x1="",x2="";	
			try 
				{
					ResultSet rs1=stm.executeQuery(sql);//getting voucherno from accounttransaction
					while(rs1.next())
					{
						getledgerid=rs1.getString(1);
					}
					sql1="select ledgerid from accountdetails where voucherno='"+getledgerid+"' ";
					//System.out.println(sql1);
					ResultSet rs = stm.executeQuery(sql1);//getting ledgerid from accountdetails		
					FormBean usBean;
					Vector<String> vledger=new Vector<String>();
					String ledger="";
					while (rs.next()) 
						{
							if(rs.isFirst()==true)
							{
							//System.out.println(rs.getString(1));
							ledger=rs.getString(1);
							}
							//vledger.add(ledger);
						}	
					//for(int i=0;i<vledger.size();i++)
					//{
						sql="select ledgername from ledgermaster where ledgerid like '%CH%' or ledgerid like '%BA%' and ledgerid != '"+ledger+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							usBean=new FormBean();
							usBean.setPart1(rs.getString(1));
							//System.out.println("Test: "+rs.getString(1));
							l1.add(usBean);
						}
					//}
					
				}
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}	
//contra ends here
//journal starts here
		//journal creation
				public static boolean journalcreation(FormBean FormBean) {
					boolean result=false;		
					String sql = null;	
					String sql1 = null;
					Connection conn = ConnectionDAO.getConnectionObject();
					Statement stm = ConnectionDAO.createStatement(conn);	
					
					if (FormBean.getId() != null) 
					{	
						try
						{
						ResultSet rs;
						String voucherno="";
						Vector<String> voucher=new Vector<String>();
						String dorc[]=FormBean.getDorchidden();
						String particular[]=FormBean.getContra1();
						String credit[]=FormBean.getCredithidden();
						String debit[]=FormBean.getDebithidden();
						String narration[]=FormBean.getNarration1();
						if(dorc[0].equals("dr"))
						{
							sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+FormBean.getContradate()+"', totalamount='"+FormBean.getTotal1()+"', vouchertype='dr' where id='"+FormBean.getId()+"'";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
						else if(dorc[0].equals("cr"))
						{
							sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+FormBean.getContradate()+"', totalamount='"+FormBean.getTotal()+"', vouchertype='cr' where id='"+FormBean.getId()+"'";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
						
						sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select voucherno from accounttransaction where id='"+FormBean.getId()+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							voucherno=rs.getString(1);
						}
						Vector<String> amount=new Vector<String>();
						Vector<String> ledgerid=new Vector<String>();
						double bal=0.00;
						sql="select amount,ledgerid from accountdetails where voucherno='"+voucherno+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							amount.add(rs.getString(1));
							ledgerid.add(rs.getString(2));
						}
						for(int i=0;i<amount.size();i++)
						{
							if(Double.parseDouble(amount.get(i)) < 0 )
							{
								//ledger update
								sql="select currentbalance from ledgermaster where ledgerid='"+ledgerid.get(i)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update ledgermaster set currentbalance='"+(bal+Double.parseDouble(amount.get(i)))+"' where ledgerid='"+ledgerid.get(i)+"'";
								//System.out.println("<0 "+sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//subgroup update
								sql="select currentbalance from subgroupmaster where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(amount.get(i)))+"' where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								//System.out.println("<0 "+sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//group update
								sql="select closingbalance from groupmaster where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(amount.get(i)))+"' where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								//System.out.println("<0 "+sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							else if(Double.parseDouble(amount.get(i)) > 0)
							{
								//ledger update
								sql="select currentbalance from ledgermaster where ledgerid='"+ledgerid.get(i)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update ledgermaster set currentbalance='"+(bal-Double.parseDouble(amount.get(i)))+"' where ledgerid='"+ledgerid.get(i)+"'";
								//System.out.println(">0 "+sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//subgroup update
								sql="select currentbalance from subgroupmaster where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(amount.get(i)))+"' where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								//System.out.println(">0 "+sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//group update
								sql="select closingbalance from groupmaster where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(amount.get(i)))+"' where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								//System.out.println(">0 "+sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
						}//loop ends
						sql="delete from accountdetails where voucherno='"+voucherno+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						String ledger="";
						double crbal=0.00;
						//insert into accountdetails
						for(int i=0;i<dorc.length;i++)
						{
							//getting ledgerid
							sql="select ledgerid from ledgermaster where ledgername='"+particular[i]+"'";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								ledger=rs.getString(1);
							}

							//to account details
							if(dorc[i].equals("cr"))
							{	
								sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration)values('"+voucherno+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+credit[i]+"', '"+narration[i]+"')";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//update to ledgermaster
								sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
								//System.out.println(sql);
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									crbal=rs.getDouble(1);
								}
								sql="update ledgermaster set currentbalance='"+(crbal-Double.parseDouble(credit[i]))+"' where ledgerid='"+ledger+"' ";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//update to subgroup master
								sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									crbal=rs.getDouble(1);
								}
								sql="update subgroupmaster set currentbalance='"+(crbal-Double.parseDouble(credit[i]))+"' where subgroupcode='"+ledger.substring(0,5)+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//update to groupmaster
								sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									crbal=rs.getDouble(1);
								}
								sql="update groupmaster set closingbalance='"+(crbal-Double.parseDouble(credit[i]))+"' where groupcode='"+ledger.substring(0,2)+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							else if(dorc[i].equals("dr"))
							{
								sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration)values('"+voucherno+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+debit[i]+"', '"+narration[i]+"')";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//update to ledgermaster
								sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									crbal=rs.getDouble(1);
								}
								sql="update ledgermaster set currentbalance='"+(crbal+Double.parseDouble(debit[i]))+"' where ledgerid='"+ledger+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//update to subgroup master
								sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									crbal=rs.getDouble(1);
								}
								sql="update subgroupmaster set currentbalance='"+(crbal+Double.parseDouble(debit[i]))+"' where subgroupcode='"+ledger.substring(0,5)+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//update to groupmaster
								sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									crbal=rs.getDouble(1);
								}
								sql="update groupmaster set closingbalance='"+(crbal+Double.parseDouble(debit[i]))+"' where groupcode='"+ledger.substring(0,2)+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							
							//getting voucherno from outstandingledger
							sql="select voucherno from outstandingledger where ledgerid='"+ledger+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								voucher.add(rs.getString(1));
							}	
							
							//deleting outstanding ledger
							sql="delete from outstandingledger where ledgerid='"+ledger+"'";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
							
							//deleting adjustmentdetails ledger
							sql="delete from adjustmentdetails where ledgerid='"+ledger+"'";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
						int count=0;
						String abcd="";
						Vector<String> first=new Vector<String>();
						Vector<String> second=new Vector<String>();
						Vector<String> third=new Vector<String>();
						Vector<String> fourth=new Vector<String>();
						Vector<String> fifth=new Vector<String>();
						Vector<String> sixth=new Vector<String>();
						for(int j=0;j<dorc.length;j++)
						{
							String sql6="select ledgerid from ledgermaster where ledgername = '"+particular[j]+"' ";
							//System.out.println("found "+sql6);
							ResultSet rs2=stm.executeQuery(sql6);
							while(rs2.next())
							{
								abcd=rs2.getString(1);
							}
							sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
							//System.out.println(sql6);
							rs2=stm.executeQuery(sql6);
							while(rs2.next())
							{
								count=rs2.getInt(1);
							}
							if(count > 0)
							{
							for(int j1=1;j1<=count;j1++)
							{
								sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
								rs2=stm.executeQuery(sql6);
								while(rs2.next())
								{
									first.add(rs2.getString(2));
									second.add(rs2.getString(3));
									third.add(rs2.getString(4));
									fourth.add(rs2.getString(5));
									fifth.add(rs2.getString(6));
									sixth.add(rs2.getString(7));
								}
								//insert outstandingledger
								sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucher.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
								//System.out.println(sql6);
								result=ConnectionDAO.executeUpdate(stm, sql6);
								
								//insert adjustmentdetails
								sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucher.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucherno+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
								//System.out.println(sql6);
								result=ConnectionDAO.executeUpdate(stm, sql6);
							}
							}
							else
							{}
						}
						}//try ends
						catch(Exception ramkrishna)
						{
							System.out.println("error on journal update "+ramkrishna);
						}
					}
					else
					{
						String dorc[]=FormBean.getDorc();
						String part[]=FormBean.getPartforcontra();
						String credit[]=FormBean.getCredit();
						String debit[]=FormBean.getDebit();
						String narration[]=FormBean.getNarration();
						String entrydate=FormBean.getShowdate();
						String largenarration=FormBean.getDesc1();
						String contraref=FormBean.getContraref();
						String contradate=FormBean.getContradate();
						if(contraref.equals(""))
						{
							contraref="0";
						}
						if(contradate.equals(""))
						{
							contradate="0000-00-00";
						}
						String ctotal=FormBean.getTotal();
						String dtotal=FormBean.getTotal1();
						String cont="JV";
						String cont1="1617";
						String zero="";
						int aa=0;
						String abcd="";
						double crbal=0.00;
						String ledgerid="";
						String finalcode="";
						Vector<String> voucherno=new Vector<String>();
						
						sql="select count(id) from accounttransaction where voucherno like 'JV%'";
						sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
						try
						{
							ResultSet rs1=stm.executeQuery(sql1);
							while(rs1.next())
							{
								ledgerid=rs1.getString(1);
							}
							//System.out.println("ledgerid got from contra is:- "+ledgerid);
							
							ResultSet rs=stm.executeQuery(sql);
							while(rs.next())
							{
								aa=rs.getInt(1);
							}
							
							//checking starts for id
							if(aa==0)
							{
								zero="0000";
								finalcode=cont+cont1+cont1+zero+1;
								
							}
							else if(aa > 0 && aa < 9)
							{
								zero="0000";
								finalcode=cont+cont1+cont1+zero+(aa+1);
							}
							else if(aa > 8 && aa < 99)
							{
								zero="000";
								finalcode=cont+cont1+cont1+zero+(aa+1);
							}
							else if(aa > 98 && aa < 999)
							{
								zero="00";
								finalcode=cont+cont1+cont1+zero+(aa+1);
							}
							else if(aa > 998 && aa < 9999)
							{
								zero="0";
								finalcode=cont+cont1+cont1+zero+(aa+1);
							}
							else if(aa > 9998 && aa < 99999)
							{
								finalcode=cont+cont1+cont1+(aa+1);
							}
							//checking ends
							
							//getting ledgerid
							sql="select ledgerid from ledgermaster where ledgername='"+part[0]+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								ledgerid=rs.getString(1);
							}
							//insert into accounttransaction
							if(dorc[0].equals("dr"))
							{
								sql="insert into accounttransaction(entrydate, voucherno, referenceno, referencedate, ledgerid, totalamount, vouchertype) values('"+entrydate+"', '"+finalcode+"', '"+contraref+"', '"+contradate+"', '"+ledgerid+"', '"+dtotal+"','dr')";
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//insert into account narration
								sql="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+largenarration+"', 'dr')";
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							else if(dorc[0].equals("cr"))
							{
								sql="insert into accounttransaction(entrydate, voucherno, referenceno, referencedate, ledgerid, totalamount, vouchertype) values('"+entrydate+"', '"+finalcode+"', '"+contraref+"', '"+contradate+"', '"+ledgerid+"', '"+ctotal+"','cr')";
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//insert into account narration
								sql="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+largenarration+"', 'cr')";
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							//insert into accountdetails
							for(int i=0;i<dorc.length;i++)
							{
								//System.out.println("loop "+i);
								//getting ledgerid
								sql="select ledgerid from ledgermaster where ledgername='"+part[i]+"'";
								//System.out.println(sql);
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ledgerid=rs.getString(1);
								}
								//System.out.println("ledgerid "+ledgerid);
								//to account details
								if(dorc[i].equals("cr"))
								{	
									sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration)values('"+finalcode+"', '"+entrydate+"', '"+ledgerid+"', '"+"-"+credit[i]+"', '"+narration[i]+"')";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to ledgermaster
									sql="select currentbalance from ledgermaster where ledgerid='"+ledgerid+"' ";
									//System.out.println(sql);
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										crbal=rs.getDouble(1);
									}
									sql="update ledgermaster set currentbalance='"+(crbal-Double.parseDouble(credit[i]))+"' where ledgerid='"+ledgerid+"' ";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									//update to subgroup master
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledgerid.substring(0,5)+"'";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										crbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(crbal-Double.parseDouble(credit[i]))+"' where subgroupcode='"+ledgerid.substring(0,5)+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//update to groupmaster
									sql="select closingbalance from groupmaster where groupcode='"+ledgerid.substring(0,2)+"'";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										crbal=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(crbal-Double.parseDouble(credit[i]))+"' where groupcode='"+ledgerid.substring(0,2)+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
								}
								else if(dorc[i].equals("dr"))
								{
									sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration)values('"+finalcode+"', '"+entrydate+"', '"+ledgerid+"', '"+debit[i]+"', '"+narration[i]+"')";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to ledgermaster
									sql="select currentbalance from ledgermaster where ledgerid='"+ledgerid+"' ";
									rs1=stm.executeQuery(sql);
									while(rs1.next())
									{
										crbal=rs1.getDouble(1);
									}
									sql="update ledgermaster set currentbalance='"+(crbal+Double.parseDouble(debit[i]))+"' where ledgerid='"+ledgerid+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to subgroup master
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledgerid.substring(0,5)+"'";
									rs1=stm.executeQuery(sql);
									while(rs1.next())
									{
										crbal=rs1.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(crbal+Double.parseDouble(debit[i]))+"' where subgroupcode='"+ledgerid.substring(0,5)+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to groupmaster
									sql="select closingbalance from groupmaster where groupcode='"+ledgerid.substring(0,2)+"'";
									rs1=stm.executeQuery(sql);
									while(rs1.next())
									{
										crbal=rs1.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(crbal+Double.parseDouble(debit[i]))+"' where groupcode='"+ledgerid.substring(0,2)+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
								}
								
								//getting voucherno from outstandingledger
								sql="select voucherno from outstandingledger where ledgerid='"+ledgerid+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									voucherno.add(rs.getString(1));
								}	
								
								//deleting outstanding ledger
								sql="delete from outstandingledger where ledgerid='"+ledgerid+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//deleting adjustmentdetails ledger
								sql="delete from adjustmentdetails where ledgerid='"+ledgerid+"'";
								//System.out.println(sql);
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							int count=0;
							Vector<String> first=new Vector<String>();
							Vector<String> second=new Vector<String>();
							Vector<String> third=new Vector<String>();
							Vector<String> fourth=new Vector<String>();
							Vector<String> fifth=new Vector<String>();
							Vector<String> sixth=new Vector<String>();
							for(int j=0;j<dorc.length;j++)
							{
								String sql6="select ledgerid from ledgermaster where ledgername = '"+part[j]+"' ";
								//System.out.println("found "+sql6);
								ResultSet rs2=stm.executeQuery(sql6);
								while(rs2.next())
								{
									abcd=rs2.getString(1);
								}
								sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
								//System.out.println(sql6);
								rs2=stm.executeQuery(sql6);
								while(rs2.next())
								{
									count=rs2.getInt(1);
								}
								if(count > 0)
								{
								for(int j1=0;j1<count;j1++)
								{
									sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
									rs2=stm.executeQuery(sql6);
									while(rs2.next())
									{
										first.add(rs2.getString(2));
										second.add(rs2.getString(3));
										third.add(rs2.getString(4));
										fourth.add(rs2.getString(5));
										fifth.add(rs2.getString(6));
										sixth.add(rs2.getString(7));
									}
									//insert outstandingledger
									sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
									//System.out.println(sql6);
									result=ConnectionDAO.executeUpdate(stm, sql6);
									
									//insert adjustmentdetails
									sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
									//System.out.println(sql6);
									result=ConnectionDAO.executeUpdate(stm, sql6);
								}
								}
								else
								{}
							}
						}
						catch(Exception f)
						{
							f.printStackTrace();
						}
					}	
					ConnectionDAO.closeConnection(conn);
					return result;
					}
				public static List<FormBean> journallist() 
				{
					List<FormBean> l1 = new ArrayList<FormBean>();
					String sql = "select * from accounttransaction where voucherno like 'JV%' order by id desc ";
					//String sql1="select max(id) from accountdetails";
					Connection conn = ConnectionDAO.getConnectionObject();
					Statement stm = ConnectionDAO.createStatement(conn);
					String le="";
					try 
						{
							ResultSet rs = stm.executeQuery(sql);
							FormBean usBean;
							while (rs.next()) 
								{
								usBean = new FormBean();
								
								usBean.setId(rs.getInt(1));//for id
								usBean.setShowdate(rs.getString(2));//entry date
								usBean.setContraref(rs.getString(4));//ref no
								usBean.setContradate(rs.getString(5));//ref date
								usBean.setTotal(rs.getString(7));
								usBean.setVoucher(rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length()));
								le=findledger(rs.getString(6));
								usBean.setPart1(le);
								l1.add(usBean);		
								}
							
							
						} 
					catch (SQLException e) 
						{
							e.printStackTrace();
						}
					ConnectionDAO.closeConnection(conn);
					return l1;
				}
		//journal edit
				public static FormBean journaledit(int id) {
					FormBean usBean=new FormBean();
					String sql="",voucherno="",entrydate="",refno="",refdate="",nar="";
					int id1=0;
					Connection conn = ConnectionDAO.getConnectionObject();
					Statement stm = ConnectionDAO.createStatement(conn);
					ResultSet rs;
					try
					{
						sql="select voucherno,entrydate,referenceno,referencedate,id from accounttransaction where id='"+id+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							voucherno=rs.getString(1);
							entrydate=rs.getString(2);
							refno=rs.getString(3);
							refdate=rs.getString(4);
							id1=rs.getInt(5);
						}
						usBean.setSrno(voucherno.substring(voucherno.length()-1,voucherno.length()));
						sql="select narration from accountnarration where voucherno='"+voucherno+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							nar=rs.getString(1);
						}
						Vector<String> dc=new Vector<String>();
						Vector<String> particular=new Vector<String>();
						Vector<String> credit=new Vector<String>();
						Vector<String> debit=new Vector<String>();
						Vector<String> narration=new Vector<String>();
						sql="select * from accountdetails where voucherno='"+voucherno+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getDouble(5) < 0)
							{
								dc.add("cr");
								credit.add(Double.toString(rs.getDouble(5)));
								debit.add("0");
							}
							else if(rs.getDouble(5) > 0)
							{
								dc.add("dr");
								debit.add(Double.toString(rs.getDouble(5)));
								credit.add("0");
							}
							String led=findledger(rs.getString(4));
							particular.add(led);
							narration.add(rs.getString(8));
						}
						String dc1[]=new String[dc.size()];
						String particular1[]=new String[particular.size()];
						String credit1[]=new String[credit.size()];
						String debit1[]=new String[debit.size()];
						String narration1[]=new String[narration.size()];
						for(int i=1;i<=narration.size();i++)
						{
							//System.out.println("value of i "+i);
							dc1[i-1]=dc.get(i-1);
							credit1[i-1]=credit.get(i-1).replaceAll("-","");
							debit1[i-1]=debit.get(i-1);
							narration1[i-1]=narration.get(i-1);
							particular1[i-1]=particular.get(i-1);
						}
						usBean.setDorc(dc1);
						usBean.setQuantity(particular1);
						//System.out.println("particular1 "+particular1[0]+" "+particular1[1]);
						usBean.setCredit(credit1); 
						usBean.setDebit(debit1);
						usBean.setNarration(narration1);
						usBean.setShowdate(entrydate);
						usBean.setContraref(refno);
						usBean.setContradate(refdate);
						usBean.setDesc1(nar); 
						usBean.setId(id1);
					}
					catch(Exception g)
					{
						System.out.println("journal edit error at "+g);
					}
					ConnectionDAO.closeConnection(conn);
					return usBean;
					}
		//journal delete
				public static String journaldelete(int id) {
					boolean result = false;		
					String sql = null;	
					String sql1 = null;
					Connection conn = ConnectionDAO.getConnectionObject();
					Statement stm = ConnectionDAO.createStatement(conn);
					ResultSet rs;
					String voucherno="",lid="";
					double bal=0.00;
					try
					{
						
						Vector<String> amount=new Vector<String>();
						Vector<String> ledgerid=new Vector<String>();
						sql="select voucherno,ledgerid from accounttransaction where id='"+id+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							voucherno=rs.getString(1);
							lid=rs.getString(2);
						}
						sql="select amount,ledgerid from accountdetails where voucherno='"+voucherno+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							amount.add(rs.getString(1));
							ledgerid.add(rs.getString(2));
						}
						//System.out.println("Vector size "+amount.size());
						for(int i=0;i<amount.size();i++)
						{
							if(Double.parseDouble(amount.get(i)) < 0 )
							{
								//ledger update
								sql="select currentbalance from ledgermaster where ledgerid='"+ledgerid.get(i)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update ledgermaster set currentbalance='"+(bal+Double.parseDouble(amount.get(i)))+"' where ledgerid='"+ledgerid.get(i)+"'";
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//subgroup update
								sql="select currentbalance from subgroupmaster where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(amount.get(i)))+"' where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//group update
								sql="select closingbalance from groupmaster where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(amount.get(i)))+"' where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								result=ConnectionDAO.executeUpdate(stm, sql);
							}
							else if(Double.parseDouble(amount.get(i)) > 0)
							{
								//ledger update
								sql="select currentbalance from ledgermaster where ledgerid='"+ledgerid.get(i)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update ledgermaster set currentbalance='"+(bal-Double.parseDouble(amount.get(i)))+"' where ledgerid='"+ledgerid.get(i)+"'";
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//subgroup update
								sql="select currentbalance from subgroupmaster where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(amount.get(i)))+"' where subgroupcode='"+ledgerid.get(i).substring(0,5)+"'";
								result=ConnectionDAO.executeUpdate(stm, sql);
								
								//group update
								sql="select closingbalance from groupmaster where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bal=rs.getDouble(1);
								}
								sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(amount.get(i)))+"' where groupcode='"+ledgerid.get(i).substring(0,2)+"'";
								result=ConnectionDAO.executeUpdate(stm, sql);
							}//conditions end
						}
						sql="delete from accounttransaction where voucherno='"+voucherno+"'";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="delete from accountdetails where voucherno='"+voucherno+"'";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="delete from accountnarration where voucherno='"+voucherno+"'";
						result=ConnectionDAO.executeUpdate(stm, sql);
					}
					catch(Exception ff)
					{
						System.out.println("journal delete error on "+ff);
					}
					ConnectionDAO.closeConnection(conn);
					String x=findledger(lid);
					return result+"con"+x+"con"+voucherno.substring(10, voucherno.length());
					}	
//journal ends here

//debit note starts here
//debit note creation
	public static boolean debitnotecreation(FormBean FormBean) {
		boolean result=false;		
		String sql = null;	
		String sql1 = null;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		
		if (FormBean.getId() != null) 
		{					
			//String brand= FormBean.getBname();
			//System.out.println("hello");
			//System.out.println("id= "+FormBean.getId());
			//System.out.println("id "+FormBean.getId());     id comming  properly
			String s1[]=FormBean.getContra1();
			String s2[]=FormBean.getCredithidden();
			String s3[]=FormBean.getNarration1();
			double oldamount=0.00;
			String ledger="",voucher="";
			String entry="";
			sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
			try
			{
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledger=rs.getString(1);
					oldamount=rs.getDouble(2);
					voucher=rs.getString(3);
					entry=rs.getString(4);
				}
				String contradate="";
				if(FormBean.getContradate().equals(""))
				{
					contradate="0000-00-00";
				}
				else
				{
					contradate=FormBean.getContradate();
				}
				sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//resetting
				//ledger
				double ledbal=0.00;
				sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledbal=rs.getDouble(1);
				}
				//update ledgermaster
				sql="update ledgermaster set currentbalance='"+(ledbal-oldamount) +"' where ledgerid='"+ledger+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				double subgroupbal=0.00;
				while(rs.next())
				{
					subgroupbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(subgroupbal-oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				double grpbal=0.00;
				while(rs.next())
				{
					grpbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(grpbal-oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				String abcd="";
				double amou=0.00;
				
				Vector<String> ld=new Vector<String>();
				sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ld.add(rs.getString(1));
				}
				//System.out.println("length "+s2.length);
				for(int i=0;i<ld.size();i++)//particular hidden array
				{
					if(i!=0)
					{
					sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					Vector<String> am=new Vector<String>();
					while(rs.next()) 
					{
						amou=rs.getDouble(1);//accountdetails
						am.add(rs.getString(1));
					}
					//System.out.println("part amount got "+amou);
					Vector<String> gt=new Vector<String>();
					
					//resetting ledgermaster,subgroupmaster,groupmaster
					//ledgermaster
					sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
					//System.out.println(sql);
					double ledgerbal=0.00;
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledgerbal=rs.getDouble(1);
					}
					sql="update ledgermaster set currentbalance='"+(ledgerbal+amou)+"' where ledgerid='"+ld.get(i)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//subgroupmaster
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					double subbal=0.00;
					while(rs.next())
					{
						subbal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(subbal+amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//groupmaster
					sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					double gpbal=0.00;
					while(rs.next())
					{
						gpbal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(gpbal+amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					//resetting ends
				}
				}
				
				sql="delete from accountdetails where voucherno='"+voucher+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//update to ledger
				sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
				rs=stm.executeQuery(sql);
				double newled=0.00;
				while(rs.next())
				{
					newled=rs.getDouble(1);
				}
				//System.out.println("new led bal "+newled);
				sql="update ledgermaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//update to subgroup
				sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					newled=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
				//update group
				sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					newled=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
				
				String led="",sql3="";
				double total=0.00;
				Vector<String> voucherno=new Vector<String>(0);
				for(int i=0;i<s2.length;i++)
				{
					//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
					//result=ConnectionDAO.executeUpdate(stm, sql4);
					
					sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						led=rs.getString(1);
					}
					
					sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+"-"+s2[i]+"', '"+s3[i]+"') ";
					//System.out.println(sql3);
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
					rs=stm.executeQuery(sql);
					double bal=0.00;
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					total=bal-Double.parseDouble(s2[i]);
					sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						bal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
				
					//getting voucherno from outstandingledger
					sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						voucherno.add(rs.getString(1));
					}	
					
					//deleting outstanding ledger
					sql="delete from outstandingledger where ledgerid='"+led+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//deleting adjustmentdetails ledger
					sql="delete from adjustmentdetails where ledgerid='"+led+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				int count=0;
				Vector<String> first=new Vector<String>();
				Vector<String> second=new Vector<String>();
				Vector<String> third=new Vector<String>();
				Vector<String> fourth=new Vector<String>();
				Vector<String> fifth=new Vector<String>();
				Vector<String> sixth=new Vector<String>();
				for(int j=0;j<s1.length;j++)
				{
					String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
					//System.out.println("found "+sql6);
					ResultSet rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						abcd=rs2.getString(1);
					}
					sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
					//System.out.println(sql6);
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						count=rs2.getInt(1);
					}
					for(int j1=1;j1<=count;j1++)
					{
						sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							first.add(rs2.getString(2));
							second.add(rs2.getString(3));
							third.add(rs2.getString(4));
							fourth.add(rs2.getString(5));
							fifth.add(rs2.getString(6));
							sixth.add(rs2.getString(7));
						}
						//insert outstandingledger
						sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
						
						//insert adjustmentdetails
						sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
					}
				}
				
			}
			catch(Exception f)
			{
				System.out.println("debitnote update error= "+f);
			}															
		}
		else
		{
			//System.out.println("Date:- "+FormBean.getShowdate());
			String s1[]=FormBean.getNarration();
			String s2[]=FormBean.getCredit();
			String s3[]=FormBean.getPartforcontra();
			String receipt="DN";
			//String receipt1="RB";
			String receipt2="1617";
			String zero="";
			int aa=0;
			String ledgerid="";
			String finalcode="";
			Vector<String> voucherno=new Vector<String>();
			sql="select count(id) from accounttransaction where voucherno like 'DN%'";
			sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
			try
			{
				ResultSet rs1=stm.executeQuery(sql1);
				while(rs1.next())
				{
					ledgerid=rs1.getString(1);
				}
				
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next())
				{
					aa=rs.getInt(1);//got id
				}
				
				if(aa==0)
				{
					zero="0000";
					finalcode=receipt+receipt2+receipt2+zero+1;
				}
				else if(aa > 0 && aa < 9)
				{
					zero="0000";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
					//System.out.println("max id is in 1-9,final code generated:- "+finalcode);
				}
				else if(aa > 8 && aa < 99)
				{
					zero="000";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				}
				else if(aa > 98 && aa < 999)
				{
					zero="00";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				}
				else if(aa > 998 && aa < 9999)
				{
					zero="0";
					finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				}
				else if(aa > 9998 && aa < 99999)
				{
					finalcode=receipt+receipt2+receipt2+(aa+1);
				}
				double abcd1=0.00,abcd2=0.00,abcd3=0.00,codeforsub=0.00;
				String abcd="";
				String contradate="";
				if(FormBean.getContradate().equals(""))
				{
					contradate="0000-00-00";
				}
				else
				{
					contradate=FormBean.getContradate();
				}
				sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','dr')";//insert				
				result = ConnectionDAO.executeUpdate(stm, sql);
				
				String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+FormBean.getTotal()+"') ";
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
					String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'dr') ";
					//System.out.println(sql2);
					result=ConnectionDAO.executeUpdate(stm, sql2);
				
				
				//update to ledger
				ResultSet rs5=stm.executeQuery("select currentbalance from ledgermaster where ledgerid like '"+ledgerid+"' ");
				//System.out.println("select currentbalance from ledgermaster where ledgerid like '"+ledgerid+"' ");
				while(rs5.next())
				{
					abcd3=rs5.getDouble(1);
				}
				//System.out.println("receipt ledger cr bal: "+abcd3);
				double ii=Double.parseDouble(FormBean.getTotal());
				//System.out.println("receipt ledger: "+(abcd3+ii));	
				sql3="update ledgermaster set currentbalance='"+(abcd3+ii)+"' where ledgerid like '"+ledgerid+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
				//for subgroupmaster 
				sql3="select currentbalance from subgroupmaster where subgroupcode like '"+ledgerid.substring(0,2)+"%' ";
				//System.out.println(sql3);
				ResultSet rs6=stm.executeQuery(sql3);
				while(rs6.next())
				{
					codeforsub=rs6.getDouble(1);
					//System.out.println("subgroup bal(receipt):- "+codeforsub);
				}

				double onlyforsub=codeforsub+ii;
				String sql33="update subgroupmaster set currentbalance='"+onlyforsub+"' where subgroupcode= '"+ledgerid.substring(0,5)+"' ";
			
				result=ConnectionDAO.executeUpdate(stm, sql33);
				
				//for groupmaster
				sql3="select closingbalance from groupmaster where groupcode like '"+ledgerid.substring(0,2)+"' ";
				rs6=stm.executeQuery(sql3);
				while(rs6.next())
				{
					codeforsub=rs6.getDouble(1);
				}
				
				sql3="update groupmaster set closingbalance='"+(codeforsub+ii)+"' where groupcode like '"+ledgerid.substring(0,2)+"%' ";
				
				result=ConnectionDAO.executeUpdate(stm, sql3);
				//System.out.println("part length:- "+s3.length);
				for(int i=0;i<s1.length;i++)
				{
					String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
					result=ConnectionDAO.executeUpdate(stm, sql4);
					
					//System.out.println("hello "+s3[i]);
					String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[i]+"' ";
					//System.out.println("found "+sql6);
					ResultSet rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						abcd=rs2.getString(1);
					}
					sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+abcd+"', '"+"-"+s2[i]+"', '"+s1[i]+"') ";
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					ResultSet rs3=stm.executeQuery("select currentbalance from ledgermaster where ledgerid like '"+abcd+"' ");
					while(rs3.next())
					{
						abcd1=rs3.getDouble(1);
					}
					//System.out.println("ledger bal got "+abcd1);
					ResultSet rs4=stm.executeQuery("select amount from accountdetails where ledgerid like '"+abcd+"' ");
					while(rs4.next())
					{
						abcd2=rs4.getDouble(1);
					}
					//System.out.println("accountdetails bal got "+abcd2);
					double test=(abcd1+abcd2);
					//System.out.println("final amount:- "+test);
					sql3="update ledgermaster set currentbalance='"+test+"' where ledgerid like '"+abcd+"' ";
					//System.out.println(sql3);
					result = ConnectionDAO.executeUpdate(stm, sql3);
					
					double subpart=0.00;
					
					// subgroup update for particulars
					sql33="select currentbalance from subgroupmaster where subgroupcode= '"+abcd.substring(0,5)+"' "; 
	                //System.out.println(sql33);
					rs4=stm.executeQuery(sql33); 
					while(rs4.next())
					{
						subpart=rs4.getDouble(1);//subgroup current bal
					}
					//System.out.println("subgroup bal: "+subpart);
					
					double temp=Double.parseDouble(s2[i]);
					String led="";
					//System.out.println("subgroup bal will be for array: = "+(subpart-temp));
					sql3="update subgroupmaster set currentbalance='"+(subpart-temp)+"' where subgroupcode like '"+abcd.substring(0,5)+"' ";
					//System.out.println(sql3);
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					
					//group update for particulars
					sql33="select closingbalance from groupmaster where groupcode like '"+abcd.substring(0,2)+"%' ";
					//System.out.println(sql33);
					rs4=stm.executeQuery(sql33); 
					while(rs4.next())
					{
						subpart=rs4.getDouble(1);//group closing bal
					}
					//System.out.println("group closing bal got:- "+subpart);
					sql3="select ledgerid from ledgermaster where ledgername like '"+s3[i]+"%' ";
					//System.out.println("getting ledger id from ledger master:- "+sql3);
					rs4=stm.executeQuery(sql3);
					while(rs4.next())
					{
						led=rs4.getString(1).substring(0,2);
					}
					//System.out.println("2ch id got:- "+led);
					sql3="update groupmaster set closingbalance='"+(subpart-temp)+"' where groupcode= '"+led+"' ";		
					//System.out.println("update for group:- "+sql3);
					result=ConnectionDAO.executeUpdate(stm, sql3);
					
					//getting voucherno from outstandingledger
					sql="select voucherno from outstandingledger where ledgerid='"+abcd+"'";
					rs4=stm.executeQuery(sql);
					while(rs4.next())
					{
						voucherno.add(rs4.getString(1));
					}	
					
					//deleting outstanding ledger
					sql="delete from outstandingledger where ledgerid='"+abcd+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//deleting adjustmentdetails ledger
					sql="delete from adjustmentdetails where ledgerid='"+abcd+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}//loop end	
				int count=0;
				Vector<String> first=new Vector<String>();
				Vector<String> second=new Vector<String>();
				Vector<String> third=new Vector<String>();
				Vector<String> fourth=new Vector<String>();
				Vector<String> fifth=new Vector<String>();
				Vector<String> sixth=new Vector<String>();
				
				for(int j=0;j<s1.length;j++)
				{
					String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
					//System.out.println("found "+sql6);
					ResultSet rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						abcd=rs2.getString(1);
					}
					sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
					//System.out.println(sql6);
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						count=rs2.getInt(1);
					}
					if(count > 0)
					{
					for(int j1=0;j1<count;j1++)
					{
						sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							first.add(rs2.getString(2));
							second.add(rs2.getString(3));
							third.add(rs2.getString(4));
							fourth.add(rs2.getString(5));
							fifth.add(rs2.getString(6));
							sixth.add(rs2.getString(7));
						}
						//insert outstandingledger
						sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
						
						//insert adjustmentdetails
						sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
						//System.out.println(sql6);
						result=ConnectionDAO.executeUpdate(stm, sql6);
					}
					}
				}
			}
			catch(Exception f)
			{
				System.out.println("error on debitnote creation:- "+f);
			}
		}	
		ConnectionDAO.closeConnection(conn);
		return result;
		}
				//debit note list
						public static List<FormBean> debitnotelist() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql = "select * from accounttransaction where voucherno like 'DN%' ";
							//String sql1="select max(id) from accountdetails";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String le="";
							try 
								{
									ResultSet rs = stm.executeQuery(sql);
									FormBean usBean;
									while (rs.next()) 
										{
										usBean = new FormBean();
										
										usBean.setId(rs.getInt(1));//for id
										usBean.setShowdate(rs.getString(2));//entry date
										usBean.setContraref(rs.getString(4));//ref no
										usBean.setContradate(rs.getString(5));//ref date
										usBean.setTotal(rs.getString(7));
										String vno=findfirsthead(rs.getString(3));
										usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
										usBean.setPart1(findledger(vno));
										l1.add(usBean);		
										}
								} 
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
//debit ends here

//credit starts here
//credit note creation
						public static boolean creditnotecreation(FormBean FormBean) {
							boolean result=false;		
							String sql = null;	
							String sql1 = null;
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);	
							
							if (FormBean.getId() != null) 
							{					
								//String brand= FormBean.getBname();
								//System.out.println("hello");
								//System.out.println("id= "+FormBean.getId());
								//System.out.println("id "+FormBean.getId());     id comming  properly
								String s1[]=FormBean.getContra1();
								String s2[]=FormBean.getCredithidden();
								String s3[]=FormBean.getNarration1();
								double oldamount=0.00;
								String ledger="",voucher="";
								String entry="";
								sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
								try
								{
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ledger=rs.getString(1);
										oldamount=rs.getDouble(2);
										voucher=rs.getString(3);
										entry=rs.getString(4);
									}
									String contradate="";
									if(FormBean.getContradate().equals(""))
									{
										contradate="0000-00-00";
									}
									else
									{
										contradate=FormBean.getContradate();
									}
									sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//resetting
									//ledger
									double ledbal=0.00;
									sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ledbal=rs.getDouble(1);
									}
									//update ledgermaster
									sql="update ledgermaster set currentbalance='"+(ledbal+oldamount) +"' where ledgerid='"+ledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									double subgroupbal=0.00;
									while(rs.next())
									{
										subgroupbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(subgroupbal+oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									double grpbal=0.00;
									while(rs.next())
									{
										grpbal=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(grpbal+oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									String abcd="";
									double amou=0.00;
									
									Vector<String> ld=new Vector<String>();
									sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ld.add(rs.getString(1));
									}
									//System.out.println("length "+s2.length);
									for(int i=0;i<ld.size();i++)//particular hidden array
									{
										
										//System.out.println("Vector: "+ld.size());
										//int k=1;
										if(i!=0)
										{
										sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										Vector<String> am=new Vector<String>();
										while(rs.next()) 
										{
											amou=rs.getDouble(1);//accountdetails
											am.add(rs.getString(1));
										}
										//System.out.println("part amount got "+amou);
										Vector<String> gt=new Vector<String>();
										
										//resetting ledgermaster,subgroupmaster,groupmaster
										//ledgermaster
										sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										double ledgerbal=0.00;
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											ledgerbal=rs.getDouble(1);
										}
										sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//subgroupmaster
										sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										double subbal=0.00;
										while(rs.next())
										{
											subbal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//groupmaster
										sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										double gpbal=0.00;
										while(rs.next())
										{
											gpbal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										//resetting ends
									}
									}
									
									sql="delete from accountdetails where voucherno='"+voucher+"'";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to ledger
									sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
									rs=stm.executeQuery(sql);
									double newled=0.00;
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									//System.out.println("new led bal "+newled);
									sql="update ledgermaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//update to subgroup
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
									//update group
									sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
									
									String led="",sql3="";
									double total=0.00;
									Vector<String> voucherno=new Vector<String>();
									for(int i=0;i<s2.length;i++)
									{
										//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
										//result=ConnectionDAO.executeUpdate(stm, sql4);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											led=rs.getString(1);
										}
										
										sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s3[i]+"') ";
										//System.out.println(sql3);
										result=ConnectionDAO.executeUpdate(stm, sql3);
										
										sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
										rs=stm.executeQuery(sql);
										double bal=0.00;
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										total=bal+Double.parseDouble(s2[i]);
										sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
									
										//getting voucherno from outstandingledger
										sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											voucherno.add(rs.getString(1));
										}	
										
										//deleting outstanding ledger
										sql="delete from outstandingledger where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//deleting adjustmentdetails ledger
										sql="delete from adjustmentdetails where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
									}
									int count=0;
									Vector<String> first=new Vector<String>();
									Vector<String> second=new Vector<String>();
									Vector<String> third=new Vector<String>();
									Vector<String> fourth=new Vector<String>();
									Vector<String> fifth=new Vector<String>();
									Vector<String> sixth=new Vector<String>();
									for(int j=0;j<s1.length;j++)
									{
										String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
										//System.out.println("found "+sql6);
										ResultSet rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											abcd=rs2.getString(1);
										}
										sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
										//System.out.println(sql6);
										rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											count=rs2.getInt(1);
										}
										if(count > 0)
										{
										for(int j1=1;j1<=count;j1++)
										{
											sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
											rs2=stm.executeQuery(sql6);
											while(rs2.next())
											{
												first.add(rs2.getString(2));
												second.add(rs2.getString(3));
												third.add(rs2.getString(4));
												fourth.add(rs2.getString(5));
												fifth.add(rs2.getString(6));
												sixth.add(rs2.getString(7));
											}
											//insert outstandingledger
											sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
											
											//insert adjustmentdetails
											sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
										}
										}
										else
										{}
									}
									
								}
								catch(Exception f)
								{
									System.out.println("creditnote update error= "+f);
								}
																							
							}
							else
							{

								String s1[]=FormBean.getNarration();
								String s2[]=FormBean.getDebit();
								String s3[]=FormBean.getPartforcontra();
								String receipt="CN";
								String receipt1="PB";
								String receipt2="1617";
								String zero="";
								int aa=0;
								String ledgerid="";
								String finalcode="";
								Vector<String> voucherno=new Vector<String>();
								sql="select count(id) from accounttransaction where voucherno like 'CN%' ";
								sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
								try
								{
									ResultSet rs1=stm.executeQuery(sql1);
									while(rs1.next())
									{
										ledgerid=rs1.getString(1);
									}
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										aa=rs.getInt(1);//got id
									}
									
									if(aa==0)
									{
										zero="0000";
										finalcode=receipt+receipt2+receipt2+zero+1;
										//System.out.println("code generated() "+finalcode);
									}
									else if(aa > 0 && aa < 9)
									{
										zero="0000";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(single) "+finalcode);
									}
									else if(aa > 8 && aa < 99)
									{
										zero="000";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(double) "+finalcode);
									}
									else if(aa > 98 && aa < 999)
									{
										zero="00";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(triple) "+finalcode);
									}
									else if(aa > 998 && aa < 9999)
									{
										zero="0";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(quadra) "+finalcode);
									}
									else if(aa > 9998 && aa < 99999)
									{
										finalcode=receipt+receipt2+receipt2+(aa+1);
										//System.out.println("code generated(penta) "+finalcode);
									}
									String contradate="";
									if(FormBean.getContradate().equals(""))
									{
										contradate="0000-00-00";
									}
									else
									{
										contradate=FormBean.getContradate();
									}
									
									sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','cr')";//insert				
									result = ConnectionDAO.executeUpdate(stm, sql);
									
									String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+"-"+FormBean.getTotal()+"') ";
									//System.out.println(sql3);
									result=ConnectionDAO.executeUpdate(stm, sql3);
									
									if(!FormBean.getDesc1().equals(""))//if narration details not blank
									{
										String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'cr') ";
										result=ConnectionDAO.executeUpdate(stm, sql2);
									}
									
									//update for ledgermaster
									String forledger="";
									sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getPart1()+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										forledger=rs.getString(1);
									}
									sql1="select currentbalance from ledgermaster where ledgerid='"+forledger+"' ";
									rs=stm.executeQuery(sql1);
									double curbal=0.00;
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									double total=Double.parseDouble(FormBean.getTotal());
									sql="update ledgermaster set currentbalance='"+(curbal-total)+"' where ledgerid='"+forledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update subgroup master
									sql="select currentbalance from subgroupmaster where subgroupcode='"+forledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(curbal-total)+"' where subgroupcode='"+forledger.substring(0,5)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update groupmaster
									sql="select closingbalance from groupmaster where groupcode='"+forledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									//System.out.println("group bal:- "+curbal);
									sql="update groupmaster set closingbalance='"+(curbal-total)+"' where groupcode='"+forledger.substring(0,2)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									String part=FormBean.getPart();
									String led="";
									
									for(int i=0;i<s2.length;i++)
									{
										String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
										result=ConnectionDAO.executeUpdate(stm, sql4);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
										rs=stm.executeQuery(sql);
										String ledger="";
										while(rs.next())
										{
											ledger=rs.getString(1);
										}
										sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+s2[i]+"', '"+s1[i]+"') ";
										//System.out.println("aaa "+sql3);
										result=ConnectionDAO.executeUpdate(stm, sql3);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											led=rs.getString(1);
										}
										sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
										rs=stm.executeQuery(sql);
										double bal=0.00;
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										total=bal+Double.parseDouble(s2[i]);
										sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//getting voucherno from outstandingledger
										sql="select voucherno from outstandingledger where ledgerid='"+ledger+"'";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											voucherno.add(rs.getString(1));
										}	
										
										//deleting outstanding ledger
										sql="delete from outstandingledger where ledgerid='"+ledger+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//deleting adjustmentdetails ledger
										sql="delete from adjustmentdetails where ledgerid='"+ledger+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
									}//loop ends
									
									int count=0;
									Vector<String> first=new Vector<String>();
									Vector<String> second=new Vector<String>();
									Vector<String> third=new Vector<String>();
									Vector<String> fourth=new Vector<String>();
									Vector<String> fifth=new Vector<String>();
									Vector<String> sixth=new Vector<String>();
									String abcd="";
									for(int j=0;j<s1.length;j++)
									{
										String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
										//System.out.println("found "+sql6);
										ResultSet rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											abcd=rs2.getString(1);
										}
										sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
										//System.out.println(sql6);
										rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											count=rs2.getInt(1);
										}
										if(count > 0)
										{
										for(int j1=0;j1<count;j1++)
										{
											sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
											rs2=stm.executeQuery(sql6);
											while(rs2.next())
											{
												first.add(rs2.getString(2));
												second.add(rs2.getString(3));
												third.add(rs2.getString(4));
												fourth.add(rs2.getString(5));
												fifth.add(rs2.getString(6));
												sixth.add(rs2.getString(7));
											}
											//insert outstandingledger
											sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
											
											//insert adjustmentdetails
											sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
										}
										}
										else
										{}
									}
									
								}
								catch(Exception f)
								{
									System.out.println("error credit note creation:- "+f);
								}
							}
							ConnectionDAO.closeConnection(conn);
							return result;
							}
						//credit note list
						public static List<FormBean> creditnotelist() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql = "select * from accounttransaction where voucherno like 'CN%'";
							//String sql1="select max(id) from accountdetails";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String le="";
							try 
								{
									ResultSet rs = stm.executeQuery(sql);
									FormBean usBean;
									while (rs.next()) 
										{
										usBean = new FormBean();
										
										usBean.setId(rs.getInt(1));//for id
										usBean.setShowdate(rs.getString(2));//entry date
										usBean.setContraref(rs.getString(4));//ref no
										usBean.setContradate(rs.getString(5));//ref date
										usBean.setTotal(rs.getString(7).replaceAll("-", ""));
										String vno=findfirsthead(rs.getString(3));
										usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
										usBean.setPart1(findledger(vno));
										l1.add(usBean);		
										}	
								} 
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
						
//credit ends here

//sales starts
						public static boolean salescreation(FormBean FormBean) {
							boolean result=false;		
							String sql = null;	
							String sql1 = null;
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);	
							
							if (FormBean.getId() != null) 
							{					
								//String brand= FormBean.getBname();
								//System.out.println("hello");
								//System.out.println("id= "+FormBean.getId());
								//System.out.println("id "+FormBean.getId());     id comming  properly
								String s1[]=FormBean.getContra1();
								String s2[]=FormBean.getCredithidden();
								String s3[]=FormBean.getNarration1();
								double oldamount=0.00;
								String ledger="",voucher="";
								String entry="";
								sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
								try
								{
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ledger=rs.getString(1);
										oldamount=rs.getDouble(2);
										voucher=rs.getString(3);
										entry=rs.getString(4);
									}
									String contradate="";
									if(FormBean.getContradate().equals(""))
									{
										contradate="0000-00-00";
									}
									else
									{
										contradate=FormBean.getContradate();
									}
									sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//resetting
									//ledger
									double ledbal=0.00;
									sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ledbal=rs.getDouble(1);
									}
									//update ledgermaster
									sql="update ledgermaster set currentbalance='"+(ledbal+oldamount) +"' where ledgerid='"+ledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									double subgroupbal=0.00;
									while(rs.next())
									{
										subgroupbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(subgroupbal+oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									double grpbal=0.00;
									while(rs.next())
									{
										grpbal=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(grpbal+oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									String abcd="";
									double amou=0.00;
									
									Vector<String> ld=new Vector<String>();
									sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ld.add(rs.getString(1));
									}
									//System.out.println("length "+s2.length);
									for(int i=0;i<ld.size();i++)//particular hidden array
									{
										
										//System.out.println("Vector: "+ld.size());
										//int k=1;
										if(i!=0)
										{
										sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										Vector<String> am=new Vector<String>();
										while(rs.next()) 
										{
											amou=rs.getDouble(1);//accountdetails
											am.add(rs.getString(1));
										}
										//System.out.println("part amount got "+amou);
										Vector<String> gt=new Vector<String>();
										
										//resetting ledgermaster,subgroupmaster,groupmaster
										//ledgermaster
										sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										double ledgerbal=0.00;
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											ledgerbal=rs.getDouble(1);
										}
										sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//subgroupmaster
										sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										double subbal=0.00;
										while(rs.next())
										{
											subbal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//groupmaster
										sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										double gpbal=0.00;
										while(rs.next())
										{
											gpbal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										//resetting ends
									}
									}
									
									sql="delete from accountdetails where voucherno='"+voucher+"'";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to ledger
									sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
									rs=stm.executeQuery(sql);
									double newled=0.00;
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									//System.out.println("new led bal "+newled);
									sql="update ledgermaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//update to subgroup
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
									//update group
									sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
									
									String led="",sql3="";
									double total=0.00;
									Vector<String> voucherno=new Vector<String>();
									for(int i=0;i<s2.length;i++)
									{
										//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
										//result=ConnectionDAO.executeUpdate(stm, sql4);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											led=rs.getString(1);
										}
										
										sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s3[i]+"') ";
										//System.out.println(sql3);
										result=ConnectionDAO.executeUpdate(stm, sql3);
										
										sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
										rs=stm.executeQuery(sql);
										double bal=0.00;
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										total=bal+Double.parseDouble(s2[i]);
										sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
									
										//getting voucherno from outstandingledger
										sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											voucherno.add(rs.getString(1));
										}	
										
										//deleting outstanding ledger
										sql="delete from outstandingledger where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//deleting adjustmentdetails ledger
										sql="delete from adjustmentdetails where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
									}
									int count=0;
									Vector<String> first=new Vector<String>();
									Vector<String> second=new Vector<String>();
									Vector<String> third=new Vector<String>();
									Vector<String> fourth=new Vector<String>();
									Vector<String> fifth=new Vector<String>();
									Vector<String> sixth=new Vector<String>();
									for(int j=0;j<s1.length;j++)
									{
										String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
										//System.out.println("found "+sql6);
										ResultSet rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											abcd=rs2.getString(1);
										}
										sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
										//System.out.println(sql6);
										rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											count=rs2.getInt(1);
										}
										if(count > 0)
										{
										for(int j1=1;j1<=count;j1++)
										{
											sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
											rs2=stm.executeQuery(sql6);
											while(rs2.next())
											{
												first.add(rs2.getString(2));
												second.add(rs2.getString(3));
												third.add(rs2.getString(4));
												fourth.add(rs2.getString(5));
												fifth.add(rs2.getString(6));
												sixth.add(rs2.getString(7));
											}
											//insert outstandingledger
											sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
											
											//insert adjustmentdetails
											sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);

										}
										}
										else
										{}
									}
									
								}
								catch(Exception f)
								{
									System.out.println("sales update error= "+f);
								}															
							}
							else
							{	
								String s1[]=FormBean.getNarration();
								String s2[]=FormBean.getDebit();
								String s3[]=FormBean.getPartforcontra();
								String receipt="SD";
								//String receipt1="PB";
								String receipt2="1617";
								String zero="";
								int aa=0;
								String ledgerid="";
								String finalcode="";
								Vector<String> voucherno=new Vector<String>();
								sql="select count(id) from accounttransaction where voucherno like 'SD%'";
								sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
								try
								{
									ResultSet rs1=stm.executeQuery(sql1);
									while(rs1.next())
									{
										ledgerid=rs1.getString(1);
									}
									
									
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										aa=rs.getInt(1);//got id
									}
									
									if(aa==0)
									{
										zero="0000";
										finalcode=receipt+receipt2+receipt2+zero+1;
										//System.out.println("code generated() "+finalcode);
									}
									else if(aa > 0 && aa < 9)
									{
										zero="0000";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(single) "+finalcode);
									}
									else if(aa > 8 && aa < 99)
									{
										zero="000";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(double) "+finalcode);
									}
									else if(aa > 98 && aa < 999)
									{
										zero="00";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(triple) "+finalcode);
									}
									else if(aa > 998 && aa < 9999)
									{
										zero="0";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(quadra) "+finalcode);
									}
									else if(aa > 9998 && aa < 99999)
									{
										finalcode=receipt+receipt2+receipt2+(aa+1);
										//System.out.println("code generated(penta) "+finalcode);
									}
									String contradate="";
									if(FormBean.getContradate().equals(""))
									{
										contradate="0000-00-00";
									}
									else
									{
										contradate=FormBean.getContradate();
									}
									sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','cr')";//insert				
									result = ConnectionDAO.executeUpdate(stm, sql);
									
									String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+"-"+FormBean.getTotal()+"') ";
									result=ConnectionDAO.executeUpdate(stm, sql3);
									
									
										String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'cr') ";
										//System.out.println(sql2);
										result=ConnectionDAO.executeUpdate(stm, sql2);
									
									
									//update for ledgermaster
									String forledger="";
									sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getPart1()+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										forledger=rs.getString(1);
									}
									sql1="select currentbalance from ledgermaster where ledgerid='"+forledger+"' ";
									rs=stm.executeQuery(sql1);
									double curbal=0.00;
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									double total=Double.parseDouble(FormBean.getTotal());
									sql="update ledgermaster set currentbalance='"+(curbal-total)+"' where ledgerid='"+forledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update subgroup master
									sql="select currentbalance from subgroupmaster where subgroupcode='"+forledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(curbal-total)+"' where subgroupcode='"+forledger.substring(0,5)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update groupmaster
									sql="select closingbalance from groupmaster where groupcode='"+forledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									//System.out.println("group bal:- "+curbal);
									sql="update groupmaster set closingbalance='"+(curbal-total)+"' where groupcode='"+forledger.substring(0,2)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									String part=FormBean.getPart();
									String led="";
									
									for(int i=0;i<s2.length;i++)
									{
										String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
										result=ConnectionDAO.executeUpdate(stm, sql4);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											led=rs.getString(1);
										}
										
										sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s1[i]+"') ";
										result=ConnectionDAO.executeUpdate(stm, sql3);
										
										sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
										rs=stm.executeQuery(sql);
										double bal=0.00;
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										total=bal+Double.parseDouble(s2[i]);
										sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//getting voucherno from outstandingledger
										sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											voucherno.add(rs.getString(1));
										}	
										
										//deleting outstanding ledger
										sql="delete from outstandingledger where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//deleting adjustmentdetails ledger
										sql="delete from adjustmentdetails where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
									}//loop ends
									
									int count=0;
									Vector<String> first=new Vector<String>();
									Vector<String> second=new Vector<String>();
									Vector<String> third=new Vector<String>();
									Vector<String> fourth=new Vector<String>();
									Vector<String> fifth=new Vector<String>();
									Vector<String> sixth=new Vector<String>();
									String abcd="";
									for(int j=0;j<s1.length;j++)
									{
										String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
										//System.out.println("found "+sql6);
										ResultSet rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											abcd=rs2.getString(1);
										}
										sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
										//System.out.println(sql6);
										rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											count=rs2.getInt(1);
										}
										if(count > 0)
										{
										for(int j1=0;j1<count;j1++)
										{
											sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
											rs2=stm.executeQuery(sql6);
											while(rs2.next())
											{
												first.add(rs2.getString(2));
												second.add(rs2.getString(3));
												third.add(rs2.getString(4));
												fourth.add(rs2.getString(5));
												fifth.add(rs2.getString(6));
												sixth.add(rs2.getString(7));
											}
											//insert outstandingledger
											sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
											
											//insert adjustmentdetails
											sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
										}
										}
										else
										{}
									}
								}
								catch(Exception f)
								{
									System.out.println("error sales creation:- "+f);
								}
							}
							ConnectionDAO.closeConnection(conn);
							return result;
							}
						//sales note list
						public static List<FormBean> saleslist() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql = "select * from accounttransaction where voucherno like 'SD%' ";
							//String sql1="select max(id) from accountdetails";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String le="";
							try 
								{
									ResultSet rs = stm.executeQuery(sql);
									FormBean usBean;
									while (rs.next()) 
										{
										usBean = new FormBean();
										
										usBean.setId(rs.getInt(1));//for id
										usBean.setShowdate(rs.getString(2));//entry date
										usBean.setContraref(rs.getString(4));//ref no
										usBean.setContradate(rs.getString(5));//ref date
										usBean.setTotal(rs.getString(7).replaceAll("-", ""));
										String vno=findfirsthead(rs.getString(3));
										usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
										usBean.setPart1(findledger(vno));
										l1.add(usBean);		
										}
								} 
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
//sales ends
						
//purchase starts
						public static boolean purchasecreation(FormBean FormBean) {
							boolean result=false;		
							String sql = null;	
							String sql1 = null;
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);	
							
							if (FormBean.getId() != null) 
							{					
								//String brand= FormBean.getBname();
								//System.out.println("hello");
								//System.out.println("id= "+FormBean.getId());
								//System.out.println("id "+FormBean.getId());     id comming  properly
								String s1[]=FormBean.getContra1();
								String s2[]=FormBean.getCredithidden();
								String s3[]=FormBean.getNarration1();
								double oldamount=0.00;
								String ledger="",voucher="";
								String entry="";
								sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
								try
								{
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ledger=rs.getString(1);
										oldamount=rs.getDouble(2);
										voucher=rs.getString(3);
										entry=rs.getString(4);
									}
									String contradate="";
									if(FormBean.getContradate().equals(""))
									{
										contradate="0000-00-00";
									}
									else
									{
										contradate=FormBean.getContradate();
									}
									sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//resetting
									//ledger
									double ledbal=0.00;
									sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ledbal=rs.getDouble(1);
									}
									//update ledgermaster
									sql="update ledgermaster set currentbalance='"+(ledbal+oldamount) +"' where ledgerid='"+ledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									double subgroupbal=0.00;
									while(rs.next())
									{
										subgroupbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(subgroupbal+oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									double grpbal=0.00;
									while(rs.next())
									{
										grpbal=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(grpbal+oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									String abcd="";
									double amou=0.00;
									
									Vector<String> ld=new Vector<String>();
									sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										ld.add(rs.getString(1));
									}
									//System.out.println("length "+s2.length);
									for(int i=0;i<ld.size();i++)//particular hidden array
									{
										//System.out.println("Vector: "+ld.size());
										//int k=1;
										if(i!=0)
										{
										sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										Vector<String> am=new Vector<String>();
										while(rs.next()) 
										{
											amou=rs.getDouble(1);//accountdetails
											am.add(rs.getString(1));
										}
										//System.out.println("part amount got "+amou);
										Vector<String> gt=new Vector<String>();
										
										//resetting ledgermaster,subgroupmaster,groupmaster
										//ledgermaster
										sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										double ledgerbal=0.00;
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											ledgerbal=rs.getDouble(1);
										}
										sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//subgroupmaster
										sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										double subbal=0.00;
										while(rs.next())
										{
											subbal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//groupmaster
										sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										double gpbal=0.00;
										while(rs.next())
										{
											gpbal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										//resetting ends
									}
									}
									
									sql="delete from accountdetails where voucherno='"+voucher+"'";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
									//System.out.println(sql);
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update to ledger
									sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
									rs=stm.executeQuery(sql);
									double newled=0.00;
									Vector<String> voucherno=new Vector<String>();
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									//System.out.println("new led bal "+newled);
									sql="update ledgermaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									//update to subgroup
									sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
									//update group
									sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										newled=rs.getDouble(1);
									}
									sql="update groupmaster set closingbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
									String led="",sql3="";
									double total=0.00;
									for(int i=0;i<s2.length;i++)
									{
										//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
										//result=ConnectionDAO.executeUpdate(stm, sql4);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											led=rs.getString(1);
										}
										
										sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s3[i]+"') ";
										//System.out.println(sql3);
										result=ConnectionDAO.executeUpdate(stm, sql3);
										
										sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
										rs=stm.executeQuery(sql);
										double bal=0.00;
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										total=bal+Double.parseDouble(s2[i]);
										sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
									
										//getting voucherno from outstandingledger
										sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											voucherno.add(rs.getString(1));
										}	
										
										//deleting outstanding ledger
										sql="delete from outstandingledger where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//deleting adjustmentdetails ledger
										sql="delete from adjustmentdetails where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
									}
									int count=0;
									Vector<String> first=new Vector<String>();
									Vector<String> second=new Vector<String>();
									Vector<String> third=new Vector<String>();
									Vector<String> fourth=new Vector<String>();
									Vector<String> fifth=new Vector<String>();
									Vector<String> sixth=new Vector<String>();
									for(int j=0;j<s1.length;j++)
									{
										String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
										//System.out.println("found "+sql6);
										ResultSet rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											abcd=rs2.getString(1);
										}
										sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
										//System.out.println(sql6);
										rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											count=rs2.getInt(1);
										}
										if(count > 0)
										{
										for(int j1=1;j1<=count;j1++)
										{
											sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
											rs2=stm.executeQuery(sql6);
											while(rs2.next())
											{
												first.add(rs2.getString(2));
												second.add(rs2.getString(3));
												third.add(rs2.getString(4));
												fourth.add(rs2.getString(5));
												fifth.add(rs2.getString(6));
												sixth.add(rs2.getString(7));
											}
											//insert outstandingledger
											sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
											
											//insert adjustmentdetails
											sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
										}
										}
										else
										{}
									}
								}
								catch(Exception f)
								{
									System.out.println("purchase update error= "+f);
								}
																				
							}
							else
							{
								
								String s1[]=FormBean.getNarration();
								String s2[]=FormBean.getDebit();
								String s3[]=FormBean.getPartforcontra();
								String receipt="UD";
								//String receipt1="PB";
								String receipt2="1617";
								String zero="";
								int aa=0;
								String ledgerid="";
								String finalcode="";
								Vector<String> voucherno=new Vector<String>();
								sql="select count(id) from accounttransaction where voucherno like 'UD%'";
								sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
								try
								{
									ResultSet rs1=stm.executeQuery(sql1);
									while(rs1.next())
									{
										ledgerid=rs1.getString(1);
									}
									
									
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										aa=rs.getInt(1);//got id
									}
									
									if(aa==0)
									{
										zero="0000";
										finalcode=receipt+receipt2+receipt2+zero+1;
										//System.out.println("code generated() "+finalcode);
									}
									else if(aa > 0 && aa < 9)
									{
										zero="0000";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(single) "+finalcode);
									}
									else if(aa > 8 && aa < 99)
									{
										zero="000";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(double) "+finalcode);
									}
									else if(aa > 98 && aa < 999)
									{
										zero="00";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(triple) "+finalcode);
									}
									else if(aa > 998 && aa < 9999)
									{
										zero="0";
										finalcode=receipt+receipt2+receipt2+zero+(aa+1);
										//System.out.println("code generated(quadra) "+finalcode);
									}
									else if(aa > 9998 && aa < 99999)
									{
										finalcode=receipt+receipt2+receipt2+(aa+1);
										//System.out.println("code generated(penta) "+finalcode);
									}
									String contradate="";
									if(FormBean.getContradate().equals(""))
									{
										contradate="0000-00-00";
									}
									else
									{
										contradate=FormBean.getContradate();
									}
									
									sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','cr')";//insert				
									result = ConnectionDAO.executeUpdate(stm, sql);
									
									String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+FormBean.getTotal()+"') ";
									result=ConnectionDAO.executeUpdate(stm, sql3);

									String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'cr') ";
									result=ConnectionDAO.executeUpdate(stm, sql2);
									
									//update for ledgermaster
									String forledger="";
									sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getPart1()+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										forledger=rs.getString(1);
									}
									sql1="select currentbalance from ledgermaster where ledgerid='"+forledger+"' ";
									rs=stm.executeQuery(sql1);
									double curbal=0.00;
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									double total=Double.parseDouble(FormBean.getTotal());
									sql="update ledgermaster set currentbalance='"+(curbal-total)+"' where ledgerid='"+forledger+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update subgroup master
									sql="select currentbalance from subgroupmaster where subgroupcode='"+forledger.substring(0,5)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									sql="update subgroupmaster set currentbalance='"+(curbal-total)+"' where subgroupcode='"+forledger.substring(0,5)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									
									//update groupmaster
									sql="select closingbalance from groupmaster where groupcode='"+forledger.substring(0,2)+"' ";
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										curbal=rs.getDouble(1);
									}
									//System.out.println("group bal:- "+curbal);
									sql="update groupmaster set closingbalance='"+(curbal-total)+"' where groupcode='"+forledger.substring(0,2)+"' ";
									result=ConnectionDAO.executeUpdate(stm, sql);
									String part=FormBean.getPart();
									String led="";
									
									for(int i=0;i<s2.length;i++)
									{
										String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
										result=ConnectionDAO.executeUpdate(stm, sql4);
										
										sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											led=rs.getString(1);
										}
										
										sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+"-"+s2[i]+"', '"+s1[i]+"') ";
										result=ConnectionDAO.executeUpdate(stm, sql3);
										
										sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
										rs=stm.executeQuery(sql);
										double bal=0.00;
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										total=bal+Double.parseDouble(s2[i]);
										sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											bal=rs.getDouble(1);
										}
										sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//getting voucherno from outstandingledger
										sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
										rs=stm.executeQuery(sql);
										while(rs.next())
										{
											voucherno.add(rs.getString(1));
										}	
										
										//deleting outstanding ledger
										sql="delete from outstandingledger where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
										
										//deleting adjustmentdetails ledger
										sql="delete from adjustmentdetails where ledgerid='"+led+"'";
										//System.out.println(sql);
										result=ConnectionDAO.executeUpdate(stm, sql);
									}//loop ends
									
									int count=0;
									Vector<String> first=new Vector<String>();
									Vector<String> second=new Vector<String>();
									Vector<String> third=new Vector<String>();
									Vector<String> fourth=new Vector<String>();
									Vector<String> fifth=new Vector<String>();
									Vector<String> sixth=new Vector<String>();
									String abcd="";
									for(int j=0;j<s1.length;j++)
									{
										String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
										//System.out.println("found "+sql6);
										ResultSet rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											abcd=rs2.getString(1);
										}
										sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
										//System.out.println(sql6);
										rs2=stm.executeQuery(sql6);
										while(rs2.next())
										{
											count=rs2.getInt(1);
										}
										if(count > 0)
										{
										for(int j1=0;j1<count;j1++)
										{
											sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
											rs2=stm.executeQuery(sql6);
											while(rs2.next())
											{
												first.add(rs2.getString(2));
												second.add(rs2.getString(3));
												third.add(rs2.getString(4));
												fourth.add(rs2.getString(5));
												fifth.add(rs2.getString(6));
												sixth.add(rs2.getString(7));
											}
											//insert outstandingledger
											sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
											
											//insert adjustmentdetails
											sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
											//System.out.println(sql6);
											result=ConnectionDAO.executeUpdate(stm, sql6);
										}
										}
										else
										{}
									}
								}
								catch(Exception f)
								{
									System.out.println("error purchase creation:- "+f);
								}
							}
							ConnectionDAO.closeConnection(conn);
							return result;
							}
						//purchase list
						public static List<FormBean> purchaselist() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql = "select * from accounttransaction where voucherno like 'UD%' ";
							//String sql1="select max(id) from accountdetails";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String le="";
							try 
								{
									ResultSet rs = stm.executeQuery(sql);
									FormBean usBean;
									while (rs.next()) 
										{
										usBean = new FormBean();
										
										usBean.setId(rs.getInt(1));//for id
										usBean.setShowdate(rs.getString(2));//entry date
										usBean.setContraref(rs.getString(4));//ref no 
										usBean.setContradate(rs.getString(5));//ref date
										usBean.setTotal(rs.getString(7).replaceAll("-",""));
										String vno=findfirsthead(rs.getString(3));
										usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
										usBean.setPart1(findledger(vno));
										l1.add(usBean);		
										}
								} 
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
						
//purchase ends
//paymentpartlist2 for debit note
						public static List<FormBean> paymentpartlist2() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql1="select * from ledgermaster order by ledgername asc";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String buffer,x="",x1="",x2="";	
							try 
								{
									ResultSet rs = stm.executeQuery(sql1);		
									FormBean usBean=new FormBean();	
									usBean.setPart1("");
									l1.add(usBean);
									while (rs.next()) 
										{
											x=rs.getString(3);
											usBean = new FormBean();
											usBean.setPart1(rs.getString(3));//for ledger particular list1		
											l1.add(usBean);	
										}		
								}
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
//paymentpartlist3 for purchase
						public static List<FormBean> paymentpartlist3() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql1="select * from ledgermaster where ledgername like '%purchase%' order by ledgername asc";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String buffer,x="",x1="",x2="";	
							try 
								{
									ResultSet rs = stm.executeQuery(sql1);		
									FormBean usBean=new FormBean();	
									usBean.setPart1("");	
									l1.add(usBean);	
									while (rs.next()) 
										{
											x=rs.getString(3);
											usBean = new FormBean();
											usBean.setPart1(rs.getString(3));	
											l1.add(usBean);	
										}		
								}
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
//paymentpartlist4 for sales
						public static List<FormBean> paymentpartlist4() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql1="select * from ledgermaster where ledgername like '%sales%'";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String buffer,x="",x1="",x2="";	
							try 
								{
									ResultSet rs = stm.executeQuery(sql1);		
									FormBean usBean=new FormBean();	
									usBean.setPart1("");
									l1.add(usBean);
									while (rs.next()) 
										{
											x=rs.getString(3);
											usBean = new FormBean();
											usBean.setPart1(rs.getString(3));	
											l1.add(usBean);	
										}		
								}
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
//journal top a/c part
						public static List<FormBean> journalmainpartlist() 
						{
							List<FormBean> l1 = new ArrayList<FormBean>();
							String sql1="select * from ledgermaster where ledgerid not like 'BA%' and ledgerid not like 'CH%' order by ledgername asc";
							Connection conn = ConnectionDAO.getConnectionObject();
							Statement stm = ConnectionDAO.createStatement(conn);
							String buffer,x="",x1="",x2="";	
							try 
								{
									ResultSet rs = stm.executeQuery(sql1);		
									FormBean usBean1=new FormBean();
									usBean1.setPart("");
									l1.add(usBean1);
									while (rs.next()) 
										{
											FormBean usBean=new FormBean();	
											x=rs.getString(3);
											//System.out.println(rs.getString(3));
											usBean.setPart1(rs.getString(3));//for ledger particular list1		
											usBean.setPart(rs.getString(3));
											l1.add(usBean);	
										}	
								}
							catch (SQLException e) 
								{
									e.printStackTrace();
								}
							ConnectionDAO.closeConnection(conn);
							return l1;
						}
//trial list
	public static List<FormBean> triallist() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		boolean result=false;
		FormBean usBean,usBean1;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try
		{
			//resetting 
			String sql1="update ledgermaster set debitamount='0', creditamount='0'";
			result=ConnectionDAO.executeUpdate(stm, sql1);
			
			String sql="select * from ledgermaster";
			ResultSet rs=stm.executeQuery(sql);
			Vector<String> led=new Vector<String>();
			double amount=0.00,totalcredit=0.00,totaldebit=0.00;
			String gr="";
			while(rs.next())
			{
				led.add(rs.getString(2));
			}
			for(int i=0;i<led.size();i++)
			{
				//credit amount set in ledger
				sql="select sum(amount) from accountdetails where ledgerid='"+led.get(i)+"' and amount < 0";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					totalcredit=rs.getDouble(1);
				}
				sql="update ledgermaster set creditamount='"+Math.abs(totalcredit)+"' where ledgerid='"+led.get(i)+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//debit amount set in ledger
				sql="select sum(amount) from accountdetails where ledgerid='"+led.get(i)+"' and amount > 0";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					totaldebit=rs.getDouble(1);
				}
				sql="update ledgermaster set debitamount='"+totaldebit+"' where ledgerid='"+led.get(i)+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			sql="select * from ledgermaster where openingbalance <> '0' or debitamount <> '0' or creditamount <> '0'";
			rs=stm.executeQuery(sql);
			double totalope=0.00,totald=0.00,totalc=0.00;
			
			while(rs.next())
			{
				usBean=new FormBean();
				gr=findgroup(rs.getString(2));
				usBean.setAsondate("");
				usBean.setLedger(rs.getString(3));
				usBean.setGroup(gr);
				
				usBean.setOpebal(rs.getString(17));
				totalope=totalope+Double.parseDouble(rs.getString(17));
				//usBean.setOpebal(Double.toString(totalope));//last total row
				
				usBean.setDebitam(rs.getString(27));
				totald=totald+Double.parseDouble(rs.getString(27));
				//usBean.setDebitam(Double.toString(totald));//last total row
				
				usBean.setCreditam(rs.getString(28));
				totalc=totalc+Double.parseDouble(rs.getString(28));
				//usBean.setDebitam(Double.toString(totalc));//last total row
				
				l1.add(usBean);
			}
			usBean=new FormBean();
			double totalbalance=totalope+totald-totalc;
			String y="";
			if(totalbalance < 0)
			{
				y=" Cr";
			}
			else if(totalbalance > 0)
			{
				y=" Dr";
			}
			
			usBean.setLedger("");
			usBean.setGroup("<b>"+"Balance: "+totalbalance+y+"</b>");
			String x="";
			if(totalope < 0)
			{
				x=" Cr";
			}
			else if(totalope > 0)
			{
				x=" Dr";
			}
			usBean.setOpebal("<b>"+""+totalope+x+"</b>");
			
			usBean.setDebitam("<b>"+""+totald+" Dr"+"</b>");
			
			usBean.setCreditam("<b>"+""+totalc+" Cr"+"</b>");
			
			//System.out.println(""+setAsondate(d));
			//usBean.setAsondate(d);
			
			l1.add(usBean);
		}
		catch(Exception d)
		{
			System.out.println("Trial balance list error on "+d);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//String 
//ledger report
	public static List<FormBean> ledgerreport(String ledger) 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String gr="";
		
		int x=0,nv=0;
		String a="",led="";
		
		try
		{
			double debit=0.00,credit=0.00,totalopebal=0.00,totaldebit=0.00,totalcredit=0.00,totalnv=0.00,closing=0.00,cpyfirstope=0.00;
			double finaltotal=0.00;
			FormBean usBean;
			String month="",xxx="";
			String sql="select ledgerid from ledgermaster where ledgername='"+ledger+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				led=rs.getString(1);
			}
			int i=4;
			switch(i)
			{
			case 4:if(i==4&&i<=12)
					{
					sql="select openingbalance from ledgermaster where ledgerid='"+led+"'";
					rs=stm.executeQuery(sql);
					double firstope=0.00;
					while(rs.next())
					{
						firstope=rs.getDouble(1);
					}
						for(i=4;i<=12;i++)
						{
				
							switch(i)
							{
								case 4:a="APRIL - 2017";break;
								case 5:a="MAY - 2017";break;
								case 6:a="JUNE - 2017";break;
								case 7:a="JULY - 2017";break;
								case 8:a="AUGUST - 2017";break;
								case 9:a="SEPTEMBER - 2017";break;
								case 10:a="OCTOBER - 2017";break;
								case 11:a="NOVEMBER - 2017";break;
								case 12:a="DECEMBER - 2017";break;
					
							}
							if(i<10)
							{
								xxx="0"+i;
							}
							else
							{
								xxx=Integer.toString(i);
							}
					
							usBean = new FormBean();
							usBean.setLedger(ledger); 
							usBean.setMonths(a);//months setted
							
							sql="select count(*) from accountdetails where ledgerid='"+led+"' and entrydate like '2017-"+xxx+"-%' ";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								nv=rs.getInt(1);
							}
							totalnv=(totalnv+(double)nv);
							//System.out.println("hello "+totalnv);
							if(nv==0)
							{
								usBean.setNv("NIL");//number of voucher setted 
							}
							else
							{
								usBean.setNv(Integer.toString(nv));//number of voucher setted 
							}
							
							if(nv!=0)
							{
								totalopebal=totalopebal+firstope;
								//System.out.println("next opening balance "+totalopebal);
								usBean.setOpebal(Double.toString(totalopebal));//opening balance setted
								finaltotal=finaltotal+totalopebal;
							}
							
							sql="select sum(if(amount>0,amount,0)) from accountdetails where entrydate like '2017-"+xxx+"-%' and ledgerid='"+led+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								debit=rs.getDouble(1);
							}
							if(nv!=0)
							{
								totaldebit=totaldebit+debit;
								usBean.setDebitam(Double.toString(debit));//debit amount setted
							}
							
							sql="select sum(if(amount<0,amount,0)) from accountdetails where entrydate like '2017-"+xxx+"-%' and ledgerid='"+led+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								credit=rs.getDouble(1);
							}
							if(nv!=0)
							{
								totalcredit=totalcredit+credit;
								usBean.setCreditam(Double.toString(Math.abs(credit)));//credit amount setted
								//System.out.println("total credit on 1st "+totalcredit);
							}
							
							if(nv!=0)
							{
								cpyfirstope=firstope;
								closing=totalopebal+debit+credit;
								if(closing > 0)
								{
									usBean.setClosing(Double.toString(closing)+" Dr");//closing amount setted
								}
								else if(closing <= 0)
								{
									usBean.setClosing(Double.toString(closing).replace("-", "")+" Cr");//closing amount setted
								}
							}
							firstope=0.00;
							totalopebal=closing;
							l1.add(usBean);	
						}
						i=1;
					}
			
			case 1:
			{
				sql="select openingbalance from ledgermaster where ledgerid='"+led+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				double firstope=0.00;
				while(rs.next())
				{
					firstope=rs.getDouble(1);
				}
				//System.out.println("hello "+firstope);
					for(i=1;i<=3;i++)
					{
						switch(i)
							{
								case 1:a="JANUARY - 2018";break;
								case 2:a="FEBRUARY - 2018";break;
								case 3:a="MARCH - 2018";break;
							}
						if(i<10)
						{
							xxx="0"+i;
						}
						else
						{
							xxx=Integer.toString(i);
						}
						usBean = new FormBean();	
						usBean.setLedger(ledger);
						usBean.setMonths(a);//month setted
		
						sql="select count(*) from accountdetails where ledgerid='"+led+"' and entrydate like '2017-"+xxx+"-%' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							nv=rs.getInt(1);
						}
						totalnv=(totalnv+(double)nv); 
						if(nv==0)
						{
							usBean.setNv("NIL");//number of voucher setted
						}
						else
						{
							usBean.setNv(Integer.toString(nv));//number of voucher setted
						}
						
						if(nv!=0)
						{
							totalopebal=totalopebal+firstope;
							//System.out.println("next opening balance "+totalopebal);
							usBean.setOpebal(Double.toString(totalopebal));//opening balance setted
							finaltotal=finaltotal+totalopebal;
						}
						
						sql="select sum(if(amount>0,amount,0)) from accountdetails where entrydate like '2017-"+xxx+"-%' and ledgerid='"+led+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							debit=rs.getDouble(1);
						}
						if(nv!=0)
						{
							totaldebit=totaldebit+debit;
							usBean.setDebitam(Double.toString(debit));//debit amount setted
						}
						
						sql="select sum(if(amount<0,amount,0)) from accountdetails where entrydate like '2017-"+xxx+"-%' and ledgerid='"+led+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							credit=rs.getDouble(1);
						}
						if(nv!=0)
						{
							totalcredit=totalcredit+credit;
							usBean.setCreditam(Double.toString(Math.abs(credit)));//credit amount setted
							//System.out.println("total credit on 2nd "+credit); 
						}
						
						if(nv!=0)
						{
							cpyfirstope=firstope;
							closing=totalopebal+debit+credit;
							if(closing > 0)
							{
								usBean.setClosing(Double.toString(closing)+" Dr");//closing amount setted
							}
							else if(closing <= 0)
							{
								usBean.setClosing(Double.toString(closing).replace("-", "")+" Cr");//closing amount setted
							}
						}
						firstope=0.00;
						totalopebal=closing;
						l1.add(usBean);	
					}
				}
			//System.out.println("final total "+finaltotal);
			}
			//System.out.println("all total "+totalopebal+"   "+totaldebit+"   "+totalcredit);
			usBean = new FormBean();
			int test=(int)totalnv;
			//System.out.println(totalcredit);
			double xyz=(finaltotal+totaldebit+totalcredit);
			usBean.setNv("<b>"+"Total: "+test+"</b>");
			if(finaltotal > 0)
			{
				usBean.setOpebal("<b>"+Double.toString(finaltotal)+" Dr"+"</b>");
			}
			else if(finaltotal <= 0)
			{
				usBean.setOpebal("<b>"+Double.toString(finaltotal).replace("-", "")+" Cr"+"</b>");
			}
			usBean.setDebitam("<b>"+Double.toString(totaldebit)+" Dr"+"</b>");
			usBean.setCreditam("<b>"+Double.toString(totalcredit).replace("-","")+" Cr"+"</b>");
			if(xyz < 0)
			{	
				usBean.setClosing("<b>"+Double.toString(xyz).replace("-", "")+" Cr"+"</b>");
			}
			else if(xyz > 0)
			{
				usBean.setClosing("<b>"+Double.toString(xyz)+" Dr"+"</b>");
			}
			l1.add(usBean);
			
		}
		catch(Exception e)
		{
			System.out.println("Ledger Report Error "+e);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//ledger report ends
	//asif
		//daily cash balance display
	public static List<FormBean> cashlistdetails(FormBean formbean) 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		
		String s1=formbean.getFrmdate();
		String s2=formbean.getTodate();
		String s3=formbean.getPart1();
		////System.out.println(s3);
		String s=s1;
		try
		{	
			double x=0.00,x1=0.00,x2=0.00,x3=0.00,x4=0.00,x5=0.00;	
		////System.out.println("date "+(s+1));	
		String sql1="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"'"; 
		////System.out.println(sql1);
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		String lid="";				
				FormBean usBean=new FormBean();
				ResultSet rs = stm.executeQuery(sql1);
				while (rs.next()) 
					{
						lid=rs.getString(1);
						x=rs.getDouble(2);
						////System.out.println("hhh "+x);
					}
				String sql2="select sum(amount) from accountdetails where entrydate <'"+s+"' and ledgerid='"+lid+"' ";
				////System.out.println(sql2);
				ResultSet rs2 = stm.executeQuery(sql2);
				
				while (rs2.next()) 
				{
						x1=rs2.getDouble(1);
				}		
						x2=x1+x;
						
				String sql="select entrydate,abs(sum(if(amount<0,amount,0))),sum(if(amount>0, amount, 0)) from accountdetails where entrydate>='"+s+"' and entrydate<='"+s2+"' and ledgerid='"+lid+"' group by entrydate";
				//System.out.println(sql);
				rs = stm.executeQuery(sql);
				
				////System.out.println("opening bal "+x2);
				while (rs.next()) 
				{
					usBean = new FormBean();
					usBean.setDated(rs.getString(1));
					if(x2 > 0)
					{
						usBean.setOpening_bal(Double.toString(x2)+" <b>Dr</b>");
					}
					else if(x2 < 0)
					{
						usBean.setOpening_bal(Double.toString(x2).replace("-", "")+" <b>Cr</b>");
					}
					x5=rs.getDouble(3);
					x4=rs.getDouble(2);
					if(x5!=0)
					{
						usBean.setAmount_debited(x5+" <b>Dr</b>");
					}
					else
					{
						usBean.setAmount_debited("");
					}
					if(x4!=0)
					{
						usBean.setAmount_credited(Double.toString(x4).replace("-","")+" <b>Cr</b>");
					}
					else
					{
						usBean.setAmount_credited("");
					}
					x3=x2+x5-x4;
					
					if(x3<0)
					{
						usBean.setClosing_balance(Double.toString(x3).replace("-","")+" <b>Cr</b>");
					}
					else if(x3>0)
					{
						usBean.setClosing_balance(Double.toString(x3).replace("-","")+" <b>Dr</b>");
					}
						x2=x3;
					l1.add(usBean);	
				}		
		ConnectionDAO.closeConnection(conn);
		//s=s+1;
	}catch (SQLException e) 
		{
		e.printStackTrace();
	}
		return l1;
	}
	public static List<FormBean> partyledgerlistdetails2(FormBean formbean) 
	{
				List<FormBean> l1 = new ArrayList<FormBean>();	
				String s1=formbean.getFrmdate();
				String s2=formbean.getTodate();
				String s3=formbean.getAcname();	
				try
				{		
					Vector<String> v=new Vector<String>();
					Vector<String> date=new Vector<String>();
					double x=0.00,x1=0.00,x2=0.00;			
				String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"' "; 
				Connection conn = ConnectionDAO.getConnectionObject();
				Statement stm = ConnectionDAO.createStatement(conn);	
				String lid="";				
						FormBean usBean=new FormBean();
						ResultSet rs = stm.executeQuery(sql);
						while (rs.next()) 
							{
								lid=rs.getString(1);
								x=rs.getDouble(2);
							}			
		if((s1.compareTo("")!=0)&&(s2.compareTo("")!=0))
			{	
						sql="select voucherno,entrydate from accountdetails where entrydate>='"+s1+"' and entrydate<='"+s2+"' and ledgerid='"+lid+"' ";			
						rs = stm.executeQuery(sql);
						String vno="",type="",refno="",refdate="";
						while (rs.next()) 
						{	
							//v=rs.getString(1);	
							v.add(rs.getString(1));
							//x1=rs.getDouble(2);
							date.add(rs.getString(2));
						}	
				for(int i=0;i<v.size();i++)
				{
						sql="select left(voucherno,2),right(voucherno,5),referenceno,referencedate from accounttransaction where voucherno='"+v.get(i)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							type=rs.getString(1);
							vno=rs.getString(2);
							refno=rs.getString(3);
							refdate=rs.getString(4);	
						}
						switch(type)
						{
						case "RC":  type="Cash Receipt";break;
						case "RB":  type="Bank Receipt";break;
						case "CO":  type="Contra";break;
						case "JV":  type="Journal";break;
						case "PB":  type="Bank Payment";break;
						case "PC":  type="Cash Payment";break;
						case "DN":  type="Debit Note";break;
						case "CN":  type="Credit Note";break;
						case "UC":  type="Cash Purchase";break;
						case "SC":  type="Cash Sales";break;
						case "UD":  type="Credit Purchase";break;
						case "SD":  type="Credit Sales";break;
						}

				
						
						sql="select sum(if(amount<0,amount,0)),sum(if(amount>0, amount, 0)) from accountdetails where entrydate>='"+s1+"' and entrydate<='"+s2+"' and voucherno='"+v.get(i)+"' and ledgerid='"+lid+"' ";
					//System.out.println(sql);
						rs = stm.executeQuery(sql);
						//x3=x2+x5-x4;
						while(rs.next())
						{
							x1=rs.getDouble(1);
							x2=rs.getDouble(2);
							
						}
						
						
							usBean = new FormBean();
							
							usBean.setDate(date.get(i));
							usBean.setType(type);
							usBean.setVno(vno);
							usBean.setRefno(refno);
							usBean.setRefdate(refdate);
							//usBean.setOpening_bal(Double.toString(x2));
							if(x2>0){
							usBean.setDebitamt(Double.toString(x2)+" <b>Dr</b>");
							usBean.setCreditamt("");
							}
							else if(x1<0){
								usBean.setCreditamt(Double.toString(Math.abs(x1))+" <b>Cr</b>");
								usBean.setDebitamt("");
								
							}
							
							//usBean.setCreditamt(Double.toString(x1));
							//usBean.setClosing_balance(Double.toString(x3));
							//x2=x3;
							l1.add(usBean);	
				}			
								
			}
		ConnectionDAO.closeConnection(conn);
		//s=s+1;
		


	}catch (SQLException e) 
		{
		e.printStackTrace();
	}
		return l1;
		
	}
	//party ledger list
			public static List<FormBean> partyledgerlistdetails(FormBean formbean) 
			{
				List<FormBean> l1 = new ArrayList<FormBean>();
				
				
				//String s1=formbean.getFrmdate();
				//String s2=formbean.getTodate();
				String s3=formbean.getAcname();
				
				
				try
				{
					
					double x=0.00,x1=0.00,x2=0.00,x3=0.00;	
				
					
				
				String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"' "; 
				
				

				Connection conn = ConnectionDAO.getConnectionObject();
				Statement stm = ConnectionDAO.createStatement(conn);
					
				
				String lid="";		
						
						
						FormBean usBean=new FormBean();
						ResultSet rs = stm.executeQuery(sql);
						while (rs.next()) 
							{
								lid=rs.getString(1);
								x=rs.getDouble(2);
								
							}
						
		
			double total2=0.00,total3=0.00,total4=0.00,total5=0.00;
			
			int i=4,n=0,total1=0;
			String deb="0";
			String cre="0";
			switch(i)
			{
			case 4:if(i==4&&i<=12)
					{
					for(i=4;i<=12;i++)
					{
					String a="";
					switch(i)
						{
					case 4:a="April 2016";break;
					case 5:a="May 2016";break;
					case 6:a="June 2016";break;
					case 7:a="July 2016";break;
					case 8:a="August 2016";break;
					case 9:a="September 2016";break;
					case 10:a="October 2016";break;
					case 11:a="November 2016";break;
					case 12:a="December 2016";break;
					
						}
					
					sql="select count(entrydate),sum(if(amount>0,amount,0)) from accountdetails where entrydate like '______"+i+"___' and ledgerid='"+lid+"'";
				
					rs=stm.executeQuery(sql);
					
					while(rs.next())
					{
						
						n=rs.getInt(1);
						x1=rs.getDouble(2);
					}
					
					total1=total1+n;
					total2=total2+x1;
					
					sql="select abs(sum(if(amount<0,amount,0))) from accountdetails where entrydate like '______"+i+"___' and ledgerid='"+lid+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						x2=rs.getDouble(1);
					}
					x3=x+x1-x2;
					
					total3=total3+x2;
					total4=total4+x3;
					total5=total5+x;
					
					usBean = new FormBean();
					
					usBean.setMonth(a);
					if(n!=0)
					{
						usBean.setNv(Integer.toString(n));
					}
					else if(n==0)
					{
						usBean.setNv("NIL");
					}
					usBean.setOpening_bal(Double.toString(x));
					if(x1!=0)
					{
						usBean.setDebitamt(Double.toString(x1)+"<b> Dr</b>");
						deb=deb+"con"+x1;
					}
					else
					{
						usBean.setDebitamt("");
					}
					if(x2!=0)
					{
						usBean.setCreditamt(Double.toString(x2).replaceAll("-", "")+"<b> Cr</b>");
						cre=cre+"con"+Double.toString(x2).replace("-","");
					}
					else
					{
						usBean.setCreditamt("");
					}
					if(x3<0)
					{
						usBean.setClosing_balance(Double.toString(x3).replaceAll("-", "")+"<b> Cr</b>");
					}
					else if(x3>0)
					{
						usBean.setClosing_balance(Double.toString(x3).replaceAll("-", "")+"<b> Dr</b>");
					}
					usBean.setAccid(s3);
					//x=x3;
					usBean.setShortn(formbean.getShortn());
					usBean.setLongn(formbean.getLongn());
					//System.out.println("shortn longn case 4 "+formbean.getShortn()+","+formbean.getLongn());
					l1.add(usBean);	
				}
			
					i=1;
				}
			case 1:{
				int p=0;
					for(i=01;i<=03;i++)
					{
					
						String a="";
						switch(i)
							{
						case 01:a="January 2017";break;
						case 02:a="February 2017";break;
						case 03:a="March 2017";break;
							}
					sql="select count(entrydate),sum(if(amount>0,amount,0)) from accountdetails where entrydate like '2017-0"+i+"-__' and ledgerid='"+lid+"' ";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
						while(rs.next())
						{
						p=rs.getInt(1);
						x1=rs.getDouble(2);
						}
						
						total1=total1+p;
						total2=total2+x1;
						
		
						sql="select abs(sum(if(amount<0,amount,0))) from accountdetails where entrydate like '2017-0"+i+"-%' and ledgerid='"+lid+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
							while(rs.next())
							{
							x2=rs.getDouble(1);
							}
						
							x3=x+x1-x2;
							
							total3=total3+x2;
							total4=total4+x3;
							total5=total5+x;
							
							usBean = new FormBean();
						
							usBean.setMonth(a);
							if(p!=0)
							{
								usBean.setNv(Integer.toString(p));
							}
							else if(p==0)
							{
								usBean.setNv("NIL");
							}
							usBean.setOpening_bal(Double.toString(x));
							if(x1!=0)
							{
								usBean.setDebitamt(Double.toString(x1)+"<b> Dr</b>");
								deb=deb+"con"+x1;
							}
							else
							{
								usBean.setDebitamt("");
							}
							if(x2!=0)
							{
								usBean.setCreditamt(Double.toString(x2).replaceAll("-", "")+"<b> Cr</b>");
								cre=cre+"con"+Double.toString(x2).replace("-","");
							}
							else
							{
								usBean.setCreditamt("");
							}
							if(x3<0)
							{
								usBean.setClosing_balance(Double.toString(x3).replaceAll("-", "")+"<b> Cr</b>");
							}
							else if(x3>0)
							{
								usBean.setClosing_balance(Double.toString(x3).replaceAll("-", "")+"<b> Dr</b>");
							}
							usBean.setAccid(s3);
							//x=x3;
							//System.out.println("shortn longn case 1 "+formbean.getShortn()+","+formbean.getLongn());
							l1.add(usBean);	
					}
				}
			}
			usBean = new FormBean();
			//usBean.setMonth("Total");
			usBean.setNv("<b>Total "+(total1)+"</b>");
			usBean.setOpening_bal("<b>"+Double.toString(total5)+"</b>");
			usBean.setDebitamt("<b>"+Double.toString(total2)+" Dr</b>");
			usBean.setCreditamt("<b>"+Double.toString(total3)+" Cr</b>");
			if(total4 < 0)
			{
				usBean.setClosing_balance("<b>"+Double.toString(x3).replaceAll("-", "")+" Cr</b>");
			}
			else if(total4 > 0)
			{
				usBean.setClosing_balance("<b>"+Double.toString(x3).replaceAll("-", "")+" Dr</b>");
			}
			l1.add(usBean);	
			ConnectionDAO.closeConnection(conn);
			
			//11.05.17
			String abc[]= deb.split("con");
			String def[]=cre.split("con");
	        double maxd = Double.parseDouble(abc[0]);
	        double maxc = Double.parseDouble(def[0]);
	        for (int counter = 1; counter < abc.length; counter++)
	        {
	        	if (Double.parseDouble(abc[counter]) > maxd)
	        	{
	        		maxd = Double.parseDouble(abc[counter]);
	        	}
	        }  
	        for (int counter = 1; counter < def.length; counter++)
	        {
	        	if (Double.parseDouble(def[counter]) > maxc)
	        	{
	        		maxc = Double.parseDouble(def[counter]);
	        	}
	        }
	        //System.out.println("The highest maximum is: " + maxc +","+maxd );
	       
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
				return l1;
	}
		public static List<FormBean> acnamelist(FormBean f)
		{
			List<FormBean> l1 = new ArrayList<FormBean>();	
			String sql= "select distinct ledgername from ledgermaster";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try 
				{
					ResultSet rs = stm.executeQuery(sql);
					FormBean usBean;
					while (rs.next()) 
						{
							usBean = new FormBean();
							usBean.setAcname(rs.getString(1));
							l1.add(usBean);
						}
				} 
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
		public static List<FormBean> acnamelist1(FormBean f)
		{
			List<FormBean> l1 = new ArrayList<FormBean>();	
			String sql= "select ledgername from ledgermaster";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try 
				{
					ResultSet rs = stm.executeQuery(sql);
					FormBean usBean,usBean1;
					usBean1=new FormBean();
					usBean1.setAcname("");
					l1.add(usBean1);
					while (rs.next()) 
						{
							usBean = new FormBean();
							usBean.setAcname(rs.getString(1));
							l1.add(usBean);
						}
				} 
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
//getuptodate
		public static FormBean getuptodate(String date) 
		{
			//System.out.println("hello");
			FormBean usBean = new FormBean();
			try
			{
				Connection conn = ConnectionDAO.getConnectionObject();
				Statement stm = ConnectionDAO.createStatement(conn);
				String sql="select max(id) from accounttransaction";
				ResultSet rs=stm.executeQuery(sql);
				String d="";
				int id=0;
				while(rs.next())
				{
					id=rs.getInt(1);
				}
				sql="select entrydate from accounttransaction where id='"+id+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					d=rs.getString(1);
				}
				usBean.setAsondate("As On: "+d);
				ConnectionDAO.closeConnection(conn);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return usBean;
		}
//findref
public static String findref(String x2,String x3)
{
	//System.out.println(x2);
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String refno="",refdate="";
	String got="";
	String sql="select * from accounttransaction where voucherno='"+x2+"' and entrydate='"+x3+"'";
	//System.out.println(sql);
	try
	{	
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			refno=rs.getString(4);
			refdate=rs.getString(5);
		}
		//System.out.println("ref "+refno+refdate);
		got=refno+"con"+refdate;
	}
	catch(Exception s)
	{
		System.out.println("find ref error "+s);
	}
	ConnectionDAO.closeConnection(conn);
	//System.out.println(got);
	return got;
}

//monthwisereport
		public static List<FormBean> monthwisereport(String months,String ledger) 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			FormBean usBean;
			//System.out.println("value "+months+" "+ledger);
			try
			{
				Connection conn = ConnectionDAO.getConnectionObject();
				Statement stm = ConnectionDAO.createStatement(conn);
				//System.out.println("value got "+months+","+ledger);
				int a,count=0;
				double debit=0.00,credit=0.00,amount=0.00; 
				String d="",d1="",ledgerid="",fulldate="",sql="",voucherno="",subvoucher="";
				String date="",type="",refno="",refdate="",vtype="";
				switch(months)
				{
					case "APRIL - 2017":
										a=04;
										d="04";
										break;
					case "MAY - 2017":
										a=05;
										d="05";
										break;
					case "JUNE - 2017":
										a=06;
										d="06";
										break;
					case "JULY - 2017":
										a=07;
										d="07";
										break;
					case "AUGUST - 2017":
										a=8;
										d="08";
										break;
					case "SEPTEMBER - 2017":
										a=9;
										d="09";
										break;
					case "OCTOBER - 2017":
										a=10;
										d="10";
										break;
					case "NOVEMBER - 2017":
										a=11;
										d="11";
										break;
					case "DECEMBER - 2017":
										a=12;
										d="12";
										break;
					case "JANUARY - 2018":
										a=01;
										d="01";
										break;
					case "FEBRUARY - 2018":
										a=02;
										d="02";
										d1=months;
										//System.out.println("months "+d1);
										break;
					case "MARCH - 2018":
										a=03;
										d="03";
										break;
				}
				String sql1="select ledgerid from ledgermaster where ledgername='"+ledger+"'";
				ResultSet rs=stm.executeQuery(sql1);
				while(rs.next())
				{
					ledgerid=rs.getString(1);
				}
				sql1="select voucherno from accounttransaction where ledgerid='"+ledgerid+"'";
				//System.out.println(sql1);
				rs=stm.executeQuery(sql1);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				
				if(d.equals("04"))
				{
						sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
						//System.out.println(sql);
						String vouchertype="";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							usBean=new FormBean();
							date=rs.getString(3);
							voucherno=rs.getString(2);
							amount=rs.getDouble(5);
							vouchertype=rs.getString(8);
							
							usBean.setDate(date);
							usBean.setLedger(ledger);
							String ref=findref(voucherno,date);
							String got[]=ref.split("con");
							usBean.setRefno(got[0]); 
							if(!got[1].equals("0000-00-00"))
							{	
								usBean.setRefdate(got[1]);
							}
							else
							{
								usBean.setRefdate("");
							}
							//System.out.println(voucherno);
							if(voucherno.substring(0,2).equals("RC"))
							{
								type="Cash Receipt";
							}
							else if(voucherno.substring(0,2).equals("RB"))
							{
								type="Bank Receipt";
							}
							else if(voucherno.substring(0,2).equals("PC"))
							{
								type="Cash Payment";
							}
							else if(voucherno.substring(0,2).equals("PB"))
							{
								type="Bank Payment";
							}
							else if(voucherno.substring(0,2).equals("CO"))
							{
								type="Contra Receipt";
							}
							else if(voucherno.substring(0,2).equals("JV"))
							{
								type="Journal";
							}
							else if(voucherno.substring(0,2).equals("DN"))
							{
								type="Debit Note";
							}
							else if(voucherno.substring(0,2).equals("CN"))
							{
								type="Credit Note";
							}
							else if(voucherno.substring(0,2).equals("UD"))
							{
								type="Credit Purchase";
							}
							else if(voucherno.substring(0,2).equals("SD"))
							{
								type="Credit Sales";
							}
							else if(voucherno.substring(0,2).equals("SC"))
							{
								type="Cash Sales";
							}
							else if(voucherno.substring(0,2).equals("UC"))
							{
								type="Cash Purchase";
							}
							usBean.setType(type);
							String x=voucherno.substring(voucherno.length()-5,voucherno.length());
							usBean.setVoucher(x);
							if(amount < 0)
							{
								usBean.setCreditam(Double.toString(Math.abs(amount)));
							}
							else if(amount > 0)
							{
								usBean.setDebitam(Double.toString(amount));
							}
							l1.add(usBean);
						}
				}
				else if(d.equals("05"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
				}
				else if(d.equals("06"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					//System.out.println(sql);
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						//System.out.println("value got "+ref);
						String got[]=ref.split("con");
						//System.out.println("hello "+got[0]+got[1]);
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("07"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("08"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("09"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("10"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("11"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("12"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("01"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
					
				}
				else if(d.equals("02"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}	
					}		
				else if(d.equals("03"))
				{
					sql="select * from accountdetails where ledgerid='"+ledgerid+"' and entrydate like '2017-"+d+"-%' ";
					String vouchertype="";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean=new FormBean();
						date=rs.getString(3);
						voucherno=rs.getString(2);
						amount=rs.getDouble(5);
						vouchertype=rs.getString(8);
						
						usBean.setDate(date);
						usBean.setLedger(ledger);
						String ref=findref(voucherno,date);
						String got[]=ref.split("con");
						usBean.setRefno(got[0]); 
						if(!got[1].equals("0000-00-00"))
						{	
							usBean.setRefdate(got[1]);
						}
						else
						{
							usBean.setRefdate("");
						}
						//System.out.println(voucherno);
						if(voucherno.substring(0,2).equals("RC"))
						{
							type="Cash Receipt";
						}
						else if(voucherno.substring(0,2).equals("RB"))
						{
							type="Bank Receipt";
						}
						else if(voucherno.substring(0,2).equals("PC"))
						{
							type="Cash Payment";
						}
						else if(voucherno.substring(0,2).equals("PB"))
						{
							type="Bank Payment";
						}
						else if(voucherno.substring(0,2).equals("CO"))
						{
							type="Contra Receipt";
						}
						else if(voucherno.substring(0,2).equals("JV"))
						{
							type="Journal";
						}
						else if(voucherno.substring(0,2).equals("DN"))
						{
							type="Debit Note";
						}
						else if(voucherno.substring(0,2).equals("CN"))
						{
							type="Credit Note";
						}
						else if(voucherno.substring(0,2).equals("UD"))
						{
							type="Credit Purchase";
						}
						else if(voucherno.substring(0,2).equals("SD"))
						{
							type="Credit Sales";
						}
						else if(voucherno.substring(0,2).equals("SC"))
						{
							type="Cash Sales";
						}
						else if(voucherno.substring(0,2).equals("UC"))
						{
							type="Cash Purchase";
						}
						usBean.setType(type);
						String x=voucherno.substring(voucherno.length()-5,voucherno.length());
						usBean.setVoucher(x);
						if(amount < 0)
						{
							usBean.setCreditam(Double.toString(Math.abs(amount)));
						}
						else if(amount > 0)
						{
							usBean.setDebitam(Double.toString(amount));
						}
						l1.add(usBean);
					}
				}
				ConnectionDAO.closeConnection(conn);
			}
			catch(Exception f)
			{
				System.out.println("error found on monthwise listing "+f);
			}
			
			return l1;
		}
//datewisereport
		public static List<FormBean> datewisereport(String date,String ledger) 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			int a=0;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			String sql="",ledgerid="";
			double openingbalance=0.00,closing=0.00;
			//System.out.println(date);
			String d1[]=date.split("-");
			//System.out.println(ledger);
			FormBean usBean;
			try
			{
				sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+ledger+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledgerid=rs.getString(1);
					openingbalance=rs.getDouble(2);
				}
				sql="select entrydate,if(amount>0,amount,0),abs(if(amount<0,amount,0)) from accountdetails where entrydate like '"+d1[2]+"-"+d1[1]+"-"+d1[0]+"' and ledgerid='"+ledgerid+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					usBean=new FormBean();
					String date1[]=rs.getString(1).split("-");
					usBean.setDate(date1[2]+"-"+date1[1]+"-"+date1[0]); 
					usBean.setOpebal(Double.toString(openingbalance)); 
					usBean.setDebitam(rs.getString(2));
					usBean.setCreditam(rs.getString(3));
					usBean.setClosing(Double.toString(openingbalance+rs.getDouble(2)-rs.getDouble(3)));   
					l1.add(usBean);
				}
			}	
			catch(Exception d)
			{
				System.out.println("error on "+d);
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
//report edit 
				public static FormBean reportedit(String date,String ledger) 
				{
					FormBean usBean = new FormBean();
					//System.out.println("Value got from reportedit are "+date+" "+ledger);
					Connection conn = ConnectionDAO.getConnectionObject();
					Statement stm = ConnectionDAO.createStatement(conn);
					ResultSet rs;
					String sql="",ledgerid="",voucherno="";
					try
					{
						sql="select ledgerid from ledgermaster where ledgername='"+ledger+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							ledgerid=rs.getString(1);
						}
						usBean.setPart1(ledger);
						sql="select * from accounttransaction where ledgerid='"+ledgerid+"' and entrydate='"+date+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							usBean.setId(rs.getInt(1));
							usBean.setContraref(rs.getString(4));
							usBean.setContradate(rs.getString(5));
							usBean.setShowdate(rs.getString(2)); 
							usBean.setTotal(rs.getString(7));
							voucherno=rs.getString(3);
						}
						sql="select * from accountnarration where voucherno='"+voucherno+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							usBean.setDesc1(rs.getString(3));
						}
						sql="select * from accountdetails where voucherno='"+voucherno+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						Vector<String> vledger=new Vector<String>();
						Vector<String> vledger1=new Vector<String>();
						Vector<String> vamount=new Vector<String>();
						Vector<String> vnarration=new Vector<String>();
						while(rs.next())
						{
							vledger.add(rs.getString(4));
							vamount.add(rs.getString(5));
							vnarration.add(rs.getString(8));
						}
						//System.out.println("vledger size "+vledger.size());
						String[] nar1=new String[vnarration.size()-1];
						String[] amount1=new String[vamount.size()-1];
						String[] ledger1=new String[vledger.size()-1];
						for(int i=1;i<vnarration.size();i++)
						{
								nar1[i-1]=vnarration.get(i);
								String tot=vamount.get(i);
								amount1[i-1]=tot.replaceAll("-", "");
								
								//System.out.println(vledger.get(i));
								sql="select ledgername from ledgermaster where ledgerid='"+vledger.get(i)+"' ";
								//System.out.println(sql);
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ledger1[i-1]=rs.getString(1);
								}
						}
						usBean.setNarration(nar1);
						usBean.setCredit(amount1);
						usBean.setQuantity(ledger1);
					}
					catch(Exception d)
					{ 
						System.out.println("report edit error on "+d);
					}
					ConnectionDAO.closeConnection(conn);
					return usBean;
				}
//getuptodate
				public static FormBean getledger(String ledger) 
				{
					//System.out.println("hello");
					FormBean usBean = new FormBean();
					try
					{
						usBean.setLed("For "+ledger);
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					return usBean;
				}
//get monthwise
				public static FormBean getmonthwise(String months,String ledger) 
				{
					//System.out.println(months+ledger);
					FormBean usBean = new FormBean();
					try
					{
						usBean.setAsondate("For "+ledger+" ("+months+")"); 
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					return usBean;
				}	
//reporteditsave
public static boolean reporteditsave(FormBean FormBean) {
					boolean result=false;		
				String s1[]=FormBean.getContra1();
				String s2[]=FormBean.getCredithidden();
				String s3[]=FormBean.getNarration1();
				Connection conn = ConnectionDAO.getConnectionObject();
				Statement stm = ConnectionDAO.createStatement(conn);
				double oldamount=0.00;
				String ledger="",voucher="";
				String entry="";
				String sql="";
				sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
				try
				{
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledger=rs.getString(1);
						oldamount=rs.getDouble(2);
						voucher=rs.getString(3);
						entry=rs.getString(4);
					}
					String contradate="";
					if(FormBean.getContradate().equals(""))
					{
						contradate="0000-00-00";
					}
					else
					{
						contradate=FormBean.getContradate();
					}
					sql="update accounttransaction set referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//resetting
					//ledger
					double ledbal=0.00;
					sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ledbal=rs.getDouble(1);
					}
					//update ledgermaster
					sql="update ledgermaster set currentbalance='"+(ledbal-oldamount) +"' where ledgerid='"+ledger+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					double subgroupbal=0.00;
					while(rs.next())
					{
						subgroupbal=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(subgroupbal-oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					double grpbal=0.00;
					while(rs.next())
					{
						grpbal=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(grpbal-oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					String abcd="";
					double amou=0.00;
					
					Vector<String> ld=new Vector<String>();
					sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						ld.add(rs.getString(1));
					}
					//System.out.println("length "+s2.length);
					for(int i=0;i<ld.size();i++)//particular hidden array
					{
						
						//System.out.println("Vector: "+ld.size());
						//int k=1;
						if(i!=0)
						{
						sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						Vector<String> am=new Vector<String>();
						while(rs.next()) 
						{
							amou=rs.getDouble(1);//accountdetails
							am.add(rs.getString(1));
						}
						//System.out.println("part amount got "+amou);
						Vector<String> gt=new Vector<String>();
						
						//resetting ledgermaster,subgroupmaster,groupmaster
						//ledgermaster
						sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						double ledgerbal=0.00;
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							ledgerbal=rs.getDouble(1);
						}
						sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//subgroupmaster
						sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						double subbal=0.00;
						while(rs.next())
						{
							subbal=rs.getDouble(1);
						}
						sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//groupmaster
						sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						double gpbal=0.00;
						while(rs.next())
						{
							gpbal=rs.getDouble(1);
						}
						sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
						//resetting ends
						}
					}
					
					sql="delete from accountdetails where voucherno='"+voucher+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+entry+"', '"+ledger+"', '"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					//update to ledger
					sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
					rs=stm.executeQuery(sql);
					double newled=0.00;
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					//System.out.println("new led bal "+newled);
					sql="update ledgermaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
					result=ConnectionDAO.executeUpdate(stm, sql);
					//update to subgroup
					sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					sql="update subgroupmaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
					//update group
					sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						newled=rs.getDouble(1);
					}
					sql="update groupmaster set closingbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
					
					String led="",sql3="";
					double total=0.00;
					Vector<String> voucherno=new Vector<String>();
					for(int i=0;i<s2.length;i++)
					{
						//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
						//result=ConnectionDAO.executeUpdate(stm, sql4);
						
						sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							led=rs.getString(1);
						}
						
						sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+"-"+s2[i]+"', '"+s3[i]+"') ";
						//System.out.println(sql3);
						result=ConnectionDAO.executeUpdate(stm, sql3);
						
						sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
						rs=stm.executeQuery(sql);
						double bal=0.00;
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						total=bal-Double.parseDouble(s2[i]);
						sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							bal=rs.getDouble(1);
						}
						sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
						result=ConnectionDAO.executeUpdate(stm, sql);
						
						//getting voucherno from outstandingledger
						sql="select voucherno from outstandingledger where ledgerid='"+abcd+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							voucherno.add(rs.getString(1));
						}	
						
						//deleting outstanding ledger
						sql="delete from outstandingledger where ledgerid='"+led+"'";
						//System.out.println(sql);
						result=ConnectionDAO.executeUpdate(stm, sql);
					}
					int count=0;
					Vector<String> first=new Vector<String>();
					Vector<String> second=new Vector<String>();
					Vector<String> third=new Vector<String>();
					Vector<String> fourth=new Vector<String>();
					Vector<String> fifth=new Vector<String>();
					Vector<String> sixth=new Vector<String>();
					for(int j=0;j<s1.length;j++)
					{
						String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
						//System.out.println("found "+sql6);
						ResultSet rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							abcd=rs2.getString(1);
						}
						sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
						//System.out.println(sql6);
						rs2=stm.executeQuery(sql6);
						while(rs2.next())
						{
							count=rs2.getInt(1);
						}
						for(int j1=1;j1<=count;j1++)
						{
							sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
							rs2=stm.executeQuery(sql6);
							while(rs2.next())
							{
								first.add(rs2.getString(2));
								second.add(rs2.getString(3));
								third.add(rs2.getString(4));
								fourth.add(rs2.getString(5));
								fifth.add(rs2.getString(6));
								sixth.add(rs2.getString(7));
							}
							sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
							//System.out.println(sql6);
							result=ConnectionDAO.executeUpdate(stm, sql6);
						}
					}
					
				}
				catch(Exception f)
				{
					System.out.println("receipt update error= "+f);
				}
				ConnectionDAO.closeConnection(conn);
				return result;
	}
//cash sales list
public static List<FormBean> cashsaleslist() 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	String sql = "select * from accounttransaction where voucherno like 'SC%' order by id desc";
	//String sql1="select max(id) from accountdetails";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String le="";
	try 
		{
			ResultSet rs = stm.executeQuery(sql);
			FormBean usBean;
			while (rs.next()) 
				{
				usBean = new FormBean();
				
				usBean.setId(rs.getInt(1));//for id
				usBean.setShowdate(rs.getString(2));//entry date
				usBean.setContraref(rs.getString(4));//ref no
				usBean.setContradate(rs.getString(5));//ref date
				usBean.setTotal(rs.getString(7).replaceAll("-", ""));
				String vno=findfirsthead(rs.getString(3));
				usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
				usBean.setPart1(findledger(vno));
				l1.add(usBean);		
				}
		} 
	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//cash list for top on a/c
public static List<FormBean> cashlistonac() 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	String sql1="select * from ledgermaster where ledgerid like 'CH%' order by ledgername asc";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String buffer,x="",x1="",x2="";	
	try 
		{
			ResultSet rs = stm.executeQuery(sql1);		
			FormBean usBean=new FormBean();	
			usBean.setPart1("");	
			l1.add(usBean);
			while (rs.next()) 
				{
					x=rs.getString(3);
					usBean = new FormBean();
					usBean.setPart1(rs.getString(3));	
					l1.add(usBean);	
				}		
		}
	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//cash sales creation
public static boolean cashsalescreation(FormBean FormBean) {
	boolean result=false;		
	String sql = null;	
	String sql1 = null;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	
	if (FormBean.getId() != null) 
	{					
		//String brand= FormBean.getBname();
		//System.out.println("hello");
		//System.out.println("id= "+FormBean.getId());
		//System.out.println("id "+FormBean.getId());     id comming  properly
		String s1[]=FormBean.getContra1();
		String s2[]=FormBean.getCredithidden();
		String s3[]=FormBean.getNarration1();
		double oldamount=0.00;
		String ledger="",voucher="";
		String entry="";
		sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
		try
		{
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledger=rs.getString(1);
				oldamount=rs.getDouble(2);
				voucher=rs.getString(3);
				entry=rs.getString(4);
			}
			String contradate="";
			if(FormBean.getContradate().equals(""))
			{
				contradate="0000-00-00";
			}
			else
			{
				contradate=FormBean.getContradate();
			}
			sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			if(!FormBean.getDesc1().equals(""))
			{
				sql="update accountnarration set narration='"+FormBean.getDesc1()+"', vouchertype='cr' where voucherno='"+voucher+"'";
				//System.out.println("update to narration "+sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			//resetting
			//ledger
			double ledbal=0.00;
			sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledbal=rs.getDouble(1);
			}
			//update ledgermaster
			sql="update ledgermaster set currentbalance='"+(ledbal+oldamount) +"' where ledgerid='"+ledger+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			double subgroupbal=0.00;
			while(rs.next())
			{
				subgroupbal=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance='"+(subgroupbal+oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			double grpbal=0.00;
			while(rs.next())
			{
				grpbal=rs.getDouble(1);
			}
			sql="update groupmaster set closingbalance='"+(grpbal+oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			String abcd="";
			double amou=0.00;
			
			Vector<String> ld=new Vector<String>();
			sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ld.add(rs.getString(1));
			}
			//System.out.println("length "+s2.length);
			for(int i=0;i<ld.size();i++)//particular hidden array
			{
				
				//System.out.println("Vector: "+ld.size());
				//int k=1;
				if(i!=0)
				{
				sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				Vector<String> am=new Vector<String>();
				while(rs.next()) 
				{
					amou=rs.getDouble(1);//accountdetails
					am.add(rs.getString(1));
				}
				//System.out.println("part amount got "+amou);
				Vector<String> gt=new Vector<String>();
				
				//resetting ledgermaster,subgroupmaster,groupmaster
				//ledgermaster
				sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
				//System.out.println(sql);
				double ledgerbal=0.00;
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledgerbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//subgroupmaster
				sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				double subbal=0.00;
				while(rs.next())
				{
					subbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//groupmaster
				sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				double gpbal=0.00;
				while(rs.next())
				{
					gpbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				//resetting ends
			}
			}
			
			sql="delete from accountdetails where voucherno='"+voucher+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//update to ledger
			sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
			rs=stm.executeQuery(sql);
			double newled=0.00;
			while(rs.next())
			{
				newled=rs.getDouble(1);
			}
			//System.out.println("new led bal "+newled);
			sql="update ledgermaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			//update to subgroup
			sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				newled=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
			//update group
			sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				newled=rs.getDouble(1);
			}
			sql="update groupmaster set closingbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
			
			String led="",sql3="";
			double total=0.00;
			Vector<String> voucherno=new Vector<String>();
			for(int i=0;i<s2.length;i++)
			{
				//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
				//result=ConnectionDAO.executeUpdate(stm, sql4);
				
				sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					led=rs.getString(1);
				}
				
				sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s3[i]+"') ";
				//System.out.println(sql3);
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
				sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
				rs=stm.executeQuery(sql);
				double bal=0.00;
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				total=bal+Double.parseDouble(s2[i]);
				sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
			
				//getting voucherno from outstandingledger
				sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno.add(rs.getString(1));
				}	
				
				//deleting outstanding ledger
				sql="delete from outstandingledger where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//deleting adjustmentdetails ledger
				sql="delete from adjustmentdetails where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			int count=0;
			Vector<String> first=new Vector<String>();
			Vector<String> second=new Vector<String>();
			Vector<String> third=new Vector<String>();
			Vector<String> fourth=new Vector<String>();
			Vector<String> fifth=new Vector<String>();
			Vector<String> sixth=new Vector<String>();
			for(int j=0;j<s1.length;j++)
			{
				String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
				//System.out.println("found "+sql6);
				ResultSet rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					abcd=rs2.getString(1);
				}
				sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
				//System.out.println(sql6);
				rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					count=rs2.getInt(1);
				}
				if(count > 0)
				{
				for(int j1=1;j1<=count;j1++)
				{
					sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						first.add(rs2.getString(2));
						second.add(rs2.getString(3));
						third.add(rs2.getString(4));
						fourth.add(rs2.getString(5));
						fifth.add(rs2.getString(6));
						sixth.add(rs2.getString(7));
					}
					//insert outstandingledger
					sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
					
					//insert adjustmentdetails
					sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);

				}
				}
				else
				{}
			}
			
		}
		catch(Exception f)
		{
			System.out.println("cash sales update error= "+f);
		}															
	}
	else
	{	
		String s1[]=FormBean.getNarration();
		String s2[]=FormBean.getDebit();
		String s3[]=FormBean.getPartforcontra();
		String receipt="SC";
		//String receipt1="PB";
		String receipt2="1617";
		String zero="";
		int aa=0;
		String ledgerid="";
		String finalcode="";
		Vector<String> voucherno=new Vector<String>();
		sql="select count(id) from accounttransaction where voucherno like 'SC%'";
		sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
		try
		{
			ResultSet rs1=stm.executeQuery(sql1);
			while(rs1.next())
			{
				ledgerid=rs1.getString(1);
			}
			
			
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				aa=rs.getInt(1);//got id
			}
			
			if(aa==0)
			{
				zero="0000";
				finalcode=receipt+receipt2+receipt2+zero+1;
				//System.out.println("code generated() "+finalcode);
			}
			else if(aa > 0 && aa < 9)
			{
				zero="0000";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(single) "+finalcode);
			}
			else if(aa > 8 && aa < 99)
			{
				zero="000";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(double) "+finalcode);
			}
			else if(aa > 98 && aa < 999)
			{
				zero="00";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(triple) "+finalcode);
			}
			else if(aa > 998 && aa < 9999)
			{
				zero="0";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(quadra) "+finalcode);
			}
			else if(aa > 9998 && aa < 99999)
			{
				finalcode=receipt+receipt2+receipt2+(aa+1);
				//System.out.println("code generated(penta) "+finalcode);
			}
			String contradate="";
			if(FormBean.getContradate().equals(""))
			{
				contradate="0000-00-00";
			}
			else
			{
				contradate=FormBean.getContradate();
			}
			sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','cr')";//insert				
			result = ConnectionDAO.executeUpdate(stm, sql);
			
			String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+"-"+FormBean.getTotal()+"') ";
			result=ConnectionDAO.executeUpdate(stm, sql3);
			
			if(!FormBean.getDesc1().equals(""))
			{
				String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'cr') ";
				//System.out.println(sql2);
				result=ConnectionDAO.executeUpdate(stm, sql2);
			}
			
			//update for ledgermaster
			String forledger="";
			sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getPart1()+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				forledger=rs.getString(1);
			}
			sql1="select currentbalance from ledgermaster where ledgerid='"+forledger+"' ";
			rs=stm.executeQuery(sql1);
			double curbal=0.00;
			while(rs.next())
			{
				curbal=rs.getDouble(1);
			}
			double total=Double.parseDouble(FormBean.getTotal());
			sql="update ledgermaster set currentbalance='"+(curbal-total)+"' where ledgerid='"+forledger+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//update subgroup master
			sql="select currentbalance from subgroupmaster where subgroupcode='"+forledger.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				curbal=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance='"+(curbal-total)+"' where subgroupcode='"+forledger.substring(0,5)+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//update groupmaster
			sql="select closingbalance from groupmaster where groupcode='"+forledger.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				curbal=rs.getDouble(1);
			}
			//System.out.println("group bal:- "+curbal);
			sql="update groupmaster set closingbalance='"+(curbal-total)+"' where groupcode='"+forledger.substring(0,2)+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			String part=FormBean.getPart();
			String led="";
			
			for(int i=0;i<s2.length;i++)
			{
				String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
				result=ConnectionDAO.executeUpdate(stm, sql4);
				
				sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					led=rs.getString(1);
				}
				
				sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s1[i]+"') ";
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
				sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
				rs=stm.executeQuery(sql);
				double bal=0.00;
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				total=bal+Double.parseDouble(s2[i]);
				sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//getting voucherno from outstandingledger
				sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno.add(rs.getString(1));
				}	
				
				//deleting outstanding ledger
				sql="delete from outstandingledger where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//deleting adjustmentdetails ledger
				sql="delete from adjustmentdetails where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}//loop ends
			
			int count=0;
			Vector<String> first=new Vector<String>();
			Vector<String> second=new Vector<String>();
			Vector<String> third=new Vector<String>();
			Vector<String> fourth=new Vector<String>();
			Vector<String> fifth=new Vector<String>();
			Vector<String> sixth=new Vector<String>();
			String abcd="";
			for(int j=0;j<s1.length;j++)
			{
				String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
				//System.out.println("found "+sql6);
				ResultSet rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					abcd=rs2.getString(1);
				}
				sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
				//System.out.println(sql6);
				rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					count=rs2.getInt(1);
				}
				if(count > 0)
				{
				for(int j1=0;j1<count;j1++)
				{
					sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						first.add(rs2.getString(2));
						second.add(rs2.getString(3));
						third.add(rs2.getString(4));
						fourth.add(rs2.getString(5));
						fifth.add(rs2.getString(6));
						sixth.add(rs2.getString(7));
					}
					//insert outstandingledger
					sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
					
					//insert adjustmentdetails
					sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+voucherno.get(j1)+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
				}
				}
				else
				{}
			}
		}
		catch(Exception f)
		{
			System.out.println("error cash sales creation:- "+f);
		}
	}
	ConnectionDAO.closeConnection(conn);
	return result;
	}
//cash purchase creation
public static boolean cashpurchasecreation(FormBean FormBean) {
	boolean result=false;		
	String sql = null;	
	String sql1 = null;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	//System.out.println("inside cash purchase creation");
	if (FormBean.getId() != null) 
	{					
		//String brand= FormBean.getBname();
		//System.out.println("hello");
		//System.out.println("id= "+FormBean.getId());
		//System.out.println("id "+FormBean.getId());     id comming  properly
		String s1[]=FormBean.getContra1();
		String s2[]=FormBean.getCredithidden();
		String s3[]=FormBean.getNarration1();
		double oldamount=0.00;
		String ledger="",voucher="";
		String entry="";
		sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
		try
		{
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledger=rs.getString(1);
				oldamount=rs.getDouble(2);
				voucher=rs.getString(3);
				entry=rs.getString(4);
			}
			String contradate="";
			if(FormBean.getContradate().equals(""))
			{
				contradate="0000-00-00";
			}
			else
			{
				contradate=FormBean.getContradate();
			}
			sql="update accounttransaction set entrydate='"+FormBean.getShowdate()+"', referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+"-"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			sql="update accountnarration set narration='"+FormBean.getDesc1()+"' where voucherno='"+voucher+"'";
			result=ConnectionDAO.executeUpdate(stm, sql);
			//resetting
			//ledger
			double ledbal=0.00;
			sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledbal=rs.getDouble(1);
			}
			//update ledgermaster
			sql="update ledgermaster set currentbalance='"+(ledbal+oldamount) +"' where ledgerid='"+ledger+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			double subgroupbal=0.00;
			while(rs.next())
			{
				subgroupbal=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance='"+(subgroupbal+oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			double grpbal=0.00;
			while(rs.next())
			{
				grpbal=rs.getDouble(1);
			}
			sql="update groupmaster set closingbalance='"+(grpbal+oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			String abcd="";
			double amou=0.00;
			
			Vector<String> ld=new Vector<String>();
			sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ld.add(rs.getString(1));
			}
			//System.out.println("length "+s2.length);
			for(int i=0;i<ld.size();i++)//particular hidden array
			{
				//System.out.println("Vector: "+ld.size());
				//int k=1;
				if(i!=0)
				{
				sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				Vector<String> am=new Vector<String>();
				while(rs.next()) 
				{
					amou=rs.getDouble(1);//accountdetails
					am.add(rs.getString(1));
				}
				//System.out.println("part amount got "+amou);
				Vector<String> gt=new Vector<String>();
				
				//resetting ledgermaster,subgroupmaster,groupmaster
				//ledgermaster
				sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
				//System.out.println(sql);
				double ledgerbal=0.00;
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledgerbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//subgroupmaster
				sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				double subbal=0.00;
				while(rs.next())
				{
					subbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//groupmaster
				sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				double gpbal=0.00;
				while(rs.next())
				{
					gpbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				//resetting ends
			}
			}
			
			sql="delete from accountdetails where voucherno='"+voucher+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+ledger+"', '"+"-"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//update to ledger
			sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
			rs=stm.executeQuery(sql);
			double newled=0.00;
			Vector<String> voucherno=new Vector<String>();
			while(rs.next())
			{
				newled=rs.getDouble(1);
			}
			//System.out.println("new led bal "+newled);
			sql="update ledgermaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			//update to subgroup
			sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				newled=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
			//update group
			sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				newled=rs.getDouble(1);
			}
			sql="update groupmaster set closingbalance='"+(newled-Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
			String led="",sql3="";
			double total=0.00;
			for(int i=0;i<s2.length;i++)
			{
				//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
				//result=ConnectionDAO.executeUpdate(stm, sql4);
				
				sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					led=rs.getString(1);
				} 
				
				sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s3[i]+"') ";
				//System.out.println(sql3);
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
				sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
				rs=stm.executeQuery(sql);
				double bal=0.00;
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				total=bal+Double.parseDouble(s2[i]);
				sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
			
				//getting voucherno from outstandingledger
				sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno.add(rs.getString(1));
				}	
				
				//deleting outstanding ledger
				sql="delete from outstandingledger where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//deleting adjustmentdetails ledger
				sql="delete from adjustmentdetails where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			int count=0;
			Vector<String> first=new Vector<String>();
			Vector<String> second=new Vector<String>();
			Vector<String> third=new Vector<String>();
			Vector<String> fourth=new Vector<String>();
			Vector<String> fifth=new Vector<String>();
			Vector<String> sixth=new Vector<String>();
			for(int j=0;j<s1.length;j++)
			{
				String sql6="select ledgerid from ledgermaster where ledgername = '"+s1[j]+"' ";
				//System.out.println("found "+sql6);
				ResultSet rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					abcd=rs2.getString(1);
				}
				sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
				//System.out.println(sql6);
				rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					count=rs2.getInt(1);
				}
				if(count > 0)
				{
				for(int j1=1;j1<=count;j1++)
				{
					sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						first.add(rs2.getString(2));
						second.add(rs2.getString(3));
						third.add(rs2.getString(4));
						fourth.add(rs2.getString(5));
						fifth.add(rs2.getString(6));
						sixth.add(rs2.getString(7));
					}
					//insert outstandingledger
					sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
					
					//insert adjustmentdetails
					sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+FormBean.getShowdate()+"', '"+voucher+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fifth.get(j1-1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
				}
				}
				else
				{}
			}
		}
		catch(Exception f)
		{
			System.out.println("cash purchase update error= "+f);
		}
														
	}
	else
	{
		
		String s1[]=FormBean.getNarration();
		String s2[]=FormBean.getDebit();
		String s3[]=FormBean.getPartforcontra();
		String receipt="UC";
		//String receipt1="PB";
		String receipt2="1617";
		String zero="";
		int aa=0;
		String ledgerid="";
		String finalcode="";
		Vector<String> voucherno=new Vector<String>();
		sql="select count(id) from accounttransaction where voucherno like 'UC%'";
		sql1="select ledgerid from ledgermaster where ledgername like '"+FormBean.getPart1()+"' ";
		try
		{
			ResultSet rs1=stm.executeQuery(sql1);
			while(rs1.next())
			{
				ledgerid=rs1.getString(1);
			}
			
			
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				aa=rs.getInt(1);//got id
			}
			
			if(aa==0)
			{
				zero="0000";
				finalcode=receipt+receipt2+receipt2+zero+1;
				//System.out.println("code generated() "+finalcode);
			}
			else if(aa > 0 && aa < 9)
			{
				zero="0000";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(single) "+finalcode);
			}
			else if(aa > 8 && aa < 99)
			{
				zero="000";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(double) "+finalcode);
			}
			else if(aa > 98 && aa < 999)
			{
				zero="00";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(triple) "+finalcode);
			}
			else if(aa > 998 && aa < 9999)
			{
				zero="0";
				finalcode=receipt+receipt2+receipt2+zero+(aa+1);
				//System.out.println("code generated(quadra) "+finalcode);
			}
			else if(aa > 9998 && aa < 99999)
			{
				finalcode=receipt+receipt2+receipt2+(aa+1);
				//System.out.println("code generated(penta) "+finalcode);
			}
			String contradate="";
			if(FormBean.getContradate().equals(""))
			{
				contradate="0000-00-00";
			}
			else
			{
				contradate=FormBean.getContradate();
			}
			//System.out.println("final code "+finalcode);
			sql = "insert into accounttransaction(entrydate,voucherno,referenceno,referencedate,ledgerid,totalamount,vouchertype) values('"+FormBean.getShowdate()+"','"+finalcode+"','"+FormBean.getContraref()+"','"+contradate+"','"+ledgerid+"','"+FormBean.getTotal()+"','cr')";//insert				
			result = ConnectionDAO.executeUpdate(stm, sql);
			
			String sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount ) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+ledgerid+"', '"+"-"+FormBean.getTotal()+"') ";
			result=ConnectionDAO.executeUpdate(stm, sql3);
			
			if(!FormBean.getDesc1().equals(""))
			{
				String sql2="insert into accountnarration(voucherno, narration, vouchertype) values('"+finalcode+"', '"+FormBean.getDesc1()+"', 'cr') ";
				result=ConnectionDAO.executeUpdate(stm, sql2);
			}
			
			//update for ledgermaster
			String forledger="";
			sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getPart1()+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				forledger=rs.getString(1);
			}
			sql1="select currentbalance from ledgermaster where ledgerid='"+forledger+"' ";
			rs=stm.executeQuery(sql1);
			double curbal=0.00;
			while(rs.next())
			{
				curbal=rs.getDouble(1);
			}
			double total=Double.parseDouble(FormBean.getTotal());
			sql="update ledgermaster set currentbalance='"+(curbal-total)+"' where ledgerid='"+forledger+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//update subgroup master
			sql="select currentbalance from subgroupmaster where subgroupcode='"+forledger.substring(0,5)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				curbal=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance='"+(curbal-total)+"' where subgroupcode='"+forledger.substring(0,5)+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//update groupmaster
			sql="select closingbalance from groupmaster where groupcode='"+forledger.substring(0,2)+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				curbal=rs.getDouble(1);
			}
			//System.out.println("group bal:- "+curbal);
			sql="update groupmaster set closingbalance='"+(curbal-total)+"' where groupcode='"+forledger.substring(0,2)+"' ";
			result=ConnectionDAO.executeUpdate(stm, sql);
			String part=FormBean.getPart();
			String led="";
			
			for(int i=0;i<s2.length;i++)
			{
				String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
				result=ConnectionDAO.executeUpdate(stm, sql4);
				
				sql="select ledgerid from ledgermaster where ledgername='"+s3[i]+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					led=rs.getString(1);
				}
				
				sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+finalcode+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+s2[i]+"', '"+s1[i]+"') ";
				result=ConnectionDAO.executeUpdate(stm, sql3);
				
				sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
				rs=stm.executeQuery(sql);
				double bal=0.00;
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				total=bal+Double.parseDouble(s2[i]);
				sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(bal+Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(bal+Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//getting voucherno from outstandingledger
				sql="select voucherno from outstandingledger where ledgerid='"+led+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno.add(rs.getString(1));
				}	
				
				//deleting outstanding ledger
				sql="delete from outstandingledger where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//deleting adjustmentdetails ledger
				sql="delete from adjustmentdetails where ledgerid='"+led+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}//loop ends
			
			int count=0;
			Vector<String> first=new Vector<String>();
			Vector<String> second=new Vector<String>();
			Vector<String> third=new Vector<String>();
			Vector<String> fourth=new Vector<String>();
			Vector<String> fifth=new Vector<String>();
			Vector<String> sixth=new Vector<String>();
			String abcd="";
			for(int j=0;j<s1.length;j++)
			{
				String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
				//System.out.println("found "+sql6);
				ResultSet rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					abcd=rs2.getString(1);
				}
				sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
				//System.out.println(sql6);
				rs2=stm.executeQuery(sql6);
				while(rs2.next())
				{
					count=rs2.getInt(1);
				}
				if(count > 0)
				{
				for(int j1=0;j1<count;j1++)
				{
					sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
					rs2=stm.executeQuery(sql6);
					while(rs2.next())
					{
						first.add(rs2.getString(2));
						second.add(rs2.getString(3));
						third.add(rs2.getString(4));
						fourth.add(rs2.getString(5));
						fifth.add(rs2.getString(6));
						sixth.add(rs2.getString(7));
					}
					//insert outstandingledger
					sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fourth.get(j1)+"', '"+fifth.get(j1)+"', '"+sixth.get(j1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
					
					//insert adjustmentdetails
					sql6="insert into adjustmentdetails(ledgerid, voucherno ,entrydate, adjustedvoucherno, referenceno, referencedate, adjustedamount)values('"+first.get(j1)+"', '"+finalcode+"', '"+FormBean.getShowdate()+"', '"+finalcode+"', '"+second.get(j1)+"', '"+third.get(j1)+"', '"+fifth.get(j1)+"')";
					//System.out.println(sql6);
					result=ConnectionDAO.executeUpdate(stm, sql6);
				}
				}
				else
				{}
			}
		}
		catch(Exception f)
		{
			System.out.println("error cash purchase creation:- "+f);
		}
	}
	ConnectionDAO.closeConnection(conn);
	return result;
	}
//cashpurchaselist
public static List<FormBean> cashpurchaselist() 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	String sql = "select * from accounttransaction where voucherno like 'UC%' order by id desc";
	//String sql1="select max(id) from accountdetails";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String le="";
	try 
		{
			ResultSet rs = stm.executeQuery(sql);
			FormBean usBean;
			while (rs.next()) 
				{
				usBean = new FormBean();
				
				usBean.setId(rs.getInt(1));//for id
				usBean.setShowdate(rs.getString(2));//entry date
				usBean.setContraref(rs.getString(4));//ref no
				usBean.setContradate(rs.getString(5));//ref date
				usBean.setTotal(rs.getString(7).replaceAll("-", ""));
				String vno=findfirsthead(rs.getString(3));
				usBean.setVoucher(findvtype(rs.getString(3))+" - "+rs.getString(3).substring(rs.getString(3).length()-5,rs.getString(3).length())); 
				usBean.setPart1(findledger(vno));
				l1.add(usBean);		
				}
		} 
	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//opening trial display
public static List<FormBean> openingtriallist() 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	double x=0.00,totaldebit=0.00,totalcredit=0.00,difference=0.00;
	String ledname="",lcd="";
		
	try 
		{
		String sql="select ledgermaster.openingbalance,ledgermaster.ledgername,groupmaster.groupname from ledgermaster inner join groupmaster where left(ledgermaster.ledgerid,2)=groupmaster.groupcode and ledgermaster.openingbalance<>'0'";
			ResultSet rs = stm.executeQuery(sql);		
			
			while (rs.next()) 
				{
				FormBean usBean=new FormBean();	
					x=rs.getDouble(1);
					ledname=rs.getString(2);						
					lcd=rs.getString(3);
					usBean.setGrouphead(lcd);
					usBean.setParticular(ledname);
					if(x<0)
					{
						usBean.setOpeningbal("<right>"+Double.toString(Math.abs(x))+" Cr</right>");
						usBean.setCreditamt(Double.toString(Math.abs(x)));
						totalcredit=totalcredit+x;
					}
					else if(x>0)
					{
						usBean.setOpeningbal("<span align='right'>"+Double.toString(Math.abs(x))+" Dr</span>");
						usBean.setDebitamt(Double.toString(Math.abs(x)));
						totaldebit=totaldebit+x;
					}
					else{
						usBean.setOpeningbal(Double.toString(x));
						usBean.setCreditamt("");
						usBean.setDebitamt("");
					}
					
					
					l1.add(usBean);	
				}
			difference=totaldebit-totalcredit;
			FormBean usBean=new FormBean();
			if(difference<0){
				usBean.setParticular("<b><span style='color:red'>Difference "+Math.abs(difference) +" Cr</span></b>");
			}
			else if(difference>0){
				usBean.setParticular("<b><span style='color:red'>Difference "+Math.abs(difference) +" Dr</span></b>");
			}
			else{
				usBean.setParticular("<b><span style='color:red'>Difference </span></b>");
			}
			usBean.setDebitamt("<b><span style='color:red'>"+Double.toString(totaldebit)+" Dr.</span></b>");
			usBean.setCreditamt("<b><span style='color:red'>"+Double.toString(totalcredit)+" Cr. </span></b>");
			l1.add(usBean);
			
		}
	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	ConnectionDAO.closeConnection(conn);
	return l1;
}

public static List<FormBean> accnamelist(FormBean f)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	
	
	String sql= "select ledgername from ledgermaster where ledgerid like 'CH%' ";
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try 
		{
			ResultSet rs = stm.executeQuery(sql);
			FormBean usBean;				
			while (rs.next()) 
				{
					usBean = new FormBean();
					usBean.setAccname(rs.getString(1));
					l1.add(usBean);
				}
		} 
	catch (SQLException e) 
		{
			e.printStackTrace();
		}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static FormBean monthreport1(String month,String accid,String shortn,String longn) {
	FormBean usBean = new FormBean();
	usBean.setMonth(month);
	usBean.setAccid(accid);
	usBean.setShortn(shortn);
	usBean.setLongn(longn);
	
	////System.out.println(accid);
	return usBean;
	}
public static List<FormBean> monthreport(String month,String accid,String shortn,String longn) 
{
	
	List<FormBean> l1 = new ArrayList<FormBean>();
	int a=0;
	
	//System.out.println("value "+month+accid+shortn+longn);
	////System.out.println(accid);
	switch(month)
	{
	case "April 2016":		a=04;	break;
	case "May 2016":		a=05;	break;
	case "June 2016":		a=06;	break;
	case "July 2016":		a=07;	break;
	case "August 2016":		a=8;	break;
	case "September 2016":	a=9;	break;
	case "October 2016":	a=10;	break;
	case "November 2016":	a=11;	break;
	case "December 2016":	a=12;	break;
	case "January 2017":	a=01;	break;
	case "February 2017":	a=02;	break;
	case "March 2017":		a=03;	break;		
	}

	try
	{
		double x=0.00,x1=0.00,x2=0.00,totaldebit=0.00,totalcredit=0.00,closing=0.00;		
		String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+accid+"' "; 	
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String lid="";		
				
				
				FormBean usBean=new FormBean();
				ResultSet rs = stm.executeQuery(sql);
				////System.out.println(sql);
				while (rs.next()) 
					{
						lid=rs.getString(1);
						x=rs.getDouble(2);

					}
				usBean = new FormBean();

			usBean.setRefdate("<b><span style='color:red'>Opening Balance</span></b>");
			if(x<0){
				usBean.setCreditamt("<b><span style='color:red'>"+Double.toString(x)+ "Cr</span></b>");
				}
			else if(x==0.0){
				usBean.setCreditamt("");
					}
			else{
				usBean.setDebitamt("<b><span style='color:red'>"+Double.toString(x)+"</span></b>");
				}
				l1.add(usBean);
		String v="",vno="",type="",date="",refno="",refdate="",sn="",ln="";	
		
 if(shortn.compareTo("Without_Narration")==0 && longn.compareTo("Without_Narration")==0)	
 {			
		sql="select accountdetails.voucherno,accountdetails.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),accounttransaction.referenceno,accounttransaction.referencedate,abs(if(accountdetails.amount<0,amount,0)),if(accountdetails.amount>0,amount,0) from accountdetails inner join accounttransaction where accountdetails.ledgerid='"+lid+"' and accountdetails.voucherno=accounttransaction.voucherno and accountdetails.entrydate like '______"+a+"___'";		
		rs = stm.executeQuery(sql);
		while(rs.next())
		{
			v=rs.getString(1);	
			date=rs.getString(2);
			type=rs.getString(3);
			vno=rs.getString(4);
			refno=rs.getString(5);
			refdate=rs.getString(6);
			x1=rs.getDouble(7);
			x2=rs.getDouble(8);
			
			
			switch(type)
			{
			case "RC":  type="Cash Receipt";   break;
			case "RB":  type="Bank Receipt";   break;
			case "CO":  type="Contra";		   break;
			case "JV":  type="Journal";		   break;
			case "PB":  type="Bank Payment";   break;
			case "PC":  type="Cash Payment";   break;
			case "DN":  type="Debit Note";	   break;
			case "CN":  type="Credit Note";	   break;
			case "UC":  type="Cash Purchase";  break;
			case "SC":  type="Cash Sales";	   break;
			case "UD":  type="Credit Purchase";break;
			case "SD":  type="Credit Sales";   break;
			}

			usBean = new FormBean();
			
			usBean.setDate(date);
			usBean.setType(type);
			usBean.setVno(vno);
			usBean.setRefno(refno);
			if(refdate.equals("0000-00-00"))
			{
				usBean.setRefdate("");
			}
			else{
			usBean.setRefdate(refdate);
			}
			//usBean.setOpening_bal(Double.toString(x2));
			if(x1==0.0){
			usBean.setCreditamt("");
			}
			else{
				usBean.setCreditamt(Double.toString(x1) +" Cr");
			}
			totalcredit=totalcredit+x1;
			if(x2==0.0){
				usBean.setDebitamt("");
			}else{
			usBean.setDebitamt(Double.toString(x2)+" Dr");
			}
			
			totaldebit=totaldebit+x2;
			//usBean.setClosing_balance(Double.toString(x3));
			//x2=x3;
			l1.add(usBean);		
			
			
		}
 }
 
 else if(shortn.compareTo("With_Narration")==0 && longn.compareTo("Without_Narration")==0)
 {
	 sql="select accountdetails.voucherno,accountdetails.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),accounttransaction.referenceno,accounttransaction.referencedate,abs(if(accountdetails.amount<0,amount,0)),if(accountdetails.amount>0,amount,0),group_concat(accountdetails.narration separator ',') from accountdetails inner join accounttransaction where accountdetails.ledgerid='"+lid+"' and accountdetails.voucherno=accounttransaction.voucherno and accountdetails.entrydate like '______"+a+"___'";		
	 //System.out.println(sql);	
	 rs = stm.executeQuery(sql);
		while(rs.next())
		{
			v=rs.getString(1);	
			date=rs.getString(2);
			type=rs.getString(3);
			vno=rs.getString(4);
			refno=rs.getString(5);
			refdate=rs.getString(6);
			x1=rs.getDouble(7);
			x2=rs.getDouble(8);
			sn=rs.getString(9);
			
			switch(type)
			{
			case "RC":  type="Cash Receipt";   break;
			case "RB":  type="Bank Receipt";   break;
			case "CO":  type="Contra";		   break;
			case "JV":  type="Journal";		   break;
			case "PB":  type="Bank Payment";   break;
			case "PC":  type="Cash Payment";   break;
			case "DN":  type="Debit Note";	   break;
			case "CN":  type="Credit Note";	   break;
			case "UC":  type="Cash Purchase";  break;
			case "SC":  type="Cash Sales";	   break;
			case "UD":  type="Credit Purchase";break;
			case "SD":  type="Credit Sales";   break;
			}

			usBean = new FormBean();
			
			usBean.setDate(date);
			usBean.setType(type);
			usBean.setVno(vno);
			usBean.setRefno(refno);
			if(refdate.equals("0000-00-00"))
			{
				usBean.setRefdate("");
			}
			else{
			usBean.setRefdate(refdate);
			}
			//usBean.setOpening_bal(Double.toString(x2));
			if(x1==0.0){
			usBean.setCreditamt("");
			}
			else{
				usBean.setCreditamt(Double.toString(x1) +" Cr");
			}
			totalcredit=totalcredit+x1;
			if(x2==0.0){
				usBean.setDebitamt("");
			}else{
			usBean.setDebitamt(Double.toString(x2)+" Dr");
			}
			usBean.setShortn(sn);
			
			totaldebit=totaldebit+x2;
			//usBean.setClosing_balance(Double.toString(x3));
			//x2=x3;
			l1.add(usBean);		
			
			
		}
 }
 
 else if(shortn.compareTo("Without_Narration")==0 && longn.compareTo("With_Narration")==0)
 {
	 Vector<String> vo=new Vector<String>();
	 sql="select accountdetails.voucherno from accountdetails inner join accounttransaction where accountdetails.ledgerid='"+lid+"' and accountdetails.voucherno=accounttransaction.voucherno and accountdetails.entrydate like '______"+a+"___'";
	
	 rs=stm.executeQuery(sql);
	 while(rs.next())
	 {
		 vo.add(rs.getString(1));
	 }
	// System.out.println(vo.get(1)+""+vo.get(2)+""+vo.get(3)+""+vo.get(4)+""+vo.get(5)+""+vo.get(6)+""+vo.get(0));
	 for(int i=0;i<vo.size();i++)
	 {
	 sql="select accountdetails.voucherno,accountdetails.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),accounttransaction.referenceno,accounttransaction.referencedate,abs(if(accountdetails.amount<0,amount,0)),if(accountdetails.amount>0,amount,0) from accountdetails inner join accounttransaction where accountdetails.voucherno='"+vo.get(i)+"' ";		
		//System.out.println(sql);
	 rs = stm.executeQuery(sql);
		while(rs.next())
		{
			v=rs.getString(1);	
			date=rs.getString(2);
			type=rs.getString(3);
			vno=rs.getString(4);
			refno=rs.getString(5);
			refdate=rs.getString(6);
			x1=rs.getDouble(7);
			x2=rs.getDouble(8);
			
			
			switch(type)
			{
			case "RC":  type="Cash Receipt";   break;
			case "RB":  type="Bank Receipt";   break;
			case "CO":  type="Contra";		   break;
			case "JV":  type="Journal";		   break;
			case "PB":  type="Bank Payment";   break;
			case "PC":  type="Cash Payment";   break;
			case "DN":  type="Debit Note";	   break;
			case "CN":  type="Credit Note";	   break;
			case "UC":  type="Cash Purchase";  break;
			case "SC":  type="Cash Sales";	   break;
			case "UD":  type="Credit Purchase";break;
			case "SD":  type="Credit Sales";   break;
			}
		sql="select narration from accountnarration where voucherno='"+vo.get(i)+"' ";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ln=rs.getString(1);
		}
			
			usBean = new FormBean();
			
			usBean.setDate(date);
			usBean.setType(type);
			usBean.setVno(vno);
			usBean.setRefno(refno);
			if(refdate.equals("0000-00-00"))
			{
				usBean.setRefdate("");
			}
			else{
			usBean.setRefdate(refdate);
			}
			//usBean.setOpening_bal(Double.toString(x2));
			if(x1==0.0){
			usBean.setCreditamt("");
			}
			else{
				usBean.setCreditamt(Double.toString(x1) +" Cr");
			}
			totalcredit=totalcredit+x1;
			if(x2==0.0){
				usBean.setDebitamt("");
			}else{
			usBean.setDebitamt(Double.toString(x2)+" Dr");
			}
			usBean.setLongn(ln);
			
			totaldebit=totaldebit+x2;
			//usBean.setClosing_balance(Double.toString(x3));
			//x2=x3;
			l1.add(usBean);		
		}	
			
		}
 }
 
 else if(shortn.compareTo("With_Narration")==0 && longn.compareTo("With_Narration")==0)
 {
	 
	 Vector<String> vo=new Vector<String>();
	 sql="select accountdetails.voucherno from accountdetails inner join accounttransaction where accountdetails.ledgerid='"+lid+"' and accountdetails.voucherno=accounttransaction.voucherno and accountdetails.entrydate like '______"+a+"___'";
	 rs=stm.executeQuery(sql);
	 while(rs.next())
	 {
		 vo.add(rs.getString(1));
	 }
	//System.out.println(vo);
	 for(int i=0;i<vo.size();i++)
	 {
	 sql="select accountdetails.voucherno,accountdetails.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),accounttransaction.referenceno,accounttransaction.referencedate,abs(if(accountdetails.amount<0,amount,0)),if(accountdetails.amount>0,amount,0),group_concat(accountdetails.narration separator ',') from accountdetails inner join accounttransaction where accountdetails.voucherno='"+vo.get(i)+"' and accountdetails.ledgerid='"+lid+"' and accountdetails.voucherno=accounttransaction.voucherno and accountdetails.entrydate like '______"+a+"___' ";		
	 //System.out.println(sql);
	 rs = stm.executeQuery(sql);
		while(rs.next())
		{
			v=rs.getString(1);	
			date=rs.getString(2);
			type=rs.getString(3);
			vno=rs.getString(4);
			refno=rs.getString(5);
			refdate=rs.getString(6);
			x1=rs.getDouble(7);
			x2=rs.getDouble(8);
			sn=rs.getString(9);
			//System.out.println(vo.get(i));
			switch(type)
			{
			case "RC":  type="Cash Receipt";   break;
			case "RB":  type="Bank Receipt";   break;
			case "CO":  type="Contra";		   break;
			case "JV":  type="Journal";		   break;
			case "PB":  type="Bank Payment";   break;
			case "PC":  type="Cash Payment";   break;
			case "DN":  type="Debit Note";	   break;
			case "CN":  type="Credit Note";	   break;
			case "UC":  type="Cash Purchase";  break;
			case "SC":  type="Cash Sales";	   break;
			case "UD":  type="Credit Purchase";break;
			case "SD":  type="Credit Sales";   break;
			}
		sql="select narration from accountnarration where voucherno='"+vo.get(i)+"' ";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ln=rs.getString(1);
		}
			
			usBean = new FormBean();
			
			usBean.setDate(date);
			usBean.setType(type);
			usBean.setVno(vno);
			usBean.setRefno(refno);
			if(refdate.equals("0000-00-00"))
			{
				usBean.setRefdate("");
			}
			else{
			usBean.setRefdate(refdate);
			}
			//usBean.setOpening_bal(Double.toString(x2));
			if(x1==0.0){
			usBean.setCreditamt("");
			}
			else{
				usBean.setCreditamt(Double.toString(x1) +" Cr");
			}
			totalcredit=totalcredit+x1;
			if(x2==0.0){
				usBean.setDebitamt("");
			}else{
			usBean.setDebitamt(Double.toString(x2)+" Dr");
			}
			usBean.setShortn(sn);
			usBean.setLongn(ln);
			
			totaldebit=totaldebit+x2;
			//usBean.setClosing_balance(Double.toString(x3));
			//x2=x3;
			l1.add(usBean);		
		}	
			
		}
 }
 
 
		closing=x+totaldebit+totalcredit;
		usBean = new FormBean();
		usBean.setType("<b><span style='color:red'>Closing " +closing +"</span></b>");
		usBean.setDebitamt("<b><span style='color:red'>"+Double.toString(totaldebit)+"</span></b>");
		usBean.setCreditamt("<b><span style='color:red'>"+Double.toString(totalcredit)+"</span></b>");
		
		l1.add(usBean);
		ConnectionDAO.closeConnection(conn);
}catch (SQLException e) 
	{
	e.printStackTrace();
	}
	return l1;
}
public static List<FormBean> cashbooklistdetails(FormBean formbean) 
{
	
	List<FormBean> l1 = new ArrayList<FormBean>();
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try{
		String s1=formbean.getFrmdate();
		String s2=formbean.getTodate();
		String s3=formbean.getAccname();
		
		double x=0.00,x1=0.00,amt=0.00,totalamount=0.00;
		String lid="",vno="",lcd="";
		String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"' ";
		//System.out.println("uslist2  "+sql);
		
		ResultSet rs=stm.executeQuery(sql);
		//System.out.println(sql );
		while(rs.next())
		{
			lid=rs.getString(1);
			x=rs.getDouble(2);
			//System.out.println("ledgerid"+ lid );
		}
		
		sql="select sum(amount) from accountdetails where ledgerid='"+lid+"' and entrydate<'"+s1+"' ";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			x1=rs.getDouble(1);
		}
		//System.out.println(x1 );
		
		x=x+x1;

		FormBean usBean=new FormBean();
		if(x > 0)
		{
			usBean.setRefno("<span style='color:red'>Opening Balance</span>");
			usBean.setRefdate("<span style='color:red'>"+Double.toString(x)+"</span>");
			l1.add(usBean);
		}

			sql="select voucherno,amount,ledgerid,entrydate from accountdetails where entrydate>='"+s1+"' and entrydate<='"+s2+"' and ledgerid!='"+lid+"' and (left(voucherno,2)='PC' or left(voucherno,2)='RC' or left(voucherno,2)='CO' )";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean = new FormBean();
				vno=rs.getString(1);
				amt=rs.getDouble(2);
				if(amt > 0)
				{
				//System.out.println(amt); 
				usBean.setAmount("Rs. "+Double.toString(amt)+" Dr");
				totalamount=totalamount+amt;
				lcd=rs.getString(3);
				
				String ref=findref(vno,rs.getString(4));
				//System.out.println("findref "+ref);
				String got[]=ref.split("con");
				/*System.out.println(got[0]);
				System.out.println(got[1]);
				System.out.println(got[2]);*/
				usBean.setParticular(findledger(lcd));
				usBean.setRefno(got[0]);
				usBean.setRefdate(got[1]);
				l1.add(usBean);
				}
			}
			usBean=new FormBean();
			usBean.setRefdate("<font color='red'><b>Total: </b></font>");
			usBean.setAmount("<font color='red'><b>"+Double.toString(totalamount)+" Dr</b></font>");
			l1.add(usBean);
		//}	
		//l1.add(usBean);
	}catch (Exception e) 
	{
	e.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static List<FormBean> cashbooklistdetails2(FormBean formbean) 
{
	
	List<FormBean> l1 = new ArrayList<FormBean>();
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try{
		String s1=formbean.getFrmdate();
		String s2=formbean.getTodate();
		String s3=formbean.getAccname();
		
		double x=0.00,x1=0.00,amt=0.00,totalamount=0.00;
		String lid="",vno="",lcd="";
		String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"' ";
		//System.out.println("uslist1 "+sql);
		
		ResultSet rs=stm.executeQuery(sql);
		//System.out.println(sql );
		while(rs.next())
		{
			lid=rs.getString(1);
			x=rs.getDouble(2);
		}
		
		sql="select sum(amount) from accountdetails where ledgerid='"+lid+"' and entrydate<'"+s1+"' ";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			x1=rs.getDouble(1);
		}
		x=x+x1;
		FormBean usBean=new FormBean();
		if(x <= 0)
		{
			usBean.setRefno("<span style='color:red'>Opening Balance</span>");
			usBean.setRefdate("<span style='color:red'>"+Double.toString(x)+"</span>");
			l1.add(usBean);
		}
		sql="select voucherno,amount,ledgerid,entrydate from accountdetails where entrydate>='"+s1+"' and entrydate<='"+s2+"' and ledgerid!='"+lid+"' and (left(voucherno,2)='PC' or left(voucherno,2)='RC' or left(voucherno,2)='CO' )";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean = new FormBean();
				vno=rs.getString(1);
				amt=rs.getDouble(2);
				
				if(amt <= 0)
				{
				String xx=Double.toString(amt).replace("-", "");
				totalamount=totalamount+amt;
				usBean.setAmount("Rs. "+xx+" Cr");
				lcd=rs.getString(3);				
				String ref=findref(vno,rs.getString(4));				
				String got[]=ref.split("con");
				/*System.out.println(got[0]);
				System.out.println(got[1]);
				System.out.println(got[2]);*/
				usBean.setParticular(findledger(lcd));
				usBean.setRefno(got[0]);
				usBean.setRefdate(got[1]);
				//System.out.println(lcd+","+got[0]+","+got[1]+","+amt);
				l1.add(usBean);
				}
			}
			usBean=new FormBean();
			usBean.setRefdate("<font color='red'><b>Total: </b></font>");
			usBean.setAmount("<font color='red'><b>"+Double.toString(totalamount).replaceAll("-", "")+" Cr</b></font>");
			l1.add(usBean);
	}catch (Exception e) 
	{
	e.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static List<FormBean> cashtriallistdetails(FormBean formbean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	//System.out.println("cashtriallist");
	String s1=formbean.getFrmdate();
	//System.out.println("hello "+s1);
	String s2=formbean.getTodate();
	//System.out.println("value got is "+s1);

	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	
	Vector<String> vno=new Vector<String>();
	String particular="",lid1="",lid2="",vn="";
	double opbal1=0.00,opbal2=0.00,amt=0.00,dramt=0.00,cramt=0.00,opening=0.00,closing=0.00,amount1=0.00,amount2=0.00; 
	try{
		String sql="select voucherno from accounttransaction where entrydate<'"+s1+"' ";
		//System.out.println(sql);
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			vno.add(rs.getString(1));			
		}
		//System.out.println("voucher no" +vno.size());
			for(int i=0;i<vno.size();i++)
			{
				//System.out.println(i);
				//System.out.println("hello "+vno.get(i));
				sql="select amount,ledgerid from accountdetails where voucherno='"+vno.get(i)+"' and left(ledgerid,2)='CH'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				
				while(rs.next())
				{
					amount1=rs.getDouble(1);
					lid1=rs.getString(2);
					
				}
				//System.out.println("amount1" +amount1.get(i));
				sql="select amount,ledgerid from accountdetails where voucherno='"+vno.get(i)+"' and left(ledgerid,2)!='CH'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
					while(rs.next())
					{
						amount2=rs.getDouble(1);
						lid2=rs.getString(2);
					}
					//System.out.println("amount2" +amount2);
					
						sql="select opbal1,opbal2 from ledgermaster where ledgerid='"+lid1+"' ";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							opbal1=rs.getDouble(1);
							opbal2=rs.getDouble(2);
							opbal1=opbal1+amount1;
							opbal2=opbal2+amount2;
						}
					
			
				sql="select opbal1,opbal2,ledgername,creditamount,debitamount from ledgermaster where ledgerid='"+lid2+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					opbal1=rs.getDouble(1);
					opbal2=rs.getDouble(2);
					particular=rs.getString(3);
					cramt=rs.getDouble(4);
					dramt=rs.getDouble(5);
					opbal1=opbal1+amount1;
					opbal2=opbal2+amount2;
					
				}
							
				//System.out.println(opbal1+"        "+opbal2);
				sql="select voucherno from accounttransaction where entrydate>='"+s1+"' and entrydate<='"+s2+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					vn=rs.getString(1);
				}
				sql="select amount from accountdetails where voucherno='"+vn+"' and left(ledgerid,2)!='CH'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{	
					if(rs.getDouble(1)==0)
					{
						amt=0;
					}
					else
					{
						amt=rs.getDouble(1);
					}
					
					//System.out.println("amount new"+amt);
					if(amt>=0)
					{
						dramt=dramt+amt;
					}
					else
					{
						cramt=cramt+amt;
					}	
				}
				opbal2=amt+opbal2;
				opening=opening+opbal1;
				closing=closing+opbal2;
				//System.out.println("opening balance"+opening +"    "+closing);
				FormBean usBean=new FormBean();
				//System.out.println("hello "+particular+" "+cramt+" "+dramt);
				usBean.setParticular(particular);
				usBean.setCashrcvd(Double.toString(cramt));
				usBean.setCashpaid(Double.toString(dramt));
				l1.add(usBean);
			} 
			FormBean usBean=new FormBean();
			usBean.setParticular("<b><span style='color:red'>Closing "+Double.toString(closing)+"</span></b>");
			l1.add(usBean);
			//System.out.println(opbal1+ "          " +opbal2 );
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static FormBean setforledger(String x) 
{
	FormBean usBean1=new FormBean();
	//System.out.println("value to helper "+x);
	usBean1.setGetsession(x); 
	return usBean1;
}
//statement
public static List<FormBean> statementlistdetails(FormBean formbean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	String s1=formbean.getFrmdate();
	String s2=formbean.getTodate();
	String s3=formbean.getAcname();
	////System.out.println(s3);
	Map<String ,Object> session12=ActionContext.getContext().getSession();
	session12.put("frmdate", ""+s1);
	session12.put("todate", ""+s2);
	session12.put("ledger", ""+s3);
	try
	{	
		double x=0.00,x1=0.00,x2=0.00,x3=0.00,x4=0.00,x5=0.00,debitamt=0.00,creditamt=0.00,totaldr=0.00,totalcr=0.00,totalclosing=0.00;	
		////System.out.println("date "+(s+1));	
		String sql1="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"'"; 
		////System.out.println(sql1);
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		String lid="",type="",vno="",date="";	
		double totald=0.00,totalc=0.00,tc=0.00;
			FormBean usBean=new FormBean();
			ResultSet rs = stm.executeQuery(sql1);
			while (rs.next()) 
				{
					lid=rs.getString(1);
					x=rs.getDouble(2);
					////System.out.println("hhh "+x);
				}
				String sql="select sum(amount) from accountdetails where entrydate <'"+s1+"' and ledgerid='"+lid+"' ";
				////System.out.println(sql);
				rs = stm.executeQuery(sql);
				
				while (rs.next()) 
				{
						x1=rs.getDouble(1);
						////System.out.println("sum amount  "+x1);
				}		
					x2=x1+x;
					usBean= new FormBean();
					usBean.setAmount_credited("<b><span style='color:red'>Opening Balance</span></b>");
					usBean.setClosing_balance("<b><span style='color:red'>"+Double.toString(x2).replace("-", "")+"</span></b>");
					if(x2<0){
						usBean.setDrcr("<b><span style='color:red'>Cr</span></b>");
					}
					else if(x2>0){
						usBean.setDrcr("<b><span style='color:red'>Dr</span></b>");
					} else{
						usBean.setDrcr(" ");
					}
					l1.add(usBean);
			sql="select * from accountdetails where ledgerid='"+lid+"' and entrydate between '"+s1+"' and '"+s2+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean=new FormBean();
				usBean.setDate(rs.getString(3));
				usBean.setVno(findvtype(rs.getString(2).substring(0,2))+" - "+rs.getString(2).substring(10, rs.getString(2).length()));
				if(rs.getDouble(5) > 0)
				{
					usBean.setAmount_debited(Double.toString(rs.getDouble(5)));
					usBean.setDrcr("Dr");
					usBean.setAmount_credited("");
					totald=totald+rs.getDouble(5);
				}
				else if(rs.getDouble(5) <= 0)
				{
					usBean.setAmount_debited("");
					usBean.setAmount_credited(Double.toString(rs.getDouble(5)).replace("-","") );
					totalc=totalc-rs.getDouble(5);
					usBean.setDrcr("Cr");
				}
				usBean.setClosing_balance(rs.getString(5).replace("-",""));
				tc=tc+Double.parseDouble(rs.getString(5).replace("-",""));
				l1.add(usBean);
			}
			usBean=new FormBean();
			usBean.setVno("<b>Total: </b>");
			usBean.setAmount_debited("<b>"+totald+" Dr</b>");
			usBean.setAmount_credited("<b>"+totalc+" Cr</b>");	
			usBean.setClosing_balance("<b>"+tc+"</b>");
			l1.add(usBean);
	ConnectionDAO.closeConnection(conn);
	
	}catch (SQLException e) 
	{
	e.printStackTrace();
	}
	return l1;
}
public static FormBean statementeditdetails(String date,String ledger) 
{
	FormBean usBean = new FormBean();
	////System.out.println("Value got from reportedit are "+date+" "+ledger);
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",ledgerid="",voucherno="";
	try
	{
		sql="select ledgerid from ledgermaster where ledgername='"+ledger+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ledgerid=rs.getString(1);
		}
		usBean.setPart1(ledger);
		sql="select * from accounttransaction where ledgerid='"+ledgerid+"' and entrydate='"+date+"' ";
		////System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean.setId(rs.getInt(1));
			usBean.setContraref(rs.getString(4));
			usBean.setContradate(rs.getString(5));
			usBean.setShowdate(rs.getString(2)); 
			usBean.setTotal(rs.getString(7));
			voucherno=rs.getString(3);
		}
		sql="select * from accountnarration where voucherno='"+voucherno+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean.setDesc1(rs.getString(3));
		}
		sql="select * from accountdetails where voucherno='"+voucherno+"'";
		////System.out.println(sql);
		rs=stm.executeQuery(sql);
		Vector<String> vledger=new Vector<String>();
		Vector<String> vledger1=new Vector<String>();
		Vector<String> vamount=new Vector<String>();
		Vector<String> vnarration=new Vector<String>();
		while(rs.next())
		{
			vledger.add(rs.getString(4));
			vamount.add(rs.getString(5));
			vnarration.add(rs.getString(8));
		}
		////System.out.println("vledger size "+vledger.size());
		String[] nar1=new String[vnarration.size()-1];
		String[] amount1=new String[vamount.size()-1];
		String[] ledger1=new String[vledger.size()-1];
		for(int i=1;i<vnarration.size();i++)
		{
				nar1[i-1]=vnarration.get(i);
				String tot=vamount.get(i);
				amount1[i-1]=tot.replaceAll("-", "");
				
				////System.out.println(vledger.get(i));
				sql="select ledgername from ledgermaster where ledgerid='"+vledger.get(i)+"' ";
				////System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledger1[i-1]=rs.getString(1);
				}
		}
		usBean.setNarration(nar1);
		usBean.setCredit(amount1);
		usBean.setQuantity(ledger1);
	}
	catch(Exception d)
	{ 
		//System.out.println("report edit error on "+d);
	}
	ConnectionDAO.closeConnection(conn);
	return usBean;
}
public static boolean statementeditsave(FormBean FormBean) {
	boolean result=false;		
String s1[]=FormBean.getContra1();
String s2[]=FormBean.getCredithidden();
String s3[]=FormBean.getNarration1();
Connection conn = ConnectionDAO.getConnectionObject();
Statement stm = ConnectionDAO.createStatement(conn);
double oldamount=0.00;
String ledger="",voucher="";
String entry="";
String sql="";
sql="select ledgerid,totalamount,voucherno,entrydate from accounttransaction where id='"+FormBean.getId()+"' ";
try
{
	ResultSet rs=stm.executeQuery(sql);
	while(rs.next())
	{
		ledger=rs.getString(1);
		oldamount=rs.getDouble(2);
		voucher=rs.getString(3);
		entry=rs.getString(4);
	}
	String contradate="";
	if(FormBean.getContradate().equals(""))
	{
		contradate="0000-00-00";
	}
	else
	{
		contradate=FormBean.getContradate();
	}
	sql="update accounttransaction set referenceno='"+FormBean.getContraref()+"', referencedate='"+contradate+"', totalamount='"+FormBean.getTotal()+"' where id='"+FormBean.getId()+"' ";	
	////System.out.println(sql);
	result=ConnectionDAO.executeUpdate(stm, sql);
	
	//resetting
	//ledger
	double ledbal=0.00;
	sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
	rs=stm.executeQuery(sql);
	while(rs.next())
	{
		ledbal=rs.getDouble(1);
	}
	//update ledgermaster
	sql="update ledgermaster set currentbalance='"+(ledbal-oldamount) +"' where ledgerid='"+ledger+"' ";
	result=ConnectionDAO.executeUpdate(stm, sql);
	
	sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
	rs=stm.executeQuery(sql);
	double subgroupbal=0.00;
	while(rs.next())
	{
		subgroupbal=rs.getDouble(1);
	}
	sql="update subgroupmaster set currentbalance='"+(subgroupbal-oldamount)+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
	result=ConnectionDAO.executeUpdate(stm, sql);
	
	sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
	rs=stm.executeQuery(sql);
	double grpbal=0.00;
	while(rs.next())
	{
		grpbal=rs.getDouble(1);
	}
	sql="update groupmaster set closingbalance='"+(grpbal-oldamount)+"' where groupcode='"+ledger.substring(0,2)+"' ";
	////System.out.println(sql);
	result=ConnectionDAO.executeUpdate(stm, sql);
	String abcd="";
	double amou=0.00;
	
	Vector<String> ld=new Vector<String>();
	sql="select ledgerid from accountdetails where voucherno='"+voucher+"' ";
	rs=stm.executeQuery(sql);
	while(rs.next())
	{
		ld.add(rs.getString(1));
	}
	////System.out.println("length "+s2.length);
	for(int i=0;i<ld.size();i++)//particular hidden array
	{
		
		////System.out.println("Vector: "+ld.size());
		//int k=1;
		if(i!=0)
		{
		sql="select amount from accountdetails where ledgerid='"+ld.get(i)+"' ";
		////System.out.println(sql);
		rs=stm.executeQuery(sql);
		Vector<String> am=new Vector<String>();
		while(rs.next()) 
		{
			amou=rs.getDouble(1);//accountdetails
			am.add(rs.getString(1));
		}
		////System.out.println("part amount got "+amou);
		Vector<String> gt=new Vector<String>();
		
		//resetting ledgermaster,subgroupmaster,groupmaster
		//ledgermaster
		sql="select currentbalance from ledgermaster where ledgerid='"+ld.get(i)+"' ";
		////System.out.println(sql);
		double ledgerbal=0.00;
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ledgerbal=rs.getDouble(1);
		}
		sql="update ledgermaster set currentbalance='"+(ledgerbal-amou)+"' where ledgerid='"+ld.get(i)+"' ";
		////System.out.println(sql);
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		//subgroupmaster
		sql="select currentbalance from subgroupmaster where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
		////System.out.println(sql);
		rs=stm.executeQuery(sql);
		double subbal=0.00;
		while(rs.next())
		{
			subbal=rs.getDouble(1);
		}
		sql="update subgroupmaster set currentbalance='"+(subbal-amou)+"' where subgroupcode='"+ld.get(i).substring(0,5)+"' ";
		////System.out.println(sql);
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		//groupmaster
		sql="select closingbalance from groupmaster where groupcode='"+ld.get(i).substring(0,2)+"' ";
		////System.out.println(sql);
		rs=stm.executeQuery(sql);
		double gpbal=0.00;
		while(rs.next())
		{
			gpbal=rs.getDouble(1);
		}
		sql="update groupmaster set closingbalance='"+(gpbal-amou )+"' where groupcode='"+ld.get(i).substring(0,2)+"'";
		////System.out.println(sql);
		result=ConnectionDAO.executeUpdate(stm, sql);
		//resetting ends
		}
	}
	
	sql="delete from accountdetails where voucherno='"+voucher+"'";
	////System.out.println(sql);
	result=ConnectionDAO.executeUpdate(stm, sql);
	
	sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration ) values('"+voucher+"', '"+entry+"', '"+ledger+"', '"+FormBean.getTotal()+"', '"+FormBean.getNarration()+"')";
	////System.out.println(sql);
	result=ConnectionDAO.executeUpdate(stm, sql);
	
	//update to ledger
	sql="select currentbalance from ledgermaster where ledgerid='"+ledger+"' ";
	rs=stm.executeQuery(sql);
	double newled=0.00;
	while(rs.next())
	{
		newled=rs.getDouble(1);
	}
	////System.out.println("new led bal "+newled);
	sql="update ledgermaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where ledgerid='"+ledger+"' ";
	result=ConnectionDAO.executeUpdate(stm, sql);
	//update to subgroup
	sql="select currentbalance from subgroupmaster where subgroupcode='"+ledger.substring(0,5)+"' ";
	rs=stm.executeQuery(sql);
	while(rs.next())
	{
		newled=rs.getDouble(1);
	}
	sql="update subgroupmaster set currentbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where subgroupcode='"+ledger.substring(0,5)+"' ";
	//update group
	sql="select closingbalance from groupmaster where groupcode='"+ledger.substring(0,2)+"' ";
	rs=stm.executeQuery(sql);
	while(rs.next())
	{
		newled=rs.getDouble(1);
	}
	sql="update groupmaster set closingbalance='"+(newled+Double.parseDouble(FormBean.getTotal()) )+"' where groupcode='"+ledger.substring(0,2)+"' ";
	
	String led="",sql3="";
	double total=0.00;
	Vector<String> voucherno=new Vector<String>();
	for(int i=0;i<s2.length;i++)
	{
		//String sql4="insert into accountdetailsdummy(amount, narration ) values('"+s2[i]+"', '"+s1[i]+"') ";
		//result=ConnectionDAO.executeUpdate(stm, sql4);
		
		sql="select ledgerid from ledgermaster where ledgername='"+s1[i]+"' ";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			led=rs.getString(1);
		}
		
		sql3="insert into accountdetails(voucherno, entrydate, ledgerid, amount, narration) values('"+voucher+"', '"+FormBean.getShowdate()+"', '"+led+"', '"+"-"+s2[i]+"', '"+s3[i]+"') ";
		////System.out.println(sql3);
		result=ConnectionDAO.executeUpdate(stm, sql3);
		
		sql="select currentbalance from ledgermaster where ledgerid='"+led+"' ";
		rs=stm.executeQuery(sql);
		double bal=0.00;
		while(rs.next())
		{
			bal=rs.getDouble(1);
		}
		total=bal-Double.parseDouble(s2[i]);
		sql="update ledgermaster set currentbalance='"+total+"' where ledgerid='"+led+"' ";
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		sql="select currentbalance from subgroupmaster where subgroupcode='"+led.substring(0,5)+"' ";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			bal=rs.getDouble(1);
		}
		sql="update subgroupmaster set currentbalance='"+(bal-Double.parseDouble(s2[i]))+"' where subgroupcode='"+led.substring(0,5)+"'  ";
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		sql="select closingbalance from groupmaster where groupcode='"+led.substring(0,2)+"' ";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			bal=rs.getDouble(1);
		}
		sql="update groupmaster set closingbalance='"+(bal-Double.parseDouble(s2[i]))+"' where groupcode='"+led.substring(0,2)+"' ";
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		//getting voucherno from outstandingledger
		sql="select voucherno from outstandingledger where ledgerid='"+abcd+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			voucherno.add(rs.getString(1));
		}	
		
		//deleting outstanding ledger
		sql="delete from outstandingledger where ledgerid='"+led+"'";
		////System.out.println(sql);
		result=ConnectionDAO.executeUpdate(stm, sql);
	}
	int count=0;
	Vector<String> first=new Vector<String>();
	Vector<String> second=new Vector<String>();
	Vector<String> third=new Vector<String>();
	Vector<String> fourth=new Vector<String>();
	Vector<String> fifth=new Vector<String>();
	Vector<String> sixth=new Vector<String>();
	for(int j=0;j<s1.length;j++)
	{
		String sql6="select ledgerid from ledgermaster where ledgername = '"+s3[j]+"' ";
		////System.out.println("found "+sql6);
		ResultSet rs2=stm.executeQuery(sql6);
		while(rs2.next())
		{
			abcd=rs2.getString(1);
		}
		sql6="select count(ledgerid) from outstandingledgerdummy where ledgerid='"+abcd+"'";
		////System.out.println(sql6);
		rs2=stm.executeQuery(sql6);
		while(rs2.next())
		{
			count=rs2.getInt(1);
		}
		for(int j1=1;j1<=count;j1++)
		{
			sql6="select * from outstandingledgerdummy where ledgerid='"+abcd+"'";
			rs2=stm.executeQuery(sql6);
			while(rs2.next())
			{
				first.add(rs2.getString(2));
				second.add(rs2.getString(3));
				third.add(rs2.getString(4));
				fourth.add(rs2.getString(5));
				fifth.add(rs2.getString(6));
				sixth.add(rs2.getString(7));
			}
			sql6="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount)values('"+first.get(j1-1)+"', '"+voucherno.get(j1-1)+"', '"+second.get(j1-1)+"', '"+third.get(j1-1)+"', '"+fourth.get(j1-1)+"', '"+fifth.get(j1-1)+"', '"+sixth.get(j1-1)+"')";
			////System.out.println(sql6);
			result=ConnectionDAO.executeUpdate(stm, sql6);
		}
	}
	
}
catch(Exception f)
{
	//System.out.println("receipt update error= "+f);
}
ConnectionDAO.closeConnection(conn);
return result;
}
//bank book account names
public static List<FormBean> bankpartlist() 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	try
	{
		String sql="select ledgername from ledgermaster where ledgerid like 'BA%' ";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean usBean=new FormBean();
			usBean.setAccname(rs.getString(1));
			l1.add(usBean);
		}
	}
	catch(Exception aa)
	{
		System.out.println("bank part list error on "+aa);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//banklist

public static String findref1(String y)
{
	//System.out.println(y);
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String h="";
	try
	{
		String sql="select referenceno,referencedate from accounttransaction where voucherno='"+y+"'";
		//System.out.println(sql);
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			h=rs.getString(1)+"con"+rs.getString(2);
		}
	}
	catch(Exception df)
	{
		System.out.println("findref1 function error "+df);
	}
	//System.out.println("value "+h);
	ConnectionDAO.closeConnection(conn);
	return h;
}
//trial search
public static List<FormBean> trialsearch(FormBean FormBean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	boolean result=false;
	Map<String,Object> souravsession=ActionContext.getContext().getSession();
	souravsession.put("date", ""+FormBean.getUptodate());
	
	FormBean usBean,usBean1;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		//resetting 
		String sql1="update ledgermaster set debitamount='0', creditamount='0'";
		//result=ConnectionDAO.executeUpdate(stm, sql1);
		
		String sql="select * from ledgermaster";
		ResultSet rs=stm.executeQuery(sql);
		Vector<String> led=new Vector<String>();
		double amount=0.00,totalcredit=0.00,totaldebit=0.00;
		String gr="";
		while(rs.next())
		{
			led.add(rs.getString(2));
		}
		for(int i=0;i<led.size();i++)
		{
			//credit amount set in ledger
			sql="select sum(amount) from accountdetails where ledgerid='"+led.get(i)+"' and amount < 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totalcredit=rs.getDouble(1);
			}
			sql="update ledgermaster set creditamount='"+Math.abs(totalcredit)+"' where ledgerid='"+led.get(i)+"'";
			//System.out.println(sql);
			//result=ConnectionDAO.executeUpdate(stm, sql);
			
			//debit amount set in ledger
			sql="select sum(amount) from accountdetails where ledgerid='"+led.get(i)+"' and amount > 0";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totaldebit=rs.getDouble(1);
			}
			sql="update ledgermaster set debitamount='"+totaldebit+"' where ledgerid='"+led.get(i)+"'";
			//System.out.println(sql);
			//result=ConnectionDAO.executeUpdate(stm, sql);
		}
		
		double totalope=0.00,totald=0.00,totalc=0.00;
		double countd=0.00,countc=0.00;
		Vector<String> ledger=new Vector<String>();
		sql="select distinct ledgerid from accounttransaction where entrydate <= '"+FormBean.getUptodate()+"' ";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean=new FormBean();
			usBean.setLedger(findledger(rs.getString(1)));
			usBean.setGroup(findgroup(rs.getString(1)));
			usBean.setOpebal(findopening(rs.getString(1)));
			String xx=findamount(rs.getString(1),FormBean.getUptodate());
			String arr[]=xx.split("con");
			usBean.setCreditam(arr[0]);
			totalc=totalc+Double.parseDouble(arr[0]);
			usBean.setDebitam(arr[1]);
			totald=totald+Double.parseDouble(arr[1]);
			l1.add(usBean);
		}
		usBean=new FormBean();
		usBean.setOpebal("<b>"+"Total"+"</b>");
		usBean.setCreditam("<b>"+totalc+" Cr</b>");
		usBean.setDebitam("<b>"+totald+" Dr</b>");
		l1.add(usBean);
	}
	catch(Exception d)
	{
		System.out.println("Trial balance list error on "+d);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static String findopening(String xx)
{
	String x3="",x1="";
	try
	{
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		String sql="select openingbalance from ledgermaster where ledgerid='"+xx+"'";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			x1=rs.getString(1);
		}
		//System.out.println("ledger name got "+x3);
		ConnectionDAO.closeConnection(conn);
	}
	catch(Exception hh)
	{
		System.out.println("error in transaction ledger function "+hh);
	}
	
	return x1;
}
public static FormBean getasondate(FormBean FormBean) 
{
	//System.out.println("hello");
	String e=FormBean.getUptodate();
	FormBean usBean = new FormBean();
	try
	{
		//String e=(String) souravsession.get("date");
		usBean.setAsondate("As On: "+e);
		usBean.setUptodate(e); 
	}
	catch (Exception e1) 
	{
		e1.printStackTrace();
	}
	return usBean;
}
public static List<FormBean> maintainlistdetails(FormBean formbean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String s1=formbean.getFrmdate();
	String s2=formbean.getTodate();
	String s3=formbean.getVtyp();
	String s4=formbean.getChoice();
	String s5=formbean.getAcname();
	//System.out.println(s1 + s2 + s3 +s4 +s5);
	String date="",type="",vno="",head="",lid="";
	double amount=0.00;
	
	try
	{	
		if(s3.compareTo("All")==0 && s4.compareTo("All")==0)
		{
			//System.out.println("hello");
	String sql="select accounttransaction.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),ledgermaster.ledgername,accounttransaction.totalamount,accounttransaction.vouchertype from accounttransaction inner join ledgermaster where accounttransaction.entrydate>='"+s1+"' and accounttransaction.entrydate<='"+s2+"' and accounttransaction.ledgerid=ledgermaster.ledgerid ";
	//System.out.println(sql);
	ResultSet rs=stm.executeQuery(sql);
	while(rs.next())
	{
		date=rs.getString(1);
		type=rs.getString(2);
		switch(type)
		{
		case "RC":  type="Cash Receipt";break;
		case "RB":  type="Bank Receipt";break;
		case "CO":  type="Contra";break;
		case "JV":  type="Journal";break;
		case "PB":  type="Bank Payment";break;
		case "PC":  type="Cash Payment";break;
		case "DN":  type="Debit Note";break;
		case "CN":  type="Credit Note";break;
		case "UC":  type="Cash Purchase";break;
		case "SC":  type="Cash Sales";break;
		case "UD":  type="Credit Purchase";break;
		case "SD":  type="Credit Sales";break;
		}
		vno=rs.getString(3);
		head=rs.getString(4);
		//amount=rs.getDouble(5);
		FormBean usBean=new FormBean();
		usBean.setDate(date);
		usBean.setType(type);
		usBean.setVno(vno);
		usBean.setAchead(head);
		if(rs.getString(6).equals("cr"))
		{
			usBean.setAmount(Double.toString(rs.getDouble(5))+" Cr");
		}
		else if(rs.getString(6).equals("dr"))
		{
			usBean.setAmount(Double.toString(rs.getDouble(5))+" Dr");
		}
		
		l1.add(usBean);
	}
		}	
		else if(s3.compareTo("All")!=0 && s4.compareTo("All")==0)
		{
			String sql="select accounttransaction.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),ledgermaster.ledgername,accounttransaction.totalamount,accounttransaction.vouchertype from accounttransaction inner join ledgermaster where accounttransaction.entrydate>='"+s1+"' and accounttransaction.entrydate<='"+s2+"' and left(accounttransaction.voucherno,2)='"+s3+"' and accounttransaction.ledgerid=ledgermaster.ledgerid ";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				date=rs.getString(1);
				type=rs.getString(2);
				switch(type)
				{
				case "RC":  type="Cash Receipt";break;
				case "RB":  type="Bank Receipt";break;
				case "CO":  type="Contra";break;
				case "JV":  type="Journal";break;
				case "PB":  type="Bank Payment";break;
				case "PC":  type="Cash Payment";break;
				case "DN":  type="Debit Note";break;
				case "CN":  type="Credit Note";break;
				case "UC":  type="Cash Purchase";break;
				case "SC":  type="Cash Sales";break;
				case "UD":  type="Credit Purchase";break;
				case "SD":  type="Credit Sales";break;
				}
				vno=rs.getString(3);
				head=rs.getString(4);
				//amount=rs.getDouble(5);
				FormBean usBean=new FormBean();
				usBean.setDate(date);
				usBean.setType(type);
				usBean.setVno(vno);
				usBean.setAchead(head);
				if(rs.getString(6).equals("cr"))
				{
					usBean.setAmount(Double.toString(rs.getDouble(5))+" Cr");
				}
				else if(rs.getString(6).equals("dr"))
				{
					usBean.setAmount(Double.toString(rs.getDouble(5))+" Dr");
				}
				l1.add(usBean);
			}
		}
			else if(s3.compareTo("All")==0 && s4.compareTo("All")!=0 && s5.compareTo("")!=0)
			{
				
			String sql="select ledgerid from ledgermaster where ledgername='"+s5+"' ";
			//System.out.println(sql);
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				lid=rs.getString(1);
			}
			
			
		
				sql="select accounttransaction.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),accountdetails.amount from accounttransaction inner join accountdetails where accounttransaction.entrydate>='"+s1+"' and accounttransaction.entrydate<='"+s2+"' and accountdetails.ledgerid='"+lid+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					date=rs.getString(1);
					type=rs.getString(2);
					switch(type)
					{
					case "RC":  type="Cash Receipt";break;
					case "RB":  type="Bank Receipt";break;
					case "CO":  type="Contra";break;
					case "JV":  type="Journal";break;
					case "PB":  type="Bank Payment";break;
					case "PC":  type="Cash Payment";break;
					case "DN":  type="Debit Note";break;
					case "CN":  type="Credit Note";break;
					case "UC":  type="Cash Purchase";break;
					case "SC":  type="Cash Sales";break;
					case "UD":  type="Credit Purchase";break;
					case "SD":  type="Credit Sales";break;
					}
					vno=rs.getString(3);
					amount=rs.getDouble(4);
					
					FormBean usBean=new FormBean();
					usBean.setDate(date);
					usBean.setType(type);
					usBean.setVno(vno);
					usBean.setAchead(s5);
					if(amount<0)
					{
						usBean.setAmount(Double.toString(Math.abs(amount))+" Cr");
					}
					else if(amount>0)
					{
						usBean.setAmount(Double.toString(Math.abs(amount))+" Dr");
					}else
					{
						usBean.setAmount("");
					}
					l1.add(usBean);
				}
	
			}
		
			else if(s3.compareTo("All")!=0 && s4.compareTo("All")!=0 && s5.compareTo("")!=0)
			{
				
			String sql="select ledgerid from ledgermaster where ledgername='"+s5+"' ";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				lid=rs.getString(1);
			}
			
			sql="select amount from accountdetails where ledgerid='"+lid+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				amount=rs.getDouble(1);
			}
		
			sql="select accounttransaction.entrydate,left(accounttransaction.voucherno,2),right(accounttransaction.voucherno,5),accountdetails.amount from accounttransaction inner join accountdetails where accounttransaction.entrydate>='"+s1+"' and accounttransaction.entrydate<='"+s2+"' and accountdetails.ledgerid='"+lid+"' and left(accounttransaction.voucherno,2)='"+s3+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					date=rs.getString(1);
					type=rs.getString(2);
					switch(type)
					{
					case "RC":  type="Cash Receipt";break;
					case "RB":  type="Bank Receipt";break;
					case "CO":  type="Contra";break;
					case "JV":  type="Journal";break;
					case "PB":  type="Bank Payment";break;
					case "PC":  type="Cash Payment";break;
					case "DN":  type="Debit Note";break;
					case "CN":  type="Credit Note";break;
					case "UC":  type="Cash Purchase";break;
					case "SC":  type="Cash Sales";break;
					case "UD":  type="Credit Purchase";break;
					case "SD":  type="Credit Sales";break;
					}
					vno=rs.getString(3);
					amount=rs.getDouble(4);
					
					FormBean usBean=new FormBean();
					usBean.setDate(date);
					usBean.setType(type);
					usBean.setVno(vno);
					usBean.setAchead(s5);
					if(amount<0)
					{
						usBean.setAmount(Double.toString(Math.abs(amount))+" Cr");
					}
					else if(amount>0)
					{
						usBean.setAmount(Double.toString(Math.abs(amount))+" Dr");
					}else
					{
						usBean.setAmount("");
					}
					l1.add(usBean);
				}
	
			}
		
		
	ConnectionDAO.closeConnection(conn);
	
	}catch (Exception e) 
	{
	e.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;

}
//bank reconciliation  action
public static List<FormBean> bankreconciliationsearch(FormBean FormBean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String sql="";
	ResultSet rs;
	String ledgerid="";
	try
	{
		sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getAccname()+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ledgerid=rs.getString(1);
		}
		//System.out.println("Value got "+FormBean.getFrmdate()+","+FormBean.getTodate()+","+FormBean.getAccname()+","+FormBean.getCase1()+","+FormBean.getType());
		if(FormBean.getCase1().equals("openingcase"))
		{
			sql="select * from accounttransaction where entrydate <= '"+FormBean.getFrmdate()+"' and vouchertype='"+FormBean.getType()+"' and ledgerid='"+ledgerid+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean usBean=new FormBean();
				usBean.setEntry(rs.getString(2));//set entry date				
				String vtype=findvtype(rs.getString(3).substring(0,2));
				usBean.setVtyp(vtype);//set voucher type
				usBean.setVoucher(rs.getString(3));
				//System.out.println(rs.getString(3));
				usBean.setVno(rs.getString(3).substring(10, rs.getString(3).length() ));//set voucher no last 5 digit				
				usBean.setChedd("NIL");//set cheqq as of now it will be blank				
				usBean.setChedddate("NIL");//set chedddate as of now it will be blank				
				usBean.setAmount("Rs. "+rs.getString(7)+" "+FormBean.getType());
				usBean.setClearedon(rs.getString(9));//set clearedon as off now it will be blank
				l1.add(usBean);
			}
		}
		else if(FormBean.getCase1().equals("withopeningcase"))
		{
			sql="select * from accounttransaction where entrydate <= '"+FormBean.getTodate()+"' and vouchertype='"+FormBean.getType()+"' and ledgerid='"+ledgerid+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean usBean=new FormBean();
				usBean.setEntry(rs.getString(2));//set entry date				
				String vtype=findvtype(rs.getString(3).substring(0,2));
				usBean.setVtyp(vtype);//set voucher type
				usBean.setVoucher(rs.getString(3));
				//System.out.println(rs.getString(3));
				usBean.setVno(rs.getString(3).substring(10, rs.getString(3).length() ));//set voucher no last 5 digit				
				usBean.setChedd("NIL");//set cheqq as of now it will be blank				
				usBean.setChedddate("NIL");//set chedddate as of now it will be blank				
				usBean.setAmount("Rs. "+rs.getString(7)+" "+FormBean.getType());				
				usBean.setClearedon(rs.getString(9));//set clearedon as off now it will be blank
				l1.add(usBean);
			}
		}
		else if(FormBean.getCase1().equals("withoutopeningcase"))
		{
			sql="select * from accounttransaction where entrydate between '"+FormBean.getFrmdate()+"' and '"+FormBean.getTodate()+"' and vouchertype='"+FormBean.getType()+"' and ledgerid='"+ledgerid+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean usBean=new FormBean();
				usBean.setEntry(rs.getString(2));//set entry date				
				String vtype=findvtype(rs.getString(3).substring(0,2));
				usBean.setVtyp(vtype);//set voucher type				
				usBean.setVno(rs.getString(3).substring(10, rs.getString(3).length() ));//set voucher no last 5 digit				
				usBean.setChedd("NIL");//set cheqq as of now it will be blank				
				usBean.setChedddate("NIL");//set chedddate as of now it will be blank				
				usBean.setAmount("Rs. "+rs.getString(7)+" "+FormBean.getType());
				usBean.setClearedon(rs.getString(9));//set clearedon as off now it will be blank
				l1.add(usBean);
			}
		}
	}
	catch(Exception h)
	{
		System.out.println("banklist reconciliation search error on "+h);
		//h.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//find vouchertype
public static String findvtype(String xx)
{
	String x3="",x1="";
	try
	{
		xx=xx.substring(0,2);
		if(xx.equals("RC"))
		{
			x3="Cash Receipt";
		}
		else if(xx.equals("RB"))
		{
			x3="Bank Receipt";
		}
		else if(xx.equals("PC"))
		{
			x3="Cash Payment";
		}
		else if(xx.equals("PB"))
		{
			x3="Bank Payment";
		}
		else if(xx.equals("CO"))
		{
			x3="Contra";
		}
		else if(xx.equals("JV"))
		{
			x3="Journal";
		}
		else if(xx.equals("DN"))
		{
			x3="Debit Note";
		}
		else if(xx.equals("CN"))
		{
			x3="Credit Note";
		}
		else if(xx.equals("UD"))
		{
			x3="Credit Purchase";
		}
		else if(xx.equals("SD"))
		{
			x3="Credit Sales";
		}
		else if(xx.equals("SC"))
		{
			x3="Cash Sales";
		}
		else if(xx.equals("UC"))
		{
			x3="Cash Purchase";
		}
		//System.out.println("voucher "+x3); 
	}
	catch(Exception hh)
	{
		System.out.println("error in transaction ledger function "+hh);
	}
	return x3;
}
public static List<FormBean> grouptriallist() 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	boolean result=false;
	FormBean usBean,usBean1;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		//resetting 
		String sql1="update groupmaster set debitamount='0', creditamount='0'";
		result=ConnectionDAO.executeUpdate(stm, sql1);
		
		String sql="select groupcode from groupmaster";
		ResultSet rs=stm.executeQuery(sql);
		Vector<String> code=new Vector<String>();
		double amount=0.00,totalcredit=0.00,totaldebit=0.00;
		String gr="";
		while(rs.next())
		{
			code.add(rs.getString(1));
		}
		for(int i=0;i<code.size();i++)
		{
			//credit amount set in ledger
			sql="select sum(amount) from accountdetails where left(ledgerid,2)='"+code.get(i)+"' and amount < 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totalcredit=rs.getDouble(1);
			}
			sql="update groupmaster set creditamount='"+Math.abs(totalcredit)+"' where groupcode='"+code.get(i)+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//debit amount set in ledger
			sql="select sum(amount) from accountdetails where left(ledgerid,2)='"+code.get(i)+"' and amount > 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totaldebit=rs.getDouble(1);
			}
			sql="update groupmaster set debitamount='"+totaldebit+"' where groupcode='"+code.get(i)+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		sql="select groupname,incomeexpencetype,groupcategory,debitamount,creditamount from groupmaster where openingbalance <> '0' or debitamount <> '0' or creditamount <> '0'";
		rs=stm.executeQuery(sql);
		//System.out.println(sql);
		double totalope=0.00,totald=0.00,totalc=0.00;
		
		while(rs.next())
		{
			usBean=new FormBean();
			//gr=findgroup(rs.getString(2));
			//usBean.setAsondate("");
			usBean.setGroupname(rs.getString(1));
			//usBean.setGroup(gr);
			String in=rs.getString(2);
			switch(in)
			{
			case "B":in="Balance Sheet";			break;
			case "P":in="Profit & Loss";			break;
			case "M":in="Manufacturing Account";	break;
			case "T":in="Trading Account";			break;
			}
			usBean.setIncome(in);
			//totalope=totalope+Double.parseDouble(rs.getString(17));
			//usBean.setOpebal(Double.toString(totalope));//last total row
			String cat=rs.getString(3);
			switch(cat)
			{
			case "A":cat="Asset";			break;
			case "I":cat="Income";			break;
			case "L":cat="Liability";		break;
			case "E":cat="Expenditure";		break;
			}
			usBean.setGroupcat(cat);
			double debit=rs.getDouble(4);
			usBean.setDebitam(Double.toString(debit));
			//totald=totald+Double.parseDouble(rs.getString(27));
			//usBean.setDebitam(Double.toString(totald));//last total row
			totald=totald+debit;
			
			double credit=rs.getDouble(5);
			usBean.setCreditam(Double.toString(credit));
			//totalc=totalc+Double.parseDouble(rs.getString(28));
			//usBean.setDebitam(Double.toString(totalc));//last total row
			totalc=totalc+credit;
			l1.add(usBean);
		}
		usBean=new FormBean();
		
		usBean.setIncome("<b>"+"Total: "+"</b>");
		usBean.setDebitam("<b>"+""+totald+" Dr"+"</b>");
		
		usBean.setCreditam("<b>"+""+totalc+" Cr"+"</b>");

		l1.add(usBean);
	}
	catch(Exception d)
	{
		System.out.println("Trial balance list error on "+d);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static List<FormBean> grouptrialsearch(FormBean formbean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	boolean result=false;
	String s1=formbean.getUptodate();

	FormBean usBean,usBean1;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		//resetting 
		String sql1="update groupmaster set debitamount='0', creditamount='0'";
		result=ConnectionDAO.executeUpdate(stm, sql1);
		
		String sql="select groupcode from groupmaster";
		ResultSet rs=stm.executeQuery(sql);
		Vector<String> code=new Vector<String>();
		double amount=0.00,totalcredit=0.00,totaldebit=0.00;
		String gr="";
		while(rs.next())
		{
			code.add(rs.getString(1));
		}
		for(int i=0;i<code.size();i++)
		{
			//credit amount set in ledger
			sql="select sum(amount) from accountdetails where left(ledgerid,2)='"+code.get(i)+"' and amount < 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totalcredit=rs.getDouble(1);
			}
			sql="update groupmaster set creditamount='"+Math.abs(totalcredit)+"' where groupcode='"+code.get(i)+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//debit amount set in ledger
			sql="select sum(amount) from accountdetails where left(ledgerid,2)='"+code.get(i)+"' and amount > 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totaldebit=rs.getDouble(1);
			}
			sql="update groupmaster set debitamount='"+totaldebit+"' where groupcode='"+code.get(i)+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		double totalope=0.00,totald=0.00,totalc=0.00;
		sql="select distinct ledgerid from accounttransaction where entrydate <= '"+s1+"'";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean=new FormBean();
			String x=findgroup1(rs.getString(1));
			String ar[]=x.split(",");
			usBean.setGroupname(ar[0]);
			
			if(ar[2].equals("A"))
			{
				usBean.setGroupcat("Asset");
			}
			else if(ar[2].equals("I"))
			{
				usBean.setGroupcat("Income");
			}
			else if(ar[2].equals("L"))
			{
				usBean.setGroupcat("Liability");
			}
			else if(ar[2].equals("E"))
			{
				usBean.setGroupcat("Expenditure");
			}
			
			if(ar[1].equals("B"))
			{
				usBean.setIncome("Balance Sheet");
			}
			else if(ar[1].equals("P"))
			{
				usBean.setIncome("Profit & Loss");
			}
			else if(ar[1].equals("M"))
			{
				usBean.setIncome("Manufacturing Account");
			}
			else if(ar[1].equals("T"))
			{
				usBean.setIncome("Trading Account");
			}
			String crdr=findamount(rs.getString(1),s1);
			String ar1[]=crdr.split("con");
			totald=totald+Double.parseDouble(ar1[1]);
			totalc=totalc+Double.parseDouble(ar1[0]);
			if(!ar1[1].equals("0"))
			{
				usBean.setDebitam(ar1[1]);
			}
			else
			{
				usBean.setDebitam("");
			}
			if(!ar1[0].equals("0"))
			{
				usBean.setCreditam(ar1[0]);
			}
			else
			{
				usBean.setCreditam("");
			}
			l1.add(usBean);
		}
		usBean=new FormBean();
		usBean.setIncome("<b> Total</b>");
		usBean.setDebitam("<b>"+Double.toString(totald)+"</b>");
		usBean.setCreditam("<b>"+Double.toString(totalc)+"</b>");
		l1.add(usBean);
		//System.out.println("check wheather date received or not "+FormBean.getUptodate()+" in helper");
	}
	catch(Exception d)
	{
		System.out.println("Group Trial balance list error on "+d);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static String findamount(String x,String y)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",a="";
	double debit=0.00,credit=0.00;
	try
	{
		sql="select sum(if(vouchertype='cr',totalamount,0)),sum(if(vouchertype='dr',totalamount,0)) from accounttransaction where ledgerid='"+x+"' and entrydate <='"+y+"'";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			a=Double.toString(rs.getDouble(1))+"con"+Double.toString(rs.getDouble(2));
		}
	}
	catch(Exception gh)
	{
		System.out.println("find amount error on "+gh);
	}
	ConnectionDAO.closeConnection(conn);
	return a;
}
public static String findamount1(String x,String y)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",a="";
	double debit=0.00,credit=0.00;
	try
	{
		sql="select sum(if(vouchertype='cr',totalamount,0)),sum(if(vouchertype='dr',totalamount,0)) from accounttransaction where ledgerid='"+x+"' and entrydate <='"+y+"'";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			a=Double.toString(rs.getDouble(1))+"con"+Double.toString(rs.getDouble(2));
		}
	}
	catch(Exception gh)
	{
		System.out.println("find amount error on "+gh);
	}
	ConnectionDAO.closeConnection(conn);
	return a;
}
public static String findgroup1(String x2)
{
	String x3="",x1="";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{	
	
	x2=x2.substring(0, 2);
	ResultSet rs2 = stm.executeQuery("select * from groupmaster where groupcode like'"+x2+"%'");
	//System.out.println("select * from groupmaster where groupcode like'"+x2+"%' ");
	String j="";	
		while(rs2.next())
		{
			//System.out.println(rs2.getString(3)+"\r");
			String x=rs2.getString(3);//groupname
			String in=rs2.getString(7);//incomeexpence
			String group=rs2.getString(8);//groupcatagory
			x3=x+","+in+","+group;
		}			
	}
	catch(Exception f)
	{
		System.out.println(f);
	}
	ConnectionDAO.closeConnection(conn);
	return x3;
}
//subgroup triallist
public static List<FormBean> subgrouptriallist() {
	List<FormBean> l1 = new ArrayList<FormBean>();
	boolean result=false;
	FormBean usBean,usBean1;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		//resetting 
		
		// modified by Nilesh, 17th April
		
		String sql1="update subgroupmaster set debitamount='0', creditamount='0'";
		//result=ConnectionDAO.executeUpdate(stm, sql1);
		
		String sql="select subgroupcode from subgroupmaster";
		ResultSet rs=stm.executeQuery(sql);
		Vector<String> led=new Vector<String>();
		double amount=0.00,totalcredit=0.00,totaldebit=0.00;
		String gr="";
		while(rs.next())
		{
			led.add(rs.getString(1));
		}
		for(int i=0;i<led.size();i++)
		{
			//credit amount set in ledger
			sql="select sum(amount) from accountdetails where ledgerid like '"+led.get(i)+"%' and amount < 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totalcredit=rs.getDouble(1);
			}
			sql="update subgroupmaster set creditamount='"+Math.abs(totalcredit)+"' where subgroupcode like '"+led.get(i)+"%'";
			////System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//debit amount set in ledger
			sql="select sum(amount) from accountdetails where ledgerid like '"+led.get(i)+"%' and amount > 0";
			////System.out.println();
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totaldebit=rs.getDouble(1);
			}
			sql="update subgroupmaster set debitamount='"+totaldebit+"' where subgroupcode like '"+led.get(i)+"'";
			////System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		
		////System.out.println(sql);
		double totalope=0.00,totald=0.00,totalc=0.00;
		sql="select subgroupname,subgroupcode,openingbalance,debitamount,creditamount from subgroupmaster where openingbalance <> '0' or debitamount <> '0' or creditamount <> '0'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean=new FormBean();
			
			// method will be modified, 17th April
			//gr=findgroup(rs.getString(2));
			
			gr = findsubgroup(rs.getString(2));
			////System.out.println("hello "+gr);
			
			//usBean.setAsondate("");
			usBean.setLedger(rs.getString(1));
			
			// setSubGroup will be created, 17th April
			usBean.setSubgroups(gr);
			
			usBean.setOpebal(Double.toString(rs.getDouble(3)));
			double o = rs.getDouble(3);
			if(Double.toString(o).equals(""))
			{
				o=0.0;
			}
			
			totalope=totalope+o;
			//usBean.setOpebal(Double.toString(totalope));//last total row
			
			usBean.setDebitam(Double.toString(rs.getDouble(4)));
			double p=rs.getDouble(4);
			if(Double.toString(p).equals(""))
			{
				p=0.0;
			}
			
			totald=totald+p;
			//usBean.setDebitam(Double.toString(totald));//last total row
			
			usBean.setCreditam(Double.toString(rs.getDouble(5)));
			double q=rs.getDouble(5);
			if(Double.toString(q).equals(""))
			{
				q=0.0;
			}
			totalc=totalc+q;
			//usBean.setCreditam(Double.toString(totalc));
		
			
			l1.add(usBean);
			
		}
		
		usBean=new FormBean();
		
		usBean.setSubgroups("<b>"+"Total Balance: "+"</b>");
		String x="";
		if(totalope < 0)
		{
			x=" Cr";
		}
		else if(totalope > 0)
		{
			x=" Dr";
		}
		
		
		usBean.setOpebal("<b>"+Double.toString(totalope)+x+"</b>");
		
		usBean.setDebitam("<b>"+Double.toString(totald)+" Dr</b>");
		
		usBean.setCreditam("<b>"+Double.toString(totalc)+" Cr</b>");
		
		////System.out.println(""+setAsondate(d));
		//usBean.setAsondate(d);
		
		l1.add(usBean);
	}
	catch(Exception d)
	{
		d.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static List<FormBean> subgrouptrialsearch(FormBean formbean) {
	List<FormBean> l1 = new ArrayList<FormBean>();
	boolean result=false;
	Map<String,Object> souravsession=ActionContext.getContext().getSession();
	souravsession.put("date", formbean.getUptodate());

	FormBean usBean,usBean1;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		//resetting 
		String sql1="update subgroupmaster set debitamount='0', creditamount='0'";
		result=ConnectionDAO.executeUpdate(stm, sql1);
		String s1=formbean.getUptodate();
		String sql="select * from subgroupmaster";
		ResultSet rs=stm.executeQuery(sql);
		Vector<String> led=new Vector<String>();
		double amount=0.00,totalcredit=0.00,totaldebit=0.00;
		String gr="";
		while(rs.next())
		{
			led.add(rs.getString(2));
		}
		for(int i=0;i<led.size();i++)
		{
			//credit amount set in ledger
			sql="select sum(amount) from accountdetails where ledgerid like '"+led.get(i)+"%' and amount < 0";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totalcredit=rs.getDouble(1);
			}
			sql="update subgroupmaster set creditamount='"+Math.abs(totalcredit)+"' where Left(subgroupcode,5)='"+led.get(i)+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			//debit amount set in ledger
			sql="select sum(amount) from accountdetails where ledgerid like '"+led.get(i)+"%' and amount > 0";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				totaldebit=rs.getDouble(1);
			}
			sql="update subgroupmaster set debitamount='"+totaldebit+"' where Left(subgroupcode,5)='"+led.get(i)+"'";
			////System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		
		double totalope=0.00,totald=0.00,totalc=0.00;
		
		// modified by Nilesh 17th April
		sql="select distinct ledgerid from accounttransaction where entrydate <= '"+s1+"'";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean=new FormBean();
			String x=findsubgroup(rs.getString(1));
			usBean.setLedger(x);
			usBean.setSubgroups(findgroup(rs.getString(1)));
			usBean.setOpebal(findsubgroupopening(rs.getString(1)));
			
			String op=findsubgroupopening(rs.getString(1));
			totalope=totalope+Double.parseDouble(op);
			
			String crdr=findamount(rs.getString(1),s1);
			String ar1[]=crdr.split("con");
			totald=totald+Double.parseDouble(ar1[1]);
			totalc=totalc+Double.parseDouble(ar1[0]);
			usBean.setDebitam(ar1[1]);
			usBean.setCreditam(ar1[0]);
			
			l1.add(usBean);
		}
		usBean=new FormBean();
		usBean.setSubgroups("<b> Total</b>");
		usBean.setOpebal("<b>"+Double.toString(totalope)+"</b>");
		usBean.setDebitam("<b>"+Double.toString(totald)+"</b>");
		usBean.setCreditam("<b>"+Double.toString(totalc)+"</b>");
		l1.add(usBean);
	}
	catch(Exception d)
	{
		System.out.println("subgroup Trial balance list error on "+d);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static String findsubgroup(String x2)
{
	String x3="",x1="";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		
	x2=x2.substring(0,5);
	//System.out.println("value "+x2);
	String sql="select * from subgroupmaster where subgroupcode='"+x2+"' ";
	//System.out.println(sql);
	ResultSet rs2 = stm.executeQuery(sql);

		while(rs2.next())
		{
			x3=rs2.getString(3);	
		}			
	}
	catch(Exception f)
	{
		f.printStackTrace();
	}
	//System.out.println("value found "+x3);
	ConnectionDAO.closeConnection(conn);
	return x3;
}
private static String findsubgroupopening(String xx) {
	
	String x3="",x1="";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	try
	{
		String x=xx.substring(0,5);
		String sql="select openingbalance from subgroupmaster where subgroupcode='"+x+"'";
		////System.out.println(sql);
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			x1=rs.getString(1);
		}
		////System.out.println("ledger name got "+x1);
	}
	catch(Exception hh)
	{
		System.out.println("subgroup opening error "+hh);
	}
	ConnectionDAO.closeConnection(conn);
	return x1;
}
public static List<FormBean> billoutstandinglistdetails(FormBean formbean) 
{
        List<FormBean> l1 = new ArrayList<FormBean>();
        
        String s3=formbean.getAcname();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String lid="",byb="",refno="",date1="";
        Vector<String> vno=new Vector<String>();
        int age;
        double billamt=0.00,adamt=0.00,amtbal=0.00;
        //System.out.println(dateFormat.format(date));
        Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
        FormBean usBean;
        
        try{
                String sql="select billbybill,ledgerid from ledgermaster where ledgername='"+s3+"' ";
                //System.out.println(sql);
                ResultSet rs=stm.executeQuery(sql);
                while(rs.next())
                {
                        byb=rs.getString(1);
                        lid=rs.getString(2);
                }
                sql="select voucherno from accountdetails where ledgerid='"+lid+"' ";
                //System.out.println(sql);
                rs=stm.executeQuery(sql);
                while(rs.next())
                {
                        vno.add(rs.getString(1));
                }
                
                if(byb.compareTo("Y")==0)
                {
                        for(int i=0;i<vno.size();i++)
                                
                        {
                                
                                usBean=new FormBean();
                                                sql="select entrydate,referenceno from accounttransaction where voucherno='"+vno.get(i)+"'  ";
                                                //System.out.println(sql);
                                                rs=stm.executeQuery(sql);
                                                while(rs.next())
                                                {
                                                        date1=rs.getString(1);
                                                        refno=rs.getString(2);
                                                                
                                                        usBean.setDate1(date1);
                                                        usBean.setParticulars(refno);
                                                                        
                                                }
                                                sql="select billamount,adjustmentamount,(billamount-adjustmentamount),datediff(curdate(),accounttransaction.entrydate) from outstandingledger inner join accounttransaction where outstandingledger.voucherno='"+vno.get(i)+"' ";
                                                rs=stm.executeQuery(sql);
                                                //System.out.println(sql);
                                                while(rs.next())
                                                {
                                                        billamt=rs.getDouble(1);
                                                        adamt=rs.getDouble(2);
                                                        amtbal=rs.getDouble(3);
                                                        age=rs.getInt(4);
                                                        
                                                        usBean.setGrossamt(Double.toString(billamt));
                                                        usBean.setAmtadjusted(Double.toString(adamt));
                                                        usBean.setAmtbalance(Double.toString(amtbal));
                                                        usBean.setAge(Integer.toString(age));
                                                }
                                                l1.add(usBean);
                        }
                }
                ConnectionDAO.closeConnection(conn);
        }catch(Exception e)
        {
                e.printStackTrace();
        }
return l1;
}
public static List<FormBean> bankreconsearch(FormBean FormBean) 
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	String sql="";
	ResultSet rs;
	String ledgerid="";
	try
	{
		sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getAccname()+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			ledgerid=rs.getString(1);
		}
		//System.out.println("Value got "+FormBean.getFrmdate()+","+FormBean.getTodate()+","+FormBean.getAccname()+","+FormBean.getCase1()+","+FormBean.getType());
		if(FormBean.getCase1().equals("openingcheque"))
		{
			sql="select * from accounttransaction where entrydate <= '"+FormBean.getFrmdate()+"' and vouchertype='"+FormBean.getType()+"' and ledgerid='"+ledgerid+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean usBean=new FormBean();
				usBean.setEntry(rs.getString(2));//set entry date				
				String vtype=findvtype(rs.getString(3).substring(0,2));
				usBean.setVtype1(vtype);//set voucher type
				usBean.setVoucher(rs.getString(3));
				//System.out.println(rs.getString(3));
				usBean.setVno(rs.getString(3).substring(10, rs.getString(3).length() ));//set voucher no last 5 digit				
				usBean.setChedd("NIL");//set cheqq as of now it will be blank				
				usBean.setChedddate("NIL");//set chedddate as of now it will be blank				
				usBean.setAmount("Rs. "+rs.getString(7)+" "+FormBean.getType());
				usBean.setClearedon(rs.getString(9));//set clearedon as off now it will be blank
				l1.add(usBean);
			}
		}
		else if(FormBean.getCase1().equals("withopeningcheque"))
		{
			sql="select * from accounttransaction where entrydate <= '"+FormBean.getTodate()+"' and vouchertype='"+FormBean.getType()+"' and ledgerid='"+ledgerid+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean usBean=new FormBean();
				usBean.setEntry(rs.getString(2));//set entry date				
				String vtype=findvtype(rs.getString(3).substring(0,2));
				usBean.setVtype1(vtype);//set voucher type
				usBean.setVoucher(rs.getString(3));
				//System.out.println(rs.getString(3));
				usBean.setVno(rs.getString(3).substring(10, rs.getString(3).length() ));//set voucher no last 5 digit				
				usBean.setChedd("NIL");//set cheqq as of now it will be blank				
				usBean.setChedddate("NIL");//set chedddate as of now it will be blank				
				usBean.setAmount("Rs. "+rs.getString(7)+" "+FormBean.getType());				
				usBean.setClearedon(rs.getString(9));//set clearedon as off now it will be blank
				l1.add(usBean);
			}
		}
		else if(FormBean.getCase1().equals("withoutopeningcheque"))
		{
			sql="select * from accounttransaction where entrydate between '"+FormBean.getFrmdate()+"' and '"+FormBean.getTodate()+"' and vouchertype='"+FormBean.getType()+"' and ledgerid='"+ledgerid+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean usBean=new FormBean();
				usBean.setEntry(rs.getString(2));//set entry date				
				String vtype=findvtype(rs.getString(3).substring(0,2));
				//System.out.println(vtype);
				usBean.setVtype1(vtype);//set voucher type				
				usBean.setVno(rs.getString(3).substring(10, rs.getString(3).length() ));//set voucher no last 5 digit				
				usBean.setChedd("NIL");//set cheqq as of now it will be blank				
				usBean.setChedddate("NIL");//set chedddate as of now it will be blank				
				usBean.setAmount("Rs. "+rs.getString(7)+" "+FormBean.getType());
				usBean.setClearedon(rs.getString(9));//set clearedon as off now it will be blank
				l1.add(usBean);
			}
		}
	}
	catch(Exception h)
	{
		System.out.println("bank reconciliation report search search error on "+h);
		//h.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static List<FormBean> daybooklistdetails(FormBean formbean) 
{
		Map<String, Object> da = ActionContext.getContext().getSession();
			List<FormBean> l1 = new ArrayList<FormBean>();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);	
			
			String s1=formbean.getDate();
			da.put("date12", ""+s1);
			String ss=(String)da.get("date12");
			//System.out.println(ss);
			String s3=formbean.getLongn();
			String s4=formbean.getShortn();
			
			FormBean usBean;
			String lid="",date="",vno="",ledname="",vtyp="",v="",longn="",shortn="";	
			double debit=0.00,credit=0.00,totaldebit=0.00,totalcredit=0.00,x4=0.00,x5=0.00;	
	try
	{	
						
				
				
		
		if(s1.compareTo("")!=0 && s3.compareTo("With_Narration")==0 && s4.compareTo("Without_Narration")==0)
		{
			
					Vector<String> voucher=new Vector<String>();
											
					Vector<String> id=new Vector<String>();
					String sql="select voucherno,ledgerid from accountdetails  where entrydate='"+s1+"' ";
					//System.out.println(sql);
					
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
						{
						voucher.add(rs.getString(1));								
						id.add(rs.getString(2));
						}
					String d="",vn="";
							
					for(int i=0;i<voucher.size();i++)
						{

								sql="select ledgername from ledgermaster where ledgerid='"+id.get(i)+"' ";
								
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ledname=rs.getString(1);
									usBean=new FormBean();
									usBean.setParticulars(ledname+"<br>");
								}
								//System.out.println("abcd");
								sql="select narration from accountnarration where voucherno='"+voucher.get(i)+"' ";
								//System.out.println(sql);
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									longn=rs.getString(1);
									usBean=new FormBean();
									usBean.setParticulars(longn);
									//System.out.println(longn);
								}
								
								sql="select left(voucherno,2),right(voucherno,5),if(amount>0,amount,0),if(amount<0,amount,0) from accountdetails  where voucherno='"+voucher.get(i)+"' and ledgerid='"+id.get(i)+"' ";		
								rs=stm.executeQuery(sql); 
								//System.out.println(sql);
								while(rs.next())
								{
								usBean=new FormBean();
									//date=rs.getString(1);
									vtyp=rs.getString(1);
									vno=rs.getString(2);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									//narration=rs.getString(5);
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									/*if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}*/
									
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno);
										usBean.setDate(s1);
									}
									usBean.setParticulars(ledname+"<br>"+"<font color='darkblue'>"+longn+"</font>");
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
									//usBean.setV(voucher.get(i));
									//System.out.println("hello "+voucher.get(i));
										l1.add(usBean);	
										d=date;
										vn=vno;
								}								
							}
						usBean=new FormBean();
						usBean.setAsondate(s1);
							usBean.setVno("<b><span style='color:red'>Total</span></b>");
							usBean.setCreditamt("<b><span style='color:red'> "+Double.toString(totalcredit).replace("-","")+"Cr</span></b>");
							usBean.setDebitamt("<b><span style='color:red'> "+Double.toString(totaldebit)+" Dr</span></b>");
							l1.add(usBean);
					}		
		else if(s1.compareTo("")!=0 && s3.compareTo("Without_Narration")==0 && s4.compareTo("With_Narration")==0)
		{
			
					Vector<String> voucher=new Vector<String>();
											
					Vector<String> id=new Vector<String>();
					String sql="select voucherno,ledgerid from accountdetails  where entrydate='"+s1+"' ";
					//System.out.println(sql);
					
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
						{
						voucher.add(rs.getString(1));								
						id.add(rs.getString(2));
						}
					String d="",vn="";
							
					for(int i=0;i<voucher.size();i++)
						{
								sql="select ledgername from ledgermaster where ledgerid='"+id.get(i)+"' ";
								
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ledname=rs.getString(1);
									usBean=new FormBean();
									usBean.setParticulars(ledname);
						
								}
								//System.out.println("abcd");
	
								sql="select left(voucherno,2),right(voucherno,5),if(amount>0,amount,0),if(amount<0,amount,0),narration,voucherno from accountdetails  where voucherno='"+voucher.get(i)+"' and ledgerid='"+id.get(i)+"' ";		
								rs=stm.executeQuery(sql); 
								//System.out.println(sql);
								while(rs.next())
								{
								usBean=new FormBean();
									//date=rs.getString(1);
									vtyp=rs.getString(1);
									vno=rs.getString(6);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									if(!rs.getString(5).equals("0"))
									{
										shortn=rs.getString(5);
									}
									else
									{
										shortn="";
									}
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									/*if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}*/
									
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno.substring(10, vno.length()));
										usBean.setDate(s1);
									}
									
									//System.out.println("shortn "+shortn);
									usBean.setParticulars(ledname+"<br>"+"<font color='red'>"+shortn+"</font>");
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
									//usBean.setV(voucher.get(i));
									//System.out.println("hello "+voucher.get(i));
										l1.add(usBean);	
										d=date;
										vn=vno;
								}								
							}
						usBean=new FormBean();
						usBean.setAsondate(s1);
							usBean.setVno("<b><span style='color:red'>Total</span></b>");
							usBean.setCreditamt("<b> <span style='color:red'>"+Double.toString(totalcredit).replace("-","")+"Cr</span></b>");
							usBean.setDebitamt("<b> <span style='color:red'>"+Double.toString(totaldebit)+" Dr</span></b>");
							l1.add(usBean);
					}	
		else if(s1.compareTo("")!=0 && s3.compareTo("With_Narration")==0 && s4.compareTo("With_Narration")==0)
		{
			
					Vector<String> voucher=new Vector<String>();
											
					Vector<String> id=new Vector<String>();
					String sql="select voucherno,ledgerid from accountdetails  where entrydate='"+s1+"' ";
					//System.out.println(sql);
					
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
						{
						voucher.add(rs.getString(1));								
						id.add(rs.getString(2));
						}
					String d="",vn="";
							
					for(int i=0;i<voucher.size();i++)
						{
								sql="select ledgername from ledgermaster where ledgerid='"+id.get(i)+"' ";
								
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ledname=rs.getString(1);
									usBean=new FormBean();
									usBean.setParticulars(ledname);
						
								}
								sql="select narration from accountnarration where voucherno='"+voucher.get(i)+"' ";
								//System.out.println(sql);
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									longn=rs.getString(1);
									usBean=new FormBean();
									usBean.setParticulars(longn);
								}
	
								sql="select left(voucherno,2),right(voucherno,5),if(amount>0,amount,0),if(amount<0,amount,0),narration,voucherno from accountdetails  where voucherno='"+voucher.get(i)+"' and ledgerid='"+id.get(i)+"' ";		
								rs=stm.executeQuery(sql); 
								//System.out.println(sql);
								while(rs.next())
								{
								usBean=new FormBean();
									//date=rs.getString(1);
									vtyp=rs.getString(1);
									vno=rs.getString(6);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									if(!rs.getString(5).equals("0"))
									{
										shortn=rs.getString(5);
									}
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									/*if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}*/
									
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno.substring(10, vno.length()));
										usBean.setDate(s1);
									}
									usBean.setParticulars(ledname+"<br>"+"<font color='darkblue'>"+longn+"</font>"+"<br>"+"<font color='red'>"+shortn+"</font>");
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
									//usBean.setV(voucher.get(i));
									//System.out.println("hello "+voucher.get(i));
										l1.add(usBean);	
										d=date;
										vn=vno;
								}								
							}
						usBean=new FormBean();
						usBean.setAsondate(s1);
							usBean.setVno("<b><span style='color:red'>Total</span></b>");
							usBean.setCreditamt("<b> <span style='color:red'>"+Double.toString(totalcredit).replace("-","")+"Cr</span></b>");
							usBean.setDebitamt("<b><span style='color:red'> "+Double.toString(totaldebit)+" Dr</span></b>");
							l1.add(usBean);
					}
		else
		{
			
					Vector<String> voucher=new Vector<String>();
											//Vector<String> v=new Vector<String>();
					Vector<String> id=new Vector<String>();
					String sql="select voucherno,ledgerid from accountdetails  where entrydate='"+s1+"' ";
					//System.out.println(sql);
					
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
						{
						voucher.add(rs.getString(1));								
						id.add(rs.getString(2));
						}
					String d="",vn="";
							
					for(int i=0;i<voucher.size();i++)
						{
								sql="select ledgername from ledgermaster where ledgerid='"+id.get(i)+"' ";
								
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ledname=rs.getString(1);
									usBean=new FormBean();
									usBean.setParticulars(ledname);
						
								}
								//System.out.println("abcd");
								sql="select left(voucherno,2),right(voucherno,5),if(amount>0,amount,0),if(amount<0,amount,0),voucherno from accountdetails  where voucherno='"+voucher.get(i)+"' and ledgerid='"+id.get(i)+"' ";		
								rs=stm.executeQuery(sql); 
								//System.out.println(sql);
								while(rs.next())
								{
								usBean=new FormBean();
									//date=rs.getString(1);
									vtyp=rs.getString(1);
									vno=rs.getString(5);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									//narration=rs.getString(5);
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									/*if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}*/
									
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno.substring(10, vno.length()));
										usBean.setDate(s1);
									}
									usBean.setParticulars(ledname);
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
									//usBean.setV(voucher.get(i));
									//System.out.println("hello "+voucher.get(i));
										l1.add(usBean);	
										d=date;
										vn=vno;
								}								
							}
						usBean=new FormBean();
						usBean.setAsondate(s1);
							usBean.setVno("<b><span style='color:red'>Total</span></b>");
							usBean.setCreditamt("<b><span style='color:red'> "+Double.toString(totalcredit).replace("-","")+"Cr</span></b>");
							usBean.setDebitamt("<b> <span style='color:red'>"+Double.toString(totaldebit)+" Dr</span></b>");
							l1.add(usBean);
					}
		ConnectionDAO.closeConnection(conn);
		
	}catch (SQLException e) 
	{
		e.printStackTrace();
	}
			return l1;
}
//journal register list	
		public static List<FormBean> journalregisterlistdetails(String s1, String s2, String s3, String s4) 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);	
			
			/*String s1=formbean.getFrmdate();
			String s2=formbean.getTodate();
			String s3=formbean.getAcname();
			String s4=formbean.getType();*/
			
			////System.out.println(s3);
			String lid="",date="",vno="",ledname="",vtyp="",v="";	
			double debit=0.00,credit=0.00,totaldebit=0.00,totalcredit=0.00,x4=0.00,x5=0.00;	
			try
			{	
				if(s3.compareTo("")!=0 && s1.compareTo("")==0 && s2.compareTo("")==0 && s4.compareTo("Party")==0)
				{
					
								String sql="select ledgerid from ledgermaster where ledgername='"+s3+"'"; 		
										ResultSet rs = stm.executeQuery(sql);
										while (rs.next()) 
											{
												lid=rs.getString(1);			
											}
										sql="select voucherno from accountdetails where ledgerid='"+lid+"' and left(voucherno,2)='JV' ";
										//System.out.println(sql);
										rs=stm.executeQuery(sql);
										while(rs.next())
											{
											FormBean usBean=new FormBean();
											v=rs.getString(1);
											usBean.setV(v);
											}
										String d="",vn="";		
								sql="select accountdetails.entrydate,right(accountdetails.voucherno,5),if(accountdetails.amount>0,amount,0),if(accountdetails.amount<0,amount,0),ledgermaster.ledgername,left(accountdetails.voucherno,2) from accountdetails inner join ledgermaster where accountdetails.voucherno='"+v+"' and ledgermaster.ledgerid=accountdetails.ledgerid ";		
								rs=stm.executeQuery(sql);
								//System.out.println(sql);
								while(rs.next())
								{
									FormBean usBean=new FormBean();
									date=rs.getString(1);
									vno=rs.getString(2);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									ledname=rs.getString(5);
									vtyp=rs.getString(6);
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno);
									}
									
									usBean.setParticulars(ledname);
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
										usBean.setV(v);	
										//System.out.println("hello "+v);
										l1.add(usBean);	
										d=date;
										vn=vno;
										
										
								}
								FormBean usBean=new FormBean();
								usBean.setVno("<b>Total</b>");
								usBean.setCreditamt("<b> "+Double.toString(totalcredit).replace("-","")+"Cr</b>");
								usBean.setDebitamt("<b> "+Double.toString(totaldebit)+" Dr</b>");
								l1.add(usBean);
								//usBean=new FormBean();
								
				}
				
				
				if(s3.compareTo("")!=0 && s1.compareTo("")!=0 && s2.compareTo("")!=0 && s4.compareTo("Party")==0)
				{
					
								String sql="select ledgerid from ledgermaster where ledgername='"+s3+"'"; 		
										ResultSet rs = stm.executeQuery(sql);
										while (rs.next()) 
											{
												lid=rs.getString(1);			
											}
										sql="select voucherno from accountdetails where ledgerid='"+lid+"' and left(voucherno,2)='JV' and entrydate>='"+s1+"' and entrydate<='"+s2+"' ";
										rs=stm.executeQuery(sql);
										while(rs.next())
											{
											FormBean usBean=new FormBean();
											v=rs.getString(1);
											//usBean.setV(v);
											//l1.add(usBean);
											}
										String d="",vn="";		
								sql="select accountdetails.entrydate,right(accountdetails.voucherno,5),if(accountdetails.amount>0,amount,0),if(accountdetails.amount<0,amount,0),ledgermaster.ledgername,left(accountdetails.voucherno,2) from accountdetails inner join ledgermaster where accountdetails.voucherno='"+v+"' and ledgermaster.ledgerid=accountdetails.ledgerid ";		
								rs=stm.executeQuery(sql);
								//System.out.println(sql);
								while(rs.next())
								{
									FormBean usBean=new FormBean();
									date=rs.getString(1);
									vno=rs.getString(2);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									ledname=rs.getString(5);
									vtyp=rs.getString(6);
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}
									
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno);
									}
									usBean.setParticulars(ledname);
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
										usBean.setV(v);		
										l1.add(usBean);	
										d=date;
										vn=vno;
								}
								FormBean usBean=new FormBean();
								usBean.setVno("<b>Total</b>");
								usBean.setCreditamt("<b> "+Double.toString(totalcredit).replace("-","")+"Cr</b>");
								usBean.setDebitamt("<b> "+Double.toString(totaldebit)+" Dr</b>");
								l1.add(usBean);
				}		
				
				
		else if(s1.compareTo("")==0 && s2.compareTo("")==0 && s4.compareTo("All")==0)
				{
			
								Vector<String> voucher=new Vector<String>();
								//Vector<String> v=new Vector<String>();
								Vector<String> id=new Vector<String>();
								String sql="select distinct voucherno,ledgerid from accountdetails where left(voucherno,2)='JV' ";
								//System.out.println(sql);
								int i=0;
								ResultSet rs=stm.executeQuery(sql);
										while(rs.next())
											{
											
											voucher.add(rs.getString(1));
											//FormBean usBean=new FormBean();
											//voucher.get(i);
											/*usBean.setV(v);
											l1.add(usBean);*/
											id.add(rs.getString(2));
											//i++;
											
											}
										String d="",vn="";
							for(i=0;i<voucher.size();i++)
							{
								sql="select accountdetails.entrydate,right(accountdetails.voucherno,5),if(accountdetails.amount>0,amount,0),if(accountdetails.amount<0,amount,0),ledgermaster.ledgername,left(accountdetails.voucherno,2) from accountdetails inner join ledgermaster where accountdetails.voucherno='"+voucher.get(i)+"' and ledgermaster.ledgerid='"+id.get(i)+"' and ledgermaster.ledgerid=accountdetails.ledgerid ";		
								rs=stm.executeQuery(sql);
								//System.out.println(sql);
								while(rs.next())
								{
									FormBean usBean=new FormBean();
									date=rs.getString(1);
									vno=rs.getString(2);
									debit=rs.getDouble(3);
									credit=rs.getDouble(4);
									ledname=rs.getString(5);
									vtyp=rs.getString(6);
									totaldebit=totaldebit+debit;
									totalcredit=totalcredit+credit;
									
									switch(vtyp)
									{
									case "RC":  vtyp="Cash Receipt";break;
									case "RB":  vtyp="Bank Receipt";break;
									case "CO":  vtyp="Contra";break;
									case "JV":  vtyp="Journal";break;
									case "PB":  vtyp="Bank Payment";break;
									case "PC":  vtyp="Cash Payment";break;
									case "DN":  vtyp="Debit Note";break;
									case "CN":  vtyp="Credit Note";break;
									case "UC":  vtyp="Cash Purchase";break;
									case "SC":  vtyp="Cash Sales";break;
									case "UD":  vtyp="Credit Purchase";break;
									case "SD":  vtyp="Credit Sales";break;
									}
									if(date.compareTo(d)==0)
									{
										usBean.setDate("");
									}
									else{
										usBean.setDate(date);
									}
									
									if(vno.compareTo(vn)==0)
									{
										usBean.setVno("");
									}
									else{
										usBean.setVno(vno);
									}
									usBean.setParticulars(ledname);
									usBean.setVtyp(vtyp);
										if(debit!=0)
										{
											usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
										}
										else
										{
											usBean.setDebitamt("");
										}
										if(credit!=0)
										{
											usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
										}
										else
										{
											usBean.setCreditamt("");
										}
									usBean.setV(voucher.get(i));
									//System.out.println("hello "+voucher.get(i));
										l1.add(usBean);	
										d=date;
										vn=vno;
								}
								
							}
							FormBean usBean=new FormBean();
							usBean.setVno("<b>Total</b>");
							usBean.setCreditamt("<b> "+Double.toString(totalcredit).replace("-","")+"Cr</b>");
							usBean.setDebitamt("<b> "+Double.toString(totaldebit)+" Dr</b>");
							l1.add(usBean);
					}
				
		else if(s1.compareTo("")!=0 && s2.compareTo("")!=0 && s4.compareTo("All")==0)
		{
			
						Vector<String> voucher=new Vector<String>();
						Vector<String> id=new Vector<String>();
						String sql="select distinct voucherno,ledgerid from accountdetails where left(voucherno,2)='JV' and entrydate>='"+s1+"' and entrydate<='"+s2+"'";
						//System.out.println(sql);
						int i=0;
						ResultSet rs=stm.executeQuery(sql);
								while(rs.next())
									{
									
									voucher.add(rs.getString(1));
									//FormBean usBean=new FormBean();
									v=voucher.get(i);
									
									id.add(rs.getString(2));
									i++;
									
									}
								String d="",vn="";
					for(i=0;i<voucher.size();i++)
					{
						sql="select distinct accountdetails.entrydate,right(accountdetails.voucherno,5),if(accountdetails.amount>0,amount,0),if(accountdetails.amount<0,amount,0),ledgermaster.ledgername,left(accountdetails.voucherno,2) from accountdetails inner join ledgermaster where accountdetails.voucherno='"+voucher.get(i)+"' and ledgermaster.ledgerid=accountdetails.ledgerid and ledgermaster.ledgerid='"+id.get(i)+"' ";		
						rs=stm.executeQuery(sql);
						//System.out.println(sql);
						while(rs.next())
						{
							FormBean usBean=new FormBean();
							date=rs.getString(1);
							vno=rs.getString(2);
							debit=rs.getDouble(3);
							credit=rs.getDouble(4);
							ledname=rs.getString(5);
							vtyp=rs.getString(6);
							
							totaldebit=totaldebit+debit;
							totalcredit=totalcredit+credit;
							
							switch(vtyp)
							{
							case "RC":  vtyp="Cash Receipt";break;
							case "RB":  vtyp="Bank Receipt";break;
							case "CO":  vtyp="Contra";break;
							case "JV":  vtyp="Journal";break;
							case "PB":  vtyp="Bank Payment";break;
							case "PC":  vtyp="Cash Payment";break;
							case "DN":  vtyp="Debit Note";break;
							case "CN":  vtyp="Credit Note";break;
							case "UC":  vtyp="Cash Purchase";break;
							case "SC":  vtyp="Cash Sales";break;
							case "UD":  vtyp="Credit Purchase";break;
							case "SD":  vtyp="Credit Sales";break;
							}
							if(date.compareTo(d)==0)
							{
								usBean.setDate("");
							}
							else{
								usBean.setDate(date);
							}
							
							if(vno.compareTo(vn)==0)
							{
								usBean.setVno("");
							}
							else{
								usBean.setVno(vno);
							}
							usBean.setParticulars(ledname);
							usBean.setVtyp(vtyp);
								if(debit!=0)
								{
									usBean.setDebitamt(Double.toString(debit).replace("-","")+" <b>Dr</b>");
								}
								else
								{
									usBean.setDebitamt("");
								}
								if(credit!=0)
								{
									usBean.setCreditamt(Double.toString(credit).replace("-","")+" <b>Cr</b>");
								}
								else
								{
									usBean.setCreditamt("");
								}
								usBean.setV(voucher.get(i));			
								l1.add(usBean);	
								d=date;
								vn=vno;
						}
						
					}
					FormBean usBean=new FormBean();
					usBean.setVno("<b>Total</b>");
					usBean.setCreditamt("<b> "+Double.toString(totalcredit).replace("-","")+"Cr</b>");
					usBean.setDebitamt("<b> "+Double.toString(totaldebit)+" Dr</b>");
					l1.add(usBean);
			}	
				
											
		ConnectionDAO.closeConnection(conn);
		
		}catch (SQLException e) 
			{
			e.printStackTrace();
		}
			return l1;
		}
		public static FormBean journaledit1(String date,String v) {
			FormBean usBean=new FormBean();
			String sql="",voucherno="",entrydate="",refno="",refdate="",nar="";
			int id1=0;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			try
			{
				sql="select voucherno,entrydate,referenceno,referencedate,id from accounttransaction where entrydate='"+date+"' and voucherno='"+v+"' ";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
					entrydate=rs.getString(2);
					refno=rs.getString(3);
					refdate=rs.getString(4);
					id1=rs.getInt(5);
				}
				usBean.setSrno(voucherno.substring(voucherno.length()-1,voucherno.length()));
				sql="select narration from accountnarration where voucherno='"+voucherno+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					nar=rs.getString(1);
				}
				Vector<String> dc=new Vector<String>();
				Vector<String> particular=new Vector<String>();
				Vector<String> credit=new Vector<String>();
				Vector<String> debit=new Vector<String>();
				Vector<String> narration=new Vector<String>();
				sql="select * from accountdetails where voucherno='"+voucherno+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					if(rs.getDouble(5) < 0)
					{
						dc.add("cr");
						credit.add(Double.toString(rs.getDouble(5)));
						debit.add("0");
					}
					else if(rs.getDouble(5) > 0)
					{
						dc.add("dr");
						debit.add(Double.toString(rs.getDouble(5)));
						credit.add("0");
					}
					String led=findledger(rs.getString(4));
					particular.add(led);
					narration.add(rs.getString(8));
				}
				String dc1[]=new String[dc.size()];
				String particular1[]=new String[particular.size()];
				String credit1[]=new String[credit.size()];
				String debit1[]=new String[debit.size()];
				String narration1[]=new String[narration.size()];
				for(int i=1;i<=narration.size();i++)
				{
					//System.out.println("value of i "+i);
					dc1[i-1]=dc.get(i-1);
					credit1[i-1]=credit.get(i-1).replaceAll("-","");
					debit1[i-1]=debit.get(i-1);
					narration1[i-1]=narration.get(i-1);
					particular1[i-1]=particular.get(i-1);
				}
				usBean.setDorc(dc1);
				usBean.setQuantity(particular1);
				//System.out.println("particular1 "+particular1[0]+" "+particular1[1]);
				usBean.setCredit(credit1); 
				usBean.setDebit(debit1);
				usBean.setNarration(narration1);
				usBean.setShowdate(entrydate);
				usBean.setContraref(refno);
				usBean.setContradate(refdate);
				usBean.setDesc1(nar); 
				usBean.setId(id1);
			}
			catch(Exception g)
			{
				System.out.println("journal edit1 error at "+g);
			}
			return usBean;
			}
		public static List<FormBean> bankbooklistdetails(FormBean formbean) 
		{
			
			List<FormBean> l1 = new ArrayList<FormBean>();
			
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try{
				String s1=formbean.getFrmdate();
				String s2=formbean.getTodate();
				String s3=formbean.getAccname();
				
				double x=0.00,x1=0.00,amt=0.00;
				String lid="",vno="",lcd="";
				String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"' ";
				//System.out.println("uslist2  "+sql);
				
				ResultSet rs=stm.executeQuery(sql);
				//System.out.println(sql );
				while(rs.next())
				{
					lid=rs.getString(1);
					x=rs.getDouble(2);
					//System.out.println("ledgerid"+ lid );
				}
				
				sql="select sum(amount) from accountdetails where ledgerid='"+lid+"' and entrydate<'"+s1+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					x1=rs.getDouble(1);
				}
				//System.out.println(x1 );
				
				x=x+x1;
				
				//System.out.println(x );
				FormBean usBean;	
				
				//if(x>0){

					sql="select voucherno,amount,ledgerid,entrydate from accountdetails where entrydate>='"+s1+"' and entrydate<='"+s2+"' and ledgerid!='"+lid+"' and (left(voucherno,2)='PC' or left(voucherno,2)='RC' or left(voucherno,2)='CO' )";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						usBean = new FormBean();
						vno=rs.getString(1);
						amt=rs.getDouble(2);
						if(amt > 0)
						{
						//System.out.println(amt); 
						usBean.setAmount("Rs. "+Double.toString(amt)+" Dr");
						lcd=rs.getString(3);
						
						String ref=findref(vno,rs.getString(4));
						//System.out.println("findref "+ref);
						String got[]=ref.split("con");
						/*System.out.println(got[0]);
						System.out.println(got[1]);
						System.out.println(got[2]);*/
						usBean.setParticular(findledger(lcd));
						usBean.setRefno(got[0]);
						usBean.setRefdate(got[1]);
						l1.add(usBean);
						}
					}

				//}	
				//l1.add(usBean);
			}catch (Exception e) 
			{
			e.printStackTrace();
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
		public static List<FormBean> bankbooklistdetails2(FormBean formbean) 
		{
			
			List<FormBean> l1 = new ArrayList<FormBean>();
			
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			try{
				String s1=formbean.getFrmdate();
				String s2=formbean.getTodate();
				String s3=formbean.getAccname();
				
				double x=0.00,x1=0.00,amt=0.00;
				String lid="",vno="",lcd="";
				String sql="select ledgerid,openingbalance from ledgermaster where ledgername='"+s3+"' ";
				//System.out.println("uslist1 "+sql);
				
				ResultSet rs=stm.executeQuery(sql);
				//System.out.println(sql );
				while(rs.next())
				{
					lid=rs.getString(1);
					x=rs.getDouble(2);
				}
				
				sql="select sum(amount) from accountdetails where ledgerid='"+lid+"' and entrydate<'"+s1+"' ";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					x1=rs.getDouble(1);
				}
				x=x+x1;
						
				//if(x<=0){
				sql="select voucherno,amount,ledgerid,entrydate from accountdetails where entrydate>='"+s1+"' and entrydate<='"+s2+"' and ledgerid!='"+lid+"' and (left(voucherno,2)='PC' or left(voucherno,2)='RC' or left(voucherno,2)='CO' )";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						FormBean usBean = new FormBean();
						vno=rs.getString(1);
						amt=rs.getDouble(2);
						if(amt <= 0)
						{
						String xx=Double.toString(amt).replace("-", "");
						usBean.setAmount("Rs. "+xx+" Cr");
						lcd=rs.getString(3);				
						String ref=findref(vno,rs.getString(4));				
						String got[]=ref.split("con");
						/*System.out.println(got[0]);
						System.out.println(got[1]);
						System.out.println(got[2]);*/
						usBean.setParticular(findledger(lcd));
						usBean.setRefno(got[0]);
						usBean.setRefdate(got[1]);
						System.out.println(lcd+","+got[0]+","+got[1]+","+amt);
						l1.add(usBean);
						}
					}
				//}
				/*usBean = new FormBean();	
				usBean.setAmount("");		
				usBean.setParticular("");
				usBean.setRefno("");
				usBean.setRefdate("");
				l1.add(usBean);		*/
			}catch (Exception e) 
			{
			e.printStackTrace();
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
		public static List<FormBean> company() 
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			String sql = "select * from company_master";
			//String sql1="select * from subgroupmaster";
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			String buffer,x="",x1="",x2="";
			try 
				{
					ResultSet rs = stm.executeQuery(sql);
					FormBean usBean=new FormBean();
					FormBean usBean1=new FormBean();
					
					while (rs.next()) 
						{
						x=rs.getString(3);
						usBean = new FormBean();
					
						usBean.setCompany(rs.getString(3));
						usBean.setFinyear(findfinyear(rs.getString(2)));
						l1.add(usBean);	
						}
				} 
			catch (SQLException e) 
				{
					e.printStackTrace();
				}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
public static String findfinyear(String x)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",a="";
	try
	{
		sql="select * from financial_period where company_code='"+x+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			a=rs.getString(3);
		}
	}
	catch(Exception fg)
	{
		System.out.println("error in findfinyear "+fg);
	}
	ConnectionDAO.closeConnection(conn);
	return a;
}
}
