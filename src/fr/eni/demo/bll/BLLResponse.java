package fr.eni.demo.bll;

import fr.eni.demo.dal.DAOBase;

public class BLLResponse<T> {

	private int code;
	private String message;
	
	// Tout les possbilités
	private Object object = null;
	
	public BLLResponse() {
		
	}
	
	public BLLResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public BLLResponse(int code, String message, Object object) {
		super();
		this.code = code;
		this.message = message;
		this.object = object;
	}
	
	public boolean isSuccess() {
		return (code >= 200 && code < 300);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public <T> T getObject() {
		return (T) object;
	}

	public <E> E getObjectByClass(Class<E> type) {
		return (E) object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
