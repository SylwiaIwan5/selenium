package page.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPaymentPage {

    @FindBy(className = "navigation_page")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElement confirmOrderButton;

    private WebDriver driver;

    public CheckPaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened check payment page");
    }

    public CheckOrderConfirmationPage clickOnConfirmOrderButton(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", confirmOrderButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(confirmOrderButton).click().perform();
        System.out.println("Clicked on confirm order button");
        return new CheckOrderConfirmationPage(driver);
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
