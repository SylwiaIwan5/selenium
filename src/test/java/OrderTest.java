import org.junit.Test;
import page.objects.HomePage;

import static configuration.Configuration.LOGIN;
import static configuration.Configuration.PASSWORD;

public class OrderTest extends TestBase {

    public static final String COMMUNICATION = "Your order on My Store is complete.";

    @Test
    public void bankWireOrderSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopMenuWomenOption()
                .chooseProduct()
                .addProductToCart()
                .switchToPopup()
                .clickOnProceedToCheckoutButton(driver)
                .clickOnProceedToCheckoutButton(driver)
                .signInSuccess(driver, LOGIN, PASSWORD)
                .clickOnProceedToCheckoutButton(driver)
                .tickCheckbox(driver)
                .clickOnProceedToCheckoutButton(driver)
                .choosePaymentByBankWire(driver)
                .clickOnConfirmOrderButton(driver)
                .assertCommunication(driver, COMMUNICATION);
    }

    @Test
    public void checkOrderSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopMenuWomenOption()
                .chooseProduct()
                .addProductToCart()
                .switchToPopup()
                .clickOnProceedToCheckoutButton(driver)
                .clickOnProceedToCheckoutButton(driver)
                .signInSuccess(driver, LOGIN, PASSWORD)
                .clickOnProceedToCheckoutButton(driver)
                .tickCheckbox(driver)
                .clickOnProceedToCheckoutButton(driver)
                .choosePaymentByCheck(driver)
                .clickOnConfirmOrderButton(driver)
                .assertCommunication(driver, COMMUNICATION);
    }

}