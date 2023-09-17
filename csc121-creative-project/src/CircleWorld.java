import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 *
 */
public class CircleWorld {
	// the position of the drop
	double x;
	double y;


    public CircleWorld(double x, double y) {
        this.x = x;
        this.y = y; 
    }

	/**
	 * Renders a picture of the drop on the window
	 */
	Runner r1 = new  Runner(25,"blue", .5, new Posn(25,40));
	Runner r2 = new  Runner(25,"green", .2, new Posn(25,80));
	Runner r3 = new  Runner(25,"red", .7, new Posn(25,120));
	Runner r4 = new  Runner(25,"purple", .1, new Posn(25,160));
	int count = 0;
	//int tm = count/1000;
	public PApplet draw(PApplet c) {
		c.background(255);
		c.line(40,0, 40, 200);
		c.fill(0,0,0);
		c.text("Start!", 5, 20);
		c.line(355,0, 355, 200);
		c.fill(0,0,0);
		c.text("Finish!", 360, 20);
		c.fill(0,0,0);
		c.text("Time:", 180,10);
		c.fill(0, 0, 255);
		c.circle((int)r1.p.x, (int)r1.p.y, r1.size);
		c.fill(0, 255, 0);
		c.circle((int)r2.p.x, (int)r2.p.y, r2.size);
		c.fill(255,0,0);
		c.circle((int)r3.p.x, (int)r3.p.y,r3.size);
		c.fill(255, 0, 255);
		c.circle((int)r4.p.x, (int)r4.p.y, r4.size);
		return c;
	}

	/**
	 * Produces an updated world where the circle moves
	 * across the screen, if it hasn't hit the finish
	 * line yet.
	 * If it has reached the finish line(for now it resets)
	 * later we will most likely have a finish sequence presenting the winner
	 */
	public CircleWorld update() {
		double updatedX1 = r1.p.x + r1.speed; // updates the x-posn of r1
		double updatedX2 = r2.p.x + r2.speed; // updates the x-posn of r2
		double updatedX3 = r3.p.x + r3.speed; // updates the x-posn of r3
		double updatedX4 = r4.p.x + r4.speed; // updates the x-posn of r4
		if (updatedX1 < 350  && updatedX2 < 350 
				&& updatedX3 < 350   && updatedX4 < 350 ) {
			r1.p.x = updatedX1;
			r2.p.x = updatedX2;
			r3.p.x = updatedX3;
			r4.p.x = updatedX4;
			count += 1;
		}else { // resets the x posn back to the start after one has made it to finish
			
			r1.p.x=25;
			r2.p.x=25;
			r3.p.x=25;
			r4.p.x=25;
		}
		return this;
	}

	/**
	 * Produces an updated world with the position of the
	 * drop updated to the location of the mouse press.
	 */
	public CircleWorld mousePressed(MouseEvent mev) {
		return new CircleWorld(mev.getX(), mev.getY());
	}

	/**
	 * Produces a string rendering of the position of the
	 * drop
	 */
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
