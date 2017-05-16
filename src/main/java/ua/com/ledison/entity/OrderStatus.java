package ua.com.ledison.entity;

public enum OrderStatus {
	PENDING("Pending"),
	AWAITING_PAYMENT("Awaiting Payment"),
	AWAITING_SHIPMENT("Awaiting Shipment"),
	AWAITING_PICKUP("Awaiting Pickup"),
	PARTIALLY_SHIPPED("Partially Shipped"),
	COMPLETED("Completed"),
	SHIPPED("Shipped"),
	CANCELLED("Cancelled"),
	DECLINED("Declined"),
	REFUNDED("Refunded"),
	DISPUTED("Disputed"),
	VERIFICATION_REQUIRED("Verification Required");

	private String name;

	OrderStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
