import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static configuration.Configuration.ENV;

public class TestBase {

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
        driver.close();
        driver.quit();
        System.out.println("Browser was closed and driver was killed");
    }

}