package animesh;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOOrderToBillOracle;
import DAO.Device;
import DAO.Order;




public class AddComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		Order order=(Order)hs.getAttribute("order");
		int sport=(int)hs.getAttribute("port");
		int dport=(int)hs.getAttribute("dport");
		
		int orderid=(int)hs.getAttribute("orderkey");
		
//		//ad-hoc
//		int orderid=1;
		
		int custid=order.getCustomerId();
		String ddevsel=(String)hs.getAttribute("ddevsel");
		String devsel=(String)hs.getAttribute("devsel");
		java.sql.Date dued=order.getOrderDueDate();
		//int saddid=order.getServiceAddressId();
		
		
		DAOOrderToBillOracle dest=new DAOOrderToBillOracle();
		int destseqnum= dest.getDeviceSeqNo(ddevsel, dport);
		int srcseqnum= dest.getDeviceSeqNo(devsel, sport);
//		
//		int destseqnum= 16;
//		int srcseqnum= 43;
		
		Device d=dest.getDevice(destseqnum);
		int bwidth=d.getBandwidthMbps();
		String status="INEFFECT";
		
		
		
		java.sql.Date mdate=dest.getModifiedDate();
		
		int result= dest.insertConnectionIntoCircuitDesign(srcseqnum,destseqnum,orderid,custid, bwidth,status,dued,mdate);
		
		if(result>0)
		{
			response.sendRedirect("AddComplete.jsp");
		}
		else
		{
			response.sendRedirect("AddIncomplete.jsp");
		}
		
	}

	

}
