
// class representing a runner (circle) on the track
public class Runner {
    int size;
    String color;
    double speed;
    Posn p;
    double finishTime;
    
    double min = 0.5; // Minimum value
    double max = 1.0; // Maximum value
    double randomValue = min + (Math.random() * (max - min));	// increase other runners speed so they aren't as slow


    public Runner(int size, String color, Posn p) {
        this.size = size;
        this.color = color;
        this.speed = randomValue;
        this.p = p;
        //this.finishTime = finishTime;
    }
    
    /*
    public void crossFinishLine() {
        
        }
    }

    public long getTime() {
        
        }
        return finishTime;
    }*/

}
