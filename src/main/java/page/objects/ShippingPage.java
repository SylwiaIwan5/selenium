package page.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

    @FindBy(className = "page-heading")
    private WebElement header;

    @FindBy(xpath = "//input[@id=\"cgv\"]")
    private WebElement termsCheckbox;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened shipping page");
    }

    public ShippingPage tickCheckbox(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", termsCheckbox);
        Actions actions = new Actions(driver);
        actions.moveToElement(termsCheckbox).click().perform();
        System.out.println("Tick checkbox");
        return new ShippingPage(driver);
    }

    public ChoosePaymentPage clickOnProceedToCheckoutButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, proceedToCheckoutButton);
        actions.moveToElement(proceedToCheckoutButton).click().perform();
        System.out.println("Clicked on proceed to checkout button");
        return new ChoosePaymentPage(driver);
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }


}
