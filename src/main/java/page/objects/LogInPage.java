package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogInPage {

    @FindBy(xpath = "//div[@id=\"create_account_error\"]/ol[1]/li[1]")
    private WebElement registerAlert;

    @FindBy(css = "input[id='email_create']")
    private WebElement inputRegisterEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "div[class = 'alert alert-danger']")
    private WebElement loginAlert;

    @FindBy(css = "input[id='email']")
    private WebElement inputEmail;

    @FindBy(css = "input[id='passwd']")
    private WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        System.out.println("Opened log in page");
    }

    public LogInPage startRegisterWithErrors(WebDriver driver, String email) {
        startRegister(driver, email);
        return this;
    }

    public RegisterPage startRegisterSuccess(WebDriver driver) {
        String email = randomEmail();
        startRegister(driver, email);
        return new RegisterPage(driver);
    }

    public String randomEmail() {
        String email = randomString() + "@email.com";
        return email;
    }

    public String randomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        byte length = 15;
        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public void startRegister(WebDriver driver, String email) {
        System.out.println("Start register...");
        waitUntilElementIsVisible(driver, inputRegisterEmail);
        inputRegisterEmail.sendKeys(email);
        clickOnCreateAccountButton(driver);
    }

    public void clickOnCreateAccountButton(WebDriver driver) {
        waitUntilElementIsVisible(driver, createAccountButton);
        createAccountButton.click();
    }

    public LogInPage signInWithErrors(WebDriver driver, String loginEmail, String password) {
        signIn(driver, loginEmail, password);
        return this;
    }

    public AccountPage signInSuccess(WebDriver driver, String loginEmail, String password) {
        signIn(driver, loginEmail, password);
        return new AccountPage(driver);
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

    public LogInPage assertLoginErrorCommunication(String expectedCommunication) {
        System.out.println("Checking if login alert is proper");
        String actualCommunication = loginAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        System.out.println("Login error communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    public LogInPage assertLogout() {
        System.out.println("Checking if sign in button is enabled");
        assertTrue(signInButton.isEnabled());
        return this;
    }

    public LogInPage assertStartRegisterErrorCommunication(WebDriver driver, String expectedCommunication) {
        waitUntilElementIsVisible(driver, registerAlert);
        System.out.println("Checking if register alert is proper");
        String actualCommunication = registerAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        System.out.println("Register error communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
