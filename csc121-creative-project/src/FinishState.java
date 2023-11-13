import static processing.core.PConstants.CENTER;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class FinishState implements IWorld {
	
	private double[] times;
	private ArrayList<Double> allTimeFinishTimes;

    public FinishState(double[] times) {
        this.times = times;
    }
    
    /**
	 * Loads the top 5 finishing times from a text file
	 */
	
	public void loadTimes() {
		try {
			Scanner sc = new Scanner(new File("output.txt"));
			ArrayList<Double> bp = new ArrayList<Double>();
			
			while (sc.hasNextDouble()) {
				bp.add(sc.nextDouble());
			}
			
			Collections.sort(bp);
			//Collections.reverse(bp);
			for (int i = 0; i < 5 && i < bp.size() && i > 0; i++) { 
				allTimeFinishTimes.addAll(bp);
				}
			
			
			sc.close();
		} catch (IOException exp) {
			System.out.println("Problem loading times: " + exp.getMessage() );
		}
	}


    

	@Override
	public PApplet draw(PApplet c) {
		c.background(214, 99, 82);
		c.textSize(24);
		c.textAlign(CENTER);
		c.text("FINISHED", 400, 20);
		c.text("WORLD'S FASTEST 5", 400, 280);
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
            String runnerName = (i < 10) ? "Runner " + (i + 1) : "Player";
            double finishTime = times[i];
            String timeText = finishTime + "";

            // Display the runner's name and finish time
            c.text(runnerName + ": " + timeText, 400, 50 + i * 20);
            
            //Display the Best Times
            c.text(runnerName + ": " + allTimeFinishTimes, 400, 300 + i * 20);

           
        }
        
    }
	
	
	
}
