package model;

import javax.servlet.http.HttpSession;

import dao.BasicDAO;

public class LoginLogic {
	/*やること
	 * メールとパスワードをもらってDAOからログイン判定を行う
	 * ログインできたらセッションスコープにアカウントIDを入れてTrueの返り値を返す
	 *
	 * フィールド
	 *
	 *
	 * メソッド
	 * AccountDAOを用いてメールとパスワードからログイン判定を行う
	 *
	 */
	private String mail;
	private String pass;
	public LoginLogic() {}

	public String loginCheck(LoginInfo info) {
		//DAOにログインの是非を問い、成功ならばセッションスコープに"USER_DATA"を格納してHome.javaのGet呼び出し
		//失敗ならばTop.javaのGetを呼び出し（メールアドレスまたはパスワードが違いますのメッセージを可能なら入れる）
		//【ここではじくもの】メール...半角英数字と_以外　パスワード...半角英数字以外
		mail = info.getMail();
		pass = info.getPass();

		if(mail != null && mail != "" && mail.matches("[a-zA-Z0-9]{1,20}")){

			BasicDAO dao = new BasicDAO();
			Account result = dao.findByLogin(info);
			if (result != null) {
				return result.getName();
			} else {
				return null;
			}
		} else if(mail == "") {

		} else if () {

		}


	}
	private




}
