package vo;

import java.io.Serializable;

public class Search implements Serializable{
	
	private String shopLocation;
	private String toyName;
	
	public String getShopLocation() {
		return shopLocation;
	}
	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	
	

}
