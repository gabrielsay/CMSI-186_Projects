/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File Name   :  Timer.java
*  Purpose     :  Provides a class for defining time related methods in SoccerSim
*                 class
*  @author     :  Gabriel Say
*  Date Written:  03/15/2018
*  Description :  This class is meant to provide methods for the SoccerSim to emulate
*                 the times that may affect the soccer ball.
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Timer {
  private double hours;
  private double minutes;
  private double seconds;
  private double timeSlice;

  public Timer() {
    hours     = 0.0;
    minutes   = 0.0;
    seconds   = 0.0;
    timeSlice = 0.0;
  }

  public Timer(double param1, double param2, double param3, double param4) {
    if (param1 < 0 || param2 < 0 || param3 < 0 || param4 < 0 || param4 >1800) {
      throw new IllegalArgumentException();
    } hours = param1;
    minutes = param2;
    seconds = param3;
    timeSlice = param4;
  }


  public void tick(){
    seconds += timeSlice;
    seconds  = Math.floor(((((seconds / 3600) - hours) * 60) - minutes) * 60);
    minutes   = Math.floor(((seconds / 3600) - hours) * 60);
    hours     = Math.floor(seconds / 3600);
     return seconds;

  }

}


/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~NOTES FOR HW 5!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* velocity is given in Feet per seconds.
* xDir and yDir give the direction to where the balls are going after being kicked.
* 1%/second is the velocity; to be exact, look up instantaneous velocity of rolling
* ball.
* Vf = Vo- ((Vo* 0.01)* timeSlice); need to do twice for x and y direcion.
* How do we know when ball comes to rest; could look at both Vf or hypotenuse or
*     using trig functions.
* If zero is given, add given arg of 1
* Make sure there is a pole. can be a point or non moving ball
* 8.9 inches away from each other is considered contact
*     On contact, the ball should return "CONTACT ball"
*     If there is no collision, return "NO COLLISION POSSIBLE"
*     Friction can make a curve which may prevent collision
* Be able to convert from feet to inches to determine when ball stops which is
* IPS less than or equal to 1 but IPS needs to be converted to FPS (in/ft per sec)
* 1 percent per second decrease
* 0.083 should be considered rest
* To test collision of balls, angle the kick so that they collide (Force issue)
* There needs to be a ball and don't force the user to input the ball after saying
*    "sorry there is no ball." Instead restart program if there are no args input
* Give each ball a line of its own which return position and velocity per tick
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
