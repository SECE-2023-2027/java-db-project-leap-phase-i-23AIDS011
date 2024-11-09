package com.org.bank.model;

public class Account {
	private int accid;
	private String accholder;
	private String acctype;
	private double balance;
	private String address;
	private String phno;

	public Account(int accid, String accholder, String acctype, double balance, String address, String phno) {
		this.accid = accid;
		this.accholder = accholder;
		this.acctype = acctype;
		this.balance = balance;
		this.address = address;
		this.phno = phno;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public String getAccholder() {
		return accholder;
	}
	public void setAccholder(String accholder) {
		this.accholder = accholder;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Account [accid=" + accid + ", accholder=" + accholder + ", acctype=" + acctype + ", balance=" + balance
				+ ", address=" + address + ", phno=" + phno + "]";
	}
	
}
