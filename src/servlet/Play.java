package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasicDAO;

/**
 * Servlet implementation class Play
 */
@WebServlet("/Play")
public class Play extends HttpServlet {
	/*
	 * 実際のプレイ画面を司るクラス
	 * var disp == 0 -> プレイ前の待機画面を呼ぶ
	 * var disp == 1 -> プレイ画面を呼ぶ
	 * 終了処理：var disp = 0;
	 */
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Play() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * DAOでDBからレコードを引っ張ってきて
		 * セッションスコープに入れ、JSPにフォワードする。
		 * JSPでセッションスコープからレコードを表示し、フォームで受けたコードをまたセッションスコープに
		 * サーブレットからチェックロジックに渡して結果次第でログ追加もしくは再解答
		 *
		 */

		HttpSession session = request.getSession();
		BasicDAO dao = new BasicDAO();
		String code = dao.choiceCode();

		session.setAttribute("code", code);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/play.jsp");
		dispatcher.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
