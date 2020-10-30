package Hangman;

import java.util.Arrays;

public class Scoreboard implements java.io.Serializable {

	public DoublyLinkedList<Player> scoreboard = new DoublyLinkedList<Player>();
	private int numPlayers;

	Player player;

	public Scoreboard() {
		this.numPlayers = 0;
	}

	public void addPlayer(String name) throws PlayerAlreadyExistsException {
		String newName = name.toLowerCase();
		if (this.scoreboard.getLength() == 0) {
			this.scoreboard.add(new Player(newName));
			this.numPlayers++;
		} else {
			for (int i = 0; i < this.scoreboard.getLength(); i++) {
				if (newName.compareTo(this.scoreboard.getElementAt(i).getName()) > 0) {
					this.scoreboard.add(new Player(newName));
				}
				else if (newName.compareTo(this.scoreboard.getElementAt(i).getName()) < 0) {
					this.scoreboard.add(new Player(newName), i);
				}
				else if (newName.compareTo(this.scoreboard.getElementAt(i).getName()) == 0) {
					throw new PlayerAlreadyExistsException(this.scoreboard.getElementAt(i).getName() + " already exist");
				}
			}
		}
	}

	public void gamePlayed(String name, Boolean winOrLose) {
		for (int i = 0; i < scoreboard.getLength(); i++) {
			if (scoreboard.getElementAt(i).getName().equals(name)) {
				scoreboard.getElementAt(i).incrementNumOfGamePlayed();
				scoreboard.getElementAt(i).incrementGamesWon();
			}
		}
	}

	public void displayAllPlayers() {
		System.out.println("Number of players: " + this.numPlayers);
		for (int i = 0; i < scoreboard.getLength(); i++) {
			System.out.println("Player has been added: " + scoreboard.getElementAt(i).getName() + " "
					+ scoreboard.getElementAt(i).getGamePlayed() + " " + scoreboard.getElementAt(i).getWins());
		}
	}

	private void sortList() {
		for (int i = 0; i < this.scoreboard.getLength(); i++) {
			Player player = this.scoreboard.getElementAt(i);
		}
	}

}