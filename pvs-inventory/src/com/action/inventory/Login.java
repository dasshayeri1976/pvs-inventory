package com.action.inventory;

import java.io.File;
import java.text.ParseException;
import java.util.List;
//import java.util.Map;  
import java.util.Map;
//import org.apache.struts2.dispatcher.SessionMap;  
//import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;    
import org.apache.struts2.interceptor.SessionAware;  
import org.apache.commons.io.FileUtils;
import com.bean.inventory.FormBean;
import com.helper.inventory.FormHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//public class Login extends ActionSupport implements SessionAware {
	public class Login extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormBean formbean,formbean1;
	private String accid,username,brandname,mcode,pcode,voucher,shortn,longn,v,frmdate,todate,acname,type;
	private String stax,remarks,ledger,months,month,count,cvalue,xx,yy,zz,company,finyear;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName,date,zz1;
	public String getZz1() {
		return zz1;
	}

	public void setZz1(String zz1) {
		this.zz1 = zz1;
	}

	private Integer id;
	private String[] checked;
	private String[] checked1;
	private String[] checked2;
	private String leadid;
	private List<FormBean> usList,usList1,usList2,usList3,usList4,usList5,usList6,usList7,usList8,usList9,acgrouplist;
	private SessionMap<String,Object> sessionMap;  
	Map<String, Object> session = ActionContext.getContext().getSession();
	String d=(String)session.get("user");

	public String login() throws ParseException 
	{
		String result="";
		result = SUCCESS;	
		return result;
	}
	
	public String dashboard() throws ParseException 
	{
		String result=SUCCESS;
		Map<String, Object> session = ActionContext.getContext().getSession();
		return result;
	}
	public String load() throws ParseException 
	{
		String result=SUCCESS;
		Map<String, Object> s4cf = ActionContext.getContext().getSession();
		//s4cf.put("cmp", ""+formbean.getCompany());
		//s4cf.put("fin", ""+formbean.getFinyear());
		return result;
	}
	 
	 public String loader1() 
		{
			String result = SUCCESS;
			//usList=FormHelper.company();
			//usList1=FormHelper.company();
			return result;
		}
