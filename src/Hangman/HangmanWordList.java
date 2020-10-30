package Hangman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HangmanWordList {

	private SinglyLinkedList<Word> wordList = new SinglyLinkedList<Word>();
	private String filename;

	public HangmanWordList() {
		this.filename = "dictionary.txt";
		readFile();
	}

	public void readFile() {
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNextLine()) {
				String inLine = input.nextLine();
				StringTokenizer tokens = new StringTokenizer(inLine, "\n");
				while (tokens.hasMoreTokens()) {
					wordList.add(new Word(tokens.nextToken().toLowerCase()));
				}
			}
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public String recieveAWord() {
		int randomIndex = (int) (Math.random() * wordList.getLength());
		removeWordFromList(wordList.getElementAt(randomIndex).getWord());
		return wordList.getElementAt(randomIndex).getWord();
	}

	public void removeWordFromList(String word) {
		for (int i = 0; i < this.wordList.getLength(); i++) {
			Word word1 = this.wordList.getElementAt(i);
			if (word1.getWord() == word) {
				this.wordList.remove(i);
			}
		}
	}

}