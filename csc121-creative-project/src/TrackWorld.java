import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 *
 */
public class TrackWorld implements IWorld{
	// positions of various elements
	double x;
	double y;


	public TrackWorld(double x, double y) {
		this.x = x;
		this.y = y; 
	}

   /**
    * Runners displayed on the track
    */
	Runner r1 = new Runner(25, "blue", new Posn(25,40));
	Runner r2 = new Runner(25, "green", new Posn(25,80));
	Runner r3 = new Runner(25, "red", new Posn(25,120));
	Runner r4 = new Runner(25, "purple", new Posn(25,160));
	Player me = new Player(25, "white", new Posn(25,200));

	public PApplet draw(PApplet c) {
		startLine(c);
		finishLine(c);
		timer(c);
		players(c);
		trackLines(c);
		return c;
	}
	void startLine(PApplet c) {
		c.background(214, 99, 82);
		c.line(40,0, 40, 220);		// start line
		c.stroke(255,255,255);
		c.fill(255,255,255);
		c.textSize(12);
		c.text("Start!", 20, 20);
	}
	void finishLine(PApplet c) {
		c.line(755,0, 755, 220);	// finish line
		c.fill(255,255,255);
		c.textSize(12);
		c.text("Finish!", 780, 20);
	}
	void timer(PApplet c) {
		c.fill(255,255,255);
		int elapsedTimeInSeconds = c.millis() / 1000;
		c.textSize(20);
		c.text("Time:" + elapsedTimeInSeconds, 380,15);
	}
	void players(PApplet c) {
		c.fill(0, 0, 255);
		c.circle((int)r1.p.x, (int)r1.p.y, r1.size);
		c.fill(0, 255, 0);
		c.circle((int)r2.p.x, (int)r2.p.y, r2.size);
		c.fill(255,0,0);
		c.circle((int)r3.p.x, (int)r3.p.y,r3.size);
		c.fill(255, 0, 255);
		c.circle((int)r4.p.x, (int)r4.p.y, r4.size);
		c.fill(255, 255, 255);
		c.circle((int)me.p.x, (int)me.p.y, me.size);
	}
	void trackLines(PApplet c) {
		c.line(0, 60, 800, 60);
		c.line(0, 100, 800, 100);
		c.line(0, 140, 800, 140);
		c.line(0, 180, 800, 180);
	}
	/**
	 * Produces an updated world where the circle moves
	 * across the screen, if it hasn't hit the finish
	 * line yet.
	 * If it has reached the finish line(for now it resets)
	 * later we will most likely have a finish sequence presenting the winner
	 */
	private boolean X1 = false;
	private boolean X2 = false;
	private boolean X3 = false;
	private boolean X4 = false;
	private boolean Player = false;
	public IWorld update() {
		double updatedX1 = r1.p.x + r1.speed; // updates the x-posn of r1
		double updatedX2 = r2.p.x + r2.speed; // updates the x-posn of r2
		double updatedX3 = r3.p.x + r3.speed; // updates the x-posn of r3
		double updatedX4 = r4.p.x + r4.speed; // updates the x-posn of r4

		while(!(X1 && X2 && X3 && X4 && Player)){ 
			r1.p.x = updatedX1;
			r2.p.x = updatedX2;
			r3.p.x = updatedX3;
			r4.p.x = updatedX4;
			if(updatedX1 >= 770) {
				X1 = true;
				r1.p.x = 770;
				//r1.crossFinishLine();
			}
			if(updatedX2 >= 770) {
				X2 = true;
				r2.p.x = 770;
				//r2.crossFinishLine();
			}
			if(updatedX3 >= 770) {
				X3 = true;
				r3.p.x = 770;
				//r3.crossFinishLine();
			}
			if(updatedX4 >= 770) {
				X4 = true;
				r4.p.x = 770;
				//r4.crossFinishLine();
			}
			if(me.p.x >= 770) {
				Player = true;
				me.p.x = 770;
				//me.crossFinishLine();
			}
			
			/*
			 //Check if all runners have finished and record their times
		    if (X1 && X2 && X3 && X4 && !Player) {
		        long[] times = {r1.getTime(), r2.getTime(), r3.getTime(), r4.getTime(), me.getTime()};
		        return new FinishState(times); // Pass the recorded times to FinishState
		    }*/
			
			
			return this;
		}
		return new FinishState();
	}

	/**
	 * moves player based on keys pressed
	 */
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == 'a') { // left key <
			me.p.x += 5;
		} else if (kev.getKey() == 'd') { // right key >
			me.p.x += 5;
		}
		return this;
	}



	/**
	 * Produces a string rendering of the position of the
	 * drop
	 */
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
