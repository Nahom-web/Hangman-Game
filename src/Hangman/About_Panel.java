package Hangman;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class About_Panel extends JPanel {

	private GridBagLayout gridBagLayout;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblYear;
	private JLabel lblSchool;
	private GridBagConstraints gbc_lblTitle;
	private GridBagConstraints gbc_lblAuthor;
	private GridBagConstraints gbc_Copyright;
	private GridBagConstraints gbc_lblCompany;

	public About_Panel() {

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblTitle = new JLabel("Hangman Game");
		gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);

		lblAuthor = new JLabel("Nahom Haile");
		gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 0);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 1;
		add(lblAuthor, gbc_lblAuthor);

		lblYear = new JLabel("2020");
		gbc_Copyright = new GridBagConstraints();
		gbc_Copyright.insets = new Insets(0, 0, 5, 0);
		gbc_Copyright.gridx = 0;
		gbc_Copyright.gridy = 2;
		add(lblYear, gbc_Copyright);

		lblSchool = new JLabel("Heritage College");
		gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 3;
		add(lblSchool, gbc_lblCompany);
	}
}