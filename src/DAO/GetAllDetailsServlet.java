package DAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllDetailsServlet
 */
public class GetAllDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		DAOOrderToBill dao=new DAOOrderToBillOracle();
		Device dev=dao.getDevice(Integer.parseInt(request.getParameter("nodeid")));
		pw.append("<br>Device Details: ");
		pw.append("<br>Device Id : "+dev.getDeviceId());
		pw.append("<br>Part No : "+dev.getPartNo());
		pw.append("<br>Manufacturer : "+dev.getManufacturer());
		pw.append("<br>Zipcode : "+dev.getZipcode());
		pw.append("<br>Port Id : "+dev.getPortId());
		pw.append("<br>Status : "+dev.getStatus());
		pw.append("<br>Bandwidth in Mbps : "+dev.getBandwidthMbps());
		pw.append("<br>Device Type : "+dev.getDeviceType());
		pw.append("<br><br>");
		
		pw.append("<br>Circuit Details: ");
		Circuit circuit=dao.getCircuitDetailsUsingPorts(Integer.parseInt(request.getParameter("srcNode")),Integer.parseInt(request.getParameter("destNode")));
		
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
