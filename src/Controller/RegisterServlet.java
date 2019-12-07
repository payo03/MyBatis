package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQL.CustomerDao;
import vo.Customer;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		CustomerDao customer = new CustomerDao();
		
		Customer param = new Customer();
		param.setCustomerId(id);
		param.setCustomerPwd(pw);
		param.setCustomerName(name);
		
		Customer result = new Customer();
		result = customer.register(param);
		
		if(result!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginForm.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
