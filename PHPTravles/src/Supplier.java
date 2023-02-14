import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Supplier {

  public static void login(WebDriver driver, String email, String password) {
    // Code to enter the email and password and submit the login form
  }

  public static boolean verifyLogin(WebDriver driver, String expectedText) {
    WebElement textElement = driver.findElement(By.xpath("//div[text()='" + expectedText + "']"));
    return textElement.isDisplayed();
  }

  public static void changeBookingStatus(WebDriver driver, String status) {
    // Code to change the booking status
  }

  public static boolean verifyCountInDashboard(WebDriver driver, String expectedCount) {
    WebElement countElement = driver.findElement(By.xpath("//div[@class='count']"));
    return countElement.getText().equals(expectedCount);
  }

  public static boolean verifyModule(WebDriver driver, String module) {
    WebElement moduleElement = driver.findElement(By.xpath("//a[contains(text(), '" + module + "')]"));
    return moduleElement.isDisplayed() && moduleElement.isEnabled();
  }

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Silpa\\Documents\\PHPTravels-Chromedriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    String email = "supplier@phptravels.com";
    String password = "demosupplier";
    String expectedText = "Sales Overview & Summary";
    String expectedCount = "1";

    login(driver, email, password);
    if (verifyLogin(driver, expectedText)) {
      System.out.println("Valid login");
    } else {
      System.out.println("Invalid login");
    }

    changeBookingStatus(driver, "Confirmed");
    if (verifyCountInDashboard(driver, expectedCount)) {
      System.out.println("Count in dashboard is correct");
    } else {
      System.out.println("Count in dashboard is incorrect");
    }

    String[] modules = {"Flight", "Visa", "Tours", "Bookings"};
    for (String module : modules) {
      if (verifyModule(driver, module)) {
        System.out.println(module + " is displayed and can be clicked");
      } else {
        System.out.println(module + " is not displayed or not clickable");
      }
    }

    driver.quit();
  }
}
