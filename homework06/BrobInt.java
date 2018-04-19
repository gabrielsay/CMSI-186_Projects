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
     String arrayValue = value;
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

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *  Method to compare a BrobInt passed as argument to this BrobInt
     *  @param  gint  BrobInt to add to this
     *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
     *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
     *        It takes into account the length of the two numbers, and if that isn't enough it does a
     *        character by character comparison to determine
     *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
     public int compareTo( BrobInt gint ) {
        if( arrayValue.length() > gint.arrayValue.length() ) {
           return 1;
        } else if( arrayValue.length() < gint.arrayValue.length() ) {
           return (-1);
        } else {
           for( int i = 0; i < arrayValue.length(); i++ ) {
              Character a = new Character( arrayValue.charAt(i) );
              Character b = new Character( gint.arrayValue.charAt(i) );
              if( new Character(a).compareTo( new Character(b) ) > 0 ) {
                 return 1;
              } else if( new Character(a).compareTo( new Character(b) ) < 0 ) {
                 return (-1);
              }
           }
        }
     }

     /**
     if (this.toString().substring(0,1).equals("-") && !value.toString(0,1).equals("-") ) {
       return -1;
     } else if (this.toString().length() > value.toString().length() ) {
         if ( !this.toString().substring( 0 , 1 ).equals( "-" ) ) {
           return = 1;
         } return = -1;
             }
   }**/

   public BrobInt add(BrobInt value) {
     int stackedAdd =
     if (positiveNumber = true) {

     }
   }

   public BrobInt subtract( BrobInt value ) {

   }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to return a BrobInt given a long value passed as argument
    *  @param  value         long type number to make into a BrobInt
    *  @return BrobInt  which is the BrobInt representation of the long
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public static BrobInt valueOf( long value ) throws NumberFormatException {
       BrobInt gi = null;
       try {
          gi = new BrobInt( String.valueOf( value ).toString() );
       }
       catch( NumberFormatException nfe ) {
          System.out.println( "\n  Sorry, the value must be numeric of type long." );
       }
       return gi;
    }
    /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *  Method to return the array representation of this BrobInt
     *  @return array  that holds integer array representation of this BrobInt
     *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public int[] getArrayRep() {
      return intArray;
    }

    /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *  Method to return BrobInt with absolute value of this BrobInt
     *  @return BrobInt  that is absolute value of this BrobInt
     *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt abs() {
        return ( this.toString().substring( 0 , 1).equals( "-" ) ) ? new BrobInt( this.toString().substring( 1 ) ) : this;
    }

    /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *  Method to check if a BrobInt passed as argument is equal to this BrobInt
     *  @param  value     BrobInt to compare to this
     *  @return boolean  that is true if they are equal and false otherwise
     *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public boolean equals( BrobInt value ) {
      return ( this.toString().equals( value.toString() ) ) ? true : false;
    }

    /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *  Method to return a String representation of this BrobInt
     *  @return String  which is the String representation of this BrobInt
     *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public String toString() {
      return arrayValue;
    }

   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      System.exit( 0 );
   }
}
/* BrobInt for abbreviation
* cant use java.math.BigInteger only for testing
* check java API for string comparison
* no recursive algorithm in fibonacci sequence
* can handle quicker if pairing them up when bits
* convert blocks of digits into int/long
* Add own test harness to repo
* Need to take into account for add on characters as well as negatives
* String Builder in api
* Arrays in API
* Divide c result by 10 if c result is greater than 9 and add that to carry
* If deprication error occurs, use (look up class integer) valueOf(int s)
* can use : depricated to make class file
* return new BrobInt(this.toString());
* Flag flag code conventions */
