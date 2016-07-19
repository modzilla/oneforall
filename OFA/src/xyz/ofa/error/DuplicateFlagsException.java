package xyz.ofa.error;

public class DuplicateFlagsException extends Exception {
	public DuplicateFlagsException(){
		super("Duplicated Flags in the registered Flags");
	}
}
