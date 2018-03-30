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
    timeSlice = timeSliceInput;
    totalSeconds = 0.0;
  }

  public double tick(){
    totalSeconds += timeSlice;

    hours = Math.floor(totalSeconds/3600);
    minutes = Math.floor((totalSeconds - (3600* hours))%60);
    seconds = Math.abs(((3600 * hours) - (60 * minutes) - totalSeconds)%60);

    return totalSeconds;
  }

  public String toString() {
    String hAndMString = "00";
    String secondsString = "00.0";
    DecimalFormat formatHourAndMinute = new DecimalFormat(hAndMString);
    DecimalFormat formatSecond = new DecimalFormat(secondsString);
    return formatHourAndMinute.format(hours) + ":" + formatHourAndMinute.format(minutes) + ":" + formatSecond.format(seconds);
  }

  public static void main(String args[]){

      System.out.println( "TESTING tick()...." );

      System.out.println( " Time Slice is equal to 1800 seconds" );
      Timer a = new Timer( 1800 );
      for ( int i = 0; i < 10; i++ ) {
        try { System.out.println( "    Time: " + a.toString() ); }
        catch (Exception e) { System.out.println( e ); }
        a.tick();
      }

      System.out.println( " Time Slice is equal to 356 seconds");
      Timer b = new Timer( 356 );
      for ( int i = 0; i < 10; i++ ) {
        try { System.out.println( "    Time: " + a.toString() ); }
        catch (Exception e) { System.out.println( e ); }
        b.tick();
      }

      System.out.println( " Time Slice is equal to 782 seconds");
      Timer c = new Timer( 782 );
      for ( int i = 0; i < 10; i++ ) {
        try { System.out.println( "    Time: " + c.toString() ); }
        catch (Exception e) { System.out.println( e ); }
        c.tick();
      }

      System.out.println( " Time Slice is equal to 1800 seconds");
      Timer d = new Timer( 2321 );
      for ( int i = 0; i < 10; i++ ) {
        try { System.out.println( "    Time: " + d.toString() ); }
        catch (Exception e) { System.out.println( e ); }
        d.tick();
      }
  }
}