//salesmanlist
	 public String salesmanlist() 
		{
			String result = SUCCESS;
			
			String prefix = "SAL";
			formbean= FormHelper.uniqueid1(prefix);
			
		//	usList=FormHelper.companylist(formbean);
			usList1=FormHelper.salesmanlist(formbean);
			return result;
		}
	 
	 public String salesmancreation() 
		{
			String result1 = SUCCESS;
			if(formbean != null)
			 {
				 boolean r=FormHelper.salesmancreation(formbean);
				 if(r==true)
				 {
					 addActionMessage("sales man creation Successfully..");
					 result1 = SUCCESS;
				 }
				 else
				 {
					 result1=ERROR;
				 }
				 formbean=null;
			 }
			salesmanlist();
			return result1;
		}
	 
	 public String salesmanupdate() 
	 {
		 String result=SUCCESS;
		 formbean=FormHelper.salesmanedit(id);
		 usList1=FormHelper.salesmanlist(formbean);
		
		 return result;
	 }
 
 //salesmemodelte
	
	 public String salesmandelete() 
	 {
		 String result=SUCCESS;
		 FormHelper.salesmandelete(id);
		 usList1=FormHelper.salesmanlist(formbean);
		 return result;
	 }
	 
	 public String purchaselist1() 
		{
			String result = SUCCESS;
			//usList=FormHelper.purchaselist1(formbean);
			usList1=FormHelper.purchaselist1(formbean);
			usList=FormHelper.companylist(formbean);
			usList2=FormHelper.sundaylist(formbean);
			return result;
		}
	 

	 	public String purchasecreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.purchasecreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("purchase list Added Successfully..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				
				purchaselist1();
				//usList1=FormHelper.purchaselist1(formbean);
				return result;
			}
	 	
	 	public String purchaseupdate1() 
		 {
			 String result=SUCCESS;
			 	formbean=FormHelper.purchaseupdate1(id);
				//usList=FormHelper.purchaselist1(formbean);
				usList1=FormHelper.purchaselist1(formbean);
				usList=FormHelper.companylist(formbean);
				usList2=FormHelper.sundaylist(formbean);
				usList3=FormHelper.nameofitem(formbean);
			 return result;
		 }
		
	 	
	 	
		public String purchasedelete1() 
		 {
			 String result=SUCCESS;
			 	formbean=FormHelper.purchasedelete1(id);
				//usList=FormHelper.purchaselist1(formbean);
				//usList1=FormHelper.purchaselist1(formbean);
			 	purchaselist1();
			 return result;
		 }
	 
	 
	 public String dsalesmemeoentry() 
		{
		 System.out.println("hello1");
			String result = SUCCESS;
			
			usList1=FormHelper.dsalesmemeoentry(formbean);
			System.out.println("hello2");
			usList2=FormHelper.plist1(formbean);
			usList3=FormHelper.saleslist(formbean);
			return result;
		}
	 public String dsalesmemeocreation() 
		{
			String result1 = SUCCESS;
			if(formbean != null)
			 {
				 boolean r=FormHelper.dsalesmemeocreation(formbean);
				 if(r==true)
				 {
					 addActionMessage("sales counter sales memo Added Successfully..");
				     result1 = SUCCESS;
				 }
				 else
				 {
					 result1=ERROR;
				 }
				 formbean=null;
			 }
			dsalesmemeoentry();
			return result1;
		}
	 
	 //dsalesmemoupdate
	 
		public String dsalesmemeoupdate() 
		 {
			 String result=SUCCESS;
			
			 	usList9=FormHelper.nameitem();
				
				usList1=FormHelper.dsalesmemeoentry(formbean);
				usList2=FormHelper.plist1(formbean);
				
				usList3=FormHelper.saleslist(formbean);
				formbean=FormHelper.dsalesmemeoupdate(id);
				usList5=FormHelper.retailername(formbean);
			
			 return result;
		 }
	 
	 //dsalesmemodelte
		
		 public String dsalesmemeodelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.dsalesmemeodelete(id);
			 dsalesmemeoentry();
			 return result;
		 }

	
	 
	 
	
	 
	 
	 public String csalesmemeoentry() 
		{
			String result = SUCCESS;
		//	usList=FormHelper.companylist(formbean);
			usList1=FormHelper.csalesmemeoentry(formbean);
			
			usList2=FormHelper.plist1(formbean);
			
			usList3=FormHelper.saleslist(formbean);
			
			return result;
		}
	 
	 
	 public String csalesmemeocreation() 
		{
			String result1 = SUCCESS;
			if(formbean != null)
			 {
				 boolean r=FormHelper.csalesmemeocreation(formbean);
				 if(r==true)
				 {
					 addActionMessage("sales counter sales memo Added Successfully..");
					 result1 = SUCCESS;
				 }
				 else
				 {
					 result1=ERROR;
				 }
				 formbean=null;
			 }
			csalesmemeoentry();
			return result1;
		}
	 
	 //salesmemoupdate
	 
		public String csalesmemeoupdate() 
		 {
			 String result=SUCCESS;
			
			    usList9=FormHelper.nameitem();
				
				usList1=FormHelper.csalesmemeoentry(formbean);
				usList2=FormHelper.plist1(formbean);
				
				usList3=FormHelper.saleslist(formbean);
				formbean=FormHelper.csalesmemeoupdate(id);
				usList5=FormHelper.retailername(formbean);
			
			 return result;
		 }
	 
	 //salesmemodelte
		
		 public String csalesmemeodelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.csalesmemeodelete(id);
			 csalesmemeoentry();
			 return result;
		 }
		 
		 
		 public String msalesmemeoentry() 
			{
			 System.out.println("hello1");
				String result = SUCCESS;
				
				usList1=FormHelper.msalesmemeoentry(formbean);
				System.out.println("hello2");
				usList2=FormHelper.plist1(formbean);
				usList3=FormHelper.saleslist(formbean);
				return result;
			}
		 public String msalesmemeocreation() 
			{
				String result1 = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.msalesmemeocreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("sales counter sales memo Added Successfully..");
					     result1 = SUCCESS;
					 }
					 else
					 {
						 result1=ERROR;
					 }
					 formbean=null;
				 }
				msalesmemeoentry();
				return result1;
			}
		 
		 //msalesmemoupdate
		 
			public String msalesmemeoupdate() 
			 {
				 String result=SUCCESS;
				
				 	usList9=FormHelper.nameitem();
					
					usList1=FormHelper.msalesmemeoentry(formbean);
					usList2=FormHelper.plist1(formbean);
					
					usList3=FormHelper.saleslist(formbean);
					formbean=FormHelper.msalesmemeoupdate(id);
					usList5=FormHelper.retailername(formbean);
				
				 return result;
			 }
		 
		 //msalesmemodelte
			
			 public String msalesmemeodelete() 
			 {
				 String result=SUCCESS;
				 FormHelper.msalesmemeodelete(id);
				 msalesmemeoentry();
				 return result;
			 }

	 
	 public String materialglist() 
		{
			String result = SUCCESS;
		
			 String prefix="GD";
			 String prefix1="GD";
				formbean=FormHelper.uniqueid1(prefix,prefix1);
			
			usList2=FormHelper.companylist(formbean);
			usList=FormHelper.materialglist(formbean);
			usList1=FormHelper.materialglist(formbean);
			 usList3=FormHelper.compdetaillist(formbean);
			return result;
		}
	 
	 
	 
	 	public String materialgroupcreation1() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.materialgroupcreation1(formbean);
					 if(r==true)
					 {
						 addActionMessage("Material Group Added Successfully..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				materialglist();
				return result;
			}
	 	
	 	public String materialupdate1() //material group master
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.materialedit1(id);
				usList=FormHelper.materialglist(formbean);
				usList1=FormHelper.materialglist(formbean);
				 usList3=FormHelper.compdetaillist(formbean);
			
			 return result;
		 }

