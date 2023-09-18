import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 *
 */
public class TrackWorld {
	// positions of various elements
	double x;
	double y;


    public TrackWorld(double x, double y) {
        this.x = x;
        this.y = y; 
    }

	/**
	 * Renders a picture of the drop on the window
	 */
	Runner r1 = new Runner(25, "blue", .5, new Posn(25,40));
	Runner r2 = new Runner(25, "green", .2, new Posn(25,80));
	Runner r3 = new Runner(25, "red", .7, new Posn(25,120));
	Runner r4 = new Runner(25, "purple", .1, new Posn(25,160));
	
	Player me = new Player(25, "white", new Posn(25,190));
	int count = 0;	
	
	public PApplet draw(PApplet c) {
		c.background(214, 99, 82);
		c.line(40,0, 40, 200);		// start line
		c.stroke(255,255,255);
		c.fill(255,255,255);
		c.textSize(12);
		c.text("Start!", 5, 20);
		

		
		c.line(755,0, 755, 200);	// finish line
		c.fill(255,255,255);
		c.textSize(12);
		c.text("Finish!", 760, 20);

		
		c.fill(255,255,255);
		int elapsedTimeInSeconds = c.millis() / 1000;
		c.textSize(20);
		c.text("Time:" + elapsedTimeInSeconds, 380,15);
		
		
		
		c.fill(0, 0, 255);
		c.circle((int)r1.p.x, (int)r1.p.y, r1.size);
		c.fill(0, 255, 0);
		c.circle((int)r2.p.x, (int)r2.p.y, r2.size);
		c.fill(255,0,0);
		c.circle((int)r3.p.x, (int)r3.p.y,r3.size);
		c.fill(255, 0, 255);
		c.circle((int)r4.p.x, (int)r4.p.y, r4.size);
		//c.fill(255, 255, 255);
		//c.circle((int)me.p.x, (int)me.p.y, me.size);
		
		c.line(0, 60, 800, 60);
		c.line(0, 100, 800, 100);
		c.line(0, 140, 800, 140);
		
		return c;
	}

	/**
	 * Produces an updated world where the circle moves
	 * across the screen, if it hasn't hit the finish
	 * line yet.
	 * If it has reached the finish line(for now it resets)
	 * later we will most likely have a finish sequence presenting the winner
	 */
	public TrackWorld update() {
		double updatedX1 = r1.p.x + r1.speed; // updates the x-posn of r1
		double updatedX2 = r2.p.x + r2.speed; // updates the x-posn of r2
		double updatedX3 = r3.p.x + r3.speed; // updates the x-posn of r3
		double updatedX4 = r4.p.x + r4.speed; // updates the x-posn of r4
		
		//double updatedPlayer = me.p.x + .5;   // given speed per key press of player
		
		if (updatedX1 < 750  && updatedX2 < 750 
				&& updatedX3 < 750   && updatedX4 < 750 ) {
			r1.p.x = updatedX1;
			r2.p.x = updatedX2;
			r3.p.x = updatedX3;
			r4.p.x = updatedX4;
			count += 1;
		} else { // resets the x posn back to the start after one has made it to finish
			
			r1.p.x=25;
			r2.p.x=25;
			r3.p.x=25;
			r4.p.x=25;
		}
		return this;
	}

	/**
	 * moves player based on keys pressed
	 */
	public TrackWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == '<') { // left key <
			return new TrackWorld(this.x, this.y + .5);
			
		} else if (kev.getKey() == '>') { // left key >
			return new TrackWorld(this.x, this.y);
		
		} else {
			return this;
		}
			
	}
	
	

	/**
	 * Produces a string rendering of the position of the
	 * drop
	 */
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
