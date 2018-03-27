/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*  File Name   :  Timer.java
*  Purpose     :  Provides a class for defining time related methods in SoccerSim
*                 class
*  @author     :  Gabriel Say
*  Date Written:  03/15/2018
*  Description :  This class is meant to provide methods for the SoccerSim to emulate
*                 the times that may affect the soccer ball.
**/
import java.text.DecimalFormat;


public class Timer {
  private static double hours;
  private static double minutes;
  private static double seconds;
  private static double timeSlice;
  private static double totalSeconds;

  public Timer(double timeSliceInput) {
    hours     = 0.0;
    minutes   = 0.0;
    seconds   = 0.0;
    totalSeconds = 0.0;
    timeSlice = timeSliceInput;
  }

  public double tick(){
    totalSeconds += timeSlice;

    hours = Math.floor(totalSeconds/3600);
    minutes = Math.floor(totalSeconds - (3600* hours));
    seconds = totalSeconds - (3600 * hours) - (60 * minutes);

    return totalSeconds;
  }

  public String toString() {
    DecimalFormat formatHourAndMinute = new DecimalFormat("#0.00");
    DecimalFormat formatSecond = new DecimalFormat("#0.000");
    return formatHourAndMinute.format(hours) + ":" + formatHourAndMinute.format(minutes) + ":" + formatSecond.format(seconds);
  }

  public static void main(String[] args){
      Timer a = new Timer( 1800 );
      System.out.println( a.toString() );

      System.out.println( "TESTING tick()...." );

      System.out.println( " Time Slice is equal to 1800 seconds");
      for ( int i = 0; i < 10; i++ ) {
        try { System.out.println( "    Time: " + a.toString() ); }
        catch (Exception e) { System.out.println( e ); }
        a.tick();
      }
  }
}
