package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
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
public class DressesPage {

    @FindBy(xpath = "//a[@title = \"View my shopping cart\"]")
    private WebElement cart;

    @FindBy(className = "title_block")
    private WebElement dressesPageHeader;

    @FindBy(className = "product-container")
    private WebElement product;

    @FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    private WebElement productName;

    @FindBy(css = "div[class = 'button-container'] a[class ='button ajax_add_to_cart_button btn btn-default']")
    private WebElement addToCartButton;

    @FindBy(className = "clearfix")
    private WebElement addedToCartPopup;

    @FindBy(id = "layer_cart_product_title")
    private WebElement addedToCartPopupProductName;

    @FindBy(xpath = "//span[@title=\"Continue shopping\"]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;

    public DressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        log.info("Opened Dresses page");
    }

    public DressesPage chooseProduct() {
        waitUntilElementIsVisible(driver, product);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", product);
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        return this;
    }

    public String getProductName() {
        Actions actions = new Actions(driver);
        actions.moveToElement(productName).perform();
        String productNameText = productName.getText();
        return productNameText;
    }

    public DressesPage addProductToCart(WebDriver driver) {
        log.info("Adding product to the cart");
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
        return this;
    }

    public DressesPage switchToPopup() {
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        log.info("Switch to popup");
        return this;
    }

    public DressesPage clickOnContinueShoppingButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, continueShoppingButton);
        actions.moveToElement(continueShoppingButton).click().perform();
        log.info("Clicked on continue shopping button");
        return this;
    }

    public CartPage clickOnProceedToCheckoutButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, proceedToCheckoutButton);
        actions.moveToElement(proceedToCheckoutButton).click().perform();
        log.info("Clicked on proceed to checkout button");
        return new CartPage(driver);
    }

    public CartPage goToCart() {
        cart.click();
        log.info("Clicked on Cart");
        return new CartPage(driver);
    }

    public DressesPage assertPopupIsDisplayed(WebDriver driver, String expectedPopupProductName) {
        log.info("Checking if added to cart popup is displayed");
        assertTrue(addedToCartPopup.isDisplayed());
        log.info("Product was added to the cart");
        waitUntilElementIsVisible(driver, addedToCartPopupProductName);
        log.info("Checking if product name on popup is correct");
        String actualPopupProductName = addedToCartPopupProductName.getText();
        assertEquals(expectedPopupProductName, actualPopupProductName);
        log.info("Product name on popup is correct " + expectedPopupProductName);
        return this;
    }

    public DressesPage assertDressesPageIsOpen(WebDriver driver, String expectedWebsiteAddress, String expectedDressesPageHeaderText) {
        log.info("Checking if website address is proper");
        String actualWebsiteAddress = driver.getCurrentUrl();
        assertEquals(expectedWebsiteAddress, actualWebsiteAddress);
        log.info("Website address: '" + actualWebsiteAddress + " is proper");
        waitUntilElementIsVisible(driver, dressesPageHeader);
        log.info("Checking if Dresses page header is visible");
        assertTrue(dressesPageHeader.isDisplayed());
        log.info("Dresses page header is visible");
        log.info("Checking if Dresses page header text is correct");
        String actualDressesPageHeaderText = dressesPageHeader.getText();
        assertEquals(expectedDressesPageHeaderText, actualDressesPageHeaderText);
        log.info("Dresses page header text is correct " + expectedDressesPageHeaderText);
        return this;
    }

    public DressesPage assertCartIsVisible(String expectedCartText) {
        log.info("Checking if cart is enabled");
        assertTrue(cart.isEnabled());
        log.info("Cart is enabled");
        log.info("Checking if cart text is correct");
        String actualCartText = cart.getText();
        assertEquals(expectedCartText, actualCartText);
        log.info("Cart text is correct " + expectedCartText);
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
