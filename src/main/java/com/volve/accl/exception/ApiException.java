package com.volve.accl.exception;

public class ApiException {
	private String statusCode;
    private String statusMessage;
    private String ZoneDateTime;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getZoneDateTime() {
        return ZoneDateTime;
    }

    public void setZoneDateTime(String zoneDateTime) {
        ZoneDateTime = zoneDateTime;
    }

}