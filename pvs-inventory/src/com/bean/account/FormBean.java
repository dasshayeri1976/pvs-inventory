package com.bean.account;

import java.io.File;

public class FormBean 
{
	private String accid,catagory,sname,name,fname,address,address2,add,contact,email,mobile,gender,community,dob,pf,doa,deg,post,department,workshop,gradepay,comcertificate,educertificate,matcertificate,place,cdate,edate;
	private Integer id;
	private String[] academic;
	private String[] board;
	private String[] passingyear;
	private String userid,username,userpass,password,roll,userstatus,pon,cperson,city,district,pcode,state,scode,remarks,doj,rmobile,eduqli,tecqli,pmobile;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName,vtype1;
	private String ctype,ccode,mcode,pserial,ptype,comcode,cptype,premarks,cremarks,sremarks,pdate,bname;
	private String modelcode,modelname,brandname,productname,companyname,brandcode,allocation,engname,spare,user,distance,amount;
	private String engstatus,sparedetails,expencedetails,total,total1;
	private String[] quantity;
	private String[] amount1;
	private String[] narration;
	private String[] narration1;
	private String[] credit;
	private String[] credithidden;
	private String[] debit;
	private String[] partforcontra;
	private String[] contra1;
	private String[] vtype;
	private String[] parti;
	private String[] dt;
	private String[] gross;
	private String[] pre;
	private String[] due;
	private String[] vtypehidden;
	private String[] partihidden;
	private String[] dthidden;
	private String[] grosshidden;
	private String[] prehidden;
	private String[] duehidden;
	private String[] doref;
	private String[] dat,billamount,adjusted,dues,dorc,dorchidden,debithidden;
	private String partdebit,partcredit,refnodebit,refnocredit,refdatedebit,refdatecredit,amountdebit,amountcredit,vtyp,choice,achead,groupcat;
	private String frmdate,todate,icharge,complaincode,complainname,count,getsession,drcr,uptodate,case1,entry,chedd,chedddate,clearedon;
	private String income,groupname,subgroups,srno,shortn,longn,subs,maxd,maxc,company,finyear;
	private String date1,particulars,grossamt,amtadjusted,amtbalance,age,v;
	//for group master
	private String gname,classy,cat,catforinex,ptext,detailreq,voucher,refno,refdate,type,led,grouphead,openingbal,particular,cashrcvd,cashpaid,accname,vno;
	private int schname,contsr;
	private String subgroupdes,mgrpname,mgrpname1,opetotal,debittotal,credittotal,acname,month,date,dated,amount_debited,amount_credited,forac;
	private String title,desc1,dc,ledger,group,debitam,creditam,asondate,months,nv,closing,opening_bal,debitamt,creditamt,closing_balance;
	private String alias,sub_grp,main_grp,opebal,prebal,default1,maintainbal,inventoryval,opedc,cost,mailto,pan1,vat,contname,phno;
	
