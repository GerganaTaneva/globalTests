import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage extends AbstractPage {

  WebElement firstName = driver.findElement(By.id("first-name"));

  WebElement lastName = driver.findElement(By.id("last-name"));

  WebElement postalCode = driver.findElement(By.id("postal-code"));

  WebElement continueButton = driver.findElement(By.id("continue"));

  public CheckoutInfoPage() {
    super();
  }

  public AbstractPage addInfoForPurchase(String firstName, String lastName, String postalCode){
    if(this.firstName.isDisplayed() && this.lastName.isDisplayed() && this.postalCode.isDisplayed()) {
      this.firstName.sendKeys(firstName);
      this.lastName.sendKeys(lastName);
      this.postalCode.sendKeys(postalCode);
      this.continueButton.click();
    }
    return new PurchaseOverviewPage();
  }
}
