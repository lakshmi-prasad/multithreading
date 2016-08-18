package main.java.gifservice;

public class GIFResponse {

	GIFDataNode [] data; 
	
	public GIFResponse(int n) {
		data = new GIFDataNode[n];
	}
	

	public GIFDataNode[] getData() {
		return data;
	}

	public void setData(GIFDataNode[] data) {
		this.data = data;
	}
}
