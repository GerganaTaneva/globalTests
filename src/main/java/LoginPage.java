import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

  private WebElement username;
  private WebElement password;
  private WebElement loginButton;

  LoginPage(WebDriver driver) {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
  }

  public ProductsMainPage login(User user, WebDriver driver) {
    username = driver.findElement(By.id("user-name"));
    password = driver.findElement(By.id("password"));
    loginButton = driver.findElement(By.id("login-button"));

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
