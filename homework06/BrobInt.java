/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  B.J. Johnson
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *  1.2.0  2018-04-03  Gabriel Say   Started adding code to each method
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.util.ArrayList;
/** How I found ArrayList and a basic idea for the addition algorithm
https://www.quora.com/How-can-we-add-two-large-numbers-without-using-any-integer-data-type-in-java
**/

public class BrobInt {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   private String internalValue = "";        // internal String representation of this BrobInt
   private byte   sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   private byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string
   private boolean positiveNumber = true;
   private ArrayList<Integer> valueList = new ArrayList<>();

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
     super();
     String brobValue = value;
     long brob = value.length();
     int space = 0;

     //check for negative
     if (value.charAt(0) == '-'){
       sign = 1;
       positiveNumber = false;
     } else {
       sign = 0;
       positiveNumber = true;
     }
     //Add string to to internal values
     if (value.length() == 0) {
       valueList.add (0);
     } else {
       if (value.length() > 1 && value.substring(0,1).equals("-")) {
         valueList.add(Integer.parseInt(value.substring(0,2)));
         space = space + 2;
       } for (int i = space; i < brob; space++) {
            try {valueList.add(Integer.parseInt(value.substring(i,i+1)));
          } catch (NumberFormatException e) {
            if (value.substring(i, i+1).equals("+") || value.substring(i, i+1).equals("-")){
              continue;
            } else{
              System.out.println(e.toString());
              System.exit(0);
            }
          }
        }
     }
   }

   public BrobInt compareTo( BrobInt value ) {
     if (this.toString().substring(0,1).equals("-") && !value.toString(0,1).equals("-") ) {
       return -1;
     } else if (this.toString().length() > value.toString().length() ) {
         if ( !this.toString().substring( 0 , 1 ).equals( "-" ) ) {
           return = 1;
         } return = -1;
             }
   }

   public BrobInt add(BrobInt value) {
     int stackedAdd =
     if (positiveNumber = true) {

     }
   }

   public BrobInt subtract( BrobInt value ) {

   }

   public BrobInt valueOf( BrobInt value) {

   }

   public BrobInt toString( BrobInt value ) {
     return brobValue;
   }
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      System.exit( 0 );
   }
}
