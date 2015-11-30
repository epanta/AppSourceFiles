package com.goeuro.search.locations.connection;

import java.io.*;

import javax.net.ssl.*;

import com.goeuro.search.locations.Main;

import java.net.*;


public class GoEuroConnection {
	
	public void myHostVerifier(){
		HostnameVerifier hv = new HostnameVerifier() {
			
			@Override
			public boolean verify(String hostname, SSLSession session) {
				// TODO Auto-generated method stub
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}
	

	public String goEuroURL(String url){
			GoEuroConnection geConnection = new GoEuroConnection();
			geConnection.myHostVerifier();
			StringBuilder sBuilder = null;
			
		try {
			
			System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
			System.setProperty("javax.net.ssl.keyStoreType", "JKS");  
			System.setProperty("javax.net.ssl.keyStore", Main.config.getProperty("CERT_DIG"));  
			System.setProperty("javax.net.ssl.keyStorePassword", "123456");
			
			System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
			System.setProperty("javax.net.ssl.trustStore", Main.config.getProperty("CERT_DIG"));  
			System.setProperty("javax.net.ssl.trustStorePassword", "123456");
			
			URL	endPoint = new URL(url);
			BufferedReader brd = new BufferedReader(new InputStreamReader(endPoint.openStream()));
			
			String goEuroJsonReturn;

			sBuilder = new StringBuilder();
			
			while ((goEuroJsonReturn = brd.readLine()) != null) {
				sBuilder.append(goEuroJsonReturn);
			}

			brd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sBuilder.toString();
		
	}

}
