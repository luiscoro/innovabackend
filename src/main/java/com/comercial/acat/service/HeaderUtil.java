package com.comercial.acat.service;

import org.springframework.http.HttpHeaders;

public class HeaderUtil {

	 

	    private static final String APPLICATION_NAME = "INNOVA";

	    private HeaderUtil() {
	    }

	    public static HttpHeaders createAlert(String message, String param) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("X-" + APPLICATION_NAME + "-alert", message);
	        headers.add("X-" + APPLICATION_NAME + "-params", param);
	        return headers;
	    }

	    public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
	        return createAlert(APPLICATION_NAME + "." + entityName + ".created", param);
	    }

	    public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
	        return createAlert(APPLICATION_NAME + "." + entityName + ".updated", param);
	    }

	    public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
	        return createAlert(APPLICATION_NAME + "." + entityName + ".deleted", param);
	    }

	    public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("X-" + APPLICATION_NAME + "-error", "error." + errorKey);
	        headers.add("X-" + APPLICATION_NAME + "-params", entityName);
	        return headers;
	    }
}
