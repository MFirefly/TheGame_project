package Logic;

/**
 * Class that represents a player of the game.
 * 
 * @author Maja Filakovic
 * @version 0.1
 *
 */
public abstract class Player implements Comparable<Player> {

	/**
	 * Player name attribute
	 */
	private String name;
	/**
	 * Player score attribute - number of won games.
	 */
	private int score;

	public Player(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}

	/**
	 * Returns the value of attribute name
	 * 
	 * @return value of the name attribute
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets attribute name of the player to value name
	 * 
	 * @param name
	 *            value to set the name attribute
	 */
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	/**
	 * Returns the value of attribute score
	 * 
	 * @return value of the score attribute
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Sets attribute score of the player to value score
	 * 
	 * @param score
	 *            value to set the score attribute
	 */
	public void setScore(int score) {
		if (score >= 0) {
			this.score = score;
		}
	}

	/**
	 * Method that is used for comparing two objects of type Player. Needs to be
	 * implemented so sorting can be easier.
	 * 
	 * @param o
	 *            object that we compare with
	 * @return -1, 0 or 1, depending of the result of the comparison
	 */
	@Override
	public int compareTo(Player o) {
		return this.getName().compareTo(o.getName());
	}

	/**
	 * Method that is used for comparison with other objects of the Player class
	 * type. Players are the same if their names are the same
	 * 
	 * @param obj
	 *            object that we compare with
	 * @return true if they are same, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((Player) obj).getName());
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
