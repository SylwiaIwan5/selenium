package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@Slf4j
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
        log.info("Opened contact page");
    }

    public ContactPage fillForm(WebDriver driver, String subjectSelectOption, String email, String orderReference, String message) {
        log.info("Start fill contact us form...");
        fillEmail(driver, email);
        log.info("Choose option from select...");
        Select subjectSelectOptions = new Select(subjectSelect);
        subjectSelectOptions.selectByVisibleText(subjectSelectOption);
        log.info("Typing in order reference...");
        orderReferenceInput.sendKeys(orderReference);
        fillMessage(message);
        log.info("Form is filled");
        return this;
    }

    public ContactPage fillEmail(WebDriver driver, String email) {
        waitUntilElementIsVisible(driver, emailInput);
        log.info("Typing in e-mail...");
        emailInput.sendKeys(email);
        return this;
    }

    public ContactPage fillMessage(String message) {
        log.info("Typing in message...");
        messageInput.sendKeys(message);
        return this;
    }

    public ContactPage clickOnSendIcon() {
        sendButton.click();
        log.info("Clicked on send button");
        return this;
    }

    public ContactPage assertContactSuccessCommunication(String expectedCommunication) {
        log.info("Checking if contact alert is proper");
        String actualCommunication = successAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        log.info("Contact success communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    public ContactPage assertContactErrorCommunication(String expectedCommunication) {
        log.info("Checking if contact alert is proper");
        String actualCommunication = errorAlert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        log.info("Contact error communication is correct and sounds: '" + expectedCommunication + "'");
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
