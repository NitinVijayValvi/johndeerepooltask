package com.yash.ems.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {

	
	private int statuscode;
	private Date date;
	private HttpStatus errorHttpStatus;
	private String errormsgString;
	private String pathString;
	public ApiError() {}
	public ApiError(int statuscode, Date date, HttpStatus errorHttpStatus, String errormsgString, String pathString) {
		super();
		this.statuscode = statuscode;
		this.date = date;
		this.errorHttpStatus = errorHttpStatus;
		this.errormsgString = errormsgString;
		this.pathString = pathString;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public HttpStatus getErrorHttpStatus() {
		return errorHttpStatus;
	}
	public void setErrorHttpStatus(HttpStatus errorHttpStatus) {
		this.errorHttpStatus = errorHttpStatus;
	}
	public String getErrormsgString() {
		return errormsgString;
	}
	public void setErrormsgString(String errormsgString) {
		this.errormsgString = errormsgString;
	}
	public String getPathString() {
		return pathString;
	}
	public void setPathString(String pathString) {
		this.pathString = pathString;
	}
	
	
}
