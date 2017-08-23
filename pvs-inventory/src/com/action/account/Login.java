package com.action.account;

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

import com.bean.account.FormBean;
import com.helper.account.FormHelper;
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
	//private SessionMap<String,Object> sessionMap; 
	private SessionMap<String,Object> sessionMap;  
	Map<String, Object> session = ActionContext.getContext().getSession();
	String d=(String)session.get("user");

	public String login() throws ParseException {
		//System.out.println("Avijit");
		String result="";
		//usList = FormHelper.list1();
		//usList1 = FormHelper.list2();
		//usList2 = FormHelper.list3();
		//usList3 = FormHelper.list4(d);
		//usList4 = FormHelper.list5(d);
		//usList5 = FormHelper.list6(d);
		result = SUCCESS;	
		return result;
	}
	
	public String dashboard() throws ParseException 
	{
		String result=SUCCESS;
		Map<String, Object> session = ActionContext.getContext().getSession();
		//System.out.println(company+","+finyear);	
		return result;
	}
	public String load() throws ParseException 
	{
		String result=SUCCESS;
		Map<String, Object> s4cf = ActionContext.getContext().getSession();
		//System.out.println("hello "+formbean.getCompany()+","+formbean.getFinyear());
		s4cf.put("cmp", ""+formbean.getCompany());
		s4cf.put("fin", ""+formbean.getFinyear());
		return result;
	}
	 public String userlist() 
		{
			
			String result = SUCCESS;
			usList=FormHelper.userlist();
			return result;
			
		}
	 public String loader1() 
		{
			String result = SUCCESS;
			usList=FormHelper.company();
			//usList1=FormHelper.company();
			return result;
		}
//master group creation
	 public String acgroupcreation()
	 {
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.acgroupcreation(formbean))
			 {
				 addActionMessage("Group Created Successfully..");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 acgrouplist();
			 return result;
		 }
		 return result;
	 }
//subgroup creation
	 public String grpnamecreation()
	 {
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.mgrpcreation(formbean))
			 {
				 addActionMessage("SubGroup Created Successfully..");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 grpnamelist();
			 return result;
		 }
		 return result;
	 }
//subgroup list
	 public String grpnamelist() 
		{
			String result = SUCCESS;
			usList=FormHelper.grpnamelist();//main group list
			usList1=FormHelper.grpnamelistdisp();//bottom list
			return result;
		}
	 public String grpnamelist1() 
		{
		 	Map<String,Object> sfortransaction1=ActionContext.getContext().getSession();
			sfortransaction1.put("count", ""+"");
			sfortransaction1.put("count", ""+count);
			Map<String,Object> val2=ActionContext.getContext().getSession();
		
			//cvalue=(String) sfortransaction.get("count");
			//val1.put("valu", ""+cvalue);
			//System.out.println("session value "+(String)sfortransaction1.get("count"));
			
			String result = SUCCESS;
			usList=FormHelper.grpnamelist();//main group list
			usList1=FormHelper.grpnamelistdisp();//bottom list
			return result;
		}
//subgroup update
	 public String grpnameupdate() 
		{
			String result = SUCCESS;
			formbean=FormHelper.grpnameedit(id);
			
			//System.out.println(enquerybean.getName());
			grpnamelist();
			return result;
		}
//subgroup delete	 
		 public String grpnamedelete() 
			{
			String result = SUCCESS;
			boolean x=FormHelper.grpnamedelete(id);
			if(x==false)
			{
				addActionMessage("Subgroup Master will not be deleted Due To Fixed Head....");
			}
			else if(x==true)
			{
				addActionMessage("Subgroup Master Deleted....");
			}
			grpnamelist();
			return result;
			}
	 
//narration
//narration creation
		 public String narrationcreation()
		 {
			 String result=ERROR;
			 if(formbean != null)
			 {
				 if(FormHelper.narrationcreation(formbean))
				 {
					 addActionMessage("Narration Created Successfully..");
					 result = SUCCESS;
				 }
				 else
				 {
					 result=ERROR;
				 }
				 formbean=null;
				 narrationlist();
				 return result;
			 }
			 return result;
		 } 
//narration list
		 public String narrationlist() 
			{
				String result = SUCCESS;
				usList=FormHelper.narrationlist();
				return result;
			}
//narration update
		 public String narrationupdate() 
			{
				String result = SUCCESS;
				formbean=FormHelper.narrationedit(id);
				//System.out.println(enquerybean.getName());
				narrationlist();
				return result;
			}
