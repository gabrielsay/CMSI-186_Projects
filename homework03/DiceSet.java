/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Student Author:  Gabriel Say
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-02-09  Gabriel Say   Update to skeleton code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
     this.count = count;
     this.sides = sides;
       ds = new Die[this.count];
       if (this.count < 1) {
         throw new IllegalArgumentException("Need more die!");
       } for (int i = 0; i < this.count; i++) {
         ds[i] = new Die(this.sides);
       }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     int sum = 0;
     for ( int i = 0; i < count; i++ ) {
       sum += ds[i].getValue();
     }
      return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for ( int i = 0; i < count; i ++) {
       System.out.println(ds[i].roll());
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     if ( dieIndex <= 0 || dieIndex > count ) {
       throw new IllegalArgumentException ("Out of Range.");
     } else {
       return ds[dieIndex].roll();
     }
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     if ( dieIndex <= 0 || dieIndex > count ) {
       throw new IllegalArgumentException("Out of Range.");
     }
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
     String result = "";
      for ( int k = 0; k < count; k++ ) {
        result += ds[k].toString();
      }
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }

  /**
  * @return  tru iff this set is identical to the set passed as an argument
  */
   public boolean isIdentical( DiceSet ds1 ) {
     if (this.count == ds1.count){
       if (this.sides == ds1.sides) {
         if(this.sum() == ds1.sum()) {
           return true;
         }
       }
     }
      return false;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {

     DiceSet a = new DiceSet(1,6);
     a.roll();
     System.out.println( "Sum of roll a: " + a.sum() );
     try{ System.out.println( "Individual number from roll a: " + a.rollIndividual(6));}
     catch (IllegalArgumentException e) {System.out.println("Maybe a different index??");}
     System.out.println();

     DiceSet c = new DiceSet(11,43);
     c.roll();
     System.out.println( "Sum of roll c: " + c.sum() );
     try{ System.out.println( "Individual number from roll c: " + c.rollIndividual(4));}
     catch (IllegalArgumentException e) {System.out.println("Maybe a different index??");}
     System.out.println();

     DiceSet d = new DiceSet(2,9);
     d.roll();
     System.out.println( "Sum of roll d: " + d.sum() );
     try{ System.out.println( "Individual number from roll d: " + d.rollIndividual(9));}
     catch (IllegalArgumentException e) {System.out.println("Maybe a different index??");}
     System.out.println();

     DiceSet b = new DiceSet(3,75);
     b.roll();
     System.out.println( "Sum of roll b: " + b.sum() );
     try{ System.out.println("Individual number from roll b: " + b.rollIndividual(3));}
     catch (IllegalArgumentException e) {System.out.println("Maybe a different index??");}
      // You do this part!
   }

}
