import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTests {

  private User user = new User("standard_user", "secret_sauce");
  private WebDriver driver;
//  private ProductsMainPage productsMainPage;
//  private UserCartPage userCartPage;
//  private CheckoutInfoPage checkoutInfoPage;
//  private PurchaseOverviewPage purchaseOverviewPage;
//  private CompletedPurchasePage completedPurchasePage;

  @BeforeTest
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
    CheckoutInfoPage checkoutInfoPage = userCartPage.checkout(driver);
    Assert.assertTrue(checkoutInfoPage.getCheckoutInfo(driver).isDisplayed());
    PurchaseOverviewPage purchaseOverviewPage = checkoutInfoPage.addInfoForPurchase("Gergana", "Taneva",
        "1336", driver);
    Assert.assertTrue(purchaseOverviewPage.getCheckoutOverview(driver).isDisplayed());
    CompletedPurchasePage completedPurchasePage = purchaseOverviewPage.finishPurchase(driver);
    Assert.assertTrue(completedPurchasePage.getCheckoutComplete(driver).isDisplayed());
    Assert.assertTrue(completedPurchasePage.getBackToHomeButton(driver).isDisplayed());
  }

  @AfterTest
  public void closeDriver() {
    driver.close();
  }
}