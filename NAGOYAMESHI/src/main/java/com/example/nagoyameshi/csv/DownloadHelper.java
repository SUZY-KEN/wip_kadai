package com.example.nagoyameshi.csv;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class DownloadHelper {
	
	   private static final String CONTENT_DISPOSITION_FORMAT = "attachment; filename=\"%s\"; filename*=UTF-8''%s";
	    
	    public void addContentDisposition(HttpHeaders headers, String fileName)
	            throws UnsupportedEncodingException 
	    {
	        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");
	        String headerValue = String.format(CONTENT_DISPOSITION_FORMAT,fileName, encodedFileName);
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, headerValue);
	    }
	    

}
