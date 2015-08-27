package chandni;
import java.io.IOException;
import java.io.PrintWriter;




import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOOrderToBillOracle;

/**
 * Servlet implementation class AddServlet
 */

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("abc");
		PrintWriter pw = response.getWriter();
		// pw.print("fkjhntei");
		// Device d=new Device();
		PrintWriter p=response.getWriter();
		String deviceid = request.getParameter("inp1");
		System.out.println("gbgh");
		String partnumber = request.getParameter("inp2");
		String manufacturer = request.getParameter("inp3");
		String zipcodestring= request.getParameter("inp4");
		String portidstring = request.getParameter("inp5");
		String status = request.getParameter("inp6");
		String bandwidthstring = request.getParameter("inp7");
		String deviceType=request.getParameter("inp8");
		int zipcode=Integer.parseInt(zipcodestring);
		int portid=Integer.parseInt(portidstring);
		int bandwidth=Integer.parseInt(bandwidthstring);
		/*if(partnumber.equals("")||manufacturer.equals("")||zipcodestring.equals("")||portidstring.equals("")||
				status.equals("VACANT")|bandwidthstring.equals("")||deviceType.equals("")){
			p.print("Please enter values in all the fields");
		}
		*/
	/*	else{*/	//Device d=new Device(*,in1,in2,in3,in4,in5,in6,in7);
		 DAOOrderToBillOracle dao=new  DAOOrderToBillOracle();
		int a=dao.insertDevice(deviceid,partnumber,manufacturer,zipcode,portid,status,bandwidth,deviceType);
        
      /*  if(a==0){*/
        p.print("Your device has been added");
       /* }
        else
        {
        	pw.print("Device couldn't be added");
        }*/
		System.out.println(deviceid);
		System.out.println(partnumber);
		System.out.println(manufacturer);
		System.out.println(zipcode);
		System.out.println(portid);
		System.out.println(status);
		System.out.println(bandwidth);
		System.out.println(deviceType);
		
		}
	}
/*}*/
