package Logic;

/**
 * Class that we want to extend from if we want to create special factory for
 * objects of BoardPlayer type.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public abstract class BoardPlayerFactory {

	public BoardPlayerFactory() {

	}

	/**
	 * Method that returns reference on object of type BoardPlayer. It
	 * implements Abstract Factory design pattern. Based on input parameters it
	 * creates some of the concrete implementations of BoardPlayer class.
	 * 
	 * @param game
	 *            - game object for which BoardPlayer object is created
	 * @param name
	 *            - player name
	 * @param mark
	 *            - player mark
	 * @param score
	 *            - player score
	 * @return object of concrete BoardPlayer implementation
	 */
	abstract BoardPlayer createPlayer(BoardGame game, String name, char mark, int score);

}
