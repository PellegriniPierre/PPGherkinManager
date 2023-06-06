package utils.Random;

import java.util.Random;

public class Randomisation {
    public static String RandomWords(){
        return generateRandomWord(5);
    }

    public static String generateRandomWord(int length) {
        Random random = new Random();
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(letters.length);
            char randomLetter = letters[randomIndex];
            sb.append(randomLetter);
        }
        return sb.toString();
    }

}
