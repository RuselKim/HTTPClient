package com.httpComponents.httpClient;

import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class Response {
	public Response(Map<String, Object> props) {
		this.props = props;
	}
	
	private Map <String, Object> props;

	
	JSONObject obj = new JSONObject();
	
}
