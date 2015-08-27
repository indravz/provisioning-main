package animesh;

import java.io.IOException;	
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOOrderToBillOracle;

/**
 * Servlet implementation class GetVacantPortIdsServlet
 */
public class GetVacantPortIdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVacantPortIdsServlet() {
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
		HttpSession hs=request.getSession();
		String dev=request.getParameter("device").toString();
		List<Integer> port = new DAOOrderToBillOracle().getVacantPortIdsInDevice(dev);
		System.out.println("Vacant ports "+ port);
		Collections.sort(port) ;
		PrintWriter pw=response.getWriter();
		
		
		if (port.isEmpty()){
			System.out.println("So it is empty");
			hs.setAttribute("port",-1);
			hs.setAttribute("devsel", dev);
			pw.write("-1");
			/*RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);*/
		}
		else{
			int p= port.get(0);
			System.out.println(p);
			hs.setAttribute("port",p);
			hs.setAttribute("devsel", dev);
			pw.write(""+p);
		}
		
		
			
	}

}