//salesmandelete
		public String materialdelete1() //material group master
		 {
			 String result=SUCCESS;
			 FormHelper.mtdelete(id);
			 materialglist();
			 return result;
		 }
	 
	 
	 public String materialpaddarlist() 
		{
			String result = SUCCESS;
			String prefix="MMC";
			formbean=FormHelper.uniqueid1(prefix);
			
			
		//	usList=FormHelper.companylist(formbean);
			usList = FormHelper.materialnamelist(formbean);
			usList3 = FormHelper.companynamelist(formbean);
			usList1=FormHelper.materialpaddarlist(formbean);
			usList2=FormHelper.materialnamelist(formbean);
			 usList4=FormHelper.compdetaillist(formbean);
			 usList5 = FormHelper.purlist(formbean);
			 usList6 = FormHelper.sallist(formbean);
			return result;
		}
	 
	 
	 
	 public String paddarlistcreation1() 
		{
			String result = SUCCESS;
			if(formbean != null)
			 {
				 boolean r=FormHelper.paddarlistcreation1(formbean);
				 if(r==true)
				 {
					 addActionMessage("Material List Added Successfully..");
					 result = SUCCESS;
				 }
				 else
				 {
					 result=ERROR;
				 }
				 formbean=null;
			 }
			materialpaddarlist();
			return result;
		}
	 
	 
	 
	 
	
		public String paddarlistupdate1() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.paddarlistupdate1(id);
				/*usList=FormHelper.materialpaddarlist(formbean);
				usList1=FormHelper.materialpaddarlist(formbean);*/
				
				usList = FormHelper.materialnamelist(formbean);
				usList3 = FormHelper.companynamelist(formbean);
				usList1=FormHelper.materialpaddarlist(formbean);
				usList2=FormHelper.materialnamelist(formbean);
				 usList4=FormHelper.compdetaillist(formbean);
				 usList5 = FormHelper.purlist(formbean);
				 usList6 = FormHelper.sallist(formbean);
			
			 return result;
		 }
		
		public String paddarlistdelete1() //material master delete
		 {
			 String result=SUCCESS;
			 FormHelper.paddarlistdelete1(id);
			 materialpaddarlist();
			 return result;
		 }
		
		 public String salesmemeoentry() 
			{
				String result = SUCCESS;
			//	usList=FormHelper.companylist(formbean);
				usList1=FormHelper.salesmemeoentry(formbean);
				
				usList2=FormHelper.plist1(formbean);
				
				usList3=FormHelper.saleslist(formbean);
				return result;
			}
		 
		 
		 public String salesmemeocreation() 
			{
				String result1 = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.salesmemeocreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("sales memo Added Successfully..");
						 result1 = SUCCESS;
					 }
					 else
					 {
						 result1=ERROR;
					 }
					 formbean=null;
				 }
				salesmemeoentry();
				return result1;
			}
		 
		 //salesmemoupdate
		 
			public String salesmemeoupdate() 
			 {
				 String result=SUCCESS;
				 formbean=FormHelper.salesmemeoupdate(id);
					usList=FormHelper.salesmemeoentry(formbean);
					usList1=FormHelper.salesmemeoentry(formbean);
				
				 return result;
			 }
		 
		 //salesmemodelte
			
			 public String salesmemeodelete() 
			 {
				 String result=SUCCESS;
				 FormHelper.salesmemeodelete(id);
				 salesmemeoentry();
				 return result;
			 }
