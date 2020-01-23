package model;

import dao.BasicDAO;

public class RegisterLogic {
	/*
	 * フィールド
	 *破棄
	 *
	 * メソッド
	 * RegisterDAOを用いてユーザ名から新規登録判定を行う
	 *
	 */
	private String user;
	public RegisterLogic(){	}



	public String register(String name, String mail, String pass, String repass) {
		//成功した場合はユーザーネームを返し、失敗したらエラーメッセージを返す・・・ん？
		//
		//DAOにログインの是非を問い、成功ならばセッションスコープに"USER_DATA"を格納してHome.javaのGet呼び出し
		//失敗ならばTop.javaのGetを呼び出し（メールアドレスまたはパスワードが違いますのメッセージを可能なら入れる）

		Account account = new Account("0000", name, mail, pass);
		BasicDAO dao = new BasicDAO();
		//ユーザーネームがすでに存在しているとNull返す
		if(dao.searchName(account.getName()) == true) return null;
		int idCount = dao.countRecord();
		account.setId(String.valueOf(idCount + 1));
		if(dao.signUp(account)) {
			return account.getName();
		} else {
			return null;
		}

	}

	public 
}
