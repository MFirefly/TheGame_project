package Logic;

/**
 * Exception that is thrown if there is a problem when starting the game.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
@SuppressWarnings("serial")
public class GameStartedException extends RuntimeException {

	/**
	 * Message that is thrown when this exception occurs.
	 */
	private String message;

	public GameStartedException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
