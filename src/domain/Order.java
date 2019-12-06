package domain;

import java.io.Serializable;

public class Order implements Serializable{

	private int toyNo;
	private int shopNo;
	private String orderDate;
	private String customerName;
	
	private Shop shop;
	private Toy toy;
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Toy getToy() {
		return toy;
	}
	public void setToy(Toy toy) {
		this.toy = toy;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getToyNo() {
		return toyNo;
	}
	public void setToyNo(int toyNo) {
		this.toyNo = toyNo;
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	
	
}
