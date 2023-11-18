package life6vistor;

public abstract class LifeObserver {
	//variable
	protected GameOfLife gameOfLife;
	
	//constructor
	LifeObserver(GameOfLife gameOfLife){
		this.gameOfLife = gameOfLife;
	}
	
	//abstract method
	public abstract void updateObserver();
}
