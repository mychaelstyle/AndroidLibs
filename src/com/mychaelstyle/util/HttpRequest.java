package com.mychaelstyle.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/**
 * HTTP Request getting response as string
 * 
 * @author masanori nakashima
 */
public class HttpRequest {
	private int connectionTimeout = 5;
	private int socketTimeout = 3;
	private String userAgent;
	private Header[] requestHeaders;
	public HttpRequest() {
		super();
	}
	
	/**
	 * HTTP get
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws ServerConnectionException 
	 */
	public String get(String url)
	throws ClientProtocolException, IOException, ServerConnectionException{
		HttpGet method = new HttpGet(url);
		return this.request(method, url);
	}
	
	/**
	 * HTTP post
	 * @param url
	 * @param requestParams
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws ServerConnectionException 
	 */
	public String post(String url, List<NameValuePair> requestParams)
	throws ClientProtocolException, IOException, ServerConnectionException{
		HttpPost method = new HttpPost(url);
		method.setEntity(new UrlEncodedFormEntity(requestParams));  
		return this.request(method, url);
	}
	
	/**
	 * HTTP request
	 * @param method
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws ServerConnectionException 
	 */
	public String request(HttpRequestBase method, String url)
	throws ClientProtocolException, IOException, ServerConnectionException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, connectionTimeout);
		HttpConnectionParams.setSoTimeout(params, socketTimeout);
		method.setHeader("User-Agent", this.userAgent);
		if (requestHeaders != null) {
			for (Header header : requestHeaders) {
				method.addHeader(header);
			}
		}
		HttpResponse response = httpClient.execute(method);  
		int responseStatus = response.getStatusLine().getStatusCode();
		if(responseStatus!=HttpStatus.SC_OK) {
			throw new ServerConnectionException(responseStatus);
		}
		String resultStr = EntityUtils.toString(response.getEntity(), "UTF-8");
		return resultStr;
	}
}