//narration delete
		 public String narrationdelete() 
			{
			String result = SUCCESS;
			FormHelper.narrationdelete(id);
			narrationlist();
			return result;
			}
//narration ends
		 
	 public String usercreation() 
		{
			String result = ERROR;
			if (formbean != null)
				{
				//System.out.println("Avi1234");
				if (FormHelper.usercreation(formbean))
					{
						addActionMessage("User create/Updated successfully!!!!!");
						result = SUCCESS;
					}
				else
					result = ERROR;
				}
			formbean = null;
			userlist();
			return result;
		}
//group delete	 
	 public String acgroupdelete() 
		{
		String result = SUCCESS;
		boolean x=FormHelper.acgroupdelete(id);
		if(x==false)
		{
			addActionMessage("Group Master will not be deleted Due To Fixed Head....");
		}
		else if(x==true)
		{
			addActionMessage("Group Master deleted....");
		}
		acgrouplist();
		return result;
		}
//group update	 
	 public String acgroupupdate() 
		{
			String result = SUCCESS;
			formbean=FormHelper.acgroupedit(id);
			//System.out.println(enquerybean.getName());
			acgrouplist();
			return result;
		}
//getting master group name 	 
	public String userupdate() 
	{
		String result = SUCCESS;
		formbean=FormHelper.useredit(id);
		
		//System.out.println(enquerybean.getName());
		userlist();
		return result;
	}

	public String userdelete() 
	{
	String result = SUCCESS;
	FormHelper.userdelete(id);
	
	//System.out.println(enquerybean.getName());
	userlist();
	return result;
	}
	public String acgrouplist() 
	{	
		String result = SUCCESS;
		usList=FormHelper.acgrouplist();
		return result;
	}
	public String acgrouplist1() 
	{	
		Map<String,Object> sfortransaction2=ActionContext.getContext().getSession();
		
		//System.out.println("Check: ");
		sfortransaction2.put("count", ""+count);
		Map<String,Object> val1=ActionContext.getContext().getSession();
	
		
		String result = SUCCESS;
		usList=FormHelper.acgrouplist();
		return result;
	}
//ledger	
//ledger creation
	public String ledgercreation()
	 {
		Map<String,Object> sfortransaction=ActionContext.getContext().getSession();
		Map<String,Object> val1=ActionContext.getContext().getSession();
		
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.ledgercreation(formbean))
			 {
				 addActionMessage("Ledger Saved....");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 String valu=(String) val1.get("valu");
			 //System.out.println("Values: "+valu);
			 //val1.put("valu", ""+valu);
			 ledgerlist();
		 }
		 return result;
	 }
//ledger list
	public String ledgerlist() 
	{

		String result = SUCCESS;
		usList1=FormHelper.ledgersublist();
		usList=FormHelper.ledgerlist();
		//formbean=FormHelper.setforledger(xx);
		return result;
	}
	
	public String ledgerlist1() 
	{
		Map<String,Object> sfortransaction=ActionContext.getContext().getSession();
		
		sfortransaction.put("count", ""+count);
		Map<String,Object> val1=ActionContext.getContext().getSession();
		
		String result = SUCCESS;
		usList1=FormHelper.ledgersublist();
		usList=FormHelper.ledgerlist();
		//formbean=FormHelper.setforledger(xx);
		return result;
	}
//ledger update
	public String ledgerupdate() 
	{
		String result = SUCCESS;
		formbean=FormHelper.ledgeredit(id);
		//System.out.println(enquerybean.getName());
		ledgerlist();
		return result;
	}
//ledger delete
	public String ledgerdelete() 
	{
	String result = SUCCESS;
	boolean x=FormHelper.ledgerdelete(id);
	if(x==false)
	{
		addActionMessage("Ledger will not be deleted Due To Fixed Head....");
	}
	else if(x==true)
	{
		addActionMessage("Ledger deleted....");
	}
	ledgerlist();
	return result;
	}
//ledger ends	
	
//payment starts here
//payment creation	
	public String paymentcreation()
	 {
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.paymentcreation(formbean))
			 {
				 addActionMessage("Payment Done Successfully..");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 paymentlist();
			 return result;
		 }
		 return result;
	 } 
//payment list
	 public String paymentlist() 
		{
			String result = SUCCESS;
			usList2=FormHelper.paymentpartlist1();//top on a/c drop down display
			usList1=FormHelper.paymentpartlist();//particular list
			usList3=FormHelper.contranar();//for narration
			usList=FormHelper.paymentlist();
			//formbean=FormHelper.setpart();
			return result;
		}
