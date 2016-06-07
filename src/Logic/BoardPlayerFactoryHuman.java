package Logic;

/**
 * Class that is used for creating concrete implementation of BoardPlayer class,
 * but it is not a human being, ie. it is the object of BoardPlayerHuman class
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public class BoardPlayerFactoryHuman extends BoardPlayerFactory {

	public BoardPlayerFactoryHuman() {
		
	}

	/**
	 * Method that returns reference on object of type BoardPlayer. It
	 * implements Abstract Factory design pattern. Based on input parameters it
	 * creates some of the concrete implementations of BoardPlayer class.
	 * 
	 * @param game
	 *            game object for which BoardPlayer object is created
	 * @param name
	 *            player name
	 * @param mark
	 *            player mark
	 * @param score
	 *            player score
	 * @return object of concrete BoardPlayer implementation
	 */
	@Override
	public BoardPlayer createPlayer(BoardGame game, String name, char mark, int score) {

		return new BoardPlayerHuman(name, mark, score);
	}

}
