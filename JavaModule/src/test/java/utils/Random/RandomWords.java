package utils.Random;

import java.util.Random;

public class RandomWords {
    public RandomWords(){
        getRandomString(6);
    }
    private String RandomString;

    public String getRandomString(int lenght){
        return RandomString;
    }

    public static String setRandomWord(int length) {
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
