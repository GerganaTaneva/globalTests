import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletedPurchasePage {

  private WebElement checkoutComplete;
  private WebElement backToHomeButton;

  public WebElement getCheckoutComplete(WebDriver driver) {
    this.checkoutComplete = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Complete!')]"));
    return this.checkoutComplete;
  }

  public WebElement getBackToHomeButton(WebDriver driver) {
    this.backToHomeButton = driver.findElement(By.id("back-to-products"));
    return this.backToHomeButton;
  }
}
