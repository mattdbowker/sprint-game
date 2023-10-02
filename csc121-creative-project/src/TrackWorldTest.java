import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.event.*;

class TrackWorldTest {

    TrackWorld cw1 = new TrackWorld(100, 150);
    

    @Test
    void tests() {        
        assertEquals("[100.0, 150.0]", cw1.toString());
        
        assertEquals("[100.0, 150.0]", cw1.update().toString());
        assertEquals("[100.0, 150.0]", cw1.update().update().toString());
        
        //assertEquals("[200.0, 135.0]", cw1.mousePressed(new MouseEvent(null, 1, 0, 0, 200, 135, 0, 1)).toString());
    }

}
