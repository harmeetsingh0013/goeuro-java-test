/**
 * 
 */
package com.harmeetsingh13.exceptions;

/**
 * @author Harmeet Singh(Taara)
 *
 */
public class NotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5650524884055006914L;

	private String errorCode;
	
	public NotFound(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}
}
