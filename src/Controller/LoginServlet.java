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

import SQL.CustomerDao;
import vo.Customer;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Customer param = new Customer();
		param.setCustomerId(id);
		param.setCustomerPwd(pw);
		
		CustomerDao customer = new CustomerDao();
		Customer result = new Customer();
		result = customer.login(param);
		
		if(result != null) {
			session.setAttribute("Customer", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/From/Main");
			dispatcher.forward(request, response);
		}
		script.println("<script>");
		script.println("alert(\"ID 혹은 비밀번호를 확인하세요\");");
		script.println("history.go(-1)");
		script.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
