package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQL.ShopDao;
import domain.Shop;

@WebServlet("/From/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopLocation = request.getParameter("shopLocation");
		
		ShopDao shop = new ShopDao();
		List<Shop> result = new ArrayList<Shop>();
		
		result = shop.search(shopLocation);
		
		if(shopLocation.equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/From/ShopList");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("SearchData", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SearchDataShop.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
