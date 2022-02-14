import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserCartPage {

  private WebElement checkoutButton;
  private WebElement yourCart;
  private WebElement continueShoppingButton;
  private WebElement onesie;
  private WebElement backpack;
  private WebElement boltTShirt;
  private WebElement redTShirt;

  public WebElement getYourCart(WebDriver driver) {
    this.yourCart = driver.findElement(By.xpath("//span[contains(text(),'Your Cart')]"));
    return this.yourCart;
  }

  public WebElement getRedTShirt(WebDriver driver) {
    this.redTShirt = driver.findElement(By.xpath("//div[contains(text(), 'Test.allTheThings() T-Shirt (Red)')]"));
    return this.redTShirt;
  }

  public WebElement getBoltTShirt(WebDriver driver) {
    this.boltTShirt = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bolt T-Shirt')]"));
    return this.boltTShirt;
  }

  public WebElement getOnesie(WebDriver driver) {
    this.onesie = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Onesie')]"));
    return this.onesie;
  }

  public WebElement getBackpack(WebDriver driver) {
    this.backpack = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
    return this.backpack;
  }

  public CheckoutInfoPage checkout(WebDriver driver) {
    checkoutButton = driver.findElement(By.id("checkout"));

    if(checkoutButton.isDisplayed())
      checkoutButton.click();
    return new CheckoutInfoPage();
  }

  public ProductsMainPage continueShopping(WebDriver driver) {
    this.continueShoppingButton = driver.findElement(By.id("continue-shopping"));
    if(continueShoppingButton.isDisplayed()) {
      continueShoppingButton.click();
    }
    return new ProductsMainPage();
  }
}