//materialgrouplist
		 public String materialgrouplist() 
			{
				String result = SUCCESS;
				usList=FormHelper.companylist(formbean);
				usList1=FormHelper.materialgrouplist(formbean);
				return result;
			}
//materialgroupcreation
		 public String materialgroupcreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.materialgroupcreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Group Created Successfully..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				materialgrouplist();
				return result;
			}
//materialgroupupdate
		 public String materialgroupupdate() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.materialgroupedit(id);
			 materialgrouplist();
			 return result;
		 }
//materialgroupdelete
		 public String materialgroupdelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.materialgroupdelete(id);
			 materialgrouplist();
			 return result;
		 }
//mrlist
		 public String mrlist() 
			{
				String result = SUCCESS;
				usList=FormHelper.mrlist(formbean);
				usList1=FormHelper.saleslist(formbean);
				usList2=FormHelper.companylist(formbean);
				return result;
			}
//mrcreation
		 public String mrcreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.mrcreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Medical Representative Saved..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				mrlist();
				return result;
			}
//mrupdate
		 public String mrupdate() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.mredit(id);
			 mrlist();
			 return result;
		 }
//mrdelete
		 public String mrdelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.mrdelete(id);
			 mrlist();
			 return result;
		 }
		 
//categorylist
		 public String categorylist() 
			{
				String result = SUCCESS;
				String prefix ="CAT";
				formbean=FormHelper.uniqueid1(prefix);
				usList=FormHelper.tlist(formbean);
				return result;
			}
		 
		 
//categorycreation
		 public String categorycreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.tcreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Party Category Saved..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				categorylist();
				return result;
			}
//categoryupdate
		 public String categoryupdate() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.tedit(id);
			 usList=FormHelper.tlist(formbean);
			 return result;
		 }
//categorydelete
		 public String categorydelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.tdelete(id);
			 categorylist();
			 return result;
		 }
//materialist
		 public String materialist() 
			{
				String result = SUCCESS;
				
				String prefix="MAT";
				formbean=FormHelper.uniqueid1(prefix);
				usList=FormHelper.materialist(formbean);//buttom list
				usList1=FormHelper.materiallist(formbean);//material grouplist
				usList2=FormHelper.companylist(formbean);//onac list
				usList3=FormHelper.unitlist(formbean);//unitlist
				return result;
			}
//materialcreation
		 public String materialcreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.materialcreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Material Saved..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				materialist();
				return result;
			}
//materialupdate
		 public String materialupdate() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.materialedit(id);
			 materialist();
			 return result;
		 }
//materialdelete
		 public String materialdelete() 
		 {
			 String result=SUCCESS;
			 boolean huu=FormHelper.mtdelete(id);
			 if(huu == true)
			 {
				 addActionMessage("Material Deleted...");
			 }
			 else
			 {
				 addActionMessage("");
			 }
			 materialist();
			 return result;
		 }
//placemasterlist
		 public String placemasterlist() 
			{
				String result = SUCCESS;
				String prefix ="PLC";
				formbean = FormHelper.uniqueid1(prefix);
				usList=FormHelper.plist(formbean);
				return result;
			}
//placecreation
		 public String placecreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.placecreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Place Saved..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				placemasterlist();
				return result;
			}
//placeupdate
		 public String placeupdate() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.pcedit(id);
			 System.out.println();
			 usList=FormHelper.plist(formbean);
				return result;
			 
		 }
//placedelete
		 public String placedelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.pcdelete(id);
			 placemasterlist();
			 return result;
		 }		 
//headquarterlist
		 public String headquarterlist() 
			{
				String result = SUCCESS;
				usList=FormHelper.headquarterlist(formbean);
				return result;
			}
//headquartercreation
		 public String headquartercreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.headquartercreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Saved..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				headquarterlist();
				return result;
			}
//headquarterupdate
		 public String headquarterupdate() 
		 {
			 String result=SUCCESS;
			 formbean=FormHelper.hqedit(id);
			 headquarterlist();
			 return result;
		 }
