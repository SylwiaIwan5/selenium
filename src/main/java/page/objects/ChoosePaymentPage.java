package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class ChoosePaymentPage {

    @FindBy(className = "page-heading")
    private WebElement header;

    @FindBy(className = "bankwire")
    private WebElement payByBankWireButton;

    @FindBy(className = "cheque")
    private WebElement payByCheckButton;

    private WebDriver driver;

    public ChoosePaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        log.info("Opened choose payment page");
    }

    public BankWirePaymentPage choosePaymentByBankWire(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, payByBankWireButton);
        actions.moveToElement(payByBankWireButton).click().perform();
        log.info("Clicked on pay by bank wire option");
        return new BankWirePaymentPage(driver);
    }

    public CheckPaymentPage choosePaymentByCheck(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, payByCheckButton);
        actions.moveToElement(payByCheckButton).click().perform();
        log.info("Clicked on pay by check option");
        return new CheckPaymentPage(driver);
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
