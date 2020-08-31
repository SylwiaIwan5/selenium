import org.junit.Test;
import page.objects.*;

public class CartTest extends TestBase {

    public static final String WOMEN_PAGE_WEBSITE_ADDRESS = "http://automationpractice.com/index.php?id_category=3&controller=category";
    public static final String DRESSES_PAGE_WEBSITE_ADDRESS = "http://automationpractice.com/index.php?id_category=8&controller=category";
    public static final String TSHIRTS_PAGE_WEBSITE_ADDRESS = "http://automationpractice.com/index.php?id_category=5&controller=category";
    public static final String CART_WEBSITE_ADDRESS = "http://automationpractice.com/index.php?controller=order";

    public static final String WOMEN_PAGE_HEADER_TEXT = "Women";
    public static final String DRESSES_PAGE_HEADER_TEXT = "DRESSES";
    public static final String TSHIRTS_PAGE_HEADER_TEXT = "CATALOG";
    public static final String CART_HEADER_TEXT = "Your shopping cart";

    public static final String CART_TEXT = "Cart 1 Product";

    public static final String COMMUNICATION_EMPTY_CART = "Your shopping cart is empty.";

    @Test
    public void fromWomenPageAfterAddToCartPopupIsDisplayedSuccessfully() {
        HomePage homePage = new HomePage(driver);
        WomenPage womenPage = homePage
                .clickOnTopMenuWomenOption()
                .chooseProduct();
        String chosenProductName = womenPage
                .getProductName();
        womenPage
                .addProductToCart()
                .switchToPopup()
                .assertPopupIsDisplayed(driver, chosenProductName);
    }

    @Test
    public void fromWomenPageAfterAddToCartContinueShoppingSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopMenuWomenOption()
                .chooseProduct()
                .addProductToCart()
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .assertWomenPageIsOpen(driver, WOMEN_PAGE_WEBSITE_ADDRESS, WOMEN_PAGE_HEADER_TEXT)
                .assertCartIsVisible(CART_TEXT);
    }

    @Test
    public void fromWomenPageAddToCartSuccessfully()  {
        HomePage homePage = new HomePage(driver);
        WomenPage womenPage = homePage
                .clickOnTopMenuWomenOption()
                .chooseProduct();
        String chosenProductName = womenPage
                .getProductName();
        womenPage
                .addProductToCart()
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .goToCart()
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void fromWomenPageProceedToCheckoutSuccessfully() {
        HomePage homePage = new HomePage(driver);
        WomenPage womenPage = homePage
                .clickOnTopMenuWomenOption()
                .chooseProduct();
        String chosenProductName = womenPage
                .getProductName();
        womenPage
                .addProductToCart()
                .switchToPopup()
                .clickOnProceedToCheckoutButton(driver)
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void fromDressesPageAfterAddToCartPopupIsDisplayedSuccessfully() {
        HomePage homePage = new HomePage(driver);
        DressesPage dressesPage = homePage
                .clickOnTopMenuDressesOption()
                .chooseProduct();
        String chosenProductName = dressesPage
                .getProductName();
        dressesPage
                .addProductToCart(driver)
                .switchToPopup()
                .assertPopupIsDisplayed(driver, chosenProductName);
    }

    @Test
    public void fromDressesPageAfterAddToCartContinueShoppingSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopMenuDressesOption()
                .chooseProduct()
                .addProductToCart(driver)
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .assertDressesPageIsOpen(driver, DRESSES_PAGE_WEBSITE_ADDRESS, DRESSES_PAGE_HEADER_TEXT)
                .assertCartIsVisible(CART_TEXT);
    }

    @Test
    public void fromDressesPageAddToCartSuccessfully()  {
        HomePage homePage = new HomePage(driver);
        DressesPage dressesPage = homePage
                .clickOnTopMenuDressesOption()
                .chooseProduct();
        String chosenProductName = dressesPage
                .getProductName();
        dressesPage
                .addProductToCart(driver)
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .goToCart()
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void fromDressesPageProceedToCheckoutSuccessfully() {
        HomePage homePage = new HomePage(driver);
        DressesPage dressesPage = homePage
                .clickOnTopMenuDressesOption()
                .chooseProduct();
        String chosenProductName = dressesPage
                .getProductName();
        dressesPage
                .addProductToCart(driver)
                .switchToPopup()
                .clickOnProceedToCheckoutButton(driver)
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void fromTshirtsPageAfterAddToCartPopupIsDisplayedSuccessfully() {
        HomePage homePage = new HomePage(driver);
        TshirtsPage tshirtsPage = homePage
                .clickOnTopMenuTshirtsOption()
                .chooseProduct();
        String chosenProductName = tshirtsPage
                .getProductName();
        tshirtsPage
                .addProductToCart()
                .switchToPopup()
                .assertPopupIsDisplayed(driver, chosenProductName);
    }

    @Test
    public void fromTshirtsPageAfterAddToCartContinueShoppingSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopMenuTshirtsOption()
                .chooseProduct()
                .addProductToCart()
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .assertTshirtsPageIsOpen(driver, TSHIRTS_PAGE_WEBSITE_ADDRESS, TSHIRTS_PAGE_HEADER_TEXT)
                .assertCartIsVisible(CART_TEXT);
    }

    @Test
    public void fromTshirtsPageAddToCartSuccessfully()  {
        HomePage homePage = new HomePage(driver);
        TshirtsPage tshirtsPage = homePage
                .clickOnTopMenuTshirtsOption()
                .chooseProduct();
        String chosenProductName = tshirtsPage
                .getProductName();
        tshirtsPage
                .addProductToCart()
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .goToCart()
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void fromTshirtsPageProceedToCheckoutSuccessfully() {
        HomePage homePage = new HomePage(driver);
        TshirtsPage tshirtsPage = homePage
                .clickOnTopMenuTshirtsOption()
                .chooseProduct();
        String chosenProductName = tshirtsPage
                .getProductName();
        tshirtsPage
                .addProductToCart()
                .switchToPopup()
                .clickOnProceedToCheckoutButton(driver)
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void fromTshirtsPageFromProductDetailsAddToCartSuccessfully()  {
        HomePage homePage = new HomePage(driver);
        TshirtsPage tshirtsPage = homePage
                .clickOnTopMenuTshirtsOption()
                .chooseProduct();
        String chosenProductName = tshirtsPage
                .getProductName();
        tshirtsPage
                .clickOnProduct()
                .addProductToCart()
                .switchToPopup()
                .clickOnContinueShoppingButton(driver)
                .goToCart()
                .assertCartIsOpen(driver, CART_WEBSITE_ADDRESS, CART_HEADER_TEXT, chosenProductName);
    }

    @Test
    public void deleteProductFromCartSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage
                .clickOnTopMenuDressesOption()
                .chooseProduct()
                .addProductToCart(driver)
                .switchToPopup()
                .clickOnProceedToCheckoutButton(driver)
                .clickOnDeleteIcon(driver)
                .assertCartIsEmpty(driver, COMMUNICATION_EMPTY_CART);
    }

}