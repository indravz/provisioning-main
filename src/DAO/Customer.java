package DAO;

public class Customer {
	int customerId;
	int serviceAddressId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getServiceAddressId() {
		return serviceAddressId;
	}
	public void setServiceAddressId(int serviceAddressId) {
		this.serviceAddressId = serviceAddressId;
	}
	public Customer(int customerId, int serviceAddressId) {
		super();
		this.customerId = customerId;
		this.serviceAddressId = serviceAddressId;
	}
	
	

}
