package hucklebuckle;

class Player {

	private String myName;
	private Game myGame;
	private int x; // constraint: 0 <= x < HuckleBuckle.GridSize
	private int y; // constraint: 0 <= y < HuckleBuckle.GridSize

	Player(String name, Game game) {
		myName = name;
		myGame = game;
		setX(0); // all players start at (0,0)
		setY(0);
	}

	String getName() {
		return myName;
	}

	Game getGame() {
		return myGame;
	}


	int getX() {
		return x;
	}

	void setX(int px) {
		x = (int) px; // TODO: add bounds-checking logic
	}

	int getY() {
		return y;
	}

	void setY(int py) {
		y = (int) py; // TODO: add bounds-checking logic
	}

}