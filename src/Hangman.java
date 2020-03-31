import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class Hangman {

	private static String[] words = {"terminator", "banana", "computer", "cow", "rain", "water" };
	public static String word;
	public static String asterisk;
	public static int count = 0;
	private static int repeats = 0;

	public static void TestSwing() {
		JFrame f=new JFrame();//creating instance of JFrame

		JButton b = new JButton("click");//creating instance of JButton
		b.setBounds(130,100,300, 40);//x axis, y axis, width, height

		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repeats++;
				b.setText("clicked..." + repeats);
			}
		});

		f.add(b);//adding button in JFrame

		f.setSize(400,500);//400 width and 500 height
		f.setLayout(null);//using no layout managers
		f.setVisible(true);//making the frame visible
	}

	public static void initialize() {
		word = words[(int) (Math.random() * words.length)];
		asterisk = new String(new char[word.length()]).replace("\0", "*");
		count = 0;
	}

	public static void main(String[] args) {
		//TestSwing();

		Scanner sc = new Scanner(System.in);
		boolean bContinue = true;
		initialize();

		while(bContinue) {
			while (count < 7 && asterisk.contains("*")) {
				System.out.println("Guess any letter in the word");
				System.out.println(asterisk);
				String guess = sc.next();
				hang(guess);
			}
			System.out.println("Do you want to continue(y/n) ?");
			String sContinue = sc.next();
			if (!sContinue.equalsIgnoreCase("y")) {
				bContinue = false;
			}
			else {
				initialize();
			}
		}
		sc.close();
	}

	public static String getnewAsterisk(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		return newasterisk;
	}

	public static void hang(String guess) {
		String newasterisk = getnewAsterisk(guess);
		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}

	public static String hangmanGuiImage() {

		String hangmanImage = new String("");
		if (count == 1) {
			hangmanImage += "Wrong guess, try again\n";
			hangmanImage += " \n";
			hangmanImage += " \n";
			hangmanImage += " \n";
			hangmanImage += " \n";
			hangmanImage += " \n";
			hangmanImage += "___|___";
			hangmanImage += "\n";
		}
		if (count == 2) {
			hangmanImage += "Wrong guess, try again\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "___|___";
		}
		if (count == 3) {
			hangmanImage += "Wrong guess, try again\n";
			hangmanImage += "   ____________\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "___|___";
		}
		if (count == 4) {
			hangmanImage += "Wrong guess, try again\n";
			hangmanImage += "   ____________\n";
			hangmanImage += "   |          _|_\n";
			hangmanImage += "   |         /   \\\n";
			hangmanImage += "   |        |     |\n";
			hangmanImage += "   |         \\_ _/\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "   |\n";
			hangmanImage += "___|___";
		}
		if (count == 5) {
			hangmanImage += "Wrong guess, try again\n";
			hangmanImage += "   ____________\n";
			hangmanImage += "   |          _|_\n";
			hangmanImage += "   |         /   \\\n";
			hangmanImage += "   |        |     |\n";
			hangmanImage += "   |         \\_ _/\n";
			hangmanImage += "   |           |\n";
			hangmanImage += "   |           |\n";
			hangmanImage += "   |\n";
			hangmanImage += "___|___";
		}
		if (count == 6) {
			hangmanImage += "Wrong guess, try again\n";
			hangmanImage += "   ____________\n";
			hangmanImage += "   |          _|_\n";
			hangmanImage += "   |         /   \\\n";
			hangmanImage += "   |        |     |\n";
			hangmanImage += "   |         \\_ _/\n";
			hangmanImage += "   |           |\n";
			hangmanImage += "   |           |\n";
			hangmanImage += "   |          / \\\n ";
			hangmanImage += "___|___      /   \\\n";
		}
		if (count == 7) {
			hangmanImage += "GAME OVER!\n";
			hangmanImage += "   ____________";
			hangmanImage += "   |          _|_\n";
			hangmanImage += "   |         /   \\\n";
			hangmanImage += "   |        |     |\n";
			hangmanImage += "   |         \\_ _/\n";
			hangmanImage += "   |          _|_\n";
			hangmanImage += "   |         / | \\\n";
			hangmanImage += "   |          / \\ \n";
			hangmanImage += "___|___      /   \\\n";
			hangmanImage += "The word was " + word;
		}

		return hangmanImage;
	}

	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}