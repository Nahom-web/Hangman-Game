package Hangman;

import java.util.Iterator;
import java.util.Random;

public class Hangman implements java.io.Serializable {

	private SinglyLinkedList<Character> lettersFromWord = new SinglyLinkedList<Character>(); // all the letters in the
																								// // word
	private SinglyLinkedList<Character> guessedLetters = new SinglyLinkedList<Character>(); // letters guessed in
																							// the word

	private SinglyLinkedList<Character> availableLetters = new SinglyLinkedList<Character>(); // letters that are
																								// available to give a
																								// hint

	public String wordChosen;

	private Character[] charactersinWord;

	private int numOfHints;

	private int numOfGuesses;

	public Hangman() {
		this.numOfGuesses = 0;
		this.numOfHints = 0;
		this.wordChosen = "";
	}

	public Hangman(String word) {
		guessedLetters.emptyList();
		lettersFromWord.emptyList();
		availableLetters.emptyList();
		this.numOfGuesses = 0;
		this.numOfHints = 0;
		this.wordChosen = word;
		charactersinWord = new Character[this.wordChosen.length()];
		populateLettersInWord();
	}

	public int getNumOfGuesses() {
		return numOfGuesses;
	}

	public void setNumOfGuesses(int numOfGuesses) {
		this.numOfGuesses = numOfGuesses;
	}

	public String getWordChosen() {
		return wordChosen;
	}

	public void setWordChosen(String wordChosen) {
		this.wordChosen = wordChosen;
	}

	public int getNumOfHints() {
		return numOfHints;
	}

	public void setNumOfHints(int numOfHints) {
		this.numOfHints = numOfHints;
	}

	public String getCharactersinWord() {
		String txt = "";
		for (int i = 0; i < this.charactersinWord.length; i++) {
			txt += charactersinWord[i];
		}
		return txt;
	}

	public void setCharactersinWord(Character[] charactersinWord) {
		this.charactersinWord = charactersinWord;
	}

	public boolean equals(Object o) {
		if ((o == null) || (!(o instanceof Hangman))) {
			return false;
		}

		if (((Hangman) o).getWordChosen() == (this.getWordChosen())) {
			return true;
		}

		else
			return false;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < charactersinWord.length; i++) {
			str += charactersinWord[i] + " ";
		}
		return str;
	}

	public void quitGame() {
		System.exit(-1);
	}

	public boolean canHint() {
		if (this.numOfGuesses < 6) {
			return false;
		} else {
			return false;
		}
	}

	public boolean recieveHint() {

		this.numOfHints++;
		this.numOfGuesses++;

		if (!isGameWon()) {
			if (this.numOfHints <= 1) {
				int randomIndex = (int) (Math.random() * this.availableLetters.getLength());
				this.guessedLetters.add(this.availableLetters.getElementAt(randomIndex));
				updateWordWithGuess(this.availableLetters.getElementAt(randomIndex));
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean checkIfGuessWasGuessed(char guess) {
		if (this.guessedLetters.getLength() == 0) {
			this.guessedLetters.add(guess);
			return true;
		} else {
			for (int i = 0; i < this.guessedLetters.getLength(); i++) {
				if (this.guessedLetters.getElementAt(i) == guess) {
					return false;
				}
			}
			this.guessedLetters.add(guess);
			return true;
		}
	}

	public boolean checkGuess(char guess) {
		for (int i = 0; i < this.lettersFromWord.getLength(); i++) {
			if (this.lettersFromWord.getElementAt(i) == guess) {
				return true;
			}
		}
		this.numOfGuesses++;
		return false;
	}

	public String updateWordWithGuess(char guess) {
		for (int i = 0; i < this.lettersFromWord.getLength(); i++) {
			if (this.lettersFromWord.getElementAt(i) == guess) {
				charactersinWord[i] = guess;
			}
		}

		for (int i = 0; i < this.availableLetters.getLength(); i++) {
			if (this.availableLetters.getElementAt(i) == guess) {
				availableLetters.remove(i);
			}
		}
		return toString();
	}

	public boolean isGameWon() {
		for (int i = 0; i < this.lettersFromWord.getLength(); i++) {
			if (lettersFromWord.getElementAt(i) != this.charactersinWord[i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isGameLose() {
		if (this.numOfGuesses == 6) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkName(String name) {
		Player playerObj = new Player();
		return playerObj.checkName(name);
	}

	public String printUnderscores() {
		String txt = "";
		for (int i = 0; i < this.lettersFromWord.getLength(); i++) {
			if (Character.isLetter(this.lettersFromWord.getElementAt(i))) {
				charactersinWord[i] = '_';
				txt += charactersinWord[i] + " ";
			} else {
				charactersinWord[i] = this.lettersFromWord.getElementAt(i);
				txt += charactersinWord[i] + " ";
			}
		}
		return txt;
	}

	public void populateLettersInWord() {
		for (int i = this.wordChosen.length() - 1; i >= 0; i--) {
			char l = getWordChosen().charAt(i);
			lettersFromWord.add(l);
			availableLetters.add(l);
		}
	}

}