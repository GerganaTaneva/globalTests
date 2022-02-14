import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTests {

  private User user = new User("standard_user", "secret_sauce");
  private WebDriver driver;

  @BeforeMethod
  public void setDriver() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
  }

  /**
   * Login to https://www.saucedemo.com/ using the "standard_user" account
   * Sort the products by Price (high to low)
   * Add the cheapest & the 2nd costliest products to your basket
   * Open the basket
   * Checkout
   * Enter details and Finish the purchase
   */
  @Test(description = "Make purchase for two items")
  public void purchaseProducts() {
    LoginPage loginPage = new LoginPage(driver);
    ProductsMainPage productsMainPage = loginPage.login(user, driver);
    Assert.assertTrue(productsMainPage.getProducts(driver).isDisplayed());
    UserCartPage userCartPage = productsMainPage.addCheapestAndSecondCostliestProductsToCart(driver);
    Assert.assertTrue(userCartPage.getYourCart(driver).isDisplayed());
    Assert.assertTrue(userCartPage.getOnesie(driver).isDisplayed());
    Assert.assertTrue(userCartPage.getBackpack(driver).isDisplayed());
    CheckoutInfoPage checkoutInfoPage = userCartPage.checkout(driver);
    Assert.assertTrue(checkoutInfoPage.getCheckoutInfo(driver).isDisplayed());
    PurchaseOverviewPage purchaseOverviewPage = checkoutInfoPage.addInfoForPurchase("Gergana", "Taneva",
        "1336", driver);
    Assert.assertTrue(purchaseOverviewPage.getCheckoutOverview(driver).isDisplayed());
    CompletedPurchasePage completedPurchasePage = purchaseOverviewPage.finishPurchase(driver);
    Assert.assertTrue(completedPurchasePage.getCheckoutComplete(driver).isDisplayed());
    Assert.assertTrue(completedPurchasePage.getBackToHomeButton(driver).isDisplayed());
    productsMainPage = completedPurchasePage.getBackToMain(driver);
    BurgerMenu menu = productsMainPage.openMenu(driver);
    menu.logout(driver);
  }

  /**
   * Log in with invalid User
   */
  @Test(description = "Login with invalid credentials")
  public void loginWithInvalidCredentials() {
    User invalidUser = new User("geriT@gmail.com", "55555");
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(invalidUser, driver);
    Assert.assertEquals(loginPage.getErrorMessage(driver).getText(),
        "Epic sadface: Username and password do not match any user in this service");
  }

  /**
   * Login, add items in cart and log out
   */
  @Test(description = "Add T-shirts to cart and continue shopping")
  public void addToCartTShirts() {
    LoginPage loginPage = new LoginPage(driver);
    ProductsMainPage productsMainPage = loginPage.login(user, driver);
    Assert.assertTrue(productsMainPage.getProducts(driver).isDisplayed());
    UserCartPage userCartPage = productsMainPage.addToCartTShirts(driver);
    Assert.assertTrue(userCartPage.getYourCart(driver).isDisplayed());
    Assert.assertTrue(userCartPage.getRedTShirt(driver).isDisplayed());
    Assert.assertTrue(userCartPage.getBoltTShirt(driver).isDisplayed());
    productsMainPage = userCartPage.continueShopping(driver);
    BurgerMenu menu = productsMainPage.openMenu(driver);
    loginPage = menu.logout(driver);
    Assert.assertTrue(loginPage.getUsername(driver).isEnabled());
    Assert.assertTrue(loginPage.getPassword(driver).isEnabled());
  }

  @AfterMethod
  public void closeDriver() {
    driver.close();
  }
}