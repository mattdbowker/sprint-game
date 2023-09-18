import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class TrackApp extends PApplet {
    TrackWorld w;
    
    public void settings() {
        this.size(800, 200);
    }
    
    public void setup() {
        w = new TrackWorld(200, 0);
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
        //w = w.mousePressed(mev);
    }
    
    public void keyPressed(KeyEvent kev) {
         w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "TrackApp" }, new TrackApp());
    }
}
