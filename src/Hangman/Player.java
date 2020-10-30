package Hangman;

public class Player implements java.io.Serializable {

	public String name;
	public int wins;
	public int gamePlayed;

	public Player() {
		this.name = "Unknown";
		this.wins = 0;
		this.gamePlayed = 0;
	}

	public Player(String n) {
		this.name = n;
		this.wins = 0;
		this.gamePlayed = 0;
	}

	public Player(String n, int w, int gp) {
		this.name = n;
		this.wins = w;
		this.gamePlayed = gp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getGamePlayed() {
		return gamePlayed;
	}

	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}

	public void incrementNumOfGamePlayed() {
		this.gamePlayed++;
	}

	public void incrementGamesWon() {
		this.wins++;
	}

	public boolean checkName(String name) {
		if (name.length() == 0) {
			return false;
		} else {
			return true;
		}
	}
}