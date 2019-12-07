package vo;

import java.io.Serializable;
import java.util.List;

public class Toy implements Serializable{

	private int toyNo;
	private String toyName;
	private int shopNo;
	private List<Shop> shops;
	
	public int getToyNo() {
		return toyNo;
	}
	public void setToyNo(int toyNo) {
		this.toyNo = toyNo;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	public List<Shop> getShops() {
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
