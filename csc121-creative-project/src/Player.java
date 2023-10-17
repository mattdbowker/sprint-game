
import processing.core.PApplet;


public class Player {
	int size;
	String color;
	Posn p;
	double finishTime;

	public Player(int size, String color, Posn p) {
		this.size = size;
		this.color = color;
		this.p = p;
		this.finishTime = -1.0;
	}
	
	// Method to record player's time when they cross the finish line
    public void crossFinishLine(long currentTime) {
        if (finishTime == -1.0) {
            // If the player hasn't crossed the finish line before, record their time
            finishTime = (double) currentTime / 1000.0; // Convert milliseconds to seconds
        }
    }

    // Method to get the recorded time for the player
    public double getTime() {
        return finishTime;
    }
}



