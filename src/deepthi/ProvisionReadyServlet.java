package deepthi;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOOrderToBill;
import DAO.DAOOrderToBillOracle;
import DAO.Order;

public class ProvisionReadyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOrderToBill dob = new DAOOrderToBillOracle();
		List<Order> orderlist= dob.getProvisionReadyOrders();
		request.setAttribute("orderkey",orderlist);
		RequestDispatcher rd=request.getRequestDispatcher("OrdersList.jsp");
		rd.forward(request, response);
	}
}
