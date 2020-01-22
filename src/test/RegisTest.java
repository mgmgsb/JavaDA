package test;

import dao.BasicDAO;
import model.Account;
import model.LoginInfo;

public class RegisTest {
	private static String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private static final String DB_USER = "sa";
	private static final String DB_PASS = "pass";

	public static void main(String[] args) {
		choiceCodeのテスト();
//		登録のテスト();
//		searchNameのテスト();
//		ログインのテスト();
	}

	private static void choiceCodeのテスト() {
		BasicDAO dao = new BasicDAO();
		String string = dao.choiceCode();
		System.out.println(string);
		
		
		
	}

	private static void 登録のテスト() {
		Account account = new Account("777", "pachi", "take@kawa", "pass");
		BasicDAO dao = new BasicDAO();
		if(dao.searchName(account.getName()) == true) return;


		System.out.println(dao.signUp(account));


	}

	private static void searchNameのテスト() {
		/*テストの内容
		 * .signUpにAccountを入れて登録しする
		 * Accountを返す
		 *
		 */
		boolean results = false;
		BasicDAO dao = new BasicDAO();
		results = dao.searchName("namae");



		System.out.println(results);
//
//		if(testAc != null && testAc.getName().equals(answerAC.getName())) {
//			System.out.println("とりま名前は同じ");
//		}else {
//			System.out.println("名前ちゃうわ");
//		}




	}
	private static void ログインのテスト() {
		Account account = new Account("202", "zombii", "hurinkazan@com", "pass");
		LoginInfo login = new LoginInfo(account.getMail(), account.getPass());
		BasicDAO dao = new BasicDAO();
		Account result = dao.findByLogin(login);
		System.out.println(result.getName());



	}

}
