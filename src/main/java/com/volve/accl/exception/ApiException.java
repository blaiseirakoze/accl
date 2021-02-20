package com.volve.accl.exception;

public class ApiException {
    private String error;
    private String HttpStatus;
    private String ZoneDateTime;

    public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getHttpStatus() {
        return HttpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        HttpStatus = httpStatus;
    }

    public String getZoneDateTime() {
        return ZoneDateTime;
    }

    public void setZoneDateTime(String zoneDateTime) {
        ZoneDateTime = zoneDateTime;
    }

}