package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "Submit")
    private WebElement addToCartButton;

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened product page");
    }

    public TshirtsPage addProductToCart() {
        System.out.println("Adding product to the cart");
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
        return new TshirtsPage(driver);
    }

}
