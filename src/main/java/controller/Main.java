package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pokemon;
import model.PokemonParser;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		// 図鑑番号からポケモンのデータ取得
		PokemonParser parser = new PokemonParser();
		Pokemon pokemon = parser.getPokemon(id);

		// リクエストスコープに保存
		request.setAttribute("pokemon", pokemon);
		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}
}
