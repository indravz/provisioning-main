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
 * Servlet implementation class GetDataServlet
 */
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataServlet() {
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
		List<NodePair> lst=dao.getAllNodePairs();
		Iterator<NodePair> it=lst.iterator();
		pw.append("dinetwork {");
		while(it.hasNext()){
			NodePair np=it.next();
			pw.append(" "+np.getSrcNode()+" -> "+np.getDestNode());
			if(it.hasNext())
				pw.append(";");
			
		}
		pw.append(" }");
		System.out.println(pw.toString());
		//pw.write("dinetwork {1 -> 1 -> 2; 2 -> 3; 2 -- 4; 2 -> 1 }");
	}

}
