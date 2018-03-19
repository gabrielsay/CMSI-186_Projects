/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-03-01  Gabriel Say   Added to some functions
 *  @version 1.0.2  2018-03-12  Gabriel Say   Added tests
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   *  Throws exceptions seen twice because it has to be put back into a try catch block
   *  HH:MM:SS.SSSS Format for time
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private double hour;
   private double minute;
   private double seconds;
   private double angle;
   private double timeSlice;
   private double totalSeconds = 0.0;
   private double hourHandAngle = 0.0;
   private double minuteHandAngle = 0.0;

  /**
   *  Constructor goes here
   */
   public Clock() {
     hour    = 0;
     minute  = 0;
     seconds = 0;
     totalSeconds = 0;
     timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
   }
  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
     if (totalSeconds > 43200) {
       totalSeconds = totalSeconds - 43200;
     }
     totalSeconds += timeSlice;
     seconds  = Math.floor(((((totalSeconds / 3600) - hour) * 60) - minute) * 60);
     minute   = Math.floor(((totalSeconds / 3600) - hour) * 60);
     hour     = Math.floor(totalSeconds / 3600);
      return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {

     double angle = 0.0;

     try { angle = Double.valueOf(argValue); }
       catch (Exception e) { throw new NumberFormatException(); }

     if (angle < 0 || angle > MAXIMUM_DEGREE_VALUE) {
       throw new NumberFormatException();
     } else {
     return angle;
     }
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
     double validTimeSlice = Double.valueOf(argValue);
     if (validTimeSlice < 0 || validTimeSlice > 1800) {
       return INVALID_ARGUMENT_VALUE;
     } else {
       return validTimeSlice;
     }
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
     hourHandAngle = Math.abs(totalSeconds * HOUR_HAND_DEGREES_PER_SECOND) % 360;
     return hourHandAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
     minuteHandAngle = Math.abs(totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND) % 360;
      return minuteHandAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     double handAngle = 0.0;
     if (hourHandAngle > minuteHandAngle){
       return handAngle = MAXIMUM_DEGREE_VALUE - Math.abs(hourHandAngle - minuteHandAngle);
     } else {
       return handAngle = MAXIMUM_DEGREE_VALUE - Math.abs(minuteHandAngle - hourHandAngle);
     }
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
     DecimalFormat formatHourAndMinute = new DecimalFormat("00");
     DecimalFormat formatSecond = new DecimalFormat("00.0");
     return formatHourAndMinute.format(hour) + ":" + formatHourAndMinute.format(minute) + ":" + formatSecond.format(seconds);
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

           System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                               "--------------------------\n" );
           System.out.println( "  Creating a new clock: " );
           Clock clock = new Clock();
           System.out.println( "    New clock created: " + clock.toString() );

           System.out.println( "    Testing validateAngleArg()....");
           System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
           try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " Correct" : " - no joy" ); }
           catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

           System.out.print( "      sending '  450 degrees', expecting Exception" );
           try { System.out.println( (450.0 == clock.validateAngleArg( "450.0" )) ? " - got 450.0" : " - no joy" ); }
           catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

           System.out.print( "      sending '  360 degrees', expecting double value   0.0" );
           try { System.out.println( (360.0 == clock.validateAngleArg( "360.0" )) ? " Correct" : " - no joy" ); }
           catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

           System.out.print( "      sending '  26.7 degrees', expecting double value   26.7" );
           try { System.out.println( (26.7 == clock.validateAngleArg( "26.7" )) ? " Correct" : " - no joy" ); }
           catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

           System.out.print( "      sending '  178.92 degrees', expecting double value   178.92" );
           try { System.out.println( (178.92 == clock.validateAngleArg( "178.92" )) ? " Correct" : " - no joy" ); }
           catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

           System.out.print( "      sending '  -72.5 degrees', expecting double value   Exception" );
           try { System.out.println( (-72.5 == clock.validateAngleArg( "-72.5" )) ? " Correct" : " - no joy" ); }
           catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

           //test for validateTimeSliceArg

           System.out.println("     Testing validateTimeSliceArg()....");
           System.out.print("       sending '  354.8 seconds', expecting double value   354.8" );
           try { System.out.println( ( 354.8 == clock.validateTimeSliceArg("354.8")) ? " Correct" : clock.validateTimeSliceArg("354.8")); }
           catch( Exception e ) { System.out.println( " RIP, error." ); }

           System.out.print("       sending '  -213.0 seconds', expecting double value   Exception " );
           try { System.out.println( ( -213.0 == clock.validateTimeSliceArg("-213.0")) ? " Correct" : clock.validateTimeSliceArg("-213.0")); }
           catch( Exception e ) { System.out.println( " RIP, error." ); }

           System.out.print("       sending '  712.941 seconds', expecting double value   712.941" );
           try { System.out.println( ( 712.941 == clock.validateTimeSliceArg("712.941")) ? " Correct" : clock.validateTimeSliceArg("712.941")); }
           catch( Exception e ) { System.out.println( " RIP, error." ); }

           System.out.print("       sending '  1789.2432 seconds', expecting double value   1789.2432" );
           try { System.out.println( ( 1789.2432 == clock.validateTimeSliceArg("1789.2432")) ? " Correct" : clock.validateTimeSliceArg("1789.2432")); }
           catch( Exception e ) { System.out.println( " RIP, error." ); }

           System.out.print("       sending '  2789.2432 seconds', expecting double value   Exception " );
           try { System.out.println( ( 2789.2432 == clock.validateTimeSliceArg("2789.2432")) ? " Correct" : clock.validateTimeSliceArg("2789.2432")); }
           catch( Exception e ) { System.out.println( " RIP, error." ); }

           //test for getHourHandAngle, toString, and getMinuteHandAngle

           System.out.println("     Testing getHourHandAngle()....");
           clock.totalSeconds = 19800;
           clock.tick();
           System.out.println("Current time = " + clock.toString() );
           System.out.println("The hour hand has an angle of " + clock.getHourHandAngle() + " degrees.\n");

           clock.totalSeconds = -4431;
           clock.tick();
           System.out.println("Current time = " + clock.toString() );
           System.out.println("The hour hand has an angle of " + clock.getHourHandAngle() + " degrees.\n");

           clock.totalSeconds = 43200;
           clock.tick();
           System.out.println("Current time = " + clock.toString() );
           System.out.print("The hour hand has an angle of " + clock.getHourHandAngle() + " degrees.\n");

           clock.totalSeconds = 8934;
           clock.tick();
           System.out.println("Current time = " + clock.toString() );
           System.out.print("The minute hand has an angle of " + clock.getMinuteHandAngle() + " degrees.\n");

           clock.totalSeconds = 654;
           clock.tick();
           System.out.println("Current time = " + clock.toString() );
           System.out.print("The minute hand has an angle of " + clock.getMinuteHandAngle() + " degrees.\n");

           clock.totalSeconds = 1800;
           clock.tick();
           System.out.println("Current time = " + clock.toString() );
           System.out.print("The minute hand has an angle of " + clock.getMinuteHandAngle() + " degrees.\n");

   }
}

