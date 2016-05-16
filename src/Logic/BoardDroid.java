package Logic;

/**
 * Interface for droid that can play Board-type games.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public interface BoardDroid {

	/**
	 * Method that returns the next move of droid on a board.
	 * 
	 * @return position of the next move on the board
	 */
	public int getMove();
}
