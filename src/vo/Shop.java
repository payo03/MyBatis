package vo;

import java.io.Serializable;
import java.util.List;

public class Shop implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int shopNo;
	private String shopName;
	private String shopLocation;
	private String shopStatus;
	private List<Toy> toys;
	
	public List<Toy> getToys() {
		return toys;
	}
	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopLocation() {
		return shopLocation;
	}
	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}
	public String getShopStatus() {
		return shopStatus;
	}
	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}
	
	
}
