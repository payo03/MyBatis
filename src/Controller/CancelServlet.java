package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQL.OrderDao;
import domain.Customer;
import domain.Order;

@WebServlet("/From/Cancel")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("Customer");
		
		int toyNo = Integer.parseInt(request.getParameter("toyNo"));
		int shopNo = Integer.parseInt(request.getParameter("shopNo"));
		String name = customer.getCustomerName();
		
		Order param = new Order();
		param.setToyNo(toyNo);
		param.setShopNo(shopNo);
		param.setCustomerName(name);
		
		OrderDao order = new OrderDao();
		order.cancel(param);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/From/OrderList");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
