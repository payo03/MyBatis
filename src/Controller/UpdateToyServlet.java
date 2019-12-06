package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQL.ToyDao;
import domain.Toy;

@WebServlet("/From/UpdateToy")
public class UpdateToyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toyName = request.getParameter("toyName");
		int toyNo = Integer.parseInt(request.getParameter("toyNo"));
		int shopNo = Integer.parseInt(request.getParameter("shopNo"));
		
		Toy param = new Toy();
		param.setToyName(toyName);
		param.setToyNo(toyNo);
		param.setShopNo(shopNo);
		
		ToyDao toy = new ToyDao();
		
		toy.update(param);
		
		PrintWriter script = response.getWriter();
		
		script.println("<script>");
		script.println("alert(\"수정완료\");");
		script.println("window.location = '" + request.getContextPath() + "/From/ToyList'");
		script.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
