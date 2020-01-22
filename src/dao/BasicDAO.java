package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Account;
import model.LoginInfo;

public class BasicDAO {
	//DBテーブル　ACCOUNT　に対応したDAO
	/*
	 * 内包フィールド
	 * 接続情報
	 * 内包メソッド
	 * 接続
	 * 引数に指定されたメールアドレスとパスワードを紐づけて検索し、存在していたらTRUEを返す
	 * 引数に指定されたユーザ名が存在しているか確認し、存在しなければTRUEを返す
	 * Codeのカラム総数を返す
	 * 引数に指定されたレコードのCodeを返す
	 * 引数に指定されたIDのプレイ日と正答数を紐づけして返す
	 * 引数に指定されたID・プレイ日・正答数をDBに登録する
	 *アカウントの総数を返すメソッド
	 *
	 */

	private static String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private static String DB_USER = "sa";
	private static String DB_PASS = "pass";
	private static final int wordsAmount = 5;//出題コードの総数



	public Account findByLogin(LoginInfo login) {
		//ログインします
		Account account = null;

		//DB connecting
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID, NAME, MAIL, PASS FROM ACCOUNT_TEST WHERE MAIL = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getMail());
			pStmt.setString(2, login.getPass());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				account = new Account(rs.getString("ID"), rs.getString("NAME"), rs.getString("MAIL"), rs.getString("PASS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}


	public String choiceCode() {
		//WORDS_TESTからレコードを１つ持ってきて返す
		Random r = new Random();
		int i = r.nextInt(wordsAmount)+ 1;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT CODE FROM WORDS_TEST WHERE ID = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, i);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String s = rs.getString("CODE");
				return s;
			}
			return "***Error*** Undefinition ID is selected!";

		}catch (SQLException e) {
			return "***Error*** SQLException is throwed!";
		}



	}

	public boolean signUp(Account account) {
		//アカウントを新規登録します
		//後でメールの重複を避けるロジック実装必要
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//登録時の必要項目を記したSELECT文
			String registerSql = "INSERT INTO ACCOUNT_TEST VALUES(?, ?, ?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(registerSql);

			//アカウントにIDを割り振って登録.
			pStmt.setString(1, account.getId());
			pStmt.setString(2, account.getName());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getPass());

			pStmt.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean searchName(String searchName) {
		//アカウントを検索します
		//【ここは追加機能】第一引数で受け取る検索語の指定(n/4=1->mail && n = n%4, n/2=1->name && n = n%2, n/1=1->ID)
		//第二引数をString配列に。これらにより複数検索を簡単に
		List<Account> results = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//ユーザ名の重複を避けるためNAMEのみのSELECT文
			String searchSql = "SELECT ID, NAME, MAIL, PASS FROM ACCOUNT_TEST WHERE NAME = ?;";
			PreparedStatement pStmt = conn.prepareStatement(searchSql);
			pStmt.setString(1, searchName);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error001");
		}
		return false;
	}

	public int countRecord() {
		//AccountのID振りのための既存検索。オートインクリメントにして破棄すべきメソッド
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT * FROM ACCOUNT_TEST;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			int idCount = 0;
			while (rs.next()) {
				idCount++;
			}
			return idCount;
		}catch (SQLException e) {
			return -1;
		}
	}


}
