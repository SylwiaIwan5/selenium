package page.objects;

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

public class WomenPage {

    @FindBy(xpath = "//a[@title = \"View my shopping cart\"]")
    private WebElement cart;

    @FindBy(className = "navigation_page")
    private WebElement womenPageHeader;

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

    public WomenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened Women page");
    }

    public WomenPage chooseProduct() {
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

    public WomenPage addProductToCart() {
        System.out.println("Adding product to the cart");
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
        return this;
    }

    public WomenPage switchToPopup() {
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        System.out.println("Switch to popup");
        return this;
    }

    public WomenPage clickOnContinueShoppingButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, continueShoppingButton);
        actions.moveToElement(continueShoppingButton).click().perform();
        System.out.println("Clicked on continue shopping button");
        return this;
    }

    public CartPage clickOnProceedToCheckoutButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(driver, proceedToCheckoutButton);
        actions.moveToElement(proceedToCheckoutButton).click().perform();
        System.out.println("Clicked on proceed to checkout button");
        return new CartPage(driver);
    }

    public CartPage goToCart() {
        cart.click();
        System.out.println("Clicked on Cart");
        return new CartPage(driver);
    }

    public WomenPage assertPopupIsDisplayed(WebDriver driver, String expectedPopupProductName) {
        System.out.println("Checking if added to cart popup is displayed");
        assertTrue(addedToCartPopup.isDisplayed());
        System.out.println("Product was added to the cart");
        waitUntilElementIsVisible(driver, addedToCartPopupProductName);
        System.out.println("Checking if product name on popup is correct");
        String popupProductName = addedToCartPopupProductName.getText();
        assertEquals(expectedPopupProductName, popupProductName);
        System.out.println("Product name on popup is correct " + expectedPopupProductName);
        return this;
    }

    public WomenPage assertWomenPageIsOpen(WebDriver driver, String websiteAddress, String expectedWomenPageHeaderText) {
        System.out.println("Checking if website address is proper");
        assertEquals(websiteAddress, driver.getCurrentUrl());
        System.out.println("Website address: '" + driver.getCurrentUrl() + " is proper");
        waitUntilElementIsVisible(driver, womenPageHeader);
        System.out.println("Checking if Women page header is visible");
        assertTrue(womenPageHeader.isDisplayed());
        System.out.println("Women page header is visible");
        System.out.println("Checking if Women page header text is correct");
        String womenPageHeaderText = womenPageHeader.getText();
        assertEquals(expectedWomenPageHeaderText, womenPageHeaderText);
        System.out.println("Women page header text is correct " + expectedWomenPageHeaderText);
        return this;
    }

    public WomenPage assertCartIsVisible(String expectedCartText) {
        System.out.println("Checking if cart is enabled");
        assertTrue(cart.isEnabled());
        System.out.println("Cart is enabled");
        System.out.println("Checking if cart text is correct");
        String cartText = cart.getText();
        assertEquals(expectedCartText, cartText);
        System.out.println("Cart text is correct " + expectedCartText);
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}

