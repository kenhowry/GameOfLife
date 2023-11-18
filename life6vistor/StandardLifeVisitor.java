package life6vistor;

import java.util.List;

public class StandardLifeVisitor extends LifeVisitor {
	//variable
	private int n;
	
	@Override
	//method holding the logic for an alive Cell
	public void visitLiveCell(Cell cell, List<LifeCommand> commandList) {
		n = cell.nbrAliveNeighbors();
		if (n != 3 && n !=2) {
			LifeCommand command = new DieCommand(cell);
			commandList.add(command);
		}	
	}

	@Override
	//method holding the logic for a dead Cell
	public void visitDeadCell(Cell cell, List<LifeCommand> commandList) {
		n = cell.nbrAliveNeighbors();
		if (n == 3) {
			LifeCommand command = new LiveCommand(cell);
			commandList.add(command);
		}		
	}

}
