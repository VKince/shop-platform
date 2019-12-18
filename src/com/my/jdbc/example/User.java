package com.my.jdbc.example;

public class User {
	private String username=null;
	private String truename;
	private String password;
	private String email;
	public String getusername() {
		return username;
	}
	public void setusername(String name) {
		this.username=name;
	}
	public String gettruename() {
		return truename;
	}
	public void settruename(String name) {
		this.truename=name;
	}
	
	public String getpassword() {
		return password;
	}
	public void setpassword(String pass) {
		this.password=pass;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String ee) {
		this.email=ee;
	}
}
