package chandni;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DecisionServlet
 */
public class DecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
			
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selection=request.getParameter("selectoption");
		
		//System.out.println("hree");
		if(selection.equals("modify")){
			System.out.println("modify");
			RequestDispatcher rd=request.getRequestDispatcher("modifyinventory.jsp");
			rd.forward(request, response);
		}
		
		else if(selection.equals("provision")){
			System.out.println("provison");
			RequestDispatcher rd=request.getRequestDispatcher("ProvisionReadyServlet");
			rd.forward(request, response);
		}
		else if(selection.equals("viewnetwork")){
			System.out.println("viewnetwork");
			RequestDispatcher rd=request.getRequestDispatcher("Visualization.html");
			rd.forward(request, response);
		}
		
		
	
	}

}
