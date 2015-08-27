package susritha;

import java.io.IOException;
import DAO.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPortsServlet
 */
public class GetPortsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPortsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOOrderToBillOracle dao = new DAOOrderToBillOracle();
		String zips=request.getParameter("zips");
		List<String> al=new ArrayList<String>();
		al=dao.getDeviceIdsInZipcode(Integer.parseInt(zips));
		System.out.println(al.isEmpty());
		al.add("CISC9036");
		//al.add("Device1");
		//al.add("Device2");
		PrintWriter out =response.getWriter();
		out.write("<br><br>Select the destination device:<br><br>");
		out.write("<select name='devices'>");
		out.write("<option>");
		out.write("Select Device");
		out.write("</option>");
		for(int i=0; i<al.size(); i++){
			out.write("<option>");	
				out.write(""+al.get(i));
			out.write("</option>");
		}
		out.write("</select>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
