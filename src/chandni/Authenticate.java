package chandni;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("username");
	String pass=request.getParameter("password");
if(name.equals("admin")&& pass.equals("provision")){
	RequestDispatcher rd=request.getRequestDispatcher("ProvisionScreen.jsp");
	rd.forward(request, response);
	
}
else{
	RequestDispatcher rd=request.getRequestDispatcher("Invalid.jsp");
	rd.forward(request, response);
	
}
	
	}

}
