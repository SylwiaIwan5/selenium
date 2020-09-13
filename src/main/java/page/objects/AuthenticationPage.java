package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
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
        log.info("Opened authentication page");
    }

    public OrderAddressesPage signInSuccess(WebDriver driver, String loginEmail, String password) {
        signIn(driver, loginEmail, password);
        return new OrderAddressesPage(driver);
    }

    public void signIn(WebDriver driver, String loginEmail, String password) {
        log.info("Start logging...");
        waitUntilElementIsVisible(driver, inputEmail);
        log.info("Typing in email...");
        inputEmail.sendKeys(loginEmail);
        log.info("Typing in password...");
        inputPassword.sendKeys(password);
        log.info("Credentials was typed");
        signInButton.click();
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
