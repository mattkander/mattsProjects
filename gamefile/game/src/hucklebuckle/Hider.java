package hucklebuckle;

import java.lang.Math;

class Hider extends Player {

	Seeker mySeeker;

	Hider(String name, Game game) {
		super(name, game);
	}

	void introduceYourself() {
		System.out.println("  Harry says \"Hi, I'm " + getName()
				+ ", let's play Huckle Buckle!\"");
	}

	void hide() { // move to a random place
		setX((int) (Math.random() * getGame().getGridSize()));
		setY((int) (Math.random() * getGame().getGridSize()));
	}

	/**
	 * @param seeker
	 *            the other player on the 2d grid
	 * @return a Euclidean distance from the Hider to the seeker, in the range
	 *         [0.0, sqrt(2)*gridSize]
	 */
	private double distance(Player seeker) {
		return Math.hypot(getX() - seeker.getX(), getY() - seeker.getY());
	}

	/**
	 * @param s
	 *            a Seeker `
	 * @return 0, if the Seeker has found the hidden object. Returns a larger
	 *         int-valued "temperature" if the Seeker is farther away.
	 */
	int revealTemperature(Seeker s) {

		// compute a scaled distance. The range of r is 0.0 to 1.414
		double r = distance(s) / (double) getGame().getGridSize();

		System.out.print("  " + getName() + " says to " + s.getName() + ", \"");

		if (r == 0.0) {
			System.out.println("Huckle buckle beanstalk!\"");
			return 0;
		} else if (r <= 0.25) {
			System.out.println("You're boiling!\"");
			return 1;
		} else if (r <= 0.35) {
			System.out.println("You're hot.\"");
			return 2;
		} else if (r <= 0.5) {
			System.out.println("You're warm.\"");
			return 3;
		} else if (r <= 0.7) {
			System.out.println("You're cool.\"");
			return 4;
		} else if (r <= 1.0) {
			System.out.println("You're cold.\"");
			return 5;
		} else {
			System.out.println("freezing!\"");
			return 6;
		}
	}

}