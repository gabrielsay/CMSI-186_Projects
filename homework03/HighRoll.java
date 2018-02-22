/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File Name  : HighRoll.java
* Purpose    : This program provides the platform for the dice to be used in a game
* @author    : Gabriel Say
* Date       : 2018-02-15
* Description: This makes a game using the Die and DiceSet programs.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {

  int highScore = 0;
  int DiceSet = 0;

  public static void main( String args[] ) {

    System.out.println( "\n Main Menu\n" );
    System.out.println( " Select '1'  to ROLL ALL THE DICE" );
    System.out.println( " Select '2'  to ROLL A SINGLE DIE" );
    System.out.println( " Select '3'  to CALCULATE THE SCORE FOR THIS SET" );
    System.out.println( " Select '4'  to SAVE THIS SCORE AS HIGH SCORE" );
    System.out.println( " Select '5'  to DISPLAY THE HIGH SCORE" );
    System.out.println( " Select 'Q'  to quit program." );
    DiceSet ds = new DiceSet();

    BufferedReader input = new BufferedReader(new InputStreamReader( System.in));
    while( true ){
      System.out.println("\n Type in option \n");
      String inputLine = null;
         try { inputLine = input.readLine();
             if ('1' == input.readLine(0)){

          }
     }
   }
  }
}
