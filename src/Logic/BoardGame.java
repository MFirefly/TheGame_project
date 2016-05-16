package Logic;

/**
 * BoardGame interface represents all games that belong to Board-type games.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public interface BoardGame {

	/**
	 * Method that adds player into game. Method returns the number under which
	 * the player is added or zero if player couldn't have been added to the
	 * game, ie. if all the players are already added to the game.
	 * 
	 * @param player
	 *            - player that we are adding to the game
	 * @return number under which the player is added to the game or zero if all
	 *         places are filled
	 */
	public int addPlayer(BoardPlayer player);

	/**
	 * Method that returns player which turn it is to play.
	 * 
	 * @return reference to object of type Player, which turn is to play.
	 */
	public Player getActivePlayer();

	/**
	 * Method that returns appearance of the board for Board-type game.
	 * 
	 * @return String that represents board appearance.
	 */
	public String getBoardHelp();

	/**
	 * Method that return current status of the board - occupancy of each field
	 * of the board.
	 * 
	 * @return array of Players
	 */
	public Player[][] getBoardStatus();

	/**
	 * Returns maximum number of players allowed in the game.
	 * 
	 * @return maximum number of players
	 */
	public int getNumberOfPlayers();

	/**
	 * Method returns a player under the given number. If that player doesn't
	 * exists null is returned.
	 * 
	 * @param playerNo
	 *            - number of the player to be returned
	 * @return player under the given number or null if it doesn't exist
	 */
	public Player getPlayer(int playerNo);

	/**
	 * Returns reference to object of String class that contains rules of the
	 * game.
	 * 
	 * @return String class object that contains rules of the game.
	 */
	public String getRules();

	/**
	 * Method that returns the reference to Player object that is the winner of
	 * the game, if it exists. If there is no winner of the game (tie), method
	 * returns null.
	 * 
	 * @return reference to Player object that is the winner of the game.
	 */
	public Player getWinner();

	/**
	 * Method that checks if there are any free spaces left to play. We have
	 * free spaces if there is no winner and if it is not tie.
	 * 
	 * @return True if there are free spaces left, false otherwise.
	 */
	public boolean hasMovesLeft();

	/**
	 * Method that does the move on the board.
	 * 
	 * @param move
	 *            - position on which you want to set the move
	 * @return true if move is successful, false otherwise.
	 */
	public boolean placeMove(int move);

	/**
	 * Method that resets the game by setting it in the game begin state. Method
	 * doesn't check if all players are initialized nor it removes players from
	 * the game itself. It sets the board game in its beginning state for
	 * playing and sets the played that starts the game.
	 * 
	 * @param playerNo
	 *            - number of the player that starts the game
	 */
	public void resetGame(int playerNo);

	/**
	 * Method that starts the game, ie. puts it in active state.
	 */
	public void startGame();

}
