package life5observer;

public class LiveCommand extends LifeCommand {

	//constructor
	LiveCommand(Cell cell) {
		super(cell);
	}

	@Override
	//method for executing a LiveCommand
	public void execute() {
		this.cell.live();
	}

}
