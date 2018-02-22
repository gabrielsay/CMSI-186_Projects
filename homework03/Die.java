/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  B.J. Johnson
 *  Student       :  Gabriel Say
 *  Date          :  2017-02-06
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-02-17  B.J. Johnson  Filled in method code
 *  @version 1.2.0  2018-02-18  Gabriel Say   Input code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
     if (nSides < MINIMUM_SIDES){
       throw new IllegalArgumentException("Need at least four sides!");
     } else {
       this.sides = nSides;
     }
   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
      return this.pips = (int)((Math.random()*sides)+1);
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
      return this.pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public void setSides( int sides ) {
     if ( sides < MINIMUM_SIDES ) {
       throw new IllegalArgumentException("Need more sides!");
     } else {
       this.sides = sides;
     }
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
     String dieInstance = Integer.toString(this.pips);
      return dieInstance;
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) {
     String dInstance = Integer.toString(d.pips);
      return dInstance;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {

     Die a = new Die (9);
     System.out.println("\n Test a \n");
     System.out.println( "First roll for Die a: " + a.roll() );
     System.out.println( "Last roll for Die a: " + a.roll() );

     Die b = new Die(6);
     System.out.println("\n Test b \n");
     System.out.println( "First roll for Die b: " + b.roll() );
     System.out.println( "Second roll for Die b: " + b.roll() );
     System.out.println( "Final roll for Die b: " + b.roll() );
        try { b.setSides(2);
        System.out.println("Reset Die b roll: " + b.roll()); }
        catch ( IllegalArgumentException e ) { System.out.println("Try a different sides configuration."); }

     Die c = new Die(56);
     System.out.println("\n Test c \n");
     System.out.println( "First roll for Die c: " + c.roll() );
     System.out.println( "Second roll for Die c: " + c.roll() );
     System.out.println( "Final roll for Die c: " + c.roll() );
        try { c.setSides(12);
        System.out.println("Reset Die c roll= " + c.roll()); }
        catch ( IllegalArgumentException e ) { System.out.println("Try a different sides configuration."); }

     Die d = new Die (21);
     System.out.println("\n Test d \n");
     System.out.println( "First roll for Die d: " + d.roll() );
     System.out.println( "Last roll for Die d: " + d.roll() );
        try { c.setSides(8);
        System.out.println("Reset Die d roll= " + d.roll()); }
        catch ( IllegalArgumentException e ) { System.out.println("Try a different sides configuration."); }
     System.out.println("Public Instance test for the string= " + d.toString());

      System.out.println( "\nHaha, rolling dice is cool now.\n" );
   }

}
