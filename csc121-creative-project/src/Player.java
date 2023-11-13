import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
	private int size;
	private String color;
	private Posn p;
	private double finishTime;
	private boolean crossedLine;
	
	public Player(Scanner sc) {
		this.finishTime = sc.nextDouble();

	}

	public Player(int size, String color, Posn p) {
		this.size = size;
		this.color = color;
		this.p = p;
		this.finishTime = -1.0;
		this.crossedLine = false;

		
	}

	
	// Method to record player's time when they cross the finish line
    public void crossFinishLine(long currentTime) {
        if (finishTime == -1.0) {
            // If the player hasn't crossed the finish line before, record their time
            finishTime = (double) currentTime / 1000.0; // Convert milliseconds to seconds
        }
    }

    /* Method to get the size of the player*/
    public int getSize() {
    	return size;
    }
    /* Method to get the color of the player*/
    public String getColor() {
    	return color;
    }
    /* Method to get the posn of the player*/
    public Posn getPosn() {
    	return p;
    }
    /* Method to get the recorded time for the player*/
    public double getTime() {
        return finishTime;
    }
    /* Updates the crossed Line field*/
    public void setCrossedLine(boolean x) {
    	crossedLine = x;
    }
    /* Returns if the player has crossed the line*/
    public boolean hasCrossedFinishLine() {
		return crossedLine;
	}
    
    /**
	 * print the time of this player to the given output file
	 */
	
	public void writeToFile(PrintWriter pw) {
		pw.println(this.finishTime);
	}
	
	
	
	
}



