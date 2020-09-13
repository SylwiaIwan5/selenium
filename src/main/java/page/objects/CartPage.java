package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class CartPage {

    @FindBy(className = "navigation_page")
    private WebElement shoppingCartHeader;

    @FindBy(className = "cart_product first_item")
    private WebElement cartProductHeader;

    @FindBy(xpath = "//tr[contains(@id, 'product_')]/td[2]/p/a")
    private WebElement addedToCartProductName;

    @FindBy(className = "icon-trash")
    private WebElement deleteIcon;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "p[class = 'alert alert-warning']")
    private WebElement communicationAlert;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        log.info("Opened cart page");
    }

    public CartPage clickOnDeleteIcon(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, deleteIcon);
        actions.moveToElement(deleteIcon).click().perform();
        log.info("Clicked on delete icon");
        return new CartPage(driver);
    }

    public AuthenticationPage clickOnProceedToCheckoutButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, proceedToCheckoutButton);
        actions.moveToElement(proceedToCheckoutButton).click().perform();
        log.info("Clicked on proceed to checkout button");
        return new AuthenticationPage(driver);
    }

    public CartPage assertCartIsOpen(WebDriver driver, String expectedWebsiteAddress, String expectedCartHeaderText, String expectedProductNameInCart) {
        log.info("Checking if website address is proper");
        String actualWebsiteAddress = driver.getCurrentUrl();
        assertEquals(expectedWebsiteAddress, actualWebsiteAddress);
        log.info("Website address: '" + actualWebsiteAddress + " is proper");
        waitUntilElementIsVisible(driver, shoppingCartHeader);
        log.info("Checking if Cart header is visible");
        assertTrue(shoppingCartHeader.isDisplayed());
        log.info("Cart header is visible");
        log.info("Checking if Cart header text is correct");
        String actualCartHeaderText = shoppingCartHeader.getText();
        assertEquals(expectedCartHeaderText, actualCartHeaderText);
        log.info("Women page header text is correct " + expectedCartHeaderText);
        log.info("Checking if product name in cart is correct");
        String actualPopupProductName = addedToCartProductName.getText();
        assertEquals(expectedProductNameInCart, actualPopupProductName);
        log.info("Product name in cart is correct " + expectedProductNameInCart);
        return this;
    }

    public CartPage assertCartIsEmpty(WebDriver driver, String expectedCommunication) {
        log.info("Checking if communication is proper");
        waitUntilElementIsVisible(driver, communicationAlert);
        String actualCommunication = communicationAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        log.info("Communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}