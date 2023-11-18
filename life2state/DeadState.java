package life2state;

public class DeadState implements CellState {
	//constructor
	public DeadState() {}
	
	@Override
	//boolean determining if the Cell is alive or dead
	public boolean isAlive() {
		return false;
	}

	@Override
	//method for making the Cell alive
	public CellState live() {
		return new AliveState();
	}

	@Override
	//method for making the Cell dead
	public CellState die() {
		return new DeadState();
	}

}