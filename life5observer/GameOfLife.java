package life5observer;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	//variables
	private List<LifeObserver> lifeObservers;
	private static ArrayList<LifeCommand> commandList;

	// rows and cols for the game
	private int rows;
	private int cols;
	private Cell[][] grid;

	//constructor
	GameOfLife(int rows, int cols){
		this.lifeObservers = new ArrayList<>();
		GameOfLife.commandList = new ArrayList<LifeCommand>();


		// Save the instance variables
		this.rows = rows;
		this.cols = cols;

		Cell[][] grid = new Cell[rows][cols];
		setupGrid(grid);

		this.grid = grid;

	}

	//adding a LifeObserver
	public void attach(LifeObserver lifeObserver) {
		lifeObservers.add(lifeObserver);
	}

	//removing a LifeObserver
	public void detach(LifeObserver lifeObserver) {
		lifeObservers.remove(lifeObserver);
	}

	//updating Observer
	public void notifyGameOfLifeApp() {
		for (LifeObserver o : lifeObservers) {
			o.updateObserver();
		}
	}
	
	//method holding the game's logic
	public void advance() {
		int n = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < getCols(); j++) {
				n = grid[i][j].nbrAliveNeighbors();
				if (grid[i][j].isAlive()) {
					if (n != 3 && n !=2) {
						LifeCommand command = new DieCommand(grid[i][j]);
						commandList.add(command);
					}
				}

				else {
					if (n == 3) {
						LifeCommand command = new LiveCommand(grid[i][j]);
						commandList.add(command);
					} 
				}
			}
		}
		execute();
	}

	//executes the commandList
	private void execute() {
		for (LifeCommand command : commandList) {
			command.execute();
		}
	}

	//creates a grid of Cell objects
	private void setupGrid(Cell[][] grid) {
		int numRows = grid.length;
		int numCols = grid[0].length;

		// iterate over each cell in the grid
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				// create a new Cell object with a DeadState
				Cell cell = new Cell();

				// Assign the cell to the grid
				grid[i][j] = cell;
			}
		}
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				// iterate over the neighboring cells and add them to the neighbors list
				for (int ni = i - 1; ni <= i + 1; ni++) {
					for (int nj = j - 1; nj <= j + 1; nj++) {
						// Check if the neighbor is within the bounds of the grid
						if (ni >= 0 && ni < numRows && nj >= 0 && nj < numCols) {
							// Make sure not to add the cell itself as a neighbor
							if (ni != i || nj != j) {
								grid[i][j].addNeighbor(grid[ni][nj]);
							}
						}
					}
				}
			}
		}

	}

	//returns the int cols
	public int getCols() {
		return cols;
	}

	//returns the int rows
	public int getRows() {
		return rows;
	}

	//returns the Cell object
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
}