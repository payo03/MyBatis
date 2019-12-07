package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SQL.ShopDao;
import SQL.ToyDao;
import vo.Shop;
import vo.Toy;

@WebServlet("/From/InsertToy")
public class InsertToyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter script = response.getWriter();
		
		String toyName = request.getParameter("toyName");
		int shopNo = Integer.parseInt(request.getParameter("shopNo"));
		
		Toy param = new Toy();
		param.setToyName(toyName);
		param.setShopNo(shopNo);
		
		ToyDao toy = new ToyDao();
		
		toy.register(param);
			
		script.println("<script>");
		script.println("alert(\"등록 완료!\");");
		script.println("window.location ='" + request.getContextPath() + "/From/ShopList'");		//서블릿 호출
		script.println("</script>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
