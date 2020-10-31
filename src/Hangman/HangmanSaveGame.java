package Hangman;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HangmanSaveGame {

	private String filenameSaveGame;
	private String filenamePlayers;

	public HangmanSaveGame() {
		filenameSaveGame = "savedGame.txt";
		filenamePlayers = "players.txt";
	}

	public void saveGame(Hangman game) {
		Hangman saveGame = game;
		try {
			FileOutputStream file = new FileOutputStream(filenameSaveGame);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(saveGame);
			out.close();
			file.close();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public Hangman resumeGame() throws Exception {
		Hangman obj = null;
		try {
			FileInputStream file = new FileInputStream(filenameSaveGame);
			ObjectInputStream in = new ObjectInputStream(file);
			obj = (Hangman) in.readObject();
			in.close();
			file.close();

		} catch (IOException ex) {
			ex.getMessage();
		}

		return obj;
	}

	public void savePlayers(DoublyLinkedList<Player> scoreboard) {
		try {
			FileOutputStream file = new FileOutputStream(filenamePlayers);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(scoreboard);
			out.close();
			file.close();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public DoublyLinkedList<Player> readPlayers() throws ClassNotFoundException {
		DoublyLinkedList<Player> players = null;
		try {
			FileInputStream file = new FileInputStream(filenamePlayers);
			ObjectInputStream in = new ObjectInputStream(file);
			players = (DoublyLinkedList<Player>) in.readObject();
			in.close();
			file.close();
		} catch (IOException ex) {
			ex.getMessage();
		}

		return players;
	}

}
