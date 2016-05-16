package Logic;

/**
 * Represents board player
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public abstract class BoardPlayer extends Player{

	/**
	 * Mark that player BoardType uses for the game
	 */
	private char mark;

	public BoardPlayer(String name, char mark, int score) {
		super(name, score);
		this.mark = mark;
	}

	/**
	 * Method that returns value of mark attribute
	 * 
	 * @return value of attribute mark
	 */
	public char getMark() {
		return this.mark;
	}
}
