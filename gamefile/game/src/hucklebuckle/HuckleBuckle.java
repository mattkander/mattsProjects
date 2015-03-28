package hucklebuckle;

import java.util.Random;

/**
 * <p>
 * Second optional command-line parameter: ngames, the number of games to be
 * played on this run of the program, an integer between 0 and 9 inclusive.
 * Note: if only one command-line parameter is supplied, it is interpreted as
 * gridsize rather than as ngames, as indicated by the nested bracketing I need
 * to- generate a random number for parameter ngames, loop through the program n
 * times between 0 and 9 on the usage comment below.
 * <p>
 * Usage: hbbv1.1 [gridsize [ngames]]
 *
 * @author Matthew Kiernander Questions: Where does getname get the name from?
 */

public class HuckleBuckle {

	public static final String VERSION = "1.0";

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static void main(String[] args) {
		/*
		 * Generates a random number for ngame- the number of games to play
		 * Random rand = new Random(); int ngames= rand.nextInt((9-0)+1)+0;
		 * System.out.println(ngames);
		 */
		// / instantiates the variable ngames by converting args to an int
		int ngames = Integer.parseInt(args[1]);
		// / checks to ensure that the user wants to play
		if (ngames == 0) {
			System.out
					.println("Sally says, \"That's fine, I didn't want to play anyway!\" ");
		}
		// /A for loop that starts the game
		for (int i = 0; i < ngames; i++) {
			int gridSize = 5; // gridSize == 5, if there are no command-line
								// args
			// /Checks for errors in the input of args if args length is greater
			// than 0 ie has an input
			if (args.length > 0) {
				// /Error check if args is an integer by parsing to an int
				try {
					gridSize = Integer.parseInt(args[0]);

				} catch (NumberFormatException e) {
					System.err
							.println("Error: first arg (gridSize) must be an integer.  ");
					System.exit(1);
				}
				// /Checking to make sure it is in a valid range
				if (gridSize < 1 || gridSize > 40) {
					System.err
							.println("Error: first arg (gridSize) must be in the range 1..40.  ");
					System.exit(1);
				}

			}
			// /making sure args length only contains one argument.
			if (args.length > 2) {
				System.err.println("Warning: too many args.  ");
			}
			// /Starting to play the game, the above checks the input, the below
			// starts the game.

			Game myGame = new Game(gridSize);

			myGame.play();
			/// loop to dictate Sally and harrys interaction at the end of the game. 
			if (i == ngames - 1) {
				System.out
						.println("Sally says, \"I'm all tired out now! I'm going home for dinner, bye Harry!\" ");
			} else {

				System.out
						.println("Sally says, \"Let's play again shall we?\" ");
				System.out.println("Harry says, \"You betcha!\" ");
			}

		}
	}

}