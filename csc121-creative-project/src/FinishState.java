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
		c.textAlign(c.CENTER);
		c.text("FINISHED", 400, 20);
		c.textSize(18);
		displayFinishTimes(c);
		/*
		c.text("First:", 349, 50);
        c.text("Second:", 357, 70);
        c.text("Third:", 350, 90);
        c.text("Fourth:", 357, 110);
        c.text("Fifth:", 348, 130);*/
		
		return c;
	}

	@Override
	public IWorld update() {
		return this;
	}

	@Override
	public IWorld keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
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
