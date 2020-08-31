package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {

    @FindBy(className = "page-heading")
    private WebElement header;

    @FindBy(css = "input[id='email']")
    private WebElement inputEmail;

    @FindBy(css = "input[id='passwd']")
    private WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened authentication page");
    }

    public OrderAddressesPage signInSuccess(WebDriver driver, String loginEmail, String password) {
        signIn(driver, loginEmail, password);
        return new OrderAddressesPage(driver);
    }

    public void signIn(WebDriver driver, String loginEmail, String password) {
        System.out.println("Start logging...");
        waitUntilElementIsVisible(driver, inputEmail);
        System.out.println("Typing in email...");
        inputEmail.sendKeys(loginEmail);
        System.out.println("Typing in password...");
        inputPassword.sendKeys(password);
        System.out.println("Credentials was typed");
        signInButton.click();
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
