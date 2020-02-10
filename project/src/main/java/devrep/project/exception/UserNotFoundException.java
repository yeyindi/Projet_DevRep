package devrep.project.exception;

public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2301583711144758684L;

	public UserNotFoundException(Long id) {
		super("Could not find user with id "+id);
	}

}
