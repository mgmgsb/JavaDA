package model;

public class ErrorCaution {
	//指定のエラーメッセージをgetterで返すだけのクラス
	private static String[] cautionList = {

	};


	//新規作成時のコピー用    private static final String "";


	//Loginで出るエラーメッセージ



	//Registerで出るエラーメッセージ

	private static final String StringuserNameNotRight = "ユーザー名は半角英数字と\" . \",\" - \", \" _ \"のみ使用可能です。";
	private static final String userNameUsed = "このユーザー名は既に使用されています。";
	private static final String mailNotRight = "正しいメールアドレスを入力してください。";
	private static final String mailAlreadyRegistered = "このメールアドレスは登録済みです。";
	private static final String passwordNotRight = "パスワードは半角英数字と＊＊【ここ後でやる】＊＊のみ使用可能です。";
	private static final String passwordLengthNotRight = "パスワードは6～32文字で入力してください。";
	private static final String passwordNotSame = "パスワードが一致しません。";






	public static String getStringusernamenotright() {
		return StringuserNameNotRight;
	}




	public static String getUsernameused() {
		return userNameUsed;
	}




	public static String getMailnotright() {
		return mailNotRight;
	}




	public static String getMailalreadyregistered() {
		return mailAlreadyRegistered;
	}




	public static String getPasswordnotright() {
		return passwordNotRight;
	}




	public static String getPasswordlengthnotright() {
		return passwordLengthNotRight;
	}




	public static String getPasswordnotsame() {
		return passwordNotSame;
	}



}
