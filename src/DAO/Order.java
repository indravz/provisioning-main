package DAO;

public class Order {
	int customerId;
	public int orderId;
	String orderStatus;
	java.sql.Date orderDueDate;
	public String orderType;
	
	public Order(){
		
	}

	public Order(int customerId, int orderId, String orderStatus,
			java.sql.Date orderDueDate, String orderType) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDueDate = orderDueDate;
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "Order [customerId=" + customerId + ", orderId=" + orderId
				+ ", orderStatus=" + orderStatus + ", orderDueDate="
				+ orderDueDate +  ", orderType=" + orderType + "]";
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public java.sql.Date getOrderDueDate() {
		return orderDueDate;
	}

	public void setOrderDueDate(java.sql.Date orderDueDate) {
		this.orderDueDate = orderDueDate;
	}

	

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
