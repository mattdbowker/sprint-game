import static processing.core.PConstants.CENTER;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class FinishState implements IWorld {
	
	private double[] times;
	//private ArrayList<Double> allTimeFinishTimes;
	private double[] highScoreTimes;

    public FinishState(double[] times) {
        this.times = times;
       //this.allTimeFinishTimes = new ArrayList<>();
        this.highScoreTimes = new double[5];
        loadTimes();	// load in the times!!!
    }
    
    /**
	 * Loads the top 5 finishing times from 'output.txt'
	 */
	
	public void loadTimes() {
		try {
			Scanner sc = new Scanner(new File("output.txt"));
			double[] bp = new double[10];
			int count = 0;
			
			while (sc.hasNextDouble() && count < 10) {
                bp[count] = sc.nextDouble();
                count++;
            }
			
			Arrays.sort(bp, 0, count); // Sort only the valid times

            // Copy the top 5 times into the highScoreTimes array
            int copyCount = Math.min(count, 5);
            for (int i = 0; i < copyCount; i++) {
                highScoreTimes[i] = bp[i]; // Copy the highest times to the highScoreTimes array
            }

			sc.close();
			
			// extra
			//ArrayList<Double> bp = new ArrayList<Double>();
			//while (sc.hasNextDouble()) {
			//	bp.add(sc.nextDouble());
			//}
			
			/*
			Collections.sort(bp);
			//Collections.reverse(bp);
			
            int count = Math.min(5, bp.size()); // To avoid going out of bounds if there are less than 5 times

			for (int i = 0; i < count && i > 0; i++) { 
				highScoreTimes.add(bp.get(i));
			} */
			
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
		displayHighScoreTimes(c);
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
            //double bestTime = highScoreTimes[i];

            // Display the runner's name and finish time
            c.text(runnerName + ": " + timeText, 400, 50 + i * 20);
        }
        
    }
	
	/**
	 * Displays the high score times from 'output.txt' in descending order.
	 * Will update if new time is less than a top 5 time.
	 * 
	 */
	private void displayHighScoreTimes(PApplet c) {
		c.fill(255);
        c.textSize(18);

        for (int i = 0; i < highScoreTimes.length; i++) {
            if (highScoreTimes[i] != 0.0) {
                c.text("Best Time " + (i + 1) + ": " + highScoreTimes[i], 400, 300 + i * 20);
            }
        }
	}
	
	
	
}
