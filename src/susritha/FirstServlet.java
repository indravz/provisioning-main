package susritha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pw.println("in first servlet");
		Integer orderid = (Integer) request.getAttribute("orderKey");
		//String orderid="1";
		HttpSession hs = request.getSession();
		hs.setAttribute("orderid", orderid);
		DAOOrderToBillOracle dao = new DAOOrderToBillOracle();
		Order o ;
		System.out.println("Hey"+orderid);
		o = dao.getOrderDetails(orderid);
		//pw.print(orderid);
		List<Circuit> al=new ArrayList<Circuit>();
		al=dao.getAllCircuitsOfCustomer(o.getCustomerId());
		request.setAttribute("circuits", al);
		RequestDispatcher rd = request.getRequestDispatcher("ModifyJsp.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
