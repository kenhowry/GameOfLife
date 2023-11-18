package life2state;

public interface CellState {
	
	//boolean determining if the Cell is alive or dead
	public boolean isAlive();
	
	//method for making the Cell alive
	public CellState live();
	
	//method for making the Cell dead
	public CellState die();

}