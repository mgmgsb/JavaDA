package model;

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

	public void loginCheck(LoginInfo info) {
		//DAOにログインの是非を問い、成功ならばセッションスコープに"USER_DATA"を格納してHome.javaのGet呼び出し
		//失敗ならばTop.javaのGetを呼び出し（メールアドレスまたはパスワードが違いますのメッセージを可能なら入れる）



	}




}
