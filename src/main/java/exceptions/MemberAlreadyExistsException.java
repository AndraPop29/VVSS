package exceptions;

public class MemberAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberAlreadyExistsException() {
		super("Member already exists");
	}
	
}
