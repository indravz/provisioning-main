package DAO;

public class Circuit {
	@Override
	public String toString() {
		return "Circuit [sourcePort=" + sourcePort + ", destinationPort="
				+ destinationPort + ", orderId=" + orderId + ", customerId="
				+ customerId + ", bandwidthMbps=" + bandwidthMbps + ", status="
				+ status + ", dueDate=" + dueDate + ", modifiedDate="
				+ modifiedDate + "]";
	}
	int sourcePort;
	int destinationPort;
	int orderId;
	int customerId;
	int bandwidthMbps;
	String status;
	java.sql.Date dueDate;
	java.sql.Date modifiedDate;
	public int getSourcePort() {
		return sourcePort;
	}
	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}
	public int getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBandwidthMbps() {
		return bandwidthMbps;
	}
	public void setBandwidthMbps(int bandwidthMbps) {
		this.bandwidthMbps = bandwidthMbps;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.sql.Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(java.sql.Date dueDate) {
		this.dueDate = dueDate;
	}
	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Circuit(int sourcePort, int destinationPort, int orderId,
			int customerId, int bandwidthMbps, String status, java.sql.Date dueDate,
			java.sql.Date modifiedDate) {
		super();
		this.sourcePort = sourcePort;
		this.destinationPort = destinationPort;
		this.orderId = orderId;
		this.customerId = customerId;
		this.bandwidthMbps = bandwidthMbps;
		this.status = status;
		this.dueDate = dueDate;
		this.modifiedDate = modifiedDate;
	}
	
}
