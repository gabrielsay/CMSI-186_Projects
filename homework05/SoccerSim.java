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
  private static final double timeSlice;
  private Ball[] soccerBalls = null;
  private Timer clock = null;

  public SoccerSim() {
    Timer clock = new Timer();
  }

  public double validateInitialSetup (String args[]){
    if (args.length < 4){
      System.out.println(     "\n There must be four inputs per ball. \n" +
          "\n input x, input y, velocity x, velocity y \n" +
          "\n Please try again by calling the program again!! \n" );
      System.exit(0);
    } else if ((args.length % 4 != 0) && (args.length % 4 != 1)) {
      System.out.println(    "\n There must be four inputs per ball. \n" +
          "\n input x, input y, velocity x, velocity y \n" +
          "\n Please try again by calling the program again!! \n" );
      System.exit(0);
    } else if (arg.length % 4 == 0) {
      try { soccerBalls = new Ball(args.length/4);
      }
    }
  }

}