//payment update
	 public String paymentupdate() 
		{
			String result = SUCCESS;
			formbean=FormHelper.paymentedit(id);
			//System.out.println(enquerybean.getName());
			paymentlist();
			return result;
		}
//payment delete
	 public String paymentdelete() 
		{
		String result = SUCCESS;
		String x=FormHelper.paymentdelete(id);
		//System.out.println(x);
		String ar[]=x.split("con");
		if(ar[0].equals("true"))
		{
			addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
		}
		paymentlist();
		return result;
		}
//payment ends here
	 
//contra starts here
//contra creation
	 public String contracreation()
	 {
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.contracreation(formbean))
			 {
				 addActionMessage("Contra Saved Successfully..");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 contralist();
			 return result;
		 }
		 return result;
	 }
//contra list
	 public String contralist() 
		{
			String result = SUCCESS;
			usList2=FormHelper.paymentpartlist1();//for on a/c display
			usList4=FormHelper.partlist();//for particular firsttime list
			usList3=FormHelper.contranar();
			//usList1=FormHelper.paymentpartlist();
			usList=FormHelper.contralist();
			//formbean=FormHelper.setpart();
			return result;
		}
//contra update
	 public String contraupdate() 
		{
			String result = SUCCESS;
			formbean=FormHelper.contraedit(id);
			usList4=FormHelper.partlist1(id);
			//usList6=FormHelper.contradynamiclist(id);
			//System.out.println("List Size:"+usList6.size());
			usList2=FormHelper.paymentpartlist1();//for on a/c display
			usList3=FormHelper.contranar();
			//usList1=FormHelper.paymentpartlist();
			usList=FormHelper.contralist();
			return result;
		}
//contra delete
	 public String contradelete() 
		{
		String result = SUCCESS;
		FormHelper.contradelete(id);
		contralist();
		return result;
		}
//contra ends here
	 
//journal starts here
//journal creation
	 public String journalcreation()
	 {
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.journalcreation(formbean))
			 {
				 addActionMessage("Created Successfully..");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 journallist();
			 return result;
		 }
		 return result;
	 }
//journal list
	 public String journallist() 
		{
			String result = SUCCESS;
			usList2=FormHelper.journalmainpartlist();//for on a/c display 
			usList1=FormHelper.journalmainpartlist();
			usList=FormHelper.journallist();
			usList3=FormHelper.contranar();
			return result;
		}
//journal update
	 public String journalupdate() 
		{
		 String result = SUCCESS;
			formbean=FormHelper.journaledit(id);
			usList4=FormHelper.partlist1(id);
			usList2=FormHelper.paymentpartlist1();//for on a/c display
			usList3=FormHelper.contranar();
			usList=FormHelper.receiptlist();
			journallist();
			return result;
		}
//journal delete
	 public String journaldelete() 
		{
		 	String result = SUCCESS;
			String x=FormHelper.journaldelete(id);
			//System.out.println(x);
			String ar[]=x.split("con");
			if(ar[0].equals("true"))
			{
				addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
			}
			journallist();
			return result;
		}
//journal ends here

//debit note starts
	//debit note creation
		 public String debitnotecreation()
		 {
			 String result=ERROR;
			 if(formbean != null)
			 {
				 if(FormHelper.debitnotecreation(formbean))
				 {
					 addActionMessage("Created Successfully..");
					 result = SUCCESS;
				 }
				 else
				 {
					 result=ERROR;
				 }
				 formbean=null;
				 debitnotelist();
				 return result;
			 }
			 return result;
		 }
	//debit note list
		 public String debitnotelist() 
			{
			 String result = SUCCESS;
				usList2=FormHelper.paymentpartlist2();//for on a/c display 
				usList1=FormHelper.paymentpartlist();
				usList=FormHelper.debitnotelist();
				usList3=FormHelper.contranar();
				//formbean=FormHelper.setpart();
				return result;
			}
	//debit note update
		 public String debitnoteupdate() 
			{
			 String result = SUCCESS;
				formbean=FormHelper.contraedit(id);
				usList4=FormHelper.partlist1(id);
				//usList6=FormHelper.contradynamiclist(id);
				//System.out.println("List Size:"+usList6.size());
				usList2=FormHelper.paymentpartlist1();//for on a/c display
				usList3=FormHelper.contranar();
				//usList1=FormHelper.paymentpartlist();
				usList=FormHelper.receiptlist();
				debitnotelist();
				return result;
			}
	//debit delete
		 public String debitnotedelete() 
			{
			 String result = SUCCESS;
			String x=FormHelper.contradelete(id);
			String ar[]=x.split("con");
			if(ar[0].equals("true"))
			{
				//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
				addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
			}
			debitnotelist();
			return result;
			}	 
