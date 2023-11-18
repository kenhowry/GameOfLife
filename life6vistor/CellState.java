package life6vistor;

import java.util.List;

public interface CellState {
	//boolean determining if the Cell is alive or dead
	public boolean isAlive();
	
	//method for making the Cell alive
	public CellState live();
	
	//method for making the Cell dead
	public CellState die();
	
	//method for accepting a Visitor
	public void accept(LifeVisitor v, List<LifeCommand> commandList, Cell cell);
}