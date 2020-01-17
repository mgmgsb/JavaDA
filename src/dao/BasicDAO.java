package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 *
	 *
	 */

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/*****";
	private final String DB_USER = "sa";
	private final String DB_PASS = "****";


	public Account findByLogin(LoginInfo login) {
		Account account = null;

		//DB connecting
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "SELECT ID, NAME, MAIL, PASS FROM ACCOUNT WHERE MAIL = ? AND PASS = ?";
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


	public Account signUp(Account account) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String selectSql = "SELECT ID, NAME, MAIL, PASS FROM ACCOUNT WHERE USER = ?";
			String registerSql = "INSERT INTO ACCOUNT VALUES(ID, NAME, MAIL, PASS)";
			PreparedStatement pStmt = conn.prepareStatement(selectSql);
			pStmt.setString(1, account.getName());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				//結果が返った時はエラー
				account = null;
			} else {
				//結果が返らなかったとき、アカウントにIDを割り振って登録.
				account.setId("000");
				pStmt = conn.prepareStatement(registerSql);
				pStmt.setString(1, account.getId());
				pStmt.setString(2, account.getName());
				pStmt.setString(3, account.getMail());
				pStmt.setString(4, account.getPass());

				rs = pStmt.executeQuery();


			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}





}