//debit note ends 

		//credit note starts
			//credit note creation
				 public String creditnotecreation()
				 {
					 String result=ERROR;
					 if(formbean != null)
					 {
						 if(FormHelper.creditnotecreation(formbean))
						 {
							 addActionMessage("Created Successfully..");
							 result = SUCCESS;
						 }
						 else
						 {
							 result=ERROR;
						 }
						 formbean=null;
						 creditnotelist();
						 return result;
					 }
					 return result;
				 }
			//credit note list
				 public String creditnotelist() 
					{
						String result = SUCCESS;
						usList2=FormHelper.paymentpartlist2();//for on a/c display 
						usList1=FormHelper.paymentpartlist();
						usList=FormHelper.creditnotelist();
						usList3=FormHelper.contranar();
						//formbean=FormHelper.setpart();//last created ledger
						return result;
					}
			//credit note update
				 public String creditnoteupdate() 
					{
					 String result = SUCCESS;
						formbean=FormHelper.paymentedit(id);
						//System.out.println(enquerybean.getName());
						creditnotelist();
						return result;
					}
			//credit delete
				 public String creditnotedelete() 
					{
					String result = SUCCESS;
					String x=FormHelper.paymentdelete(id);
					String ar[]=x.split("con");
					if(ar[0].equals("true"))
					{
						//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
						addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
					}
					creditnotelist();
					return result;
					}	 
		//debit note ends 
				 
//sales starts here
//sales creation
				 public String salescreation()
				 {
					 String result=ERROR;
					 if(formbean != null)
					 {
						 if(FormHelper.salescreation(formbean))
						 {
							 addActionMessage("Created Successfully..");
							 result = SUCCESS;
						 }
						 else
						 {
							 result=ERROR;
						 }
						 formbean=null;
						 saleslist();
						 return result;
					 }
					 return result;
				 }
//sales list
				 public String saleslist() 
					{
						String result = SUCCESS;
						usList2=FormHelper.paymentpartlist4();//for on a/c display 
						usList1=FormHelper.paymentpartlist();
						usList=FormHelper.saleslist();
						usList3=FormHelper.contranar();
						return result;
					}
				//sales update
				 public String salesupdate() 
					{
					 String result = SUCCESS;
						formbean=FormHelper.paymentedit(id);
						//System.out.println(enquerybean.getName());
						saleslist();
						return result;
					}
//sales delete
				 public String salesdelete() 
					{
					 String result = SUCCESS;
					String x=FormHelper.paymentdelete(id);
					String ar[]=x.split("con");
					if(ar[0].equals("true"))
					{
						//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
						addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
					}
					saleslist();
					return result;
					}
//sales ends here
//cash sales starts
				 public String cashsaleslist() 
					{
						String result = SUCCESS;
						usList2=FormHelper.cashlistonac();//for on a/c top display 
						usList1=FormHelper.paymentpartlist();//for particulars list
						usList=FormHelper.cashsaleslist();//for bottom display
						usList3=FormHelper.contranar();//for narration listing
						return result;
					}
//cash sales creation
				 public String cashsalescreation()
				 {
					 //System.out.println("iiii");
					 String result=ERROR;
					 if(formbean != null)
					 {
						 if(FormHelper.cashsalescreation(formbean))
						 {
							 addActionMessage("Created Successfully..");
							 result = SUCCESS;
						 }
						 else
						 {
							 result=ERROR;
						 }
						 formbean=null;
						 cashsaleslist();
						 return result;
					 }
					 return result;
				 }
//cash sales update
				 public String cashsalesupdate() 
					{
					 String result = SUCCESS;
						formbean=FormHelper.paymentedit(id);
						//System.out.println(enquerybean.getName());
						cashsaleslist();
						return result;
					}
//cash sales delete
				 public String cashsalesdelete() 
					{
					 	String result = SUCCESS;
						String x=FormHelper.paymentdelete(id);
						String ar[]=x.split("con");
						if(ar[0].equals("true"))
						{
							//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
							addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
						}
						cashsaleslist();
						return result;
					}
