package page.objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@Slf4j
public class HomePage {

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(css = "a[class='login']")
    private WebElement signInButton;

    @FindBy(id = "search_query_top")
    private WebElement textFieldSearch;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(css = "div[id='block_top_menu'] a[title='Women']")
    private WebElement topMenuWomenOption;

    @FindBy(xpath = "//div[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement topMenuDressesOption;

    @FindBy(xpath = "//div[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement topMenuTshirtsOption;

    @FindBy(id = "homepage-slider")
    private WebElement mainSlider;

    @FindBy(xpath = "//ul[@id=\"homeslider\"]/li[4]/div/p[2]/button")
    private WebElement sliderButton;

    @FindBy(css = "div[id='htmlcontent_top'] li[class='htmlcontent-item-1 col-xs-4']")
    private WebElement topSlider;

    @FindBy(css = "div[id='htmlcontent_top'] li[class='htmlcontent-item-2 col-xs-4']")
    private WebElement bottomSlider;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        log.info("Opened home page");
    }

    public ContactPage clickOnContactIcon() {
        contactUsButton.click();
        log.info("Clicked on button Contact us");
        return new ContactPage(driver);
    }

    public LogInPage clickOnSignInIcon() {
        waitUntilElementIsVisible(driver, signInButton);
        signInButton.click();
        log.info("Clicked on button Sign in");
        return new LogInPage(driver);
    }

    public HomePage typeIntoSearchQuery(String productName) {
        textFieldSearch.sendKeys(productName);
        log.info("Typed into field Search Query " + productName);
        return this;
    }

    public SearchResultsPage clickOnSearchIcon() {
        searchButton.click();
        log.info("Clicked on button Search");
        return new SearchResultsPage(driver);
    }

    public WomenPage clickOnTopMenuWomenOption() {
        topMenuWomenOption.click();
        log.info("Clicked on top menu Women option");
        return new WomenPage(driver);
    }

    public DressesPage clickOnTopMenuDressesOption() {
        topMenuDressesOption.click();
        log.info("Clicked on top menu Dresses option");
        return new DressesPage(driver);
    }

    public TshirtsPage clickOnTopMenuTshirtsOption() {
        topMenuTshirtsOption.click();
        log.info("Clicked on top menu T-shirts option");
        return new TshirtsPage(driver);
    }

    public HomePage clickOnMainSlider() {
        mainSlider.click();
        log.info("Clicked on main slider");
        return this;
    }

    public HomePage clickOnSliderButton(WebDriver driver) {
        waitUntilElementIsVisible(driver, sliderButton);
        sliderButton.click();
        log.info("Clicked on slider button");
        return this;
    }

    public HomePage clickOnTopSlider() {
        topSlider.click();
        log.info("Clicked on top slider");
        return this;
    }

    public HomePage clickOnBottomSlider() {
        bottomSlider.click();
        log.info("Clicked on bottom slider");
        return this;
    }

    public HomePage assertWebsiteAddress(String expectedWebsiteAddress) {
        log.info("Checking if website address is proper");
        String actualWebsiteAddress = driver.getCurrentUrl();
        assertEquals(expectedWebsiteAddress, actualWebsiteAddress);
        log.info("Website address: '" + actualWebsiteAddress + " is proper");
        return this;
    }

    public HomePage assertButtonText(WebDriver driver, String expectedButtonText) {
        waitUntilElementIsVisible(driver, sliderButton);
        log.info("Checking if button text is correct");
        String actualButtonText = sliderButton.getText();
        assertEquals(expectedButtonText, actualButtonText);
        log.info("Button text is correct " + expectedButtonText);
        return this;
    }

    private void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
