package Astronomy;
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class ImplementCalc {
	public static void main(String[] args) throws FontFormatException, IOException, Exception {
		// make a TTTFrame
		CalcFrame frame = new CalcFrame();
		// make it so the Frame closes when the x is clicked
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// make the frame 500 pixels by 500 pixels
		frame.setSize(800, 800);
		frame.setResizable(false);
		// make the frame visible
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);

		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\User\\Desktop\\Current\\Speech UK\\Astro_Speech.wav"));
		Clip ukIntro = AudioSystem.getClip();
		ukIntro.open(audioInputStream);
		FloatControl gainControl = (FloatControl) ukIntro.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(6.0f);
		ukIntro.start();
		
		AudioInputStream audioMusicStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\User\\Desktop\\CS LEARN\\Educational Vids Java\\Tutorial Music\\Quieter Tutorial Music.wav"));
		Clip clipMusic = AudioSystem.getClip();
		clipMusic.open(audioMusicStream);
		FloatControl gainControlMusic = (FloatControl) clipMusic.getControl(FloatControl.Type.MASTER_GAIN);
		gainControlMusic.setValue(-10.0f);
		clipMusic.start();
	}
}
