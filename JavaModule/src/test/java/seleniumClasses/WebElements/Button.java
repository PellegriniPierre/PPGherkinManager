package seleniumClasses.WebElements;

public class Button {
    public Button(){

    }
    private static final String detailAccount = "Détails du compte";
    private static final String loginButton = "login";
    private static final String registerButton = "/html/body/div/div[2]/div/div/div[2]/main/article/div/div/div[2]/div[2]/form/p[3]/button";
    private static final String loginButton2 = "reg_email";
    public static String getDetailAccount(){return detailAccount;}
    public static String getLoginButton(){return loginButton;}
    public static String getLoginButton2(){return loginButton2;}
    public static String getRegisterButton(){
        System.out.println("On passe dans getRegisterButton");
        return registerButton;
    }
}
