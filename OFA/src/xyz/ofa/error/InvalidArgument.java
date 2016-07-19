package xyz.ofa.error;

public class InvalidArgument extends Exception {

	private static final long serialVersionUID = 5669953498515733663L;
	public InvalidArgument(){
		super("Invalid Arguments specified");
	}
	public InvalidArgument(String msg){
		super(msg);
	}
}
