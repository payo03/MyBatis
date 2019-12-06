package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQL.OrderDao;
import SQL.ToyDao;
import domain.Customer;
import domain.Order;
import domain.Toy;

@WebServlet("/From/UpdateOrder")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		Customer loginCustomer = (Customer)session.getAttribute("Customer");
		
		String orderName = loginCustomer.getCustomerName();
		int toyNo = Integer.parseInt(request.getParameter("toyNo"));
		int shopNo = Integer.parseInt(request.getParameter("shopNo"));
		String or = request.getParameter("order");
		String up = request.getParameter("update");
		
		if(or!=null) {
			OrderDao order = new OrderDao();
			Order param = new Order();
			param.setToyNo(toyNo);
			param.setShopNo(shopNo);
			param.setCustomerName(orderName);
			
			order.order(param);
			
			script.println("<script>");
			script.println("alert(\"주문 완료\");");
			script.println("window.location = '" + request.getContextPath() + "/From/ToyList'");
			script.println("</script>");
		}
		if(up!=null) {
			Toy param = new Toy();
			param.setShopNo(shopNo);
			param.setToyNo(toyNo);
			
			ToyDao toy = new ToyDao();
			Toy result = new Toy();
			result = toy.select(param);
			
			request.setAttribute("Toy", result);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/UpdateToy.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
