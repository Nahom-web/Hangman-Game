package Hangman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

public class HangmanFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JMenuBar menuBar;
	private JMenu mnGame;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmScoreboard;
	private JMenuItem mntmSaveGame;
	private JMenuItem mntmQuitGame;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmRules;
	private JMenuItem mntmHint;

	private JPanel namePanel;
	private JLabel lblName;
	private JTextField fldName;
	private JButton btnSubmit;
	private JLabel lblReturningPlayer;
	private JComboBox comboBoxReturningPlayers;
	private JButton btnResumeGame;

	private JPanel gamePanel;
	private JLabel lblWelcome;
	private JLabel lblhangmanPicture;
	private JLabel lblHauntedHousePicture;
	private JLabel lblWordVal;

	private JPanel alphabetPanel;
	private JButton alphabet[][] = new JButton[2][13];

	HangmanWordList hangmanWordList;
	Hangman hangman;
	Scoreboard_Panel scoreboard_panel;
	Scoreboard scoreboard;
	HangmanSaveGame hangmanSaveGame;

	private String player = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangmanFrame frame = new HangmanFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	public HangmanFrame() throws ClassNotFoundException {
		setTitle("Hangman Game");
		setBackground(new Color(255, 140, 0));
		scoreboard = new Scoreboard();
		scoreboard_panel = new Scoreboard_Panel();
		hangmanWordList = new HangmanWordList();
		hangmanSaveGame = new HangmanSaveGame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 766);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 127, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnGame = new JMenu("Game");
		menuBar.add(mnGame);

		mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(this);
		mntmNewGame.setEnabled(false);
		mnGame.add(mntmNewGame);

		mntmScoreboard = new JMenuItem("Scoreboard");
		mntmScoreboard.addActionListener(this);
		mnGame.add(mntmScoreboard);

		mntmSaveGame = new JMenuItem("Save Game");
		mntmSaveGame.addActionListener(this);
		mntmSaveGame.setEnabled(false);
		mnGame.add(mntmSaveGame);

		mntmQuitGame = new JMenuItem("Quit Game");
		mntmQuitGame.addActionListener(this);
		mnGame.add(mntmQuitGame);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(this);
		mnHelp.add(mntmAbout);

		mntmRules = new JMenuItem("Rules");
		mntmRules.addActionListener(this);
		mnHelp.add(mntmRules);

		mntmHint = new JMenuItem("Hint");
		mntmHint.addActionListener(this);
		mntmHint.setEnabled(false);
		mnHelp.add(mntmHint);

		gamePanel = new JPanel();
		gamePanel.setBackground(new Color(255, 140, 0));
		gamePanel.setBounds(0, 149, 1003, 436);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);

		// made hangman 1 - 6 pictures myself using paint 3d

		lblhangmanPicture = new JLabel(new ImageIcon("hangman.png"));
		lblhangmanPicture.setBounds(10, 114, 264, 262);
		gamePanel.add(lblhangmanPicture);

		// https://pixabay.com/illustrations/halloween-haunted-house-graveyard-5658556/

		lblHauntedHousePicture = new JLabel(new ImageIcon("hauntedHouse.jpg"));
		lblHauntedHousePicture.setBounds(335, 65, 610, 247);
		gamePanel.add(lblHauntedHousePicture);

		lblWordVal = new JLabel("");
		lblWordVal.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblWordVal.setBounds(335, 345, 631, 69);
		gamePanel.add(lblWordVal);

		alphabetPanel = new JPanel();
		alphabetPanel.setLayout(new GridLayout(2, 13));
		alphabetPanel.setBackground(new Color(255, 255, 255));
		alphabetPanel.setBounds(0, 586, 1003, 121);
		contentPane.add(alphabetPanel);

		lblWelcome = new JLabel("");
		lblWelcome.setBounds(268, 61, 481, 45);
		contentPane.add(lblWelcome);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 32));

		namePanel = new JPanel();
		namePanel.setBounds(0, 0, 1003, 152);
		contentPane.add(namePanel);
		namePanel.setForeground(Color.WHITE);
		namePanel.setBackground(Color.BLACK);
		namePanel.setLayout(null);

		lblName = new JLabel("New Player:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(127, 32, 167, 33);
		namePanel.add(lblName);

		fldName = new JTextField();
		fldName.setBounds(253, 34, 207, 31);
		namePanel.add(fldName);
		fldName.setColumns(10);

		btnSubmit = new JButton("Join");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSubmit.setBackground(new Color(0, 0, 255));
		btnSubmit.setBounds(252, 92, 145, 38);
		btnSubmit.addActionListener(this);
		namePanel.add(btnSubmit);

		lblReturningPlayer = new JLabel("Returning Player:");
		lblReturningPlayer.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblReturningPlayer.setForeground(new Color(255, 255, 255));
		lblReturningPlayer.setBounds(555, 34, 207, 33);

		namePanel.add(lblReturningPlayer);

		comboBoxReturningPlayers = new JComboBox();
		comboBoxReturningPlayers.setBounds(737, 31, 175, 34);
		namePanel.add(comboBoxReturningPlayers);

		btnResumeGame = new JButton("Resume Game");
		btnResumeGame.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnResumeGame.setForeground(Color.WHITE);
		btnResumeGame.setBackground(Color.BLUE);
		btnResumeGame.setBounds(737, 92, 145, 38);
		btnResumeGame.addActionListener(this);
		namePanel.add(btnResumeGame);

		gamePanel.setVisible(false);
		alphabetPanel.setVisible(false);

		createAlphabetButtons();

		if (hangmanSaveGame.readPlayers() == null) {
			btnResumeGame.setEnabled(false);
		}

		else {
			scoreboard.scoreboard = hangmanSaveGame.readPlayers();
			for (int i = 0; i < scoreboard.scoreboard.getLength(); i++) {
				comboBoxReturningPlayers.addItem(scoreboard.scoreboard.getElementAt(i).getName());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmit) {
			startUp();
		}

		if (e.getSource() == mntmNewGame) {
			startNewGame();
		}

		if (e.getSource() == mntmSaveGame) {
			saveGame();
		}

		if (e.getSource() == mntmQuitGame) {
			quitGame();
		}

		if (e.getSource() == mntmHint) {
			hint();
		}

		if (e.getSource() == btnResumeGame) {
			try {
				player = comboBoxReturningPlayers.getSelectedItem().toString();
				resumeGame();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == mntmAbout) {
			JOptionPane.showMessageDialog(this, new About_Panel(), "About", JOptionPane.PLAIN_MESSAGE);
		}

		if (e.getSource() == mntmRules) {
			JOptionPane.showMessageDialog(this, new Rules_Panel(), "Rules", JOptionPane.PLAIN_MESSAGE);
		}
		if (e.getSource() == mntmScoreboard) {
			try {
				JOptionPane.showMessageDialog(this, new Scoreboard_Panel(), "Scoreboard", JOptionPane.PLAIN_MESSAGE);
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		enterGuess(e);
	}

	public void enterGuess(ActionEvent e) {

		for (int i = 0; i < alphabet.length; i++) {

			for (int j = 0; j < alphabet[i].length; j++) {

				if (e.getSource() == alphabet[i][j]) {

					if (hangman.isGameLose()) {
						JOptionPane.showMessageDialog(this, " Sorry you have guessed 6 letters wrong", "Lost!",
								JOptionPane.PLAIN_MESSAGE);
						scoreboard.gamePlayed(player, false);
						hangmanSaveGame.savePlayers(scoreboard.scoreboard);
						startNewGame();
					} else {

						char guess = alphabet[i][j].getText().toLowerCase().charAt(0);

						alphabet[i][j].setEnabled(false);

						alphabet[i][j].setBackground(Color.white);
						alphabet[i][j].setForeground(Color.black);

						if (hangman.checkIfGuessWasGuessed(guess)) {

							if (hangman.checkGuess(guess)) {

								lblWordVal.setText(hangman.updateWordWithGuess(guess));
								if (hangman.isGameWon()) {
									wonGame();
								}

							} // if (hangman.checkGuess(guess))

							else {
								String hangmanPic = "hangman" + hangman.getNumOfGuesses() + ".png";
								lblhangmanPicture.setIcon(new ImageIcon(hangmanPic));
							}

						} // if (hangman.checkIfGuessWasGuessed(guess))

						else {
							JOptionPane.showMessageDialog(this, alphabet[i][j].getText() + " has already been guessed",
									"Already Guessed", JOptionPane.PLAIN_MESSAGE);
						}
					}
				} // if e.getSource() == alphabet[i][j]

			} // for inner

		} // for outer

	}

	public void startUp() {
		hangman = new Hangman();
		if (hangman.checkName(fldName.getText())) {
			player = fldName.getText();
			scoreboard.addPlayer(player);
			fldName.setText("");
			hangman = new Hangman(hangmanWordList.recieveAWord());
			lblWelcome.setText("Welcome to Hangman, " + player + "!");
			lblWordVal.setText(hangman.printUnderscores());
			lblhangmanPicture.setIcon(new ImageIcon("hangman.png"));
			namePanel.setVisible(false);
			enable();
		} else {
			JOptionPane.showMessageDialog(this, "Please enter a valid name!", "Invalid Name!",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void startNewGame() {
		enable();
		hangman = new Hangman(hangmanWordList.recieveAWord());
		lblWordVal.setText(hangman.printUnderscores());
		lblhangmanPicture.setIcon(new ImageIcon("hangman.png"));
	}

	private void wonGame() {
		JOptionPane.showMessageDialog(this, "congradulations, you finished the word", "Word Complete!",
				JOptionPane.PLAIN_MESSAGE);
		scoreboard.gamePlayed(player, true);
		hangmanSaveGame.savePlayers(scoreboard.scoreboard);
		startNewGame();
	}

	public void enable() {
		for (int i = 0; i < alphabet.length; i++) {
			for (int j = 0; j < alphabet[i].length; j++) {
				alphabet[i][j].setEnabled(true);
				alphabet[i][j].setBackground(Color.black);
				alphabet[i][j].setForeground(Color.white);
			}
		}

		mntmSaveGame.setEnabled(true);
		mntmHint.setEnabled(true);
		mntmNewGame.setEnabled(true);
		alphabetPanel.setVisible(true);
		gamePanel.setVisible(true);
	}

	public void createAlphabetButtons() {
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		int incr = 0;
		for (int i = 0; i < alphabet.length; i++) {
			for (int j = 0; j < alphabet[i].length; j++) {
				alphabet[i][j] = new JButton(letters[incr]);
				alphabet[i][j].setPreferredSize(new Dimension(40, 40));
				alphabet[i][j].setActionCommand(letters[incr]);
				incr++;
				alphabet[i][j].addActionListener(this);
				alphabet[i][j].setEnabled(false);
				alphabet[i][j].setBackground(Color.black);
				alphabet[i][j].setForeground(Color.white);
				alphabetPanel.add(alphabet[i][j]);
			}
		}
	}

	public void saveGame() {
		hangmanSaveGame.saveGame(hangman);
		hangmanSaveGame.savePlayers(scoreboard.scoreboard);
		JOptionPane.showMessageDialog(this, "The game is saved in savedGame.txt " + player, "Thank you!",
				JOptionPane.PLAIN_MESSAGE);
		gamePanel.setVisible(false);
		alphabetPanel.setVisible(false);
		namePanel.setVisible(true);
		lblWelcome.setText("");
	}

	public void quitGame() {
		JOptionPane.showMessageDialog(this, "Thank you for playing my Hangman game " + player, "Thank you!",
				JOptionPane.PLAIN_MESSAGE);
		hangman.quitGame();
	}

	public void hint() {
		if (hangman.canHint()) {
			if (hangman.recieveHint()) {
				lblWordVal.setText(hangman.toString());
				String hangmanPic = "hangman" + hangman.getNumOfGuesses() + ".png";
				lblhangmanPicture.setIcon(new ImageIcon(hangmanPic));

				if (hangman.isGameWon()) {
					wonGame();
				}

			} else {
				mntmHint.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Cannot hint more than once", "Thank you!",
						JOptionPane.PLAIN_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, " Sorry you can't recieve a hint because you have guessed 5 letters wrong and can't lose on a hint", "Lost!",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void resumeGame() throws Exception {
		if (hangmanSaveGame.resumeGame() != null) {
			hangman = hangmanSaveGame.resumeGame();
			lblWelcome.setText("Welcome to Hangman, " + player + "!");
			fldName.setText("");
			lblWordVal.setText(hangman.toString());
			String pic = "hangman.png";
			if (hangman.getNumOfGuesses() != 0) {
				pic = "hangman" + hangman.getNumOfGuesses() + ".png";
			}
			lblhangmanPicture.setIcon(new ImageIcon(pic));
			namePanel.setVisible(false);
			enable();
		}
	}
}
