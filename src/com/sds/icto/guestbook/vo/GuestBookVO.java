package com.sds.icto.guestbook.vo;

import java.sql.Date;

public class GuestBookVO {

	private int no;
	private String name;
	private String password;
	private String message;
	private Date reg_date;
	public GuestBookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuestBookVO(int no, String name, String password, String message,
			Date reg_date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.message = message;
		this.reg_date = reg_date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "GuestBookVO [no=" + no + ", name=" + name + ", password="
				+ password + ", message=" + message + ", reg_date=" + reg_date
				+ "]";
	}
	
}
