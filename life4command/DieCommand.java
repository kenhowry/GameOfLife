package life4command;

public class DieCommand extends LifeCommand {
	//constructor
	DieCommand(Cell cell) {
		super(cell);
	}

	@Override
	//method for executing a DieCommand
	public void execute() {
		this.cell.die();		
	}

}
