package main.java.gifservice;

import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	
	private static final int N = 2;
	//URL myURL = new URL("http://example.com/pages/");
	@RequestMapping("/search")
    public GIFResponse search(@RequestParam(value="q", defaultValue="No Result") String q) {
//		GIFSearch obj = new GIFSearch("ID_ABC", template + q );
//		GIFSearch [] data = new GIFSearch[1];
//		data[0] = obj;
//		GIFResponse resp = new GIFResponse();
//		resp.setData(data);
//		return resp;
		GIFSearchTask gifSearchTask = new GIFSearchTask(N);
		GIFDataNode [] data = gifSearchTask.curateGIFs(q);
		GIFResponse resp = new GIFResponse(N);
		resp.setData(data);
		return resp;
    }
	/*
	 * {"gifID":"ID_ABC","gifURL":"http://example.com/pages/manibhushan"}
	 * [{"gifID":"ID_ABC","gifURL":"http://example.com/pages/manibhushan"}]
	 * {"data":[{"gifID":"ID_ABC","gifURL":"http://example.com/pages/manibhushan"}]}
	 */
}
