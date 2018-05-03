/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Program to return change in different currencies
 * @author    :  Gabriel Say
 * Date       :  2018-04-24
 * Description:  This program provides the class for coin changemaker, which is a
 *               "Dynamic Programming" algorithm.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2018-04-27  Gabe Say      Initial release;
 *  1.0.1  2018-05-02  Gabe Say      Added makeChangeWithDynamicProgramming
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public class DynamicChangeMaker{


     /**
     * Validate change arguments
     * @param numCoins                    int[] contains the user input for coin values
     * @param totalWanted                 int containg the user's input for wanted total
     * @throws IllegalArgumentException   for values less than 1 or duplicates
     */

     public static void validChange (int[] numCoins, int totalWanted){
       //make sure there are values which can be used to calculate the
       for (int coins : numCoins){
         if (coins < 1){
           throw new IllegalArgumentException("Need at least one coin value!");
         }
       }
       //check for duplicate
       for (int startingCoin = 0; startingCoin < numCoins.length; startingCoin++){
         for (int nextCoin = startingCoin + 1; nextCoin < numCoins.length; nextCoin++){
           if (numCoins[startingCoin] == numCoins[nextCoin]) {
             throw new IllegalArgumentException("Do not put duplicate coin values!");
           }
         }
       }
       //check for a "totalWanted" value which is the sum of the coins
       if (totalWanted < 1 ){
         throw new IllegalArgumentException("Need to input a positive total!");
       }
     }

     /**
     * class to make the change itself
     * @param numCoins      similar to validate, it adds the values of the coins we will be using
     * @param totalWanted   user inputs the total we want to calculate using the coin values given
     * Exception ie         checks to validate the tuples passed through
     * @return              the best way to find the total wanted by the user, using the coins given 
     */
     public static Tuple makeChangeWithDynamicProgramming(int[] numCoins, int totalWanted){

       //validate arguments
       try{validChange(numCoins, totalWanted);}
       catch (Exception ie) {return(Tuple.IMPOSSIBLE);}

       //creates a grid for the change to be collected
 		   Tuple[][] gridChange = new Tuple[numCoins.length][totalWanted + 1];

       //adds int for the data to be put into the Tuple
          for (int horz = 0; horz < numCoins.length; horz++) {
             for (int vert = 0; vert < totalWanted + 1; vert++) {
                 if (vert == 0) {
                     gridChange[horz][vert] =  new Tuple(numCoins.length);
                 } else {
                   //sets value as 1
                     if (vert >= numCoins[horz]){
                         gridChange[horz][vert] = new Tuple(numCoins.length);
                         gridChange[horz][vert].setElement(horz, 1);
                         if (gridChange[horz][vert - numCoins[horz]].equals(Tuple.IMPOSSIBLE)) {
                             gridChange[horz][vert] = Tuple.IMPOSSIBLE;
                         } else if (!gridChange[horz][vert - numCoins[horz]].equals(Tuple.IMPOSSIBLE)) {
                             gridChange[horz][vert] = gridChange[horz][vert].add(gridChange[horz][vert-numCoins[horz]]);
                         }
                     } else {
                         gridChange[horz][vert] = Tuple.IMPOSSIBLE;
                     }
                 }

                 if (horz != 0) {
                     if (!gridChange[horz][vert].equals(Tuple.IMPOSSIBLE)) {
                         if (gridChange[horz - 1][vert].equals(Tuple.IMPOSSIBLE)) {
                         } else if (!gridChange[horz - 1][vert].equals(Tuple.IMPOSSIBLE)) {
                             if (gridChange[horz - 1][vert].total() < gridChange[horz][vert].total()) {
                                  gridChange[horz][vert] = gridChange[horz - 1][vert];
                             } else {
                             }
                         }
                     } else {
                         if (!(gridChange[horz - 1][vert].equals(Tuple.IMPOSSIBLE))) {
                             gridChange[horz][vert] = gridChange[horz - 1][vert];
                         }
                     }
                 }
             }
         }
         return gridChange[numCoins.length - 1][totalWanted];
     }

 }
