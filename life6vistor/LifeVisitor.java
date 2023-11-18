package life6vistor;

import java.util.List;

public abstract class LifeVisitor {
	//accepts the Visitor and commandList
	public void visit(Cell cell, List<LifeCommand> commandList) {
		cell.accept(this, commandList);
	}
	
	//abstract methods
	public abstract void visitLiveCell(Cell cell, List<LifeCommand> commandList);
	public abstract void visitDeadCell(Cell cell, List<LifeCommand> commandList);
}
