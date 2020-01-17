package model;

import dao.BasicDAO;

public class RegisterLogic {
	/*
	 * フィールド
	 *
	 *
	 * メソッド
	 * RegisterDAOを用いてユーザ名から新規登録判定を行う
	 *
	 */
	private String user;
	public RegisterLogic(){	}



	public Account registerCheck(String user, String mail, String pass) {
		//DAOにログインの是非を問い、成功ならばセッションスコープに"USER_DATA"を格納してHome.javaのGet呼び出し
		//失敗ならばTop.javaのGetを呼び出し（メールアドレスまたはパスワードが違いますのメッセージを可能なら入れる）

		Account account = new Account("000", user, mail, pass);
		BasicDAO dao = new BasicDAO();
		account = dao.signUp(account);
		return account;


	}
}
