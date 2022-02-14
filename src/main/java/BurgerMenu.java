import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerMenu {

  private WebElement logOutButton;

  public LoginPage logout(WebDriver driver) {
    this.logOutButton = driver.findElement(By.id("logout_sidebar_link"));
    if(logOutButton.isDisplayed()) {
      logOutButton.click();
    }
    return new LoginPage(driver);
  }
}
