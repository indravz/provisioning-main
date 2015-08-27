package susritha;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyConnectionServlet
 */
public class ModifyConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deviceid=request.getParameter("devices");
		DAOOrderToBillOracle dao = new DAOOrderToBillOracle();
		//String port=request.getParameter("port");
		List<Integer> port = new ArrayList<Integer>();
		port = dao.getVacantPortIdsInDevice((deviceid));
		System.out.println(port.isEmpty());
		Collections.sort(port);
		int min=0;
		if(!port.isEmpty()){
		min=port.get(0);
		}
		//Integer min = port.get(0);
		/*Iterator iterator = port.iterator();
		while(iterator.hasNext()){
			int i =1;
			if(port.get(i)<min)
				min=port.get(i);
			}
		}*/
		int seqnum= dao.getDeviceSeqNo((deviceid),min);
		HttpSession hs1 = request.getSession(false);
		String orderid=hs1.getAttribute("orderid").toString();
		dao.updateDeviceStatus(seqnum,"RESERVED");
		System.out.println(orderid);
		dao.updateDestinationPort(Integer.parseInt(orderid),seqnum);
		dao.updateOrderStatus(Integer.parseInt(orderid), "PC");
		PrintWriter p=response.getWriter();
		p.write("update");
		/*RequestDispatcher rd = request.getRequestDispatcher("FinalPage.jsp");
		rd.forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
