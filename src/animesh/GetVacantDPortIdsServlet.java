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
import javax.swing.JOptionPane;

import DAO.DAOOrderToBillOracle;

/**
 * Servlet implementation class GetVacantDPortIdsServlet
 */
public class GetVacantDPortIdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVacantDPortIdsServlet() {
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
		String ddev=(String) hs.getAttribute("ddevice");
		System.out.println(ddev);
		List<Integer> dport = new DAOOrderToBillOracle().getVacantPortIdsInDevice(ddev);
		Collections.sort(dport) ;
		PrintWriter pw=response.getWriter();
		
		if (dport.isEmpty()){
			System.out.println("So it is empty");
			hs.setAttribute("dport",-1);
			hs.setAttribute("ddevsel", ddev);
			pw.write("-1");
		/*	RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);*/
		}
		
			
		else{
			int dp= dport.get(0);
			System.out.println(dp);
			hs.setAttribute("dport",dp);
			hs.setAttribute("ddevsel", ddev);
			pw.write(dp);
		}
			
		
	}

}