//cash sales ends	
//cash purchase starts
				 public String cashpurchaselist() 
					{
					 //System.out.println("inside cash purchase list");
						String result = SUCCESS;
						usList2=FormHelper.cashlistonac();//for on a/c display 
						usList1=FormHelper.paymentpartlist();//particulars listing
						usList=FormHelper.cashpurchaselist();//bottom elements listing
						usList3=FormHelper.contranar();//narration listing
						return result;
					}
//cash purchase creation
				 public String cashpurchasecreation1()
				 {
					 String result=ERROR;
					 if(formbean != null)
					 {
						 if(FormHelper.cashpurchasecreation(formbean))
						 {
							 addActionMessage("Created Successfully..");
							 result = SUCCESS;
						 }
						 else
						 {
							 result=ERROR;
						 }
						 formbean=null;
						 cashpurchaselist();
						 return result;
					 }
					 return result;
				 }
//cash purchase update
				 public String cashpurchaseupdate() 
					{
					 	String result = SUCCESS;
						formbean=FormHelper.paymentedit(id);
						//System.out.println(enquerybean.getName());
						cashpurchaselist();
						return result;
					}
//cash purchase delete
				 public String cashpurchasedelete() 
					{
					 	String result = SUCCESS;
						String x=FormHelper.paymentdelete(id);
						String ar[]=x.split("con");
						if(ar[0].equals("true"))
						{
							//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
							addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
						}
						cashpurchaselist();
						return result;
					}
//cash purchase ends
//opening trail display
				 public String openingtriallist() 
					{
					 String result = SUCCESS;
					
					 usList=FormHelper.openingtriallist();
					 
					 return result;
					}				 
//opening trail display ends
				//purchase starts here
				//purchase creation
								 public String purchasecreation()
								 {
									 //System.out.println("inside purchase creation");
									 String result=ERROR;
									 if(formbean != null)
									 {
										 if(FormHelper.purchasecreation(formbean))
										 {
											 addActionMessage("Created Successfully..");
											 result = SUCCESS;
										 }
										 else
										 {
											 result=ERROR;
										 }
										 formbean=null;
										 purchaselist();
										 return result;
									 }
									 return result;
								 }
				//purchase list
								 public String purchaselist() 
									{
										String result = SUCCESS;
										usList2=FormHelper.paymentpartlist3();//for on a/c display 
										usList1=FormHelper.paymentpartlist();
										usList=FormHelper.purchaselist();
										usList3=FormHelper.contranar();
										return result;
									}
								//purchase update
								 public String purchaseupdate() 
									{
									 String result = SUCCESS;
										formbean=FormHelper.paymentedit(id);
										//System.out.println(enquerybean.getName());
										purchaselist();
										return result;
									}
				//purchase delete
								 public String purchasedelete() 
									{
									 String result = SUCCESS;
									String x=FormHelper.paymentdelete(id);
									String ar[]=x.split("con");
									if(ar[0].equals("true"))
									{
										//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
										addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
									}
									purchaselist();
									return result;
									}
				//sales ends here
//receipt starts here
	 public String receiptcreation()
	 {
		 String result=ERROR;
		 if(formbean != null)
		 {
			 if(FormHelper.receiptcreation(formbean))
			 {
				 addActionMessage("Receipt Created Successfully..");
				 result = SUCCESS;
			 }
			 else
			 {
				 result=ERROR;
			 }
			 formbean=null;
			 receiptlist();
			 return result;
		 }
		 return result;
	 }  
//receipt list
	 public String receiptlist() 
		{
			String result = SUCCESS;
			//formbean=FormHelper.setpart();
			usList2=FormHelper.paymentpartlist1();
			usList1=FormHelper.paymentpartlist();
			usList3=FormHelper.contranar();
			usList=FormHelper.receiptlist();
			//formbean=FormHelper.setpart();
			return result;
		}
//receipt update
	 public String receiptupdate() 
		{
		 String result = SUCCESS;
			formbean=FormHelper.contraedit(id);
			usList4=FormHelper.partlist1(id);
			//usList6=FormHelper.contradynamiclist(id);
			//System.out.println("List Size:"+usList6.size());
			usList2=FormHelper.paymentpartlist1();//for on a/c display
			usList3=FormHelper.contranar();
			//usList1=FormHelper.paymentpartlist();
			usList=FormHelper.receiptlist();
			receiptlist();
			return result;
		}
