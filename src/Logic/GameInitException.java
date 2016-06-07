package Logic;

/**
 * Exception that is thrown if there is a problem during game initialization.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
@SuppressWarnings("serial")
public class GameInitException extends RuntimeException {
	
	/**
	 * Message that is thrown when this exception occurs.
	 */
	private String message;
	
	public GameInitException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
