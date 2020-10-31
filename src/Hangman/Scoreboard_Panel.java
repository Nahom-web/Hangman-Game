package Hangman;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class Scoreboard_Panel extends JPanel {

	private JTextArea areaDisplay;
	private int lineLength = 10;
	private int indent = 2;
	HangmanSaveGame hangmanSaveGame;
	Scoreboard scoreboard;

	/**
	 * Create the panel.
	 * 
	 * @throws ClassNotFoundException
	 */
	public Scoreboard_Panel() throws ClassNotFoundException {
		hangmanSaveGame = new HangmanSaveGame();
		scoreboard = new Scoreboard();

		setBackground(Color.BLUE);
		areaDisplay = new JTextArea(15, 45);
		areaDisplay.setBackground(new Color(255, 255, 255));
		areaDisplay.setEditable(false);
		areaDisplay.setFont(new Font("Courier New", 0, 11));
		add(new JScrollPane(areaDisplay), BorderLayout.CENTER);
		displayPlayers();
	}

	private void displayPlayers() throws ClassNotFoundException {

		String title = "All Players";
		String underline = "-----------";
		lineLength = 40;

		int titleEnd = (lineLength / 2) + (title.length() / 2);

		areaDisplay.setText(String.format("%" + indent + "s%" + titleEnd + "s\n", " ", title));
		areaDisplay.append(String.format("%" + indent + "s%" + titleEnd + "s\n", " ", underline, " "));
		areaDisplay.append(String.format("%" + indent + "s", " "));

		areaDisplay.append(String.format("%-17s%-8s%-3s\n", "NAME:", "WINS:", "GAMES PLAYED:"));

		for (int i = 0; i < lineLength; ++i)
			areaDisplay.append("-");
		areaDisplay.append("\n");

		if (hangmanSaveGame.readPlayers() != null) {
			scoreboard.scoreboard = hangmanSaveGame.readPlayers();
			for (int i = 0; i < scoreboard.scoreboard.getLength(); i++) {
				Player player = scoreboard.scoreboard.getElementAt(i);
				areaDisplay.append(String.format("%-19s%-8s%-3s\n", i + 1 + " " + player.getName(), player.getWins(),
						player.getGamePlayed()));
			}
		}
	}

}