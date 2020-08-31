import org.junit.Test;
import page.objects.HomePage;

import static configuration.Configuration.LOGIN;
import static configuration.Configuration.PASSWORD;

public class LogOutTest extends TestBase {

    @Test
    public void logOutSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnSignInIcon()
                .signInSuccess(driver, LOGIN, PASSWORD)
                .clickOnLogoutButton()
                .assertLogout();
    }

}