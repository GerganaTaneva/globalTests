import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductsMainPage {

  private WebElement selectSortingMethod;
  private WebElement optionHighToLow;
  private WebElement addToCartBackpack;
  private WebElement addToCartOnesie;
  private WebElement addToCartRedTShirt;
  private WebElement addToCartBoltTShirt;
  private WebElement removeFromCartOnesie ;
  private WebElement removeFromCartBackpack;
  private WebElement removeFromCartRedTShirt;
  private WebElement removeFromCartBoltTShirt;
  private WebElement shoppingCartButton;
  private BurgerMenu burgerMenu;

  public WebElement getProducts(WebDriver driver) {
    return driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
  }

  public UserCartPage addCheapestAndSecondCostliestProductsToCart(WebDriver driver) {
    selectSortingMethod = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
    optionHighToLow = driver.findElement(By.xpath("//option[contains(text(),'Price (high to low)')]"));
    shoppingCartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

    if(selectSortingMethod.isDisplayed()) {
      selectSortingMethod.click();
      optionHighToLow.click();

      addToCartBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
      addToCartOnesie = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
      addToCartOnesie.click();
      addToCartBackpack.click();

      removeFromCartOnesie = driver.findElement(By.id("remove-sauce-labs-onesie"));
      removeFromCartBackpack = driver.findElement(By.id("remove-sauce-labs-backpack"));
      Assert.assertTrue(removeFromCartOnesie.isEnabled());
      Assert.assertTrue(removeFromCartBackpack.isEnabled());

      shoppingCartButton.click();
    }
    else
      throw new NotFoundException("Element cannot be located");
    return new UserCartPage();
  }

  public BurgerMenu openMenu(WebDriver driver) {
    WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
    if(menu.isDisplayed()) {
      menu.click();
    }
    return new BurgerMenu();
  }

  public UserCartPage addToCartTShirts(WebDriver driver) {
    this.addToCartRedTShirt = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
    this.addToCartBoltTShirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    shoppingCartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

    if(addToCartRedTShirt.isDisplayed() && shoppingCartButton.isDisplayed() &&
        addToCartBoltTShirt.isDisplayed()) {
      addToCartRedTShirt.click();
      addToCartBoltTShirt.click();

      removeFromCartRedTShirt = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
      removeFromCartBoltTShirt = driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)"));
      Assert.assertTrue(removeFromCartRedTShirt.isEnabled());
      Assert.assertTrue(removeFromCartBoltTShirt.isEnabled());

      shoppingCartButton.click();
    }
    return new UserCartPage();
  }
}
