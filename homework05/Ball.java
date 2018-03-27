/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File Name   :  Ball.java
 *  Purpose     :  Provides ball class for how the ball moves in SoccerSim class
 *  @author     :  Gabriel Say
 *  Date Written:  03/15/2018
 *  Description :  This application is a method for
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.text.DecimalFormat;

public class Ball {
  private static final double Radius = 4.45;
  private static final double Diameter = 8.65;
  private static final double Weight = 1; /* why do we need weight? */
  private double[] ballPosition;
  private double[] ballVelocity;
  private double ballMovement = 0.0;
  private boolean atRest;
  private boolean atMovement;
  private double wheresBall;

  public Ball(double param1, double param2, double param3, double param4) {
    ballPosition[0] = param1;
    ballPosition[1] = param2;
    ballVelocity[2] = param3;
    ballVelocity[3] = param4;

    ballMovement = Math.sqrt((ballVelocity[2]*ballVelocity[2]) + (ballVelocity[3] * ballVelocity[3]));
    wheresBall = Double.parseDouble(ballPosition[2] + ", " + ballPosition[3]);
  }

  public double[] currentPosition(){
    return ballPosition;
  }

  public double[] positionUpdate(double timeSlice){
    ballPosition[0] = ballPosition[0] + (ballVelocity[2] * timeSlice);
    ballPosition[1] = ballPosition[1] + (ballVelocity[3] * timeSlice);
    return ballPosition;
  }

  public double[] currentVelocity() {
    return ballVelocity;
  }

  public double[] velocityUpdate() {
    ballVelocity[2] = ballVelocity[2] - (ballVelocity[2] / 0.01);
    ballVelocity[3] = ballVelocity[3] - (ballVelocity[3] / 0.01);
    return ballVelocity;
  }

  public boolean atRest() {
    return atRest = (ballMovement < 0.083) ? true : false;
  }

  public boolean atMovement() {
    return atMovement = (ballMovement < 0.082) ? true : false;
  }

  public String toString() {
    DecimalFormat ballSpeed = new DecimalFormat("#0.00");
    DecimalFormat ballLocation = new DecimalFormat("#0.00");
    return "The ball is moving at " + ballSpeed.format(ballMovement) + " feet." + "The ball is at " + ballLocation.format(wheresBall) + " .";
  }
  public static void main (String[] args) {

  }
}
