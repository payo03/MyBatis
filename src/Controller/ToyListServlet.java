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

import SQL.ToyDao;
import vo.Shop;
import vo.Toy;

@WebServlet("/From/ToyList")
public class ToyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopLocation = request.getParameter("shopLocation");
		Shop param = new Shop();
		param.setShopLocation(shopLocation);
		
		ToyDao toy = new ToyDao();
		List<Toy> result = new ArrayList<Toy>();
		
		result = toy.selectList(param);
		request.setAttribute("ToyList", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ToyList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
