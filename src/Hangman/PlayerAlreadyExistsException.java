package Hangman;

public class PlayerAlreadyExistsException extends RuntimeException {

	public PlayerAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
