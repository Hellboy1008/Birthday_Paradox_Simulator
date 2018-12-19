
//龍ONE

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class BirthdayParadox {
    public static int peopleMax = 70;
    public static int trials = 10000;
    public static int success = 0;
    public static ArrayList<Integer> birthdates = new ArrayList<Integer>();

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        for (int counter = 0; counter < trials; counter++){
            for (int people = 0; people < peopleMax; people++){
                birthdates.add(randomGenerator.nextInt(365));
            }
            Set birthdate = new HashSet<>(birthdates);
            if (birthdate.size() < birthdates.size()){
                success += 1;
            }
            birthdates.clear();
            birthdate.clear();
        }
        System.out.println((float)(success) / (float)(trials) * 100 + "%");
    }
}