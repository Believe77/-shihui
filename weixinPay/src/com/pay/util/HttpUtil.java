package com.pay.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpUtil {

	 private static final Log logger = LogFactory.getLog("org.apache.catalina.tribes.MESSAGES" );
	      
	      private final static int CONNECT_TIMEOUT = 5000; // in milliseconds  
	      
	      private final static String DEFAULT_ENCODING = "UTF-8";  
	        
	      public static String postData(String urlStr, String data){  
	          return postData(urlStr, data, null);  
	      }  
	        
	      public static String postData(String urlStr, String data, String contentType){  
	          BufferedReader reader = null;  
	          try {  
	        	  System.out.println(data);
	              URL url = new URL(urlStr);  
	              URLConnection conn = url.openConnection();  
	              conn.setDoOutput(true);  
	              conn.setConnectTimeout(CONNECT_TIMEOUT);  
	              conn.setReadTimeout(CONNECT_TIMEOUT);  
	              if(contentType != null)  
	                  conn.setRequestProperty("content-type", contentType);  
	              OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);  
	              if(data == null) { 
	            	  System.out.println("1");
	                  data = "";  
	              }
	              writer.write(data);   
	              writer.flush();  
	              writer.close();    
	    
	              reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));  
	              System.out.println(reader.toString());
	              StringBuilder sb = new StringBuilder();  
	              String line = null;  
	              while ((line = reader.readLine()) != null) {  
	                  sb.append(line);  
	                  sb.append("\r\n");  
	              }  
	              return sb.toString();  
	          } catch (IOException e) {  
	              logger.error("Error connecting to " + urlStr + ": " + e.getMessage());  
	          } finally {  
	              try {  
	                  if (reader != null)  
	                      reader.close();  
	              } catch (IOException e) {  
	              }  
	         }  
	          return null;  
	      }  
}
