package Logic;

/**
 * Enum that represents all board-type games
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public enum BoardGameType {

	ConnectFour("ConnectFour"),
	REVERSI("Reversi"), 
	TicTacToe("TicTacToe");

	private String name;
	
	BoardGameType(String name) {
		this.name = name;
	}

}
