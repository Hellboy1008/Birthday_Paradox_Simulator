
//龍ONE

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class BirthdayParadox {
    private static final int PEOPLE_MAX = 70;
    private static final int TRIALS = 10000;
    private static final double PERCENT_CONVERT = 100;

    public static void main(String[] args) {
        int success = 0;
        Random randomGenerator = new Random();
        ArrayList<Integer> birthdates = new ArrayList<Integer>();
        for (int counter = 0; counter < TRIALS; counter++) {
            for (int people = 0; people < PEOPLE_MAX; people++) {
                birthdates.add(randomGenerator.nextInt(365));
            }
            Set birthdate = new HashSet<>(birthdates);
            if (birthdate.size() < birthdates.size()) {
                success += 1;
            }
            birthdates.clear();
            birthdate.clear();
        }
        System.out.println((float) (success) / (float) (TRIALS) * PERCENT_CONVERT + "%");
    }
}