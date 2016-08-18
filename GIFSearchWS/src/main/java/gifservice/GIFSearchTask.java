package main.java.gifservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GIFSearchTask {
	
	private GIFDataNode [] gifData;
	private GIFResponse gifResponse;
	private final int n;
	
	public GIFSearchTask(int n) {
		this.gifData = new GIFDataNode[n];
		//gifResponse = new GIFResponse(n);
		this.n = n;
	}

//	public static void main(String[] args) throws IOException {
//		GIFSearchTask gs = new GIFSearchTask(2);
//	
//		System.out.println("searching for icecream: ");
//		String token = "icecream";
////		String gifSearchData = gs.searchGIFs(token);
////		gs.filterGifData(gifSearchData);
//		gs.curateGIFs(token);
//		
//	}
	
	public GIFDataNode [] curateGIFs(String token) {
		String jsonStr  = null;
		try {
			jsonStr = searchGIFs(token);
			filterGifData(jsonStr);
		} catch(IOException e) {
			e.printStackTrace();
		}
		//gifResponse.setData(this.gifData);
		System.out.println("GFT: " + Arrays.toString(this.gifData));
		return this.gifData;
	}

	//http://api.giphy.com/v1/gifs/search?q=cat&limit=2&fmt=json&api_key=dc6zaTOxFJmzC
	public String searchGIFs(String token) throws IOException {
		HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String jsonStr = null;
        String zurl = "http://api.giphy.com/v1/gifs/search?q=" + token + "&limit="+this.n+"&fmt=json&api_key=dc6zaTOxFJmzC";

		 URL url = new URL(zurl);
		 System.out.println(url.toString());

         // Create the request to OpenWeatherMap, and open the connection
         urlConnection = (HttpURLConnection) url.openConnection();
         urlConnection.setRequestMethod("GET");
         urlConnection.connect();
         
         // Read the input stream into a String
         InputStream inputStream = urlConnection.getInputStream();
         StringBuffer buffer = new StringBuffer();
         if (inputStream == null) {
             // Nothing to do.
             //return null;
             System.out.println("input stream null");
             return null;
         }
         reader = new BufferedReader(new InputStreamReader(inputStream));

         String line;
         while ((line = reader.readLine()) != null) {
             // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
             // But it does make debugging a *lot* easier if you print out the completed
             // buffer for debugging.
             buffer.append(line + "\n");
         }

         if (buffer.length() == 0) {
             // Stream was empty.  No point in parsing.
        	 System.out.println("buff len null");
             return null;
         }
         jsonStr = buffer.toString();
         System.out.println("jsonStr str");
         System.out.println(jsonStr);
         return jsonStr;
	}
	
	public void filterGifData(String gifSearchData) {
		try {
			JSONObject jsonObj = new JSONObject(gifSearchData);
			JSONArray gifArray = jsonObj.getJSONArray("data");
			System.out.println("gif array size: " + gifArray.length());
			int size = gifArray.length();
			//TODO: check if the size is less than desired and do the error handling accordingly.
			for (int i=0; i<size; i++) {
				JSONObject gifObj = gifArray.getJSONObject(i);
				String gif_id = gifObj.getString("id");
				String url = gifObj.getString("url");
				gifData[i] = new GIFDataNode(gif_id, url);
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println("GIF Data Node: ");
		for (GIFDataNode node: gifData) {
			System.out.println(node);
		}
	}

}



