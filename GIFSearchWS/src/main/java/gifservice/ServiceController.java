package main.java.gifservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class ServiceController implements ErrorController {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceController.class.getName());
	
	@Autowired
	private ErrorAttributes errorAttributes;

	// @Value("${debug}")
	private final boolean debug = true;

	private static final String ERROR_PATH = "/error";
	private static final int N = 5;

	@RequestMapping("/search/{searchToken}")
	public GIFResponse search(@PathVariable String searchToken, HttpServletRequest request) {
		GIFSearchTask gifSearchTask = new GIFSearchTask(N);
		searchToken = sanitizeToken(searchToken.trim());
		GIFDataNode[] data = gifSearchTask.curateGIFs(searchToken);
		GIFResponse resp = new GIFResponse();
		resp.setData(data);
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			   ipAddress = request.getRemoteAddr();
		}
		//can use ip address for rate limiting or throttling based on in memory request tracking (key-value)
		logger.info("IP ADDRESS: " + ipAddress);
		return resp;
	}
	
	private String sanitizeToken(String str) {
		if (str == null) {
			return str;
		}
		String [] inArr = str.split(" ");
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<inArr.length; i++) {
			if (inArr[i].length() < 1) {
				continue;
			}
			sb.append(inArr[i] + "+");
		}
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

	@RequestMapping(value = ERROR_PATH)
	ErrorResponse error(HttpServletRequest request, HttpServletResponse response) {
		ErrorResponse err = new ErrorResponse(response.getStatus(), getErrorAttributes(
				request, debug));
		err.setMessage("API Format: http://[hostname]:8080/search/[search term]");
		return err;
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request,
			boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(
				request);
		return errorAttributes.getErrorAttributes(requestAttributes,
				includeStackTrace);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
