package Hangman;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Rules_Panel extends JPanel {

	private GridBagLayout gridBagLayout;

	public Rules_Panel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblRulesOne = new JLabel("Hangman is usually a group game where a group of people try to ");
		GridBagConstraints gbc_lblRulesOne = new GridBagConstraints();
		gbc_lblRulesOne.insets = new Insets(0, 0, 5, 0);
		gbc_lblRulesOne.gridx = 0;
		gbc_lblRulesOne.gridy = 0;
		add(lblRulesOne, gbc_lblRulesOne);

		JLabel lblRulesTwo = new JLabel("guess a word something is thinking about. This is kind of different");
		GridBagConstraints gbc_lblRulesTwo = new GridBagConstraints();
		gbc_lblRulesTwo.insets = new Insets(0, 0, 5, 0);
		gbc_lblRulesTwo.gridx = 0;
		gbc_lblRulesTwo.gridy = 1;
		add(lblRulesTwo, gbc_lblRulesTwo);

		JLabel lblRulesThree = new JLabel("Once you start a new game and entered your name, a word length");
		GridBagConstraints gbc_lblRulesThree = new GridBagConstraints();
		gbc_lblRulesThree.insets = new Insets(0, 0, 5, 0);
		gbc_lblRulesThree.gridx = 0;
		gbc_lblRulesThree.gridy = 2;
		add(lblRulesThree, gbc_lblRulesThree);

		JLabel lblRulesFour = new JLabel("appears below the hangman image. You must be able to guess the word");
		GridBagConstraints gbc_lblRulesFour = new GridBagConstraints();
		gbc_lblRulesFour.insets = new Insets(0, 0, 5, 0);
		gbc_lblRulesFour.gridx = 0;
		gbc_lblRulesFour.gridy = 3;
		add(lblRulesFour, gbc_lblRulesFour);

		JLabel lblRulesFive = new JLabel(
				"by slecting a letter between a-z shown bellow. You have 6 tries before you lose.");
		GridBagConstraints gbc_lblRulesFive = new GridBagConstraints();
		gbc_lblRulesFive.insets = new Insets(0, 0, 5, 0);
		gbc_lblRulesFive.gridx = 0;
		gbc_lblRulesFive.gridy = 4;
		add(lblRulesFive, gbc_lblRulesFive);

		JLabel lblRulesSix = new JLabel("Good luck");
		GridBagConstraints gbc_lblRulesSix = new GridBagConstraints();
		gbc_lblRulesSix.gridx = 0;
		gbc_lblRulesSix.gridy = 5;
		add(lblRulesSix, gbc_lblRulesSix);
	}

}
