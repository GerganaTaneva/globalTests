import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractPage {

  protected WebDriver driver = new ChromeDriver();

  public AbstractPage() {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
  }
}
