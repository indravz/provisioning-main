package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDeviceDetailsServlet
 */
public class GetDeviceDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDeviceDetailsServlet() {
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
		pw.append("\nDevice Id : "+dev.getDeviceId());
		pw.append("\nPart No : "+dev.getPartNo());
		pw.append("\nManufacturer : "+dev.getManufacturer());
		pw.append("\nZipcode : "+dev.getZipcode());
		pw.append("\nPort Id : "+dev.getPortId());
		pw.append("\nStatus : "+dev.getStatus());
		pw.append("\nBandwidth in Mbps : "+dev.getBandwidthMbps());
		pw.append("\nDevice Type : "+dev.getDeviceType());
	
		
	}

}
