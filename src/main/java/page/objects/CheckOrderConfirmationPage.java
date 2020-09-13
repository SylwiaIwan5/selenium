package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@Slf4j
public class CheckOrderConfirmationPage {

    @FindBy(className = "navigation_page")
    private WebElement header;

    @FindBy(css = "p[class = 'alert alert-success']")
    private WebElement completeOrderCommunication;

    @FindBy(className = "button-exclusive btn btn-default")
    private WebElement backToOrdersButton;

    private WebDriver driver;

    public CheckOrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        log.info("Opened check order confirmation page");
    }

    public CheckOrderConfirmationPage assertCommunication(WebDriver driver, String expectedCommunication) {
        log.info("Checking if communication is proper");
        waitUntilElementIsVisible(driver, completeOrderCommunication);
        String actualCommunication = completeOrderCommunication.getText();
        assertEquals(expectedCommunication, actualCommunication);
        log.info("Communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
