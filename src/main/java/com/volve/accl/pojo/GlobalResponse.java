package com.volve.accl.pojo;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalResponse {
	private String statusCode;
	private String statusMessage;
	private String zoneDateTime = ZonedDateTime.now(ZoneId.of("Z")).toString();
	private Object data;

	public GlobalResponse(String statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public GlobalResponse(String statusCode, String statusMessage, Object data) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getZoneDateTime() {
		return zoneDateTime;
	}

	public void setZoneDateTime(String zoneDateTime) {
		this.zoneDateTime = zoneDateTime;
	}
	
}
