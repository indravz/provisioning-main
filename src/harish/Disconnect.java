package harish;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;


/**
 * Servlet implementation class Disconnect
 */
public class Disconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Disconnect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int orderid = Integer.parseInt(request.getParameter("orderid"));
		Integer orderid = (Integer) request.getAttribute("orderKey");
		DAOOrderToBillOracle dao = new DAOOrderToBillOracle();
		Order o =dao.getOrderDetails(orderid);
	/*	List<Circuit> al=new ArrayList<Circuit>();
				al=dao.getAllCircuitsOfCustomer(o.getCustomerId());*/
				
		dao.updateCircuitStatus(dao.getCircuitOrderIdForChangeOrder(o.getCustomerId()), "D");
		dao.updateOrderStatus(orderid, "PC");
		PrintWriter pw;
		pw=response.getWriter();
		pw.print("Done");
		pw.print("<a href='ProvisionScreen.jsp'>Home</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
