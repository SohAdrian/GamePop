
public class Game {

	protected String gameName;

	public Game(String gameName, String gamePicture, String gameDescription, String genre) {
		super();
		this.gameName = gameName;
		this.gamePicture = gamePicture;
		this.gameDescription = gameDescription;
		this.genre = genre;
	}

	protected String gamePicture;

	protected String gameDescription;

	protected String genre;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGamePicture() {
		return gamePicture;
	}

	public void setGamePicture(String gamePicture) {
		this.gamePicture = gamePicture;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
