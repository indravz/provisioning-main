package DAO;
public class Device {

	int sequenceNumber;

	public Device() {

	}

	public Device(int sequenceNumber, String deviceId, String partNo,
			String manufacturer, int zipcode, int portId, String status,
			int bandwidthMbps, String deviceType) {
		super();
		this.sequenceNumber = sequenceNumber;
		this.deviceId = deviceId;
		this.partNo = partNo;
		this.manufacturer = manufacturer;
		this.zipcode = zipcode;
		this.portId = portId;
		this.status = status;
		this.bandwidthMbps = bandwidthMbps;
		this.deviceType = deviceType;
	}

	@Override
	public String toString() {
		return "Device [sequenceNumber=" + sequenceNumber + ", deviceId="
				+ deviceId + ", partNo=" + partNo + ", manufacturer="
				+ manufacturer + ", zipcode=" + zipcode + ", portId=" + portId
				+ ", status=" + status + ", bandwidthMbps=" + bandwidthMbps
				+ ", deviceType=" + deviceType + "]";
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	String deviceId;
	String partNo;
	String manufacturer;
	int zipcode;
	int portId;
	String status;
	int bandwidthMbps;
	String deviceType;

	public int getBandwidthMbps() {
		return bandwidthMbps;
	}

	public void setBandwidthMbps(int bandwidthMbps) {
		this.bandwidthMbps = bandwidthMbps;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getPortId() {
		return portId;
	}

	public void setPortId(int portId) {
		this.portId = portId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
