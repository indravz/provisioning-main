package DAO;

import java.sql.Date;

public class CustomerServices {
	int customerId;
	int serviceId;
	String currentStatus;
	java.sql.Date effectiveDate;
	java.sql.Date endDate;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public java.sql.Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(java.sql.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public java.sql.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
	public CustomerServices(int customerId, int serviceId,
			String currentStatus, Date effectiveDate, Date endDate) {
		super();
		this.customerId = customerId;
		this.serviceId = serviceId;
		this.currentStatus = currentStatus;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
	}
	

}
