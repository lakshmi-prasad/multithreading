package com.manib.bean;

public class Images {
	String gifID;
	String url;
	
	public Images(String gifID, String url) {
		this.gifID = gifID;
		this.url = url;
	}
	
	public String getGifID() {
		return this.gifID;
	}
	
	public String getURL() {
		return this.url;
	}
	
	public void setGifID(String gifID) {
		this.gifID = gifID;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
}
