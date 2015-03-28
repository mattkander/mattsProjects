package hucklebuckle;

class Game {

	private Hider myHider;
	private Seeker mySeeker;
	private int gridSize;

	Game(int gs) {
		myHider = new Hider("Harry", this);
		mySeeker = new Seeker("Sally", this);
		gridSize = gs;
	}

	int getGridSize() {
		return gridSize;
	}

	void play() {
		System.out.println("Playing HuckleBuckle v" + HuckleBuckle.VERSION
				+ " on a " + gridSize + " by " + gridSize + " grid...");
		myHider.introduceYourself();
		mySeeker.sayHelloTo(myHider); // let Sally know who will answer her
										// questions
		myHider.hide(); // tell Harry to hide an object
		mySeeker.seek(); // tell Sally to start looking
	}
}