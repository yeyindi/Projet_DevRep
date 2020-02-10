package devrep.project.exception;

public class ConfNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1256118768325073677L;

	public ConfNotFoundException(Long id) {
	    super("Could not find conf with id" + id);
	}

}
