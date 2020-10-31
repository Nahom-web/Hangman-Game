package Hangman;

public class Scoreboard implements java.io.Serializable {

	public DoublyLinkedList<Player> scoreboard = new DoublyLinkedList<Player>();
	private int numPlayers;

	Player player;

	public Scoreboard() {
		this.numPlayers = 0;
	}

	public void addPlayer(String name) throws PlayerAlreadyExistsException {
		boolean added = false;
		if (this.scoreboard.getLength() == 0) {
			this.scoreboard.add(new Player(name));
			this.numPlayers++;
		} else {
			for (int i = 0; i < this.scoreboard.getLength(); i++) {
				if (name.compareToIgnoreCase(this.scoreboard.getElementAt(i).getName()) < 0) {
					this.scoreboard.add(new Player(name), i);
					this.numPlayers++;
					added = true;
					break;
				} else if (name.compareToIgnoreCase(this.scoreboard.getElementAt(i).getName()) == 0) {
					throw new PlayerAlreadyExistsException(
							this.scoreboard.getElementAt(i).getName() + " already exist");
				}
			}

			if (added == false) {
				for (int i = 0; i < this.scoreboard.getLength(); i++) {
					if (name.compareToIgnoreCase(this.scoreboard.getElementAt(i).getName()) > 0) {
						this.scoreboard.add(new Player(name), i + 1);
						this.numPlayers++;
						break;
					}
				}
			}
		}
	}

	public void gamePlayed(String name, Boolean winOrLose) {
		for (int i = 0; i < scoreboard.getLength(); i++) {
			if (scoreboard.getElementAt(i).getName().equals(name)) {
				if (winOrLose) {
					scoreboard.getElementAt(i).incrementGamesWon();
				}
				scoreboard.getElementAt(i).incrementNumOfGamePlayed();
			}
		}
	}
}