//receipt delete
	 public String receiptdelete() 
		{
		 String result = SUCCESS;
		String x=FormHelper.contradelete(id);
		String ar[]=x.split("con");
		if(ar[0].equals("true"))
		{
			//System.out.println("Particular "+ar[1]+", Voucher No "+ar[2]+" Deleted Successfully");
			addActionMessage("Particular- "+ar[1]+", Voucher No- "+ar[2]+" Deleted Successfully");
		}
		receiptlist();
		return result;
		}
//receipt ends here
//trial balane list starts
	 public String triallist() 
		{
			String result = SUCCESS;
			formbean=FormHelper.getuptodate(date);
			usList=FormHelper.triallist();
			return result;
		}
//trial search
	 public String trialsearch() 
		{
			String result = SUCCESS;
			usList=FormHelper.trialsearch(formbean);
			formbean=FormHelper.getasondate(formbean);
			return result;
		}
//ledger report	 
	 public String ledgerreport() 
		{
			String result = SUCCESS;
			formbean=FormHelper.getledger(ledger);
			usList=FormHelper.ledgerreport(ledger);
			return result;
		}
//monthwisereport
	 public String monthwisereport() 
		{
			String result = SUCCESS;
			Map<String ,Object> session=ActionContext.getContext().getSession();
			session.put("months", ""+months);
			session.put("ledger", ""+ledger);
			
    		String months=(String) session.get("months");
			String ledger=(String) session.get("ledger");
	
			formbean=FormHelper.getmonthwise(months,ledger);
			usList=FormHelper.monthwisereport(months,ledger); 
			return result;
		}
//datewisereport
	 public String datewisereport() 
		{
			String result = SUCCESS;
			usList=FormHelper.datewisereport(date,ledger);		
			return result;
		}	 
//reportedit
	 public String reportedit() 
		{
			String result = SUCCESS;
			//usList=FormHelper.reportedit(date,ledger);	
			formbean=FormHelper.reportedit(date,ledger);
			usList2=FormHelper.reportedit();//top a/c
			usList1=FormHelper.paymentpartlist();
			usList3=FormHelper.contranar();//narration list
			return result;
		}	
//reporteditsave
	 public String reporteditsave() 
		{
		 	String result = SUCCESS;
		 	
		 	String months=(String) session.get("months");
			String ledger=(String) session.get("ledger");
		 	
		 	FormHelper.reporteditsave(formbean);
		 	usList=FormHelper.monthwisereport(months,ledger);
		 	formbean=FormHelper.getmonthwise(months,ledger);
		 	//monthwisereport();
			return result;
		}
//reportlist
//trial balance list ends 
	 public String monthreport() 
		{
		 String result = SUCCESS;
		 //System.out.println("value inside action "+month+accid+shortn+longn);
		 if(shortn.compareTo("Without_Narration")==0 && longn.compareTo("Without_Narration")==0)
		 {
		 usList1=FormHelper.monthreport(month,accid,shortn,longn);
		 }
		 else if(shortn.compareTo("With_Narration")==0 && longn.compareTo("Without_Narration")==0)
		 {
			 usList2=FormHelper.monthreport(month,accid,shortn,longn);
		 }
		 else if(shortn.compareTo("Without_Narration")==0 && longn.compareTo("With_Narration")==0)
		 {
			 usList3=FormHelper.monthreport(month,accid,shortn,longn);
		 }
		 else if(shortn.compareTo("With_Narration")==0 && longn.compareTo("With_Narration")==0)
		 {
			 usList4=FormHelper.monthreport(month,accid,shortn,longn);
		 }
		 formbean=FormHelper.monthreport1(month,accid,shortn,longn);
		// System.out.println(shortn+"   "+longn);
		 
		 return result;
		}
	 	public Integer getMonth() 
	 	{
			return id;
		}
			 
		public void setMonth(String month) 
		{
			this.month = month;
		}
		public String cashbooklist() 
		{
			String result = SUCCESS;
			accname();
			usList1=FormHelper.cashbooklistdetails2(formbean); 
			usList2=FormHelper.cashbooklistdetails(formbean); 
			return result;
		}
		public String accname() 
		{
		 String result = SUCCESS;
		 usList=FormHelper.accnamelist(formbean);
		 return result;
		}
	 public String cashbooklist1() 
		{
		 String result = SUCCESS;
		 accname();
		 return result;
		}
	 public String cashtriallist() 
		{
		 String result = SUCCESS;
		
		 //usList=FormHelper.cashtriallistdetails(formbean);
		 
		 return result;
		}
	 public String cashtriallistdetails() 
		{
		 String result = SUCCESS;
		
		 usList=FormHelper.cashtriallistdetails(formbean);
		 
		 return result;
		}
	 public String cashlist() 
		{
			
			String result = SUCCESS;
			dailycashlist();
			//usList=FormHelper.dailycash_bal(formbean);
			//usList1=FormHelper.dailycash_bal(formbean);
			return result;
		}
	 public String cashlistdetails() 
		{
			
			String result = SUCCESS;
			dailycashlist();
			usList=FormHelper.cashlistdetails(formbean);
			//usList1=FormHelper.dailycash_bal(formbean);
			return result;
		}
	 
	 public String dailycashlist() 
		{
		 String result = SUCCESS;
			usList2=FormHelper.paymentpartlist1();
			//usList=FormHelper.dailycash_bal();
			return result;
		}
	 
	 public String partyledgerlist() 
		{
			String result = SUCCESS;
			//usList2=FormHelper.paymentpartlist1();
			acname();
			return result;
		} 
	 
	 public String acname() 
		{
			String result = SUCCESS;
			usList=FormHelper.acnamelist(formbean);
			//acname();
			return result;
		} 
	 
	 public String partyledgerlistdetails() 
		{
			String result = SUCCESS;
			if(formbean.getFrmdate().compareTo("")!=0  && formbean.getTodate().compareTo("")!=0)
			{
				//System.out.println("usList 2");
				usList2=FormHelper.partyledgerlistdetails2(formbean);
			}
			else
			{
				//System.out.println("usList 2");
				usList1=FormHelper.partyledgerlistdetails(formbean);
				
			}
			acname();
			return result;
		}
