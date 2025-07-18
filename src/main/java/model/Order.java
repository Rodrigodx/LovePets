package model;

public class Order extends Product {

	private int orderId;
	private int uid;
	private int quantity;
	private String date;
	
	public Order() {
		
	}
	
	public Order(int orderId, int uid, int quantity, String date) {
		this.orderId = orderId;
		this.uid = uid;
		this.quantity = quantity;
		this.date = date;
	}
	
	public Order(int uid, int quantity, String date) {
		this.uid = uid;
		this.quantity = quantity;
		this.date = date;
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getUid() {
		return this.uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
