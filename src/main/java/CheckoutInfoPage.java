import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage {

  private WebElement firstName;
  private WebElement lastName;
  private WebElement postalCode;
  private WebElement continueButton;
  private WebElement checkoutInfo;

  public WebElement getCheckoutInfo(WebDriver driver) {
    this.checkoutInfo = driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]"));
    return this.checkoutInfo;
  }

  public PurchaseOverviewPage addInfoForPurchase(String firstName, String lastName, String postalCode,
      WebDriver driver){
    this.firstName = driver.findElement(By.id("first-name"));
    this.lastName = driver.findElement(By.id("last-name"));
    this.postalCode = driver.findElement(By.id("postal-code"));
    this.continueButton = driver.findElement(By.id("continue"));

    if(this.firstName.isDisplayed() && this.lastName.isDisplayed() && this.postalCode.isDisplayed()) {
      this.firstName.sendKeys(firstName);
      this.lastName.sendKeys(lastName);
      this.postalCode.sendKeys(postalCode);
      this.continueButton.click();
    }
    return new PurchaseOverviewPage();
  }
}
