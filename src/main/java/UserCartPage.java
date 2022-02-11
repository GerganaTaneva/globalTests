import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserCartPage extends AbstractPage {

  private WebElement checkoutButton = driver.findElement(By.id("checkout"));

  public AbstractPage checkout() {
    if(this.checkoutButton.isDisplayed())
      this.checkoutButton.click();
    return new CheckoutInfoPage();
  }
}
