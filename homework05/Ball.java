/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File Name   :  Ball.java
 *  Purpose     :  Provides ball class for how the ball moves in SoccerSim class
 *  @author     :  Gabriel Say
 *  Date Written:  03/15/2018
 *  Description :  This application is a method for the ball to be generated in
 *                 SoccerSim.
 *  Notes       :  I was unable to get the updated Velocity to appear as a string.
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.text.DecimalFormat;

public class Ball {
  private static final double Radius = 4.45;
  private static final double Diameter = 8.65;
  private static final double Weight = 1; /* why do we need weight? */
  private double[] ballPosition = new double[2];
  private double[] ballVelocity = new double[2];
  private double ballMovement = 0.0;
  private boolean atRest;
  private boolean atMovement;
  private double wheresBall;

  public Ball(double param1, double param2, double param3, double param4) {
    ballPosition[0] = param1;
    ballPosition[1] = param2;
    ballVelocity[0] = param3;
    ballVelocity[1] = param4;

    ballMovement = Math.sqrt((ballVelocity[0]*ballVelocity[0]) + (ballVelocity[1] * ballVelocity[1]));
  }

  public double[] currentPosition(){
    return ballPosition;
  }

  public double[] positionUpdate(double timeSlice){
    ballPosition[0] += ballVelocity[0] * timeSlice;
    ballPosition[1] += ballVelocity[1] * timeSlice;
    return ballPosition;
  }

  public double[] velocityUpdate() {
    ballVelocity[0] = ballVelocity[0] - (ballVelocity[0] / 0.01);
    ballVelocity[1] = ballVelocity[1] - (ballVelocity[1] / 0.01);
    return ballVelocity;
  }

  public boolean atRest() {
    return atRest = (ballMovement < 0.083) ? true : false;
  }

  public boolean atMovement() {
    return atMovement = (ballMovement < 0.083) ? true : false;
  }

  public String toString() {
    DecimalFormat ballSpeed = new DecimalFormat("#0.00");
    DecimalFormat ballLocation = new DecimalFormat("#0.00");
    return "The ball is moving at " + ballSpeed.format(ballMovement) + " ft/s." + " The ball is at " + ballLocation.format(ballPosition[0]) + ", " + ballLocation.format(ballPosition[1]) + " .";
  }
  public static void main (String[] args) {

    System.out.println( "  Creating a new ball: " );
    Ball a = new Ball(10,23,9,3);
    System.out.println( a.toString() );
    System.out.println( "The ball is at rest: " + a.atRest() + ".");
    System.out.println( "The ball is now at: " + a.positionUpdate(32) + ".");
    System.out.println( "The ball is now traveling at: " + a.velocityUpdate() + " ft/s.");

    System.out.println( "  Creating a new ball: " );
    Ball b = new Ball(31,5,9,14);
    System.out.println( b.toString() );
    System.out.println( "The ball is at rest: " + b.atRest() + ".");
    System.out.println( "The ball is now at: " + b.positionUpdate(9) + ".");
    System.out.println( "The ball is now traveling at: " + b.velocityUpdate() + " ft/s.");

    System.out.println( "  Creating a new ball: " );
    Ball c = new Ball(1,2,0,22);
    System.out.println( c.toString() );
    System.out.println( "Test for toString: " + c.toString() + ".");
    System.out.println( "The ball is at rest: " + c.atRest() + ".");
    System.out.println( "The ball is now at: " + c.positionUpdate(54) + ".");
    System.out.println( "The ball is now traveling at: " + c.velocityUpdate() + " ft/s.");

  }
}
