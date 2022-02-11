import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class PurchaseOverviewPage extends AbstractPage {

  WebElement onsieItem = driver.findElement(By.id("item_1_tittle_link"));

  WebElement backpackItem = driver.findElement(By.id("item_4_tittle_link"));

  WebElement finishButton = driver.findElement(By.id("finish"));

  public PurchaseOverviewPage() {
    super();
  }

  public AbstractPage finishPurchase() {
    if(onsieItem.isDisplayed() && backpackItem.isDisplayed()) {
      finishButton.click();
    }
    else
      throw new NotFoundException("");
    return new CompletedPurchasePage();
  }
}
