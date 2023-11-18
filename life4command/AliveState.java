package life4command;

public class AliveState implements CellState {
	//variables
	private static AliveState instance;
	
	//constructor
	private AliveState() {}
	
	//method that creates and instance of AliveState
	public static AliveState create() {
		if (instance == null) {
			instance = new AliveState();
		}
		return instance;
	}
	
	@Override
	//boolean determining if the Cell is alive or dead
	public boolean isAlive() {
		return true;
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