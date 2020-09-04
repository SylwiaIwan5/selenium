import org.junit.Test;
import page.objects.HomePage;

public class LogInTest extends TestBase {

    public static final String LOGIN_IMPROPER = "email";
    public static final String PASSWORD_IMPROPER = "ASDFHJK^*((2232DDSSD";
    public static final String COMMUNICATION_LOGIN_REQUIRED = "There is 1 error\n" + "An email address required.";
    public static final String COMMUNICATION_PASSWORD_REQUIRED = "There is 1 error\n" + "Password is required.";
    public static final String COMMUNICATION_IMPROPER_LOGIN = "There is 1 error\n" + "Invalid email address.";
    public static final String COMMUNICATION_IMPROPER_PASSWORD = "There is 1 error\n" + "Authentication failed.";
    public static final String ACCOUNT_WEBSITE_ADDRESS = "http://automationpractice.com/index.php?controller=my-account";
    public static final String ACCOUNT_HEADER = "MY ACCOUNT";

    @Test
    public void logInSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInSuccess(driver, LOGIN, PASSWORD)
                .assertAccountPageIsOpen(ACCOUNT_WEBSITE_ADDRESS, ACCOUNT_HEADER);
    }

    @Test
    public void logInUnsuccessfullyBecauseOfEmptyLoginAndPassword() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInWithErrors(driver, "", "")
                .assertLoginErrorCommunication(COMMUNICATION_LOGIN_REQUIRED);
    }

    @Test
    public void logInUnsuccessfullyBecauseOfEmptyLogin() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInWithErrors(driver, "", PASSWORD)
                .assertLoginErrorCommunication(COMMUNICATION_LOGIN_REQUIRED);
    }

    @Test
    public void logInUnsuccessfullyBecauseOfEmptyPassword() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInWithErrors(driver, LOGIN, "")
                .assertLoginErrorCommunication(COMMUNICATION_PASSWORD_REQUIRED);
    }

    @Test
    public void logInUnsuccessfullyBecauseOfImproperLogin() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInWithErrors(driver, LOGIN_IMPROPER, PASSWORD)
                .assertLoginErrorCommunication(COMMUNICATION_IMPROPER_LOGIN);
    }

    @Test
    public void logInUnsuccessfullyBecauseOfImproperPassword() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInWithErrors(driver, LOGIN, PASSWORD_IMPROPER)
                .assertLoginErrorCommunication(COMMUNICATION_IMPROPER_PASSWORD);
    }

}