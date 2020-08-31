import org.junit.Test;
import page.objects.HomePage;

public class SliderTest extends TestBase {

    public static final String WEBSITE_ADDRESS_GENERAL = "https://www.prestashop.com/pl";
    public static final String WEBSITE_ADDRESS_SPECIFIC = "https://www.prestashop.com/pl?utm_source=v16_homeslider";
    public static final String BUTTON_TEXT = "SHOP NOW !";

    @Test
    public void checkSliderButtonText() {
        HomePage homePage = new HomePage(driver);
        homePage
                .assertButtonText(driver, BUTTON_TEXT);
    }

    @Test
    public void goToPageFromSliderButton() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSliderButton(driver)
                .assertWebsiteAddress(WEBSITE_ADDRESS_SPECIFIC);
    }

    @Test
    public void goToPageFromMainSlider() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnMainSlider()
                .assertWebsiteAddress(WEBSITE_ADDRESS_SPECIFIC);
    }

    @Test
    public void goToPageFromTopSlider() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopSlider()
                .assertWebsiteAddress(WEBSITE_ADDRESS_GENERAL);
    }

    @Test
    public void goToPageFromBottomSlider() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnBottomSlider()
                .assertWebsiteAddress(WEBSITE_ADDRESS_GENERAL);
    }

}