//a/c statement
	 public String statementlist() 
		{
			String result = SUCCESS;
			usList2=FormHelper.acnamelist(formbean);
			//usList1=FormHelper.dailycash_bal(formbean);
			return result;
		}
	 public String statementlistdetails() 
		{
			
			String result = SUCCESS;
			Map<String ,Object> session12=ActionContext.getContext().getSession();
			/*session12.put("frmdate", ""+frmdate);
			session12.put("todate", ""+todate);*/
			usList=FormHelper.statementlistdetails(formbean);
			//usList1=FormHelper.dailycash_bal(formbean);
			xx=(String) session12.get("frmdate");
			yy=(String) session12.get("todate");
			zz=(String) session12.get("ledger");
			//System.out.println("check if the value received or not "+xx+","+yy+","+zz);
			statementlist();
			return result;
		}
	 public String statementedit() 
		{
			String result = SUCCESS;
			formbean=FormHelper.statementeditdetails(date,ledger);
			usList2=FormHelper.paymentpartlist5();
			usList1=FormHelper.paymentpartlist();
			usList3=FormHelper.contranar();
			return result;
		}
	 public String statementeditsave() 
		{
		 	String result = SUCCESS;
		 	Map<String ,Object> session12=ActionContext.getContext().getSession();
		 	xx=(String) session12.get("frmdate");
			yy=(String) session12.get("todate");
			zz=(String) session12.get("ledger");
		 	//System.out.println("check if the value received or not "+xx+","+yy+","+zz);
		 	FormHelper.statementeditsave(formbean);
		 	//usList=FormHelper.statementlistdetails2(xx,yy,zz);
		 	//formbean=FormHelper.getmonthwise(frmdate,todate,ledger);
		 	//System.out.println(frmdate+" "+todate+" "+ledger);
		 	
			return result;
		}
	public String narration() 
	{
		String result = SUCCESS;
		//usList=FormHelper.acgrouplist();
		return result;
	}
	
//bank book
	 public String bankbooklist() 
		{
		 String result = SUCCESS;
		 usList=FormHelper.bankpartlist();
		 return result;
		}
//banklist after action
	 public String banklist() 
		{
		 String result = SUCCESS;
		 	usList1=FormHelper.cashbooklistdetails2(formbean);//credit
			usList2=FormHelper.cashbooklistdetails(formbean);//debit
		 bankbooklist();
		 return result;
		}
	 
	 public String maintainlist() 
		{
			
			String result = SUCCESS;
			acname();
			return result;
		}
	 public String maintainlistdetails() 
		{			
			String result = SUCCESS;
			//System.out.println("value got "+count);
			usList1=FormHelper.maintainlistdetails(formbean);
			//usList1=FormHelper.dailycash_bal(formbean);
			return result;
		} 
//bank reconciliation
	 public String bankreconsiliation() 
		{			
			String result = SUCCESS;
			usList=FormHelper.bankpartlist();
			return result;
		} 
