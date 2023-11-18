package life5observer;

public abstract class LifeCommand {
	//variables
	protected Cell cell;
	
	//constructor
	LifeCommand(Cell cell) {
		this.cell = cell;
	}
	
	//abstract method
	public abstract void execute();

}
