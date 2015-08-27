package animesh;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOOrderToBillOracle;
import DAO.Order;

/**
 * Servlet implementation class GetAllZipcodes
 */
public class GetAllInitialData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllInitialData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Reached");
		List<Integer> l = new DAOOrderToBillOracle().getAllZipcodes();
		System.out.println("zipcodes"+ l.toString());
		
		request.setAttribute("l", l);
		
		
		//
		DAOOrderToBillOracle dest=new DAOOrderToBillOracle();
		System.out.println("order key " + request.getAttribute("orderKey"));
		Order order = dest.getOrderDetails((int)request.getAttribute("orderKey"));
		
		//ad-hoc
		//Order order = dest.getOrderDetails(1);
		
		System.out.println("order"+ order);
		
		System.out.println("cust id: "+order.getCustomerId());
		System.out.println("service address id: "+dest.getServiceAddressId(order.getCustomerId()));
		int dzip= dest.getZipcode(dest.getServiceAddressId(order.getCustomerId()));
		System.out.println("dzip "+dzip);
		request.setAttribute("dzip", dzip);
		
		List<String> ddevice= dest.getDeviceIdsInZipcode(dzip);
		System.out.println("ddevic e ids in zipcode "+ ddevice);
		
		HttpSession hs=request.getSession();
		hs.setAttribute("ddevice", ddevice);
		hs.setAttribute("order",order);
		hs.setAttribute("orderkey",request.getAttribute("orderKey") );
		
		RequestDispatcher rd=request.getRequestDispatcher("AddOrder.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get all zipcodes
		System.out.println("Reached");
		List<Integer> l = new DAOOrderToBillOracle().getAllZipcodes();
		System.out.println("zipcodes"+ l.toString());
		
		request.setAttribute("l", l);
		
		
		//
		DAOOrderToBillOracle dest=new DAOOrderToBillOracle();
		System.out.println("order key " + request.getAttribute("orderKey"));
		Order order = dest.getOrderDetails((int)request.getAttribute("orderKey"));
		
		//ad-hoc
		//Order order = dest.getOrderDetails(1);
		
		System.out.println("Hey order"+ order);
		
		System.out.println("order cust id"+ order.getCustomerId());
		System.out.println("Service Address Id: "+dest.getServiceAddressId(order.getCustomerId()));
		int dzip= dest.getZipcode(dest.getServiceAddressId(order.getCustomerId()));
		System.out.println("dzip "+dzip);
		request.setAttribute("dzip", dzip);
		
		List<String> ddevice= dest.getDeviceIdsInZipcode(dzip);
		System.out.println("ddevic e ids in zipcode "+ ddevice);
		
		HttpSession hs=request.getSession();
		hs.setAttribute("ddevice", ddevice);
		hs.setAttribute("order",order);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("AddOrder.jsp");
		rd.forward(request, response);
		
		
	}

}
