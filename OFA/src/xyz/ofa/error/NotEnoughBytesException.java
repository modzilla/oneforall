package xyz.ofa.error;

public class NotEnoughBytesException extends Exception {
	public NotEnoughBytesException(int minBytes){
		super("byte[] length must be greater than " + minBytes);
	}
}
