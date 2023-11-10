import static processing.core.PConstants.CENTER;
import processing.core.PApplet;
import processing.event.KeyEvent;
public class WelcomeState implements IWorld{
	private int players = 1;
	@Override
	public PApplet draw(PApplet c) {
		c.background(214, 99, 82);
		c.textSize(24);
		c.textAlign(CENTER);
		c.text("Press space bar to start", 400, 50);
		c.textSize(20);
		c.text("Use keys 'a' and 'd' to move player", 400, 80);
		return c;
	}

	@Override
	public IWorld update() {
		return this;
	}

	/* Updates from the Welcome State to the game*/
	public IWorld keyPressed(KeyEvent key) {
		if (key.getKey() == 'i') {
			players++;
		}else if (key.getKey() == 'k') {
			players--;
		}
		if (key.getKey() == ' ') {
			TrackWorld w = new TrackWorld(players);
			return w;
		}
		return this;
	}
}