//headquarterdelete
		 public String headquarterdelete() 
		 {
			 String result=SUCCESS;
			 FormHelper.hqdelete(id);
			 headquarterlist();
			 return result;
		 }
//purchaseentrylist
		 public String purchaseentrylist()
		 {
			 String result=SUCCESS;
			 usList1=FormHelper.companylist(formbean);//for principle sundry creditors
			 //usList2=FormHelper.purchaselist(formbean);//for debit account purchaselist
			 usList4=FormHelper.unitlist(formbean);//for unitlist
			 usList7=FormHelper.categorylist(formbean);//transporter list
			 usList3=FormHelper.purchaseentrylist(formbean);//purchaseentrylist
			 return result;
		 }
//headquartercreation
		 public String purchaseentrycreation() 
			{
				String result = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.purchaseentrycreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("Purchase Saved..");
						 result = SUCCESS;
					 }
					 else
					 {
						 result=ERROR;
					 }
					 formbean=null;
				 }
				purchaseentrylist();
				return result;
			}
//purchaseentrydelete
		 public String purchaseentrydelete()
		 {
			 String result=SUCCESS;
			 boolean xx=FormHelper.purchaseentrydelete(id);
			 if(xx==true)
			 {
				 addActionMessage("Entry Deleted....");
			 }
			 purchaseentrylist();
			 return result;
		 }
//purchaseentryupdate
		 public String purchaseentryupdate()
		 {
			 String result=SUCCESS;
			 usList8=FormHelper.list4material(id,formbean);
			 formbean=FormHelper.purchaseentryedit(id);
			 purchaseentrylist();
			 return result;
		 }	 
//outwardlist
		 public String outwardlist()
		 {
			 String result=SUCCESS;
			 usList1=FormHelper.companylist(formbean);//for principle sundry creditors
			 usList2=FormHelper.sdpartylist(formbean);//for party sundry debtors
			 //usList4=FormHelper.unitlist(formbean);//for unitlist
			 usList5=FormHelper.categorylist(formbean);//category list
			 return result;
		 }
//salesinvoice
		 public String salesinvoicelist()
		 {
			 String result=SUCCESS;
			 usList1=FormHelper.companylist(formbean);//for principle sundry creditors
			 usList2=FormHelper.sdpartylist(formbean);//for party sundry debtors
			 usList4=FormHelper.unitlist(formbean);//for unitlist
			 usList5=FormHelper.categorylist(formbean);//category list
			 return result;
		 }
//tradingsalesinvoice
		 public String tradingsalesinvoicelist()
		 {
			 String result=SUCCESS;
			 usList1=FormHelper.companylist(formbean);//for principle sundry creditors
			 usList2=FormHelper.sdpartylist(formbean);//for party sundry debtors
			 usList4=FormHelper.unitlist(formbean);//for unitlist
			 usList5=FormHelper.categorylist(formbean);//category list
			 usList6=FormHelper.crsaleslist(formbean);//credit a/c
			 return result;
		 }
//tradingsalescreation
		 public String tradingsalescreation()
		 {
			 String result=SUCCESS;
			 addActionMessage("inside trading sales creation action:- "+result);
			 return result;
		 }
//incentiveschemelist
		 public String incentiveschemelist()
		 {
			 String result=SUCCESS;
			 usList1=FormHelper.companylist(formbean);//for principle sundry creditors
			 usList3=FormHelper.schemelist(formbean);
			 return result;
		 }
//incentiveschemecreation
		 public String incentiveschemecreation()
		 {
			 String result=SUCCESS;
			 if(FormHelper.incentiveschemecreation(formbean))
			 {
				 addActionMessage("Scheme Saved..");
			 }
			 incentiveschemelist();
			 return result;
		 }
		 
		//salesreturn
		 public String salesreturn() 
			{
				String result = SUCCESS;
			//	usList=FormHelper.companylist(formbean);
				usList1=FormHelper.salesreturn(formbean);
				
				usList2=FormHelper.plist1(formbean);
				
				usList3=FormHelper.saleslist(formbean);
				
				return result;
			}
		 
