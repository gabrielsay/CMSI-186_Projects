/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File Name   : SoccerSim.java
* Purpose     : Provides a movement class, an out of bounds class, and a
*               collision class.
* @author     : Gabriel Say
* Date Written: 03/23/2018
* Description : This program is meant to simulate a soccer ball using the Ball
*               and Timer programs. It also provides the bounds which limit
*               how the soccer ball interacts within an xy axis (Soccer field).
*               The field is set to 1000x800 since soccer fields are not square.
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class SoccerSim {
  private static final double fieldLength = 1000;
  private static final double fieldWidth = 800;
  private static final double xPosPole = 345;
  private static final double yPosPole = 12;
  private static final double defaultTimeSlice = 1.0;
  private double timeSlice;
  private Ball[] soccerBalls = null;
  private Timer clock = null;

  public SoccerSim() {
    Timer clock = new Timer(defaultTimeSlice);
  }

  public double validateInitialSetup (String args[]){
    if (args.length < 4){
      System.out.println(     "\n There must be four inputs per ball and a final arg for time slices. \n" +
          "\n input x, input y, velocity x, velocity y, time slice \n" +
          "\n Please try again by calling the program again!! \n" );
      System.exit(0);
    } else if ((args.length % 4 != 0) && (args.length % 4 != 1)) {
      System.out.println(    "\n There must be four inputs per ball and a final arg for time slices. \n" +
          "\n input x, input y, velocity x, velocity y, time slice \n" +
          "\n Please try again by calling the program again!! \n" );
      System.exit(0);
    } else if (args.length % 4 == 0) {
      timeSlice = defaultTimeSlice;
    } else {
      try { timeSlice = Timer.validateTSArg(args [args.length - 1]);
      } catch ( Exception e) {
        System.out.println(    "\n There must be four inputs per ball and a final arg for time slices. \n" +
            "\n input x, input y, velocity x, velocity y, time slice \n" +
            "\n Please try again by calling the program again!! \n" );
     System.exit (0);
      }
      int soccerBallNumber = (int)Math.floor( args.length / 4 );
      soccerBalls = new Ball[soccerBallNumber.length];
      int i = 0;
      int j = 0;
      for (i = 0; i.soccerBalls.length; i+=4) {
        soccerBalls[i] = new Ball(
        Double.parseDouble(args[i+0]),
        Double.parseDouble(args[i+1]),
        Double.parseDouble(args[i+2]),
        Double.parseDouble(args[i+3])
        );
      }
    }
  }

  public boolean poleCollisionOccured() {
    if ((soccerBalls(Double.parseDouble(args[i+0])) = xPosPole) && (soccerBalls(Double.parseDouble(args[i+1])) = yPosPole)) {
      return true;
    } else{
      return false;
    }
  }

  public boolean outOfBounds() {
    if ((soccerBalls(Double.parseDouble(args[i+0])) >= fieldLength) && (soccerBalls(Double.parseDouble(args[i+1])) >= fieldWidth)){
      return true;
    } else {
      return false;
    }
  }

  public static void main (String args[]) {
    System.out.println("\n Welcome to Soccer Sim program! \n");
    validateInitialSetup(args);
    System.out.println("\n Soccer field is " + fieldLength + " by " + fieldWidth + ".");
    System.out.println("\n There is a pole at " + xPosPole + " and " + yPosPole + ".");
    System.out.println("\n The time is being counted by " + timeSlice + "," + " but if it equals " + defaultTimeSlice + ", no timeSlice was input.");
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
