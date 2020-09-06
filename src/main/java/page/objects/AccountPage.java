package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        System.out.println("Opened account page");
    }

    public LogInPage clickOnLogoutButton() {
        logoutButton.click();
        System.out.println("Clicked on logout button");
        return new LogInPage(driver);
    }

    public AccountPage assertAccountPageIsOpen(String expectedWebsiteAddress, String expectedAccountHeaderText) {
        System.out.println("Checking if website address is proper");
        String actualWebsiteAddress = driver.getCurrentUrl();
        assertEquals(expectedWebsiteAddress, actualWebsiteAddress);
        System.out.println("Website address: '" + driver.getCurrentUrl() + " is proper");
        System.out.println("Checking if account header text is correct");
        String actualAccountHeaderText = accountHeader.getText();
        assertEquals(expectedAccountHeaderText, actualAccountHeaderText);
        System.out.println("Account header text is correct " + expectedAccountHeaderText);
        System.out.println("Checking if all account sections are visible");
        assertTrue(orderHistoryAndDetailsSection.isDisplayed());
        assertTrue(creditSlipsSection.isDisplayed());
        assertTrue(addressesSection.isDisplayed());
        assertTrue(personalInformationSection.isDisplayed());
        assertTrue(wishlistsSection.isDisplayed());
        System.out.println("All account sections are visible");
        System.out.println("Checking if account button is enabled");
        assertTrue(accountButton.isEnabled());
        System.out.println("Account button is enabled");
        System.out.println("Checking if sign out button is enabled");
        assertTrue(logoutButton.isEnabled());
        System.out.println("Log out button is enabled");
        return this;
    }

}
