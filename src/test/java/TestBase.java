import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to(ENV);
        log.info("Navigating to page " + ENV);
    }

    @After
    public void afterTest() {
        driver.quit();
        log.info("Browser was closed and driver was killed");
    }

}