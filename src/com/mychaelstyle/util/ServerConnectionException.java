package com.mychaelstyle.util;

public class ServerConnectionException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * HTTP Response status
	 */
	private int status;

	/**
	 * Constructor
	 * @param status
	 */
	protected ServerConnectionException(int status){
		super("Server response error : "+status);
		this.status = status;
	}
	/**
	 * Constructor
	 */
	protected ServerConnectionException() {
		super();
	}

	/**
	 * Constructor
	 * @param detailMessage
	 */
	protected ServerConnectionException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * Constructor
	 * @param throwable
	 */
	protected ServerConnectionException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Constructor
	 * @param detailMessage
	 * @param throwable
	 */
	protected ServerConnectionException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status セットする status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}