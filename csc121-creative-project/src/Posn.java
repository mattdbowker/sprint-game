/* class for positions of the players*/
class Posn {
  private double x;
  private double y;
  
  Posn(double x, double y) {
    this.x = x;
    this.y = y;
  }
  /* Get the x posn value*/
  public double getX() {
	  return x;
  }
  /* Get the y posn value*/
  public double getY() {
	  return y;
  }
  /* updates the x value of the posn*/
  public void setX(double updatedX) {
	this.x = updatedX;
  }
}