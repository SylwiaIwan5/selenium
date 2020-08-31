import org.junit.Test;
import page.objects.HomePage;
import page.objects.LogInPage;
import page.objects.RegisterPage;

public class RegisterTest extends TestBase {

    public static final String REGISTER_EMAIL_IMPROPER = "email";

    public static final String REGISTER_HEADER = "CREATE AN ACCOUNT";
    public static final String PERSONAL_INFORMATION_HEADER = "YOUR PERSONAL INFORMATION";
    public static final String ADDRESS_REGISTER_HEADER = "YOUR ADDRESS";

    public static final String COMMUNICATION_INVALID_EMAIL = "Invalid email address.";
    public static final String COMMUNICATION_1_ERROR = "There is 1 error";
    public static final String COMMUNICATION_8_ERRORS = "There are 8 errors";

    public static final String FIRST_NAME = "Monika";
    public static final String IMPROPER_FIRST_NAME = "232323";
    public static final String LAST_NAME = "Hajduk";
    public static final String IMPROPER_LAST_NAME = "90674.;";
    public static final String PASSWORD = "free8952.";
    public static final String TOO_SHORT_PASSWORD = "K";
    public static final String DAY_IN_DATE_OF_BIRTH = "27  ";
    public static final String MONTH_IN_DATE_OF_BIRTH = "November ";
    public static final String YEAR_IN_DATE_OF_BIRTH = "2000  ";
    public static final String COMPANY = "Google";
    public static final String STREET = "Główna";
    public static final String APARTMENT = "8A/5";
    public static final String CITY = "Wrocław";
    public static final String STATE = "Alaska";
    public static final String POSTCODE = "87093";
    public static final String IMPROPER_POSTCODE = "090";
    public static final String ADDITIONAL_INFORMATION = "Second floor";
    public static final String HOME_PHONE = "76 897 72 22";
    public static final String MOBILE_PHONE = "609878282";
    public static final String ADDRESS_ALIAS = "Correspondence address";

    public static final String ACCOUNT_WEBSITE_ADDRESS = "http://automationpractice.com/index.php?controller=my-account";
    public static final String ACCOUNT_HEADER = "MY ACCOUNT";

