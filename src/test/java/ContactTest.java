import org.junit.Test;
import page.objects.HomePage;

import static configuration.Configuration.LOGIN;

public class ContactTest extends TestBase {

    public static final String SUBJECT_SELECT_OPTION = "Webmaster";
    public static final String IMPROPER_EMAIL = "test";
    public static final String ORDER_REFERENCE = "489437";
    public static final String MESSAGE = "Please check my order status.";
    public static final String SUCCESS_ALERT = "Your message has been successfully sent to our team.";
    public static final String ERROR_EMAIL_ALERT = "There is 1 error\n" + "Invalid email address.";
    public static final String ERROR_SUBJECT_ALERT = "There is 1 error\n" + "Please select a subject from the list provided.";
    public static final String ERROR_MESSAGE_ALERT = "There is 1 error\n" + "The message cannot be blank.";

    @Test
    public void fillContactFormSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnContactIcon()
                .fillForm(driver, SUBJECT_SELECT_OPTION, LOGIN, ORDER_REFERENCE, MESSAGE)
                .clickOnSendIcon()
                .assertContactSuccessCommunication(SUCCESS_ALERT);
    }

    @Test
    public void fillContactFormUnsuccessfullyBecauseOfImproperEmail() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnContactIcon()
                .fillEmail(driver, IMPROPER_EMAIL)
                .clickOnSendIcon()
                .assertContactErrorCommunication(ERROR_EMAIL_ALERT);
    }

    @Test
    public void fillContactFormUnsuccessfullyBecauseOfEmptyMessage() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnContactIcon()
                .fillEmail(driver, LOGIN)
                .clickOnSendIcon()
                .assertContactErrorCommunication(ERROR_MESSAGE_ALERT);
    }

    @Test
    public void fillContactFormUnsuccessfullyBecauseOfNotChooseSubject() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnContactIcon()
                .fillEmail(driver, LOGIN)
                .fillMessage(MESSAGE)
                .clickOnSendIcon()
                .assertContactErrorCommunication(ERROR_SUBJECT_ALERT);
    }

}