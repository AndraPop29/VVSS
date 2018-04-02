package exceptions;

public class MemberDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberDoesNotExistException() {
		super("Member does not exist!");
	}
	
}
