//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman_Gui {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel asteriskText;
    private static JLabel label;
    private static JTextField guessLetter;
    private static JButton oK;
    private static JButton newWord;
    private static JTextArea hangMan;
    private static boolean newW = true;

    private static void InitializeGUI () {
        //Creating the Frame

        if (newW) {
            Hangman.initialize();
            newW = false;
        }

        //Creating the panel at bottom and adding component
        asteriskText = new JLabel(Hangman.asterisk);
        panel.add(asteriskText); // Components Added using Flow Layout


        // Text Area at the Center
        hangMan = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, hangMan);
        frame.setVisible(true);
    }


    private static class NewWordButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            newW = true;
            InitializeGUI();
        }
    }
    private static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String guessedLetter = guessLetter.getText();
            if (guessedLetter.length()!=1) {
                hangMan.setText("Guess a letter");
                return;
            }
            if (Hangman.count < 7 && Hangman.asterisk.contains("*")) {
                asteriskText.setText(Hangman.asterisk);
                String newasterisk = Hangman.getnewAsterisk(guessedLetter);

                if (Hangman.asterisk.equals(newasterisk)) {
                    Hangman.count++;
                    hangMan.setText(Hangman.hangmanGuiImage());
                } else {
                    Hangman.asterisk = newasterisk;
                    asteriskText.setText(Hangman.asterisk);
                }
                if (Hangman.asterisk.equals(Hangman.word)) {
                    hangMan.setText("Correct! You win! The word was " + Hangman.word);
                }
            }
        }
    }
    public static void main(String args[]) {

        frame = new JFrame("Hangman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Guess a letter");
        guessLetter = new JTextField(1); // accepts upto 10 characters
        oK = new JButton("OK");
        newWord = new JButton("New Word");
        panel.add(label);
        panel.add(guessLetter);
        panel.add(oK);
        panel.add(newWord);

        InitializeGUI();

        oK.addActionListener(new ButtonClickListener());

        newWord.addActionListener(new NewWordButtonListener());
    }
}