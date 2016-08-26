/**
 * 
 */
package com.trusdom.fdip.common;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月27日 下午4:31:50
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class RestTempleteConfig {
	
	public static RestTemplate initRestTemplateForPdfAsByteArrayAndSelfSignedHttps() {
		RestTemplate restTemplate = new RestTemplate(useApacheHttpClientWithSelfSignedSupport());
		return restTemplate;
	}

	private static HttpComponentsClientHttpRequestFactory useApacheHttpClientWithSelfSignedSupport() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory useApacheHttpClient = new HttpComponentsClientHttpRequestFactory();
		useApacheHttpClient.setHttpClient(httpClient);
		return useApacheHttpClient;
	}
	public static RestTemplate getTemplete() throws Exception {
		   SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build());
		   	 	
		      HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
		      HttpComponentsClientHttpRequestFactory useApacheHttpClient = new HttpComponentsClientHttpRequestFactory();
		      useApacheHttpClient.setHttpClient(httpClient);
		      RestTemplate template = new RestTemplate(useApacheHttpClient);
//		      ((HttpComponentsClientHttpRequestFactory) template.getRequestFactory()).setHttpClient(httpClient);
		      return template;
	}
	
	
	

	
}
