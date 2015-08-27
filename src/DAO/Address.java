package DAO;

public class Address {
	
	int addressId;
	int zipcode;
	public Address(int addressId, int zipcode) {
		super();
		this.addressId = addressId;
		this.zipcode = zipcode;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
