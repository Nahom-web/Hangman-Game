package Hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanTest {

	@Test
	void test() {
		Hangman hangman = new Hangman("Doorbell");
		
		assertEquals("Doorbell", hangman.getWordChosen(), "Test Case 1: getWordChossen");
		
		assertEquals(0, hangman.getNumOfGuesses(), "Test Case 1: getNumOfGuesses");
	}
	
	@Test
	void test2() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		Hangman hangman2 = new Hangman("Doorbell");
		
		assertEquals(true, hangman1.equals(hangman2), "Test Case 2: testing if two Hangman are equal");
		
		assertEquals(true, hangman2.equals(hangman1), "Test Case 2: testing if two Hangman are equal");
		
	}
	
	@Test
	void test3() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		Hangman hangman2 = new Hangman("Dish");
		
		assertEquals(false, hangman1.equals(hangman2), "Test Case 3: testing if two Hangman are not equal");
		
		assertEquals(false, hangman2.equals(hangman1), "Test Case 3: testing if two Hangman are not equal");
	}
	
	@Test
	void test4() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		Player hangman2 = new Player("Dish");
		
		assertEquals(false, hangman1.equals(hangman2), "Test Case 4: testing if one Hangman obj and a Player obk are not equal");
	}
	
	@Test
	void test5() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		char guess = 'o';
		
		assertEquals(true, hangman1.checkGuess(guess), "Test Case 5: testing if check guess returns true for correct guess");
	}
	
	@Test
	void test6() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		char guess = 't';
		
		assertEquals(false, hangman1.checkGuess(guess), "Test Case 6: testing if check guess returns false for a incorrect guess");
	}
	
	@Test
	void test7() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		char guess = 'o';
		
		hangman1.printUnderscores();
		
		hangman1.updateWordWithGuess(guess);
		
		assertEquals("_ o o _ _ _ _ _ ", hangman1.toString(), "Test Case 7: testing if toString returns correct output");
	}
	
	@Test 
	void test8() {
		Hangman hangman1 = new Hangman("Doorbell");
		
		//tesing num of hints > 1	
		
		assertEquals(true, hangman1.recieveHint(), "Test Case 8: testing if hint returns true since numOfHints is 0");
		
		//tesing num of hints > 1		
		hangman1.setNumOfHints(3);
		
		assertEquals(false, hangman1.recieveHint(), "Test Case 8: testing if hint returns false since numOfHints > 1");
		
		// testing receive hint after word is solved
		
		Hangman hangman2 = new Hangman("lollipop");
		
		hangman2.updateWordWithGuess('l');
		hangman2.updateWordWithGuess('o');
		hangman2.updateWordWithGuess('i');
		hangman2.updateWordWithGuess('p');
		
		assertEquals(false, hangman2.recieveHint(), "Test Case 8: testing if hint returns false since word is complete");
		
		// testing receive hint after word isn't solved
		
		Hangman hangman3 = new Hangman("jack-o-lantern");
		
		hangman3.updateWordWithGuess('l');
		hangman3.updateWordWithGuess('o');
		
		assertEquals(true, hangman3.recieveHint(), "Test Case 8: testing if hint returns false since word is not complete");
		
	}
	
	@Test 
	void test9() {
		Hangman hangman1 = new Hangman("werewolf");
		
		//tesing isGameWon when word isn't solved
		
		hangman1.updateWordWithGuess('w');
		
		assertEquals(false, hangman1.isGameWon(), "Test Case 9: testing if isGameWon would return false if word isn't complete");
		
		Hangman hangman2 = new Hangman("werewolf");
		
		
		//tesing isGameWon when word isn't solved
		
		hangman2.updateWordWithGuess('w');
		hangman2.updateWordWithGuess('e');
		hangman2.updateWordWithGuess('r');
		hangman2.updateWordWithGuess('o');
		hangman2.updateWordWithGuess('l');
		hangman2.updateWordWithGuess('f');
		
		assertEquals(true, hangman2.isGameWon(), "Test Case 9: testing if isGameWon would return false if word is complete");
	}
	
	@Test
	void test10() {
		Hangman hangman1 = new Hangman("sweets");
		
		hangman1.setNumOfGuesses(6);
		
		assertEquals(true, hangman1.isGameLose(), "Test Case 10: testing isGameLose when num of guesses is == 6");
		
		Hangman hangman2 = new Hangman("zombie");
		
		hangman2.setNumOfGuesses(3);
		
		assertEquals(false, hangman2.isGameLose(), "Test Case 10: testing isGameLose when num of guesses is == 3");		
	}
}