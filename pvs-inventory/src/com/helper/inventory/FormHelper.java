package com.helper.inventory;

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
import com.bean.inventory.FormBean;
import org.apache.commons.lang.ArrayUtils;



public class FormHelper 
{	static String g_ledgername="";
	static String getdate="";
	static String g_ledgernameforcashonly="";
	static String areaname="";
	static String areaname1="";
	static String cocode="";
	
	public static String findledger(String xx)
	{
		String x3="",x1="";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try
		{
			String sql="select ledgername from ledgermaster where ledgerid like'%"+xx+"%'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				x3=rs.getString(1);
			}
			//System.out.println("ledger name got "+x3);
		}
		catch(Exception hh)
		{
			System.out.println("error in findledger "+hh);
		}
		ConnectionDAO.closeConnection(conn);
		return x3;
	}
	public static List<FormBean> materialgrouplist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from materialgroupmaster order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setShortname(rs.getString(4));
				x.setCompany(findledger(rs.getString(5)));
				l1.add(x);
				sr++;
			}
		}
		catch(Exception c)
		{
			System.out.println("error on materialgroup list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	public static List<FormBean> sdpartylist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			sql="select * from ledgermaster where ledgerid like 'SD%'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setDebitac(rs.getString(3));
				//x.setOnac(rs.getString(3));
				//System.out.println("value "+rs.getString(3));
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on party list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	public static List<FormBean> categorylist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			//int srno=1;
			sql="select * from categorymaster order by trname";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setCategory(rs.getString(3));
				x.setSname(rs.getString(4));
				l1.add(x);
				//srno++;
			}
		}
		catch(Exception c)
		{
			System.out.println("error on category list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	public static List<FormBean> materialglist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from materialgroupmaster order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setDesc(rs.getString(3));
				x.setSname(rs.getString(4));
				
				x.setCompany(findledger1(rs.getString(5)));
				l1.add(x);
				
			}
		}
		catch(Exception c)
		{
			System.out.println("error on salesman list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	
	public static boolean materialgroupcreation1(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		if(FormBean.getId() != null)
		{
			try
			{
				String sql="update materialgroupmaster set description='"+FormBean.getDesc()+"', shortname='"+FormBean.getSname()+"',ledgerid='"+FormBean.getCmpcode()+"' where id='"+FormBean.getId()+"'";
				
				System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			catch(Exception g)
			{
			//	System.out.println("error on salesmanupdate "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String smcode="",x="";
				String sql="";
				
					sql="insert into materialgroupmaster(groupcode,description, shortname, ledgerid)values('"+FormBean.getGroupcode()+"', '"+FormBean.getDesc()+"','"+FormBean.getSname()+"','"+FormBean.getCmpcode()+"')";
					System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				
			}
			catch(Exception a)
			{
				System.out.println("error on salesman creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}
	
	public static FormBean materialedit1(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from materialgroupmaster where id='"+id+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setDesc(rs.getString(3));
				usBean.setSname(rs.getString(4));
				usBean.setCompanyname(findledger1(rs.getString(5)));
				usBean.setCmpcode(rs.getString(5));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on sales man edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
	
	public static List<FormBean> csalesmemeoentry(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from itransaction where voucherno like 'MR%' order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setNameofarea(rs.getString(4));
				x.setSalesmanname(rs.getString(6));
				x.setRetailername(rs.getString(7));
				x.setMemo(rs.getString(9));
				
			
			//	x.setCompany(findledger(rs.getString(5)));
				l1.add(x);
				
			}
		}
		catch(Exception c)
		{
			System.out.println("error on salesman list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	
	
	
	//salesmemocreation
	
	public static boolean csalesmemeocreation(FormBean FormBean) 
	{
		boolean result1 = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String voucherno="";
		if(FormBean.getId() != null)
		{
			try
			{
				//System.out.println("hello");
				String sql="update itransaction set area='"+FormBean.getNameofarea()+"', entrydate='"+FormBean.getDate()+"',sman_name='"+FormBean.getSalesmanname()+"',rname='"+FormBean.getRetailername()+"', address='"+FormBean.getAddress()+"',memo='"+FormBean.getMemo()+"',totalamt1='"+FormBean.getTotalamt()+"',packing='"+FormBean.getPacking()+"',case1='"+FormBean.getCasee()+"',pcs1='"+FormBean.getPcss()+"',total='"+FormBean.getTotal()+"',total_discount='"+FormBean.getDiscount()+"',gross_amt='"+FormBean.getGamount()+"',discount='"+FormBean.getDiscount1()+"',sub_total='"+FormBean.getSubtotal()+"',sgst='"+FormBean.getSgst()+"',cgst='"+FormBean.getCgst()+"',igst='"+FormBean.getIgst()+"',total_rs='"+FormBean.getTotalamtrs()+"',gst_amt='"+FormBean.getGstamount()+"',r_off='"+FormBean.getRoundoff()+"',add1='"+FormBean.getAdd()+"',net_amt='"+FormBean.getNetamount()+"' where id='"+FormBean.getId()+"'";
				
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				
				sql="delete from idetails where voucherno='"+voucherno+"' ";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				String nameofitems6[]=FormBean.getNameofitems1();
				//System.out.println("length: "+nameofitems6.length);
				String materialcode="";
				String	case6[]=FormBean.getCase5(),pcs6[]=FormBean.getPcs5(),fp6[]=FormBean.getFp1(),mrp6[]=FormBean.getMrp5(),rate6[]=FormBean.getRate4(),discs6[]=FormBean.getDiscs4(),dis6[]=FormBean.getDis4(),amount6[]=FormBean.getAmount5();
				String dis_amount[]=FormBean.getTotal111(),remain_amount[]=FormBean.getTodiscount1(),tax_amount[]=FormBean.getTytax1(),gst_amount[]=FormBean.getGstper1();
				
				
				for(int i=0;i<nameofitems6.length;i++)
				{
					String packing="",ccase="",cpcs="",ctotal="";
					double scase=0,spcs=0,stotal=0;
					
					//System.out.println("hello");
					sql="select packing,matcode from materialmaster where matname='"+nameofitems6[i]+"'";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						packing=rs.getString(1);
						materialcode=rs.getString(2);
					
						//System.out.println("Packng: "+packing+","+materialcode);
					}
					sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						
						ccase=rs.getString(1);
						cpcs=rs.getString(2);
						ctotal=rs.getString(3);
						//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
					}
					
					if(fp6[i].equals(""))
					{
						fp6[i]="0";
					}
					System.out.println("output: "+case6[i]+","+pcs6[i]+","+fp6[i]);
					double total=(Double.parseDouble(case6[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs6[i]) +Double.parseDouble(fp6[i]));
					//System.out.println("Total value: "+total);
					
					sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+voucherno+"','"+nameofitems6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+mrp6[i]+"','"+rate6[i]+"','"+discs6[i]+"','"+dis6[i]+"','"+amount6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
				
					//System.out.println(sql);
					
					result1=ConnectionDAO.executeUpdate(stm, sql);
					
					scase=Double.parseDouble(ccase) - Double.parseDouble(case6[i]);
					spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs6[i]) + Double.parseDouble(fp6[i]));
					stotal=Double.parseDouble(ctotal) - total;
					
					 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
					 //System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm, sql);
				}
				
			}
			catch(Exception g)
			{
				System.out.println("error on counter sales "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String materialcode="",x="";
				String sql="";
				String v="VD";
				int cmat=0;
				 String mcode="",matcode="",matcode1="";
				 String v1="MR";
				 
				 String cdate=FormBean.getDate();
				 
				
				 String cdate1[]=cdate.split("-");
				 String yr=cdate1[0];
				 String mon=cdate1[1];
				 String day=cdate1[2];
				// System.out.println("date: "+cdate+","+yr+","+mon+","+day);
				 yr=yr.substring(2, 4);
				 //System.out.println("sub year: "+yr);
				int yr1=Integer.parseInt(yr)+1;
				v1=v1+yr+yr1+yr+mon+day;
				//System.out.println("bubun: "+v1);
					
				sql="select count(id) from itransaction";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						 cmat=rs.getInt(1);
					}
					
					if(cmat == 0)
					{
						matcode=mcode+"00"+(cmat+1);
					}
					else if(cmat > 0 && cmat < 9)
					{
						matcode=mcode+"00"+(cmat+1);
					}
					else if(cmat > 8 && cmat < 99)
					{
						matcode=mcode+"0"+(cmat+1);
					}
					else if(cmat > 98 && cmat < 999)
					{
						matcode=mcode+(cmat+1);
					}
					else if(cmat > 998 && cmat < 9999)
					{
						matcode=mcode+(cmat+1);
						
					}
					 matcode1=v1+matcode;
				//System.out.println("hii"+matcode1);
					sql="insert into itransaction(voucherno,vouchertype,area,entrydate,sman_name,rname,address,memo,totalamt1,packing,case1,pcs1,total,total_discount,gross_amt,discount,sub_total,sgst,cgst,igst,total_rs,gst_amt,r_off,add1,net_amt)values( '"+matcode1+"','"
					+"MR"+"','"
					+FormBean.getNameofarea()+"','"
					+FormBean.getDate()+"','"
					+FormBean.getSalesmanname()+"','"
					+FormBean.getRetailername()+"','"
					+FormBean.getAddress()+"','"
					+FormBean.getMemo()+"','"
					+FormBean.getTotalamt()+"','"
					+FormBean.getPacking()+"','"
					+FormBean.getCasee()+"','"
					+FormBean.getPcss()+"','"
					+FormBean.getTotal()+"','"
					+FormBean.getDiscount()+"','"
					+FormBean.getGamount()+"','"
					+FormBean.getDiscount1()+"','"
					+FormBean.getSubtotal()+"','"
					+FormBean.getSgst()+"','"
					+FormBean.getCgst()+"','"
					+FormBean.getIgst()+"','"
					+FormBean.getTotalamtrs()+"','"
					+FormBean.getGstamount()+"','"
					+FormBean.getRoundoff()+"','"
					+FormBean.getAdd()+"','"
					+FormBean.getNetamount()+"')";
					//System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm,sql);
					//int total=0;
					
					String nameofitems[]=FormBean.getNameofitems();
					String case1[]=FormBean.getCase4(),pcs1[]=FormBean.getPcs4(),fp1[]=FormBean.getFp();
					String mrp1[]=FormBean.getMrp4(),rate1[]=FormBean.getRate(),discs[]=FormBean.getDiscs(),dis1[]=FormBean.getDis(),amount1[]=FormBean.getAmount4();
					String dis_amount[]=FormBean.getTotal11(),remain_amount[]=FormBean.getTodiscount(),tax_amount[]=FormBean.getTytax(),gst_amount[]=FormBean.getGstper();
					//System.out.println("hi: "+nameofitems.length);
					for(int i=0;i<nameofitems.length;i++)
					{
						String packing="",ccase="",cpcs="",ctotal="";
						double scase=0,spcs=0,stotal=0;
						
						//System.out.println("hello");
						sql="select packing,matcode from materialmaster where matname='"+nameofitems[i]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							packing=rs.getString(1);
							materialcode=rs.getString(2);
						
							System.out.println("Packng: "+packing+","+materialcode);
						}
						sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							
							ccase=rs.getString(1);
							cpcs=rs.getString(2);
							ctotal=rs.getString(3);
							//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
						}
						
						if(fp1[i].equals(""))
						{
							fp1[i]="0";
						}
						System.out.println("output: "+case1[i]+","+pcs1[i]+","+fp1[i]);
						double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(fp1[i]));
						//System.out.println("Total value: "+total);
						
						sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+matcode1+"','"+nameofitems[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+mrp1[i]+"','"+rate1[i]+"','"+discs[i]+"','"+dis1[i]+"','"+amount1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
					
						//System.out.println(sql);
						
						result1=ConnectionDAO.executeUpdate(stm, sql);
						
						scase=Double.parseDouble(ccase) - Double.parseDouble(case1[i]);
						spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs1[i]) + Double.parseDouble(fp1[i]));
						stotal=Double.parseDouble(ctotal) - total;
						
						 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						 //System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm, sql);
					}
					
					
				
			}
			catch(Exception a)
			{
				System.out.println("error on salesman creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result1;
	}
	
	
	
	//salesmemoupdate
	
	
	public static FormBean csalesmemeoupdate(int id)
	{
		FormBean usBean=new FormBean();
		
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String voucherno="";
		try
		{
			String sql="select voucherno from itransaction where id= '"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			//System.out.println(voucherno);
			
			
			 sql="select * from itransaction where voucherno='"+voucherno+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			
			
		
			
			
			while(rs.next())
			{
				areaname=rs.getString(7);
				//System.out.println("Ram: "+rs.getString(7));
				usBean.setId(rs.getInt(1));
				usBean.setNameofarea(rs.getString(4));
				usBean.setDate(rs.getString(5));
				usBean.setSalesmanname(rs.getString(6));
				usBean.setRetailername(rs.getString(7));
				usBean.setAddress(rs.getString(8));
				usBean.setMemo(rs.getString(9));
				usBean.setTotalamt(rs.getString(10));
				/*usBean.setPacking(rs.getString(11));
				usBean.setCasee(rs.getString(12));
				usBean.setPcss(rs.getString(13));
				usBean.setTotal(rs.getString(14));*/
				usBean.setDiscount(rs.getString(15));
				usBean.setGamount(rs.getString(16));
				usBean.setDiscount1(rs.getString(17));
				usBean.setSubtotal(rs.getString(18));
				usBean.setSgst(rs.getString(19));
				usBean.setCgst(rs.getString(20));
				usBean.setIgst(rs.getString(21));
				usBean.setTotalamtrs(rs.getString(22));
				usBean.setGstamount(rs.getString(23));
				usBean.setRoundoff(rs.getString(24));
				usBean.setAdd(rs.getString(25));
				usBean.setNetamount(rs.getString(26));
				
				
			}
			 sql="select placename from placemaster where placecode=(select area from itransaction where voucherno='"+voucherno+"' )";
			//System.out.println(sql);
			 rs=stm.executeQuery(sql);
			
				while(rs.next())
				{
					areaname1=rs.getString(1);
					usBean.setNameofarea1(rs.getString(1));
					
				}
				 sql="select smname from areasalesmanmaster where smcode=(select sman_name from itransaction where voucherno='"+voucherno+"' )";
					//System.out.println(sql);
					 rs=stm.executeQuery(sql);
					
						while(rs.next())
						{
							usBean.setSalesmanname1(rs.getString(1));
							
						}
						sql="select party_name from partymaster1 where party_code=(select rname from itransaction where voucherno='"+voucherno+"' )";
						//System.out.println(sql);
						 rs=stm.executeQuery(sql);
						
							while(rs.next())
							{
								areaname=rs.getString(1);
								System.out.println("partyname: "+areaname);
								usBean.setRetailername1(rs.getString(1));
								
							}
			
			Vector<String> nameofitems=new Vector<String>();
			Vector<String> case1=new Vector<String>();
			Vector<String> pcs=new Vector<String>();
			Vector<String> fp=new Vector<String>();
			Vector<String> mrp=new Vector<String>();
			Vector<String> rate=new Vector<String>();
			Vector<String> discs=new Vector<String>();
			Vector<String> dispercent=new Vector<String>();
			Vector<String> amount=new Vector<String>();
			//Vector<String> tytax=new Vector<String>();
			Vector<String> disamount=new Vector<String>();
			Vector<String> remainamount=new Vector<String>();
			Vector<String> taxamount=new Vector<String>();
			Vector<String> gstamount=new Vector<String>();
			
			
			
			sql="select * from idetails where voucherno='"+voucherno+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				nameofitems.add(rs.getString(3));
				case1.add(rs.getString(4));
				pcs.add(rs.getString(5));
				fp.add(rs.getString(6));
				mrp.add(rs.getString(7));
				rate.add(rs.getString(8));
				discs.add(rs.getString(9));
				dispercent.add(rs.getString(10));
				amount.add(rs.getString(11));
				disamount.add(rs.getString(16));
				remainamount.add(rs.getString(17));
				taxamount.add(rs.getString(18));
				gstamount.add(rs.getString(19));
				
				
			
			
			}
			
			String nameofitems1[]= new String[nameofitems.size()];
			String case2[]= new String[case1.size()];
			String pcs1[]= new String[pcs.size()];
			String fp1[]= new String[fp.size()];
			String mrp1[]= new String[mrp.size()];
			String rate1[]= new String[rate.size()];
			String discs1[]= new String[discs.size()];
			String dispercent1[]= new String[dispercent.size()];
			String amount1[]= new String[amount.size()];
			String disamount1[]= new String[disamount.size()];
			String remainamount1[]= new String[remainamount.size()];
			String taxamount1[]= new String[taxamount.size()];
			String gstamount1[]= new String[gstamount.size()];
			
			
			for(int i=0;i<nameofitems.size();i++)
			{
				nameofitems1[i]=nameofitems.get(i);
				//System.out.println("material name: "+nameofitems1[i]);
				case2[i]=case1.get(i);
				pcs1[i]=pcs.get(i);
				fp1[i]=fp.get(i);
				mrp1[i]=mrp.get(i);
				rate1[i]=rate.get(i);
				discs1[i]=discs.get(i);
				dispercent1[i]=dispercent.get(i);
				amount1[i]=amount.get(i);
				disamount1[i]=disamount.get(i);
				remainamount1[i]=remainamount.get(i);
				taxamount1[i]=taxamount.get(i);
				gstamount1[i]=gstamount.get(i);
				System.out.println("amount: "+disamount.get(i)+","+remainamount.get(i)+","+taxamount.get(i)+","+gstamount.get(i));
			
			}
			
			usBean.setNameofitems(nameofitems1);
			usBean.setCase4(case2);
			usBean.setPcs4(pcs1);
			usBean.setFp(fp1);
			usBean.setMrp4(mrp1);
			usBean.setRate(rate1);
			usBean.setDiscs(discs1);
			usBean.setDis(dispercent1);
			usBean.setAmount4(amount1);
    		usBean.setTotal11(disamount1);
	        usBean.setTodiscount(remainamount1);
	        usBean.setTytax(taxamount1);
	        usBean.setGstper(gstamount1);
		}
		catch(Exception a)
		{
			System.out.println("error on sales man edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
	
	
	
	
	
	
//dsalesmemeoentry
public static List<FormBean> dsalesmemeoentry(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from itransaction where voucherno like 'VD%'order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setNameofarea(rs.getString(3));
				x.setSalesmanname(rs.getString(5));
				
				x.setRetailername(rs.getString(6));
				x.setMemo(rs.getString(8));
				System.out.println(rs.getString(3)+"concat"+rs.getString(5)+"concat"+rs.getString(6)+"concat"+rs.getString(8));
			
			//	x.setCompany(findledger(rs.getString(5)));
				l1.add(x);
				
			}
		}
		catch(Exception c)
		{
			System.out.println("error on salesman list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	
	
	
	//dsalesmemocreation
	
	public static boolean dsalesmemeocreation(FormBean FormBean) 
	{
		boolean result1 = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String voucherno="";
		if(FormBean.getId() != null)
		{
			try
			{
				System.out.println("hello");
				String sql="update itransaction set area='"+FormBean.getNameofarea()+"', entrydate='"+FormBean.getDate()+"',sman_name='"+FormBean.getSalesmanname()+"',rname='"+FormBean.getRetailername()+"', address='"+FormBean.getAddress()+"',memo='"+FormBean.getMemo()+"',totalamt1='"+FormBean.getTotalamt()+"',packing='"+FormBean.getPacking()+"',case1='"+FormBean.getCasee()+"',pcs1='"+FormBean.getPcss()+"',total='"+FormBean.getTotal()+"',total_discount='"+FormBean.getDiscount()+"',gross_amt='"+FormBean.getGamount()+"',discount='"+FormBean.getDiscount1()+"',sub_total='"+FormBean.getSubtotal()+"',sgst='"+FormBean.getSgst()+"',cgst='"+FormBean.getCgst()+"',igst='"+FormBean.getIgst()+"',total_rs='"+FormBean.getTotalamtrs()+"',gst_amt='"+FormBean.getGstamount()+"',r_off='"+FormBean.getRoundoff()+"',add1='"+FormBean.getAdd()+"',net_amt='"+FormBean.getNetamount()+"' where id='"+FormBean.getId()+"'";
				
				System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				
				sql="delete from idetails where voucherno='"+voucherno+"' ";
				System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				String nameofitems6[]=FormBean.getNameofitems1();
				System.out.println("length: "+nameofitems6.length);
				String materialcode="";
				String	case6[]=FormBean.getCase5(),pcs6[]=FormBean.getPcs5(),fp6[]=FormBean.getFp1(),mrp6[]=FormBean.getMrp5(),rate6[]=FormBean.getRate4(),discs6[]=FormBean.getDiscs4(),dis6[]=FormBean.getDis4(),amount6[]=FormBean.getAmount5();
				String dis_amount[]=FormBean.getTotal111(),remain_amount[]=FormBean.getTodiscount1(),tax_amount[]=FormBean.getTytax1(),gst_amount[]=FormBean.getGstper1();
				
				
				for(int i=0;i<nameofitems6.length;i++)
				{
					String packing="",ccase="",cpcs="",ctotal="";
					double scase=0,spcs=0,stotal=0;
					
					System.out.println("hello");
					sql="select packing,matcode from materialmaster where matname='"+nameofitems6[i]+"'";
					System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						packing=rs.getString(1);
						materialcode=rs.getString(2);
					System.out.println("Packing: "+packing+","+materialcode);
					}
					sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
					System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						
						ccase=rs.getString(1);
						cpcs=rs.getString(2);
						ctotal=rs.getString(3);
						System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
					}
					
					if(fp6[i].equals(""))
					{
						fp6[i]="0";
					}
					System.out.println("output: "+case6[i]+","+pcs6[i]+","+fp6[i]);
					double total=(Double.parseDouble(case6[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs6[i]) +Double.parseDouble(fp6[i]));
					//System.out.println("Total value: "+total);
					
					sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+voucherno+"','"+nameofitems6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+mrp6[i]+"','"+rate6[i]+"','"+discs6[i]+"','"+dis6[i]+"','"+amount6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
				
					System.out.println(sql);
					
					result1=ConnectionDAO.executeUpdate(stm, sql);
					
					scase=Double.parseDouble(ccase) - Double.parseDouble(case6[i]);
					spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs6[i]) + Double.parseDouble(fp6[i]));
					stotal=Double.parseDouble(ctotal) - total;
					
					 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
					System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm, sql);
				}
				
			}
			catch(Exception g)
			{
				System.out.println("error on counter sales "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String materialcode="",x="";
				String sql="";
				String v="VD";
				int cmat=0;
				 String mcode="",matcode="",matcode1="";
				 String v1="DS";
				 
				 String cdate=FormBean.getDate();
				 
				
				 String cdate1[]=cdate.split("-");
				 String yr=cdate1[0];
				 String mon=cdate1[1];
				 String day=cdate1[2];
				// System.out.println("date: "+cdate+","+yr+","+mon+","+day);
				 yr=yr.substring(2, 4);
				 //System.out.println("sub year: "+yr);
				int yr1=Integer.parseInt(yr)+1;
				v1=v1+yr+yr1+yr+mon+day;
				//System.out.println("bubun: "+v1);
					
				sql="select count(id) from itransaction";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						 cmat=rs.getInt(1);
					}
					
					if(cmat == 0)
					{
						matcode=mcode+"00"+(cmat+1);
					}
					else if(cmat > 0 && cmat < 9)
					{
						matcode=mcode+"00"+(cmat+1);
					}
					else if(cmat > 8 && cmat < 99)
					{
						matcode=mcode+"0"+(cmat+1);
					}
					else if(cmat > 98 && cmat < 999)
					{
						matcode=mcode+(cmat+1);
					}
					else if(cmat > 998 && cmat < 9999)
					{
						matcode=mcode+(cmat+1);
						
					}
					 matcode1=v1+matcode;
				//System.out.println("hii"+matcode1);
					sql="insert into itransaction(voucherno,vouchertype,area,entrydate,sman_name,rname,address,memo,totalamt1,packing,case1,pcs1,total,total_discount,gross_amt,discount,sub_total,sgst,cgst,igst,total_rs,gst_amt,r_off,add1,net_amt)values( '"+matcode1+"','"
					+"DS"+"','"
					+FormBean.getNameofarea()+"','"
					+FormBean.getDate()+"','"
					+FormBean.getSalesmanname()+"','"
					+FormBean.getRetailername()+"','"
					+FormBean.getAddress()+"','"
					+FormBean.getMemo()+"','"
					+FormBean.getTotalamt()+"','"
					+FormBean.getPacking()+"','"
					+FormBean.getCasee()+"','"
					+FormBean.getPcss()+"','"
					+FormBean.getTotal()+"','"
					+FormBean.getDiscount()+"','"
					+FormBean.getGamount()+"','"
					+FormBean.getDiscount1()+"','"
					+FormBean.getSubtotal()+"','"
					+FormBean.getSgst()+"','"
					+FormBean.getCgst()+"','"
					+FormBean.getIgst()+"','"
					+FormBean.getTotalamtrs()+"','"
					+FormBean.getGstamount()+"','"
					+FormBean.getRoundoff()+"','"
					+FormBean.getAdd()+"','"
					+FormBean.getNetamount()+"')";
					System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm,sql);
					//int total=0;
					
					String nameofitems[]=FormBean.getNameofitems();
					String case1[]=FormBean.getCase4(),pcs1[]=FormBean.getPcs4(),fp1[]=FormBean.getFp();
					String mrp1[]=FormBean.getMrp4(),rate1[]=FormBean.getRate(),discs[]=FormBean.getDiscs(),dis1[]=FormBean.getDis(),amount1[]=FormBean.getAmount4();
					String dis_amount[]=FormBean.getTotal11(),remain_amount[]=FormBean.getTodiscount(),tax_amount[]=FormBean.getTytax(),gst_amount[]=FormBean.getGstper();
					//System.out.println("hi: "+nameofitems.length);
					for(int i=0;i<nameofitems.length;i++)
					{
						String packing="",ccase="",cpcs="",ctotal="";
						double scase=0,spcs=0,stotal=0;
						
						//System.out.println("hello");
						sql="select packing,matcode from materialmaster where matname='"+nameofitems[i]+"'";
						System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							packing=rs.getString(1);
							materialcode=rs.getString(2);
						
							System.out.println("Packng: "+packing+","+materialcode);
						}
						sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							
							ccase=rs.getString(1);
							cpcs=rs.getString(2);
							ctotal=rs.getString(3);
							//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
						}
						
						if(fp1[i].equals(""))
						{
							fp1[i]="0";
						}
						System.out.println("output: "+case1[i]+","+pcs1[i]+","+fp1[i]);
						double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(fp1[i]));
						//System.out.println("Total value: "+total);
						
						sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+matcode1+"','"+nameofitems[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+mrp1[i]+"','"+rate1[i]+"','"+discs[i]+"','"+dis1[i]+"','"+amount1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
					
						System.out.println(sql);
						
						result1=ConnectionDAO.executeUpdate(stm, sql);
						
						scase=Double.parseDouble(ccase) - Double.parseDouble(case1[i]);
						spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs1[i]) + Double.parseDouble(fp1[i]));
						stotal=Double.parseDouble(ctotal) - total;
						
						 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						 System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm, sql);
					}
					
					
				
			}
			catch(Exception a)
			{
				System.out.println("error on salesman creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result1;
	}
	
	
	
	//dsalesmemoupdate
	
	
	public static FormBean dsalesmemeoupdate(int id)
	{
		FormBean usBean=new FormBean();
		
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String voucherno="";
		try
		{
			String sql="select voucherno from itransaction where id= '"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			//System.out.println(voucherno);
			
			
			 sql="select * from itransaction where voucherno='"+voucherno+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			
			
		
			
			
			while(rs.next())
			{
				areaname=rs.getString(7);
				//System.out.println("Ram: "+rs.getString(7));
				usBean.setId(rs.getInt(1));
				usBean.setNameofarea(rs.getString(4));
				usBean.setDate(rs.getString(5));
				usBean.setSalesmanname(rs.getString(6));
				usBean.setRetailername(rs.getString(7));
				usBean.setAddress(rs.getString(8));
				usBean.setMemo(rs.getString(9));
				usBean.setTotalamt(rs.getString(10));
				/*usBean.setPacking(rs.getString(11));
				usBean.setCasee(rs.getString(12));
				usBean.setPcss(rs.getString(13));
				usBean.setTotal(rs.getString(14));*/
				usBean.setDiscount(rs.getString(15));
				usBean.setGamount(rs.getString(16));
				usBean.setDiscount1(rs.getString(17));
				usBean.setSubtotal(rs.getString(18));
				usBean.setSgst(rs.getString(19));
				usBean.setCgst(rs.getString(20));
				usBean.setIgst(rs.getString(21));
				usBean.setTotalamtrs(rs.getString(22));
				usBean.setGstamount(rs.getString(23));
				usBean.setRoundoff(rs.getString(24));
				usBean.setAdd(rs.getString(25));
				usBean.setNetamount(rs.getString(26));
				
				
			}
			 sql="select placename from placemaster where placecode=(select area from itransaction where voucherno='"+voucherno+"' )";
			//System.out.println(sql);
			 rs=stm.executeQuery(sql);
			
				while(rs.next())
				{
					areaname1=rs.getString(1);
					usBean.setNameofarea1(rs.getString(1));
					
				}
				 sql="select smname from areasalesmanmaster where smcode=(select sman_name from itransaction where voucherno='"+voucherno+"' )";
					//System.out.println(sql);
					 rs=stm.executeQuery(sql);
					
						while(rs.next())
						{
							usBean.setSalesmanname1(rs.getString(1));
							
						}
						sql="select party_name from partymaster1 where party_code=(select rname from itransaction where voucherno='"+voucherno+"' )";
						//System.out.println(sql);
						 rs=stm.executeQuery(sql);
						
							while(rs.next())
							{
								areaname=rs.getString(1);
								System.out.println("partyname: "+areaname);
								usBean.setRetailername1(rs.getString(1));
								
							}
			
			Vector<String> nameofitems=new Vector<String>();
			Vector<String> case1=new Vector<String>();
			Vector<String> pcs=new Vector<String>();
			Vector<String> fp=new Vector<String>();
			Vector<String> mrp=new Vector<String>();
			Vector<String> rate=new Vector<String>();
			Vector<String> discs=new Vector<String>();
			Vector<String> dispercent=new Vector<String>();
			Vector<String> amount=new Vector<String>();
			//Vector<String> tytax=new Vector<String>();
			Vector<String> disamount=new Vector<String>();
			Vector<String> remainamount=new Vector<String>();
			Vector<String> taxamount=new Vector<String>();
			Vector<String> gstamount=new Vector<String>();
			
			
			
			sql="select * from idetails where voucherno='"+voucherno+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				nameofitems.add(rs.getString(3));
				case1.add(rs.getString(4));
				pcs.add(rs.getString(5));
				fp.add(rs.getString(6));
				mrp.add(rs.getString(7));
				rate.add(rs.getString(8));
				discs.add(rs.getString(9));
				dispercent.add(rs.getString(10));
				amount.add(rs.getString(11));
				disamount.add(rs.getString(16));
				remainamount.add(rs.getString(17));
				taxamount.add(rs.getString(18));
				gstamount.add(rs.getString(19));
				
				
			
			
			}
			
			String nameofitems1[]= new String[nameofitems.size()];
			String case2[]= new String[case1.size()];
			String pcs1[]= new String[pcs.size()];
			String fp1[]= new String[fp.size()];
			String mrp1[]= new String[mrp.size()];
			String rate1[]= new String[rate.size()];
			String discs1[]= new String[discs.size()];
			String dispercent1[]= new String[dispercent.size()];
			String amount1[]= new String[amount.size()];
			String disamount1[]= new String[disamount.size()];
			String remainamount1[]= new String[remainamount.size()];
			String taxamount1[]= new String[taxamount.size()];
			String gstamount1[]= new String[gstamount.size()];
			
			
			for(int i=0;i<nameofitems.size();i++)
			{
				nameofitems1[i]=nameofitems.get(i);
				//System.out.println("material name: "+nameofitems1[i]);
				case2[i]=case1.get(i);
				pcs1[i]=pcs.get(i);
				fp1[i]=fp.get(i);
				mrp1[i]=mrp.get(i);
				rate1[i]=rate.get(i);
				discs1[i]=discs.get(i);
				dispercent1[i]=dispercent.get(i);
				amount1[i]=amount.get(i);
				disamount1[i]=disamount.get(i);
				remainamount1[i]=remainamount.get(i);
				taxamount1[i]=taxamount.get(i);
				gstamount1[i]=gstamount.get(i);
				System.out.println("amount: "+disamount.get(i)+","+remainamount.get(i)+","+taxamount.get(i)+","+gstamount.get(i));
			
			}
			
			usBean.setNameofitems(nameofitems1);
			usBean.setCase4(case2);
			usBean.setPcs4(pcs1);
			usBean.setFp(fp1);
			usBean.setMrp4(mrp1);
			usBean.setRate(rate1);
			usBean.setDiscs(discs1);
			usBean.setDis(dispercent1);
			usBean.setAmount4(amount1);
    		usBean.setTotal11(disamount1);
	        usBean.setTodiscount(remainamount1);
	        usBean.setTytax(taxamount1);
	        usBean.setGstper(gstamount1);
		}
		catch(Exception a)
		{
			System.out.println("error on sales man edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}

//dsalesmemeodelete
	
	public static FormBean dsalesmemeodelete(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		boolean result1 = false;
		
		String voucherno="";
		try
		{
			String sql="select voucherno from itransaction where id= '"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			System.out.println(voucherno);
			
			
			 sql="delete from itransaction where voucherno='"+voucherno+"'";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="delete from idetails where voucherno='"+voucherno+"' ";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			
		}
		catch(Exception a)
		{
			System.out.println("error on selememodelete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}

	//salesmemeoentry
	public static List<FormBean> salesmemeoentry(FormBean formbean)
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);	
			ResultSet rs;
			String sql="";
			try
			{
				int sr=1;
				sql="select * from itransaction where voucherno like 'CD%' order by id desc";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					FormBean x=new FormBean();
					x.setId(rs.getInt(1));
					x.setNameofarea(rs.getString(3));
					x.setSalesmanname(rs.getString(5));
					
					x.setRetailername(rs.getString(6));
					x.setMemo(rs.getString(8));
					System.out.println(rs.getString(3)+"concat"+rs.getString(5)+"concat"+rs.getString(6)+"concat"+rs.getString(8));
				
				//	x.setCompany(findledger(rs.getString(5)));
					l1.add(x);
					
				}
			}
			catch(Exception c)
			{
				System.out.println("error on salesman list "+c);
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
		
		
		
		
		//salesmemocreation
		
		public static boolean salesmemeocreation(FormBean FormBean) 
		{
			boolean result1 = false;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			String voucherno="";
			if(FormBean.getId() != null)
			{
				try
				{
					//System.out.println("hello");
					String sql="update itransaction set area='"+FormBean.getNameofarea()+"', entrydate='"+FormBean.getDate()+"',sman_name='"+FormBean.getSalesmanname()+"',rname='"+FormBean.getRetailername()+"', address='"+FormBean.getAddress()+"',memo='"+FormBean.getMemo()+"',totalamt1='"+FormBean.getTotalamt()+"',packing='"+FormBean.getPacking()+"',case1='"+FormBean.getCasee()+"',pcs1='"+FormBean.getPcss()+"',total='"+FormBean.getTotal()+"',total_discount='"+FormBean.getDiscount()+"',gross_amt='"+FormBean.getGamount()+"',discount='"+FormBean.getDiscount1()+"',sub_total='"+FormBean.getSubtotal()+"',sgst='"+FormBean.getSgst()+"',cgst='"+FormBean.getCgst()+"',igst='"+FormBean.getIgst()+"',total_rs='"+FormBean.getTotalamtrs()+"',gst_amt='"+FormBean.getGstamount()+"',r_off='"+FormBean.getRoundoff()+"',add1='"+FormBean.getAdd()+"',net_amt='"+FormBean.getNetamount()+"' where id='"+FormBean.getId()+"'";
					
					//System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						voucherno=rs.getString(1);
					}
					
					sql="delete from idetails where voucherno='"+voucherno+"' ";
					//System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm, sql);
					String nameofitems6[]=FormBean.getNameofitems1();
					//System.out.println("length: "+nameofitems6.length);
					String materialcode="";
					String	case6[]=FormBean.getCase5(),pcs6[]=FormBean.getPcs5(),fp6[]=FormBean.getFp1(),mrp6[]=FormBean.getMrp5(),rate6[]=FormBean.getRate4(),discs6[]=FormBean.getDiscs4(),dis6[]=FormBean.getDis4(),amount6[]=FormBean.getAmount5();
					String dis_amount[]=FormBean.getTotal111(),remain_amount[]=FormBean.getTodiscount1(),tax_amount[]=FormBean.getTytax1(),gst_amount[]=FormBean.getGstper1();
					
					
					for(int i=0;i<nameofitems6.length;i++)
					{
						String packing="",ccase="",cpcs="",ctotal="";
						double scase=0,spcs=0,stotal=0;
						
						//System.out.println("hello");
						sql="select packing,matcode from materialmaster where matname='"+nameofitems6[i]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							packing=rs.getString(1);
							materialcode=rs.getString(2);
						
							//System.out.println("Packng: "+packing+","+materialcode);
						}
						sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							
							ccase=rs.getString(1);
							cpcs=rs.getString(2);
							ctotal=rs.getString(3);
							//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
						}
						
						if(fp6[i].equals(""))
						{
							fp6[i]="0";
						}
						//System.out.println("output: "+case6[i]+","+pcs6[i]+","+fp6[i]);
						double total=(Double.parseDouble(case6[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs6[i]) +Double.parseDouble(fp6[i]));
						//System.out.println("Total value: "+total);
						
						sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+voucherno+"','"+nameofitems6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+mrp6[i]+"','"+rate6[i]+"','"+discs6[i]+"','"+dis6[i]+"','"+amount6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
					
						//System.out.println(sql);
						
						result1=ConnectionDAO.executeUpdate(stm, sql);
						
						scase=Double.parseDouble(ccase) - Double.parseDouble(case6[i]);
						spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs6[i]) + Double.parseDouble(fp6[i]));
						stotal=Double.parseDouble(ctotal) - total;
						
						 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
						 //System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm, sql);
					}
					
				}
				catch(Exception g)
				{
					System.out.println("error on counter sales "+g);
				}
			}
			else
			{
				try
				{
					int id=0;
					String materialcode="",x="";
					String sql="";
					String v="VD";
					int cmat=0;
					 String mcode="",matcode="",matcode1="";
					 String v1="CD";
					 
					 String cdate=FormBean.getDate();
					 
					
					 String cdate1[]=cdate.split("-");
					 String yr=cdate1[0];
					 String mon=cdate1[1];
					 String day=cdate1[2];
					// System.out.println("date: "+cdate+","+yr+","+mon+","+day);
					 yr=yr.substring(2, 4);
					 //System.out.println("sub year: "+yr);
					int yr1=Integer.parseInt(yr)+1;
					v1=v1+yr+yr1+yr+mon+day;
					//System.out.println("bubun: "+v1);
						
					sql="select count(id) from itransaction";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							 cmat=rs.getInt(1);
						}
						
						if(cmat == 0)
						{
							matcode=mcode+"00"+(cmat+1);
						}
						else if(cmat > 0 && cmat < 9)
						{
							matcode=mcode+"00"+(cmat+1);
						}
						else if(cmat > 8 && cmat < 99)
						{
							matcode=mcode+"0"+(cmat+1);
						}
						else if(cmat > 98 && cmat < 999)
						{
							matcode=mcode+(cmat+1);
						}
						else if(cmat > 998 && cmat < 9999)
						{
							matcode=mcode+(cmat+1);
							
						}
						 matcode1=v1+matcode;
					//System.out.println("hii"+matcode1);
						sql="insert into itransaction(voucherno,vouchertype,area,entrydate,sman_name,rname,address,memo,totalamt1,packing,case1,pcs1,total,total_discount,gross_amt,discount,sub_total,sgst,cgst,igst,total_rs,gst_amt,r_off,add1,net_amt)values( '"+matcode1+"','"
						+"CD"+"','"
						+FormBean.getNameofarea()+"','"
						+FormBean.getDate()+"','"
						+FormBean.getSalesmanname()+"','"
						+FormBean.getRetailername()+"','"
						+FormBean.getAddress()+"','"
						+FormBean.getMemo()+"','"
						+FormBean.getTotalamt()+"','"
						+FormBean.getPacking()+"','"
						+FormBean.getCasee()+"','"
						+FormBean.getPcss()+"','"
						+FormBean.getTotal()+"','"
						+FormBean.getDiscount()+"','"
						+FormBean.getGamount()+"','"
						+FormBean.getDiscount1()+"','"
						+FormBean.getSubtotal()+"','"
						+FormBean.getSgst()+"','"
						+FormBean.getCgst()+"','"
						+FormBean.getIgst()+"','"
						+FormBean.getTotalamtrs()+"','"
						+FormBean.getGstamount()+"','"
						+FormBean.getRoundoff()+"','"
						+FormBean.getAdd()+"','"
						+FormBean.getNetamount()+"')";
						//System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm,sql);
						//int total=0;
						
						String nameofitems[]=FormBean.getNameofitems();
						String case1[]=FormBean.getCase4(),pcs1[]=FormBean.getPcs4(),fp1[]=FormBean.getFp();
						String mrp1[]=FormBean.getMrp4(),rate1[]=FormBean.getRate(),discs[]=FormBean.getDiscs(),dis1[]=FormBean.getDis(),amount1[]=FormBean.getAmount4();
						String dis_amount[]=FormBean.getTotal11(),remain_amount[]=FormBean.getTodiscount(),tax_amount[]=FormBean.getTytax(),gst_amount[]=FormBean.getGstper();
						//System.out.println("hi: "+nameofitems.length);
						for(int i=0;i<nameofitems.length;i++)
						{
							String packing="",ccase="",cpcs="",ctotal="";
							double scase=0,spcs=0,stotal=0;
							
							//System.out.println("hello");
							sql="select packing,matcode from materialmaster where matname='"+nameofitems[i]+"'";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								packing=rs.getString(1);
								materialcode=rs.getString(2);
							
								System.out.println("Packng: "+packing+","+materialcode);
							}
							sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								
								ccase=rs.getString(1);
								cpcs=rs.getString(2);
								ctotal=rs.getString(3);
								//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
							}
							
							if(fp1[i].equals(""))
							{
								fp1[i]="0";
							}
							//System.out.println("output: "+case1[i]+","+pcs1[i]+","+fp1[i]);
							double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(fp1[i]));
							//System.out.println("Total value: "+total);
							
							sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+matcode1+"','"+nameofitems[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+mrp1[i]+"','"+rate1[i]+"','"+discs[i]+"','"+dis1[i]+"','"+amount1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
						
							//System.out.println(sql);
							
							result1=ConnectionDAO.executeUpdate(stm, sql);
							
							scase=Double.parseDouble(ccase) - Double.parseDouble(case1[i]);
							spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs1[i]) + Double.parseDouble(fp1[i]));
							stotal=Double.parseDouble(ctotal) - total;
							
							 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
							// System.out.println(sql);
							result1=ConnectionDAO.executeUpdate(stm, sql);
						}
						
						
					
				}
				catch(Exception a)
				{
					System.out.println("error on salesman creation "+a);
				}
			}
			ConnectionDAO.closeConnection(conn);
			return result1;
		}
		
		
		
		//salesmemoupdate
		
		
		public static FormBean salesmemeoupdate(int id)
		{
			FormBean usBean=new FormBean();
			
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			String voucherno="";
			try
			{
				String sql="select voucherno from itransaction where id= '"+id+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				//System.out.println(voucherno);
				
				
				 sql="select * from itransaction where voucherno='"+voucherno+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				
				
			
				
				
				while(rs.next())
				{
					areaname=rs.getString(7);
					//System.out.println("Ram: "+rs.getString(7));
					usBean.setId(rs.getInt(1));
					usBean.setNameofarea(rs.getString(4));
					usBean.setDate(rs.getString(5));
					usBean.setSalesmanname(rs.getString(6));
					usBean.setRetailername(rs.getString(7));
					usBean.setAddress(rs.getString(8));
					usBean.setMemo(rs.getString(9));
					usBean.setTotalamt(rs.getString(10));
					/*usBean.setPacking(rs.getString(11));
					usBean.setCasee(rs.getString(12));
					usBean.setPcss(rs.getString(13));
					usBean.setTotal(rs.getString(14));*/
					usBean.setDiscount(rs.getString(15));
					usBean.setGamount(rs.getString(16));
					usBean.setDiscount1(rs.getString(17));
					usBean.setSubtotal(rs.getString(18));
					usBean.setSgst(rs.getString(19));
					usBean.setCgst(rs.getString(20));
					usBean.setIgst(rs.getString(21));
					usBean.setTotalamtrs(rs.getString(22));
					usBean.setGstamount(rs.getString(23));
					usBean.setRoundoff(rs.getString(24));
					usBean.setAdd(rs.getString(25));
					usBean.setNetamount(rs.getString(26));
					
					
				}
				 sql="select placename from placemaster where placecode=(select area from itransaction where voucherno='"+voucherno+"' )";
				//System.out.println(sql);
				 rs=stm.executeQuery(sql);
				
					while(rs.next())
					{
						areaname1=rs.getString(1);
						usBean.setNameofarea1(rs.getString(1));
						
					}
					 sql="select smname from areasalesmanmaster where smcode=(select sman_name from itransaction where voucherno='"+voucherno+"' )";
						//System.out.println(sql);
						 rs=stm.executeQuery(sql);
						
							while(rs.next())
							{
								usBean.setSalesmanname1(rs.getString(1));
								
							}
							sql="select party_name from partymaster1 where party_code=(select rname from itransaction where voucherno='"+voucherno+"' )";
							//System.out.println(sql);
							 rs=stm.executeQuery(sql);
							
								while(rs.next())
								{
									areaname=rs.getString(1);
									System.out.println("partyname: "+areaname);
									usBean.setRetailername1(rs.getString(1));
									
								}
				
				Vector<String> nameofitems=new Vector<String>();
				Vector<String> case1=new Vector<String>();
				Vector<String> pcs=new Vector<String>();
				Vector<String> fp=new Vector<String>();
				Vector<String> mrp=new Vector<String>();
				Vector<String> rate=new Vector<String>();
				Vector<String> discs=new Vector<String>();
				Vector<String> dispercent=new Vector<String>();
				Vector<String> amount=new Vector<String>();
				//Vector<String> tytax=new Vector<String>();
				Vector<String> disamount=new Vector<String>();
				Vector<String> remainamount=new Vector<String>();
				Vector<String> taxamount=new Vector<String>();
				Vector<String> gstamount=new Vector<String>();
				
				
				
				sql="select * from idetails where voucherno='"+voucherno+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					nameofitems.add(rs.getString(3));
					case1.add(rs.getString(4));
					pcs.add(rs.getString(5));
					fp.add(rs.getString(6));
					mrp.add(rs.getString(7));
					rate.add(rs.getString(8));
					discs.add(rs.getString(9));
					dispercent.add(rs.getString(10));
					amount.add(rs.getString(11));
					disamount.add(rs.getString(16));
					remainamount.add(rs.getString(17));
					taxamount.add(rs.getString(18));
					gstamount.add(rs.getString(19));
					
					
				
				
				}
				
				String nameofitems1[]= new String[nameofitems.size()];
				String case2[]= new String[case1.size()];
				String pcs1[]= new String[pcs.size()];
				String fp1[]= new String[fp.size()];
				String mrp1[]= new String[mrp.size()];
				String rate1[]= new String[rate.size()];
				String discs1[]= new String[discs.size()];
				String dispercent1[]= new String[dispercent.size()];
				String amount1[]= new String[amount.size()];
				String disamount1[]= new String[disamount.size()];
				String remainamount1[]= new String[remainamount.size()];
				String taxamount1[]= new String[taxamount.size()];
				String gstamount1[]= new String[gstamount.size()];
				
				
				for(int i=0;i<nameofitems.size();i++)
				{
					nameofitems1[i]=nameofitems.get(i);
					//System.out.println("material name: "+nameofitems1[i]);
					case2[i]=case1.get(i);
					pcs1[i]=pcs.get(i);
					fp1[i]=fp.get(i);
					mrp1[i]=mrp.get(i);
					rate1[i]=rate.get(i);
					discs1[i]=discs.get(i);
					dispercent1[i]=dispercent.get(i);
					amount1[i]=amount.get(i);
					disamount1[i]=disamount.get(i);
					remainamount1[i]=remainamount.get(i);
					taxamount1[i]=taxamount.get(i);
					gstamount1[i]=gstamount.get(i);
					System.out.println("amount: "+disamount.get(i)+","+remainamount.get(i)+","+taxamount.get(i)+","+gstamount.get(i));
				
				}
				
				usBean.setNameofitems(nameofitems1);
				usBean.setCase4(case2);
				usBean.setPcs4(pcs1);
				usBean.setFp(fp1);
				usBean.setMrp4(mrp1);
				usBean.setRate(rate1);
				usBean.setDiscs(discs1);
				usBean.setDis(dispercent1);
				usBean.setAmount4(amount1);
	    		usBean.setTotal11(disamount1);
		        usBean.setTodiscount(remainamount1);
		        usBean.setTytax(taxamount1);
		        usBean.setGstper(gstamount1);
			}
			catch(Exception a)
			{
				System.out.println("error on sales man edit "+a);
			}
			ConnectionDAO.closeConnection(conn);
			return usBean;
		}

	//salesmemeodelete
		
		public static FormBean salesmemeodelete(int id)
		{
			FormBean usBean=new FormBean();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			boolean result1 = false;
			
			String voucherno="";
			try
			{
				String sql="select voucherno from itransaction where id= '"+id+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				System.out.println(voucherno);
				
				
				 sql="delete from itransaction where voucherno='"+voucherno+"'";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="delete from idetails where voucherno='"+voucherno+"' ";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
			}
			catch(Exception a)
			{
				System.out.println("error on salememodelete "+a);
			}
			ConnectionDAO.closeConnection(conn);
			return usBean;
		}
	

	//msalesmemeoentry
	public static List<FormBean> msalesmemeoentry(FormBean formbean)
		{
			List<FormBean> l1 = new ArrayList<FormBean>();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);	
			ResultSet rs;
			String sql="";
			try
			{
				int sr=1;
				sql="select * from itransaction where voucherno like 'OT%' order by id desc";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					FormBean x=new FormBean();
					x.setId(rs.getInt(1));
					x.setNameofarea(rs.getString(3));
					x.setSalesmanname(rs.getString(5));
					
					x.setRetailername(rs.getString(6));
					x.setMemo(rs.getString(8));
					System.out.println(rs.getString(3)+"concat"+rs.getString(5)+"concat"+rs.getString(6)+"concat"+rs.getString(8));
				
				//	x.setCompany(findledger(rs.getString(5)));
					l1.add(x);
					
				}
			}
			catch(Exception c)
			{
				System.out.println("error on salesman list "+c);
			}
			ConnectionDAO.closeConnection(conn);
			return l1;
		}
		
		
		
		
		//msalesmemocreation
		
		public static boolean msalesmemeocreation(FormBean FormBean) 
		{
			boolean result1 = false;
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			String voucherno="";
			if(FormBean.getId() != null)
			{
				try
				{
					//System.out.println("hello");
					String sql="update itransaction set area='"+FormBean.getNameofarea()+"', entrydate='"+FormBean.getDate()+"',sman_name='"+FormBean.getSalesmanname()+"',rname='"+FormBean.getRetailername()+"', address='"+FormBean.getAddress()+"',memo='"+FormBean.getMemo()+"',totalamt1='"+FormBean.getTotalamt()+"',packing='"+FormBean.getPacking()+"',case1='"+FormBean.getCasee()+"',pcs1='"+FormBean.getPcss()+"',total='"+FormBean.getTotal()+"',total_discount='"+FormBean.getDiscount()+"',gross_amt='"+FormBean.getGamount()+"',discount='"+FormBean.getDiscount1()+"',sub_total='"+FormBean.getSubtotal()+"',sgst='"+FormBean.getSgst()+"',cgst='"+FormBean.getCgst()+"',igst='"+FormBean.getIgst()+"',total_rs='"+FormBean.getTotalamtrs()+"',gst_amt='"+FormBean.getGstamount()+"',r_off='"+FormBean.getRoundoff()+"',add1='"+FormBean.getAdd()+"',net_amt='"+FormBean.getNetamount()+"' where id='"+FormBean.getId()+"'";
					
					//System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						voucherno=rs.getString(1);
					}
					
					sql="delete from idetails where voucherno='"+voucherno+"' ";
					//System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm, sql);
					String nameofitems6[]=FormBean.getNameofitems1();
					//System.out.println("length: "+nameofitems6.length);
					String materialcode="";
					String	case6[]=FormBean.getCase5(),pcs6[]=FormBean.getPcs5(),fp6[]=FormBean.getFp1(),mrp6[]=FormBean.getMrp5(),rate6[]=FormBean.getRate4(),discs6[]=FormBean.getDiscs4(),dis6[]=FormBean.getDis4(),amount6[]=FormBean.getAmount5();
					String dis_amount[]=FormBean.getTotal111(),remain_amount[]=FormBean.getTodiscount1(),tax_amount[]=FormBean.getTytax1(),gst_amount[]=FormBean.getGstper1();
					
					
					for(int i=0;i<nameofitems6.length;i++)
					{
						String packing="",ccase="",cpcs="",ctotal="";
						double scase=0,spcs=0,stotal=0;
						
						//System.out.println("hello");
						sql="select packing,matcode from materialmaster where matname='"+nameofitems6[i]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							packing=rs.getString(1);
							materialcode=rs.getString(2);
						
							//System.out.println("Packng: "+packing+","+materialcode);
						}
						sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							
							ccase=rs.getString(1);
							cpcs=rs.getString(2);
							ctotal=rs.getString(3);
							//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
						}
						
						if(fp6[i].equals(""))
						{
							fp6[i]="0";
						}
						//System.out.println("output: "+case6[i]+","+pcs6[i]+","+fp6[i]);
						double total=(Double.parseDouble(case6[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs6[i]) +Double.parseDouble(fp6[i]));
						//System.out.println("Total value: "+total);
						
						sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+voucherno+"','"+nameofitems6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+mrp6[i]+"','"+rate6[i]+"','"+discs6[i]+"','"+dis6[i]+"','"+amount6[i]+"','"+case6[i]+"','"+pcs6[i]+"','"+fp6[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
					
						//System.out.println(sql);
						
						result1=ConnectionDAO.executeUpdate(stm, sql);
						
						scase=Double.parseDouble(ccase) - Double.parseDouble(case6[i]);
						spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs6[i]) + Double.parseDouble(fp6[i]));
						stotal=Double.parseDouble(ctotal) - total;
						
						 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp6[i]+"'";
						 //System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm, sql);
					}
					
				}
				catch(Exception g)
				{
					System.out.println("error on counter sales "+g);
				}
			}
			else
			{
				try
				{
					int id=0;
					String materialcode="",x="";
					String sql="";
					String v="VD";
					int cmat=0;
					 String mcode="",matcode="",matcode1="";
					 String v1="OT";
					 
					 String cdate=FormBean.getDate();
					 
					
					 String cdate1[]=cdate.split("-");
					 String yr=cdate1[0];
					 String mon=cdate1[1];
					 String day=cdate1[2];
					// System.out.println("date: "+cdate+","+yr+","+mon+","+day);
					 yr=yr.substring(2, 4);
					 //System.out.println("sub year: "+yr);
					int yr1=Integer.parseInt(yr)+1;
					v1=v1+yr+yr1+yr+mon+day;
					//System.out.println("bubun: "+v1);
						
					sql="select count(id) from itransaction";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							 cmat=rs.getInt(1);
						}
						
						if(cmat == 0)
						{
							matcode=mcode+"00"+(cmat+1);
						}
						else if(cmat > 0 && cmat < 9)
						{
							matcode=mcode+"00"+(cmat+1);
						}
						else if(cmat > 8 && cmat < 99)
						{
							matcode=mcode+"0"+(cmat+1);
						}
						else if(cmat > 98 && cmat < 999)
						{
							matcode=mcode+(cmat+1);
						}
						else if(cmat > 998 && cmat < 9999)
						{
							matcode=mcode+(cmat+1);
							
						}
						 matcode1=v1+matcode;
					//System.out.println("hii"+matcode1);
						sql="insert into itransaction(voucherno,vouchertype,area,entrydate,sman_name,rname,address,memo,totalamt1,packing,case1,pcs1,total,total_discount,gross_amt,discount,sub_total,sgst,cgst,igst,total_rs,gst_amt,r_off,add1,net_amt)values( '"+matcode1+"','"
						+"OT"+"','"
						+FormBean.getNameofarea()+"','"
						+FormBean.getDate()+"','"
						+FormBean.getSalesmanname()+"','"
						+FormBean.getRetailername()+"','"
						+FormBean.getAddress()+"','"
						+FormBean.getMemo()+"','"
						+FormBean.getTotalamt()+"','"
						+FormBean.getPacking()+"','"
						+FormBean.getCasee()+"','"
						+FormBean.getPcss()+"','"
						+FormBean.getTotal()+"','"
						+FormBean.getDiscount()+"','"
						+FormBean.getGamount()+"','"
						+FormBean.getDiscount1()+"','"
						+FormBean.getSubtotal()+"','"
						+FormBean.getSgst()+"','"
						+FormBean.getCgst()+"','"
						+FormBean.getIgst()+"','"
						+FormBean.getTotalamtrs()+"','"
						+FormBean.getGstamount()+"','"
						+FormBean.getRoundoff()+"','"
						+FormBean.getAdd()+"','"
						+FormBean.getNetamount()+"')";
						//System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm,sql);
						//int total=0;
						
						String nameofitems[]=FormBean.getNameofitems();
						String case1[]=FormBean.getCase4(),pcs1[]=FormBean.getPcs4(),fp1[]=FormBean.getFp();
						String mrp1[]=FormBean.getMrp4(),rate1[]=FormBean.getRate(),discs[]=FormBean.getDiscs(),dis1[]=FormBean.getDis(),amount1[]=FormBean.getAmount4();
						String dis_amount[]=FormBean.getTotal11(),remain_amount[]=FormBean.getTodiscount(),tax_amount[]=FormBean.getTytax(),gst_amount[]=FormBean.getGstper();
						//System.out.println("hi: "+nameofitems.length);
						for(int i=0;i<nameofitems.length;i++)
						{
							String packing="",ccase="",cpcs="",ctotal="";
							double scase=0,spcs=0,stotal=0;
							
							//System.out.println("hello");
							sql="select packing,matcode from materialmaster where matname='"+nameofitems[i]+"'";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								packing=rs.getString(1);
								materialcode=rs.getString(2);
							
								System.out.println("Packng: "+packing+","+materialcode);
							}
							sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								
								ccase=rs.getString(1);
								cpcs=rs.getString(2);
								ctotal=rs.getString(3);
								//System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
							}
							
							if(fp1[i].equals(""))
							{
								fp1[i]="0";
							}
							//System.out.println("output: "+case1[i]+","+pcs1[i]+","+fp1[i]);
							double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(fp1[i]));
							//System.out.println("Total value: "+total);
							
							sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+matcode1+"','"+nameofitems[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+mrp1[i]+"','"+rate1[i]+"','"+discs[i]+"','"+dis1[i]+"','"+amount1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
						
							//System.out.println(sql);
							
							result1=ConnectionDAO.executeUpdate(stm, sql);
							
							scase=Double.parseDouble(ccase) - Double.parseDouble(case1[i]);
							spcs=Double.parseDouble(cpcs) - (Double.parseDouble(pcs1[i]) + Double.parseDouble(fp1[i]));
							stotal=Double.parseDouble(ctotal) - total;
							
							 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
							// System.out.println(sql);
							result1=ConnectionDAO.executeUpdate(stm, sql);
						}
						
						
					
				}
				catch(Exception a)
				{
					System.out.println("error on salesman creation "+a);
				}
			}
			ConnectionDAO.closeConnection(conn);
			return result1;
		}
		
		
		
		//msalesmemoupdate
		
		
		public static FormBean msalesmemeoupdate(int id)
		{
			FormBean usBean=new FormBean();
			
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			String voucherno="";
			try
			{
				String sql="select voucherno from itransaction where id= '"+id+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				//System.out.println(voucherno);
				
				
				 sql="select * from itransaction where voucherno='"+voucherno+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				
				
			
				
				
				while(rs.next())
				{
					areaname=rs.getString(7);
					//System.out.println("Ram: "+rs.getString(7));
					usBean.setId(rs.getInt(1));
					usBean.setNameofarea(rs.getString(4));
					usBean.setDate(rs.getString(5));
					usBean.setSalesmanname(rs.getString(6));
					usBean.setRetailername(rs.getString(7));
					usBean.setAddress(rs.getString(8));
					usBean.setMemo(rs.getString(9));
					usBean.setTotalamt(rs.getString(10));
					/*usBean.setPacking(rs.getString(11));
					usBean.setCasee(rs.getString(12));
					usBean.setPcss(rs.getString(13));
					usBean.setTotal(rs.getString(14));*/
					usBean.setDiscount(rs.getString(15));
					usBean.setGamount(rs.getString(16));
					usBean.setDiscount1(rs.getString(17));
					usBean.setSubtotal(rs.getString(18));
					usBean.setSgst(rs.getString(19));
					usBean.setCgst(rs.getString(20));
					usBean.setIgst(rs.getString(21));
					usBean.setTotalamtrs(rs.getString(22));
					usBean.setGstamount(rs.getString(23));
					usBean.setRoundoff(rs.getString(24));
					usBean.setAdd(rs.getString(25));
					usBean.setNetamount(rs.getString(26));
					
					
				}
				 sql="select placename from placemaster where placecode=(select area from itransaction where voucherno='"+voucherno+"' )";
				//System.out.println(sql);
				 rs=stm.executeQuery(sql);
				
					while(rs.next())
					{
						areaname1=rs.getString(1);
						usBean.setNameofarea1(rs.getString(1));
						
					}
					 sql="select smname from areasalesmanmaster where smcode=(select sman_name from itransaction where voucherno='"+voucherno+"' )";
						//System.out.println(sql);
						 rs=stm.executeQuery(sql);
						
							while(rs.next())
							{
								usBean.setSalesmanname1(rs.getString(1));
								
							}
							sql="select party_name from partymaster1 where party_code=(select rname from itransaction where voucherno='"+voucherno+"' )";
							//System.out.println(sql);
							 rs=stm.executeQuery(sql);
							
								while(rs.next())
								{
									areaname=rs.getString(1);
									System.out.println("partyname: "+areaname);
									usBean.setRetailername1(rs.getString(1));
									
								}
				
				Vector<String> nameofitems=new Vector<String>();
				Vector<String> case1=new Vector<String>();
				Vector<String> pcs=new Vector<String>();
				Vector<String> fp=new Vector<String>();
				Vector<String> mrp=new Vector<String>();
				Vector<String> rate=new Vector<String>();
				Vector<String> discs=new Vector<String>();
				Vector<String> dispercent=new Vector<String>();
				Vector<String> amount=new Vector<String>();
				//Vector<String> tytax=new Vector<String>();
				Vector<String> disamount=new Vector<String>();
				Vector<String> remainamount=new Vector<String>();
				Vector<String> taxamount=new Vector<String>();
				Vector<String> gstamount=new Vector<String>();
				
				
				
				sql="select * from idetails where voucherno='"+voucherno+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					nameofitems.add(rs.getString(3));
					case1.add(rs.getString(4));
					pcs.add(rs.getString(5));
					fp.add(rs.getString(6));
					mrp.add(rs.getString(7));
					rate.add(rs.getString(8));
					discs.add(rs.getString(9));
					dispercent.add(rs.getString(10));
					amount.add(rs.getString(11));
					disamount.add(rs.getString(16));
					remainamount.add(rs.getString(17));
					taxamount.add(rs.getString(18));
					gstamount.add(rs.getString(19));
					
					
				
				
				}
				
				String nameofitems1[]= new String[nameofitems.size()];
				String case2[]= new String[case1.size()];
				String pcs1[]= new String[pcs.size()];
				String fp1[]= new String[fp.size()];
				String mrp1[]= new String[mrp.size()];
				String rate1[]= new String[rate.size()];
				String discs1[]= new String[discs.size()];
				String dispercent1[]= new String[dispercent.size()];
				String amount1[]= new String[amount.size()];
				String disamount1[]= new String[disamount.size()];
				String remainamount1[]= new String[remainamount.size()];
				String taxamount1[]= new String[taxamount.size()];
				String gstamount1[]= new String[gstamount.size()];
				
				
				for(int i=0;i<nameofitems.size();i++)
				{
					nameofitems1[i]=nameofitems.get(i);
					//System.out.println("material name: "+nameofitems1[i]);
					case2[i]=case1.get(i);
					pcs1[i]=pcs.get(i);
					fp1[i]=fp.get(i);
					mrp1[i]=mrp.get(i);
					rate1[i]=rate.get(i);
					discs1[i]=discs.get(i);
					dispercent1[i]=dispercent.get(i);
					amount1[i]=amount.get(i);
					disamount1[i]=disamount.get(i);
					remainamount1[i]=remainamount.get(i);
					taxamount1[i]=taxamount.get(i);
					gstamount1[i]=gstamount.get(i);
					System.out.println("amount: "+disamount.get(i)+","+remainamount.get(i)+","+taxamount.get(i)+","+gstamount.get(i));
				
				}
				
				usBean.setNameofitems(nameofitems1);
				usBean.setCase4(case2);
				usBean.setPcs4(pcs1);
				usBean.setFp(fp1);
				usBean.setMrp4(mrp1);
				usBean.setRate(rate1);
				usBean.setDiscs(discs1);
				usBean.setDis(dispercent1);
				usBean.setAmount4(amount1);
	    		usBean.setTotal11(disamount1);
		        usBean.setTodiscount(remainamount1);
		        usBean.setTytax(taxamount1);
		        usBean.setGstper(gstamount1);
			}
			catch(Exception a)
			{
				System.out.println("error on sales man edit "+a);
			}
			ConnectionDAO.closeConnection(conn);
			return usBean;
		}

	//msalesmemeodelete
		
		public static FormBean msalesmemeodelete(int id)
		{
			FormBean usBean=new FormBean();
			Connection conn = ConnectionDAO.getConnectionObject();
			Statement stm = ConnectionDAO.createStatement(conn);
			ResultSet rs;
			boolean result1 = false;
			
			String voucherno="";
			try
			{
				String sql="select voucherno from itransaction where id= '"+id+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				System.out.println(voucherno);
				
				
				 sql="delete from itransaction where voucherno='"+voucherno+"'";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="delete from idetails where voucherno='"+voucherno+"' ";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
			}
			catch(Exception a)
			{
				System.out.println("error on salememodelete "+a);
			}
			ConnectionDAO.closeConnection(conn);
			return usBean;
		}
	
	
	public static List<FormBean> retailername(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		FormBean x;
		String sql="";
		try
		{
			
			
			sql="select party_name from partymaster1 where arcode=(select placecode from placemaster where placename='"+areaname1+"') ";
			System.out.println("ramm: "+sql);
			rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				
				x=new FormBean();
				//x.setPart1(" ");
				x.setPart1(rs.getString(1));
				//System.out.println("outputvalue2: "+rs.getString(1));
				//x.setSalesman(rs.getString(3));
				//System.out.println("got "+rs.getString(3));
				//x.setSalesmanname1(rs.getString(3));
				l1.add(x);
			}
			
		}
		catch(Exception c)
		{
			System.out.println("error on sales list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	public static List<FormBean> nameitem() 
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		String sql = "";
		//String sql1="select * from subgroupmaster";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		
		try 
			{
				sql="select matname from materialmaster";
				ResultSet rs = stm.executeQuery(sql);
				FormBean usBean=new FormBean();
				while (rs.next()) 
					{
					usBean = new FormBean();
					usBean.setPart(rs.getString(1));
					System.out.println(rs.getString(1));
					//usBean.setNname("");
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
	
	//salesmemodelete
	
	public static FormBean csalesmemeodelete(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		boolean result1 = false;
		
		String voucherno="";
		try
		{
			String sql="select voucherno from itransaction where id= '"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			System.out.println(voucherno);
			
			
			 sql="delete from itransaction where voucherno='"+voucherno+"'";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="delete from idetails where voucherno='"+voucherno+"' ";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			
		}
		catch(Exception a)
		{
			System.out.println("error on selememodelete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
	
	public static String findledger2(String xx)
	{
		String x3="",x1="";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try
		{
			String sql="select description from materialgroupmaster where groupcode='"+xx+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				x3=rs.getString(1);
			}
			//System.out.println("ledger name got "+x3);
		}
		catch(Exception hh)
		{
			System.out.println("error in findledger "+hh);
		}
		ConnectionDAO.closeConnection(conn);
		return x3;
	}

	public static List<FormBean> materialpaddarlist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from materialmaster order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setMaterialname(rs.getString(3));
			/*	x.setSname(rs.getString(3));*/
				x.setPacking(rs.getString(6));
				x.setSunit(rs.getString(7));
				/*x.setMfgcode(rs.getString(8));*/
				/*x.setPurchase1(rs.getString(11));*/
				/*x.setSalesac1(rs.getString(12));*/
				/*x.setValueaddedtax(rs.getString(13));*/
				/*x.setAgriculturetax(rs.getString(14));*/
				/*x.setHsn(rs.getString(15));*/
			/*	x.setMtype(rs.getString(16));
				x.setSize(rs.getString(17));*/
				x.setTcase(rs.getString(28));
				x.setTpcs(rs.getString(29));
				x.setTamount(rs.getString(30));
				x.setTypeoftax(rs.getString(23));
				x.setMaterialgroup(findledger2(rs.getString(27)));
			//	x.setCompany(findledger(rs.getString(5)));
				l1.add(x);
				
			}
		}
		catch(Exception c)
		{
			System.out.println("error on salesman list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	
	
	public static boolean paddarlistcreation1(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String matcode="";
		if(FormBean.getId() != null)
		{
			try
			{
				String sql="update materialmaster set matcode='"+FormBean.getMmcode()+"', matname='"+FormBean.getMaterialname()+"',msname='"+FormBean.getSname()+"',packing='"+FormBean.getPacking()+"',unit='"+FormBean.getSunit()+"', mfgcode='"+FormBean.getMfgcode()+"',pur_ac='"+FormBean.getPurcode()+"',sale_ac='"+FormBean.getSalecode()+"', v_tax='"+FormBean.getValueaddedtax()+"', agri_tax='"+FormBean.getAgriculturetax()+"', hsn_code='"+FormBean.getHsn()+"', m_type='"+FormBean.getMtype()+"',  size='"+FormBean.getSize()+"',sunit='"+FormBean.getUnitofitem()+"',scheme='"+FormBean.getScheme()+"', period='"+FormBean.getPeriod()+"',min_level='"+FormBean.getMininvlevel()+"', type_tax='"+FormBean.getTypeoftax()+"', value_stock='"+FormBean.getValueofstock()+"',surchar='"+FormBean.getSurchar()+"',company_code='"+FormBean.getCmpcode()+"',material_group='"+FormBean.getMaterialgroup1()+"',tcase='"+FormBean.getTcase()+"',tpcs='"+FormBean.getTpcs()+"',ttotal='"+FormBean.getTamount()+"'  where id='"+FormBean.getId()+"' ";
				
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select matcode from materialmaster where id='"+FormBean.getId()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					matcode=rs.getString(1);
				}
				
				sql="delete from materialdetails where matcode='"+matcode+"' ";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				
				String pcase[]=FormBean.getPcase1();
				String	pcs[]=FormBean.getPcs1(),mrp1[]=FormBean.getMrp11(),scase[]=FormBean.getScase1(),spcs[]=FormBean.getSpcs1(),stotal[]=FormBean.getStotal1(),rtcase[]=FormBean.getRtcase1(),rtpcs[]=FormBean.getRtpcs1(),vrtcase[]=FormBean.getVrtcase1(),vrtpcs[]=FormBean.getVrtpcs1(),dist[]=FormBean.getDist1(),price[]=FormBean.getPrice1();
			
				
				//System.out.println("hello: "+);
			
			System.out.println("hi: "+pcase.length);
			for(int i=0;i<pcase.length;i++){
				
				System.out.println("hello");
				sql="insert into materialdetails(matcode,list_price_case,pcs,mrp_pcs,op_case,op_pcs,op_total,cr_case,cr_pcs,cr_total,sl_rt_case,van_rt_case,rt_pcs,van_rt_pcs,dist,price)values('"+FormBean.getMmcode()+"','"+pcase[i]+"','"+pcs[i]+"','"+mrp1[i]+"','"+scase[i]+"','"+spcs[i]+"','"+stotal[i]+"','"+scase[i]+"','"+spcs[i]+"','"+stotal[i]+"','"+rtcase[i]+"','"+vrtcase[i]+"','"+rtpcs[i]+"','"+vrtpcs[i]+"','"+dist[i]+"','"+price[i]+"')";
			//	System.out.println(sql);
				
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
				
				
				
			}
			
			catch(Exception g)
			{
			//	System.out.println("error on salesmanupdate "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String smcode="",x="";
				String sql="";
				//System.out.println("hello: "+FormBean.getUnit());
				//System.out.println("hii: "+FormBean.getSaleac());
				//System.out.println("hii: "+FormBean.getValueaddtax());
					sql="insert into materialmaster(matcode,matname,msname,packing,unit,mfgcode,pur_ac,sale_ac,v_tax,agri_tax,hsn_code,m_type,size,sunit,scheme,period,min_level,type_tax,value_stock,surchar,company_code,material_group,tcase,tpcs,ttotal)values( '"+FormBean.getMmcode()+"','"+FormBean.getMaterialname()+"','"+FormBean.getSname()+"','"+FormBean.getPacking()+"','"+FormBean.getSunit()+"','"+FormBean.getMfgcode()+"','"+FormBean.getPurcode()+"','"+FormBean.getSalecode()+"','"+FormBean.getValueaddedtax()+"','"+FormBean.getAgriculturetax()+"','"+FormBean.getHsn()+"','"+FormBean.getMtype()+"','"+FormBean.getSize()+"','"+FormBean.getSunit()+"','"+FormBean.getScheme()+"','"+FormBean.getPeriod()+"','"+FormBean.getMininvlevel()+"','"+FormBean.getTypeoftax()+"','"+FormBean.getValueofstock()+"','"+FormBean.getSurchar()+"','"+FormBean.getCmpcode()+"','"+FormBean.getMaterialgroup1()+"','"+FormBean.getTcase()+"','"+FormBean.getTpcs()+"','"+FormBean.getTamount()+"')";
					//System.out.println(sql);
					
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					String pcase[]=FormBean.getPcase();
						String	pcs[]=FormBean.getPcs(),mrp1[]=FormBean.getMrp1(),scase[]=FormBean.getScase(),spcs[]=FormBean.getSpcs(),stotal[]=FormBean.getStotal(),rtcase[]=FormBean.getRtcase(),rtpcs[]=FormBean.getRtpcs(),vrtcase[]=FormBean.getVrtcase(),vrtpcs[]=FormBean.getVrtpcs(),dist[]=FormBean.getDist(),price[]=FormBean.getPrice();
					//System.out.println("hello: "+);
					
					//System.out.println("hi: "+pcase.length);
					for(int i=0;i<pcase.length;i++){
						System.out.println("hello");
						sql="insert into materialdetails(matcode,list_price_case,pcs,mrp_pcs,op_case,op_pcs,op_total,cr_case,cr_pcs,cr_total,sl_rt_case,van_rt_case,rt_pcs,van_rt_pcs,dist,price)values('"+FormBean.getMmcode()+"','"+pcase[i]+"','"+pcs[i]+"','"+mrp1[i]+"','"+scase[i]+"','"+spcs[i]+"','"+stotal[i]+"','"+scase[i]+"','"+spcs[i]+"','"+stotal[i]+"','"+rtcase[i]+"','"+vrtcase[i]+"','"+rtpcs[i]+"','"+vrtpcs[i]+"','"+dist[i]+"','"+price[i]+"')";
						//System.out.println(sql);
						
						result=ConnectionDAO.executeUpdate(stm, sql);
						
					}
					
					
				
			}
			catch(Exception a)
			{
				System.out.println("error on salesman creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}

	
	
	public static FormBean paddarlistupdate1(int id)
	{
		FormBean usBean=new FormBean();
		
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String matcode="";
		try
		{
			String sql="select matcode from materialmaster where id= '"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				matcode=rs.getString(1);
			}
			System.out.println(matcode);
			
			
			 sql="select * from materialmaster where matcode='"+matcode+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			
			
		
			
			
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setMmcode(rs.getString(2));
				usBean.setMaterialname(rs.getString(3));
				
				usBean.setSname(rs.getString(4));
				usBean.setPacking(rs.getString(6));
				usBean.setSunit(rs.getString(7));
				usBean.setMfgcode(rs.getString(9));
				usBean.setPurchase1(findledger(rs.getString(12)));
				usBean.setSalesac1(findledger(rs.getString(13)));
				
				usBean.setPurcode(rs.getString(12));
				usBean.setSalecode(rs.getString(13));
				
				usBean.setValueaddedtax(rs.getString(14));
				usBean.setAgriculturetax(rs.getString(15));
				usBean.setHsn(rs.getString(16));
				usBean.setMtype(rs.getString(17));
				usBean.setSize(rs.getString(18));
				usBean.setUnitofitem(rs.getString(19));
				usBean.setScheme(rs.getString(20));
				usBean.setPeriod(rs.getString(21));
				usBean.setMininvlevel(rs.getString(22));
				usBean.setTypeoftax(rs.getString(23));
				usBean.setValueofstock(rs.getString(24));
				usBean.setSurchar(rs.getString(25));
				usBean.setCompanyname(findledger1(rs.getString(26)));
				usBean.setCmpcode(rs.getString(26));
				usBean.setMaterialgroup(findledger2(rs.getString(27)));
				usBean.setMaterialgroup1(rs.getString(27));
				usBean.setTcase(rs.getString(28));
				usBean.setTpcs(rs.getString(29));
				usBean.setTamount(rs.getString(30));
				
			}
			
			Vector<String> pcase=new Vector<String>();
			Vector<String> pcs=new Vector<String>();
			Vector<String> mrp1=new Vector<String>();
			Vector<String> scase=new Vector<String>();
			Vector<String> spcs=new Vector<String>();
			Vector<String> stotal=new Vector<String>();
			Vector<String> rtcase=new Vector<String>();
			Vector<String> vrtcase=new Vector<String>();
			Vector<String> rtpcs=new Vector<String>();
			Vector<String> vrtpcs=new Vector<String>();
			Vector<String> dist=new Vector<String>();
			Vector<String> price=new Vector<String>();
			
			sql="select * from materialdetails where matcode='"+matcode+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				pcase.add(rs.getString(3));
				pcs.add(rs.getString(4));
				mrp1.add(rs.getString(5));
				scase.add(rs.getString(6));
				spcs.add(rs.getString(7));
				stotal.add(rs.getString(8));
				rtcase.add(rs.getString(12));
				vrtcase.add(rs.getString(13));
				rtpcs.add(rs.getString(14));
				vrtpcs.add(rs.getString(15));
				dist.add(rs.getString(16));
				price.add(rs.getString(17));
				
			
			}
			
			String pcase1[]= new String[pcase.size()];
			String pcs1[]= new String[pcs.size()];
			String mrp11[]= new String[mrp1.size()];
			String scase1[]= new String[scase.size()];
			String spcs1[]= new String[spcs.size()];
			String stotal1[]= new String[stotal.size()];
			String rtcase1[]= new String[rtcase.size()];
			String vrtcase1[]= new String[vrtcase.size()];
			String rtpcs1[]= new String[rtpcs.size()];
			String vrtpcs1[]= new String[vrtpcs.size()];
			String dist1[]= new String[dist.size()];
			String price1[]= new String[price.size()];
			
			for(int i=0;i<pcase.size();i++)
			{
				pcase1[i]=pcase.get(i);
				pcs1[i]=pcs.get(i);
				mrp11[i]=mrp1.get(i);
				scase1[i]=scase.get(i);
				spcs1[i]=spcs.get(i);
				//System.out.println("hi: "+spcs1[i]);
				stotal1[i]=stotal.get(i);
				rtcase1[i]=rtcase.get(i);
				vrtcase1[i]=vrtcase.get(i);
				rtpcs1[i]=rtpcs.get(i);
				vrtpcs1[i]=vrtpcs.get(i);
				dist1[i]=dist.get(i);
				price1[i]=price.get(i);
				
				
				
			}
			
			usBean.setPcase(pcase1);
			usBean.setPcs(pcs1);
			usBean.setMrp1(mrp11);
			usBean.setScase(scase1);
			usBean.setScase(scase1);
			usBean.setSpcs(spcs1);
			usBean.setStotal(stotal1);
			usBean.setRtcase(rtcase1);
			usBean.setVrtcase(vrtcase1);
			usBean.setRtpcs(rtpcs1);
			usBean.setVrtpcs(vrtpcs1);
			usBean.setDist(dist1);
			usBean.setPrice(price1);
			
			
			
			
			
			
			
			
			
			
			
		}
		catch(Exception a)
		{
			System.out.println("error on sales man edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
	
	
	
	public static boolean paddarlistdelete1(int id)// material master delete
	{
		FormBean usBean=new FormBean();
		boolean result=false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String matcode="";
		try
		{
			String sql="select * from materialmaster where id='"+id+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				matcode=rs.getString(2);
			}
			sql="delete from materialmaster where matcode='"+matcode+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="delete from materialdetails where matcode='"+matcode+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception a)
		{
			System.out.println("error on headdelete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}	 
	
	
	public static String findledger1(String xx)
	{
		String x3="",x1="";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try
		{
			String sql="select company_name from companymaster1 where company_code='"+xx+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				x3=rs.getString(1);
			}
			//System.out.println("ledger name got "+x3);
		}
		catch(Exception hh)
		{
			System.out.println("error in findledger "+hh);
		}
		ConnectionDAO.closeConnection(conn);
		return x3;
	}
	public static List<FormBean> companylist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			/*sql="select * from ledgermaster where ledgerid like 'SC%'";*/
			//System.out.println(sql);
			
			sql="select company_name from companymaster1";
			
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setCompany(rs.getString(1));
				//x.setOnac(rs.getString(3));
				//System.out.println("value "+rs.getString(3));
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on company list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	public static List<FormBean> purchaselist1(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			//int sr=1;
			sql="select * from itransaction where voucherno like '%PU%';";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));				
				x.setVouno(rs.getString(2));
				x.setDated(rs.getString(5));
				x.setInvoicevaluers(rs.getString(31));
				//System.out.println(rs.getString(2)+rs.getString(6)+rs.getString(31));
				l1.add(x);
			
			}
		}
		catch(Exception c)
		{
			System.out.println("error on  purchaselist "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}

	//purchasecreation

	
	public static boolean purchasecreation(FormBean FormBean) 
	{
		boolean result1 = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String voucherno="";
		if(FormBean.getId() != null)
		{
			try
			{
				
				String sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				 sql="update itransaction set voucherno='"+voucherno+"',entrydate='"+FormBean.getDate()+"',insertdate='"+FormBean.getDated()+"', gross_amt='"+FormBean.getGrossamt()+"',sgst='"+FormBean.getSgst()+"',cgst='"+FormBean.getCgst()+"',igst='"+FormBean.getIgst()+"',companycode='"+FormBean.getCp()+"',creditors='"+FormBean.getCre()+"',invoiceno='"+FormBean.getInvoiceno()+"',invoice_valuers='"+FormBean.getInvoicevaluers()+"',lessamt='"+FormBean.getLessamt()+"',addamount='"+FormBean.getAddamount()+"',billamount='"+FormBean.getBillamt()+"',companyname='"+FormBean.getCompany()+"',crename='"+FormBean.getCreditors()+"' where id='"+FormBean.getId()+"' ";
				
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
				
				
				sql="delete from idetails where voucherno='"+voucherno+"' ";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm, sql);
				String noi7[]=FormBean.getNoi5();
				String	pack7[]=FormBean.getPack5(),case7[]=FormBean.getCase5(),pcs7[]=FormBean.getPcs5(),free7[]=FormBean.getFree5(),ratec7[]=FormBean.getRatec5(),ratep7[]=FormBean.getRatep5(),ammount7[]=FormBean.getAmmount5();
				for(int i=0;i<noi7.length;i++)
				{
					//System.out.println("hello");
					sql="insert into idetails(voucherno,name_ofitems,packing,case1,pcs1,free,rate1,ratep,amount1) values('"+voucherno+"','"+noi7[i]+"','"+pack7[i]+"','"+case7[i]+"','"+pcs7[i]+"','"+free7[i]+"','"+ratec7[i]+"','"+ratep7[i]+"','"+ammount7[i]+"')";
				
					//System.out.println(sql);
					
					result1=ConnectionDAO.executeUpdate(stm, sql);
					
					
				
				}
				
			}
			catch(Exception g)
			{
				g.printStackTrace();
			}
		}
		else
		{
			try
			{
				int id=0;
				String smcode="",x="";
				String sql="";
				String v="VD";
				int cmat=0;
				 String mcode="",matcode="",matcode1="";
				 String v1="PU1718";
					sql="select count(id) from itransaction";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						 cmat=rs.getInt(1);
					}
					
					if(cmat == 0)
					{
						matcode=mcode+"000"+(cmat+1);
					}
					else if(cmat > 0 && cmat < 9)
					{
						matcode=mcode+"000"+(cmat+1);
					}
					else if(cmat > 8 && cmat < 99)
					{
						matcode=mcode+"00"+(cmat+1);
					}
					else if(cmat > 98 && cmat < 999)
					{
						matcode=mcode+"0"+(cmat+1);
					}
					else if(cmat > 998 && cmat < 9999)
					{
						matcode=mcode+(cmat+1);
						
					}
					 matcode1=v1+matcode;
				//System.out.println("hii"+matcode);
					sql="insert into itransaction(voucherno,entrydate,insertdate,gross_amt,sgst,cgst,igst,companycode,creditors,invoiceno,invoice_valuers,lessamt,addamount,billamount,companyname,crename)values( '"+matcode1+"','"
					+FormBean.getDate()+"','"
					+FormBean.getDated()+"','"
					+FormBean.getGrossamt()+"','"
					+FormBean.getSgst()+"','"
					+FormBean.getCgst()+"','"
					+FormBean.getIgst()+"','"
					+FormBean.getCp()+"','"
					+FormBean.getCre()+"','"
					+FormBean.getInvoiceno()+"','"
					+FormBean.getInvoicevaluers()+"','"
					+FormBean.getLessamt()+"','"
					+FormBean.getAddamount()+"','"
					+FormBean.getBillamt()+"','"
					+FormBean.getCompany()+"','"
					+FormBean.getCreditors()+"')";
					System.out.println(sql);
					result1=ConnectionDAO.executeUpdate(stm,sql);
					String materialcode="";
					String noi1[]=FormBean.getNameofitems();
					String	pack1[]=FormBean.getPack(),case1[]=FormBean.getCase3(),pcs1[]=FormBean.getPcs(),free1[]=FormBean.getFree(),mrp1[]=FormBean.getMrp(),ratec1[]=FormBean.getRatec(),ratep1[]=FormBean.getRatep(),amount1[]=FormBean.getAmmount(),gst[]=FormBean.getGstp(),tax[]=FormBean.getTax1();
				System.out.println("jei sql ta chai "+sql);
				
				
				
				String nul="";
				String chec=FormBean.getPcase9();
				
				if(chec.compareTo(nul) != 0)
				{
					sql="insert into materialdetails(matcode,list_price_case,pcs,mrp_pcs,op_case,op_pcs,op_total,cr_case,cr_pcs,cr_total,sl_rt_case,van_rt_case,rt_pcs,van_rt_pcs,dist,price)values('"+FormBean.getIns()+"','"+FormBean.getPcase9()+"','"+FormBean.getPcs9()+"','"+FormBean.getMrp19()+"','"+FormBean.getScase9()+"','"+FormBean.getSpcs9()+"','"+FormBean.getStotal9()+"','"+FormBean.getScase9()+"','"+FormBean.getSpcs9()+"','"+FormBean.getStotal9()+"','"+FormBean.getRtcase9()+"','"+FormBean.getVrtcase9()+"','"+FormBean.getRtpcs9()+"','"+FormBean.getVrtpcs9()+"','"+FormBean.getDist9()+"','"+FormBean.getPrice9()+"')";
					result1=ConnectionDAO.executeUpdate(stm,sql);
				}
				
				
				
				
				
				
				
				
				
					for(int i=0;i<noi1.length;i++)
					{
						System.out.println("hello");
						sql="insert into idetails( voucherno,name_ofitems,packing,case1,pcs1,free,mrp,rate1,ratep,amount1,gstax,gsamount ) values('"+matcode1+"','"+noi1[i]+"','"+pack1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+free1[i]+"','"+mrp1[i]+"','"+ratec1[i]+"','"+ratep1[i]+"','"+amount1[i]+"','"+tax[i]+"','"+gst[i]+"')";
					
						System.out.println(sql);
						
						result1=ConnectionDAO.executeUpdate(stm, sql);
						
						
						
							
						
						
						String packing="",ccase="",cpcs="",ctotal="";
						double scase=0,spcs=0,stotal=0;
						
						//System.out.println("hello");
						sql="select packing,matcode from materialmaster where matname='"+noi1[i]+"'";
						System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							packing=rs.getString(1);
							materialcode=rs.getString(2);
						
							System.out.println("Packng: "+packing+","+materialcode);
						}
						sql="select cr_case,cr_pcs,cr_total from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							
							ccase=rs.getString(1);
							cpcs=rs.getString(2);
							ctotal=rs.getString(3);
							System.out.println("material details: "+ccase+","+cpcs+","+ctotal);
						}
						
						if(free1[i].equals(""))
						{
							free1[i]="0";
						}
						System.out.println("output: "+case1[i]+","+pcs1[i]+","+free1[i]);
						double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(free1[i]));
						System.out.println("Total value: "+total);
						
						
						
						scase=Double.parseDouble(ccase) + Double.parseDouble(case1[i]);
						spcs=Double.parseDouble(cpcs) + (Double.parseDouble(pcs1[i]) + Double.parseDouble(free1[i]));
						stotal=Double.parseDouble(ctotal) + total;
						
						 sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						 System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm, sql);
						
					
					}
					
				
					String typ="dr";	
					String dt=FormBean.getDate();
					String cre=FormBean.getCre();
					String purcode=FormBean.getPurcode();
					String billamt=FormBean.getBillamt();
					String blamnt="-"+billamt;
					
					String[] queries ={
							
							
							
							"insert into accountdetails(voucherno,entrydate,ledgerid,amount) values('"+matcode1+"','"+dt+"','"+cre+"','"+blamnt+"')",
							"insert into accountdetails(voucherno,entrydate,ledgerid,amount) values('"+matcode1+"','"+dt+"','"+purcode+"','"+billamt+"')",
							
							"insert into accounttransaction(entrydate,voucherno,ledgerid,totalamount,vouchertype) values('"+dt+"','"+matcode1+"','"+purcode+"','"+billamt+"','"+typ+"') "
					};
						
						for(String query:queries)
						{
							System.out.println(query);
							stm.addBatch(query);
						}
						
					stm.executeBatch();
				
				
				
						
				}			
			catch(Exception a)
			{
				a.printStackTrace();
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result1;
	}



	public static FormBean purchaseupdate1(int id)
	{
		FormBean usBean=new FormBean();
		
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String voucherno="";
		try
		{
			String sql="select voucherno from itransaction where id= '"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			System.out.println(voucherno);
			
			
			 sql="select * from itransaction where voucherno='"+voucherno+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			
			
		
			
			
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setVouno(rs.getString(2));
				usBean.setDate(rs.getString(5));
				usBean.setDated(rs.getString(27));
			
				usBean.setGrossamt(rs.getString(16));
				usBean.setSgst(rs.getString(19));
				usBean.setCgst(rs.getString(20));
				usBean.setIgst(rs.getString(21));
				usBean.setCompany(rs.getString(35));
				cocode=rs.getString(28);
				//System.out.println(cocode);
				usBean.setCp(rs.getString(28));
				usBean.setCreditors(rs.getString(36));
				usBean.setCre(rs.getString(29));
				usBean.setInvoiceno(rs.getString(30));
				usBean.setInvoicevaluers(rs.getString(31));
				usBean.setLessamt(rs.getString(32));
				usBean.setAddamount(rs.getString(33));
				usBean.setBillamt(rs.getString(34));
				
			}
			
			sql="select sttype from companymaster1 where company_code = '"+cocode+"' ";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setSttype(rs.getString(1));
			}
			
			Vector<String> noi=new Vector<String>();
			Vector<String> pack=new Vector<String>();
			Vector<String> case3=new Vector<String>();
			Vector<String> pcs=new Vector<String>();
			Vector<String> free=new Vector<String>();
			Vector<String> mrp=new Vector<String>();
			Vector<String> ratec=new Vector<String>();
			Vector<String> ratep=new Vector<String>();
			Vector<String> ammount=new Vector<String>();
			Vector<String> tax=new Vector<String>();
			Vector<String> gstp=new Vector<String>();
			
			sql="select * from idetails where voucherno='"+voucherno+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				noi.add(rs.getString(3));
				pack.add(rs.getString(20));
				case3.add(rs.getString(4));
				pcs.add(rs.getString(5));
				free.add(rs.getString(21));
				mrp.add(rs.getString(7));
				ratec.add(rs.getString(8));
				ratep.add(rs.getString(22));
				ammount.add(rs.getString(11));
				tax.add(rs.getString(23));
				gstp.add(rs.getString(24));
			
			
			}
			
			String noi1[]= new String[noi.size()];
			String pack1[]= new String[pack.size()];
			String case1[]= new String[case3.size()];
			String pcs1[]= new String[pcs.size()];
			String free1[]= new String[free.size()];
			String mrp1[]= new String[mrp.size()];
			String ratec1[]= new String[ratec.size()];
			String ratep1[]= new String[ratep.size()];
			String ammount1[]= new String[ammount.size()];
			String tax1[]=new String[tax.size()];
			String gst[]=new String[gstp.size()];
			
			for(int i=0;i<noi.size();i++)
			{
				noi1[i]=noi.get(i);
				pack1[i]=pack.get(i);
				case1[i]=case3.get(i);
				pcs1[i]=pcs.get(i);
				free1[i]=free.get(i);
				mrp1[i]=mrp.get(i);
				ratec1[i]=ratec.get(i);
				ratep1[i]=ratep.get(i);
				ammount1[i]=ammount.get(i);
				tax1[i]=tax.get(i);
				gst[i]=gstp.get(i);
				
				
				System.out.println("value: "+noi.get(i)+","+pack.get(i)+","+case3.get(i)+","+pcs.get(i)+","+free.get(i)+","+ratec.get(i)+","+ammount.get(i)+","+tax.get(i)+","+gstp.get(i));
				
			}
			
			usBean.setNameofitems(noi1);
			usBean.setPack(pack1);
			usBean.setCase3(case1);
			usBean.setPcs(pcs1);
			usBean.setFree(free1);
			usBean.setMrp(mrp1);
			usBean.setRatec(ratec1);
			usBean.setRatep(ratep1);
			usBean.setVoucher(voucherno);
			usBean.setAmmount(ammount1);
			usBean.setTax1(tax1);
			usBean.setGstp(gst);
			
			
			
			}
		catch(Exception a)
		{
			System.out.println("error on sales man edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
	public static FormBean purchasedelete1(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		boolean result1 = false;
		
		String voucherno="";
		try
		{
			String sql="select voucherno from itransaction where id= '"+id+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			//System.out.println(voucherno);
			
			
			 sql="delete from itransaction where voucherno='"+voucherno+"'";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			
			sql="delete from idetails where voucherno='"+voucherno+"' ";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			
		}
		catch(Exception a)
		{
			System.out.println("error on purchasedelete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}

public static List<FormBean> nameofitem(FormBean formbean) {
		
		
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			//int sr=1;
			sql="select matname from materialmaster where company_code='"+cocode+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setPart(rs.getString(1));
				//System.out.println(rs.getString(2)+rs.getString(6)+rs.getString(31));
				l1.add(x);
			
			}
		}
		catch(Exception c)
		{
			System.out.println("error on  purchaselist "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}

public static List<FormBean> sundaylist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		sql="select ledgername from ledgermaster where ledgerid like 'SC%'";
		//System.out.println(sql);
		
		/*sql="select company_name from companymaster1";*/
		
		System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setCreditors(rs.getString(1));
			//x.setOnac(rs.getString(3));
			//System.out.println("value "+rs.getString(3));
			l1.add(x);
		}
	}
	catch(Exception c)
	{
		System.out.println("error on company list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}

	
	
	public static boolean materialgroupcreation(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String sql="";
		if(FormBean.getId() != null)
		{
			try
			{
				String led="";
				sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					led=rs.getString(1);
				}
				sql="update materialgroupmaster set description='"+FormBean.getGroup()+"', shortname='"+FormBean.getSname()+"', ledgerid='"+led+"' where id='"+FormBean.getId()+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				ConnectionDAO.closeConnection(conn);
			}
			catch(Exception h)
			{
				System.out.println("error in material update "+h);
			}
		}
		else
		{
			String ledgerid="",code="",x="";
			int count=0;
			try
			{
				sql="select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					ledgerid=rs.getString(1);
				}
				String ch[]={ "A","B","C","D","E","F","G","H","I","J",
					          "K","L","M","N","O","P","Q","R","S","T","U",
					          "V","W","X","Y","Z","0","1","2","3","4","5",
					          "6","7","8","9" 
					    	};//35 character from 0 to 35
				for(int i=0;i<FormBean.getGroup().length();i++)
				{
					for(int j=i;j<35;j++)
					{
					 code=FormBean.getGroup().toUpperCase().charAt(i)+ch[j];
					 //System.out.println(code);
					 sql="select count(groupcode) from materialgroupmaster where groupcode='"+code+"'";
					// System.out.println(sql);
					 rs=stm.executeQuery(sql);
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
				sql="insert into materialgroupmaster(groupcode, description, shortname, ledgerid) values('"+code+"', '"+FormBean.getGroup()+"', '"+FormBean.getSname()+"', '"+ledgerid+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				ConnectionDAO.closeConnection(conn);
			}
			catch(Exception ab)
			{
				System.out.println("error on materialgroupcreation "+ab);
			}
		}
		return result;
	}
	public static FormBean materialgroupedit(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from materialgroupmaster where id='"+id+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setGroup(rs.getString(3));
				usBean.setSname(rs.getString(4));
				usBean.setCompany(findledger(rs.getString(5)));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on material edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
	public static FormBean materialgroupdelete(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="delete from materialgroupmaster where id='"+id+"'";
			ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception a)
		{
			System.out.println("error on material delete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
//salesmanlist
	public static List<FormBean> salesmanlist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from areasalesmanmaster order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setDesc1(sr+". "+rs.getString(3));
				x.setSname(rs.getString(4));
			//	x.setCompany(findledger(rs.getString(5)));
				l1.add(x);
				sr++;
			}
		}
		catch(Exception c)
		{
			System.out.println("error on salesman list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//salesmancreation
	public static boolean salesmancreation(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		if(FormBean.getId() != null)
		{
			try
			{
				String sql="update areasalesmanmaster set smname='"+FormBean.getDesc1()+"', shortname='"+FormBean.getSname()+"' where id='"+FormBean.getId()+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			catch(Exception g)
			{
			//	System.out.println("error on salesmanupdate "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String smcode="",x="";
				String sql="select max(id) from areasalesmanmaster";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					id=rs.getInt(1);
				}
								
				if(id > 0)
				{
					sql="select * from areasalesmanmaster where id='"+id+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						smcode=rs.getString(2).substring(3, rs.getString(2).length());
					}
					if(Integer.parseInt(smcode) > 0 && Integer.parseInt(smcode) < 9)
					{
						x="SM"+"000"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 8 && Integer.parseInt(smcode) < 99)
					{
						x="SM"+"00"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 98 && Integer.parseInt(smcode) < 999)
					{
						x="SM"+"0"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 998 && Integer.parseInt(smcode) < 9999)
					{
						x="SM"+(Integer.parseInt(smcode)+1);
					}
					sql="insert into areasalesmanmaster(smcode, smname, shortname)values('"+x+"', '"+FormBean.getDesc1()+"', '"+FormBean.getSname()+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				else if(id == 0)
				{
					sql="insert into areasalesmanmaster(smcode, smname, shortname)values('SM0001', '"+FormBean.getDesc1()+"', '"+FormBean.getSname()+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
			}
			catch(Exception a)
			{
				System.out.println("error on salesman creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}
//salesmanedit
	public static FormBean salesmanedit(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from areasalesmanmaster where id='"+id+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setDesc1(rs.getString(3));
				usBean.setSname(rs.getString(4));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on sales man edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
//salesmandelete
	public static FormBean salesmandelete(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="delete from areasalesmanmaster where id='"+id+"'";
			ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception a)
		{
			System.out.println("error on salesmandelete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
//salesmanlist in mrlist
	public static List<FormBean> saleslist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		FormBean x;
		String sql="";
		try
		{
			//int sr=1;
			sql="select * from areasalesmanmaster";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				x=new FormBean();
				x.setSalesman(rs.getString(3));
				System.out.println("got "+rs.getString(3));
				x.setSalesmanname1(rs.getString(3));
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on sales list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	
	
	
	public static List<FormBean> crsaleslist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			sql="select * from ledgermaster where ledgername like '%sales%'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setCreditac(rs.getString(3));
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on sales list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//mrlist
	public static List<FormBean> mrlist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int sr=1;
			sql="select * from mrmaster order by id desc";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setDesc1(sr+". "+rs.getString(3));
				x.setShortname(rs.getString(4));
			//	x.setSmcode(findsalesmanager(rs.getString(6)));
			//	x.setCompany(findledger(rs.getString(7)));
				l1.add(x);
				sr++;
			}
		}
		catch(Exception c)
		{
			System.out.println("error on mr list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
public static String findsalesman(String xx)
{
	String sql="",name="";
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	try
	{
		sql="select * from areasalesmanmaster where smcode='"+xx+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			name=rs.getString(3);
		}
	}
	catch(Exception err)
	{
		System.out.println("error in findsalesman function "+err);
	}
	ConnectionDAO.closeConnection(conn);
	return name;
}
//mrcreation
	public static boolean mrcreation(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		if(FormBean.getId() != null)
		{
			try
			{
				String sql="",sname="";
								
				sql="select smcode from areasalesmanmaster where smname='"+FormBean.getSalesman()+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					sname=rs.getString(1);
				}
				sql="update mrmaster set mrname='"+FormBean.getDesc1()+"', mrshortname='"+FormBean.getSname()+"', srno='"+FormBean.getSerial()+"', smcode='"+sname+"' where id='"+FormBean.getId()+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			catch(Exception g)
			{
				System.out.println("error on mrupdate "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String sql="",smcode="",x="",sname="";
				sql="select max(id) from mrmaster";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					id=rs.getInt(1);
				}					
				sql="select smcode from areasalesmanmaster where smname='"+FormBean.getSalesman()+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					sname=rs.getString(1);
				}
				if(id > 0)
				{
					sql="select * from mrmaster where id='"+id+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						smcode=rs.getString(2).substring(3, rs.getString(2).length());
					}
					if(Integer.parseInt(smcode) > 0 && Integer.parseInt(smcode) < 9)
					{
						x="MR"+"000"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 8 && Integer.parseInt(smcode) < 99)
					{
						x="MR"+"00"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 98 && Integer.parseInt(smcode) < 999)
					{
						x="MR"+"0"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 998 && Integer.parseInt(smcode) < 9999)
					{
						x="MR"+(Integer.parseInt(smcode)+1);
					}
					sql="insert into mrmaster(mrcode, mrname, mrshortname, srno, smcode)values('"+x+"', '"+FormBean.getDesc1()+"', '"+FormBean.getSname()+"', '"+FormBean.getSerial()+"', '"+sname+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				else if(id == 0)
				{
					sql="insert into mrmaster(mrcode, mrname, mrshortname, srno, smcode)values('MR0001', '"+FormBean.getDesc1()+"', '"+FormBean.getSname()+"', '"+FormBean.getSerial()+"', '"+sname+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
			}
			catch(Exception a)
			{
				System.out.println("error on mr creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}
//mredit
	public static FormBean mredit(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from mrmaster where id='"+id+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setDesc1(rs.getString(3));
				usBean.setSname(rs.getString(4));
				usBean.setSerial(rs.getString(5));
	//			usBean.setSalesman(findsalesmanager(rs.getString(6)));
		//		usBean.setCompany(findledger(rs.getString(7)));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on mredit edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
//mrdelete
	public static FormBean mrdelete(int id)
	{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="delete from mrmaster where id='"+id+"'";
			ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception a)
		{
			System.out.println("error on mrdelete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
	}
//tlist
	public static List<FormBean> tlist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			int srno=1;
			sql="select * from categorymaster order by trname";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setCategory(srno+". "+rs.getString(3));
				x.setSname(rs.getString(4));
				l1.add(x);
				srno++;
			}
		}
		catch(Exception c)
		{
			System.out.println("error on category list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	
public static FormBean uniqueid1(String prefix,String prefix1) {
		
		UniqueIDGenerator u = new UniqueIDGenerator(); 
		String x=u.getUniqueID();
		int j=0;
		FormBean usBean = new FormBean();
		String sql = "select * from uniqueid";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try {			
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) 
				{
					j=rs.getInt(3);
				}
			
			int k=String.valueOf(j).length();
			String x0="";
			String x1="";
			
			if(k==1)
			x0=prefix+"0000"+j;
			x1=prefix1+"0000"+j;
			if(k==2)
			x0=prefix+"000"+j;
			x1=prefix1+"000"+j;
			if(k==3)
			x0=prefix+"00"+j;
			x1=prefix1+"00"+j;
			if(k==4)
			x0=prefix+"0"+j;
			x1=prefix1+"0"+j;
			if(k==5)
				x0=prefix+j;
			x1=prefix1+j;
			usBean.setCompanycode(x0);
			usBean.setClaimcode(x0);
			usBean.setPartycode(x0);
			usBean.setGroupcode(x0);
			usBean.setCatcode(x0);
		//	usBean.set
			
			//usBean.setRccode(x1);*/
			sql = "insert into uniqueid(uid,sid) values ('"
					+ x /* "DS000"+(k+1)  */
					+ "','"
					+ (j+1)
					+"');";
			
			ConnectionDAO.executeUpdate(stm, sql);
		}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
	
			ConnectionDAO.closeConnection(conn);
			return usBean;
			}
//tcreation
	public static boolean tcreation(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		if(FormBean.getId() != null)
		{
			try
			{
				String led="",sql="",sname="";
				sql="update categorymaster set trname='"+FormBean.getCategory()+"', shortname='"+FormBean.getSname()+"' where id='"+FormBean.getId()+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			catch(Exception g)
			{
				System.out.println("error on category update "+g);
			}
		}
		else
		{
			try
			{
				int id=0;
				String smcode="",led="",x="",sname="";
				String sql="select max(id) from categorymaster";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					id=rs.getInt(1);
				}
				if(id > 0)
				{
					sql="select * from categorymaster where id='"+id+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						smcode=rs.getString(2).substring(3, rs.getString(2).length());
					}
					if(Integer.parseInt(smcode) > 0 && Integer.parseInt(smcode) < 9)
					{
						x="YD"+"000"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 8 && Integer.parseInt(smcode) < 99)
					{
						x="YD"+"00"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 98 && Integer.parseInt(smcode) < 999)
					{
						x="YD"+"0"+(Integer.parseInt(smcode)+1);
					}
					else if(Integer.parseInt(smcode) > 998 && Integer.parseInt(smcode) < 9999)
					{
						x="YD"+(Integer.parseInt(smcode)+1);
					}
					sql="insert into categorymaster(trcode, trname, shortname)values('"+x+"', '"+FormBean.getCategory()+"', '"+FormBean.getSname()+"')";
					//System.out.println("1. "+sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				else if(id == 0)
				{
					sql="insert into categorymaster(trcode, trname, shortname)values('YD0001', '"+FormBean.getCategory()+"', '"+FormBean.getSname()+"')";
					//System.out.println("2. "+sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
			}
			catch(Exception a)
			{
				System.out.println("error on category creation "+a);
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}
//tedit
public static FormBean tedit(int id)
{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from categorymaster where id='"+id+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setCategory(rs.getString(3));
				usBean.setSname(rs.getString(4));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on mredit edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
}
//tdelete
public static FormBean tdelete(int id)
{
	FormBean usBean=new FormBean();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	try
	{
		String sql="delete from categorymaster where id='"+id+"'";
		ConnectionDAO.executeUpdate(stm, sql);
	}
	catch(Exception a)
	{
		System.out.println("error on tdelete "+a);
	}
	ConnectionDAO.closeConnection(conn);
	return usBean;
}

public static List<FormBean> plist1(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		int srno=1;
		sql="select placename from placemaster order by id desc";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			
			//System.out.println(rs.getString(1));
			x.setNameofarea1(rs.getString(1));
			l1.add(x);
			
		}
	}
	catch(Exception c)
	{
		System.out.println("error on category list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//plist

public static List<FormBean> plist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		int srno=1;
		sql="select * from placemaster order by id desc";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setId(rs.getInt(1));
			x.setPlace(srno+". "+rs.getString(3));
			x.setSname(rs.getString(4));
			l1.add(x);
			srno++;
		}
	}
	catch(Exception c)
	{
		System.out.println("error on category list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//placecreation
public static boolean placecreation(FormBean FormBean) 
{
	boolean result = false;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	if(FormBean.getId() != null)
	{
		try
		{
			String led="",sql="",sname="";
			sql="update placemaster set placename='"+FormBean.getPlace()+"', placeshortname='"+FormBean.getSname()+"',rate1='"+FormBean.getRte()+"',group1='"+FormBean.getGroup()+"' where id='"+FormBean.getId()+"'";
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception g)
		{
			System.out.println("error on place update "+g);
		}
	}
	else
	{
		try
		{
			int id=0;
			String smcode="",led="",x="",sname="";
			String sql="select max(id) from placemaster";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getInt(1);
			}
			if(id > 0)
			{
				sql="select * from placemaster where id='"+id+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					smcode=rs.getString(2).substring(3, rs.getString(2).length());
				}
				if(Integer.parseInt(smcode) > 0 && Integer.parseInt(smcode) < 9)
				{
					x="PQ"+"000"+(Integer.parseInt(smcode)+1);
				}
				else if(Integer.parseInt(smcode) > 8 && Integer.parseInt(smcode) < 99)
				{
					x="PQ"+"00"+(Integer.parseInt(smcode)+1);
				}
				else if(Integer.parseInt(smcode) > 98 && Integer.parseInt(smcode) < 999)
				{
					x="PQ"+"0"+(Integer.parseInt(smcode)+1);
				}
				else if(Integer.parseInt(smcode) > 998 && Integer.parseInt(smcode) < 9999)
				{
					x="PQ"+(Integer.parseInt(smcode)+1);
				}
				sql="insert into placemaster(placecode, placename, placeshortname,rate1,group1)values('"+x+"', '"+FormBean.getPlace()+"', '"+FormBean.getSname()+"','"+FormBean.getRte()+"','"+FormBean.getGroup()+"')";
				System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			else if(id == 0)
			{
				sql="insert into placemaster(placecode, placename, placeshortname,rate1,group1)values('PQ0001', '"+FormBean.getPlace()+"', '"+FormBean.getSname()+"','"+FormBean.getRte()+"','"+FormBean.getGroup()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
		}
		catch(Exception a)
		{
			System.out.println("error on place creation "+a);
		}
	}
	ConnectionDAO.closeConnection(conn);
	return result;
}
//pcedit
public static FormBean pcedit(int id)
{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from placemaster where id='"+id+"'";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setPlace(rs.getString(3));
				usBean.setSname(rs.getString(4));
				usBean.setRte(rs.getString(5));
				usBean.setGroup(rs.getString(6));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on mredit edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
}
//pcdelete
public static FormBean pcdelete(int id)
{
	FormBean usBean=new FormBean();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	try
	{
		String sql="delete from placemaster where id='"+id+"'";
		ConnectionDAO.executeUpdate(stm, sql);
	}
	catch(Exception a)
	{
		System.out.println("error on tdelete "+a);
	}
	ConnectionDAO.closeConnection(conn);
	return usBean;
}
//headquarterlist
public static List<FormBean> headquarterlist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		int srno=1;
		sql="select * from headquarter order by id desc";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setId(rs.getInt(1));
			x.setHeadq(srno+". "+rs.getString(3));
			x.setSname(rs.getString(4));
			l1.add(x);
			srno++;
		}
	}
	catch(Exception c)
	{
		System.out.println("error on category list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//headquartercreation
public static boolean headquartercreation(FormBean FormBean) 
{
	boolean result = false;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	if(FormBean.getId() != null)
	{
		try
		{
			String led="",sql="",sname="";
			sql="update headquarter set hname='"+FormBean.getHeadq()+"', hshortname='"+FormBean.getSname()+"' where id='"+FormBean.getId()+"'";
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception g)
		{
			System.out.println("error on headquarter update "+g);
		}
	}
	else
	{
		try
		{
			int id=0;
			String smcode="",led="",x="",sname="";
			String sql="select max(id) from headquarter";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getInt(1);
			}
			if(id > 0)
			{
				sql="select * from headquarter where id='"+id+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					smcode=rs.getString(2).substring(3, rs.getString(2).length());
				}
				if(Integer.parseInt(smcode) > 0 && Integer.parseInt(smcode) < 9)
				{
					x="HQ"+"000"+(Integer.parseInt(smcode)+1);
				}
				else if(Integer.parseInt(smcode) > 8 && Integer.parseInt(smcode) < 99)
				{
					x="HQ"+"00"+(Integer.parseInt(smcode)+1);
				}
				else if(Integer.parseInt(smcode) > 98 && Integer.parseInt(smcode) < 999)
				{
					x="HQ"+"0"+(Integer.parseInt(smcode)+1);
				}
				else if(Integer.parseInt(smcode) > 998 && Integer.parseInt(smcode) < 9999)
				{
					x="HQ"+(Integer.parseInt(smcode)+1);
				}
				sql="insert into headquarter(hcode, hname, hshortname)values('"+x+"', '"+FormBean.getHeadq()+"', '"+FormBean.getSname()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			else if(id == 0)
			{
				sql="insert into headquarter(hcode, hname, hshortname)values('HQ0001', '"+FormBean.getHeadq()+"', '"+FormBean.getSname()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
		}
		catch(Exception a)
		{
			System.out.println("error on quarter creation "+a);
		}
	}
	ConnectionDAO.closeConnection(conn);
	return result;
}
//headquarterupdate
public static FormBean hqedit(int id)
{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		try
		{
			String sql="select * from headquarter where id='"+id+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setHeadq(rs.getString(3));
				usBean.setSname(rs.getString(4));
			}
		}
		catch(Exception a)
		{
			System.out.println("error on headquarter edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
}
//headquarterdelete
public static FormBean hqdelete(int id)
{
	FormBean usBean=new FormBean();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	try
	{
		String sql="delete from headquarter where id='"+id+"'";
		ConnectionDAO.executeUpdate(stm, sql);
	}
	catch(Exception a)
	{
		System.out.println("error on headdelete "+a);
	}
	ConnectionDAO.closeConnection(conn);
	return usBean;
}
public static List<FormBean> materiallist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		sql="select * from materialgroupmaster";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setMaterialg(rs.getString(3));
			l1.add(x);
		}
	}
	catch(Exception c)
	{
		System.out.println("error on materialgroup list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static String findmaterialgroup(String ab)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String r="";
	ab=ab.substring(0,2);
	try
	{
		String sql="select * from materialgroupmaster where groupcode='"+ab+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			r=rs.getString(3);
		}
	}
	catch(Exception aba)
	{
		System.out.println("error in findmaterialgroup "+aba);
	}
	ConnectionDAO.closeConnection(conn);
	return r;
}
//unitlist
public static List<FormBean> unitlist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		sql="select * from unitmaster";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setUnit(rs.getString(2));
			l1.add(x);
		}
	}
	catch(Exception c)
	{
		System.out.println("error on category list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//materialist
public static List<FormBean> materialist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		int srno=1;
		sql="select * from materialmaster order by id desc";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setId(rs.getInt(1));
			x.setMateriald(srno+". "+rs.getString(3));
			x.setMaterialg(findmaterialgroup(rs.getString(2)));
			x.setOnac(findledger(rs.getString(4)));
			x.setSta(rs.getString(6));
			x.setStf(rs.getString(8));
			x.setReprate(rs.getString(13));
			x.setDisc(rs.getString(14));
			l1.add(x);
			srno++;
		}
	}
	catch(Exception c)
	{
		System.out.println("error on category list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
//materialcreation
public static boolean materialcreation(FormBean FormBean) 
{
	boolean result = false;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	if(FormBean.getId() != null)
	{
		try
		{
			String ledgerid="",mcode="",matcode="";
			double opa=0.00,cra=0.00,opf=0.00,crf=0.00,newopa=0.00,newcra=0.00,newopf=0.00,newcrf=0.00;
			double aa=0.00,bb=0.00,cc=0.00,dd=0.00;
			Vector<String> a=new Vector<String>();
			Vector<String> a1=new Vector<String>();
			Vector<String> b=new Vector<String>();
			Vector<String> b1=new Vector<String>();
			String sql="select * from ledgermaster where ledgername='"+FormBean.getOnac()+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledgerid=rs.getString(2);
			}
			sql="select * from materialgroupmaster where description='"+FormBean.getMaterialg()+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				mcode=rs.getString(2);
			}
			
			sql="select * from materialmaster where id='"+FormBean.getId()+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				matcode=rs.getString(2);
				opa=rs.getDouble(5);
				cra=rs.getDouble(6);
				opf=rs.getDouble(7);
				crf=rs.getDouble(8);
			}
			String x=matcode.substring(2,matcode.length());
			//System.out.println(x);
			newopa=opa+Double.parseDouble(FormBean.getSta());
			newcra=(-cra+newopa);
			newopf=opf+Double.parseDouble(FormBean.getStf());
			newcrf=(-crf+newopf);
			sql="update materialmaster set matcode='"+mcode+x+"', matname='"+FormBean.getMateriald()+"', ledgerid='"+ledgerid+"', opstock='"+newopa+"', crstock='"+newcra+"', freeopstock='"+newopf+"', freecrstock='"+newcrf+"', packing='"+FormBean.getPacking()+"', unit='"+FormBean.getUnit()+"', opvalue='"+FormBean.getTotal()+"', mfgcode='"+FormBean.getMfgcode()+"', reprate='"+FormBean.getReprate()+"', discountex='"+FormBean.getDisc()+"' where id='"+FormBean.getId()+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			sql="delete from batchmaster where matcode='"+matcode+"'";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			
			String bat[]=FormBean.getBatchnohidden(),exdt[]=FormBean.getExpdatehidden(),aqty[]=FormBean.getAqtyhidden(),fqty[]=FormBean.getFqtyhidden(),purate[]=FormBean.getPuratehidden(),strate[]=FormBean.getStratehidden(),rtrate[]=FormBean.getRtratehidden(),mrp[]=FormBean.getMrphidden(),amounta[]=FormBean.getAmountahidden();
			for(int i=0;i<bat.length;i++)
			{
				sql="insert into batchmaster(matcode, batchno, exdt, opstocka, crstocka, opstockf, crstockf, purate, strate, rtrate, mrprate, amount)values('"+mcode+x+"', '"+bat[i]+"', '"+exdt[i]+"', '"+aqty[i]+"', '"+aqty[i]+"', '"+fqty[i]+"', '"+fqty[i]+"', '"+purate[i]+"', '"+strate[i]+"', '"+rtrate[i]+"', '"+mrp[i]+"', '"+amounta[i]+"')";
				//System.out.println(aqty[i]+fqty[i]+'\n'+sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
		}
		catch(Exception error)
		{
			System.out.println("error on materialupdate "+error);
		}
	}
	else
	{
		try
		{
			String sql="",mcode="",matcode="",ledgerid="";
			int cmat=0;
			sql="select * from ledgermaster where ledgername='"+FormBean.getOnac()+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				ledgerid=rs.getString(2);
			}
			
			sql="select * from materialgroupmaster where description='"+FormBean.getMaterialg()+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				mcode=rs.getString(2);
			}
			
			sql="select count(matcode) from materialmaster";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				cmat=rs.getInt(1);
			}
			
			if(cmat == 0)
			{
				matcode=mcode+"000"+(cmat+1);
			}
			else if(cmat > 0 && cmat < 9)
			{
				matcode=mcode+"000"+(cmat+1);
			}
			else if(cmat > 8 && cmat < 99)
			{
				matcode=mcode+"00"+(cmat+1);
			}
			else if(cmat > 98 && cmat < 999)
			{
				matcode=mcode+"0"+(cmat+1);
			}
			else if(cmat > 998 && cmat < 9999)
			{
				matcode=mcode+(cmat+1);
			}
			sql="insert into materialmaster(matcode, matname, ledgerid, opstock, crstock, freeopstock, freecrstock, packing, unit, opvalue, mfgcode, reprate, discountex)values('"+matcode+"', '"+FormBean.getMateriald()+"', '"+ledgerid+"', '"+FormBean.getSta()+"', '"+FormBean.getSta()+"', '"+FormBean.getStf()+"', '"+FormBean.getStf()+"', '"+FormBean.getPacking()+"', '"+FormBean.getUnit()+"', '"+FormBean.getTotal()+"', '"+FormBean.getMfgcode()+"', '"+FormBean.getReprate()+"', '"+FormBean.getDisc()+"')";
			//System.out.println(sql);
			result=ConnectionDAO.executeUpdate(stm, sql);
			
			String aqty[]=FormBean.getAqty(),fqty[]=FormBean.getFqty(),bat[]=FormBean.getBatchno(),exdt[]=FormBean.getExpdate(),purate[]=FormBean.getPurate(),strate[]=FormBean.getStrate(),rtrate[]=FormBean.getRtrate(),mrp[]=FormBean.getMrp(),amounta[]=FormBean.getAmounta();
			//System.out.println("find array length "+bat.length);
			for(int i=0;i<bat.length;i++)
			{
				sql="insert into batchmaster(matcode, batchno, exdt, opstocka, crstocka, opstockf, crstockf, purate, strate, rtrate, mrprate, amount)values('"+matcode+"', '"+bat[i]+"', '"+exdt[i]+"', '"+aqty[i]+"', '"+aqty[i]+"', '"+fqty[i]+"', '"+fqty[i]+"', '"+purate[i]+"', '"+strate[i]+"', '"+rtrate[i]+"', '"+mrp[i]+"', '"+amounta[i]+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on materialcreation "+c);
		}
	}
	ConnectionDAO.closeConnection(conn);
	return result;
}
//materialedit
public static FormBean materialedit(int id)
{
		FormBean usBean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String matcode="";
		try
		{
			String sql="select * from materialmaster where id='"+id+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean.setId(rs.getInt(1));
				usBean.setMaterialg(findmaterialgroup(rs.getString(2)));
				matcode=rs.getString(2);
				usBean.setOnac(findledger(rs.getString(4)));
				usBean.setMateriald(rs.getString(3));
				usBean.setPacking(rs.getString(9));
				usBean.setUnit(rs.getString(10));
				usBean.setSta(rs.getString(6));
				usBean.setStf(rs.getString(8));
				//System.out.println(rs.getString(6)+","+rs.getString(6));
				usBean.setReprate(rs.getString(13));
				usBean.setDisc(rs.getString(14));
				usBean.setMfgcode(rs.getString(12));
			}
			//dynamic field
			Vector<String> batchno=new Vector<String>();
			Vector<String> exdt=new Vector<String>();
			Vector<String> aqty=new Vector<String>();
			Vector<String> fqty=new Vector<String>();
			Vector<String> purate=new Vector<String>();
			Vector<String> strate=new Vector<String>();
			Vector<String> rtrate=new Vector<String>();
			Vector<String> mrp=new Vector<String>();
			Vector<String> amounta=new Vector<String>();
			sql="select * from batchmaster where matcode='"+matcode+"'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				batchno.add(rs.getString(3));
				exdt.add(rs.getString(4));
				aqty.add(rs.getString(6));
				fqty.add(rs.getString(8));
				purate.add(rs.getString(9));
				strate.add(rs.getString(10));
				rtrate.add(rs.getString(11));
				mrp.add(rs.getString(12));
				amounta.add(rs.getString(13));
			}
			String batcharray[]=new String[batchno.size()];
			String exdtarray[]=new String[exdt.size()];
			String aqtyarray[]=new String[aqty.size()];
			String fqtyarray[]=new String[fqty.size()];
			String puarray[]=new String[purate.size()];
			String starray[]=new String[strate.size()];
			String rtarray[]=new String[rtrate.size()];
			String mrparray[]=new String[mrp.size()];
			String amountaarray[]=new String[amounta.size()];
			//System.out.println("size of vector "+batchno.size()+" and array "+batcharray.length);
			for(int i=0;i<batcharray.length;i++)
			{
				batcharray[i]=batchno.get(i);
				exdtarray[i]=exdt.get(i);
				aqtyarray[i]=aqty.get(i);
				fqtyarray[i]=fqty.get(i);
				puarray[i]=purate.get(i);
				starray[i]=strate.get(i);
				rtarray[i]=rtrate.get(i);
				mrparray[i]=mrp.get(i);
				amountaarray[i]=amounta.get(i);
			}
			usBean.setBatchno(batcharray);
			usBean.setExpdate(exdtarray);
			usBean.setAqty(aqtyarray);
			usBean.setFqty(fqtyarray);
			usBean.setPurate(puarray);
			usBean.setStrate(starray);
			usBean.setRtrate(rtarray);
			usBean.setMrp(mrparray);
			usBean.setAmounta(amountaarray);
		}
		catch(Exception a)
		{
			System.out.println("error on material master edit "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return usBean;
}
//materialdelete
public static boolean mtdelete(int id)// materail group delete
{
	FormBean usBean=new FormBean();
	boolean result=false;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String matcode="";
	try
	{
		
		String sql="delete from materialgroupmaster where id='"+id+"'";
		//System.out.println(sql);
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		
	}
	catch(Exception a)
	{
		System.out.println("error on headdelete "+a);
	}
	ConnectionDAO.closeConnection(conn);
	return result;
}
//purchaseentrylist
public static List<FormBean> purchaseentrylist(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	FormBean usBean;
	ResultSet rs;
	String sql="";
	try
	{
		int sr=1;
		sql="select * from itransaction";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			usBean=new FormBean();
			usBean.setId(rs.getInt(1));
			usBean.setCompany(findledger(rs.getString(4)));
			usBean.setDebitac(findledger(rs.getString(5)));
			usBean.setTotalamount("Rs. "+rs.getString(10));
			usBean.setNetamount("Rs. "+rs.getString(18));
		//	usBean.setcategoryer(findcategoryer(rs.getString(9)));
			String xx=findmaterial(rs.getString(3));
			//System.out.println(xx);
			usBean.setMaterial(xx.substring(1, xx.length()));
			//usBean.setMaterial("");
			l1.add(usBean);
			//sr++;
		}
	}
	catch(Exception error)
	{
		//System.out.println("error found on purchase entry list "+error);
		error.printStackTrace();
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}
public static String findmaterial(String vno)
{
	//System.out.println(vno);
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",matcode="";
	try
	{
		sql="select * from idetails where voucherno='"+vno+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			matcode=matcode+","+findmaterialname(rs.getString(4));
		}
	}
	catch(Exception gggggg)
	{
		System.out.println("error in findcategoryer "+gggggg);
	}
	ConnectionDAO.closeConnection(conn);
	return matcode;
}
public static String findmaterial1(String vno)
{
	//System.out.println(vno);
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",matcode="";
	try
	{
		sql="select * from idetails where voucherno='"+vno+"'";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			matcode=matcode+", "+findmaterialname(rs.getString(4))+"(Offered "+rs.getString(8).substring(0, rs.getString(8).length()-3)+" on "+rs.getString(5).substring(0, rs.getString(5).length()-3)+")";
		}
	}
	catch(Exception gggggg)
	{
		System.out.println("error in findcategoryer "+gggggg);
	}
	//System.out.println(matcode);
	ConnectionDAO.closeConnection(conn);
	return matcode;
}
public static String findmaterialname(String vno)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",mat="";
	try
	{
		sql="select * from materialmaster where matcode='"+vno+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			mat=rs.getString(3);
		}
	}
	catch(Exception gggggg)
	{
		System.out.println("error in findcategoryer "+gggggg);
	}
	ConnectionDAO.closeConnection(conn);
	return mat;
}
public static String findcategoryer(String id)
{
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String sql="",name="";
	try
	{
		sql="select trname from categorymaster where trcode='"+id+"'";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			name=rs.getString(1);
		}
	}
	catch(Exception gggggg)
	{
		System.out.println("error in findcategoryer "+gggggg);
	}
	ConnectionDAO.closeConnection(conn);
	return name;
}
//purchaseentrycreation
	public static boolean purchaseentrycreation(FormBean FormBean) 
	{
		boolean result = false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		if(FormBean.getId() != null)
		{
			try
			{
				String sql="",voucherno="",round="";
				double crbal=0.00;
				sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					voucherno=rs.getString(1);
				}
				if(FormBean.getRoundoff().equals("1"))
				{
					round="Y";
				}
				else if(FormBean.getRoundoff().equals("2"))
				{
					round="N";
				}
				
				
				String crstock="",freecrstock="";
				double aqty=0.00,fqty=0.00;
				String hpname[]=FormBean.getHpname(),haqty[]=FormBean.getHaqtyd(),hfqty[]=FormBean.getHfqtyd(),hunit[]=FormBean.getHunitd(),hamount[]=FormBean.getHamountd();
				for(int i=0;i<hpname.length;i++)
				{
					sql="select crstock,freecrstock from materialmaster where matname='"+hpname[i]+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						crstock=rs.getString(1);
						freecrstock=rs.getString(2);
					}
					sql="select aqty,fqty from idetails where matcode=(select matcode from materialmaster where matname='"+hpname[i]+"')";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						aqty=rs.getDouble(1);
						fqty=rs.getDouble(2);
					}
					sql="update materialmaster set crstock='"+(Double.parseDouble(crstock)-aqty)+"', freecrstock='"+(Double.parseDouble(freecrstock)-fqty)+"' where matname='"+hpname[i]+"'";
					result=ConnectionDAO.executeUpdate(stm, sql);
					//System.out.println(sql);
				}
				Vector<String> batchno=new Vector<String>();
				
				for(int i=0;i<hpname.length;i++)
				{
					//int count=0;
					sql="select batchno from ibatchdetails where matcode=(select matcode from materialmaster where matname='"+hpname[i]+"')";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						batchno.add(rs.getString(1));
					}
					//System.out.println("hello "+batchno.size());
					for(int j=0;j<batchno.size();j++)
					{
						/*sql="select count(batchno) from batchmaster where batchno='"+batchno.get(j)+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							count=rs.getInt(1);
						}
						if(count == 0)//if batchno not exist in batchmaster
						{
							sql="insert into batchmaster(matcode, batchno, exdt, opstocka, crstocka, opstockf, crstockf, purate, strate, rtrate, mrprate, amount)";
							sql=sql+"values((select matcode from materialmaster where matname='"+hpname[i]+"'), '"+batchno.get(j)+"', (select exdt from ibatchdetails where batchno='"+batchno.get(j)+"'), ";
							sql=sql+"'0', (select aqty from ibatchdetails where batchno='"+batchno.get(j)+"'), '0', (select fqty from ibatchdetails where batchno='"+batchno.get(j)+"'), (select pu from ibatchdetails where batchno='"+batchno.get(j)+"'), ";
							sql=sql+"(select td from ibatchdetails where batchno='"+batchno.get(j)+"'), (select rt from ibatchdetails where batchno='"+batchno.get(j)+"'), (select mrp from ibatchdetails where batchno='"+batchno.get(j)+"'), (select amount from ibatchdetails where batchno='"+batchno.get(j)+"') )";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}*/
						
							double x=0.00,x1=0.00,x2=0.00,x3=0.00,t=0.00;
							sql="select crstocka,crstockf,amount from batchmaster where batchno='"+batchno.get(j)+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								x=rs.getDouble(1);
								x1=rs.getDouble(2);
								//x2=rs.getDouble(3);
							}
							//t=t+(x*)
							sql="update batchmaster set crstocka='"+x+"'-(select aqty from ibatchdetails where batchno='"+batchno.get(j)+"'), crstockf='"+x1+"'-(select fqty from ibatchdetails where batchno='"+batchno.get(j)+"') where batchno='"+batchno.get(j)+"'";
							System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
							
							sql="select * from batchmaster where batchno='"+batchno.get(j)+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								x2=rs.getDouble(6);
								x3=rs.getDouble(9);
							}
							sql="update batchmaster set amount='"+(x2*x3)+"' where batchno='"+batchno.get(j)+"'";
							result=ConnectionDAO.executeUpdate(stm, sql);
							System.out.println(sql);
						
					}
				}
				batchno.removeAllElements();
				sql="delete from idetails where voucherno='"+voucherno+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="delete from ibatchdetails where voucherno='"+voucherno+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				double xx=0.00,yy=0.00;
				for(int i=0;i<hpname.length;i++)
				{
					sql="insert into idetails(entrydate, voucherno, matcode, aqty, fqty, unit1, amount)values";
					sql=sql+"('"+FormBean.getDate1()+"', '"+voucherno+"', (select matcode from materialmaster where matname='"+hpname[i]+"'), '"+haqty[i]+"', '"+hfqty[i]+"', '"+hunit[i]+"', '"+hamount[i]+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select crstock,freecrstock from materialmaster where matname='"+hpname[i]+"'";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						xx=rs.getDouble(1);
						yy=rs.getDouble(2);
						//System.out.println("hello "+xx+","+yy);
					}
					sql="update materialmaster set crstock='"+(xx+Double.parseDouble(haqty[i]))+"', freecrstock='"+(yy+Double.parseDouble(hfqty[i]))+"' where matname='"+hpname[i]+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}
				
				sql="insert into ibatchdetails select * from ibatchdetailsdummy";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="update accountnarration set narration='"+FormBean.getSinglenarration()+"' where voucherno='"+voucherno+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
			//update ledgermaster
				sql="select currentbalance from ledgermaster where ledgerid=(select principal from itransaction where voucherno='"+voucherno+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance=(select netamount from itransaction where voucherno='"+voucherno+"')+'"+crbal+"' where ledgerid=(select principal from itransaction where voucherno='"+voucherno+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			//ledgermaster update end
				
			//update subgroup master
				sql="select currentbalance from subgroupmaster where subgroupcode=(select left(principal,5) from itransaction where voucherno='"+voucherno+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance=(select netamount from itransaction where voucherno='"+voucherno+"')+'"+crbal+"' where subgroupcode=(select left(principal,5) from itransaction where voucherno='"+voucherno+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			//subgroup master update end
				
			//update groupmaster
				sql="select closingbalance from groupmaster where groupcode=(select left(principal,2) from itransaction where voucherno='"+voucherno+"')";				
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance=(select netamount from itransaction where voucherno='"+voucherno+"')+'"+crbal+"' where groupcode=(select left(principal,2) from itransaction where voucherno='"+voucherno+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			//groupmaster update end
			
			//update ledgermaster
				sql="select currentbalance from ledgermaster where ledgerid=(select debitac from itransaction where voucherno='"+voucherno+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance=(select netamount from itransaction where voucherno='"+voucherno+"')-'"+crbal+"' where ledgerid=(select debitac from itransaction where voucherno='"+voucherno+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			//ledgermaster update end
				
			//update subgroup master
				sql="select currentbalance from subgroupmaster where subgroupcode=(select left(debitac,5) from itransaction where voucherno='"+voucherno+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance=(select netamount from itransaction where voucherno='"+voucherno+"')-'"+crbal+"' where subgroupcode=(select left(debitac,5) from itransaction where voucherno='"+voucherno+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			//subgroup master update end
				
			//update groupmaster
				sql="select closingbalance from groupmaster where groupcode=(select left(debitac,2) from itransaction where voucherno='"+voucherno+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance=(select netamount from itransaction where voucherno='"+voucherno+"')-'"+crbal+"' where groupcode=(select left(debitac,2) from itransaction where voucherno='"+voucherno+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			//groupmaster update end
				
				sql="update itransaction set entrydate='"+FormBean.getDate1()+"', principal=(select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), ";
				sql=sql+"debitac=(select ledgerid from ledgermaster where ledgername='"+FormBean.getDebitac()+"'), challanno='"+FormBean.getChallanno()+"', challandate='"+FormBean.getDated()+"', ";
				sql=sql+"truckno='"+FormBean.getTruckrr()+"', tcode=(select trcode from categorymaster where trname='"+FormBean.getCategory()+"'), totalamount='"+FormBean.getTotalamount()+"', ";
				sql=sql+"disc='"+FormBean.getDisc()+"', discp='"+FormBean.getDiscp()+"', taxtype='"+FormBean.getTaxselect().substring(0,1)+"', taxc='"+FormBean.getTaxc()+"', taxamount='"+FormBean.getTax()+"', ";
				sql=sql+"otheramount='"+FormBean.getOamount()+"', addamount='"+FormBean.getAddamount()+"', lessamount='"+FormBean.getLessamount()+"', subtotal='"+FormBean.getSubtotal()+"', netamount='"+FormBean.getNetamount()+"', ";
				sql=sql+"roundoff='"+round+"', roundofft='"+FormBean.getRoundofft()+"', subtotal1='"+FormBean.getSubtotal1()+"', billno='"+FormBean.getBillno()+"', billdate='"+FormBean.getBilldate()+"' where id='"+FormBean.getId()+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			    
				sql="select currentbalance from ledgermaster where ledgername='"+FormBean.getCompany()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance='"+(crbal-Double.parseDouble(FormBean.getNetamount()))+"' where ledgername='"+FormBean.getCompany()+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(crbal-Double.parseDouble(FormBean.getNetamount()))+"' where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(crbal-Double.parseDouble(FormBean.getNetamount()))+"' where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from ledgermaster where ledgername='"+FormBean.getDebitac()+"'";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance='"+(crbal+Double.parseDouble(FormBean.getNetamount()))+"' where ledgername='"+FormBean.getDebitac()+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(crbal+Double.parseDouble(FormBean.getNetamount()))+"' where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(crbal+Double.parseDouble(FormBean.getNetamount()))+"' where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//Vector<String> batchno=new Vector<String>();
				int count=0;
				for(int i=0;i<hpname.length;i++)
				{
					sql="select batchno from ibatchdetails where matcode=(select matcode from materialmaster where matname='"+hpname[i]+"')";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						batchno.add(rs.getString(1));
					}
					//System.out.println("hello "+batchno.size());
					for(int j=0;j<batchno.size();j++)
					{
						sql="select count(batchno) from batchmaster where batchno='"+batchno.get(j)+"'";
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							count=rs.getInt(1);
						}
						if(count == 0)//if batchno not exist in batchmaster
						{
							sql="insert into batchmaster(matcode, batchno, exdt, opstocka, crstocka, opstockf, crstockf, purate, strate, rtrate, mrprate, amount)";
							sql=sql+"values((select matcode from materialmaster where matname='"+hpname[i]+"'), '"+batchno.get(j)+"', (select exdt from ibatchdetails where batchno='"+batchno.get(j)+"'), ";
							sql=sql+"'0', (select aqty from ibatchdetails where batchno='"+batchno.get(j)+"'), '0', (select fqty from ibatchdetails where batchno='"+batchno.get(j)+"'), (select pu from ibatchdetails where batchno='"+batchno.get(j)+"'), ";
							sql=sql+"(select td from ibatchdetails where batchno='"+batchno.get(j)+"'), (select rt from ibatchdetails where batchno='"+batchno.get(j)+"'), (select mrp from ibatchdetails where batchno='"+batchno.get(j)+"'), (select amount from ibatchdetails where batchno='"+batchno.get(j)+"') )";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
						else if(count > 0)//if batchno exist in batchmaster
						{
							double x=0.00,x1=0.00,x2=0.00,x3=0.00,t=0.00;
							sql="select crstocka,crstockf,amount from batchmaster where batchno='"+batchno.get(j)+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								x=rs.getDouble(1);
								x1=rs.getDouble(2);
								//x2=rs.getDouble(3);
							}
							//t=t+(x*)
							sql="update batchmaster set crstocka=(select aqty from ibatchdetails where batchno='"+batchno.get(j)+"')+'"+x+"', crstockf=(select fqty from ibatchdetails where batchno='"+batchno.get(j)+"')+'"+x1+"' where batchno='"+batchno.get(j)+"'";
							System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
							
							sql="select * from batchmaster where batchno='"+batchno.get(j)+"'";
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								x2=rs.getDouble(6);
								x3=rs.getDouble(9);
							}
							sql="update batchmaster set amount='"+(x2*x3)+"' where batchno='"+batchno.get(j)+"'";
							result=ConnectionDAO.executeUpdate(stm, sql);
							System.out.println(sql);
						}
					}
				}
				sql="delete from ibatchdetailsdummy";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="delete from accounttransaction where voucherno='"+voucherno+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="delete from accountdetails where voucherno='"+voucherno+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="insert into accounttransaction(entrydate, voucherno, referenceno, referencedate, ledgerid, totalamount, vouchertype)values('"+FormBean.getDate1()+"', '"+voucherno+"', '"+FormBean.getBillno()+"', '"+FormBean.getBilldate()+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), '"+FormBean.getNetamount()+"', 'cr')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount)values('"+voucherno+"', '"+FormBean.getDate1()+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), '-"+FormBean.getNetamount()+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount)values('"+voucherno+"', '"+FormBean.getDate1()+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getDebitac()+"'), '"+FormBean.getNetamount()+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
			}
			catch(Exception error)
			{
				//System.out.println("purchase entry update error "+error);
				error.printStackTrace();
			}
		}
		else
		{
			try
			{
				String v1st="UD",voucher="",y="1718",prevno="";
				int c=0;
				long crstock=0,freecrstock=0;
				String sql="select voucherno from itransaction where id=(select max(id) from itransaction)";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					prevno=rs.getString(1);
				}
				/*String sql="select count(voucherno) from itransaction";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					c=rs.getInt(1);
				}*/
				c=Integer.parseInt(prevno.substring(10, prevno.length()));
				if(c==0)
				{
					voucher=v1st+y+y+"0000"+(c+1);
				}
				else if(c > 0 && c < 9)
				{
					voucher=v1st+y+y+"0000"+(c+1);
				}
				else if(c > 8 && c < 99)
				{
					voucher=v1st+y+y+"000"+(c+1);
				}
				else if(c > 98 && c < 999)
				{
					voucher=v1st+y+y+"00"+(c+1);
				}
				else if(c > 998 && c < 9999)
				{
					voucher=v1st+y+y+"0"+(c+1);
				}
				else if(c > 9998 && c < 99999)
				{
					voucher=v1st+y+y+(c+1);
				}
				String r="";
				if(FormBean.getRoundoff().equals("1"))
				{
					r="Y";
				}
				else if(FormBean.getRoundoff().equals("2"))
				{
					r="N";
				}
				sql="insert into itransaction(entrydate, voucherno, principal, debitac, challanno, challandate, truckno, tcode, totalamount, disc, taxtype, taxamount, otheramount, addamount, lessamount, subtotal, subtotal1, netamount, discp, taxc, roundoff, roundofft, billno, billdate)";
				sql=sql+"values('"+FormBean.getDate1()+"', '"+voucher+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), (select ledgerid from ledgermaster where ledgername='"+FormBean.getDebitac()+"'),"; 
				sql=sql+"'"+FormBean.getChallanno()+"', '"+FormBean.getDated()+"', '"+FormBean.getTruckrr()+"', (select trcode from categorymaster where trname='"+FormBean.getCategory()+"'), '"+FormBean.getTotalamount()+"', '"+FormBean.getDisc()+"',";
				sql=sql+"'"+FormBean.getTaxselect().substring(0,1)+"', '"+FormBean.getTax()+"', '"+FormBean.getOamount()+"', '"+FormBean.getAddamount()+"', '"+FormBean.getLessamount()+"', '"+FormBean.getSubtotal()+"', '"+FormBean.getSubtotal1()+"', '"+FormBean.getNetamount()+"', '"+FormBean.getDiscp()+"', '"+FormBean.getTaxc()+"', '"+r+"', '"+FormBean.getRoundofft()+"', '"+FormBean.getBillno()+"', '"+FormBean.getBilldate()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//System.out.println();
				String pname[]=FormBean.getPname(),aqtyd[]=FormBean.getAqtyd(),fqtyd[]=FormBean.getFqtyd(),unitd[]=FormBean.getUnitd(),amountd[]=FormBean.getAmountd();
				for(int i=0;i<pname.length;i++)
				{
					sql="insert into idetails(entrydate, voucherno, matcode, aqty, fqty, unit1, amount)";
					sql=sql+"values('"+FormBean.getDate1()+"', '"+voucher+"', (select matcode from materialmaster where matname='"+pname[i]+"'), '"+aqtyd[i]+"', '"+fqtyd[i]+"',";
					sql=sql+"'"+unitd[i]+"', '"+amountd[i]+"')";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					sql="select crstock,freecrstock from materialmaster where matname='"+pname[i]+"'";
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						crstock=rs.getLong(1);
						freecrstock=rs.getShort(2);
					}
					sql="update materialmaster set crstock='"+(crstock+Long.parseLong(aqtyd[i]))+"', freecrstock='"+(freecrstock+Long.parseLong(fqtyd[i]))+"' where matname='"+pname[i]+"'";
					//System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
					
					/*sql="delete from batchmaster where matcode=(select matcode from materialmaster where matname='"+pname[i]+"')";
					System.out.println(sql);
					result=ConnectionDAO.executeUpdate(stm, sql);*/
				}
				
				sql="insert into accountnarration(voucherno, narration, vouchertype)values('"+voucher+"', '"+FormBean.getSinglenarration()+"', 'cr')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				//System.out.println();
				sql="insert into ibatchdetails select * from ibatchdetailsdummy";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="insert into outstandingledger(ledgerid, voucherno, referenceno, referencedate, billamount, adjustmentamount, duesamount, vouchertype)values((select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), '"+voucher+"', '"+FormBean.getBillno()+"', '"+FormBean.getBilldate()+"', '"+FormBean.getNetamount()+"', '0', '"+FormBean.getNetamount()+"', 'c')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="insert into accounttransaction(entrydate, voucherno, referenceno, referencedate, ledgerid, totalamount, vouchertype)values('"+FormBean.getDate1()+"', '"+voucher+"', '"+FormBean.getBillno()+"', '"+FormBean.getBilldate()+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), '"+FormBean.getNetamount()+"', 'cr')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount)values('"+voucher+"', '"+FormBean.getDate1()+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), '-"+FormBean.getNetamount()+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				sql="insert into accountdetails(voucherno, entrydate, ledgerid, amount)values('"+voucher+"', '"+FormBean.getDate1()+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getDebitac()+"'), '"+FormBean.getNetamount()+"')";
				result=ConnectionDAO.executeUpdate(stm, sql);
				//System.out.println(sql);
				
				double crbal=0.00;
				sql="select currentbalance from ledgermaster where ledgername='"+FormBean.getCompany()+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance='"+(crbal-Double.parseDouble(FormBean.getNetamount()))+"' where ledgername='"+FormBean.getCompany()+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(crbal-Double.parseDouble(FormBean.getNetamount()))+"' where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(crbal-Double.parseDouble(FormBean.getNetamount()))+"' where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getCompany()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				
				sql="select currentbalance from ledgermaster where ledgername='"+FormBean.getDebitac()+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update ledgermaster set currentbalance='"+(crbal+Double.parseDouble(FormBean.getNetamount()))+"' where ledgername='"+FormBean.getDebitac()+"'";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select currentbalance from subgroupmaster where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update subgroupmaster set currentbalance='"+(crbal+Double.parseDouble(FormBean.getNetamount()))+"' where subgroupcode=(select left(ledgerid,5) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
				
				sql="select closingbalance from groupmaster where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crbal=rs.getDouble(1);
				}
				sql="update groupmaster set closingbalance='"+(crbal+Double.parseDouble(FormBean.getNetamount()))+"' where groupcode=(select left(ledgerid,2) from ledgermaster where ledgername='"+FormBean.getDebitac()+"')";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);

				Vector<String> batchno=new Vector<String>();
				/*Vector<String> batchno=new Vector<String>();
				Vector<String> exdt=new Vector<String>();
				Vector<String> aqty=new Vector<String>();
				Vector<String> fqty=new Vector<String>();
				Vector<String> pu=new Vector<String>();
				Vector<String> td=new Vector<String>();
				Vector<String> rt=new Vector<String>();
				Vector<String> mrp=new Vector<String>();
				Vector<String> amount=new Vector<String>();
				sql="select * from ibatchdetailsdummy";
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					matcode.add(rs.getString(13));
					batchno.add(rs.getString(4));
					exdt.add(rs.getString(5));
					aqty.add(rs.getString(6));
					fqty.add(rs.getString(7));
					pu.add(rs.getString(8));
					td.add(rs.getString(9));
					rt.add(rs.getString(10));
					mrp.add(rs.getString(11));
					amount.add(rs.getString(12));
				}
				for(int i=0;i<matcode.size();i++)
				{
					sql="insert into batchmaster(matcode, batchno, exdt, opstocka, crstocka, opstockf, crstockf, purate, strate, rtrate, mrprate, amount)";
					sql=sql+"values('"+matcode.get(i)+"', '"+batchno.get(i)+"', '"+exdt.get(i)+"', '"+aqty.get(i)+"', '"+aqty.get(i)+"', '"+fqty.get(i)+"', '"+fqty.get(i)+"', '"+pu.get(i)+"', '"+td.get(i)+"', '"+rt.get(i)+"', '"+mrp.get(i)+"', '"+amount.get(i)+"')";
					System.out.println("ibatchdetailsdummy to batchmaster: "+sql);
					result=ConnectionDAO.executeUpdate(stm, sql);
				}*/
				int count=0;
				for(int i=0;i<pname.length;i++)
				{
					sql="select batchno from ibatchdetails where matcode=(select matcode from materialmaster where matname='"+pname[i]+"')";
					//System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						batchno.add(rs.getString(1));
					}
					for(int j=0;j<batchno.size();j++)
					{
						sql="select count(batchno) from batchmaster where batchno='"+batchno.get(j)+"'";
						//System.out.println(sql);
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							count=rs.getInt(1);
						}
						if(count == 0)//if batchno not exist in batchmaster
						{
							sql="insert into batchmaster(matcode, batchno, exdt, opstocka, crstocka, opstockf, crstockf, purate, strate, rtrate, mrprate, amount)";
							sql=sql+"values((select matcode from materialmaster where matname='"+pname[i]+"'), '"+batchno.get(j)+"', (select exdt from ibatchdetails where batchno='"+batchno.get(j)+"'), ";
							sql=sql+"'0', (select aqty from ibatchdetails where batchno='"+batchno.get(j)+"'), '0', (select fqty from ibatchdetails where batchno='"+batchno.get(j)+"'), (select pu from ibatchdetails where batchno='"+batchno.get(j)+"'), ";
							sql=sql+"(select td from ibatchdetails where batchno='"+batchno.get(j)+"'), (select rt from ibatchdetails where batchno='"+batchno.get(j)+"'), (select mrp from ibatchdetails where batchno='"+batchno.get(j)+"'), (select amount from ibatchdetails where batchno='"+batchno.get(j)+"') )";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
						else if(count > 0)//if batchno exist in batchmaster
						{
							double x=0.00,x1=0.00;
							sql="select crstocka,crstockf from batchmaster where batchno='"+batchno.get(j)+"'";
							//System.out.println(sql);
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								x=rs.getDouble(1);
								x1=rs.getDouble(2);
							}
							sql="update batchmaster set crstocka=(select aqty from ibatchdetails where batchno='"+batchno.get(j)+"')+'"+x+"', crstockf=(select fqty from ibatchdetails where batchno='"+batchno.get(j)+"')+'"+x1+"' where batchno='"+batchno.get(j)+"'";
							//System.out.println(sql);
							result=ConnectionDAO.executeUpdate(stm, sql);
						}
					}
				}
				sql="delete from ibatchdetailsdummy";
				//System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			catch(Exception error)
			{
				error.printStackTrace();
			}
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}
//purchaseentrydelet
	public static boolean purchaseentrydelete(int id)
	{
		FormBean usBean=new FormBean();
		boolean result=false;
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		ResultSet rs;
		String sql="",sql1="",sql2="";
		Vector<String> matcode=new Vector<String>();
		Vector<String> batchno=new Vector<String>();
		Vector<String> aqty=new Vector<String>();
		Vector<String> fqty=new Vector<String>();
		double crbal=0.00;
		long crstock=0,freecrstock=0;
		try
		{
			sql="select matcode,aqty,fqty from idetails where voucherno=(select voucherno from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				matcode.add(rs.getString(1));
				aqty.add(rs.getString(2));
				fqty.add(rs.getString(3));
			}
			for(int i=0;i<matcode.size();i++)
			{
				sql="select crstock,freecrstock from materialmaster where matcode='"+matcode.get(i)+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					crstock=rs.getLong(1);
					freecrstock=rs.getLong(2);
				}
				sql="update materialmaster set crstock='"+(crstock-Long.parseLong(aqty.get(i)))+"', freecrstock='"+(freecrstock-Long.parseLong(fqty.get(i)))+"' where matcode='"+matcode.get(i)+"'";
				result=ConnectionDAO.executeUpdate(stm, sql);
				System.out.println(sql);
				//sql="update batchmaster set crstocka=";
			}
		//update ledgermaster
			sql="select currentbalance from ledgermaster where ledgerid=(select principal from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				crbal=rs.getDouble(1);
			}
			sql="update ledgermaster set currentbalance=(select netamount from itransaction where id='"+id+"')+'"+crbal+"' where ledgerid=(select principal from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			System.out.println(sql);
		//ledgermaster update end
			
		//update subgroup master
			sql="select currentbalance from subgroupmaster where subgroupcode=(select left(principal,5) from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				crbal=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance=(select netamount from itransaction where id='"+id+"')+'"+crbal+"' where subgroupcode=(select left(principal,5) from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			System.out.println(sql);
		//subgroup master update end
			
		//update groupmaster
			sql="select closingbalance from groupmaster where groupcode=(select left(principal,2) from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				crbal=rs.getDouble(1);
			}
			sql="update groupmaster set closingbalance=(select netamount from itransaction where id='"+id+"')+'"+crbal+"' where groupcode=(select left(principal,2) from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			System.out.println(sql);
		//groupmaster update end
		
		//update ledgermaster
			sql="select currentbalance from ledgermaster where ledgerid=(select debitac from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				crbal=rs.getDouble(1);
			}
			sql="update ledgermaster set currentbalance=(select netamount from itransaction where id='"+id+"')-'"+crbal+"' where ledgerid=(select debitac from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			System.out.println(sql);
		//ledgermaster update end
			
		//update subgroup master
			sql="select currentbalance from subgroupmaster where subgroupcode=(select left(debitac,5) from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				crbal=rs.getDouble(1);
			}
			sql="update subgroupmaster set currentbalance=(select netamount from itransaction where id='"+id+"')-'"+crbal+"' where subgroupcode=(select left(debitac,5) from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			System.out.println(sql);
		//subgroup master update end
			
		//update groupmaster
			sql="select closingbalance from groupmaster where groupcode=(select left(debitac,2) from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				crbal=rs.getDouble(1);
			}
			sql="update groupmaster set closingbalance=(select netamount from itransaction where id='"+id+"')-'"+crbal+"' where groupcode=(select left(debitac,2) from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			System.out.println(sql);
		//groupmaster update end
			
			aqty.removeAllElements();
			fqty.removeAllElements();
			
			sql="select * from ibatchdetails where voucherno=(select voucherno from itransaction where id='"+id+"')";
			System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				batchno.add(rs.getString(4));
				aqty.add(rs.getString(6));
				fqty.add(rs.getString(7));
			}
			for(int i=0;i<batchno.size();i++)
			{
				double x=0.00,x1=0.00,x2=0.00;
				sql="select * from batchmaster where batchno='"+batchno.get(i)+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					x=rs.getDouble(6);
					x1=rs.getDouble(8);
				}
				sql="update batchmaster set crstocka='"+(x-Double.parseDouble(aqty.get(i)))+"', crstockf='"+(x1-Double.parseDouble(fqty.get(i)))+"' where batchno='"+batchno.get(i)+"'";
				System.out.println(sql);
				result=ConnectionDAO.executeUpdate(stm, sql);
			}
			sql="delete from ibatchdetails where voucherno=(select voucherno from itransaction where id='"+id+"')";
			sql1="delete from idetails where voucherno=(select voucherno from itransaction where id='"+id+"')";
			sql2="delete from itransaction where id='"+id+"'";
			System.out.println(sql);
			System.out.println(sql1);
			System.out.println(sql2);
			result=ConnectionDAO.executeUpdate(stm, sql);
			result=ConnectionDAO.executeUpdate(stm, sql1);
			result=ConnectionDAO.executeUpdate(stm, sql2);
			sql="delete from accounttransaction where voucherno=(select voucherno from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
			sql="delete from accountdetails where voucherno=(select voucherno from itransaction where id='"+id+"')";
			result=ConnectionDAO.executeUpdate(stm, sql);
		}
		catch(Exception a)
		{
			System.out.println("error on purchaseentry delete "+a);
		}
		ConnectionDAO.closeConnection(conn);
		return result;
	}
