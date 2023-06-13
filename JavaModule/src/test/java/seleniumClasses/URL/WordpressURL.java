package seleniumClasses.URL;

public class WordpressURL {
    public WordpressURL(){

    }
    static String urlMonCompte = "http://20.13.162.105:8000/mon-compte/";
    static String urlHome = "http://20.13.162.105:8000/";

    public static String getUrlMonCompte() {
        return urlMonCompte;
    }
    public static String getWebSiteURL(){
        return urlHome;
    }
}
