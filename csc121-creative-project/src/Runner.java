
// class representing a runner (circle) on the track
public class Runner {
    int size;
    String color;
    double speed;
    Posn p;

    public Runner(int size, String color, Posn p) {
        this.size = size;
        this.color = color;
        this.speed = Math.random();
        this.p = p;
    }

}
