package Astronomy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalcPanel extends JPanel {

	private JLabel info; // to communicate instructions to user

	// beginning screen
	private JPanel panel; // panel for buttons for squares
	private JPanel mercuryWeight, venusWeight, marsWeight, jupiterWeight, saturnWeight, uranusWeight, neptuneWeight,
			otherWeight;

	private JPanel enterWeightPanel;
	private JPanel firstPanel;// first option
	private JPanel startPanel; // first option

	private JButton openFullPage; // startPanel

	private JButton first;
	private JButton second;
	private JButton third;
	private JButton fourth;
	private JButton fifth;
	private JButton sixth;

	private JLabel start;
	private JLabel clickStart;
	private JLabel weight;
	private JLabel distance;
	private JLabel year;
	private JLabel luminosity;
	private JLabel velocity;
	private JLabel proportion;

	private JButton back1, back2, back3, back4, back5, back6, back7, back8;

	private Font font1 = new Font("Impact", Font.BOLD, 50);
	private Font font2 = new Font("Impact", Font.BOLD, 100);
	private Font fontSmall = new Font("Impact", Font.PLAIN, 30);
	private Font fontSmaller = new Font("Impact", Font.PLAIN, 20);

	// FIRST
	JLabel buffer;
	private JButton mercury, venus, mars, jupiter, saturn, uranus, neptune, pluto;
	private JLabel mercuryC, venusC, marsC, jupiterC, saturnC, uranusC, neptuneC, plutoC;

	private JButton mercuryPic, venusPic, marsPic, jupiterPic, saturnPic, uranusPic, neptunePic, otherPic;
	private JLabel mercuryA, venusA, marsA, jupiterA, saturnA, uranusA, neptuneA, otherA;

	// WEIGHT Texts
	private JTextArea inWeight; // insert a weight
	private JLabel askWeight;
	private String outWeight;
	private JButton submit;

	private String whatPlanetWeight = "";
	private String mercuryLBS = "";

	public CalcPanel() throws FontFormatException, IOException {

		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		startPanel = new JPanel();
		startPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		ActionListener opening = new OpeningAction();
		//ImageIcon imageOpen = new ImageIcon("C:\\Users\\User\\Desktop\\College\\Astronomy\\earth.jpg");
		ImageIcon imageOpen = new ImageIcon("C:\\Users\\User\\Desktop\\College\\Astronomy\\earth.jpg");
		openFullPage = new JButton("", imageOpen);
		openFullPage.setFont(font2);
		openFullPage.addActionListener(opening);
		start = new JLabel("<html>Astronomy <br>Calculator<br><br> </html>", SwingConstants.LEFT);
		start.setForeground(Color.WHITE);
		start.setFont(font2);
		openFullPage.add(start);

		clickStart = new JLabel(
				"<html><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><U>Click Anywhere to Start</U><br> <br> </html>",
				SwingConstants.CENTER);
		clickStart.setForeground(Color.WHITE);
		clickStart.setFont(fontSmall);
		openFullPage.add(clickStart);

		openFullPage.setPreferredSize(new Dimension(800, 800));
		startPanel.add(openFullPage, BorderLayout.NORTH);
		openFullPage.setEnabled(true);
		openFullPage.setVisible(true);

		// setLayout(new BorderLayout());
		panel = new JPanel();
		// panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		ActionListener takeSquare = new CalcOptionAction();

		// FIRST + WEIGHT TXT
		ImageIcon image1 = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\eclipsingPlanetResize.jpg");
		first = new JButton(" Calculate Weight ", image1);
		weight = new JLabel("               Caclulate Weight ", SwingConstants.CENTER);
		weight.setForeground(Color.WHITE);
		weight.setFont(font1);

		first.add(weight);
		first.addActionListener(takeSquare);

		first.setBorder(BorderFactory.createEmptyBorder());
		panel.add(first);

		// SECOND + DISTANCE TXT
		ImageIcon image2 = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\largeStars.jpg");
		second = new JButton(" Calculate Distance ", image2);
		distance = new JLabel("            Caclulate Distance ", SwingConstants.CENTER);
		distance.setForeground(Color.WHITE);
		distance.setFont(font1);

		second.add(distance);
		second.addActionListener(takeSquare);
		panel.add(second);

		// THIRD + YEAR
		ImageIcon image3 = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\solarSystemResize.jpg");
		third = new JButton(" Calculate Length of Year ", image3);
		year = new JLabel("       Calculate Length of Year ", SwingConstants.CENTER);
		year.setForeground(Color.WHITE);
		year.setFont(font1);

		third.add(year);
		third.addActionListener(takeSquare);
		panel.add(third);

		// FOURTH + LUMINOSITY
		ImageIcon image4 = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\solarFlareResize.jpg");
		fourth = new JButton(" Calculate a Star's Luminosity ", image4);
		luminosity = new JLabel("    Calculate a Star's Luminosity  ", SwingConstants.CENTER);
		luminosity.setForeground(Color.WHITE);
		luminosity.setFont(font1);

		fourth.add(luminosity);
		fourth.addActionListener(takeSquare);
		panel.add(fourth);

		// FIFTH + VELOCITY
		ImageIcon image5 = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\spaceShuttle.jpg");
		fifth = new JButton(" Calculate Escape Velocity", image5);
		velocity = new JLabel("    Calculate Escape Velocity  ", SwingConstants.CENTER);
		velocity.setForeground(Color.WHITE);
		velocity.setFont(font1);

		fifth.add(velocity);
		fifth.setFont(font1);
		fifth.addActionListener(takeSquare);
		panel.add(fifth);

		ImageIcon image6 = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\sizes.jpg");
		sixth = new JButton(" Calculate Proportional Sizes ", image6);
		proportion = new JLabel("    Calculate Proportional Sizes   ", SwingConstants.CENTER);
		proportion.setForeground(Color.WHITE);
		proportion.setFont(font1);

		sixth.add(proportion);
		sixth.setFont(font1);
		sixth.addActionListener(takeSquare);
		panel.add(sixth);

		startPanel.setBackground(Color.BLACK);
		add(startPanel, BorderLayout.CENTER);

		setAllEnabled(false);
		setAllVisible(false);
		startPanel.setEnabled(true);
		startPanel.setVisible(true);

		// private JButton mercury, venus, mars, jupiter, saturn, uranus,
		// neptune, pluto;
		// private JLabel mercuryC, venusC, marsC, jupiterC, saturnC, uranusC,
		// neptuneC, plutoC;
		firstPanel = new JPanel();
		ActionListener actionFirstOption = new FirstOptionAction();
		firstPanel.setLayout(new GridLayout(4, 2, 5, 5));

		ImageIcon imageMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\correctMercuryResize.jpg");
		mercury = new JButton("Mercury", imageMerc);
		mercuryC = new JLabel("        Mercury");
		mercuryC.setForeground(Color.WHITE);
		mercuryC.setFont(font1);

		mercury.add(mercuryC);
		mercury.setFont(font1);
		mercury.addActionListener(actionFirstOption);
		firstPanel.add(mercury);
		mercury.setEnabled(true);
		mercury.setVisible(true);

		ImageIcon imageVen = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\venus.jpg");
		venus = new JButton("Venus", imageVen);
		venusC = new JLabel("        Venus");
		venusC.setForeground(Color.WHITE);
		venusC.setFont(font1);

		venus.add(venusC);
		venus.setFont(font1);
		venus.addActionListener(actionFirstOption);
		firstPanel.add(venus);

		ImageIcon imageMars = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\mars.jpg");
		mars = new JButton("Mars", imageMars);
		marsC = new JLabel("          Mars");
		marsC.setForeground(Color.WHITE);
		marsC.setFont(font1);

		mars.add(marsC);
		mars.setFont(font1);
		mars.addActionListener(actionFirstOption);
		firstPanel.add(mars);

		ImageIcon imageJupiter = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\Jupiter.jpg");
		jupiter = new JButton("Jupiter", imageJupiter);
		jupiterC = new JLabel("        Jupiter");
		jupiterC.setForeground(Color.WHITE);
		jupiterC.setFont(font1);

		jupiter.add(jupiterC);
		jupiter.setFont(font1);
		jupiter.addActionListener(actionFirstOption);
		firstPanel.add(jupiter);

		ImageIcon imageSat = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\saturn.jpg");
		saturn = new JButton("Saturn", imageSat);
		saturnC = new JLabel("        Saturn");
		saturnC.setForeground(Color.WHITE);
		saturnC.setFont(font1);

		saturn.add(saturnC);
		saturn.setFont(font1);
		saturn.addActionListener(actionFirstOption);
		firstPanel.add(saturn);

		ImageIcon imageUranus = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\uranus.jpg");
		uranus = new JButton("Uranus", imageUranus);
		uranusC = new JLabel("        Uranus");
		uranusC.setForeground(Color.WHITE);
		uranusC.setFont(font1);

		uranus.add(uranusC);
		uranus.setFont(font1);
		uranus.addActionListener(actionFirstOption);
		firstPanel.add(uranus);

		ImageIcon imageNep = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\neptune.jpg");
		neptune = new JButton("Neptune", imageNep);
		neptuneC = new JLabel("       Neptune");
		neptuneC.setForeground(Color.WHITE);
		neptuneC.setFont(font1);

		neptune.add(neptuneC);
		neptune.setFont(font1);
		neptune.addActionListener(actionFirstOption);
		firstPanel.add(neptune);

		ImageIcon imagePluto = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\pluto.jpg");
		pluto = new JButton("Pluto", imagePluto);
		plutoC = new JLabel("          Other");
		plutoC.setForeground(Color.WHITE);
		plutoC.setFont(font1);

		pluto.add(plutoC);
		pluto.setFont(font1);
		pluto.addActionListener(actionFirstOption);
		firstPanel.add(pluto);

		firstPanel.setBackground(Color.BLACK);
		firstPanel.setVisible(false);
		firstPanel.setEnabled(false);

		// WEIGHT ANSWERS

		ImageIcon imageMercPic = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\redNebulas.jpg");
		ActionListener returnOption = new ReturnAction();
		firstPanel.setLayout(new GridLayout(4, 2, 5, 5));
		mercuryWeight = new JPanel();


		mercuryA = new JLabel(mercuryLBS);
		mercuryA.setForeground(Color.WHITE);
		mercuryA.setFont(font1);
		mercuryA.setHorizontalAlignment(SwingConstants.CENTER);
		mercuryA.setVerticalAlignment(SwingConstants.CENTER);

		buffer = new JLabel("<html> Enter <br> weight in lbs: <br> <br> </html>", SwingConstants.CENTER);
		buffer.setFont(fontSmall);
		buffer.setForeground(Color.WHITE);
		mercuryA.setForeground(Color.WHITE);
		mercuryA.setFont(font1);
		
		buffer.setBackground(Color.BLACK);
		inWeight = new JTextArea();
		inWeight.setFont(fontSmall);
		inWeight.setLineWrap(true);
		inWeight.setWrapStyleWord(true);

		ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\correctMercuryResize.jpg");
		mercuryPic = new JButton("", largeMerc);
		mercuryPic.setBackground(Color.BLACK);
		mercuryPic.setPreferredSize(new Dimension(800, 600));

		JLabel submitIt = new JLabel("<html><U>Submit <br> <br></U> </html>", SwingConstants.CENTER);
		submitIt.setFont(fontSmall);
		submitIt.setForeground(Color.WHITE);
		
		enterWeightPanel = new JPanel();
		submit = new JButton();
		submit.add(submitIt);

		submit.setBackground(Color.BLACK);
		submit.addActionListener(returnOption);

		back1 = new JButton("<html><U> Return to Start </U> </html>");
		back1.setFont(fontSmall);
		back1.setForeground(Color.WHITE);
		back1.setBackground(Color.BLACK);
		back1.addActionListener(returnOption);

		mercuryWeight.setBackground(Color.BLACK);
		mercuryWeight.add(mercuryPic);
		mercuryPic.add(mercuryA);

		enterWeightPanel.setLayout(new GridLayout(1, 3, 0, 0));
		enterWeightPanel.setPreferredSize(new Dimension(800, 200));
		enterWeightPanel.setBackground(Color.BLACK);

		enterWeightPanel.add(buffer);
		enterWeightPanel.add(inWeight);
		enterWeightPanel.add(submit);
		mercuryWeight.add(enterWeightPanel);

		venusWeight = new JPanel();
		venusPic = new JButton(imageMercPic);
		venusWeight.setBackground(Color.BLACK);
		venusWeight.add(venusPic);

		marsWeight = new JPanel();
		marsPic = new JButton(imageMercPic);
		marsWeight.setBackground(Color.BLACK);
		marsWeight.add(marsPic);

		jupiterWeight = new JPanel();
		jupiterPic = new JButton(imageMercPic);
		jupiterWeight.setBackground(Color.BLACK);
		jupiterWeight.add(jupiterPic);

		saturnWeight = new JPanel();
		saturnPic = new JButton(imageMercPic);
		saturnWeight.setBackground(Color.BLACK);
		saturnWeight.add(saturnPic);

		uranusWeight = new JPanel();
		uranusPic = new JButton(imageMercPic);
		uranusWeight.setBackground(Color.BLACK);
		uranusWeight.add(uranusPic);

		neptuneWeight = new JPanel();
		neptunePic = new JButton(imageMercPic);
		neptuneWeight.setBackground(Color.BLACK);
		neptuneWeight.add(neptunePic);

		otherWeight = new JPanel();
		otherPic = new JButton(imageMercPic);
		otherWeight.setBackground(Color.BLACK);
		otherWeight.add(otherPic);

	}

	private class OpeningAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			if (b.equals(openFullPage)) {
				startPanel.setEnabled(false);
				startPanel.setVisible(false);
				removeAllPanels();
				add(panel, BorderLayout.CENTER);
				setAllVisible(true);
				setAllEnabled(true);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
			}
		}
	}

	private class CalcOptionAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			if (b.equals(first)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(true);
				setAllWeightsVisible(true);
				removeAllPanels();
				add(firstPanel, BorderLayout.CENTER);
				firstPanel.setVisible(true);
				firstPanel.setEnabled(true);

			} else if (b.equals(second)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				buffer.setHorizontalAlignment(SwingConstants.LEFT);
				buffer.setText(
						"<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter: &nbsp; Arc Parallax, "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name of Object<br> <br><br> </html>");
				buffer.setFont(fontSmaller);
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\distanceToStar.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "second";
			} else if (b.equals(third)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				buffer.setHorizontalAlignment(SwingConstants.LEFT);
				buffer.setText(
						"<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter: &nbsp; Distance to Sun, "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name of Object<br> <br><br> </html>");
				buffer.setFont(fontSmaller);
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\solarSystemArt.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "third";
			} else if (b.equals(fourth)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				buffer.setHorizontalAlignment(SwingConstants.LEFT);
				buffer.setText(
						"<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter: &nbsp; Radius (SU), "
								+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Temperature (SU), "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name of Object<br> <br><br> </html>");
				buffer.setFont(fontSmaller);
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\starTypes.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "fourth";
			} else if (b.equals(fifth)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				buffer.setHorizontalAlignment(SwingConstants.LEFT);
				buffer.setText(
						"<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter: &nbsp; Mass Base, "
								+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Mass 'e' Exponent, "
								+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Radius Base, "
								+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Radius 'e' Exponent, "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name of Planet<br> <br><br> </html>");
				buffer.setFont(fontSmaller);
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\takeOff.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "fifth";
			} else if (b.equals(sixth)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				buffer.setHorizontalAlignment(SwingConstants.LEFT);
				buffer.setText(
						"<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter: &nbsp; Radius, "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name of Planet<br> <br><br> </html>");
				buffer.setFont(fontSmaller);
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\earthAndSunResize.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "sixth";
			}

		}
	}

	private class FirstOptionAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			if (b.equals(mercury)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\correctMercuryResize.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "mercury";

			} else if (b.equals(venus)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\venus.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "venus";
			} else if (b.equals(mars)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\mars.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "mars";
			} else if (b.equals(jupiter)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\jupiterBig.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "jupiter";
			} else if (b.equals(saturn)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\saturn.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "saturn";
			} else if (b.equals(uranus)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\uranus.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "uranus";
			} else if (b.equals(neptune)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\neptune.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "neptune";
			} else if (b.equals(pluto)) {
				setAllEnabled(false);
				setAllVisible(false);
				setAllWeightsEnabled(false);
				setAllWeightsVisible(false);
				removeAllPanels();
				buffer.setHorizontalAlignment(SwingConstants.LEFT);
				buffer.setText(
						"<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter: &nbsp; Weight, "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Radius,"
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Mass Base, "
						+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Mass 'e' Exponent, "
						+ "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name of Object<br> <br><br> </html>");
				buffer.setFont(fontSmaller);
				ImageIcon largeMerc = new ImageIcon("C:\\Users\\User\\Desktop\\Extras\\Astronomy\\pluto.jpg");
				mercuryPic.setIcon(largeMerc);
				add(mercuryWeight, BorderLayout.CENTER);
				mercuryWeight.setVisible(true);
				mercuryWeight.setEnabled(true);
				whatPlanetWeight = "other";
			}
		}
	}

	private class ReturnAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			if (b.equals(back1)) {
				reset();

			} else if (b.equals(submit)) {
				if (inWeight.getText().equals("") || inWeight.getText().replaceAll(" ", "").equals("")
						|| !inWeight.getText().matches("[0-9]+")) {
					if (whatPlanetWeight.equals("other") && !inWeight.getText().equals("")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						double weightLBS = Double.parseDouble(in.next());
						double radius = Double.parseDouble(in.next());
						double massConstant = Double.parseDouble(in.next());
						double massExponent = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, radius,
								massConstant * Math.pow(10, massExponent), givenName);
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("second") && !inWeight.getText().equals("")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						double parallax = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.distanceToStar(parallax, givenName);
						String labelText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 400, mercuryLBS);
						mercuryA.setText("" + labelText);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);
						

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("third") && !inWeight.getText().equals("")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						double distance = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.lengthOfYear(distance, givenName);
						String labelText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 400, mercuryLBS);
						mercuryA.setText("" + labelText);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);
						

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("fourth") && !inWeight.getText().equals("")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						double radius = Double.parseDouble(in.next());
						double temperature = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.luminocityOfStar(radius, temperature, givenName);
						String labelText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 400, mercuryLBS);
						mercuryA.setText("" + labelText);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);
						

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("fifth") && !inWeight.getText().equals("")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						//5.98 * Math.pow(10, 24), 6.38 * Math.pow(10, 6), "Earth"
						double massBase = Double.parseDouble(in.next());
						double massExponent = Double.parseDouble(in.next());
						double radiusBase = Double.parseDouble(in.next());
						double radiusExponent = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.escapeVelocityOfObject(massBase * Math.pow(10, massExponent), radiusBase * Math.pow(10, radiusExponent), givenName);
						String labelText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 400, mercuryLBS);
						mercuryA.setText("" + labelText);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);
						

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("sixth") && !inWeight.getText().equals("")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						//5.98 * Math.pow(10, 24), 6.38 * Math.pow(10, 6), "Earth"
						double radius = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.proportionalSize(radius, givenName);
						String labelText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 400, mercuryLBS);
						mercuryA.setText("" + labelText);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);
						

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					}
					
					else {

						inWeight.setText("");
					}
				} else {
					if (whatPlanetWeight.equals("mercury")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 2440, 3.30 * Math.pow(10, 23), "Mercury");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("venus")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 6052, 4.87 * Math.pow(10, 24), "Venus");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("mars")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 3397, 6.42 * Math.pow(10, 23), "Mars");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("jupiter")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 71492, 1.90 * Math.pow(10, 27), "Jupiter");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("saturn")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 60268, 5.68 * Math.pow(10, 26), "Saturn");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("uranus")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 25559, 8.68 * Math.pow(10, 25), "Uranus");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("neptune")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);

						double weightLBS = Double.parseDouble(inWeight.getText());
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, 24766, 1.02 * Math.pow(10, 26), "Neptune");
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("other")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						double weightLBS = Double.parseDouble(in.next());
						double radius = Double.parseDouble(in.next());
						double massConstant = Double.parseDouble(in.next());
						double massExponent = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.weightOnPlanet(weightLBS, radius,
								massConstant * Math.pow(10, massExponent), givenName);
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					} else if (whatPlanetWeight.equals("second")) {
						mercuryWeight.setVisible(false);
						removeAllPanels();

						mercuryWeight.remove(submit);
						mercuryWeight.remove(inWeight);
						add(mercuryWeight, BorderLayout.CENTER);
						Scanner in = new Scanner(inWeight.getText().replaceAll(" ", "")).useDelimiter(",");
						double parallax = Double.parseDouble(in.next());
						String givenName = in.next();
						mercuryLBS = Calculator.distanceToStar(parallax, givenName);
						mercuryA.setText(" " + mercuryLBS);
						mercuryA.setForeground(Color.WHITE);
						mercuryA.setFont(font1);

						mercuryWeight.remove(enterWeightPanel);

						mercuryWeight.add(back1);
						back1.setEnabled(true);
						back1.setVisible(true);
						mercuryWeight.setVisible(true);
					}
				}
			}
		}
	}

	public void setAllEnabled(boolean bool) {
		if (!bool) {
			first.setEnabled(false);
			second.setEnabled(false);
			fourth.setEnabled(false);
			third.setEnabled(false);
			fifth.setEnabled(false);
			sixth.setEnabled(false);
		} else if (bool) {
			first.setEnabled(true);
			second.setEnabled(true);
			fourth.setEnabled(true);
			third.setEnabled(true);
			fifth.setEnabled(true);
			sixth.setEnabled(true);
		}
	}

	public void setAllVisible(boolean bool) {
		if (!bool) {
			second.setVisible(false);
			first.setVisible(false);
			fourth.setVisible(false);
			third.setVisible(false);
			fifth.setVisible(false);
			sixth.setVisible(false);
		} else if (bool) {
			first.setVisible(true);
			second.setVisible(true);
			fourth.setVisible(true);
			third.setVisible(true);
			fifth.setVisible(true);
			sixth.setVisible(true);

		}

	}

	// private JButton mercury, venus, mars, jupiter, saturn, uranus,
	// neptune, pluto;
	// private JLabel mercuryC, venusC, marsC, jupiterC, saturnC, uranusC,
	// neptuneC, plutoC;

	public void setAllWeightsEnabled(boolean bool) {
		if (!bool) {
			mercury.setEnabled(false);
			venus.setEnabled(false);
			mars.setEnabled(false);
			jupiter.setEnabled(false);
			saturn.setEnabled(false);
			uranus.setEnabled(false);
			neptune.setEnabled(false);
			pluto.setEnabled(false);
		} else if (bool) {
			mercury.setEnabled(true);
			venus.setEnabled(true);
			mars.setEnabled(true);
			jupiter.setEnabled(true);
			saturn.setEnabled(true);
			uranus.setEnabled(true);
			neptune.setEnabled(true);
			pluto.setEnabled(true);
		}
	}

	public void setAllWeightsVisible(boolean bool) {
		if (!bool) {
			mercury.setVisible(false);
			venus.setVisible(false);
			mars.setVisible(false);
			jupiter.setVisible(false);
			saturn.setVisible(false);
			uranus.setVisible(false);
			neptune.setVisible(false);
			pluto.setVisible(false);
		} else if (bool) {
			mercury.setVisible(true);
			venus.setVisible(true);
			mars.setVisible(true);
			jupiter.setVisible(true);
			saturn.setVisible(true);
			uranus.setVisible(true);
			neptune.setVisible(true);
			pluto.setVisible(true);

		}
	}

	// private JPanel panel; // panel for buttons for squares
	// private JPanel mercuryWeight, venusWeight, marsWeight, jupiterWeight,
	// saturnWeight, uranusWeight, neptuneWeight, otherWeight;
	// private JPanel enterWeightPanel;
	// private JPanel firstPanel;
	public void removeAllPanels() {
		remove(startPanel);
		remove(panel);
		remove(mercuryWeight);
		remove(venusWeight);
		remove(marsWeight);
		remove(jupiterWeight);
		remove(saturnWeight);
		remove(uranusWeight);
		remove(neptuneWeight);
		remove(otherWeight);
		remove(enterWeightPanel);
		remove(firstPanel);
	}

	public void reset() {
		removeAllPanels();
		setAllWeightsEnabled(false);
		setAllWeightsVisible(false);
		setAllEnabled(false);
		setAllVisible(false);
		mercuryWeight.setEnabled(false);
		mercuryWeight.setVisible(false);
		firstPanel.setVisible(false);
		firstPanel.setEnabled(false);
		add(startPanel, BorderLayout.CENTER);
		openFullPage.setEnabled(true);
		openFullPage.setVisible(true);
		startPanel.setEnabled(true);
		startPanel.setVisible(true);
		mercuryWeight.remove(back1);
		mercuryWeight.add(enterWeightPanel);
		inWeight.setText("");
		mercuryA.setText("");
		buffer.setText("<html> Enter <br> weight in lbs: <br> <br> </html>");
		buffer.setFont(fontSmall);
	}

}