//purchaseentryedit
	public static FormBean purchaseentryedit(int id)
    {
        FormBean usBean=new FormBean();
        Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
        ResultSet rs;
        try
        {
            String sql="select * from itransaction where id='"+id+"'";
            //System.out.println(sql);
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                usBean.setId(rs.getInt(1));
                usBean.setDate1(rs.getString(2));
                usBean.setCompany(findledger(rs.getString(4)));
                usBean.setDebitac(findledger(rs.getString(5)));
                usBean.setChallanno(rs.getString(6));
                usBean.setDated(rs.getString(7));
                usBean.setDisc(rs.getString(11));
                usBean.setTruckrr(rs.getString(8));
                usBean.setBillno(rs.getString(24));
                usBean.setBilldate(rs.getString(25));
                usBean.setVno(rs.getString(3).substring(rs.getString(3).length()-1, rs.getString(3).length()));
                if(rs.getString(12).equals("C"))
                {
                    usBean.setTaxselect("CST");
                }
                else if(rs.getString(12).equals("L"))
                {
                    usBean.setTaxselect("LST");
                }
                usBean.setTax(rs.getString(13));
                usBean.setCategory(findcategoryer(rs.getString(9)));
                usBean.setOamount(rs.getString(14));
                usBean.setAddamount(rs.getString(15));
                usBean.setLessamount(rs.getString(16));
                usBean.setSubtotal(rs.getString(17));
                usBean.setNetamount(rs.getString(18));
                usBean.setTotalamount(rs.getString(10));
                usBean.setDiscp(rs.getString(19));
                usBean.setTaxc(rs.getString(20));
                usBean.setSubtotal1(rs.getString(23));
                if(rs.getString(21).equals("N"))
                {
                    usBean.setRoundoff("2");
                }
                else if(rs.getString(21).equals("Y"))
                {
                    usBean.setRoundoff("1");
                }
                usBean.setRoundofft(rs.getString(22));
            }
            sql="select narration from accountnarration where voucherno=(select voucherno from itransaction where id='"+id+"')";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
            	usBean.setSinglenarration(rs.getString(1));
            }
            //dynamic edit
            //vectors
            Vector<String> matcode=new Vector<String>();
            Vector<String> aqty=new Vector<String>();
            Vector<String> fqty=new Vector<String>();
            Vector<String> unit1=new Vector<String>();
            Vector<String> amount=new Vector<String>();
            sql="select * from idetails where voucherno=(select voucherno from itransaction where id='"+id+"')";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                matcode.add(findmaterialname(rs.getString(4)));
                //System.out.println("got+ "+findmaterialname(rs.getString(4)));
                aqty.add(rs.getString(5));
                fqty.add(rs.getString(6));
                unit1.add(rs.getString(7));
                amount.add(rs.getString(8));
            }
            //System.out.println(matcode.size());
            if(matcode.size() > 0)
            {
            //arrays
            String matcodearray[]=new String[matcode.size()];
            String aqtyarray[]=new String[matcode.size()];
            String fqtyarray[]=new String[matcode.size()];
            String unit1array[]=new String[matcode.size()];
            String amountarray[]=new String[matcode.size()];
            for(int i=0;i<matcode.size();i++)
            {
                matcodearray[i]=matcode.get(i);
                aqtyarray[i]=aqty.get(i);
                fqtyarray[i]=fqty.get(i);
                unit1array[i]=unit1.get(i);
                amountarray[i]=amount.get(i);
                //System.out.println("got "+matcodearray[i]);
            }
            usBean.setBoard(matcodearray);
            usBean.setAqtyd(aqtyarray);
            usBean.setFqtyd(fqtyarray);
            usBean.setUnitd(unit1array);
            usBean.setAmountd(amountarray);
            }
            else if(matcode.size() == 0)
            {
            	String matcodearray[]=new String[0];
            	String aqtyarray[]=new String[0];
            	String fqtyarray[]=new String[0];
            	String unit1array[]=new String[0];
            	String amountarray[]=new String[0];
            	usBean.setBoard(matcodearray);
                usBean.setAqtyd(aqtyarray);
                usBean.setFqtyd(fqtyarray);
                usBean.setUnitd(unit1array);
                usBean.setAmountd(amountarray);
            }
        }
        catch(Exception a)
        {
            System.out.println("error on purchaseentry edit "+a);
        }
        ConnectionDAO.closeConnection(conn);
        return usBean;
    }
