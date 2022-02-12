import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseOverviewPage {

  private WebElement onsieItem;
  private WebElement backpackItem;
  private WebElement finishButton;
  private WebElement checkoutOverview;

  public WebElement getCheckoutOverview(WebDriver driver) {
    this.checkoutOverview = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]"));
    return this.checkoutOverview;
  }

  public CompletedPurchasePage finishPurchase(WebDriver driver) {
    onsieItem = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Onesie')]"));
    backpackItem = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
    finishButton = driver.findElement(By.id("finish"));

    if(onsieItem.isDisplayed() && backpackItem.isDisplayed()) {
      finishButton.click();
    }
    else
      throw new NotFoundException("");
    return new CompletedPurchasePage();
  }
}
