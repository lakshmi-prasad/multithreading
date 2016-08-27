package main.java.gifservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GIFSearchTask {

	private static final Logger logger = LoggerFactory
			.getLogger(GIFSearchTask.class);

	private GIFDataNode[] gifData;
	private final int RESULT_LIMIT;
	private final String DATA = "data";

	public GIFSearchTask(int n) {
		this.RESULT_LIMIT = n;
		this.gifData = new GIFDataNode[n];

	}

	public GIFDataNode[] curateGIFs(String token) {
		String jsonStr = null;
		try {
			jsonStr = searchGIFs(token);
			logger.debug(jsonStr);
			filterGifData(jsonStr);
		} catch (IOException e) {
			this.gifData = new GIFDataNode[0];
			logger.error("Error in curating GIFs", e);
		} 
		
		if (this.gifData == null) {
			this.gifData = new GIFDataNode[0];
		}
		return this.gifData;
	}

	public String searchGIFs(String token) throws IOException {
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		// NOTE: ideally should use URI builder
		String zurl = "http://api.giphy.com/v1/gifs/search?q=" + token
				+ "&limit=" + this.RESULT_LIMIT
				+ "&fmt=json&api_key=dc6zaTOxFJmzC";

		URL url = new URL(zurl);
		logger.info(zurl);
		urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		urlConnection.connect();

		InputStream inputStream = urlConnection.getInputStream();
		StringBuffer buffer = new StringBuffer();
		if (inputStream == null) {
			return null;
		}
		reader = new BufferedReader(new InputStreamReader(inputStream));

		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line + "\n");
		}

		if (buffer.length() == 0) {
			return null;
		}
		return buffer.toString();
	}

	public void filterGifData(String gifSearchData) {
		if (gifSearchData == null) {
			this.gifData = null;
			return;
		}

		try {

			JSONObject jsonObj = new JSONObject(gifSearchData);
			JSONArray gifArray = jsonObj.getJSONArray(DATA);

			int size = gifArray.length();

			if (size < this.RESULT_LIMIT) {
				this.gifData = null;
				return;
			}

			for (int i = 0; i < size; i++) {
				JSONObject gifObj = gifArray.getJSONObject(i);
				String gif_id = gifObj.getString("id");
				String url = gifObj.getString("url");
				gifData[i] = new GIFDataNode(gif_id, url);
				logger.debug(gifData[i].toString());
			}
		} catch (JSONException e) {
			this.gifData = new GIFDataNode[0];
			logger.error("Error in filtering GIF data!", e);
		}
	}

}
