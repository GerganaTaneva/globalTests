import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

  private WebElement username = driver.findElement(By.id("user-name"));

  private WebElement password = driver.findElement(By.id("password"));

  private WebElement loginButton = driver.findElement(By.id("login-button"));

  LoginPage() {
    super();

  }

  public AbstractPage login(User user) {
    if(username.isEnabled() && password.isEnabled() && loginButton.isEnabled()) {
      username.sendKeys(user.getUsername());
      password.sendKeys(user.getPassword());
      loginButton.click();
    }
    else
      throw new NotFoundException("Elements are not located");
    return new ProductsMainPage();
  }
}
