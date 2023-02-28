package com.ssafy.ws.step4;

public class Restaurant {
	int resId;
	String name;
	String address;
	String signatureMenu;
	int rate;
	
	public Restaurant() {
		this(24, "애슐리", "성남시", "투움바", 4);
	}

	public Restaurant(int resId, String name, String address, String signatureMenu, int rate) {
		super();
		this.resId = resId;
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSignatureMenu() {
		return signatureMenu;
	}

	public void setSignatureMenu(String signatureMenu) {
		this.signatureMenu = signatureMenu;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public String toString() {
		return String.format("Restaurant [ResId=%s, Name=%s, Address=%s, SignatureMenu=%s, Rate=%d]"
				, resId, name, address, signatureMenu, rate);
	}

}
