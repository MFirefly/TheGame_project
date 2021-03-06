package Logic;

/**
 * Class that is used for creating concrete implementation of BoardPlayer class,
 * but it is not a human being, ie. it is the object of BoardPlayerDroid class
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public class BoardPlayerFactoryDroid extends BoardPlayerFactory{
	
	public BoardPlayerFactoryDroid() {
		
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
	@Override
	public BoardPlayer createPlayer(BoardGame game, String name, char mark, int score) {
		// TODO Auto-generated method stub
		return null;
	}

}
