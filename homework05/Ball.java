/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File Name   :  Ball.java
 *  Purpose     :  Provides ball class for how the ball moves in SoccerSim class
 *  @author     :  Gabriel Say
 *  Date Written:  03/15/2018
 *  Description :  This application is a method for
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.text.DecimalFormat;

public class Ball {
  public static final double Radius = 4.45;
  public static final double Diameter = 8.65;
  public static final double Weight = 1; /* why do we need weight? */
  private double xPos = 0.0;
  private double yPos = 0.0;
  private double xVel = 0.0;
  private double yVel = 0.0;
  private boolean atRest;

  public Ball (double param1, double param2, double param3, double param4){
    xPos = param1;
    yPos = param2;
    xVel = param3;
    yVel = param4;

    atRest = Math.sqrt((xVel*xVel+yVel*yVel) < 0.083);
  }

}

/**
* Two indices per array

Ball[] balls = null;
* IF we see that each ball has its four attributes do the following:

balls = new Ball[3];
int j = 0;
for (....i+=4) {
  balls[j] = new Ball(
  Double.parseDouble(args[i+0]),
  "     "      "[i+1],
  "     "      "[i+2],
  "     "      "[i+3])
  );
}

xpos = Double.p.....args[i+0]
ypos = "  "  "[i+1]
xvel =        [i+2]
yvel =
balls[j] = new Ball(xpos, ypos, xvel, yvel);

* at bottom of loop, afteer making new ball, add j++ so that it continues until
       there are no args input

* instead of doing all Double.parseDouble can do all in one line by using comma in constructor
*/
