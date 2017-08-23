package com.bean.inventory;

import java.io.File;

/**
 * @author Avijit
 *
 */
public class FormBean 
{
	
	
	
	
	private String partycode,partyname,mainledger,openingbalance,drcr1,prevyrbalance,drcr2,dclimit,gress,anyother,intrate,discreate,tdr,location,address1,contactperson,call,incometaxpa,areaname,clas,typeofparty;
	private String country,phonenumber,faxno,country1,city1,phonenumber1,faxno1,country2,city2,phonenumber2,faxno2,to1;
	private String claimcode,claimdesc,materialgroup,type1;
	
	
	private String accid,catagory,sname,name,fname,address,address2,add,contact,email,mobile,gender,community,dob,pf,doa,deg,post,department,workshop,gradepay,comcertificate,educertificate,matcertificate,place,cdate,edate;
	private Integer id;
	private String[] academic,hpname,haqtyd,hfqtyd,hunitd,hamountd;
	private String[] board,tr;
	

	private String[] passingyear;
	private String userid,username,userpass,password,roll,userstatus,pon,cperson,city,district,pcode,state,scode,remarks,doj,rmobile,eduqli,tecqli,pmobile;
	private File userImage;
	private String userImageContentType,billno,billdate;
	private String userImageFileName,vtype1;
	private String ctype,ccode,mcode,pserial,ptype,comcode,cptype,premarks,cremarks,sremarks,pdate,bname;
	private String modelcode,modelname,brandname,productname,companyname,brandcode,allocation,engname,spare,user,distance,amount;
	private String engstatus,sparedetails,expencedetails,total,total1;
	private String[] quantity,tytax,todiscount,gstper,total11,total111,todiscount1,tytax1,gstper1;
	private String vouno,cp,cre,invoiceno,invoicevaluers,lessamt,billamt,creditors,Purcode;
	private String[] ammount5,ratep5,ratec5,free5,pack5,noi5,pack,case3,free,ratec,ratep,ammount,gstp,tax1;
	
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
	private String[] due,packingar,minqty,extra,offeredmin;
	private String[] vtypehidden;
	private String[] partihidden;
	private String[] dthidden;
	private String[] grosshidden;
	private String[] prehidden;
	private String[] duehidden,pname,aqtyd,fqtyd,unitd,amountd;
	private String[] doref,batchno,expdate,aqty,fqty,purate,strate,rtrate,mrp,amounta;
	private String[] batchnohidden,expdatehidden,aqtyhidden,fqtyhidden,puratehidden,stratehidden,rtratehidden,mrphidden,amountahidden;
	private String[] dat,billamount,adjusted,dues,dorc,dorchidden,debithidden;
	private String partdebit,partcredit,refnodebit,refnocredit,refdatedebit,refdatecredit,amountdebit,amountcredit,vtyp,choice,achead,groupcat;
	private String frmdate,todate,icharge,complaincode,complainname,count,getsession,drcr,uptodate,case1,entry,chedd,chedddate,clearedon;
	private String income,groupname,subgroups,srno,shortn,longn,subs,maxd,maxc,company,finyear;
	private String date1,particulars,grossamt,amtadjusted,amtbalance,age,v,singlenarration;
	private String shortname,salesman,serial,smcode,category,from,to,period,salecode;
	private String gname,classy,cat,catforinex,ptext,detailreq,voucher,refno,refdate,type,led,grouphead,openingbal,particular,cashrcvd,cashpaid,accname,vno;
	private int schname,contsr;
	private String subgroupdes,mgrpname,mgrpname1,opetotal,debittotal,credittotal,acname,month,date,dated,amount_debited,amount_credited,forac;
	private String title,desc1,dc,ledger,group,debitam,creditam,asondate,months,nv,closing,opening_bal,debitamt,creditamt,closing_balance,sl,pur;
	private String alias,sub_grp,main_grp,opebal,prebal,default1,maintainbal,inventoryval,opedc,cost,mailto,pan1,vat,contname,phno,material,discp,taxc,roundofft,subtotal1;
	private String headq,debitac,materialg,onac,materiald,packing,unit,sta,stf,reprate,disc,mfgcode,creditac,transporter,company_code,totalamount,truckrr,tax,oamount,addamount,lessamount,roundoff,subtotal,netamount,taxselect,challanno,cname,desc,materialname,mtype,size,sunit,scheme,hsn,unitofitem,mininvlevel,valueaddeditem,typeoftax,agriculturetax,surchar,valueofstock,purchasename,saleac,valueaddtax,companycode,salesac1,company_code1,valueaddedtax,purchase1,materialgroup1,cmpcode;
	
