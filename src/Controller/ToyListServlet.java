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
import domain.Toy;

@WebServlet("/From/ToyList")
public class ToyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Toy> result = new ArrayList<Toy>();
		ToyDao toy = new ToyDao();
		
		result = toy.selectList();
		request.setAttribute("ToyList", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ToyList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
