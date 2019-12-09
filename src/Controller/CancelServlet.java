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
import vo.Customer;
import vo.Order;

@WebServlet("/From/Cancel")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		
		Order param = new Order();
		param.setOrderNo(orderNo);
		
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
