import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserCartPage {

  private WebElement checkoutButton;
  private WebElement yourCart;

  public WebElement getYourCart(WebDriver driver) {
    this.yourCart = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]"));
    return this.yourCart;
  }

  public CheckoutInfoPage checkout(WebDriver driver) {
    checkoutButton = driver.findElement(By.id("checkout"));

    if(checkoutButton.isDisplayed())
      checkoutButton.click();
    return new CheckoutInfoPage();
  }
}
