package main.java.gifservice;

public class GIFDataNode {
	private String gif_id;
	private String url;

	public String getGif_id() {
		return gif_id;
	}

	public void setGif_id(String gif_id) {
		this.gif_id = gif_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GIFDataNode(String gif_id, String url) {
		this.gif_id = gif_id;
		this.url = url;
	}
	
	public String toString() {
		return "[id: " + this.gif_id + ", url: " + this.url + "]"; 
	}
}
