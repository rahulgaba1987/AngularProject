package com.student.exception;

public class ResourceNotFoundException  extends RuntimeException
{
	
	 private String resourceName;
	 private String fieldName;
	 private int fieldId;
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldId) {
		super(String.format("%s not found with %s : %d", resourceName,fieldName,fieldId ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldId = fieldId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	@Override
	public String toString() {
		return "ResourceNotFoundException [resourceName=" + resourceName + ", fieldName=" + fieldName + ", fieldId="
				+ fieldId + "]";
	}
	
	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	 
	 

}
