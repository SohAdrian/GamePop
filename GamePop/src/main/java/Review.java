
public class Review {

	protected String gameName;
	
	public Review(String gameName, String username, Number rating, String comment) {
		super();
		this.gameName = gameName;
		this.username = username;
		this.rating = rating;
		this.comment = comment;
	}
	
	
	protected String username;
	protected Number rating;
	protected String comment;

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the rating
	 */
	public Number getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Number rating) {
		this.rating = rating;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
