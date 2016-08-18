package main.java.gifservice;

public class GIFSearch {
	String gifID;
	String gifURL;
	
	public GIFSearch(String gifID, String gifURL) {
		this.gifID = gifID;
		this.gifURL = gifURL;
	}
	public String getGifID() {
		return gifID;
	}
	public void setGifID(String gifID) {
		this.gifID = gifID;
	}
	public String getGifURL() {
		return gifURL;
	}
	public void setGifURL(String gifURL) {
		this.gifURL = gifURL;
	}
	
	
}
