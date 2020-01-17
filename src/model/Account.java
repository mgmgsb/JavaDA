package model;

import java.io.Serializable;

public class Account implements Serializable{
	private String id;
	private String name;
	private String mail;
	private String pass;
	public Account(String id, String name, String mail, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	public String getPass() {
		return pass;
	}
	public void setId(String id) {
		this.id = id;
	}


}
