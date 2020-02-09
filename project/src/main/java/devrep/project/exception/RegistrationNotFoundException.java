package devrep.project.exception;

public class RegistrationNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrationNotFoundException(Long id) {
	    super("Could not find registration with" + id);
	}

}
