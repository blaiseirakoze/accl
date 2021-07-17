package com.volve.accl.pojo;

public class AuthErrorResponse {
	private String statusCode;
    private String statusMessage;
    private String ZoneDateTime;
    
	public AuthErrorResponse(String statusCode, String statusMessage, String zoneDateTime) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		ZoneDateTime = zoneDateTime;
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
		return ZoneDateTime;
	}
	public void setZoneDateTime(String zoneDateTime) {
		ZoneDateTime = zoneDateTime;
	}
    
    
}
