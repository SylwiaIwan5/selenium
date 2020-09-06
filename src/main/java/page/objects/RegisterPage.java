package page.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p")
    private WebElement alert;

    @FindBy(className = "page-heading")
    private WebElement registerHeader;

    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3")
    private WebElement personalInformationHeader;

    @FindBy(id = "id_gender1")
    private WebElement mrTitleRadio;

    @FindBy(id = "id_gender2")
    private WebElement mrsTitleRadio;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dateOfBirthDaysSelect;

    @FindBy(id = "months")
    private WebElement dateOfBirthMonthsSelect;

    @FindBy(id = "years")
    private WebElement dateOfBirthYearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(xpath = " //*[@id=\"account-creation_form\"]/div[2]/h3")
    private WebElement addressHeader;

    @FindBy(id = "firstname")
    private WebElement firstNameAddressInput;

    @FindBy(id = "lastname")
    private WebElement lastNameAddressInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement streetAddressInput;

    @FindBy(id = "address2")
    private WebElement apartmentAddressInput;

    @FindBy(id = "city")
    private WebElement cityAddressInput;

    @FindBy(id = "id_state")
    private WebElement stateAddressSelect;

    @FindBy(id = "postcode")
    private WebElement postcodeAddressInput;

    @FindBy(id = "id_country")
    private WebElement countryAddressSelect;

    @FindBy(id = "other")
    private WebElement additionalInformationInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasAddressInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        System.out.println("Opened register page");
    }

    public RegisterPage chooseMrTitle(WebDriver driver) {
        waitUntilElementIsVisible(driver, firstNameInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(mrTitleRadio).click().perform();
        System.out.println("Mr title is chosen");
        return new RegisterPage(driver);
    }

    public RegisterPage chooseMrsTitle(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(mrsTitleRadio).click().perform();
        System.out.println("Mrs title is chosen");
        return new RegisterPage(driver);
    }

    public RegisterPage fillInFirstName(WebDriver driver, String firstName) {
        waitUntilElementIsVisible(driver, firstNameInput);
        firstNameInput.sendKeys(firstName);
        System.out.println("First name is completed");
        return this;
    }

    public RegisterPage fillInLastName(WebDriver driver, String lastName) {
        waitUntilElementIsVisible(driver, lastNameInput);
        lastNameInput.sendKeys(lastName);
        System.out.println("Last name is completed");
        return this;
    }

    public RegisterPage fillInPassword(WebDriver driver, String password) {
        waitUntilElementIsVisible(driver, passwordInput);
        passwordInput.sendKeys(password);
        System.out.println("Password is completed");
        return this;
    }

    public RegisterPage selectDayInDateOfBirth(WebDriver driver, String dayInDateOfBirth) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", dateOfBirthDaysSelect);
        Select daysInDateOdBirthSelectOptions = new Select(dateOfBirthDaysSelect);
        daysInDateOdBirthSelectOptions.selectByVisibleText(dayInDateOfBirth);
        System.out.println("Day in date of birth is selected");
        return this;
    }

    public RegisterPage selectMonthInDateOfBirth(String monthInDateOfBirth) {
        Select monthsInDateOdBirthSelectOptions = new Select(dateOfBirthMonthsSelect);
        monthsInDateOdBirthSelectOptions.selectByVisibleText(monthInDateOfBirth);
        System.out.println("Month in date of birth is selected");
        return this;
    }

    public RegisterPage selectYearInDateOfBirth(String yearInDateOfBirth) {
        Select yearsInDateOdBirthSelectOptions = new Select(dateOfBirthYearsSelect);
        yearsInDateOdBirthSelectOptions.selectByVisibleText(yearInDateOfBirth);
        System.out.println("Year in date of birth is selected");
        return this;
    }

    public RegisterPage tickNewsletterCheckbox(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", newsletterCheckbox);
        Actions actions = new Actions(driver);
        actions.moveToElement(newsletterCheckbox).click().perform();
        System.out.println("Tick newsletter checkbox");
        return new RegisterPage(driver);
    }

    public RegisterPage tickSpecialOffersCheckbox(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(specialOffersCheckbox).click().perform();
        System.out.println("Tick special offers checkbox");
        return new RegisterPage(driver);
    }

    public RegisterPage fillInCompany(WebDriver driver, String company) {
        waitUntilElementIsVisible(driver, companyInput);
        companyInput.sendKeys(company);
        System.out.println("Company is completed");
        return this;
    }

    public RegisterPage fillInStreet(WebDriver driver, String street) {
        waitUntilElementIsVisible(driver, streetAddressInput);
        streetAddressInput.sendKeys(street);
        System.out.println("Street is completed");
        return this;
    }

    public RegisterPage fillInApartment(WebDriver driver, String apartment) {
        waitUntilElementIsVisible(driver, apartmentAddressInput);
        apartmentAddressInput.sendKeys(apartment);
        System.out.println("Apartment is completed");
        return this;
    }

    public RegisterPage fillInCity(WebDriver driver, String city) {
        waitUntilElementIsVisible(driver, cityAddressInput);
        cityAddressInput.sendKeys(city);
        System.out.println("City is completed");
        return this;
    }

    public RegisterPage selectState(String state) {
        Select stateSelectOptions = new Select(stateAddressSelect);
        stateSelectOptions.selectByVisibleText(state);
        System.out.println("State is completed");
        return this;
    }

    public RegisterPage fillInPostalCode(WebDriver driver, String postcode) {
        waitUntilElementIsVisible(driver, postcodeAddressInput);
        postcodeAddressInput.sendKeys(postcode);
        System.out.println("Postcode is completed");
        return this;
    }

    public RegisterPage fillInAdditionalInformation(WebDriver driver, String information) {
        waitUntilElementIsVisible(driver, additionalInformationInput);
        additionalInformationInput.sendKeys(information);
        System.out.println("Additional information is completed");
        return this;
    }

    public RegisterPage fillInHomePhoneNumber(WebDriver driver, String homePhoneNumber) {
        waitUntilElementIsVisible(driver, homePhoneInput);
        homePhoneInput.sendKeys(homePhoneNumber);
        System.out.println("Home phone is completed");
        return this;
    }

    public RegisterPage fillInMobilePhoneNumber(WebDriver driver, String mobilePhoneNumber) {
        waitUntilElementIsVisible(driver, mobilePhoneInput);
        mobilePhoneInput.sendKeys(mobilePhoneNumber);
        System.out.println("Mobile phone is completed");
        return this;
    }

    public RegisterPage fillInAddressAlias(WebDriver driver, String addressAlias) {
        waitUntilElementIsVisible(driver, aliasAddressInput);
        aliasAddressInput.clear();
        aliasAddressInput.sendKeys(addressAlias);
        System.out.println("Address alias is completed");
        return this;
    }

    public RegisterPage registerWithErrors(WebDriver driver) {
        clickOnRegisterButton(driver);
        return this;
    }

    public AccountPage registerSuccess(WebDriver driver) {
        clickOnRegisterButton(driver);
        System.out.println("Register button is clicked");
        return new AccountPage(driver);
    }

    public void clickOnRegisterButton(WebDriver driver) {
        waitUntilElementIsVisible(driver, registerButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", registerButton);
        registerButton.click();
    }

    public RegisterPage assertRegisterPageIsOpen(WebDriver driver, String expectedRegisterHeaderText,
                                                 String expectedPersonalInformationHeaderText, String expectedAddressHeaderText)
    {
        waitUntilElementIsVisible(driver, mrTitleRadio);

        System.out.println("Checking if register header text is correct");
        String actualRegisterHeaderText = registerHeader.getText();
        assertEquals(expectedRegisterHeaderText, actualRegisterHeaderText);
        System.out.println("Register header text is correct " + expectedRegisterHeaderText);

        System.out.println("Checking if personal information header text is correct");
        String actualPersonalInformationHeaderText = personalInformationHeader.getText();
        assertEquals(expectedPersonalInformationHeaderText, actualPersonalInformationHeaderText);
        System.out.println("Personal information header text is correct " + expectedPersonalInformationHeaderText);

        System.out.println("Checking if address header text is correct");
        String actualAddressHeaderText = addressHeader.getText();
        assertEquals(expectedAddressHeaderText, actualAddressHeaderText);
        System.out.println("Address header text is correct " + expectedAddressHeaderText);

        System.out.println("Checking if all register inputs are visible");
        assertTrue(mrTitleRadio.isEnabled());
        assertTrue(mrsTitleRadio.isEnabled());
        assertTrue(firstNameInput.isDisplayed());
        assertTrue(lastNameInput.isDisplayed());
        assertTrue(emailInput.isDisplayed());
        assertTrue(passwordInput.isDisplayed());
        assertTrue(dateOfBirthDaysSelect.isEnabled());
        assertTrue(dateOfBirthMonthsSelect.isEnabled());
        assertTrue(dateOfBirthYearsSelect.isEnabled());
        assertTrue(newsletterCheckbox.isEnabled());
        assertTrue(specialOffersCheckbox.isEnabled());
        assertTrue(firstNameAddressInput.isDisplayed());
        assertTrue(lastNameAddressInput.isDisplayed());
        assertTrue(streetAddressInput.isDisplayed());
        assertTrue(apartmentAddressInput.isDisplayed());
        assertTrue(cityAddressInput.isDisplayed());
        assertTrue(stateAddressSelect.isEnabled());
        assertTrue(postcodeAddressInput.isDisplayed());
        assertTrue(countryAddressSelect.isEnabled());
        assertTrue(additionalInformationInput.isDisplayed());
        assertTrue(homePhoneInput.isDisplayed());
        assertTrue(mobilePhoneInput.isDisplayed());
        assertTrue(aliasAddressInput.isDisplayed());
        System.out.println("All register inputs are visible");

        System.out.println("Checking if register button is enabled");
        assertTrue(registerButton.isEnabled());
        System.out.println("Account register is enabled");
        return this;
    }

    public RegisterPage assertRegisterEmailIsComplete(WebDriver driver, String expectedRegisterEmail)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", emailInput);

        System.out.println("Checking if register email is correct");
        String actualRegisterEmail = emailInput.getAttribute("value");
        assertEquals(expectedRegisterEmail, actualRegisterEmail);
        System.out.println("Register email is correct " + expectedRegisterEmail);

        return this;
    }

    public RegisterPage assertRegisterErrorCommunication(String expectedCommunication) {
        String actualCommunication = alert.getText();
        assertEquals(expectedCommunication, actualCommunication);
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