	public String getFinyear() {
		return finyear;
	}
	public void setFinyear(String finyear) {
		this.finyear = finyear;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMaxc() {
		return maxc;
	}
	public void setMaxc(String maxc) {
		this.maxc = maxc;
	}
	public String getMaxd() {
		return maxd;
	}
	public void setMaxd(String maxd) {
		this.maxd = maxd;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getVtype1() {
		return vtype1;
	}
	public void setVtype1(String vtype1) {
		this.vtype1 = vtype1;
	}
	public String getSubs() {
		return subs;
	}
	public void setSubs(String subs) {
		this.subs = subs;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public String getGrossamt() {
		return grossamt;
	}
	public void setGrossamt(String grossamt) {
		this.grossamt = grossamt;
	}
	public String getAmtadjusted() {
		return amtadjusted;
	}
	public void setAmtadjusted(String amtadjusted) {
		this.amtadjusted = amtadjusted;
	}
	public String getAmtbalance() {
		return amtbalance;
	}
	public void setAmtbalance(String amtbalance) {
		this.amtbalance = amtbalance;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public String getSrno() {
		return srno;
	}
	public void setSrno(String srno) {
		this.srno = srno;
	}
	public String getSubgroups() {
		return subgroups;
	}
	public void setSubgroups(String subgroups) {
		this.subgroups = subgroups;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getGroupcat() {
		return groupcat;
	}
	public void setGroupcat(String groupcat) {
		this.groupcat = groupcat;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getChedd() {
		return chedd;
	}
	public void setChedd(String chedd) {
		this.chedd = chedd;
	}
	public String getChedddate() {
		return chedddate;
	}
	public void setChedddate(String chedddate) {
		this.chedddate = chedddate;
	}
	public String getClearedon() {
		return clearedon;
	}
	public void setClearedon(String clearedon) {
		this.clearedon = clearedon;
	}
	public String getCase1() {
		return case1;
	}
	public void setCase1(String case1) {
		this.case1 = case1;
	}
	public String getVtyp() {
		return vtyp;
	}
	public void setVtyp(String vtyp) {
		this.vtyp = vtyp;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getAchead() {
		return achead;
	}
	public void setAchead(String achead) {
		this.achead = achead;
	}
	public String getUptodate() {
		return uptodate;
	}
	public void setUptodate(String uptodate) {
		this.uptodate = uptodate;
	}
	public String getPartdebit() {
		return partdebit;
	}
	public void setPartdebit(String partdebit) {
		this.partdebit = partdebit;
	}
	public String getPartcredit() {
		return partcredit;
	}
	public void setPartcredit(String partcredit) {
		this.partcredit = partcredit;
	}
	public String getRefnodebit() {
		return refnodebit;
	}
	public void setRefnodebit(String refnodebit) {
		this.refnodebit = refnodebit;
	}
	public String getRefnocredit() {
		return refnocredit;
	}
	public void setRefnocredit(String refnocredit) {
		this.refnocredit = refnocredit;
	}
	public String getRefdatedebit() {
		return refdatedebit;
	}
	public void setRefdatedebit(String refdatedebit) {
		this.refdatedebit = refdatedebit;
	}
	public String getRefdatecredit() {
		return refdatecredit;
	}
	public void setRefdatecredit(String refdatecredit) {
		this.refdatecredit = refdatecredit;
	}
	public String getAmountdebit() {
		return amountdebit;
	}
	public void setAmountdebit(String amountdebit) {
		this.amountdebit = amountdebit;
	}
	public String getAmountcredit() {
		return amountcredit;
	}
	public void setAmountcredit(String amountcredit) {
		this.amountcredit = amountcredit;
	}
	public String getDrcr() {
		return drcr;
	}
	public void setDrcr(String drcr) {
		this.drcr = drcr;
	}
	public String getGetsession() {
		return getsession;
	}
	public void setGetsession(String getsession) {
		this.getsession = getsession;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCashrcvd() {
		return cashrcvd;
	}
	public void setCashrcvd(String cashrcvd) {
		this.cashrcvd = cashrcvd;
	}
	public String getCashpaid() {
		return cashpaid;
	}
	public void setCashpaid(String cashpaid) {
		this.cashpaid = cashpaid;
	}
	public String getAccname() {
		return accname;
	}
	public void setAccname(String accname) {
		this.accname = accname;
	}
	public String getVno() {
		return vno;
	}
	public void setVno(String vno) {
		this.vno = vno;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public String getOpeningbal() {
		return openingbal;
	}
	public void setOpeningbal(String openingbal) {
		this.openingbal = openingbal;
	}
	public String getGrouphead() {
		return grouphead;
	}
	public void setGrouphead(String grouphead) {
		this.grouphead = grouphead;
	}
	public String[] getDorchidden() {
		return dorchidden;
	}

	public void setDorchidden(String[] dorchidden) {
		this.dorchidden = dorchidden;
	}

	public String[] getDebithidden() {
		return debithidden;
	}

	public void setDebithidden(String[] debithidden) {
		this.debithidden = debithidden;
	}

	public String getTotal1() {
		return total1;
	}

	public void setTotal1(String total1) {
		this.total1 = total1;
	}

	public String[] getDorc() {
		return dorc;
	}

	public void setDorc(String[] dorc) {
		this.dorc = dorc;
	}

	public String getLed() {
		return led;
	}

	public void setLed(String led) {
		this.led = led;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public String getRefdate() {
		return refdate;
	}

	public void setRefdate(String refdate) {
		this.refdate = refdate;
	}

	public String[] getDoref() {
		return doref;
	}

	public void setDoref(String[] doref) {
		this.doref = doref;
	}

	public String[] getDat() {
		return dat;
	}

	public void setDat(String[] dat) {
		this.dat = dat;
	}

	public String[] getBillamount() {
		return billamount;
	}

	public void setBillamount(String[] billamount) {
		this.billamount = billamount;
	}

	public String[] getAdjusted() {
		return adjusted;
	}

	public void setAdjusted(String[] adjusted) {
		this.adjusted = adjusted;
	}

	public String[] getDues() {
		return dues;
	}

	public void setDues(String[] dues) {
		this.dues = dues;
	}

	public String getForac() {
		return forac;
	}

	public void setForac(String forac) {
		this.forac = forac;
	}

	public String getDated() {
		return dated;
	}

	public void setDated(String dated) {
		this.dated = dated;
	}

	public String getAmount_debited() {
		return amount_debited;
	}

	public void setAmount_debited(String amount_debited) {
		this.amount_debited = amount_debited;
	}

	public String getAmount_credited() {
		return amount_credited;
	}

	public void setAmount_credited(String amount_credited) {
		this.amount_credited = amount_credited;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpening_bal() {
		return opening_bal;
	}

	public void setOpening_bal(String opening_bal) {
		this.opening_bal = opening_bal;
	}

	public String getDebitamt() {
		return debitamt;
	}

	public void setDebitamt(String debitamt) {
		this.debitamt = debitamt;
	}

	public String getCreditamt() {
		return creditamt;
	}

	public void setCreditamt(String creditamt) {
		this.creditamt = creditamt;
	}

	public String getClosing_balance() {
		return closing_balance;
	}

	public void setClosing_balance(String closing_balance) {
		this.closing_balance = closing_balance;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAcname() {
		return acname;
	}

	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getNv() {
		return nv;
	}

	public void setNv(String nv) {
		this.nv = nv;
	}

	public String getClosing() {
		return closing;
	}

	public void setClosing(String closing) {
		this.closing = closing;
	}

	public String getMain_grp() {
		return main_grp;
	}

	public void setMain_grp(String main_grp) {
		this.main_grp = main_grp;
	}

	private String phno1,email1,maingroup,prenar,narshow;
	private String part,part1,showdate,contraref,contradate;
	public String getComplaincode() {
		return complaincode;
	}
	
	public String getAsondate() {
		return asondate;
	}

	public void setAsondate(String asondate) {
		this.asondate = asondate;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getOpetotal()//trial list opening balance total
	{ 
	    return opetotal;
	}
	public void setOpetotal(String opetotal) 
	{
	    this.opetotal=opetotal;
	}
	
	public String getDebittotal()//trial list debit balance total
	{ 
	    return debittotal;
	}
	public void setDebittotal(String debittotal) 
	{
	    this.debittotal=debittotal;
	}
	
	public String getCredittotal()//trial list credit balance total
	{ 
	    return credittotal;
	}
	public void setCredittotal(String credittotal) 
	{
	    this.credittotal=credittotal;
	}
	
	public String getLedger()//trial list ledger
	{ 
	    return ledger;
	}
	public void setLedger(String ledger) 
	{
	    this.ledger=ledger;
	}
	public String getGroup()//trial list main group
	{ 
	    return group;
	}
	public void setGroup(String group) 
	{
	    this.group=group;
	}
	public String getDebitam()//trial list debit
	{ 
	    return debitam;
	}
	public void setDebitam(String debitam) 
	{
	    this.debitam=debitam;
	}
	public String getCreditam()//trial list credit
	{ 
	    return creditam;
	}
	public void setCreditam(String creditam) 
	{
	    this.creditam=creditam;
	}
	//for ledger popup on edit
	public String[] getVtypehidden()//ledger popup voucher hidden
	{ 
	    return vtypehidden;
	}
	public void setVtypehidden(String[] vtypehidden) 
	{
	    this.vtypehidden=vtypehidden;
	}
	public String[] getPartihidden()//ledger popup particular hidden
	{ 
	    return partihidden;
	}
	public void setPartihidden(String[] partihidden) 
	{
	    this.partihidden=partihidden;
	}
	public String[] getDthidden()//ledger popup date hidden
	{ 
	    return dthidden;
	}
	public void setDthidden(String[] dthidden) 
	{
	    this.dthidden=dthidden;
	}
	public String[] getGrosshidden()//ledger popup gross hidden
	{ 
	    return grosshidden;
	}
	public void setGrosshidden(String[] grosshidden) 
	{
	    this.grosshidden=grosshidden;
	}
	public String[] getPrehidden()//ledger popup preadjustment hidden
	{ 
	    return prehidden;
	}
	public void setPrehidden(String[] prehidden) 
	{
	    this.prehidden=prehidden;
	}
	public String[] getDuehidden()//ledger popup due hidden
	{ 
	    return duehidden; 
	}
	public void setDuehidden(String[] duehidden) 
	{
	    this.duehidden=duehidden;
	}
	//popup on edit ends
	//for ledger popup
	public String getDc()//debit credit
	{
		return dc;
	}
	public void setDc(String dc)
	{
		this.dc=dc;
	}
	public String[] getVtype()//ledger popup voucher type
	{ 
	    return vtype;
	}
	public void setVtype(String[] vtype) 
	{
	    this.vtype=vtype;
	}
	public String[] getParti()//ledger popup particular
	{ 
	    return parti;
	}
	public void setParti(String[] parti) 
	{
	    this.parti=parti;
	}
	public String[] getDt()//ledger popup date
	{ 
	    return dt;
	}
	public void setDt(String[] dt) 
	{
	    this.dt=dt;
	}
	public String[] getGross()//ledger popup gross
	{ 
	    return gross;
	}
	public void setGross(String[] gross) 
	{
	    this.gross=gross;
	}
	public String[] getPre()//ledger popup pre
	{ 
	    return pre;
	}
	public void setPre(String[] pre) 
	{
	    this.pre=pre;
	}
	public String[] getDue()//ledger popup due
	{ 
	    return due;
	}
	public void setDue(String[] due) 
	{
	    this.due=due;
	}
	//ledger popup ends 
	//contra starts
	public String getVoucher()//bottom listing voucher 
	{ 
	    return voucher;
	}
	public void setVoucher(String voucher) 
	{
	    this.voucher=voucher;
	}
	public String[] getContra1()//contra particular array hidden field 
	{ 
	    return contra1;
	}
	public void setContra1(String[] contra1) 
	{
	    this.contra1=contra1;
	}
	public String[] getNarration1()//contra short narration1 hidden field
	{ 
	    return narration1;
	}
	public void setNarration1(String[] narration1) 
	{
	    this.narration1=narration1;
	}
	public String[] getCredithidden()//contra credit array hidden field
	{ 
	    return credithidden;
	}
	public void setCredithidden(String[] credithidden) 
	{
	    this.credithidden=credithidden;
	}
	
	public String getPrenar()//contra ref date 
	{ 
	    return prenar;
	}
	public void setPrenar(String prenar) 
	{
	    this.prenar=prenar;
	}
	public int getContsr()//contra sr. no. for top
	{ 
	    return contsr;
	}
	public void setContsr(int contsr) 
	{
	    this.contsr=contsr;
	}
	public String getContradate()//contra ref date 
	{ 
	    return contradate;
	}
	public void setContradate(String contradate) 
	{
	    this.contradate=contradate;
	}
	public String getContraref()//contra reference 
	{ 
	    return contraref;
	}
	public void setContraref(String contraref) 
	{
	    this.contraref=contraref;
	}
	public String getShowdate()//contra date 
	{ 
	    return showdate;
	}
	public void setShowdate(String showdate) 
	{
	    this.showdate=showdate;
	}
	public String[] getCredit()//contra credit array 
	{ 
	    return credit;
	}
	public void setCredit(String[] credit) 
	{
	    this.credit=credit;
	}
	public String[] getNarration()//contra short narration array 
	{ 
	    return narration;
	}
	public void setNarration(String[] narration) 
	{
	    this.narration=narration;
	}
	public String[] getPartforcontra()//contra particular array array 
	{ 
	    return partforcontra;
	}
	public void setPartforcontra(String[] partforcontra) 
	{
	    this.partforcontra=partforcontra;
	}
	//contra ends
	//payment starts
	public void setPart1(String part1)//payment on a/c ledger
	{
		this.part1=part1;
	}
	public String getPart1()
	{
		return part1;
	}
	public void setPart(String part)//payment particulars
	{
		this.part=part;
	}
	public String getPart()
	{
		return part;
	}
	public String[] getDebit()//payment debit array 
	{ 
	    return debit;
	}
	public void setDebit(String[] debit) 
	{
	    this.debit=debit;
	}
	//payment ends
	//ledger
	public void setPhno1(String phno1)//ledger alternate ph no
	{
		this.phno1=phno1;
	}
	public String getPhno1()
	{
		return phno1;
	}
	public void setEmail1(String email1)//ledger alternate email
	{
		this.email1=email1;
	}
	public String getEmail1()
	{
		return email1;
	}
	public void setPhno(String phno)//ledger ph no
	{
		this.phno=phno;
	}
	public String getPhno()
	{
		return phno;
	}
	public void setContname(String contname)//ledger contact name
	{
		this.contname=contname;
	}
	public String getContname()
	{
		return contname;
	}
	public void setVat(String vat)//ledger vat no
	{
		this.vat=vat;
	}
	public String getVat()
	{
		return vat;
	}
	public void setPan1(String pan1)//ledger pan no
	{
		this.pan1=pan1;
	}
	public String getPan1()
	{
		return pan1;
	}
	public void setMailto(String mailto)//ledger mail to
	{
		this.mailto=mailto;
	}
	public String getMailto()
	{
		return mailto;
	}
	public void setCost(String cost)//ledger cost center
	{
		this.cost=cost;
	}
	public String getCost()
	{
		return cost;
	}
	public void setAlias(String alias)//ledger alias name
	{
		this.alias=alias;
	}
	public String getAlias()
	{
		return alias;
	}
	public void setSubgroup(String sub_grp)//ledger sub group name
	{
		this.sub_grp=sub_grp;
	}
	public String getSubgroup()
	{
		return sub_grp;
	}
	public void setMaingroup(String maingroup)//ledger main group name
	{
		this.maingroup=maingroup;
	}
	public String getMaingroup()
	{
		return maingroup;
	}
	public void setOpebal(String opebal)//ledger opening bal
	{
		this.opebal=opebal;
	}
	public String getOpebal()
	{
		return opebal;
	}
	public void setPrebal(String prebal)//ledger previous bal
	{
		this.prebal=prebal;
	}
	public String getPrebal()
	{
		return prebal;
	}
	public void setDefault(String default1)//ledger default
	{
		this.default1=default1;
	}
	public String getDefault()
	{
		return default1;
	}
	public void setMaintainbal(String maintainbal)//ledger maintainbal
	{
		this.maintainbal=maintainbal;
	}
	public String getMaintainbal()
	{
		return maintainbal;
	}
	public void setInventoryval(String inventoryval)//ledger inventory value
	{
		this.inventoryval=inventoryval;
	}
	public String getInventoryval()
	{
		return inventoryval;
	}
	public void setOpedc(String opedc)//ledger debit credit
	{
		this.opedc=opedc;
	}
	public String getOpedc()
	{
		return opedc;
	}
	//ledger ends
	//narration
	public void setTitle(String title)//narration name
	{
		this.title=title;
	}
	public String getTitle()
	{
		return title;
	}
	public void setDesc1(String desc1)//narration description
	{
		this.desc1=desc1;
	}
	public String getDesc1()
	{
		return desc1;
	}
	//narration ends
	public void setMgrpname(String mgrpname)//classification
	{
		this.mgrpname=mgrpname;
	}
	
	public String getMgrpname()
	{
		return mgrpname;
	}
	//for group master
	public void setGname(String gname)//classification
	{
		this.gname=gname;
	}
	
	public String getGname()
	{
		return gname;
	}
	public void setClassy(String classy)//classification
	{
		this.classy=classy;
	}
	
	public String getClassy()
	{
		return classy;
	}
	
	public void setcat(String cat)//catagory
	{
		this.cat=cat;
	}
	public String getcat()
	{
		return cat;
	}
	
	public void setPtext(String ptext)//printing text
	{
		this.ptext=ptext;
	}
	public String getPtext()
	{
		return ptext;
	}
	
	public void setSchname(int schname)//schedule name
	{
		this.schname=schname;
	}
	public int getSchname()
	{
		return schname;
	}
	
	public void setDetailreq(String detailreq)//detail required
	{
		this.detailreq=detailreq;
	}
	public String getDetailreq()
	{
		return detailreq;
	}
	
	public void setCatforinex(String catforinex)//detail required
	{
		this.catforinex=catforinex;
	}
	public String getCatforinex()
	{
		return catforinex;
	}
	//group master ends here
	//subgroup data
	public void setSubgroupdes(String subgroupdes)
	{
		this.subgroupdes=subgroupdes;
	}
	public String getSubgroupdes()
	{
		return subgroupdes;
	}
	
	public void setMgrpname1(String mgrpname1)//classification
	{
		this.mgrpname1=mgrpname1;
	}
	
	public String getMgrpname1()
	{
		return mgrpname1;
	}
	//subgroup ends
	public void setComplaincode(String complaincode) {
		this.complaincode = complaincode;
	}
	
	public String getComplainname() {
		return complainname;
	}
	
	public void setComplainname(String complainname) {
		this.complainname = complainname;
	}
	
	public String getIcharge() {
		return icharge;
	}
	
	public void setIcharge(String icharge) {
		this.icharge = icharge;
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
	
	public String[] getQuantity() {
		 
	    return quantity;
	}
	 
	public void setQuantity(String[] quantity) {
	 
	    this.quantity=quantity;
	 
	}
	
	public String[] getAmount1() {
		 
	    return amount1;
	}
	 
	public void setAmount1(String[] amount1) {
	 
	    this.amount1=amount1;
	 
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	
	public String getExpencedetails() {
		return expencedetails;
	}

	public void setExpencedetails(String expencedetails) {
		this.expencedetails = expencedetails;
	}
	
	public String getSparedetails() {
		return sparedetails;
	}

	public void setSparedetails(String sparedetails) {
		this.sparedetails = sparedetails;
	}
	
	public String getEngstatus() {
		return engstatus;
	}

	public void setEngstatus(String engstatus) {
		this.engstatus = engstatus;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	public String getPon() {
		return pon;
	}

	public void setPon(String pon) {
		this.pon = pon;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	public String getRmobile() {
		return rmobile;
	}

	public void setRmobile(String rmobile) {
		this.rmobile = rmobile;
	}
	public String getPmobile() {
		return pmobile;
	}

	public void setPmobile(String pmobile) {
		this.pmobile = pmobile;
	}
	
	public String getEduqli() {
		return eduqli;
	}

	public void setEduqli(String eduqli) {
		this.eduqli = eduqli;
	}
	public String getTecqli() {
		return tecqli;
	}

	public void setTecqli(String tecqli) {
		this.tecqli = tecqli;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCperson() {
		return cperson;
	}

	public void setCperson(String cperson) {
		this.cperson = cperson;
	}
	
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}


	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}
	
	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
		
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}
	
	public String getDoa() {
		return doa;
	}

	public void setDoa(String doa) {
		this.doa = doa;
	}
	
	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}
	
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}
	
	public String getGradepay() {
		return gradepay;
	}

	public void setGradepay(String gradepay) {
		this.gradepay = gradepay;
	}
	
	public String getComcertificate() {
		return comcertificate;
	}

	public void setComcertificate(String comcertificate) {
		this.comcertificate = comcertificate;
	}
	
	public String getEducertificate() {
		return educertificate;
	}

	public void setEducertificate(String educertificate) {
		this.educertificate= educertificate;
	}
	
	public String getMatcertificate() {
		return matcertificate;
	}

	public void setMatcertificate(String matcertificate) {
		this.matcertificate= matcertificate;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place= place;
	}
	
	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate= cdate;
	}
	
	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate= pdate;
	}
	
	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate= edate;
	}
	
	public String[] getAcademic() {
		 
	    return academic;
	}
	 
	public void setAcademic(String[] academic) {
	 
	    this.academic=academic;
	 
	}
	
	public String[] getBoard() {
		 
	    return board;
	}
	 
	public void setBoard(String[] board) {
	 
	    this.board=board;
	 
	}
	
	public String[] getPassingyear() {
		 
	    return passingyear;
	}
	 
	public void setPassingyear(String[] passingyear) {
	 
	    this.passingyear=passingyear;
	 
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
    
    public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	
	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	
	public String getPserial() {
		return pserial;
	}

	public void setPserial(String pserial) {
		this.pserial = pserial;
	}
	
	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
	public String getCptype() {
		return cptype;
	}

	public void setCptype(String cptype) {
		this.cptype = cptype;
	}
	
	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getPremarks() {
		return premarks;
	}

	public void setPremarks(String premarks) {
		this.premarks = premarks;
	}
	
	public String getCremarks() {
		return cremarks;
	}

	public void setCremarks(String cremarks) {
		this.cremarks = cremarks;
	}
	public String getSremarks() {
		return sremarks;
	}

	public void setSremarks(String sremarks) {
		this.sremarks = sremarks;
	}
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public String getModelcode() {
		return modelcode;
	}

	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}
	
	public String getBrandcode() {
		return brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}
	
	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	
	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	public String getAllocation() {
		return allocation;
	}

	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}
	
	public String getEngname() {
		return engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}
	
	public String getSpare() {
		return spare;
	}

	public void setSpare(String spare) {
		this.spare = spare;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
}