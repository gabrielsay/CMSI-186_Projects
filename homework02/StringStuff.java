/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-19
 *  Student       :  Gabriel Say
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {
     for (int i = 0; i <= s.length(); i++) {
       if((s.charAt(i) == 'a' ) ||
          (s.charAt(i) == 'e' ) ||
          (s.charAt(i) == 'i' ) ||
          (s.charAt(i) == 'o' ) ||
          (s.charAt(i) == 'u' ) ||
          (s.charAt(i) == 'y' ) ||
          (s.charAt(i) == 'A' ) ||
          (s.charAt(i) == 'E' ) ||
          (s.charAt(i) == 'I' ) ||
          (s.charAt(i) == 'O' ) ||
          (s.charAt(i) == 'U' ) ||
          (s.charAt(i) == 'Y' ))
       return true;
     }
      return false;
   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
   for (int i = 0; i < s.length() - 1; i++) {
     if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
       return false;
     }
    }
    return true;
  }


/**
* Code that would maybe divide the int
* by 2 and then return it if it were even
**private static final int A = 1;
 private static final int B = A + 1;
 private static final int C = B + 1;
 private static final int D = C + 1;
 private static final int E = D + 1;
 private static final int F = E + 1;
 private static final int G = F + 1;
 private static final int H = G + 1;
 private static final int I = H + 1;
 private static final int J = I + 1;
 private static final int K = J + 1;
 private static final int L = K + 1;
 private static final int M = L + 1;
 private static final int N = M + 1;
 private static final int O = N + 1;
 private static final int P = O + 1;
 private static final int Q = P + 1;
 private static final int R = Q + 1;
 private static final int S = R + 1;
 private static final int T = S + 1;
 private static final int U = T + 1;
 private static final int V = U + 1;
 private static final int W = V + 1;
 private static final int X = W + 1;
 private static final int Y = X + 1;
 private static final int Z = Y + 1;
 s.charAt(i)% 2 == 0) {
 **/

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
     String a = "";
     for (int i = 0; i <= s.length()-1; i++) {
       if ((s.charAt(i) == 'B') ||
       (s.charAt(i) == 'D') ||
       (s.charAt(i) == 'F') ||
       (s.charAt(i) == 'H') ||
       (s.charAt(i) == 'J') ||
       (s.charAt(i) == 'L') ||
       (s.charAt(i) == 'N') ||
       (s.charAt(i) == 'P') ||
       (s.charAt(i) == 'R') ||
       (s.charAt(i) == 'T') ||
       (s.charAt(i) == 'V') ||
       (s.charAt(i) == 'X') ||
       (s.charAt(i) == 'Z') ||
       (s.charAt(i) == 'b') ||
       (s.charAt(i) == 'd') ||
       (s.charAt(i) == 'f') ||
       (s.charAt(i) == 'h') ||
       (s.charAt(i) == 'j') ||
       (s.charAt(i) == 'l') ||
       (s.charAt(i) == 'n') ||
       (s.charAt(i) == 'p') ||
       (s.charAt(i) == 'r') ||
       (s.charAt(i) == 't') ||
       (s.charAt(i) == 'v') ||
       (s.charAt(i) == 'x') ||
       (s.charAt(i) == 'z')) {
         a += s.charAt(i);
       }
     }
      return a;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {String a = "";
   for (int i = 0; i <= s.length()-1; i++) {
     if ((s.charAt(i) == 'A') ||
     (s.charAt(i) == 'C') ||
     (s.charAt(i) == 'E') ||
     (s.charAt(i) == 'G') ||
     (s.charAt(i) == 'I') ||
     (s.charAt(i) == 'K') ||
     (s.charAt(i) == 'M') ||
     (s.charAt(i) == 'O') ||
     (s.charAt(i) == 'Q') ||
     (s.charAt(i) == 'S') ||
     (s.charAt(i) == 'U') ||
     (s.charAt(i) == 'W') ||
     (s.charAt(i) == 'Y') ||
     (s.charAt(i) == 'a') ||
     (s.charAt(i) == 'c') ||
     (s.charAt(i) == 'e') ||
     (s.charAt(i) == 'g') ||
     (s.charAt(i) == 'i') ||
     (s.charAt(i) == 'k') ||
     (s.charAt(i) == 'm') ||
     (s.charAt(i) == 'o') ||
     (s.charAt(i) == 'q') ||
     (s.charAt(i) == 's') ||
     (s.charAt(i) == 'u') ||
     (s.charAt(i) == 'w') ||
     (s.charAt(i) == 'y')) {
       a += s.charAt(i);
     }
   }
    return a;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
   public static String evensOnlyNoDupes( String s ) {
     String a = evensOnly(s);
     String b = "";
     for(int i = 0; i < a.length(); i++) {
     if (!b.contains(String.valueOf(a.charAt(i)))){
       b += String.valueOf(a.charAt(i));
     }
    }
      return b;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {
     String a = oddsOnly(s);
   String b = "";
   for(int i = 0; i < a.length(); i++) {
   if (!b.contains(String.valueOf(a.charAt(i)))){
     b += String.valueOf(a.charAt(i));
     }
    }
    return b;
   }

  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {
      return new StringBuilder(s).reverse().toString();
   }
   /** StackOverflow user came in for the save!
   *https://stackoverflow.com/questions/7569335/reverse-a-string-in-java
   **/

  /**
   * Main method to test the methods in this class
   *
   * @param args String array containing command line parameters
   */
   public static void main( String args[] ) {
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      System.out.println( containsVowel( woof ) );
      System.out.println( isPalindrome( pal1 ) );
      System.out.println( isPalindrome( pal2 ) );
      System.out.println( isPalindrome( pal3 ) );
      System.out.println( isPalindrome( pal4 ) );
      System.out.println( isPalindrome( pal5 ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearSALsz" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYloPHonES" ) );
      System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
   }
}
