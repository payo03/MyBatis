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
import javax.servlet.http.HttpSession;

import SQL.OrderDao;
import domain.Customer;
import domain.Order;

@WebServlet("/From/OrderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer param = (Customer)session.getAttribute("Customer");
		String loginName = param.getCustomerName();
		
		OrderDao order = new OrderDao();
		List<Order> result = new ArrayList<Order>();
		
		result = order.show(loginName);
		
		request.setAttribute("OrderList", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/OrderList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
