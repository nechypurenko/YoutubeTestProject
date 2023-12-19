package org.example.utils;

import java.util.Random;

public class Utils {
    public static String generateRandomNumber() {
        Random random = new Random();
        int minDigits = 2;
        int maxDigits = 4;
        return String.valueOf(generateRandomNumber(minDigits, maxDigits));
    }

    public static int generateRandomNumber(int minDigits, int maxDigits) {
        Random random = new Random();
        int multiplier = (int) Math.pow(10, random.nextInt(maxDigits - minDigits + 1) + minDigits - 1);
        return random.nextInt(9 * multiplier) + multiplier;
    }
}
