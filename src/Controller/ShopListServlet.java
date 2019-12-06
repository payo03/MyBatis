package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQL.ShopDao;
import domain.Shop;

@WebServlet("/From/ShopList")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShopDao shop = new ShopDao();
		List<Shop> result = new ArrayList<>();
		
		result = shop.shopList();
		
		if(result!=null) {
			request.setAttribute("ShopList", result);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ShopList.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