//list4material
	public static List<FormBean> list4material(int id,FormBean formbean)
    {
        List<FormBean> l1 = new ArrayList<FormBean>();
        Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
       
        ResultSet rs;
        String sql="";
        try
        {
        	FormBean usBean=new FormBean();
            usBean.setPart("");
            l1.add(usBean);
            sql="select * from materialmaster where ledgerid=(select principal from itransaction where id='"+id+"')";
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                //System.out.println(rs.getString(3));
                usBean=new FormBean();
                usBean.setPart(rs.getString(3));
                l1.add(usBean);
            }
        }
        catch(Exception error)
        {
            System.out.println("error found on purchase entry list "+error);
        }
        ConnectionDAO.closeConnection(conn);
        return l1;
    }
//schemelist
	public static List<FormBean> schemelist(FormBean formbean)
	{
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		FormBean usBean;
		ResultSet rs;
		String sql="";
		try
		{
			sql=" select * from itransaction where voucherno like 'BS%'";
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				usBean=new FormBean();
				usBean.setCompany(findledger(rs.getString(4)));
				//System.out.println(findledger(rs.getString(4)));
				String xx=findmaterial1(rs.getString(3));
				usBean.setMaterial(xx.substring(1, xx.length()));
				usBean.setPeriod(rs.getString(26)+" to "+rs.getString(27));
				l1.add(usBean);
			}
		}
		catch(Exception error)
		{
			error.printStackTrace();
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
//incentiveschemecreation
	public static boolean incentiveschemecreation(FormBean FormBean) 
	{
		boolean result=false;
		Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
        ResultSet rs;
        String sql="",voucherno="";
        int count=0;
        try
        {
        	sql="select count(voucherno) from itransaction where voucherno like 'BS%'";
        	rs=stm.executeQuery(sql);
        	while(rs.next())
        	{
        		count=rs.getInt(1);
        	}
        	if(count == 0)
        	{
        		voucherno="BS"+"171817180000"+(count+1);
        	}
        	else if(count > 0 && count < 9)
        	{
        		voucherno="BS"+"171817180000"+(count+1);
        	}
        	else if(count > 8 && count < 99)
        	{
        		voucherno="BS"+"17181718000"+(count+1);
        	}
        	else if(count > 98 && count < 999)
        	{
        		voucherno="BS"+"1718171800"+(count+1);
        	}
        	else if(count > 998 && count < 9999)
        	{
        		voucherno="BS"+"171817180"+(count+1);
        	}
        	else if(count > 9998 && count < 99999)
        	{
        		voucherno="BS"+"17181718"+(count+1);
        	}
        	sql="insert into itransaction(entrydate, voucherno, principal, billno, billdate, fromdate, todate)values('"+FormBean.getDate1()+"', '"+voucherno+"', (select ledgerid from ledgermaster where ledgername='"+FormBean.getCompany()+"'), '"+FormBean.getRefno()+"', '"+FormBean.getRefdate()+"', '"+FormBean.getFrom()+"', '"+FormBean.getTo()+"')";
        	result=ConnectionDAO.executeUpdate(stm, sql);
        	System.out.println(sql);
        	
        	sql="insert into accountnarration(voucherno, narration,vouchertype)values('"+voucherno+"', '"+FormBean.getSinglenarration()+"', 'bs')";
        	result=ConnectionDAO.executeUpdate(stm, sql);
        	System.out.println(sql);
        	
        	String pname[]=FormBean.getPname(),minqty[]=FormBean.getMinqty(),extra[]=FormBean.getExtra(),offeredmin[]=FormBean.getOfferedmin();
        		for(int i=0; i<pname.length; i++)
        		{
        			sql="insert into idetails(entrydate, voucherno, matcode, aqty, fqty, amount)values('"+FormBean.getDate1()+"', '"+voucherno+"', (select matcode from materialmaster where matname='"+pname[i]+"'), '"+minqty[i]+"', '"+extra[i]+"', '"+offeredmin[i]+"')";
        			result=ConnectionDAO.executeUpdate(stm, sql);
        			System.out.println(sql);
        		}
        }
        catch(Exception error)
        {
        	error.printStackTrace();
        }
        ConnectionDAO.closeConnection(conn);
		return result;
	}
	public static boolean partymastercreation(FormBean formbean) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
        
       
        
        if(formbean.getId() != null)
        {
        	try
        	{
        	String sql="delete from partymaster1 where id='"+formbean.getId()+"'";
    		result=ConnectionDAO.executeUpdate(stm, sql);
    		
    		String sql1="insert into partymaster1(party_code,party_name,main_ledger,short_name,opening_balance,drcr,prev_yr_balance,drcr1,dc_limit,gress,any_other,int_rate,disc_rate,tdr,mail_to,location,address,contact_person,call1,income_tax_pa,area_manager,category,clas,type_of_party,arcode,gstinno,panno,statecode,sttype) values('"+formbean.getPartycode()+"','"+formbean.getPartyname()+"','"+formbean.getMainledger()+"','"+formbean.getSname()+"','"+formbean.getOpeningbalance()+"','"+formbean.getDrcr1()+"','"+formbean.getPrevyrbalance()+"','"+formbean.getDrcr()+"','"+formbean.getDclimit()+"','"+formbean.getGress()+"','"+formbean.getAnyother()+"','"+formbean.getIntrate()+"','"+formbean.getDiscreate()+"','"+formbean.getTdr()+"','"+formbean.getMailto()+"','"+formbean.getLocation()+"','"+formbean.getAddress1()+"','"+formbean.getContactperson()+"','"+formbean.getCall()+"','"+formbean.getIncometaxpa()+"','"+formbean.getAreaname()+"','"+formbean.getCategory()+"','"+formbean.getClas()+"','"+formbean.getTypeofparty()+"','"+formbean.getArcode1()+"','"+formbean.getGstinno()+"','"+formbean.getPanno()+"','"+formbean.getStatecode()+"','"+formbean.getSttype()+"')";
    		
    		System.out.println(sql1);
    		result=ConnectionDAO.executeUpdate(stm, sql1);
    		
    		result=true;
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        	
        	
        }
        else
        {
        	try{
        		String sql="insert into partymaster1(party_code,party_name,main_ledger,short_name,opening_balance,drcr,prev_yr_balance,drcr1,dc_limit,gress,any_other,int_rate,disc_rate,tdr,mail_to,location,address,contact_person,call1,income_tax_pa,area_manager,category,clas,type_of_party,arcode,gstinno,panno,statecode,sttype) values('"+formbean.getPartycode()+"','"+formbean.getPartyname()+"','"+formbean.getMainledger()+"','"+formbean.getSname()+"','"+formbean.getOpeningbalance()+"','"+formbean.getDrcr1()+"','"+formbean.getPrevyrbalance()+"','"+formbean.getDrcr()+"','"+formbean.getDclimit()+"','"+formbean.getGress()+"','"+formbean.getAnyother()+"','"+formbean.getIntrate()+"','"+formbean.getDiscreate()+"','"+formbean.getTdr()+"','"+formbean.getMailto()+"','"+formbean.getLocation()+"','"+formbean.getAddress1()+"','"+formbean.getContactperson()+"','"+formbean.getCall()+"','"+formbean.getIncometaxpa()+"','"+formbean.getAreaname()+"','"+formbean.getCategory()+"','"+formbean.getClas()+"','"+formbean.getTypeofparty()+"','"+formbean.getArcode1()+"','"+formbean.getGstinno()+"','"+formbean.getPanno()+"','"+formbean.getStatecode()+"','"+formbean.getSttype()+"')";
        		
        		System.out.println(sql);
        		result=ConnectionDAO.executeUpdate(stm, sql);
        		
        		result=true;
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        	
        	
        	
        	
        }
        
     
		return result;
	}
public static boolean companymastercreation(FormBean formbean)
	
	{
	{
		boolean result=false;
		
		Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
        
       
        
        if(formbean.getId() != null)
        {
        	try
        	{
	        	String sql="delete from companymaster1 where id='"+formbean.getId()+"'";
	    		result=ConnectionDAO.executeUpdate(stm, sql);
	    		System.out.println(sql);
	    		
	    		String sql1="insert into companymaster1(company_code,company_name,short_name,address_1,country_1,city_1,phone_number1,fax_no1,address2,country_2,city_2,phone_number_2,fax_no_2,address_3,country_3,city_3,phone_number_3,fax_no_3,to1,phone_number_4,mobile,email,gstinno,panno,stcode,sttype)value('"+formbean.getCompanycode()+"','"+formbean.getCompanyname()+"','"+formbean.getSname()+"','"+formbean.getAddress()+"','"+formbean.getCountry()+"','"+formbean.getCity()+"','"+formbean.getPhonenumber()+"','"+formbean.getFaxno()+"','"+formbean.getAddress1()+"','"+formbean.getCountry1()+"','"+formbean.getCity1()+"','"+formbean.getPhonenumber1()+"','"+formbean.getFaxno1()+"','"+formbean.getAddress2()+"','"+formbean.getCountry2()+"','"+formbean.getCity2()+"','"+formbean.getPhonenumber2()+"','"+formbean.getFaxno2()+"','"+formbean.getTo1()+"','"+formbean.getPhno()+"','"+formbean.getMobile()+"','"+formbean.getEmail()+"','"+formbean.getGstinno()+"','"+formbean.getPanno()+"','"+formbean.getStatecode()+"','"+formbean.getSttype()+"')";
        		
        		
        		result=ConnectionDAO.executeUpdate(stm, sql1);
        		
        		//result=true;
    		
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }
        else
        {
        	try{
        		String sql="insert into companymaster1(company_code,company_name,short_name,address_1,country_1,city_1,phone_number1,fax_no1,address2,country_2,city_2,phone_number_2,fax_no_2,address_3,country_3,city_3,phone_number_3,fax_no_3,to1,phone_number_4,mobile,email,gstinno,panno,stcode,sttype)value('"+formbean.getCompanycode()+"','"+formbean.getCompanyname()+"','"+formbean.getSname()+"','"+formbean.getAddress()+"','"+formbean.getCountry()+"','"+formbean.getCity()+"','"+formbean.getPhonenumber()+"','"+formbean.getFaxno()+"','"+formbean.getAddress1()+"','"+formbean.getCountry1()+"','"+formbean.getCity1()+"','"+formbean.getPhonenumber1()+"','"+formbean.getFaxno1()+"','"+formbean.getAddress2()+"','"+formbean.getCountry2()+"','"+formbean.getCity2()+"','"+formbean.getPhonenumber2()+"','"+formbean.getFaxno2()+"','"+formbean.getTo1()+"','"+formbean.getPhno()+"','"+formbean.getMobile()+"','"+formbean.getEmail()+"','"+formbean.getGstinno()+"','"+formbean.getPanno()+"','"+formbean.getStatecode()+"','"+formbean.getSttype()+"')";
        		
        		System.out.println(sql);
        		result=ConnectionDAO.executeUpdate(stm, sql);
        		
        		result=true;
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }	
        	
        	return result;
}
	}

public static boolean claimmaster1(FormBean formbean)
{
	boolean result=false;
	Connection conn = ConnectionDAO.getConnectionObject();
    Statement stm = ConnectionDAO.createStatement(conn);
	// TODO Auto-generated method stub
	  if(formbean.getId() != null)
      {
      	try
      	{
		  String sql="delete from claimmaster1 where id='"+formbean.getId()+"'";
		  result=ConnectionDAO.executeUpdate(stm, sql);
		  
		  String sql1="insert into claimmaster1(claim_code,claim_desc)value('"+formbean.getClaimcode()+"','"+formbean.getClaimdesc()+"')";
    		
    		
    		result=ConnectionDAO.executeUpdate(stm, sql1);
      	}catch(Exception e)
      	{
      		e.printStackTrace();
      	}
      	
		  
      }
      else
      {
      	try{
      		String sql="insert into claimmaster1(claim_code,claim_desc)value('"+formbean.getClaimcode()+"','"+formbean.getClaimdesc()+"')";
      		
      		System.out.println(sql);
      		result=ConnectionDAO.executeUpdate(stm, sql);
      		
      		result=true;
      		}catch(Exception e)
      		{
      		e.printStackTrace();
      		}
      } 	
      return result;
}

public static List<FormBean> claimlist(FormBean formbean) {
		// TODO Auto-generated method stub
		
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			sql="select * from claimmaster1";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setClaimcode(rs.getString(2));
				x.setClaimdesc(rs.getString(3));
				
				
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on company list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	public static boolean claimdelete(Integer id) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
		
		String sql="delete from claimmaster1 where id='"+id+"'";
		result=ConnectionDAO.executeUpdate(stm, sql);
		
		
		return result;
	}
	public static List<FormBean> compdetaillist(FormBean formbean) {
		// TODO Auto-generated method stub
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			sql="select * from companymaster1";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setCompanycode(rs.getString(2));
				x.setCompanyname(rs.getString(3));
				x.setCity(rs.getString(7));
				x.setCity1(rs.getString(12));
				x.setCity2(rs.getString(17));
				x.setPhno(rs.getString(21));
				
				
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on company list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	
	public static boolean companydelete(int id) {
		// TODO Auto-generated method stub
		boolean result=false;
		FormBean formbean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
		
        
		String sql="delete from companymaster1 where id='"+id+"'";
		result=ConnectionDAO.executeUpdate(stm, sql);
		System.out.println(sql);
		
		return result;
	}
	public static List<FormBean> partydetaillist(FormBean formbean) {
		List<FormBean> l1 = new ArrayList<FormBean>();
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);	
		ResultSet rs;
		String sql="";
		try
		{
			sql="select * from partymaster1";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				FormBean x=new FormBean();
				x.setId(rs.getInt(1));
				x.setPartycode(rs.getString(2));
				x.setPartyname(rs.getString(3));
				x.setMainledger(rs.getString(4));
				x.setContactperson(rs.getString(19));
				x.setCall(rs.getString(20));
				
				
				l1.add(x);
			}
		}
		catch(Exception c)
		{
			System.out.println("error on company list "+c);
		}
		ConnectionDAO.closeConnection(conn);
		return l1;
	}
	public static boolean partydelete(Integer id) {
		// TODO Auto-generated method stub
		boolean result=false;
		FormBean formbean=new FormBean();
		Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
		
        
		String sql="delete from partymaster1 where id='"+id+"'";
		result=ConnectionDAO.executeUpdate(stm, sql);
		System.out.println(sql);
		
		return result;
	}
public static FormBean partyedit(Integer id) {
		
		
		
        FormBean usBean=new FormBean();
        Connection conn = ConnectionDAO.getConnectionObject();
        Statement stm = ConnectionDAO.createStatement(conn);
        ResultSet rs;
        try
        {
            String sql="select * from partymaster1 where id='"+id+"'";
            //System.out.println(sql);
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
               usBean.setId(rs.getInt(1));
               usBean.setPartycode(rs.getString(2));
               usBean.setPartyname(rs.getString(3));
               usBean.setMainledger(rs.getString(4));
               usBean.setSname(rs.getString(5));
               usBean.setOpeningbalance(rs.getString(6));
               usBean.setDrcr1(rs.getString(9));
               usBean.setPrevyrbalance(rs.getString(8));
               usBean.setDrcr(rs.getString(7));
               usBean.setDclimit(rs.getString(10));
               usBean.setGress(rs.getString(11));
               usBean.setAnyother(rs.getString(12));
               usBean.setIntrate(rs.getString(13));
               usBean.setDiscreate(rs.getString(14));
               usBean.setTdr(rs.getString(15));
               usBean.setMailto(rs.getString(16));
               usBean.setLocation(rs.getString(17));
               usBean.setAddress1(rs.getString(18));
               usBean.setContactperson(rs.getString(19));
               usBean.setCall(rs.getString(20));
               usBean.setIncometaxpa(rs.getString(21));
               usBean.setAreaname(rs.getString(22));
               usBean.setCategory(rs.getString(23));
               usBean.setClas(rs.getString(24));
               usBean.setTypeofparty(rs.getString(25));
               usBean.setArcode1(rs.getString(26));
              
		
            }
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
		return usBean;
}

public static List<FormBean> alist(FormBean formbean) {
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		
		sql="select placename from placemaster";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			
			x.setAreaname(rs.getString(1));
			l1.add(x);
			System.out.println(rs.getString(1));
			
		}
	}
	catch(Exception c)
	{
		System.out.println("error on category list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}


	public static FormBean companyedit(Integer id) {
		
		  FormBean usBean=new FormBean();
	        Connection conn = ConnectionDAO.getConnectionObject();
	        Statement stm = ConnectionDAO.createStatement(conn);
	        ResultSet rs;
	        try
	        {
	            String sql="select * from companymaster1 where id='"+id+"'";
	            //System.out.println(sql);
	            rs=stm.executeQuery(sql);
	            while(rs.next())
	            {
	               usBean.setId(rs.getInt(1));
	               usBean.setCompanycode(rs.getString(2));
	               usBean.setCompanyname(rs.getString(3));
	               usBean.setSname(rs.getString(4));
	               usBean.setAddress(rs.getString(5));
	               usBean.setCountry(rs.getString(6));
	               usBean.setCity(rs.getString(7));
	               usBean.setPhonenumber(rs.getString(8));
	               usBean.setFaxno(rs.getString(9));
	               usBean.setAddress1(rs.getString(10));
	               usBean.setCountry1(rs.getString(11));
	               usBean.setCity1(rs.getString(12));
	               usBean.setPhonenumber1(rs.getString(13));
	               usBean.setFaxno1(rs.getString(14));
	               usBean.setAddress2(rs.getString(15));
	               usBean.setCountry2(rs.getString(16));
	               usBean.setCity2(rs.getString(17));
	               usBean.setPhonenumber2(rs.getString(18));
	               usBean.setFaxno2(rs.getString(19));
	               usBean.setTo1(rs.getString(20));
	               usBean.setPhno(rs.getString(21));
	               usBean.setMobile(rs.getString(22));
	               usBean.setEmail(rs.getString(23));
	               
	              
			
	            }
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
			return usBean;
	}
	public static FormBean claimedit(Integer id) {
		
		 FormBean usBean=new FormBean();
	        Connection conn = ConnectionDAO.getConnectionObject();
	        Statement stm = ConnectionDAO.createStatement(conn);
	        ResultSet rs;
	        try
	        {
	            String sql="select * from claimmaster1 where id='"+id+"'";
	            System.out.println(sql);
	            rs=stm.executeQuery(sql);
	            while(rs.next())
	            {
	               usBean.setId(rs.getInt(1));
	               usBean.setClaimcode(rs.getString(2));
	               usBean.setClaimdesc(rs.getString(3));
	            }
	            
	            
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        
	        return usBean;
	}
	public static List<FormBean> materialnamelist(FormBean formbean) {
		 List<FormBean> l1 = new ArrayList<FormBean>();
	       Connection conn = ConnectionDAO.getConnectionObject();
	       Statement stm = ConnectionDAO.createStatement(conn);
	       ResultSet rs;
	       try
	       {
	           String sql="select shortname from materialgroupmaster";
	           //System.out.println(sql);
	           rs=stm.executeQuery(sql);
	           while(rs.next())
	           {
	           	FormBean usBean = new FormBean();
	              usBean.setMaterialgroup(rs.getString(1));
	              l1.add(usBean);
	           }
	           
	           
	       }catch(Exception e)
	       {
	       	e.printStackTrace();
	       }
	       
	       return l1;
	}
	public static List<FormBean> areaname(FormBean formbean) {
		 List<FormBean> l1 = new ArrayList<FormBean>();
	       Connection conn = ConnectionDAO.getConnectionObject();
	       Statement stm = ConnectionDAO.createStatement(conn);
	       ResultSet rs;
	       try
	       {
	           String sql="select placename from placemaster";
	           //System.out.println(sql);
	           rs=stm.executeQuery(sql);
	           while(rs.next())
	           {
	           	FormBean usBean = new FormBean();
	              usBean.setAreaname(rs.getString(1));
	              l1.add(usBean);
	           }
	           
	           
	       }catch(Exception e)
	       {
	       	e.printStackTrace();
	       }
	       
	       return l1;
	}
	public static List<FormBean> companynamelist(FormBean formbean) {
		
		 List<FormBean> l1 = new ArrayList<FormBean>();
	       Connection conn = ConnectionDAO.getConnectionObject();
	       Statement stm = ConnectionDAO.createStatement(conn);
	       ResultSet rs;
	       try
	       {
	           String sql="select company_name from companymaster1";
	           //System.out.println(sql);
	           rs=stm.executeQuery(sql);
	           while(rs.next())
	           {
	           	FormBean usBean = new FormBean();
	              usBean.setCompanyname(rs.getString(1));
	              l1.add(usBean);
	           }
	           
	           
	       }catch(Exception e)
	       {
	       	e.printStackTrace();
	       }
	       
	       return l1;
	}   
	
	
public static FormBean uniqueid1(String prefix) {
		
		UniqueIDGenerator u = new UniqueIDGenerator(); 
		String x=u.getUniqueID();
		int j=0;
		FormBean usBean = new FormBean();
		String sql = "select * from uniqueid";
		Connection conn = ConnectionDAO.getConnectionObject();
		Statement stm = ConnectionDAO.createStatement(conn);
		try {			
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) 
				{
					j=rs.getInt(3);
				}
			
			int k=String.valueOf(j).length();
			String x0="";
			String x1="";
			
			if(k==1)
			x0=prefix+"0000"+j;
			
			if(k==2)
			x0=prefix+"000"+j;
			
			if(k==3)
			x0=prefix+"00"+j;
			
			if(k==4)
			x0=prefix+"0"+j;
			
			if(k==5)
				x0=prefix+j;
			//System.out.println(x0);
			usBean.setCompanycode(x0);
			usBean.setClaimcode(x0);
			usBean.setPartycode(x0);
			usBean.setCatcode(x0);
			usBean.setSalcode(x0);
			usBean.setPlacecode(x0);
			usBean.setMatcode(x0);
			usBean.setMmcode(x0);
		//	usBean.setGroupcode(x0);
	//		usBean.setCatcode(x0);
		//	usBean.set
			
			//usBean.setRccode(x1);*/
			sql = "insert into uniqueid(uid,sid) values ('"
					+ x /* "DS000"+(k+1)  */
					+ "','"
					+ (j+1)
					+"');";
			
			ConnectionDAO.executeUpdate(stm, sql);
		}
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
	
			ConnectionDAO.closeConnection(conn);
			return usBean;
			}
	
	
	


public static List<FormBean> purlist(FormBean formbean) {

	
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		//int sr=1;
		sql="select ledgername from ledgermaster";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setPur(rs.getString(1));
			//System.out.println(rs.getString(2)+rs.getString(6)+rs.getString(31));
			l1.add(x);
		
		}
	}
	catch(Exception c)
	{
		System.out.println("error on  purchaselist "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}


public static List<FormBean> sallist(FormBean formbean) {
	
	
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		//int sr=1;
		sql="select ledgername from ledgermaster";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setSl(rs.getString(1));
			//System.out.println(rs.getString(2)+rs.getString(6)+rs.getString(31));
			l1.add(x);
		
		}
	}
	catch(Exception c)
	{
		System.out.println("error on  purchaselist "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}	


//salesreturn
public static List<FormBean> salesreturn(FormBean formbean)
{
	List<FormBean> l1 = new ArrayList<FormBean>();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);	
	ResultSet rs;
	String sql="";
	try
	{
		int sr=1;
		sql="select * from itransaction order by id desc";
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			FormBean x=new FormBean();
			x.setId(rs.getInt(1));
			x.setNameofarea(rs.getString(3));
			x.setSalesmanname(rs.getString(5));
			x.setRetailername(rs.getString(6));
			x.setMemo(rs.getString(8));
			
		
		//	x.setCompany(findledger(rs.getString(5)));
			l1.add(x);
			
		}
	}
	catch(Exception c)
	{
		System.out.println("error on salesman list "+c);
	}
	ConnectionDAO.closeConnection(conn);
	return l1;
}




//salesreturncreation

public static boolean salesreturncreation(FormBean FormBean) 
{
	boolean result1 = false;
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String voucherno="";
	if(FormBean.getId() != null)
	{
		try
		{
			int id=0;
			String materialcode="",x="";
			String sql="";
			String v="VD";
			int cmat=0;
			 String mcode="",matcode="",matcode1="";
			 String v1="MR";
			 
			 String cdate=FormBean.getDate();
			 
			
			 String cdate1[]=cdate.split("-");
			 String yr=cdate1[0];
			 String mon=cdate1[1];
			 String day=cdate1[2];
			 	String nameofitems[]=FormBean.getNameofitems();
				String tr[]=FormBean.getTr();
				String case1[]=FormBean.getCase4(),pcs1[]=FormBean.getPcs4(),fp1[]=FormBean.getFp();
				String mrp1[]=FormBean.getMrp4(),rate1[]=FormBean.getRate(),discs[]=FormBean.getDiscs(),dis1[]=FormBean.getDis(),amount1[]=FormBean.getAmount4();
				String dis_amount[]=FormBean.getTotal11(),remain_amount[]=FormBean.getTodiscount(),tax_amount[]=FormBean.getTytax(),gst_amount[]=FormBean.getGstper();
				//System.out.println("hi: "+nameofitems.length);
				
			// System.out.println("date: "+cdate+","+yr+","+mon+","+day);
			 yr=yr.substring(2, 4);
			 //System.out.println("sub year: "+yr);
			int yr1=Integer.parseInt(yr)+1;
			v1=v1+yr+yr1+yr+mon+day;
			//System.out.println("hello");
			String sql1="update itransaction set area='"+FormBean.getNameofarea()+"', entrydate='"+FormBean.getDate()+"',sman_name='"+FormBean.getSalesmanname()+"',rname='"+FormBean.getRetailername()+"', address='"+FormBean.getAddress()+"',memo='"+FormBean.getMemo()+"',totalamt1='"+FormBean.getTotalamt()+"',packing='"+FormBean.getPacking()+"',case1='"+FormBean.getCasee()+"',pcs1='"+FormBean.getPcss()+"',total='"+FormBean.getTotal()+"',total_discount='"+FormBean.getDiscount()+"',gross_amt='"+FormBean.getGamount()+"',discount='"+FormBean.getDiscount1()+"',sub_total='"+FormBean.getSubtotal()+"',sgst='"+FormBean.getSgst()+"',cgst='"+FormBean.getCgst()+"',igst='"+FormBean.getIgst()+"',total_rs='"+FormBean.getTotalamtrs()+"',gst_amt='"+FormBean.getGstamount()+"',r_off='"+FormBean.getRoundoff()+"',add1='"+FormBean.getAdd()+"',net_amt='"+FormBean.getNetamount()+"' where id='"+FormBean.getId()+"'";
			
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql1);
			
			sql="select voucherno from itransaction where id='"+FormBean.getId()+"'";
			//System.out.println(sql);
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				voucherno=rs.getString(1);
			}
			
			sql="delete from idetails where voucherno='"+voucherno+"' ";
			//System.out.println(sql);
			result1=ConnectionDAO.executeUpdate(stm, sql);
			String nameofitems6[]=FormBean.getNameofitems1();
			//System.out.println("length: "+nameofitems6.length);
			String materialcode1="",actual="",damage="";
			String	case6[]=FormBean.getCase5(),pcs6[]=FormBean.getPcs5(),fp6[]=FormBean.getFp1(),mrp6[]=FormBean.getMrp5(),rate6[]=FormBean.getRate4(),discs6[]=FormBean.getDiscs4(),dis6[]=FormBean.getDis4(),amount6[]=FormBean.getAmount5();
			String dis_amount1[]=FormBean.getTotal111(),remain_amount1[]=FormBean.getTodiscount1(),tax_amount1[]=FormBean.getTytax1(),gst_amount1[]=FormBean.getGstper1();
			
			
			for(int i=0;i<nameofitems6.length;i++)
			{
				String packing="",ccase="",cpcs="",ctotal="";
				double scase=0,spcs=0,stotal=0,tactual=0,tdamage=0;
				
				//System.out.println("hello");
				sql="select packing,matcode from materialmaster where matname='"+nameofitems6[i]+"'";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					packing=rs.getString(1);
					materialcode1=rs.getString(2);
				
					//System.out.println("Packng: "+packing+","+materialcode);
				}
				sql="select cr_case,cr_pcs,cr_total,damage,actual from materialdetails where matcode='"+materialcode1+"' and mrp_pcs='"+mrp1[i]+"'";
				System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					
					ccase=rs.getString(1);
					cpcs=rs.getString(2);
					ctotal=rs.getString(3);
					
					damage=rs.getString(4);
					actual=rs.getString(5);
					}
				
				if(fp1[i].equals(""))
				{
					fp1[i]="0";
				}
				if(actual.equals(""))
				{
					actual="0";
				}

				if(damage.equals(""))
				{
					damage="0";
				}
				System.out.println("material details: "+ccase+","+cpcs+","+ctotal+","+damage+","+actual);
				
				System.out.println("output: "+case1[i]+","+pcs1[i]+","+fp1[i]);
				double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(fp1[i]));
				//System.out.println("Total value: "+total);
				
				sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+matcode1+"','"+nameofitems[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+mrp1[i]+"','"+rate1[i]+"','"+discs[i]+"','"+dis1[i]+"','"+amount1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
			
				System.out.println(sql);
				
				result1=ConnectionDAO.executeUpdate(stm, sql);
				
				
				
				// sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
				//System.out.println(sql);
				 if(tr[i].equals("A"))
				 {
					 System.out.println("hello1");	
					 	scase=Double.parseDouble(ccase) + Double.parseDouble(case1[i]);
						spcs=Double.parseDouble(cpcs) + (Double.parseDouble(pcs1[i]) + Double.parseDouble(fp1[i]));
						stotal=Double.parseDouble(ctotal) + total;
						tactual=Double.parseDouble(actual) +total;
						System.out.println(scase+","+spcs+","+stotal+","+tactual);
						sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"',actual='"+tactual+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						System.out.println(sql);
						result1=ConnectionDAO.executeUpdate(stm, sql);
				 }
				 else if(tr[i].equals("D"))
				 {
					 //System.out.println("hello2");
					 tdamage=Double.parseDouble(damage) +total; 
					 System.out.println(tdamage);
					 sql="update materialdetails set damage='"+tdamage+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
					 result1=ConnectionDAO.executeUpdate(stm, sql);	
				 }
				
			}
			
			
			}
		catch(Exception g)
		{
			System.out.println("error on counter sales "+g);
		}
	}
	else
	{
		try
		{
		
			String materialcode="";
			String sql="";
			int cmat=0;
			 String mcode="",matcode="",matcode1="";
			 String v1="MR";
			 
			 String cdate=FormBean.getDate();
			 
			
			 String cdate1[]=cdate.split("-");
			 String yr=cdate1[0];
			 String mon=cdate1[1];
			 String day=cdate1[2];
			// System.out.println("date: "+cdate+","+yr+","+mon+","+day);
			 yr=yr.substring(2, 4);
			 //System.out.println("sub year: "+yr);
			int yr1=Integer.parseInt(yr)+1;
			v1=v1+yr+yr1+yr+mon+day;
			//System.out.println("bubun: "+v1);
				
			sql="select count(id) from itransaction";
				//System.out.println(sql);
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					 cmat=rs.getInt(1);
				}
				
				if(cmat == 0)
				{
					matcode=mcode+"00"+(cmat+1);
				}
				else if(cmat > 0 && cmat < 9)
				{
					matcode=mcode+"00"+(cmat+1);
				}
				else if(cmat > 8 && cmat < 99)
				{
					matcode=mcode+"0"+(cmat+1);
				}
				else if(cmat > 98 && cmat < 999)
				{
					matcode=mcode+(cmat+1);
				}
				else if(cmat > 998 && cmat < 9999)
				{
					matcode=mcode+(cmat+1);
					
				}
				 matcode1=v1+matcode;
			//System.out.println("hii"+matcode1);
				sql="insert into itransaction(voucherno,vouchertype,area,entrydate,sman_name,rname,address,memo,totalamt1,packing,case1,pcs1,total,total_discount,gross_amt,discount,sub_total,sgst,cgst,igst,total_rs,gst_amt,r_off,add1,net_amt)values( '"+matcode1+"','"
				+"MR"+"','"
				+FormBean.getNameofarea()+"','"
				+FormBean.getDate()+"','"
				+FormBean.getSalesmanname()+"','"
				+FormBean.getRetailername()+"','"
				+FormBean.getAddress()+"','"
				+FormBean.getMemo()+"','"
				+FormBean.getTotalamt()+"','"
				+FormBean.getPacking()+"','"
				+FormBean.getCasee()+"','"
				+FormBean.getPcss()+"','"
				+FormBean.getTotal()+"','"
				+FormBean.getDiscount()+"','"
				+FormBean.getGamount()+"','"
				+FormBean.getDiscount1()+"','"
				+FormBean.getSubtotal()+"','"
				+FormBean.getSgst()+"','"
				+FormBean.getCgst()+"','"
				+FormBean.getIgst()+"','"
				+FormBean.getTotalamtrs()+"','"
				+FormBean.getGstamount()+"','"
				+FormBean.getRoundoff()+"','"
				+FormBean.getAdd()+"','"
				+FormBean.getNetamount()+"')";
				//System.out.println(sql);
				result1=ConnectionDAO.executeUpdate(stm,sql);
				//int total=0;
				
				String nameofitems[]=FormBean.getNameofitems();
				String tr[]=FormBean.getTr();
				String case1[]=FormBean.getCase4(),pcs1[]=FormBean.getPcs4(),fp1[]=FormBean.getFp();
				String mrp1[]=FormBean.getMrp4(),rate1[]=FormBean.getRate(),discs[]=FormBean.getDiscs(),dis1[]=FormBean.getDis(),amount1[]=FormBean.getAmount4();
				String dis_amount[]=FormBean.getTotal11(),remain_amount[]=FormBean.getTodiscount(),tax_amount[]=FormBean.getTytax(),gst_amount[]=FormBean.getGstper();
				//System.out.println("hi: "+nameofitems.length);
				for(int i=0;i<nameofitems.length;i++)
				{
					String packing="",ccase="",cpcs="",ctotal="",damage="",actual="";
					double scase=0,spcs=0,stotal=0,tactual=0,tdamage=0;
					
					//System.out.println("hello");
					sql="select packing,matcode from materialmaster where matname='"+nameofitems[i]+"'";
					System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						packing=rs.getString(1);
						materialcode=rs.getString(2);
					
						System.out.println("Packng: "+packing+","+materialcode);
					}
					sql="select cr_case,cr_pcs,cr_total,damage,actual from materialdetails where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
					System.out.println(sql);
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						
						ccase=rs.getString(1);
						cpcs=rs.getString(2);
						ctotal=rs.getString(3);
						
						damage=rs.getString(4);
						actual=rs.getString(5);
						}
					
					if(fp1[i].equals(""))
					{
						fp1[i]="0";
					}
					if(actual.equals(""))
					{
						actual="0";
					}

					if(damage.equals(""))
					{
						damage="0";
					}
					System.out.println("material details: "+ccase+","+cpcs+","+ctotal+","+damage+","+actual);
					
					System.out.println("output: "+case1[i]+","+pcs1[i]+","+fp1[i]);
					double total=(Double.parseDouble(case1[i]) * Double.parseDouble(packing)) + (Double.parseDouble(pcs1[i]) +Double.parseDouble(fp1[i]));
					//System.out.println("Total value: "+total);
					
					sql="insert into idetails( voucherno,name_ofitems,case1,pcs1,fp1,mrp,rate1,dis_cs,dis_percent,amount1,tcase,tpcs,tfp,ttotal,dicount_amount,remain_amount,tax_amount,gst_amount ) values('"+matcode1+"','"+nameofitems[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+mrp1[i]+"','"+rate1[i]+"','"+discs[i]+"','"+dis1[i]+"','"+amount1[i]+"','"+case1[i]+"','"+pcs1[i]+"','"+fp1[i]+"','"+total+"','"+dis_amount[i]+"','"+remain_amount[i]+"','"+tax_amount[i]+"','"+gst_amount[i]+"')";
				
					System.out.println(sql);
					
					result1=ConnectionDAO.executeUpdate(stm, sql);
					
					
					
					// sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
					//System.out.println(sql);
					 if(tr[i].equals("A"))
					 {
						 System.out.println("hello1");	
						 	scase=Double.parseDouble(ccase) + Double.parseDouble(case1[i]);
							spcs=Double.parseDouble(cpcs) + (Double.parseDouble(pcs1[i]) + Double.parseDouble(fp1[i]));
							stotal=Double.parseDouble(ctotal) + total;
							tactual=Double.parseDouble(actual) +total;
							System.out.println(scase+","+spcs+","+stotal+","+tactual);
							sql="update materialdetails set cr_case='"+scase+"',cr_pcs='"+spcs+"',cr_total='"+stotal+"',actual='"+tactual+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
							System.out.println(sql);
							result1=ConnectionDAO.executeUpdate(stm, sql);
					 }
					 else if(tr[i].equals("D"))
					 {
						 //System.out.println("hello2");
						 tdamage=Double.parseDouble(damage) +total; 
						 System.out.println(tdamage);
						 sql="update materialdetails set damage='"+tdamage+"' where matcode='"+materialcode+"' and mrp_pcs='"+mrp1[i]+"'";
						 result1=ConnectionDAO.executeUpdate(stm, sql);	
					 }
					
				}
				
				
			
		}
		catch(Exception a)
		{
			System.out.println("error on salesreturn creation "+a);
		}
	}
	ConnectionDAO.closeConnection(conn);
	return result1;
}




