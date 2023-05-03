package cucumberSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class CucumberHooks {
    public static WebDriver driver;

    @Before
    public void SetUp() {
        String browser = System.getProperty("browser");
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        //String ListeVersions = WebDriverManager.chromedriver().getDriverVersions().toString();
        //System.out.println("ListeVersions = " + ListeVersions);
        //System.out.println("Browser set to " + browser + " so we are on local mode\n" + "Set Headless(false) within CucumberHooks class to visualise ChromeDriver actions");
        options.addArguments("--headless=new"); /* Headless permet de ne pas chargé la partie graphique du Webdriver if true si on fait un Maven clean test sur un Jenkins (intégration continue) il faudra mettre true */
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @After
    public void AfterLaunch(Scenario scenario) {
        if (scenario.isFailed()) {
            driver.quit();
        }
        else {
            driver.quit();
        }
    }

}
