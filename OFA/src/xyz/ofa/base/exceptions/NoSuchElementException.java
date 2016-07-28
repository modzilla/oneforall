package xyz.ofa.base.exceptions;

public class NoSuchElementException extends Exception {
	public NoSuchElementException(String name){
		super("Element with the name/symbol " + name + " does not exist");
	}
	public NoSuchElementException(int number){
		super("Element with the atomic number " + number + " does not exist");
	}
}
