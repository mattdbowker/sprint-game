import processing.core.PApplet;
import processing.event.KeyEvent;

/** Represents the currently active thing 
 *  that is goings on in the app's window */
public interface IWorld {
	PApplet draw(PApplet c);
	IWorld update();
	IWorld keyPressed(KeyEvent key);
}
