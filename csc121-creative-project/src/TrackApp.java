import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class TrackApp extends PApplet {
    IWorld currentState;
    
    public void settings() {
        this.size(800,550);// need to use screen size here

    }
    
    public void setup() {
        //w = new TrackWorld(200, 0);
        currentState = new WelcomeState();
    }
    
    public void draw() {
        currentState = currentState.update();
    	//w = w.update();
    	//w.draw(this);
        currentState.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
        //w = w.mousePressed(mev);
    }
    
    public void keyPressed(KeyEvent kev) {
    	 //w = w.keyPressed(kev);
         currentState = currentState.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "TrackApp" }, new TrackApp());
    }
}
