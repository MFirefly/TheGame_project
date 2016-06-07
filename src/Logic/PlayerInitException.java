package Logic;

/**
 * Exception that is thrown if there is a problem when initializing player.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
@SuppressWarnings("serial")
public class PlayerInitException extends RuntimeException{

	/**
	 * Message that is thrown when this exception occurs.
	 */
	private String message;

	public PlayerInitException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
