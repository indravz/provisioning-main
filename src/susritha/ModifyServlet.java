package susritha;

import java.io.IOException;
import DAO.*;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyServlet
 */

public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter pw;
		pw= response.getWriter();*/
		String orderid=request.getParameter("circuit");
		DAOOrderToBillOracle dao = new DAOOrderToBillOracle();
		Circuit c = dao.getCircuitDetails(Integer.parseInt(orderid));
		dao.updateDeviceStatus(c.getDestinationPort(),"VACANT");
		request.setAttribute("circuit", c);
		List<Integer> zips = new ArrayList<Integer>();
		zips=dao.getAllZipcodes();
		request.setAttribute("zips", zips);
		request.setAttribute("orderid", orderid);
		RequestDispatcher rd = request.getRequestDispatcher("ModifySecondPage.jsp");
		rd.forward(request, response);
		
		
		//o=dao.getOrderDetails();
		//int zip=dao.getZipcode(o.shippingAddressId);
		//String addr="Hyderabad";
		//String ar[] ={"device1", "device2", "device3"};
		/*List<String> al=new ArrayList<String>();
		al=dao.getDeviceIdsInZipcode(zip);
		RequestDispatcher rd = request.getRequestDispatcher("ModifySecondPage.jsp?zip="+zip);
		request.setAttribute("zip", zip);
		request.setAttribute("devices", al);
		rd.forward(request, response);*/
		/*pw.print("<select onchange=getPorts(this.value)>");
		for(int i=0; i<ar.length; i++){
			pw.print("<option>");
				pw.print(ar[i]);
			
			pw.print("</option>");
		}
		pw.print("</select>");*/
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
