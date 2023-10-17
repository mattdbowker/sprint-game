
// class representing a runner (circle) on the track
public class Runner {
    int size;
    String color;
    double speed;
    Posn p;
    double finishTime;
    
    double min = 0.5; // Minimum value
    double max = 1.0; // Maximum value
    double randomValue = min + (Math.random() * (max - min));	// increase other runners speed so they aren't as slow


    public Runner(int size, String color, Posn p) {
        this.size = size;
        this.color = color;
        this.speed = randomValue;
        this.p = p;
        this.finishTime = -1.0;
    }
    
 // Method to record runner's time when they cross the finish line
    public void crossFinishLine(long currentTime) {
        if (finishTime == -1.0) {
            // If the runner hasn't crossed the finish line before, record their time
            finishTime = (double) currentTime / 1000.0; // Convert milliseconds to seconds
        }
    }

    // Method to get the recorded time for the runner
    public double getTime() {
        return finishTime;
    }

}
