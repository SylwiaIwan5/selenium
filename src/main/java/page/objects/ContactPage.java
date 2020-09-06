package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ContactPage {

    @FindBy(id = "id_contact")
    private WebElement subjectSelect;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "id_order")
    private WebElement orderReferenceInput;

    @FindBy(id = "id_order")
    private WebElement fileUploadInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(css = "p[class = 'alert alert-success']")
    private WebElement successAlert;

    @FindBy(css = "div[class = 'alert alert-danger']")
    private WebElement errorAlert;

    private WebDriver driver;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        System.out.println("Opened contact page");
    }

    public ContactPage fillForm(WebDriver driver, String subjectSelectOption, String email, String orderReference, String message) {
        System.out.println("Start fill contact us form...");
        fillEmail(driver, email);
        System.out.println("Choose option from select...");
        Select subjectSelectOptions = new Select(subjectSelect);
        subjectSelectOptions.selectByVisibleText(subjectSelectOption);
        System.out.println("Typing in order reference...");
        orderReferenceInput.sendKeys(orderReference);
        fillMessage(message);
        System.out.println("Form is filled");
        return this;
    }

    public ContactPage fillEmail(WebDriver driver, String email) {
        waitUntilElementIsVisible(driver, emailInput);
        System.out.println("Typing in e-mail...");
        emailInput.sendKeys(email);
        return this;
    }

    public ContactPage fillMessage(String message) {
        System.out.println("Typing in message...");
        messageInput.sendKeys(message);
        return this;
    }

    public ContactPage clickOnSendIcon() {
        sendButton.click();
        System.out.println("Clicked on send button");
        return this;
    }

    public ContactPage assertContactSuccessCommunication(String expectedCommunication) {
        System.out.println("Checking if contact alert is proper");
        String actualCommunication = successAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        System.out.println("Contact success communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    public ContactPage assertContactErrorCommunication(String expectedCommunication) {
        System.out.println("Checking if contact alert is proper");
        String actualCommunication = errorAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        System.out.println("Contact error communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
