package deepthi;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOOrderToBill;
import DAO.DAOOrderToBillOracle;
import DAO.Order;

public class OrdersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int orderid;
		String ordertype = null;
		orderid = Integer.parseInt(request.getParameter("orderRadio"));
		DAOOrderToBill dob = new DAOOrderToBillOracle();
		List<Order> orderlist = dob.getProvisionReadyOrders();

		for (int i = 0; i < orderlist.size(); i++) {
			if (orderlist.get(i).orderId == orderid) {
				ordertype = orderlist.get(i).orderType;
			}
		}

		System.out.println("order id"+orderid);
		//HttpSession session = request.getSession();
		request.setAttribute("orderKey", orderid);
		

		if (ordertype.equals("N")) {
			System.out.println("hey");
			RequestDispatcher rd = request.getRequestDispatcher("GetAllInitialData");
			rd.forward(request, response);
			//response.sendRedirect("AddOrder.jsp");
		}

		else if (ordertype.equals("C")) {
			RequestDispatcher rd = request.getRequestDispatcher("FirstServlet");
			rd.forward(request, response);
			//response.sendRedirect("FirstServlet");
		}

		else if (ordertype.equals("D")) {
			System.out.println(ordertype);
			RequestDispatcher rd = request.getRequestDispatcher("Disconnect");
			rd.forward(request, response);
			//response.sendRedirect("Disconnect.html");
		}

	}
}
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { int orderId; String
 * orderType;
 * 
 * orderId=Integer.parseInt(request.getParameter("orderRadio"));
 * 
 * System.out.println(orderId); System.out.println(orderType);
 * 
 * if(orderType=="add"){ response.sendRedirect("AddOrder.jsp"); } else
 * if(orderType=="modify"){ response.sendRedirect("ModifyOrder.jsp"); } else{
 * response.sendRedirect("DisconnectOrder.jsp"); } }
 */

