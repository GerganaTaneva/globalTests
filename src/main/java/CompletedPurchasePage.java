import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompletedPurchasePage extends AbstractPage {

  private WebElement checkoutComplete = driver.findElement(By.xpath("//span[text()='Checkout: Complete!']"));

  private WebElement backToHomeButton = driver.findElement(By.id("back_to_products"));

  public WebElement getCheckoutComplete() {
    return this.checkoutComplete;
  }

  public WebElement getBackToHomeButton() {
    return this.backToHomeButton;
  }

  public CompletedPurchasePage() {
    super();
  }
}
