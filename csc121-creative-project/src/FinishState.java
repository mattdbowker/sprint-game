import static processing.core.PConstants.CENTER;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class FinishState implements IWorld {
	
	private double[] times;

    public FinishState(double[] times) {
        this.times = times;
    }
    

	@Override
	public PApplet draw(PApplet c) {
		c.background(214, 99, 82);
		c.textSize(24);
		c.textAlign(CENTER);
		c.text("FINISHED", 400, 20);
		c.textSize(18);
		displayFinishTimes(c);
		return c;
	}

	@Override
	public IWorld update() {
		return this;
	}

	@Override
	public IWorld keyPressed(KeyEvent key) {
		return null;
	}
	
	/* Displays the finish times on the final state after all 
	 * runners have crossed the finish line.
	 */
	private void displayFinishTimes(PApplet c) {
        c.fill(255);
        c.textSize(18);

        for (int i = 0; i < times.length; i++) {
            String runnerName = (i < 4) ? "Runner " + (i + 1) : "Player";
            double finishTime = times[i];
            String timeText = (finishTime >= 0) ? String.format("%.2f seconds", finishTime) : "DNF"; // DNF for Did Not Finish

            // Display the runner's name and finish time
            c.text(runnerName + ": " + timeText, 400, 50 + i * 20);
        }
    }

}
