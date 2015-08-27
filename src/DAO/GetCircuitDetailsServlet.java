package DAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCircuitDetailsServlet
 */
public class GetCircuitDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCircuitDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		DAOOrderToBill dao=new DAOOrderToBillOracle();
		Circuit circuit=dao.getCircuitDetailsUsingPorts(Integer.parseInt(request.getParameter("srcNode")),Integer.parseInt(request.getParameter("destNode")));
		
		
		
		
		pw.append("<br>Circuit Details");
		pw.append("<br>Source Port :"+circuit.getSourcePort());
		pw.append("<br>Destination Port: "+circuit.getDestinationPort());
		pw.append("<br>Order Id : "+circuit.getOrderId());
		pw.append("<br>Customer Id : "+circuit.getCustomerId());
		pw.append("<br>Status : "+circuit.getStatus());
		pw.append("<br>Due Date : "+circuit.getDueDate());
		pw.append("<br>Modified Date : "+circuit.getModifiedDate());
		
		pw.append("<br>Bandwidth in Mbps : "+circuit.getBandwidthMbps());
		
		
	}

}
