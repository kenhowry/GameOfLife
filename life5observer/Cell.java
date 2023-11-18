package life5observer;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	//variables
	private CellState state;
	private List<Cell> neighbors;
	
	//constructor
    public Cell() {
        this.state = DeadState.create();
        this.neighbors = new ArrayList<Cell>();
    }
    
	//boolean determining if the Cell is alive or dead
	public boolean isAlive() {
		return state.isAlive();
	}
	
	//method for making the Cell alive
	public void live() {
		state = AliveState.create();
	}

	//method for making the Cell dead
	public void die() {
		state = DeadState.create();
	}
	
	//method that adds a Cell neighbor to a List
    public void addNeighbor(Cell neighborCell) {
    	neighbors.add(neighborCell);
    }
    
    //method that returns a int of the # of alive neighbors
    public int nbrAliveNeighbors() {
    	int aliveNeighbor = 0;
    	for (Cell neighbor : neighbors) {
    		if (neighbor.isAlive()) {
    			aliveNeighbor++;
    		}
    	}
    	return aliveNeighbor;
    }
}