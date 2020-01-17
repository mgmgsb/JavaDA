package test;

import dao.BasicDAO;
import model.Account;

public class RegisTest {

	public static void main(String[] args) {
		登録成功のテスト();
		登録失敗のテスト();
	}

	private static void 登録成功のテスト() {
		/*テストの内容
		 * .signUpにAccountを入れて登録しする
		 * Accountを返す
		 * 
		 */
		
		Account account = new Account("000", "minato", "minato@gmail", "pass");
		BasicDAO dao = new BasicDAO();
		
		
	}
	private static void 登録失敗のテスト() {
		
		
	}
}
