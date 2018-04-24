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
/**
https://www.quora.com/How-can-we-add-two-large-numbers-without-using-any-integer-data-type-in-java
**/

public class BrobInt {

  public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
  public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
  public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
  public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
  public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
  public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
  public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
  public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
  public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
  public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
  public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   //private String internalValue = "";        // internal String representation of this BrobInt
   private byte   sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   //private byte[] brobArr   = null;      // byte array for storing the string values; uses the reversed string
   private boolean positiveNumber = true;
   private int[] brobArr = null;
   //private ArrayList<Integer> valueList = new ArrayList<>();
   public String arrayValue = null;
   private String IntBrob;
   public BrobInt absoluteValue;
   public boolean positiveSum;
   public boolean first;

   /**
    *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
    *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
    *   for later use
    *  @param  value  String value to make into a BrobInt
    */

    public BrobInt( String value ) throws IllegalArgumentException{
      super();
      arrayValue = value.trim();
      this.IntBrob = "0";
      //check for sign
      if (arrayValue.substring(0,1).equals ("-")) {
        sign = 1;
        positiveNumber = false;
      } else {
        sign = 0;
        positiveNumber = true;
      } this.IntBrob = arrayValue;
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to validate that all the characters in the value are valid decimal digits
    *  @return  boolean  true if all digits are good
    *  @throws  IllegalArgumentException if something is hinky
    *  note that there is no return false, because of throwing the exception
    *  note also that this must check for the '+' and '-' sign digits
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public boolean validateDigits(String value) throws UnsupportedOperationException{
      if (value.charAt(0) != '-' && value.charAt(0) != '0' && value.charAt(0) != '+' && value.charAt(0) != '-' && value.charAt(0) != '1' && value.charAt(0) != '2' && value.charAt(0) != '3' && value.charAt(0) != '3' && value.charAt(0) != '4' && value.charAt(0) != '5' && value.charAt(0) != '6' && value.charAt(0) != '7' && value.charAt(0) != '8' && value.charAt(0) != '9'){
        throw new UnsupportedOperationException (" \n Sorry, not a valid input");
      } for (int i = 0; i < value.length(); i++) {
        if (value.charAt(i) != '0' && value.charAt(i) != '1' && value.charAt(i) != '2' && value.charAt(i) != '3' && value.charAt(i) != '4' && value.charAt(i) != '5' && value.charAt(i) != '6' && value.charAt(i) != '7' && value.charAt(i) != '8' && value.charAt(i) != '9') {
       throw new UnsupportedOperationException( "\n         Sorry, not a valid input." );
      }
    } return true;
    }

    public String noSign (String k) {
      if (k.substring(0,1).equals("-") || k.substring(0,1).equals("-") ) {
        return k.substring(1);
      } return k;
     }

    public static String arrayString(int[] d) {
      String s = "";
      for (int i = 0; i < d.length; i++) {
          s = s + Integer.toString(d[i]);
      }
      return s;
    }

    public BrobInt absVal() {
    String absolute = this.toString();
    if (absolute.substring(0, 1).equals("+") || absolute.substring(0, 1).equals("-")) {
        absolute = absolute.substring(1);
      }
      return new BrobInt(absolute);
    }

    public boolean moreThan(BrobInt n) {
    if (this.positiveNumber && !n.positiveNumber) {
        return true;
    }
    if (!this.positiveNumber && n.positiveNumber) {
        return false;
    }

    boolean bothPositive = this.positiveNumber && n.positiveNumber;
    boolean larger = false;

    if (this.IntBrob.length() != n.IntBrob.length()) {
        larger = this.IntBrob.length() > n.IntBrob.length();
    } else {
        for (int i = 0; i < this.IntBrob.length(); i++) {
            if (Integer.parseInt(this.IntBrob.substring(i, i + 1)) > Integer.parseInt(n.IntBrob.substring(i, i + 1))) {
                larger = true;
                break;
            }
            if (Integer.parseInt(this.IntBrob.substring(i, i + 1)) < Integer.parseInt(n.IntBrob.substring(i, i + 1))) {
                larger = false;
                break;
            }
        }
    }
    return bothPositive == larger;
}

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array
    *  @param  gint         BrobInt to add to this
    *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt add( BrobInt gint ) {
      BrobInt inc;
      boolean largerInt = noSign(gint.IntBrob).length() > noSign(this.IntBrob).length();
      int longestInt = 0;
      int[] incArray;
      String incString = "";
      this.IntBrob = noSign(this.IntBrob);
      gint.IntBrob = noSign(gint.IntBrob);

      //check for larger int
      if (largerInt = true) {
        longestInt = noSign(gint.IntBrob).length();
      } else if (largerInt = false) {
        longestInt = noSign(this.IntBrob).length();
      }
          //checking for both positive
          if (this.positiveNumber == gint.positiveNumber) {
            //make both numbers equally as long in array
            for (int i = 1; i <= longestInt + 1; i++) {
              if (this.IntBrob.length() < longestInt + 1) {
              this.IntBrob = "0" + this.IntBrob;
            } if (gint.IntBrob.length() < longestInt + 1){
              gint.IntBrob = "0" + gint.IntBrob;
            }
          } //array for the sum
          incArray = new int[longestInt + 1];
          for (int i = 0; i < incArray.length ; i++) {
            incArray[i] = Integer.parseInt(this.IntBrob.substring(i, i + 1)) + Integer.parseInt(gint.IntBrob.substring(i, i + 1));
          }
            // carry numbers
            for (int i = incArray.length - 1; i >= 0; i--) {
                if (incArray[i] > 9) {
                    incArray[i] = incArray[i] - 10;
                    incArray[i - 1] = incArray[i - 1] + 1;
                }
            }
            incString = arrayString(incArray);
            if (!this.positiveNumber) {
              // if both numbers are negative
                incString = "-" + incString;
            }
            inc = new BrobInt(incString);
        } else { // if both have opposite signs
            incArray = new int[longestInt];
            if (!this.positiveNumber) { //if this is negative
                absoluteValue = this.absVal();
                if (absoluteValue.moreThan(gint)) {
                    positiveSum = false;
                    first = true;
                } else {
                    positiveSum = true;
                    first = false;
                }
                this.IntBrob = noSign(this.IntBrob);
            } else { // if gint is negative
                absoluteValue = gint.absVal();
                if (absoluteValue.moreThan(this)) {
                    positiveSum = false;
                    first = false;
                } else {
                    positiveSum = true;
                    first = true;
                }
                gint.IntBrob = noSign(gint.IntBrob);
            }// subtraction for incArray
            for (int i = 0; i < incArray.length; i++) {
                if (first) {
                    incArray[i] = Integer.parseInt(this.IntBrob.substring(i, i + 1)) - Integer.parseInt(gint.IntBrob.substring(i, i + 1));
                } else {
                    incArray[i] = Integer.parseInt(gint.IntBrob.substring(i, i + 1)) - Integer.parseInt(this.IntBrob.substring(i, i + 1));
                }
            }  // carry
            for (int i = incArray.length - 1; i >= 0; i--) {
                if (incArray[i] < 0) {
                    incArray[i] = incArray[i] + 10;
                    incArray[i - 1] = incArray[i - 1] - 1;
                }
            }  incString = arrayString(incArray);
            if (!positiveSum) {
                incString = "-" + incString;
            } for (int i = 0; i < incString.length(); i++) {
              if (incString.charAt(i) != '0') {
                incString = incString.substring(i);
                break;
              }
            }
            inc = new BrobInt(incString);
        }  return inc;
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using int array
    *  @param  gint         BrobInt to subtract from this
    *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt subtract( BrobInt gint ) {
      BrobInt inc;
      boolean largerInt = noSign(gint.IntBrob).length() > noSign(this.IntBrob).length();
      int longestInt = 0;
      int[] incArray;
      String incString = "";
      this.IntBrob = noSign(this.IntBrob);
      gint.IntBrob = noSign(gint.IntBrob);

      //check for larger int
      if (largerInt = true) {
        longestInt = noSign(gint.IntBrob).length();
      } else if (largerInt = false) {
        longestInt = noSign(this.IntBrob).length();
      }
          //checking for both positive
          if (this.positiveNumber == gint.positiveNumber) {
            //make both numbers equally as long in array
            for (int i = 1; i <= longestInt + 1; i++) {
              if (this.IntBrob.length() < longestInt + 1) {
              this.IntBrob = "0" + this.IntBrob;
            } if (gint.IntBrob.length() < longestInt + 1){
              gint.IntBrob = "0" + gint.IntBrob;
            }
          } //array for the sum
          incArray = new int[longestInt + 1];
          for (int i = 0; i < incArray.length ; i++) {
            incArray[i] = Integer.parseInt(this.IntBrob.substring(i, i + 1)) - Integer.parseInt(gint.IntBrob.substring(i, i + 1));
          }
            // carry numbers
            for (int i = incArray.length - 1; i >= 0; i--) {
                if (incArray[i] > 9) {
                    incArray[i] = incArray[i] - 10;
                    incArray[i - 1] = incArray[i - 1] + 1;
                }
            }
            incString = arrayString(incArray);
            if (!this.positiveNumber) {
              // if both numbers are negative
                incString = "-" + incString;
            }
            inc = new BrobInt(incString);
        } else { // if both have opposite signs
            incArray = new int[longestInt];
            if (!this.positiveNumber) { //if this is negative
                absoluteValue = this.absVal();
                if (absoluteValue.moreThan(gint)) {
                    positiveSum = false;
                    first = true;
                } else {
                    positiveSum = true;
                    first = false;
                }
                this.IntBrob = noSign(this.IntBrob);
            } else { // if gint is negative
                absoluteValue = gint.absVal();
                if (absoluteValue.moreThan(this)) {
                    positiveSum = false;
                    first = false;
                } else {
                    positiveSum = true;
                    first = true;
                }
                gint.IntBrob = noSign(gint.IntBrob);
            }// subtraction for incArray
            for (int i = 0; i < incArray.length; i++) {
                if (first) {
                    incArray[i] = Integer.parseInt(this.IntBrob.substring(i, i + 1)) - Integer.parseInt(gint.IntBrob.substring(i, i + 1));
                } else {
                    incArray[i] = Integer.parseInt(gint.IntBrob.substring(i, i + 1)) - Integer.parseInt(this.IntBrob.substring(i, i + 1));
                }
            }  // carry
            for (int i = incArray.length - 1; i >= 0; i--) {
                if (incArray[i] < 0) {
                    incArray[i] = incArray[i] + 10;
                    incArray[i - 1] = incArray[i - 1] - 1;
                }
            }  incString = arrayString(incArray);
            for (int i = 0; i < incString.length(); i++) {
              if (incString.charAt(i) != '0') {
                incString = incString.substring(i);
                break;
              }
            }
            inc = new BrobInt(incString);
        }  return inc;
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
    *  @param  gint         BrobInt to multiply this by
    *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt multiply( BrobInt gint ) {
       throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
    *  @param  gint         BrobInt to divide this by
    *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt divide( BrobInt gint ) {
       throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to get the remainder of division of this BrobInt by the one passed as argument
    *  @param  gint         BrobInt to divide this one by
    *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public BrobInt remainder( BrobInt gint ) {
       throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
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
        return 0;
      }
   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to check if a BrobInt passed as argument is equal to this BrobInt
    *  @param  gint     BrobInt to compare to this
    *  @return boolean  that is true if they are equal and false otherwise
    *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" using the
    *        java String "equals()" method -- THAT was easy..........
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public boolean equals( BrobInt gint ) {
       return (arrayValue.equals( gint.toString() ));
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to return a BrobInt given a long value passed as argument
    *  @param  value    long type number to make into a BrobInt
    *  @return BrobInt  which is the BrobInt representation of the long
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public static BrobInt valueOf( long value ) throws NumberFormatException {
       BrobInt gi = null;
       try {
          gi = new BrobInt( Long.valueOf( value ).toString() );
       }
       catch( NumberFormatException nfe ) {
          System.out.println( "\n  Sorry, the value must be numeric of type long." );
       }
       return gi;
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Method to return a String representation of this BrobInt
    *  @return String  which is the String representation of this BrobInt
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public String toString() {
       return arrayValue;
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  Helper method to display an Array representation of this BrobInt as its bytes
    *  @param  d  byte array to represent
    *  @see https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html
    *  NOTE: the java.utils.Arrays class contains a toString() method which is overridden to take quite a
    *        few different array data types as arguments.  To use this with your code, simply change the
    *        data type for the argument to match the data type of the array you want represented.  For
    *        example, change "byte[]" to "int[]" to make this method hand int arrays.
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    public void toArray( byte[] d ) {
       System.out.println( Arrays.toString( d ) );
    }

   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *  the main method redirects the user to the test class
    *  @param  args  String array which contains command line arguments
    *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
    *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
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
