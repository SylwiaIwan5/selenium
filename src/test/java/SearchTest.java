import org.junit.Test;
import page.objects.HomePage;

public class SearchTest extends TestBase {

    public static final String FADED_SHORT_SLEEVE_T_SHIRTS = "Faded Short Sleeve T-shirts";
    public static final String RED_DRESS = "Red Dress";
    public static final String COMMUNICATION_NO_INPUT = "Please enter a search keyword";
    public static final String COMMUNICATION = "No results were found for your search \"" + RED_DRESS + "\"";

    @Test
    public void searchProductSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .typeIntoSearchQuery(FADED_SHORT_SLEEVE_T_SHIRTS)
                .clickOnSearchIcon()
                .assertProductName(driver, FADED_SHORT_SLEEVE_T_SHIRTS);
    }

    @Test
    public void searchProductUnsuccessfullyBecauseOfNoSearchInput() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSearchIcon()
                .assertCommunication(driver, COMMUNICATION_NO_INPUT);
    }

    @Test
    public void searchProductUnsuccessfullyBecauseOfProductNotFound() {
        HomePage homePage = new HomePage(driver);
        homePage
                .typeIntoSearchQuery(RED_DRESS)
                .clickOnSearchIcon()
                .assertCommunication(driver, COMMUNICATION);
    }

}