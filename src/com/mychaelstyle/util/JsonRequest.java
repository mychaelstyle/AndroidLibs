/**
 * 
 */
package com.mychaelstyle.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * HTTP request get response as JSONObject
 * @author masanori nakashima
 */
public class JsonRequest {
	private HttpRequest request;
	/**
	 * Constructor
	 */
	public JsonRequest() {
		super();
		this.request = new HttpRequest();
	}
	
	/**
	 * get
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws ServerConnectionException
	 * @throws JSONException
	 */
	public JSONObject get(String url)
	throws ClientProtocolException, IOException, ServerConnectionException, JSONException {
		String response = this.request.get(url);
		return new JSONObject(response);
	}
	
	/**
	 * post
	 * @param url
	 * @param requestParams
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws ServerConnectionException
	 * @throws JSONException
	 */
	public JSONObject post(String url, List<NameValuePair> requestParams)
	throws ClientProtocolException, IOException, ServerConnectionException, JSONException{
		String response = this.request.post(url,requestParams);
		return new JSONObject(response);		
	}
	
}
