package life4command;

public class DeadState implements CellState {
	//variables
	private static DeadState instance;
		
	//constructor
	private DeadState() {}
	
	//creating an instance of DeadState
	public static DeadState create() {
		if (instance == null) {
			instance = new DeadState();
		}
		return instance;
	}
	
	@Override
	//boolean determining if the Cell is alive or dead
	public boolean isAlive() {
		return false;
	}

	@Override
	//method for making the Cell alive
	public CellState live() {
		return this;
	}

	@Override
	//method for making the Cell dead
	public CellState die() {
		return this;
	}
}