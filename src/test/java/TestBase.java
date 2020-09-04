import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public static final String ENV = "http://automationpractice.com/index.php";
    public static final String LOGIN = "testemail@email.com";
    public static final String PASSWORD = "free8952.";

    public WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(ENV);
        System.out.println("Navigating to page " + ENV);
    }

    @After
    public void afterTest() {
        driver.quit();
        System.out.println("Browser was closed and driver was killed");
    }

}