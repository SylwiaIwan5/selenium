package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class AccountPage {

    @FindBy(className = "page-heading")
    private WebElement accountHeader;

    @FindBy(className = "icon-list-ol")
    private WebElement orderHistoryAndDetailsSection;

    @FindBy(className = "icon-ban-circle")
    private WebElement creditSlipsSection;

    @FindBy(className = "icon-building")
    private WebElement addressesSection;

    @FindBy(className = "icon-user")
    private WebElement personalInformationSection;

    @FindBy(className = "icon-heart")
    private WebElement wishlistsSection;

    @FindBy(className = "account")
    private WebElement accountButton;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        log.info("Opened account page");
    }

    public LogInPage clickOnLogoutButton() {
        logoutButton.click();
        log.info("Clicked on logout button");
        return new LogInPage(driver);
    }

    public AccountPage assertAccountPageIsOpen(String expectedWebsiteAddress, String expectedAccountHeaderText) {
        log.info("Checking if website address is proper");
        String actualWebsiteAddress = driver.getCurrentUrl();
        assertEquals(expectedWebsiteAddress, actualWebsiteAddress);
        log.info("Website address: '" + driver.getCurrentUrl() + " is proper");
        log.info("Checking if account header text is correct");
        String actualAccountHeaderText = accountHeader.getText();
        assertEquals(expectedAccountHeaderText, actualAccountHeaderText);
        log.info("Account header text is correct " + expectedAccountHeaderText);
        log.info("Checking if all account sections are visible");
        assertTrue(orderHistoryAndDetailsSection.isDisplayed());
        assertTrue(creditSlipsSection.isDisplayed());
        assertTrue(addressesSection.isDisplayed());
        assertTrue(personalInformationSection.isDisplayed());
        assertTrue(wishlistsSection.isDisplayed());
        log.info("All account sections are visible");
        log.info("Checking if account button is enabled");
        assertTrue(accountButton.isEnabled());
        log.info("Account button is enabled");
        log.info("Checking if sign out button is enabled");
        assertTrue(logoutButton.isEnabled());
        log.info("Log out button is enabled");
        return this;
    }

}
