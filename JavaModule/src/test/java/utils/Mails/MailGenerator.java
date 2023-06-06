package utils.Mails;

import utils.Random.RandomWords;
public class MailGenerator {
    private static String RandomMail;
    public MailGenerator(){
        setRandomMail();
    }
    public static String getRandomMail() {
        return RandomMail;
    }
    public static void setRandomMail(){
        String Randomword = RandomWords.setRandomWord(8);
        RandomMail =  Randomword + "@gmail.com";
    }
}
