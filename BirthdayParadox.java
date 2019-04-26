
/**
 * Created by: 龍ONE
 * Date Created:
 * Date Edited: April 25, 2019
 * Purpose: To test the birthday paradox, a probability theory which concerns
 *          the probability that, in a set of n randomly chosen people, some
 *          pair of them will have the same birthday.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * The class tests the birthday paradox using the tester method and calling it
 * from the main method.
 */
public class BirthdayParadox {
    // the minumum number of people needed to reach 99.9%
    private static final int MIN_PEOPLE = 70;
    // the number of trials for the tester
    private static final int TRIALS = 10000;
    // number of days in a year
    private static final int DAYS_IN_YEAR = 365;
    // multiplier for converting decimal number to percentage
    private static final double PERCENT_CONVERT = 100;
    // output for the main method
    private static final String OUTPUT = "The percentage of successful trials is : %.2f%%";

    /**
     * This method runs the trials and returns the percentage of successful trials
     * 
     * @param trials The total number of trials
     * @return The percentage of successful trials
     */
    private static double paradoxTester(int trials) {
        // number of successful tries out of the trials
        double successfulTries = 0;
        // random object for creating random integers
        Random randomGenerator = new Random();
        // arraylist containing the values of all the birthdays
        ArrayList<Integer> birthdates = new ArrayList<Integer>();

        // run trials
        for (int counter = 0; counter < trials; counter++) {
            for (int personNum = 0; personNum < MIN_PEOPLE; personNum++) {
                birthdates.add(randomGenerator.nextInt(DAYS_IN_YEAR));
            }
            // check for duplicates
            for (int indexOne = 0; indexOne < birthdates.size() - 1; indexOne++) {
                for (int indexTwo = indexOne + 1; indexTwo < birthdates.size(); indexTwo++) {
                    if (birthdates.get(indexOne).equals(birthdates.get(indexTwo))) {
                        successfulTries++;
                        birthdates.clear();
                    }
                }
            }
            // reset birthdates arraylist
            birthdates.clear();
        }

        return (successfulTries / trials) * PERCENT_CONVERT;
    }

    /**
     * Main method that calls the tester method and prints the result to the console
     * 
     * @param args The arguments given to the main method
     * @return None
     */
    public static void main(String[] args) {
        System.out.printf(OUTPUT, paradoxTester(TRIALS));
    }
}