package Logic;

/**
 * Represents droid that has characteristics of Board-type games and can play
 * Board-type games.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public abstract class BoardPlayerDroid extends BoardPlayer implements BoardDroid {

	public BoardPlayerDroid(String name, char mark, int score) {
		super(name, mark, score);
	}

	/**
	 * Method that returns the next move of droid on a board.
	 * 
	 * @return position of the next move on the board
	 */
	public abstract int getMove();
}
