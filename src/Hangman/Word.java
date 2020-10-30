package Hangman;

public class Word {

	private String word;
	private SinglyLinkedList<Character> lettersFromWord = new SinglyLinkedList<Character>(); // all the letters in the
	// // word

	public Word(String w) {
		this.word = w;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String w) {
		this.word = w;
	}

}