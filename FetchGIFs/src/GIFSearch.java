import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GIFSearch {
	
	private GIFDataNode [] gifData;
	
	public GIFSearch(int n) {
		gifData = new GIFDataNode[2];
	}

	public static void main(String[] args) throws IOException {
		GIFSearch gs = new GIFSearch(2);
		
		String token = "dog";
		String gifSearchData = gs.searchGIFs(token);
		gs.filterGifData(gifSearchData);
	}

	//final String FORECAST_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
	// final String GIPHY_BASE_URL =
	// "http://www.api.giphy.com/v1/gifs/search?q=cat&limit=2&fmt=json&api_key=dc6zaTOxFJmzC";
	//http://api.giphy.com/v1/gifs/search?q=cat&limit=2&fmt=json&api_key=dc6zaTOxFJmzC
	final String GIPHY_BASE_URL = "http://api.giphy.com/v1/gifs/search?";
	final String QUERY_PARAM = "q";
	final String FORMAT_PARAM = "fmt";
	final String LIMIT_PARAM = "limit";
	final String APIKEY_PARAM = "api_key";

	public String searchGIFs(String token) throws IOException {
		HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String forecastJsonStr = null;
        String zurl = "http://api.giphy.com/v1/gifs/search?q=" + token + "&limit=2&fmt=json&api_key=dc6zaTOxFJmzC";

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
         forecastJsonStr = buffer.toString();
         System.out.println("forecast str");
         System.out.println(forecastJsonStr);
         return forecastJsonStr;
	}
	
	public void filterGifData(String gifSearchData) {
		try {
			JSONObject jsonObj = new JSONObject(gifSearchData);
			JSONArray gifArray = jsonObj.getJSONArray("data");
			System.out.println("gif array size: " + gifArray.length());
			int size = gifArray.length();
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

class GIFDataNode {
	String gif_id;
	String url;

	public GIFDataNode(String gif_id, String url) {
		this.gif_id = gif_id;
		this.url = url;
	}
	
	public String toString() {
		return "[id: " + this.gif_id + ", url: " + this.url + "]"; 
	}
	
	
}
