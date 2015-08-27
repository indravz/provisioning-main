package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOOrderToBillOracle implements DAOOrderToBill {
	public static Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String uname = "scott";
			String password = "tiger";
			String url = "jdbc:oracle:thin:@192.168.0.184:1521:orcl";
			con = DriverManager.getConnection(url, uname, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return con;
	}

	/*
	 * public int insertDevice(Device device) { PreparedStatement pstmt = null;
	 * Connection con = null; try { String query =
	 * "insert into Device values(?,?,?,?,?,?,?,?)"; con = createConnection();
	 * pstmt = con.prepareStatement(query); pstmt.setInt(1,
	 * device.getSequenceNumber()); pstmt.setString(2, device.getDeviceId());
	 * pstmt.setString(3, device.getPartNo()); pstmt.setString(4,
	 * device.getManufacturer()); pstmt.setInt(5, device.getZipcode());
	 * pstmt.setInt(6, device.getPortId()); pstmt.setString(7,
	 * device.getStatus()); pstmt.setInt(8, device.getBandwidthMbps()); int rows
	 * = pstmt.executeUpdate(); return rows; } catch (SQLException e) {
	 * e.printStackTrace(); } finally {
	 * 
	 * try { if (pstmt != null) pstmt.close(); if (con != null) con.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } } return 0; }
	 */
	@Override
	public java.sql.Date getModifiedDate(){
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public java.sql.Date getEndDate(){
		java.util.Date utilDate = new java.util.Date();
		utilDate.setYear(utilDate.getYear()+6);
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	@Override
	public int insertDevice(String deviceId, String partNo,
			String manufacturer, int zipcode, int portId, String status,
			int bandwidthMbps, String deviceType) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			String query = "insert into Device values(Newsqn1.nextVal,?,?,?,?,?,?,?,?)";
			con = createConnection();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, deviceId);
			pstmt.setString(2, partNo);
			pstmt.setString(3, manufacturer);
			pstmt.setInt(4, zipcode);
			pstmt.setInt(5, portId);
			pstmt.setString(6, status);
			pstmt.setInt(7, bandwidthMbps);
			pstmt.setString(8, deviceType);
			int rows = pstmt.executeUpdate();
			con.commit();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Order> getProvisionReadyOrders() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();

		try {
			con = createConnection();
			String query = "select customer_id,order_id,order_status,order_due_date,order_type from Orders_Demo where order_status='PR' and order_type in ('N', 'C', 'D')";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// add fields
				Order order = new Order();
				order.setCustomerId(rs.getInt("customer_id"));
				order.setOrderId(rs.getInt("order_id"));
				order.setOrderStatus(rs.getString("order_status"));
				order.setOrderDueDate(rs.getDate("order_due_date"));
				order.setOrderType(rs.getString("order_type"));
				orderList.add(order);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;

	}

	@Override
	public int getZipcode(int serviceAddressId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			String query = "select zipcode from address where service_address_id="
					+ serviceAddressId;
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next())
				return rs.getInt("zipcode");
			else {
				System.out.println("Address Doesn't exist");
				return -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}
	
	@Override
	public List<String> getDeviceIdsInZipcode(int zipcode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<String> deviceIds = new ArrayList<String>();
		try {
			con = createConnection();
			String query = "select distinct device_id from Device where zipcode="
					+ zipcode;
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				deviceIds.add(rs.getString("device_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return deviceIds;
	}
	
	@Override
	public int getDeviceSeqNo(String deviceId, int portId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			String query = "select sequence_number from Device where device_id='"
					+ deviceId + "' and port_id=" + portId;
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("sequence_number");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return -1;
	}
	
	@Override
	public Device getDevice(int sequenceNumber) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Device device = new Device();

		try {
			con = createConnection();
			String query = "select * from Device where sequence_number="
					+ sequenceNumber;
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				device.setSequenceNumber(rs.getInt(1));
				device.setDeviceId(rs.getString(2));
				device.setPartNo(rs.getString(3));
				device.setManufacturer(rs.getString(4));
				device.setZipcode(rs.getInt(5));
				device.setPortId(rs.getInt(6));
				device.setStatus(rs.getString(7));
				device.setBandwidthMbps(rs.getInt(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return device;
	}
	
	@Override
	public List<Integer> getVacantPortIdsInDevice(String deviceId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> portIds = new ArrayList<Integer>();
		try {
			con = createConnection();
			String query = "select port_id from Device where device_id='"
					+ deviceId + "' and status='VACANT'";

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portIds.add(rs.getInt("port_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return portIds;
	}
	
	@Override
	public List<Integer> getAllPortIdsInDevice(String deviceId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> portIds = new ArrayList<Integer>();
		try {
			con = createConnection();
			String query = "select port_id from Device where device_id='"
					+ deviceId + "'";

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portIds.add(rs.getInt("port_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return portIds;
	}
	
	@Override
	public List<Integer> getReservedPortIdsInDevice(String deviceId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> portIds = new ArrayList<Integer>();
		try {
			con = createConnection();
			String query = "select port_id from Device where device_id='"
					+ deviceId + "' and status='RESERVED'";

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portIds.add(rs.getInt("port_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return portIds;
	}
	
	@Override
	public List<Integer> getAllZipcodes() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> zipcodes = new ArrayList<Integer>();
		try {
			con = createConnection();
			String query = "select unique zipcode from Device ";

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				zipcodes.add(rs.getInt("zipcode"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return zipcodes;
	}

	/*
	 * public int insertConnectionIntoCircuitDesign(Circuit circuit) {
	 * PreparedStatement pstmt = null; Connection con = null; try { String query
	 * = "insert into Circuit values(?,?,?,?,?,?,?,?)"; con =
	 * createConnection(); pstmt = con.prepareStatement(query); pstmt.setInt(1,
	 * circuit.getSourcePort()); pstmt.setInt(2, circuit.getDestinationPort());
	 * pstmt.setInt(3, circuit.getOrderId()); pstmt.setInt(4,
	 * circuit.getCustomerId()); pstmt.setInt(5, circuit.getBandwidthMbps());
	 * pstmt.setString(6, circuit.getStatus()); pstmt.setString(7,
	 * circuit.getDueDate()); pstmt.setString(8, circuit.getModifiedDate()); int
	 * rows = pstmt.executeUpdate(); return rows; } catch (SQLException e) {
	 * e.printStackTrace(); } finally {
	 * 
	 * try { if (pstmt != null) pstmt.close(); if (con != null) con.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } } return 0;
	 * 
	 * }
	 * 
	 * public int getCircuitOrderIdForChangeOrder(String serviceId) { Connection
	 * con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * try { con = createConnection(); String query =
	 * "select orderId from Order where serviceId=" + serviceId +
	 * " and orderType='N'"; System.out.println(query); pstmt =
	 * con.prepareStatement(query); rs = pstmt.executeQuery();
	 * 
	 * if (rs.next()) { return rs.getInt("orderId"); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally {
	 * 
	 * try { if (pstmt != null) pstmt.close(); if (con != null) con.close(); }
	 * catch (SQLException e) { e.printStackTrace(); } } return -1;
	 * 
	 * }
	 */
	
	@Override
	public int insertConnectionIntoCircuitDesign(int sourcePort,
			int destinationPort, int orderId, int customerId,
			int bandwidthMbps, String status, java.sql.Date dueDate,
			java.sql.Date modifiedDate) {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			String query = "insert into Circuit_design values(?,?,?,?,?,?,?,?)";
			con = createConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sourcePort);
			pstmt.setInt(2, destinationPort);
			pstmt.setInt(3, orderId);
			pstmt.setInt(4, customerId);
			pstmt.setInt(5, bandwidthMbps);
			pstmt.setString(6, status);
			pstmt.setDate(7, dueDate);
			pstmt.setDate(8, modifiedDate);
			int rows = pstmt.executeUpdate();
			con.commit();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}
	
	@Override
	public int getCircuitOrderIdForChangeOrder(int customerId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			String query = "select order_Id from Orders_demo where customer_id='"
					+ customerId
					+ " and order_Type='NEW'";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("order_Id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;

	}
	
	
	@Override
	public void updateDeviceStatus(int sequenceNumber, String status) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = createConnection();
			String query = "update Device set status='" + status
					+ "' where sequence_number=" + sequenceNumber;
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void updateCircuitStatus(int orderId, String status) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = createConnection();
			String query = "update Circuit_Design set status='" + status
					+ "' where order_id=" + orderId;
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void updateOrderStatus(int orderId, String status) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = createConnection();
			String query = "update orders_demo set order_status='" + status
					+ "' where order_id=" + orderId;
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void updateDestinationPort(int oldOrderId, int destSequenceNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = createConnection();

			String query = "update Circuit_Design set destination_port="
					+ destSequenceNo + " where order_id=" + oldOrderId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Circuit getCircuitDetails(int orderId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Circuit circuit = null;

		try {
			con = createConnection();
			String query = "select * from circuit_Design where order_id="
					+ orderId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int sourcePort = rs.getInt("source_port");
				int destinationPort = rs.getInt("destination_port");
				int orderIdInt = rs.getInt("order_id");
				int customerId = rs.getInt("customer_id");
				int bandwidthMbps = rs.getInt("bandwidth_mbps");
				String status = rs.getString("status");
				java.sql.Date dueDate = rs.getDate("due_Date");
				java.sql.Date modifiedDate = rs.getDate("modified_Date");

				circuit = new Circuit(sourcePort, destinationPort, orderIdInt,
						customerId, bandwidthMbps, status, dueDate,
						modifiedDate);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return circuit;

	}
	
	@Override
	public List<Circuit> getAllCircuitsOfCustomer(int customerId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Circuit> allCircuits = new ArrayList<Circuit>();

		try {
			con = createConnection();
			String query = "select * from circuit_Design where customer_id="
					+ customerId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int sourcePort = rs.getInt("source_port");
				int destinationPort = rs.getInt("destination_port");
				int orderIdInt = rs.getInt("order_id");
				// int customerId = rs.getInt("customer_id");
				int bandwidthMbps = rs.getInt("bandwidth_mbps");
				String status = rs.getString("status");
				java.sql.Date dueDate = rs.getDate("due_date");
				java.sql.Date modifiedDate = rs.getDate("modified_date");

				Circuit circuit = new Circuit(sourcePort, destinationPort,
						orderIdInt, customerId, bandwidthMbps, status, dueDate,
						modifiedDate);
				allCircuits.add(circuit);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allCircuits;

	}
	
	@Override
	public int getServiceAddressId(int customerId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			String query = "select service_address_id from customers_demo where customer_id="
					+ customerId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next())
				return rs.getInt("service_address_id");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;

	}
	
	@Override
	public Order getOrderDetails(int orderId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;

		try {
			con = createConnection();
			String query = "select * from Orders_demo where order_Id="
					+ orderId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int customerId = rs.getInt("customer_id");
				// orderId known;
				String orderStatus = rs.getString("order_status");
				java.sql.Date orderDueDate = rs.getDate("order_due_date");
				String orderType = rs.getString("order_type");
				order = new Order(customerId, orderId, orderStatus,
						orderDueDate,  orderType);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return order;

	}
	
	/*@Override
	public String getServiceId(int orderId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			String query = "select service_id from Orders_demo where order_id="
					+ orderId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next())
				return rs.getString("service_id");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}*/
	
	@Override
	public String getCustomerId(int orderId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			String query = "select customer_id from Orders_demo where order_id="
					+ orderId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next())
				return rs.getString("customer_id");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public List<NodePair> getAllNodePairs() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NodePair> allNodePairs = new ArrayList<NodePair>();

		try {
			con = createConnection();
			String query = "select source_port, destination_port from circuit_Design";

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int sourcePort = rs.getInt("source_port");
				int destinationPort = rs.getInt("destination_port");
				NodePair nodePair = new NodePair(sourcePort, destinationPort);
				allNodePairs.add(nodePair);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allNodePairs;

	}

	@Override
	public void updateCustomerServices(int customerId, String currentStatus) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = createConnection();

			String query = "update customers_services_demo set current_status='"+currentStatus+"' , effective_date= "+getModifiedDate()+" , end_date= "+getEndDate()+
					 " where customer_id=" + customerId;
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			con.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
