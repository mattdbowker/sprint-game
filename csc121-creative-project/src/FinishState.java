import processing.core.PApplet;
import processing.event.KeyEvent;

public class FinishState implements IWorld {
	
	//private long[] runnerTimes; // Array to store the recorded times

    //public FinishState(long[] runnerTimes) {
    //    this.runnerTimes = runnerTimes;
    //}
    

	@Override
	public PApplet draw(PApplet c) {
		c.background(214, 99, 82);
		c.textSize(24);
		c.textAlign(c.CENTER);
		c.text("FINISHED", 400, 20);
		c.textSize(18);
		c.text("First:", 349, 50);
        c.text("Second:", 357, 70);
        c.text("Third:", 350, 90);
        c.text("Fourth:", 357, 110);
        c.text("Fifth:", 348, 130);
		
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

}
