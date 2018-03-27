**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

    while (seconds >= 60.0) {
      minutes += 1;
      seconds -= 60.0;
    }
    while (minutes >= 60.0){
      hours += 1;
      minutes -= 60.0;
    }
  }

  public String toString() {
    DecimalFormat formatHourAndMinute = new DecimalFormat("#0.00");
    DecimalFormat formatSecond = new DecimalFormat("#0.000");
    return formatHourAndMinute.format(hours) + ":" + formatHourAndMinute.format(minutes) + ":" + formatSecond.format(seconds);
  }

}