    @Test
    public void startRegisterSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LogInPage loginPage = homePage.clickOnSignInIcon();
        String email = loginPage.randomEmail();
        loginPage.startRegister(driver, email);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage
                .assertRegisterPageIsOpen(driver, REGISTER_HEADER, PERSONAL_INFORMATION_HEADER, ADDRESS_REGISTER_HEADER)
                .assertRegisterEmailIsComplete(driver, email);
    }

    @Test
    public void startRegisterUnsuccessfullyBecauseOfEmptyEmail() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .clickOnCreateAccountButton(driver);
        LogInPage loginPage = new LogInPage(driver);
        loginPage
                .assertStartRegisterErrorCommunication(driver, COMMUNICATION_INVALID_EMAIL);
    }

    @Test
    public void startRegisterUnsuccessfullyBecauseOfImproperEmail() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterWithErrors(driver, REGISTER_EMAIL_IMPROPER)
                .assertStartRegisterErrorCommunication(driver, COMMUNICATION_INVALID_EMAIL);
    }

    @Test
    public void registerUnsuccessfullyBecauseOfNotCompleteRequiredData() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .clickOnRegisterButton(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage
                .assertRegisterErrorCommunication(COMMUNICATION_8_ERRORS);
    }

    @Test
    public void registerSuccessfullyWithCompleteRequiredData() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .fillInFirstName(driver, FIRST_NAME)
                .fillInLastName(driver, LAST_NAME)
                .fillInPassword(driver, PASSWORD)
                .fillInStreet(driver, STREET)
                .fillInCity(driver, CITY)
                .selectState(STATE)
                .fillInPostalCode(driver, POSTCODE)
                .fillInMobilePhoneNumber(driver, MOBILE_PHONE)
                .registerSuccess(driver)
                .assertAccountPageIsOpen(ACCOUNT_WEBSITE_ADDRESS, ACCOUNT_HEADER);
    }

    @Test
    public void registerUnsuccessfullyBecauseOfImproperFirstName() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .fillInFirstName(driver, IMPROPER_FIRST_NAME)
                .fillInLastName(driver, LAST_NAME)
                .fillInPassword(driver, PASSWORD)
                .fillInStreet(driver, STREET)
                .fillInCity(driver, CITY)
                .selectState(STATE)
                .fillInPostalCode(driver, POSTCODE)
                .fillInMobilePhoneNumber(driver, MOBILE_PHONE)
                .registerWithErrors(driver)
                .assertRegisterErrorCommunication(COMMUNICATION_1_ERROR);
    }

    @Test
    public void registerUnsuccessfullyBecauseOfImproperLastName() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .fillInFirstName(driver, FIRST_NAME)
                .fillInLastName(driver, IMPROPER_LAST_NAME)
                .fillInPassword(driver, PASSWORD)
                .fillInStreet(driver, STREET)
                .fillInCity(driver, CITY)
                .selectState(STATE)
                .fillInPostalCode(driver, POSTCODE)
                .fillInMobilePhoneNumber(driver, MOBILE_PHONE)
                .registerWithErrors(driver)
                .assertRegisterErrorCommunication(COMMUNICATION_1_ERROR);
    }

    @Test
    public void registerUnsuccessfullyBecauseOfTooShortPassword() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .fillInFirstName(driver, FIRST_NAME)
                .fillInLastName(driver, LAST_NAME)
                .fillInPassword(driver, TOO_SHORT_PASSWORD)
                .fillInStreet(driver, STREET)
                .fillInCity(driver, CITY)
                .selectState(STATE)
                .fillInPostalCode(driver, POSTCODE)
                .fillInMobilePhoneNumber(driver, MOBILE_PHONE)
                .registerWithErrors(driver)
                .assertRegisterErrorCommunication(COMMUNICATION_1_ERROR);
    }

    @Test
    public void registerUnsuccessfullyBecauseOfImproperPostcode() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .fillInFirstName(driver, FIRST_NAME)
                .fillInLastName(driver, LAST_NAME)
                .fillInPassword(driver, PASSWORD)
                .fillInStreet(driver, STREET)
                .fillInCity(driver, CITY)
                .selectState(STATE)
                .fillInPostalCode(driver, IMPROPER_POSTCODE)
                .fillInMobilePhoneNumber(driver, MOBILE_PHONE)
                .registerWithErrors(driver)
                .assertRegisterErrorCommunication(COMMUNICATION_1_ERROR);
    }

    @Test
    public void registerSuccessfullyWithCompleteData() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .startRegisterSuccess(driver)
                .chooseMrTitle(driver)
                .chooseMrsTitle(driver)
                .fillInFirstName(driver, FIRST_NAME)
                .fillInLastName(driver, LAST_NAME)
                .fillInPassword(driver, PASSWORD)
                .selectDayInDateOfBirth(driver, DAY_IN_DATE_OF_BIRTH)
                .selectMonthInDateOfBirth(MONTH_IN_DATE_OF_BIRTH)
                .selectYearInDateOfBirth(YEAR_IN_DATE_OF_BIRTH)
                .tickNewsletterCheckbox(driver)
                .tickSpecialOffersCheckbox(driver)
                .fillInCompany(driver, COMPANY)
                .fillInStreet(driver, STREET)
                .fillInApartment(driver, APARTMENT)
                .fillInCity(driver, CITY)
                .selectState(STATE)
                .fillInPostalCode(driver, POSTCODE)
                .fillInAdditionalInformation(driver, ADDITIONAL_INFORMATION)
                .fillInHomePhoneNumber(driver, HOME_PHONE)
                .fillInMobilePhoneNumber(driver, MOBILE_PHONE)
                .fillInAddressAlias(driver, ADDRESS_ALIAS)
                .registerSuccess(driver)
                .assertAccountPageIsOpen(ACCOUNT_WEBSITE_ADDRESS, ACCOUNT_HEADER);
    }

}