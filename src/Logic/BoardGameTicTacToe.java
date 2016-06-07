package Logic;

import java.util.ArrayList;

/**
 * The game that is a part of Board-type game. TicTacToe is played on a board of
 * size 3x3. There are two players that play. Players exchange in setting their
 * own marks on the board. The first player that sets three own marks
 * vertically, horizontally or diagonally on the board, wins the game.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public class BoardGameTicTacToe implements BoardGame {

	private final int BOARD_ROWS = 3;
	private final int BOARD_COLUMNS = 3;
	private final int NUMBER_OF_PLAYERS = 2;

	private int playerOnMove;
	private int[][] board;
	boolean gameStarted;
	private int movesLeft;
	private int winner;
	private int numberOfPlayers;
	ArrayList<BoardPlayer> players;

	public BoardGameTicTacToe(int playerOnMove) {
		this.playerOnMove = playerOnMove;
		this.board = new int[BOARD_ROWS][BOARD_COLUMNS];
		this.players = new ArrayList<BoardPlayer>();
		this.gameStarted = false;
		this.movesLeft = BOARD_COLUMNS * BOARD_ROWS;
		this.playerOnMove = 1;
		this.winner = 0;
		this.numberOfPlayers = NUMBER_OF_PLAYERS;
	}

	/**
	 * Method that checks if there is a winner
	 * 
	 * @return true if there is a winner, false otherwise
	 */
	private boolean checkIfThereIsAWinner(int row, int column) {
		/* Check column */
		for (int i = 0; i < BOARD_COLUMNS; i++) {
			if (board[row][i] != this.playerOnMove) {
				break;
			}
			if (i == this.BOARD_COLUMNS - 1) {
				this.winner = this.playerOnMove;
			}
		}

		/* Check row */
		for (int i = 0; i < BOARD_ROWS; i++) {
			if (board[i][column] != this.playerOnMove) {
				break;
			}
			if (i == this.BOARD_ROWS - 1) {
				this.winner = this.playerOnMove;
			}
		}

		/* Check diagonal */
		if (row == column) {
			for (int i = 0; i < BOARD_ROWS; i++) {
				if (board[i][i] != this.playerOnMove) {
					break;
				}
				if (i == this.BOARD_ROWS - 1) {
					this.winner = this.playerOnMove;
				}
			}
		}

		/* Check anti-diagonal */
		for (int i = 0; i < BOARD_ROWS; i++) {
			if (board[i][(BOARD_ROWS - i) - 1] != this.playerOnMove) {
				break;
			}
			if (i == this.BOARD_ROWS - 1) {
				this.winner = this.playerOnMove;
			}
		}

		if (this.winner != 0) {
			this.movesLeft = 0;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that check if entered move is legal
	 * 
	 * @param move
	 *            argument that needs to be checked
	 * @return true if the move is legal, false otherwise
	 */
	private boolean legalMove(int move) {
		if (move >= 1 && move <= 9) {
			return true;
		}
		return false;
	}

	/**
	 * Method that returns mark on specific position on the board
	 * 
	 * @param boardPosition
	 *            position for which the mark is requested
	 * @return mark on that position
	 */
	public char getMark(int boardPosition) {
		int row = getRow(boardPosition);
		int column = getColumn(boardPosition);
		if (this.board[row][column] == 1) {
			return ((BoardPlayer)this.getPlayer(1)).getMark();
		} else if (this.board[row][column] == 2) {
			return ((BoardPlayer)this.getPlayer(2)).getMark();
		} else {
			return '-';
		}

	}

	/**
	 * Method that changes active player.
	 */
	private void traverseActivePlayer() {
		if (this.playerOnMove == 1) {
			this.playerOnMove = 2;
		} else {
			this.playerOnMove = 1;
		}
	}
	
	/**
	 * Method that calculates matrix row number
	 * @param position that is checked
	 * @return calculated row value
	 */
	private int getRow(int position) {
		return ((position - 1) / this.BOARD_ROWS);
	}
	
	/**
	 * Method that calculated matrix column number
	 * @param position that is checked
	 * @return calculated column value
	 */
	private int getColumn(int position) {
		return ((position - 1) % this.BOARD_ROWS);
	}
	

	/**
	 * Method that adds player into game. Method returns the number under which
	 * the player is added or zero if player couldn't have been added to the
	 * game, i.e. if all the players are already added to the game.
	 * 
	 * @param player
	 *            player that we are adding to the game
	 * @return number under which the player is added to the game or zero if all
	 *         places are filled
	 */
	@Override
	public int addPlayer(BoardPlayer player) {
		if (this.players.size() < this.NUMBER_OF_PLAYERS) {
			this.players.add(player);
			this.numberOfPlayers--;
			return this.players.indexOf(player);
		}
		return 0;
	}

	/**
	 * Method that returns player which turn it is to play.
	 * 
	 * @return reference to object of type Player, which turn is to play.
	 */
	@Override
	public Player getActivePlayer() {
		return this.players.get(this.playerOnMove - 1);
	}

	/**
	 * Method that returns appearance of the board for Board-type game.
	 * 
	 * @return String that represents board appearance.
	 */
	@Override
	public String getBoardHelp() {
		return "-------------\n" + "| 1 | 2 | 3 |\n" + "-------------\n" + "| 4 | 5 | 6 |\n" + "-------------\n"
				+ "| 7 | 8 | 9 |\n" + "-------------";
	}

	/**
	 * Method that returns current status of the board - occupancy of each field
	 * of the board.
	 * 
	 * @return array of Players
	 */
	@Override
	public Player[][] getBoardStatus() {
		Player[][] boardStatus = new Player[BOARD_ROWS][BOARD_COLUMNS];
		for (int i = 0; i < boardStatus.length; i++) {
			for (int j = 0; j < boardStatus[i].length; j++) {
				if(this.board[i][j] == 1) {
					boardStatus[i][j] = this.getPlayer(1);
				} else if (this.board[i][j] == 2) {
					boardStatus[i][j] = this.getPlayer(2);
				}
			}
		}
		return boardStatus;
	}

	/**
	 * Returns maximum number of players allowed in the game.
	 * 
	 * @return maximum number of players
	 */
	@Override
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}

	/**
	 * Method returns a player under the given number. If that player doesn't
	 * exists null is returned.
	 * 
	 * @param playerNo
	 *            - number of the player to be returned
	 * @return player under the given number or null if it doesn't exist
	 */
	@Override
	public Player getPlayer(int playerNo) {
		Player player;
		try {
			player = this.players.get(playerNo - 1);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}

		return player;
	}

	/**
	 * Returns reference to object of String class that contains rules of the
	 * game.
	 * 
	 * @return String class object that contains rules of the game.
	 */
	@Override
	public String getRules() {
		return "\nThe object of Tic Tac Toe game is to get three in a row.\n"
				+ "You play on a three by three game board. The first player\n"
				+ "is known by 'X' and the second is 'O'. Players alternate\n"
				+ "placing Xs and Os on the game board until either opponent\n"
				+ "has three in a row or all nine squares are filled.\n";
	}

	/**
	 * Method that returns the reference to Player object that is the winner of
	 * the game, if it exists. If there is no winner of the game (tie), method
	 * returns null.
	 * 
	 * @return reference to Player object that is the winner of the game.
	 */
	@Override
	public Player getWinner() {
		Player player;
		if (this.winner == 0) {
			return null;
		}

		try {
			player = this.players.get(this.winner - 1);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
		return player;
	}

	/**
	 * Method that checks if there are any free spaces left to play. We have
	 * free spaces if there is no winner and if it is not tie.
	 * 
	 * @return True if there are free spaces left, false otherwise.
	 */
	@Override
	public boolean hasMovesLeft() {
		if (this.movesLeft > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that does the move on the board.
	 * 
	 * @param move
	 *            position on which you want to set the move
	 * @return true if move is successful, false otherwise.
	 */
	@Override
	public boolean placeMove(int move) {
		if (this.legalMove(move)) {
			int row = this.getRow(move);
			int column = this.getColumn(move);
			if (this.board[row][column] == 0) {
				if (this.playerOnMove == 1) {
					this.board[row][column] = 1;
				} else {
					this.board[row][column] = 2;
				}
				this.movesLeft--;
				checkIfThereIsAWinner(row, column);
				traverseActivePlayer();
				return true;
			}
		}
		return false;
	}

	/**
	 * Method that resets the game by setting it in the game begin state. Method
	 * doesn't check if all players are initialized nor it removes players from
	 * the game itself. It sets the board game in its beginning state for
	 * playing and sets the player that starts the game.
	 * 
	 * @param playerNo
	 *            number of the player that starts the game
	 */
	@Override
	public void resetGame(int playerNo) {
		this.playerOnMove = playerNo;
		this.board = new int[BOARD_ROWS][BOARD_COLUMNS];
		this.gameStarted = false;
		this.movesLeft = BOARD_COLUMNS * BOARD_ROWS;
		this.playerOnMove = 1;
		this.winner = 0;
	}

	/**
	 * Method that starts the game, ie. puts it in active state.
	 */
	@Override
	public void startGame() {
		this.gameStarted = true;
	}
	
	

	@Override
	public String toString() {
		return "\n-------------\n" 
			+ "| " + this.getMark(1) + " | " + this.getMark(2) + " | " + this.getMark(3) + " |\n"
			+ "-------------\n" 
			+ "| " + this.getMark(4) + " | " + this.getMark(5) + " | " + this.getMark(6) + " |\n" 
			+ "-------------\n"
			+ "| " + this.getMark(7) + " | " + this.getMark(8) + " | " + this.getMark(9) + " |\n" 
			+ "-------------\n";
	}

	/**
	 * Represents Tic-Tac-Toe droid.
	 * 
	 * @author Maja Filakovic
	 * @version 0.1
	 *
	 */
	public class TicTacToeDroid extends BoardPlayerDroid {

		public TicTacToeDroid(String name, char mark, int score) {
			super(name, mark, score);
		}

		@Override
		public int getMove() {
			// TODO Implement method!
			return 0;
		}

	}

}
