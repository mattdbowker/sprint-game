
/*class representing a runner (circle) on the track*/
public class Runner {
	private int size;
	private String color;
	private double speed;
	private Posn p;
	private double finishTime;
	private boolean crossedLine;

	double min = 0.5; // Minimum value
	double max = 1.0; // Maximum value
	double randomValue = min + (Math.random() * (max - min));	// increase other runners speed so they aren't as slow


	public Runner(int size, String color, Posn p) {
		this.size = size;
		this.color = color;
		this.speed = randomValue;
		this.p = p;
		this.finishTime = -1.0;
		this.crossedLine = false;
	}

	// Method to record runner's time when they cross the finish line
	public void crossFinishLine(long currentTime) {
		if (finishTime == -1.0) {
			// If the runner hasn't crossed the finish line before, record their time
			finishTime = (double) currentTime / 1000.0; // Convert milliseconds to seconds
		}
	}
	/* Method to get the size of the runner*/
	public int getSize() {
		return size;
	}
	/* Method to get the color of the runner*/
	public String getColor() {
		return color;
	}
	/* Method to get the speed of the runner*/
	public double getSpeed() {
		return speed;
	}
	/* Method to get the posn of the runner*/
	public Posn getPosn() {
		return p;
	}
	/* Method to get the recorded time for the runner*/
	public double getTime() {
		return finishTime;
	}
	/* Updates the value of the field crossed line*/
	public void setCrossedLine(boolean x) {
		this.crossedLine = x;
	}
	/* Returns if the runner has crossed the line*/
	public boolean hasCrossedFinishLine() {
		return this.crossedLine;
	}

}