//salesreturncreation		 
		 public String salesreturncreation() 
			{
				String result1 = SUCCESS;
				if(formbean != null)
				 {
					 boolean r=FormHelper.salesreturncreation(formbean);
					 if(r==true)
					 {
						 addActionMessage("sales memo Added Successfully..");
						 result1 = SUCCESS;
					 }
					 else
					 {
						 result1=ERROR;
					 }
					 formbean=null;
				 }
				salesreturn();
				return result1;
			}
		 
		 //salesreturnupdate
		 
			public String salesreturnupdate() 
			 {
				 String result=SUCCESS;
				 formbean=FormHelper.salesreturnupdate(id);
				 usList9=FormHelper.nameitem();
					
					usList1=FormHelper.salesreturn(formbean);
					usList2=FormHelper.plist1(formbean);
					
					usList3=FormHelper.saleslist(formbean);
					formbean=FormHelper.salesreturnupdate(id);
					usList5=FormHelper.retailername(formbean);
				
				
				 return result;
			 }
		 
		 //salesreturndelete
			
			 public String salesreturndelete() 
			 {
				 String result=SUCCESS;
				 FormHelper.salesreturndelete(id);
				 salesreturn();
				 return result;
			 }


		 
		 
		 
		 public String partylist() 
			{
			 String result = SUCCESS;
			 String prefix="PCI";
			// String prefix1="PCI";
				formbean=FormHelper.uniqueid1(prefix);
			 usList=FormHelper.partydetaillist(formbean);
			 usList1=FormHelper.alist(formbean);
			 return result;
			 
			}
		 
		 public String partymastercreation() 
			{
			 String result=SUCCESS;
			 if(FormHelper.partymastercreation(formbean))
			 {
				 addActionMessage("Scheme Saved..");
			 }
			 formbean= null;
			 partydetaillist();
			 
			 return result;
			}
		 
		 public String companymastercreation() 
			{
			 String result=SUCCESS;
			 if(FormHelper.companymastercreation(formbean))
			 {
				 addActionMessage("Scheme Saved..");
			 }
			 formbean= null;
			 compdetaillist();
			 
			 return result;
			}
	
		 
		 public String claimmaster1() 
			{
			 String result=SUCCESS;
			 if(FormHelper.claimmaster1(formbean))
			 {
				 addActionMessage("Scheme Saved..");
			 }
			 formbean= null;
			claimlist();
			 
			 return result;
			}
		 
		 
		 
		 
		 
		 
		 
		 public String companylist() 
			{
				String result = SUCCESS;
				 String prefix="COMP";
				 String prefix1="COMP";
					formbean=FormHelper.uniqueid1(prefix,prefix1);
				
				
				return result;
			}
		 public String claimlist() 
			{
				String result = SUCCESS;
				
				 String prefix="CLM";
				 String prefix1="CLM";
					formbean=FormHelper.uniqueid1(prefix,prefix1);
				
					usList=FormHelper.claimlist(formbean);
				
				//acname();
				return result;
			}
		 
		 public String claimdelete() 
			{
				String result = SUCCESS;
			 boolean a=FormHelper.claimdelete(id);
				if(a==true)
				{
					addActionMessage("Entry Deleted....");
				}
				//acname();
				return result;
			}
		 
		 
		 
		 public String companydelete()
		 {
			 String result=SUCCESS;
			 boolean xx=FormHelper.companydelete(id);
			 if(xx==true)
			 {
				 addActionMessage("Entry Deleted....");
			 }
			 compdetaillist();
			 return result;
		 }
		 
		 public String partydelete()
		 {
			 String result=SUCCESS;
			 boolean xx=FormHelper.partydelete(id);
			 if(xx==true)
			 {
				 addActionMessage("Entry Deleted....");
			 }
			 partydetaillist();
			 return result;
		 }
		
		 public String compdetaillist() 
			{
				String result = SUCCESS;
				 usList=FormHelper.compdetaillist(formbean);
				//acname();
				return result;
			}
		
		 public String partydetaillist() 
			{
				String result = SUCCESS;
				/* String prefix="PCI";
				// String prefix1="PCI";
					formbean=FormHelper.uniqueid1(prefix);*/
				 usList=FormHelper.partydetaillist(formbean);
				 
				//acname();
				return result;
			}
		 
		 
		 public String partyupdate()
		 {
			 String result=SUCCESS;
			
			 formbean=FormHelper.partyedit(id);
			 partydetaillist();
			 return result;
		 }	 
		
		 public String companyupdate()
		 {
			 String result=SUCCESS;
			
			 formbean=FormHelper.companyedit(id);
			 compdetaillist();
			 return result;
		 }	  
		 
		 public String claimupdate()
		 {
			 String result=SUCCESS;
			
			 formbean=FormHelper.claimedit(id);
			 usList=FormHelper.claimlist(formbean);
			// claimlist();
			 return result;
		 }	  
		 
		 
		  
		 
	 public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getShortn() {
			return shortn;
		}

		public void setShortn(String shortn) {
			this.shortn = shortn;
		}

		public String getLongn() {
			return longn;
		}

		public void setLongn(String longn) {
			this.longn = longn;
		}
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public FormBean getFormbean() {
		return formbean;
	}

	public void setFormbean(FormBean formbean) {
		this.formbean = formbean;
	}
	
	public List<FormBean> getacgrouplist() {
		return acgrouplist;
	}
	
	public void setacgrouplist(List<FormBean> acgroupList) {
		this.acgrouplist = acgrouplist;
	}
	public List<FormBean> getUsList() {
		return usList;
	}

	public void setUsList(List<FormBean> usList) {
		this.usList = usList;
	}
	
	public List<FormBean> getUsList1() {
		return usList1;
	}

	public void setUsList1(List<FormBean> usList1) {
		this.usList1 = usList1;
	}
	
	public List<FormBean> getUsList2() {
		return usList2;
	}

	public void setUsList2(List<FormBean> usList2) {
		this.usList2 = usList2;
	}
	
	public List<FormBean> getUsList3() {
		return usList3;
	}

	public void setUsList3(List<FormBean> usList3) {
		this.usList3 = usList3;
	}
	
	public List<FormBean> getUsList4() {
		return usList4;
	}

	public void setUsList4(List<FormBean> usList4) {
		this.usList4 = usList4;
	}
	
	public List<FormBean> getUsList5() {
		return usList5;
	}

	public void setUsList5(List<FormBean> usList5) {
		this.usList5 = usList5;
	}
	
	public List<FormBean> getUsList6() {
		return usList6;
	}

	public void setUsList6(List<FormBean> usList6) {
		this.usList6 = usList6;
	}
	
	public List<FormBean> getUsList7() {
		return usList7;
	}

	public void setUsList7(List<FormBean> usList7) {
		this.usList7 = usList7;
	}
	
	public List<FormBean> getUsList8() {
		return usList8;
	}

	public void setUsList8(List<FormBean> usList8) {
		this.usList8 = usList8;
	}
	
	public List<FormBean> getUsList9() {
		return usList9;
	}

	public void setUsList9(List<FormBean> usList9) {
		this.usList9 = usList9;
	}


	public String[] getChecked() {
		 
	    return checked;
	}
	 
	public void setChecked(String[] checked) {
	 
	    this.checked=checked;
	 
	}
	
	public String[] getChecked1() {
		 
	    return checked1;
	}
	 
	public void setChecked1(String[] checked1) {
	 
	    this.checked1=checked1;
	 
	}
	
	public String[] getChecked2() {
		 
	    return checked2;
	}
	 
	public void setChecked2(String[] checked2) {
	 
	    this.checked2=checked2;
	 
	}
	
	public Integer getId() {
		return id;
		}
		 
	public void setId(Integer id) {
	this.id = id;
	}
	
	public File getUserImage() {
        return userImage;
    }
 
    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }
 
    public String getUserImageContentType() {
        return userImageContentType;
    }
 
    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }
 
    public String getUserImageFileName() {
        return userImageFileName;
    }
 
    public void setUserImageFileName(String userImageFileName) 
    {
        this.userImageFileName = userImageFileName;
    }
    
    public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}
	
	public String getStax() {
		return stax;
	}

	public void setStax(String stax) {
		this.stax = stax;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getLeadid() {
		return leadid;
	}

	public void setLeadid(String leadid) {
		this.leadid = leadid;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	  
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	}  
	
	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public String getLedger() {
		return ledger;
	}

	public void setLedger(String ledger) {
		this.ledger = ledger;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getFrmdate() {
		return frmdate;
	}

	public void setFrmdate(String frmdate) {
		this.frmdate = frmdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getAcname() {
		return acname;
	}

	public void setAcname(String acname) {
		this.acname = acname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFinyear() {
		return finyear;
	}

	public void setFinyear(String finyear) {
		this.finyear = finyear;
	}
 

}
