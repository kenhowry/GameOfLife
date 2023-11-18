package life6vistor;

import java.awt.Color;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class GameOfLifeUI extends LifeObserver implements DrawListener {

    private Draw window;
	private int width;
	private int height;
	
	GameOfLifeUI(GameOfLife gameOfLife, int width, int height) {
		super(gameOfLife);
		
		this.width = width;
		this.height = height;	
        
        // Setup the DuDraw board
        window = new Draw("Game Of Life");
        window.setCanvasSize(width, height);
        window.setXscale(0, width);
		window.setYscale(0, height);
       
		// Add the mouse/key listeners
        window.addListener(this);
        
        // Draw the initial board
	    update();
	}

	@Override
	public void updateObserver() {
		
	}
	
    private void drawGrid() {
        
    	window.setPenColor(Color.black);
 		
        int cellWidth = width / gameOfLife.getCols();
        int cellHeight = height / gameOfLife.getRows();
     
        for (int i = 0; i <= gameOfLife.getRows(); i++) {
        	window.line(0, i * cellHeight, width, i * cellHeight);
        }
        
        for (int i = 0; i <= gameOfLife.getCols(); i++) {
        	window.line(i * cellWidth, 0, i * cellWidth, height);
        }
    }
     
    private void drawLives() {
    	int cellWidth = width / gameOfLife.getCols();
        int cellHeight = height / gameOfLife.getRows();
        
    	window.setPenColor(Color.red);
        for (int i = 0; i < gameOfLife.getRows(); i++) {
        	for (int j = 0; j < gameOfLife.getCols(); j++) {
        		if (gameOfLife.getCell(i, j).isAlive()) {
        			// This is the center and half width/height
        			window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
                }
            }
        }
    }

    // Below are the mouse/key listeners
    
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			gameOfLife.advance();
			update();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double x, double y) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = width / gameOfLife.getCols();
		int cellHeight = height / gameOfLife.getRows();

		int cellLocRow = (int)(y / cellHeight);
		int cellLocCol = (int)(x / cellWidth);

		if (gameOfLife.getCell(cellLocRow, cellLocCol).isAlive()){
			gameOfLife.getCell(cellLocRow, cellLocCol).die();
		}
		else {
			gameOfLife.getCell(cellLocRow, cellLocCol).live();
		}
		update();        
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}

	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
	 	drawGrid();
	 	drawLives();
	}
}