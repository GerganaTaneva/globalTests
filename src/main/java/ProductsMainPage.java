import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class ProductsMainPage extends AbstractPage {

  private WebElement selectSort = driver.findElement(By.tagName("select"));

  private WebElement optionHighToLow = driver.findElement(By.xpath("//option[text()='Price (high to low)']"));

  private WebElement addToCartBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

  private WebElement addToCartOnesie = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));

  private WebElement removeFromCartOnesie = driver.findElement(By.id("remove-sauce-labs-onesie"));

  private WebElement removeFromCartBackpack = driver.findElement(By.id("remove-sauce-labs-backpack"));

  private WebElement shoppingCartButton = driver.findElement(By.xpath("//a[class='shopping_cart_link']"));


  public ProductsMainPage() {
    super();
  }

  public WebElement getRemoveFromCartOnesie() {
    return this.removeFromCartOnesie;
  }

  public WebElement getRemoveFromCartBackpack() {
    return this.removeFromCartBackpack;
  }

  public AbstractPage addCheapestAndSecondCostliestProductsToCart() {
    if(selectSort.isDisplayed()) {
      selectSort.click();
      optionHighToLow.click();
      addToCartOnesie.click();
      addToCartBackpack.click();
      shoppingCartButton.click();
    }
    else
      throw new NotFoundException("Element cannot be located");
    return new UserCartPage();
  }
}
