package Hangman;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

//		HangmanWordList hangmanWordList = new HangmanWordList();
//
//		Hangman game = new Hangman(hangmanWordList.recieveAWord());
//
//		System.out.println("Word: " + game.printUnderscores());
//
//		String guess = input.nextLine();
//
//		if (game.checkIfGuessWasGuessed(guess.charAt(0))) {
//			if (game.checkGuess(guess.charAt(0))) {
//				System.out.println(game.updateWordWithGuess(guess.charAt(0)));
//			} else {
//				System.out.println("Not in word");
//			}
//		} else {
//			System.out.println("Already Guessed");
//		}
		
		Scoreboard board = new Scoreboard();
//		
//		board.addPlayer("Ashley");
//		board.addPlayer("Nahom");
//		board.addPlayer("Ben");
//		
//		for(int i = 0; i < board.scoreboard.getLength(); i++)
//			System.out.println(board.scoreboard.getElementAt(i).getName());
		
		
		System.out.println("Hello");

	}

}
