package model;

public class LoginInfo {
	private String mail;
	private String pass;
	public LoginInfo(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public String getPass() {
		return pass;
	}


}
