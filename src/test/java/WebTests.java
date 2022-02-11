import com.qaprosoft.carina.core.foundation.utils.Configuration;
import models.User;

public class WebTests {

  private User user = new User(Configuration.getEnvArg("username"),
      Configuration.getEnvArg("password"));
  private LoginPage loginPage = new LoginPage();
  private ProductsMainPage productsMainPage;

  /**
   * Login to https://www.saucedemo.com/ using the "standard_user" account
   * Sort the products by Price (high to low)
   * Add the cheapest & the 2nd costliest products to your basket
   * Open the basket
   * Checkout
   * Enter details and Finish the purchase
   */
  public void purchaseProducts() {

  }

}