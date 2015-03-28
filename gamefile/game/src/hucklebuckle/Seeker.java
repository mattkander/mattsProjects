package hucklebuckle;

class Seeker extends Player {

	private Hider myHider;
	private int distanceMoved; // updated after every change of position

	Seeker(String name, Game game) {
		super(name, game);
		distanceMoved = 0;
	}

	void sayHelloTo(Hider h) {
		myHider = h;
		System.out.println(getName() + " says, \"Hi, " + h.getName() + ", I'm "
				+ getName() + ". Glad to meet you!\"");

	}

	private void reportLocation() {
		System.out.println(getName() + " says, \"I'm at " + getX() + ", "
				+ getY() + ".\"");
	}
	/*
	void moveTo(){
		for (int y = 0; y < getGame().getGridSize(); y++) {
			for (int cx = 0; cx < getGame().getGridSize(); cx++) {
			// cx: counts the number of times I have moved on row y
			int x = (moveRight ? cx : getGame().getGridSize() - cx - 1);
			moveTo(x,y);
		
	}
	*/
	
	void seek() {
		reportLocation(); // I report my initial location
		boolean moveRight = true; // I move left-to-right on even-numbered rows
		for (int y = 0; y < getGame().getGridSize(); y++) {
			///Moves y +1 and sets the new y coordinate
			///This operates by saying if y is less than the gridsize keep on moving up
			if (getY() != y) {
				setY(y); // I move to row y, if I'm not already there
				distanceMoved++;
				reportLocation(); // I announce my location after every move
			}
			

			
			
			for (int cx = 0; cx < getGame().getGridSize(); cx++) {
				// cx: counts the number of times I have moved on row y
				int x = (moveRight ? cx : getGame().getGridSize() - cx - 1);
				if (getX() != x) {
					setX(x);
					distanceMoved++;
					reportLocation(); // I announce my location after every move
				}
				if (myHider.revealTemperature(this) == 0) { // Did I find it?
					System.out.println(getName()
							+ " says, \"That was fun! I walked "
							+ distanceMoved + " steps before I found it.\"");
					return; // I stop when I find the hidden object
				}
			}
			
			// I move in the opposite direction on each row of the grid
			moveRight = !moveRight;
			// My movement pattern is sometimes called the snake-like row-major
			// ordering. See http://en.wikipedia.org/wiki/Boustrophedon.
		}
		System.out.println(getName() + " says, \"I'm giving up.  I took "
				+ distanceMoved + "steps before quitting.\"");
	}

}