	private String[] pcase,pcs,mrp1,scase,spcs,stotal,rtcase,vrtcase,rtpcs,vrtpcs,dist,price,pcase1,pcs1,mrp11,scase1,spcs1,stotal1,rtcase1,vrtcase1,rtpcs1,vrtpcs1,dist1,price1;
	private String nameofarea,salesmanname,retailername,memono,totalamt,discount,gamount,discount1,sgst,cgst,igst,totalamtrs,gstamount,netammount,memo,casee,pcss,rte,nameofarea1,salesmanname1,arcode1,tcase,tpcs,tamount,gstinno,panno,statecode,sttype,Ins,Pcase9,Pcs9,Mrp19,Scase9,Spcs9,Stotal9,Rtcase9,Vrtcase9,Rtpcs9,Vrtpcs9,Dist9,Price9,tooamount,toogst;
	private String[] nameofitems,case4,pcs4,fp,mrp4,rate,discs,dis,amount4,nameofitems1,case5,pcs5,fp1,mrp5,rate4,discs4,dis4,amount5,onamount1,sgst1,cgst1,igst1,asgst1,acgst1,aigst1,gamount1;
	
	
	
	public String getTooamount() {
		return tooamount;
	}
	public void setTooamount(String tooamount) {
		this.tooamount = tooamount;
	}
	public String getToogst() {
		return toogst;
	}
	public void setToogst(String toogst) {
		this.toogst = toogst;
	}
	public String[] getOnamount1() {
		return onamount1;
	}
	public void setOnamount1(String[] onamount1) {
		this.onamount1 = onamount1;
	}
	public String[] getSgst1() {
		return sgst1;
	}
	public void setSgst1(String[] sgst1) {
		this.sgst1 = sgst1;
	}
	public String[] getCgst1() {
		return cgst1;
	}
	public void setCgst1(String[] cgst1) {
		this.cgst1 = cgst1;
	}
	public String[] getIgst1() {
		return igst1;
	}
	public void setIgst1(String[] igst1) {
		this.igst1 = igst1;
	}
	public String[] getAsgst1() {
		return asgst1;
	}
	public void setAsgst1(String[] asgst1) {
		this.asgst1 = asgst1;
	}
	public String[] getAcgst1() {
		return acgst1;
	}
	public void setAcgst1(String[] acgst1) {
		this.acgst1 = acgst1;
	}
	public String[] getAigst1() {
		return aigst1;
	}
	public void setAigst1(String[] aigst1) {
		this.aigst1 = aigst1;
	}
	public String[] getGamount1() {
		return gamount1;
	}
	public void setGamount1(String[] gamount1) {
		this.gamount1 = gamount1;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public String getSalecode() {
		return salecode;
	}
	public void setSalecode(String salecode) {
		this.salecode = salecode;
	}
	public String[] getTr() {
		return tr;
	}
	
	
	
	public void setTr(String[] tr) {
		this.tr = tr;
	}
	
	
	public String getIns() {
		return Ins;
	}
	public void setIns(String ins) {
		Ins = ins;
	}
	public String getPcase9() {
		return Pcase9;
	}
	public void setPcase9(String pcase9) {
		Pcase9 = pcase9;
	}
	public String getPcs9() {
		return Pcs9;
	}
	public void setPcs9(String pcs9) {
		Pcs9 = pcs9;
	}
	public String getMrp19() {
		return Mrp19;
	}
	public void setMrp19(String mrp19) {
		Mrp19 = mrp19;
	}
	public String getScase9() {
		return Scase9;
	}
	public void setScase9(String scase9) {
		Scase9 = scase9;
	}
	public String getSpcs9() {
		return Spcs9;
	}
	public void setSpcs9(String spcs9) {
		Spcs9 = spcs9;
	}
	public String getStotal9() {
		return Stotal9;
	}
	public void setStotal9(String stotal9) {
		Stotal9 = stotal9;
	}
	public String getRtcase9() {
		return Rtcase9;
	}
	public void setRtcase9(String rtcase9) {
		Rtcase9 = rtcase9;
	}
	public String getVrtcase9() {
		return Vrtcase9;
	}
	public void setVrtcase9(String vrtcase9) {
		Vrtcase9 = vrtcase9;
	}
	public String getRtpcs9() {
		return Rtpcs9;
	}
	public void setRtpcs9(String rtpcs9) {
		Rtpcs9 = rtpcs9;
	}
	public String getVrtpcs9() {
		return Vrtpcs9;
	}
	public void setVrtpcs9(String vrtpcs9) {
		Vrtpcs9 = vrtpcs9;
	}
	public String getDist9() {
		return Dist9;
	}
	public void setDist9(String dist9) {
		Dist9 = dist9;
	}
	public String getPrice9() {
		return Price9;
	}
	public void setPrice9(String price9) {
		Price9 = price9;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getPur() {
		return pur;
	}
	public void setPur(String pur) {
		this.pur = pur;
	}
	public String getPurcode() {
		return Purcode;
	}
	public void setPurcode(String purcode) {
		Purcode = purcode;
	}
	public String[] getPack() {
		return pack;
	}
	public void setPack(String[] pack) {
		this.pack = pack;
	}
	public String[] getCase3() {
		return case3;
	}
	public void setCase3(String[] case3) {
		this.case3 = case3;
	}
	public String[] getFree() {
		return free;
	}
	public void setFree(String[] free) {
		this.free = free;
	}
	public String[] getRatec() {
		return ratec;
	}
	public void setRatec(String[] ratec) {
		this.ratec = ratec;
	}
	public String[] getRatep() {
		return ratep;
	}
	public void setRatep(String[] ratep) {
		this.ratep = ratep;
	}
	public String[] getAmmount() {
		return ammount;
	}
	public void setAmmount(String[] ammount) {
		this.ammount = ammount;
	}
	public String[] getGstp() {
		return gstp;
	}
	public void setGstp(String[] gstp) {
		this.gstp = gstp;
	}
	public String[] getTax1() {
		return tax1;
	}
	public void setTax1(String[] tax1) {
		this.tax1 = tax1;
	}
	public String[] getAmmount5() {
		return ammount5;
	}
	public void setAmmount5(String[] ammount5) {
		this.ammount5 = ammount5;
	}
	public String[] getRatep5() {
		return ratep5;
	}
	public void setRatep5(String[] ratep5) {
		this.ratep5 = ratep5;
	}
	public String[] getRatec5() {
		return ratec5;
	}
	public void setRatec5(String[] ratec5) {
		this.ratec5 = ratec5;
	}
	public String[] getFree5() {
		return free5;
	}
	public void setFree5(String[] free5) {
		this.free5 = free5;
	}
	public String[] getPack5() {
		return pack5;
	}
	public void setPack5(String[] pack5) {
		this.pack5 = pack5;
	}
	public String[] getNoi5() {
		return noi5;
	}
	public void setNoi5(String[] noi5) {
		this.noi5 = noi5;
	}
	public String getVouno() {
		return vouno;
	}
	public void setVouno(String vouno) {
		this.vouno = vouno;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCre() {
		return cre;
	}
	public void setCre(String cre) {
		this.cre = cre;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public String getInvoicevaluers() {
		return invoicevaluers;
	}
	public void setInvoicevaluers(String invoicevaluers) {
		this.invoicevaluers = invoicevaluers;
	}
	public String getLessamt() {
		return lessamt;
	}
	public void setLessamt(String lessamt) {
		this.lessamt = lessamt;
	}
	public String getBillamt() {
		return billamt;
	}
	public void setBillamt(String billamt) {
		this.billamt = billamt;
	}
	public String getCreditors() {
		return creditors;
	}
	public void setCreditors(String creditors) {
		this.creditors = creditors;
	}
	public String[] getTotal111() {
		return total111;
	}
	public void setTotal111(String[] total111) {
		this.total111 = total111;
	}
	public String[] getTodiscount1() {
		return todiscount1;
	}
	public void setTodiscount1(String[] todiscount1) {
		this.todiscount1 = todiscount1;
	}
	public String[] getTytax1() {
		return tytax1;
	}
	public void setTytax1(String[] tytax1) {
		this.tytax1 = tytax1;
	}
	public String[] getGstper1() {
		return gstper1;
	}
	public void setGstper1(String[] gstper1) {
		this.gstper1 = gstper1;
	}
	public String[] getTotal11() {
		return total11;
	}
	public void setTotal11(String[] total11) {
		this.total11 = total11;
	}
	public String[] getTodiscount() {
		return todiscount;
	}
	public void setTodiscount(String[] todiscount) {
		this.todiscount = todiscount;
	}
	public String[] getGstper() {
		return gstper;
	}
	public void setGstper(String[] gstper) {
		this.gstper = gstper;
	}
	public String[] getTytax() {
		return tytax;
	}
	public void setTytax(String[] tytax) {
		this.tytax = tytax;
	}

	
	public String getGstinno() {
		return gstinno;
	}
	public void setGstinno(String gstinno) {
		this.gstinno = gstinno;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public String getSttype() {
		return sttype;
	}
	public void setSttype(String sttype) {
		this.sttype = sttype;
	}
	public String getTcase() {
		return tcase;
	}
	public void setTcase(String tcase) {
		this.tcase = tcase;
	}
	public String getTpcs() {
		return tpcs;
	}
	public void setTpcs(String tpcs) {
		this.tpcs = tpcs;
	}
	public String getTamount() {
		return tamount;
	}
	public void setTamount(String tamount) {
		this.tamount = tamount;
	}
	public String getArcode1() {
		return arcode1;
	}
	public void setArcode1(String arcode1) {
		this.arcode1 = arcode1;
	}
	public String getSalesmanname1() {
		return salesmanname1;
	}
	public void setSalesmanname1(String salesmanname1) {
		this.salesmanname1 = salesmanname1;
	}

	
	
	
	
	public String getNameofarea1() {
		return nameofarea1;
	}
	public void setNameofarea1(String nameofarea1) {
		this.nameofarea1 = nameofarea1;
	}

	public String getRte() {
		return rte;
	}
	public void setRte(String rte) {
		this.rte = rte;
	}
	public String getNameofarea() {
		return nameofarea;
	}
	public void setNameofarea(String nameofarea) {
		this.nameofarea = nameofarea;
	}
	public String getSalesmanname() {
		return salesmanname;
	}
	public void setSalesmanname(String salesmanname) {
		this.salesmanname = salesmanname;
	}
	public String getRetailername() {
		return retailername;
	}
	public void setRetailername(String retailername) {
		this.retailername = retailername;
	}
	public String getMemono() {
		return memono;
	}
	public void setMemono(String memono) {
		this.memono = memono;
	}
	public String getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(String totalamt) {
		this.totalamt = totalamt;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getGamount() {
		return gamount;
	}
	public void setGamount(String gamount) {
		this.gamount = gamount;
	}
	public String getDiscount1() {
		return discount1;
	}
	public void setDiscount1(String discount1) {
		this.discount1 = discount1;
	}
	public String getSgst() {
		return sgst;
	}
	public void setSgst(String sgst) {
		this.sgst = sgst;
	}
	public String getCgst() {
		return cgst;
	}
	public void setCgst(String cgst) {
		this.cgst = cgst;
	}
	public String getIgst() {
		return igst;
	}
	public void setIgst(String igst) {
		this.igst = igst;
	}
	public String getTotalamtrs() {
		return totalamtrs;
	}
	public void setTotalamtrs(String totalamtrs) {
		this.totalamtrs = totalamtrs;
	}
	public String getGstamount() {
		return gstamount;
	}
	public void setGstamount(String gstamount) {
		this.gstamount = gstamount;
	}
	public String getNetammount() {
		return netammount;
	}
	public void setNetammount(String netammount) {
		this.netammount = netammount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCasee() {
		return casee;
	}
	public void setCasee(String casee) {
		this.casee = casee;
	}
	public String getPcss() {
		return pcss;
	}
	public void setPcss(String pcss) {
		this.pcss = pcss;
	}
	public String[] getNameofitems() {
		return nameofitems;
	}
	public void setNameofitems(String[] nameofitems) {
		this.nameofitems = nameofitems;
	}
	public String[] getCase4() {
		return case4;
	}
	public void setCase4(String[] case4) {
		this.case4 = case4;
	}
	public String[] getPcs4() {
		return pcs4;
	}
	public void setPcs4(String[] pcs4) {
		this.pcs4 = pcs4;
	}
	public String[] getFp() {
		return fp;
	}
	public void setFp(String[] fp) {
		this.fp = fp;
	}
	public String[] getMrp4() {
		return mrp4;
	}
	public void setMrp4(String[] mrp4) {
		this.mrp4 = mrp4;
	}
	public String[] getRate() {
		return rate;
	}
	public void setRate(String[] rate) {
		this.rate = rate;
	}
	public String[] getDiscs() {
		return discs;
	}
	public void setDiscs(String[] discs) {
		this.discs = discs;
	}
	public String[] getDis() {
		return dis;
	}
	public void setDis(String[] dis) {
		this.dis = dis;
	}
	public String[] getAmount4() {
		return amount4;
	}
	public void setAmount4(String[] amount4) {
		this.amount4 = amount4;
	}
	public String[] getNameofitems1() {
		return nameofitems1;
	}
	public void setNameofitems1(String[] nameofitems1) {
		this.nameofitems1 = nameofitems1;
	}
	public String[] getCase5() {
		return case5;
	}
	public void setCase5(String[] case5) {
		this.case5 = case5;
	}
	public String[] getPcs5() {
		return pcs5;
	}
	public void setPcs5(String[] pcs5) {
		this.pcs5 = pcs5;
	}
	public String[] getFp1() {
		return fp1;
	}
	public void setFp1(String[] fp1) {
		this.fp1 = fp1;
	}
	public String[] getMrp5() {
		return mrp5;
	}
	public void setMrp5(String[] mrp5) {
		this.mrp5 = mrp5;
	}
	public String[] getRate4() {
		return rate4;
	}
	public void setRate4(String[] rate4) {
		this.rate4 = rate4;
	}
	public String[] getDiscs4() {
		return discs4;
	}
	public void setDiscs4(String[] discs4) {
		this.discs4 = discs4;
	}
	public String[] getDis4() {
		return dis4;
	}
	public void setDis4(String[] dis4) {
		this.dis4 = dis4;
	}
	public String[] getAmount5() {
		return amount5;
	}
	public void setAmount5(String[] amount5) {
		this.amount5 = amount5;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	//private String[] pcase,pcs,mrp1,scase,spcs,stotal,rtcase,vrtcase,rtpcs,vrtpcs,dist,price,pcase1,pcs1,mrp11,scase1,spcs1,stotal1,rtcase1,vrtcase1,rtpcs1,vrtpcs1,dist1,price1;
	
	
	public String[] getPcase1() {
		return pcase1;
	}
	public String getCmpcode() {
		return cmpcode;
	}
	public void setCmpcode(String cmpcode) {
		this.cmpcode = cmpcode;
	}
	public void setPcase1(String[] pcase1) {
		this.pcase1 = pcase1;
	}
	public String[] getPcs1() {
		return pcs1;
	}
	public void setPcs1(String[] pcs1) {
		this.pcs1 = pcs1;
	}
	public String[] getMrp11() {
		return mrp11;
	}
	public void setMrp11(String[] mrp11) {
		this.mrp11 = mrp11;
	}
	public String[] getScase1() {
		return scase1;
	}
	public void setScase1(String[] scase1) {
		this.scase1 = scase1;
	}
	public String[] getSpcs1() {
		return spcs1;
	}
	public void setSpcs1(String[] spcs1) {
		this.spcs1 = spcs1;
	}
	public String[] getStotal1() {
		return stotal1;
	}
	public void setStotal1(String[] stotal1) {
		this.stotal1 = stotal1;
	}
	public String[] getRtcase1() {
		return rtcase1;
	}
	public void setRtcase1(String[] rtcase1) {
		this.rtcase1 = rtcase1;
	}
	public String[] getVrtcase1() {
		return vrtcase1;
	}
	public void setVrtcase1(String[] vrtcase1) {
		this.vrtcase1 = vrtcase1;
	}
	public String[] getRtpcs1() {
		return rtpcs1;
	}
	public void setRtpcs1(String[] rtpcs1) {
		this.rtpcs1 = rtpcs1;
	}
	public String[] getVrtpcs1() {
		return vrtpcs1;
	}
	public void setVrtpcs1(String[] vrtpcs1) {
		this.vrtpcs1 = vrtpcs1;
	}
	public String[] getDist1() {
		return dist1;
	}
	public void setDist1(String[] dist1) {
		this.dist1 = dist1;
	}
	public String[] getPrice1() {
		return price1;
	}
	public void setPrice1(String[] price1) {
		this.price1 = price1;
	}

	private String catcode,salcode,placecode,matcode,mmcode,Groupcode;
	
	
	
	
	
	public String getGroupcode() {
		return Groupcode;
	}
	public void setGroupcode(String groupcode) {
		Groupcode = groupcode;
	}
	public String getMmcode() {
		return mmcode;
	}
	public void setMmcode(String mmcode) {
		this.mmcode = mmcode;
	}
	public String getMatcode() {
		return matcode;
	}
	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}
	public String getPlacecode() {
		return placecode;
	}
	public void setPlacecode(String placecode) {
		this.placecode = placecode;
	}
	public String getSalcode() {
		return salcode;
	}
	public void setSalcode(String salcode) {
		this.salcode = salcode;
	}
	public String getCatcode() {
		return catcode;
	}
	public void setCatcode(String catcode) {
		this.catcode = catcode;
	}
	public String getMaterialgroup() {
		return materialgroup;
	}
	public void setMaterialgroup(String materialgroup) {
		this.materialgroup = materialgroup;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMaterialname() {
		return materialname;
	}
	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSunit() {
		return sunit;
	}
	public void setSunit(String sunit) {
		this.sunit = sunit;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getHsn() {
		return hsn;
	}
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}
	public String getUnitofitem() {
		return unitofitem;
	}
	public void setUnitofitem(String unitofitem) {
		this.unitofitem = unitofitem;
	}
	public String getMininvlevel() {
		return mininvlevel;
	}
	public void setMininvlevel(String mininvlevel) {
		this.mininvlevel = mininvlevel;
	}
	public String getValueaddeditem() {
		return valueaddeditem;
	}
	public void setValueaddeditem(String valueaddeditem) {
		this.valueaddeditem = valueaddeditem;
	}
	public String getTypeoftax() {
		return typeoftax;
	}
	public void setTypeoftax(String typeoftax) {
		this.typeoftax = typeoftax;
	}
	public String getAgriculturetax() {
		return agriculturetax;
	}
	public void setAgriculturetax(String agriculturetax) {
		this.agriculturetax = agriculturetax;
	}
	public String getSurchar() {
		return surchar;
	}
	public void setSurchar(String surchar) {
		this.surchar = surchar;
	}
	public String getValueofstock() {
		return valueofstock;
	}
	public void setValueofstock(String valueofstock) {
		this.valueofstock = valueofstock;
	}
	public String getPurchasename() {
		return purchasename;
	}
	public void setPurchasename(String purchasename) {
		this.purchasename = purchasename;
	}
	public String getSaleac() {
		return saleac;
	}
	public void setSaleac(String saleac) {
		this.saleac = saleac;
	}
	public String getValueaddtax() {
		return valueaddtax;
	}
	public void setValueaddtax(String valueaddtax) {
		this.valueaddtax = valueaddtax;
	}
	public String getSalesac1() {
		return salesac1;
	}
	public void setSalesac1(String salesac1) {
		this.salesac1 = salesac1;
	}
	public String getCompany_code1() {
		return company_code1;
	}
	public void setCompany_code1(String company_code1) {
		this.company_code1 = company_code1;
	}
	public String getValueaddedtax() {
		return valueaddedtax;
	}
	public void setValueaddedtax(String valueaddedtax) {
		this.valueaddedtax = valueaddedtax;
	}
	public String getPurchase1() {
		return purchase1;
	}
	public void setPurchase1(String purchase1) {
		this.purchase1 = purchase1;
	}
	public String getMaterialgroup1() {
		return materialgroup1;
	}
	public void setMaterialgroup1(String materialgroup1) {
		this.materialgroup1 = materialgroup1;
	}
	public String[] getPcase() {
		return pcase;
	}
	public void setPcase(String[] pcase) {
		this.pcase = pcase;
	}
	public String[] getPcs() {
		return pcs;
	}
	public void setPcs(String[] pcs) {
		this.pcs = pcs;
	}
	public String[] getMrp1() {
		return mrp1;
	}
	public void setMrp1(String[] mrp1) {
		this.mrp1 = mrp1;
	}
	public String[] getScase() {
		return scase;
	}
	public void setScase(String[] scase) {
		this.scase = scase;
	}
	public String[] getSpcs() {
		return spcs;
	}
	public void setSpcs(String[] spcs) {
		this.spcs = spcs;
	}
	public String[] getStotal() {
		return stotal;
	}
	public void setStotal(String[] stotal) {
		this.stotal = stotal;
	}
	public String[] getRtcase() {
		return rtcase;
	}
	public void setRtcase(String[] rtcase) {
		this.rtcase = rtcase;
	}
	public String[] getVrtcase() {
		return vrtcase;
	}
	public void setVrtcase(String[] vrtcase) {
		this.vrtcase = vrtcase;
	}
	public String[] getRtpcs() {
		return rtpcs;
	}
	public void setRtpcs(String[] rtpcs) {
		this.rtpcs = rtpcs;
	}
	public String[] getVrtpcs() {
		return vrtpcs;
	}
	public void setVrtpcs(String[] vrtpcs) {
		this.vrtpcs = vrtpcs;
	}
	public String[] getDist() {
		return dist;
	}
	public void setDist(String[] dist) {
		this.dist = dist;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String[] price) {
		this.price = price;
	}
	public String getClaimcode() {
		return claimcode;
	}
	public void setClaimcode(String claimcode) {
		this.claimcode = claimcode;
	}
	public String getClaimdesc() {
		return claimdesc;
	}
	public void setClaimdesc(String claimdesc) {
		this.claimdesc = claimdesc;
	}
	public String getTo1() {
		return to1;
	}
	public void setTo1(String to1) {
		this.to1 = to1;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getSub_grp() {
		return sub_grp;
	}
	public void setSub_grp(String sub_grp) {
		this.sub_grp = sub_grp;
	}
	public String getCompanycode() {
		return companycode;
	}
	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFaxno() {
		return faxno;
	}
	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}
	public String getCountry1() {
		return country1;
	}
	public void setCountry1(String country1) {
		this.country1 = country1;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getPhonenumber1() {
		return phonenumber1;
	}
	public void setPhonenumber1(String phonenumber1) {
		this.phonenumber1 = phonenumber1;
	}
	public String getFaxno1() {
		return faxno1;
	}
	public void setFaxno1(String faxno1) {
		this.faxno1 = faxno1;
	}
	public String getCountry2() {
		return country2;
	}
	public void setCountry2(String country2) {
		this.country2 = country2;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getPhonenumber2() {
		return phonenumber2;
	}
	public void setPhonenumber2(String phonenumber2) {
		this.phonenumber2 = phonenumber2;
	}
	public String getFaxno2() {
		return faxno2;
	}
	public void setFaxno2(String faxno2) {
		this.faxno2 = faxno2;
	}
	public String getNarshow() {
		return narshow;
	}
	public void setNarshow(String narshow) {
		this.narshow = narshow;
	}
	public String getIncometaxpa() {
		return incometaxpa;
	}
	public void setIncometaxpa(String incometaxpa) {
		this.incometaxpa = incometaxpa;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getTypeofparty() {
		return typeofparty;
	}
	public void setTypeofparty(String typeofparty) {
		this.typeofparty = typeofparty;
	}
	public String getDefault1() {
		return default1;
	}
	public void setDefault1(String default1) {
		this.default1 = default1;
	}
	public String getPartycode() {
		return partycode;
	}
	public void setPartycode(String partycode) {
		this.partycode = partycode;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getMainledger() {
		return mainledger;
	}
	public void setMainledger(String mainledger) {
		this.mainledger = mainledger;
	}
	public String getOpeningbalance() {
		return openingbalance;
	}
	public void setOpeningbalance(String openingbalance) {
		this.openingbalance = openingbalance;
	}
	public String getDrcr1() {
		return drcr1;
	}
	public void setDrcr1(String drcr1) {
		this.drcr1 = drcr1;
	}
	public String getPrevyrbalance() {
		return prevyrbalance;
	}
	public void setPrevyrbalance(String prevyrbalance) {
		this.prevyrbalance = prevyrbalance;
	}
	public String getDrcr2() {
		return drcr2;
	}
	public void setDrcr2(String drcr2) {
		this.drcr2 = drcr2;
	}
	public String getDclimit() {
		return dclimit;
	}
	public void setDclimit(String dclimit) {
		this.dclimit = dclimit;
	}
	public String getGress() {
		return gress;
	}
	public void setGress(String gress) {
		this.gress = gress;
	}
	public String getAnyother() {
		return anyother;
	}
	public void setAnyother(String anyother) {
		this.anyother = anyother;
	}
	public String getIntrate() {
		return intrate;
	}
	public void setIntrate(String intrate) {
		this.intrate = intrate;
	}
	public String getDiscreate() {
		return discreate;
	}
	public void setDiscreate(String discreate) {
		this.discreate = discreate;
	}
	public String getTdr() {
		return tdr;
	}
	public void setTdr(String tdr) {
		this.tdr = tdr;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String[] getOfferedmin() {
		return offeredmin;
	}
	public void setOfferedmin(String[] offeredmin) {
		this.offeredmin = offeredmin;
	}
	public String[] getMinqty() {
		return minqty;
	}
	public void setMinqty(String[] minqty) {
		this.minqty = minqty;
	}
	public String[] getExtra() {
		return extra;
	}
	public void setExtra(String[] extra) {
		this.extra = extra;
	}
	public String[] getPackingar() {
		return packingar;
	}
	public void setPackingar(String[] packingar) {
		this.packingar = packingar;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSinglenarration() {
		return singlenarration;
	}
	public void setSinglenarration(String singlenarration) {
		this.singlenarration = singlenarration;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public String[] getHpname() {
		return hpname;
	}
	public void setHpname(String[] hpname) {
		this.hpname = hpname;
	}
	public String[] getHaqtyd() {
		return haqtyd;
	}
	public void setHaqtyd(String[] haqtyd) {
		this.haqtyd = haqtyd;
	}
	public String[] getHfqtyd() {
		return hfqtyd;
	}
	public void setHfqtyd(String[] hfqtyd) {
		this.hfqtyd = hfqtyd;
	}
	public String[] getHunitd() {
		return hunitd;
	}
	public void setHunitd(String[] hunitd) {
		this.hunitd = hunitd;
	}
	public String[] getHamountd() {
		return hamountd;
	}
	public void setHamountd(String[] hamountd) {
		this.hamountd = hamountd;
	}
	public String getSubtotal1() {
		return subtotal1;
	}
	public void setSubtotal1(String subtotal1) {
		this.subtotal1 = subtotal1;
	}
	public String getDiscp() {
		return discp;
	}
	public void setDiscp(String discp) {
		this.discp = discp;
	}
	public String getTaxc() {
		return taxc;
	}
	public void setTaxc(String taxc) {
		this.taxc = taxc;
	}
	public String getRoundofft() {
		return roundofft;
	}
	public void setRoundofft(String roundofft) {
		this.roundofft = roundofft;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String[] getPname() {
		return pname;
	}
	public void setPname(String[] pname) {
		this.pname = pname;
	}
	public String[] getAqtyd() {
		return aqtyd;
	}
	public void setAqtyd(String[] aqtyd) {
		this.aqtyd = aqtyd;
	}
	public String[] getFqtyd() {
		return fqtyd;
	}
	public void setFqtyd(String[] fqtyd) {
		this.fqtyd = fqtyd;
	}
	public String[] getUnitd() {
		return unitd;
	}
	public void setUnitd(String[] unitd) {
		this.unitd = unitd;
	}
	public String[] getAmountd() {
		return amountd;
	}
	public void setAmountd(String[] amountd) {
		this.amountd = amountd;
	}
	public String getChallanno() {
		return challanno;
	}
	public void setChallanno(String challanno) {
		this.challanno = challanno;
	}
	public String getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}
	public String getTruckrr() {
		return truckrr;
	}
	public void setTruckrr(String truckrr) {
		this.truckrr = truckrr;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getOamount() {
		return oamount;
	}
	public void setOamount(String oamount) {
		this.oamount = oamount;
	}
	public String getAddamount() {
		return addamount;
	}
	public void setAddamount(String addamount) {
		this.addamount = addamount;
	}
	public String getLessamount() {
		return lessamount;
	}
	public void setLessamount(String lessamount) {
		this.lessamount = lessamount;
	}
	public String getRoundoff() {
		return roundoff;
	}
	public void setRoundoff(String roundoff) {
		this.roundoff = roundoff;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getNetamount() {
		return netamount;
	}
	public void setNetamount(String netamount) {
		this.netamount = netamount;
	}
	public String getTaxselect() {
		return taxselect;
	}
	public void setTaxselect(String taxselect) {
		this.taxselect = taxselect;
	}
	public String getTransporter() {
		return transporter;
	}
	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}
	public String getCreditac() {
		return creditac;
	}
	public void setCreditac(String creditac) {
		this.creditac = creditac;
	}
	public String[] getBatchnohidden() {
		return batchnohidden;
	}
	public void setBatchnohidden(String[] batchnohidden) {
		this.batchnohidden = batchnohidden;
	}
	public String[] getExpdatehidden() {
		return expdatehidden;
	}
	public void setExpdatehidden(String[] expdatehidden) {
		this.expdatehidden = expdatehidden;
	}
	public String[] getAqtyhidden() {
		return aqtyhidden;
	}
	public void setAqtyhidden(String[] aqtyhidden) {
		this.aqtyhidden = aqtyhidden;
	}
	public String[] getFqtyhidden() {
		return fqtyhidden;
	}
	public void setFqtyhidden(String[] fqtyhidden) {
		this.fqtyhidden = fqtyhidden;
	}
	public String[] getPuratehidden() {
		return puratehidden;
	}
	public void setPuratehidden(String[] puratehidden) {
		this.puratehidden = puratehidden;
	}
	public String[] getStratehidden() {
		return stratehidden;
	}
	public void setStratehidden(String[] stratehidden) {
		this.stratehidden = stratehidden;
	}
	public String[] getRtratehidden() {
		return rtratehidden;
	}
	public void setRtratehidden(String[] rtratehidden) {
		this.rtratehidden = rtratehidden;
	}
	public String[] getMrphidden() {
		return mrphidden;
	}
	public void setMrphidden(String[] mrphidden) {
		this.mrphidden = mrphidden;
	}
	public String[] getAmountahidden() {
		return amountahidden;
	}
	public void setAmountahidden(String[] amountahidden) {
		this.amountahidden = amountahidden;
	}
	public String getStf() {
		return stf;
	}
	public void setStf(String stf) {
		this.stf = stf;
	}
	public String[] getAmounta() {
		return amounta;
	}
	public void setAmounta(String[] amounta) {
		this.amounta = amounta;
	}
	public String[] getBatchno() {
		return batchno;
	}
	public void setBatchno(String[] batchno) {
		this.batchno = batchno;
	}
	public String[] getExpdate() {
		return expdate;
	}
	public void setExpdate(String[] expdate) {
		this.expdate = expdate;
	}
	public String[] getAqty() {
		return aqty;
	}
	public void setAqty(String[] aqty) {
		this.aqty = aqty;
	}
	public String[] getFqty() {
		return fqty;
	}
	public void setFqty(String[] fqty) {
		this.fqty = fqty;
	}
	public String[] getPurate() {
		return purate;
	}
	public void setPurate(String[] purate) {
		this.purate = purate;
	}
	public String[] getStrate() {
		return strate;
	}
	public void setStrate(String[] strate) {
		this.strate = strate;
	}
	public String[] getRtrate() {
		return rtrate;
	}
	public void setRtrate(String[] rtrate) {
		this.rtrate = rtrate;
	}
	public String[] getMrp() {
		return mrp;
	}
	public void setMrp(String[] mrp) {
		this.mrp = mrp;
	}
	public String getMfgcode() {
		return mfgcode;
	}
	public void setMfgcode(String mfgcode) {
		this.mfgcode = mfgcode;
	}
	public String getMateriald() {
		return materiald;
	}
	public void setMateriald(String materiald) {
		this.materiald = materiald;
	}
	public String getPacking() {
		return packing;
	}
	public void setPacking(String packing) {
		this.packing = packing;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getReprate() {
		return reprate;
	}
	public void setReprate(String reprate) {
		this.reprate = reprate;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public String getMaterialg() {
		return materialg;
	}
	public void setMaterialg(String materialg) {
		this.materialg = materialg;
	}
	public String getOnac() {
		return onac;
	}
	public void setOnac(String onac) {
		this.onac = onac;
	}
	public String getDebitac() {
		return debitac;
	}
	public void setDebitac(String debitac) {
		this.debitac = debitac;
	}
	public String getHeadq() {
		return headq;
	}
	public void setHeadq(String headq) {
		this.headq = headq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSmcode() {
		return smcode;
	}
	public void setSmcode(String smcode) {
		this.smcode = smcode;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
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
	private String part,part1,showdate,contraref,contradate,retailername1;
	
	
	public String getComplaincode() {
		return complaincode;
	}
	
	public String getAsondate() {
		return asondate;
	}

	public String getRetailername1() {
		return retailername1;
	}
	public void setRetailername1(String retailername1) {
		this.retailername1 = retailername1;
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