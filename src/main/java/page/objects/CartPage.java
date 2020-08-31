package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        System.out.println("Opened cart page");
    }

    public CartPage clickOnDeleteIcon(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, deleteIcon);
        actions.moveToElement(deleteIcon).click().perform();
        System.out.println("Clicked on delete icon");
        return new CartPage(driver);
    }

    public AuthenticationPage clickOnProceedToCheckoutButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, proceedToCheckoutButton);
        actions.moveToElement(proceedToCheckoutButton).click().perform();
        System.out.println("Clicked on proceed to checkout button");
        return new AuthenticationPage(driver);
    }

    public CartPage assertCartIsOpen(WebDriver driver, String websiteAddress, String expectedCartHeaderText, String expectedProductNameInCart) {
        System.out.println("Checking if website address is proper");
        assertEquals(websiteAddress, driver.getCurrentUrl());
        System.out.println("Website address: '" + driver.getCurrentUrl() + " is proper");
        waitUntilElementIsVisible(driver, shoppingCartHeader);
        System.out.println("Checking if Cart header is visible");
        assertTrue(shoppingCartHeader.isDisplayed());
        System.out.println("Cart header is visible");
        System.out.println("Checking if Cart header text is correct");
        String cartHeaderText = shoppingCartHeader.getText();
        assertEquals(expectedCartHeaderText, cartHeaderText);
        System.out.println("Women page header text is correct " + expectedCartHeaderText);
        System.out.println("Checking if product name in cart is correct");
        String popupProductName = addedToCartProductName.getText();
        assertEquals(expectedProductNameInCart, popupProductName);
        System.out.println("Product name in cart is correct " + expectedProductNameInCart);
        return this;
    }

    public CartPage assertCartIsEmpty(WebDriver driver, String communication) {
        System.out.println("Checking if communication is proper");
        waitUntilElementIsVisible(driver, communicationAlert);
        String paragraphAlertText = communicationAlert.getText();
        assertEquals(paragraphAlertText, communication);
        System.out.println("Communication is correct and sounds: '" + communication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}