//salesreturnupdate


public static FormBean salesreturnupdate(int id)
{
	FormBean usBean=new FormBean();
	
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	String voucherno="";
	try
	{
		String sql="select voucherno from itransaction where id= '"+id+"'";
		System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			voucherno=rs.getString(1);
		}
		//System.out.println(voucherno);
		
		
		 sql="select * from itransaction where voucherno='"+voucherno+"'";
		//System.out.println(sql);
		rs=stm.executeQuery(sql);
		
		
	
		
		
		while(rs.next())
		{
			areaname=rs.getString(7);
			//System.out.println("Ram: "+rs.getString(7));
			usBean.setId(rs.getInt(1));
			usBean.setNameofarea(rs.getString(4));
			usBean.setDate(rs.getString(5));
			usBean.setSalesmanname(rs.getString(6));
			usBean.setRetailername(rs.getString(7));
			usBean.setAddress(rs.getString(8));
			usBean.setMemo(rs.getString(9));
			usBean.setTotalamt(rs.getString(10));
			/*usBean.setPacking(rs.getString(11));
			usBean.setCasee(rs.getString(12));
			usBean.setPcss(rs.getString(13));
			usBean.setTotal(rs.getString(14));*/
			usBean.setDiscount(rs.getString(15));
			usBean.setGamount(rs.getString(16));
			usBean.setDiscount1(rs.getString(17));
			usBean.setSubtotal(rs.getString(18));
			usBean.setSgst(rs.getString(19));
			usBean.setCgst(rs.getString(20));
			usBean.setIgst(rs.getString(21));
			usBean.setTotalamtrs(rs.getString(22));
			usBean.setGstamount(rs.getString(23));
			usBean.setRoundoff(rs.getString(24));
			usBean.setAdd(rs.getString(25));
			usBean.setNetamount(rs.getString(26));
			
			
		}
		 sql="select placename from placemaster where placecode=(select area from itransaction where voucherno='"+voucherno+"' )";
		//System.out.println(sql);
		 rs=stm.executeQuery(sql);
		
			while(rs.next())
			{
				areaname1=rs.getString(1);
				usBean.setNameofarea1(rs.getString(1));
				
			}
			 sql="select smname from areasalesmanmaster where smcode=(select sman_name from itransaction where voucherno='"+voucherno+"' )";
				//System.out.println(sql);
				 rs=stm.executeQuery(sql);
				
					while(rs.next())
					{
						usBean.setSalesmanname1(rs.getString(1));
						
					}
					sql="select party_name from partymaster1 where party_code=(select rname from itransaction where voucherno='"+voucherno+"' )";
					//System.out.println(sql);
					 rs=stm.executeQuery(sql);
					
						while(rs.next())
						{
							areaname=rs.getString(1);
							System.out.println("partyname: "+areaname);
							usBean.setRetailername1(rs.getString(1));
							
						}
		
		Vector<String> nameofitems=new Vector<String>();
		Vector<String> case1=new Vector<String>();
		Vector<String> pcs=new Vector<String>();
		Vector<String> fp=new Vector<String>();
		Vector<String> mrp=new Vector<String>();
		Vector<String> rate=new Vector<String>();
		Vector<String> discs=new Vector<String>();
		Vector<String> dispercent=new Vector<String>();
		Vector<String> amount=new Vector<String>();
		//Vector<String> tytax=new Vector<String>();
		Vector<String> disamount=new Vector<String>();
		Vector<String> remainamount=new Vector<String>();
		Vector<String> taxamount=new Vector<String>();
		Vector<String> gstamount=new Vector<String>();
		
		
		
		sql="select * from idetails where voucherno='"+voucherno+"'";
		System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			nameofitems.add(rs.getString(3));
			case1.add(rs.getString(4));
			pcs.add(rs.getString(5));
			fp.add(rs.getString(6));
			mrp.add(rs.getString(7));
			rate.add(rs.getString(8));
			discs.add(rs.getString(9));
			dispercent.add(rs.getString(10));
			amount.add(rs.getString(11));
			disamount.add(rs.getString(16));
			remainamount.add(rs.getString(17));
			taxamount.add(rs.getString(18));
			gstamount.add(rs.getString(19));
			
			
		
		
		}
		
		String nameofitems1[]= new String[nameofitems.size()];
		String case2[]= new String[case1.size()];
		String pcs1[]= new String[pcs.size()];
		String fp1[]= new String[fp.size()];
		String mrp1[]= new String[mrp.size()];
		String rate1[]= new String[rate.size()];
		String discs1[]= new String[discs.size()];
		String dispercent1[]= new String[dispercent.size()];
		String amount1[]= new String[amount.size()];
		String disamount1[]= new String[disamount.size()];
		String remainamount1[]= new String[remainamount.size()];
		String taxamount1[]= new String[taxamount.size()];
		String gstamount1[]= new String[gstamount.size()];
		
		
		for(int i=0;i<nameofitems.size();i++)
		{
			nameofitems1[i]=nameofitems.get(i);
			//System.out.println("material name: "+nameofitems1[i]);
			case2[i]=case1.get(i);
			pcs1[i]=pcs.get(i);
			fp1[i]=fp.get(i);
			mrp1[i]=mrp.get(i);
			rate1[i]=rate.get(i);
			discs1[i]=discs.get(i);
			dispercent1[i]=dispercent.get(i);
			amount1[i]=amount.get(i);
			disamount1[i]=disamount.get(i);
			remainamount1[i]=remainamount.get(i);
			taxamount1[i]=taxamount.get(i);
			gstamount1[i]=gstamount.get(i);
			System.out.println("amount: "+disamount.get(i)+","+remainamount.get(i)+","+taxamount.get(i)+","+gstamount.get(i));
		
		}
		
		usBean.setNameofitems(nameofitems1);
		usBean.setCase4(case2);
		usBean.setPcs4(pcs1);
		usBean.setFp(fp1);
		usBean.setMrp4(mrp1);
		usBean.setRate(rate1);
		usBean.setDiscs(discs1);
		usBean.setDis(dispercent1);
		usBean.setAmount4(amount1);
		usBean.setTotal11(disamount1);
        usBean.setTodiscount(remainamount1);
        usBean.setTytax(taxamount1);
        usBean.setGstper(gstamount1);
	}
	catch(Exception a)
	{
		System.out.println("error on sales man edit "+a);
	}
	ConnectionDAO.closeConnection(conn);
	return usBean;}


//salesreturndelete

public static FormBean salesreturndelete(int id)
{
	FormBean usBean=new FormBean();
	Connection conn = ConnectionDAO.getConnectionObject();
	Statement stm = ConnectionDAO.createStatement(conn);
	ResultSet rs;
	boolean result1 = false;
	
	String voucherno="";
	try
	{
		String sql="select voucherno from itransaction where id= '"+id+"'";
		System.out.println(sql);
		rs=stm.executeQuery(sql);
		while(rs.next())
		{
			voucherno=rs.getString(1);
		}
		System.out.println(voucherno);
		
		
		 sql="delete from itransaction where voucherno='"+voucherno+"'";
		//System.out.println(sql);
		result1=ConnectionDAO.executeUpdate(stm, sql);
		
		sql="delete from idetails where voucherno='"+voucherno+"' ";
		//System.out.println(sql);
		result1=ConnectionDAO.executeUpdate(stm, sql);
		
	}
	catch(Exception a)
	{
		System.out.println("error on salesreturndelete "+a);
	}
	ConnectionDAO.closeConnection(conn);
	return usBean;
}
	
}