//bank reconciliation search
	 public String bankreconciliationsearch() 
		{			
			String result = SUCCESS;
			usList=FormHelper.bankpartlist();
			usList1=FormHelper.bankreconciliationsearch(formbean);
			return result;
		}
//bank reconciliation report
	 public String bankreconciliationreport() 
		{			
			String result = SUCCESS;
			usList=FormHelper.bankpartlist();
			return result;
		} 
	 public String bankreconsearch() 
		{			
			String result = SUCCESS;
			//System.out.println("check action");
			usList=FormHelper.bankpartlist();
			usList1=FormHelper.bankreconsearch(formbean);
			return result;
		}
//group triallist
	 public String grouptriallist() 
		{
			String result = SUCCESS;
			formbean=FormHelper.getuptodate(date);
			//System.out.println("hello "+formbean);
			usList=FormHelper.grouptriallist();
			return result;
		}
	 public String grouptrialsearch() 
		{
			String result = SUCCESS;
			formbean=FormHelper.getasondate(formbean);
			//System.out.println("hello "+formbean);
			usList=FormHelper.grouptrialsearch(formbean);
			return result;
		}
	 public String subgrouptriallist() 
		{
			String result = SUCCESS;
			formbean=FormHelper.getuptodate(date);
			usList=FormHelper.subgrouptriallist();
			return result;
		}
	 public String subgrouptrialsearch() 
		{
			String result = SUCCESS;
			usList=FormHelper.subgrouptrialsearch(formbean);
			formbean=FormHelper.getasondate(formbean);
			return result;
		}
	
	 public String billoutstandinglist() 
		{
			String result = SUCCESS;
			usList1=FormHelper.acnamelist1(formbean);
			return result;
		}
	 public String billoutstandinglistdetails() 
		{			
			String result = SUCCESS;
			//System.out.println("value got "+count);
			usList=FormHelper.billoutstandinglistdetails(formbean);
			//usList1=FormHelper.dailycash_bal(formbean);
			billoutstandinglist();
			return result;
		}
//daybook starts
	 public String daybooklist() 
		{			
			String result = SUCCESS;
		
			return result;
		}
	 public String daybooklistdetails() 
		{			
			String result = SUCCESS;
			//formbean=FormHelper.asondate1(formbean);
			//System.out.println("date found in action "+date);
			usList1=FormHelper.daybooklistdetails(formbean);			
			return result;
		} 
//daybook ends
//journal register starts
	 public String journalregisterlist() 
		{
			String result = SUCCESS;
			acname();
			return result;
		}
	 public String journalregisterlistdetails() 
		{			
			String result = SUCCESS;
			Map<String ,Object> sessionb=ActionContext.getContext().getSession();
			sessionb.put("frmdate", ""+frmdate);
			sessionb.put("todate", ""+todate);
			sessionb.put("acname", ""+acname);
			sessionb.put("type", ""+type);
			String i1=(String)sessionb.get("frmdate");
			String i2=(String)sessionb.get("todate");
			String i3=(String)sessionb.get("acname");
			String i4=(String)sessionb.get("type");
			//System.out.println("check value in action(i value) "+i1+","+i2+","+i3+","+i4);
			acname(); 
			usList1=FormHelper.journalregisterlistdetails(i1,i2,i3,i4);
			return result;
		} 
	 public String journalregisterlistdetails1() 
		{			
			String result = SUCCESS;
			Map<String ,Object> sessionb=ActionContext.getContext().getSession();
			String i1=(String)sessionb.get("frmdate");
			String i2=(String)sessionb.get("todate");
			String i3=(String)sessionb.get("acname");
			String i4=(String)sessionb.get("type");
			//System.out.println("check value in action(i value) "+i1+","+i2+","+i3+","+i4);
			acname(); 
			usList1=FormHelper.journalregisterlistdetails(i1,i2,i3,i4);
			return result;
		}  
	 public String journalreport() 
		{
			String result = SUCCESS;
			formbean=FormHelper.journaledit1(date,v);
			//usList1=FormHelper.partlist2(date,v);
			usList1=FormHelper.paymentpartlist1();//for on a/c display
			usList3=FormHelper.contranar();
			usList1=FormHelper.journalmainpartlist();
			//usList=FormHelper.receiptlist();
			//journallist();
			
			return result;
		}

	 
	 
	 public String logout(){  
		    sessionMap.invalidate();  
		    return "success";  
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
