package Logic;

/**
 * Class that based on the input parameters, creates one of the possible games.
 * It implements simple factory design pattern with purpose to hide concrete
 * implementations of the games.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public abstract class BoardGameFactory {

	public BoardGameFactory() {

	}

	/**
	 * Method that based on the input parameters, creates one of the possible
	 * games.
	 * 
	 * @param type
	 *            type that represents one of the games
	 * @return reference to an object of the created game
	 */
	public static BoardGame createGame(BoardGameType type) {
		if(type == BoardGameType.TicTacToe) {
			return new BoardGameTicTacToe(1);
		}
		return null;
	}

}
