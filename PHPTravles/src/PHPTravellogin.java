import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//public class PHPTravel {
//	public static void main(String args[])
//	{
//		System.setProperty(
//			"webdriver.chrome.driver",
//			"C:\\Users\\Silpa\\Documents\\PHPTravels-Chromedriver\\chromedriver.exe");
//		// Instantiate a ChromeDriver class.
//		WebDriver driver = new ChromeDriver();
//
//		// Maximize the browser
//		driver.manage().window().maximize();
//
//		// Launch Website
//		driver.get("https://phptravels.com/");
//	}
//}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PHPTravellogin {

    private WebDriver driver;
    private final String LOGIN_URL = "https://phptravels.net/login";
    private final String DASHBOARD_URL = "https://phptravels.net/account/dashboard"
    		+ "";
    private final String EMAIL = "user@phptravels.com";
    private final String PASSWORD = "demouser";
    private final String LOGOUT_URL = "https://phptravels.net/account/logout"+ "";
    private final String MY_PROFILE_URL = "https://phptravels.net/account/profile"+ "";
    private final String ADD_FUNDS_URL = "https://phptravels.net/account/add_funds"+ "";
    private final String MY_BOOKING_URL = "https://phptravels.net/account/bookings"+ "";
    private final String BOOKING_VOUCHER_URL = "https://phptravels.net/hotels/booking/invoice"+ "";
    private final String PAYPAL_URL = "https://www.paypal.com/";

    @BeforeTest
    public void setUp() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Silpa\\Documents\\PHPTravels-Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        // Open the login page
        driver.get(LOGIN_URL);
    }

    @Test(priority=1)
    public void testValidLogin() {
    	
        // Enter the email and password
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        // Click on the login button
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect' and @type='submit']")).click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().window().maximize();
        // Verify that the user is logged in
       String actualUrl = driver.getCurrentUrl();
      // System.out.println(actualUrl);
       //driver.quit();
        String expectedUrl = DASHBOARD_URL;
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed");
    }
  //import org.openqa.selenium.By;
  //import org.testng.Assert;
  //import org.testng.annotations.Test;
  //
  //public @interface BeforeTest {
  //
  //}
  //
  @Test(priority=2)
   public void testInvalidLoginEmail() {
       // Enter the email and password
       driver.findElement(By.name("username")).clear();
       driver.findElement(By.name("password")).clear();
       driver.findElement(By.name("username")).sendKeys("invaliduseer@email.com");
       driver.findElement(By.name("password")).sendKeys("invaliddpassword");
  
       // Click on the login button
       driver.findElement(By.xpath("//button[@type='submit']")).click();
  
       // Verify that the user is not logged in
       String actualUrl = driver.getCurrentUrl();
       String expectedUrl = LOGIN_URL;
       Assert.assertEquals(actualUrl, expectedUrl, "Invalid login should not be successful");
   }
  
  
  @Test(priority=3)
  public void testInvalidLogin() {
   // Enter the email and password
   driver.findElement(By.name("username")).clear();
   driver.findElement(By.name("password")).clear();
   driver.findElement(By.name("username")).sendKeys("invaliduser@email.com");
   driver.findElement(By.name("password")).sendKeys("invalidpassword");
  
   // Click on the login button
   driver.findElement(By.xpath("//button[@type='submit']")).click();
  
   // Assert error message
   boolean errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();
  Assert.assertTrue(errorMessage,"Invalid login should not be successful");
  }
@Test(priority=4)
public void testMyBookingLink() {
    // Click on the My Booking link
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	// driver.findElement(By.linkText("//a[@href='https://phptravels.net/account/bookings']")).click();
	//driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/ul/li[2]/a")).click();
	 driver.findElement(By.xpath("//a[@class='waves-effect' and contains(text(),'My Bookings')]")).click();
	 //driver.findElement(By.className("la la-shopping-cart mr-2 text-color-3")).click();
	
    // Verify that the user is on the My Booking page
    String actualUrl = driver.getCurrentUrl();
    
    String expectedUrl = MY_BOOKING_URL;
//    System.out.println(actualUrl);
//    System.out.println(expectedUrl);
//    driver.quit();
//    WebElement viewVoucherButton = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/div/table/tbody/tr[1]/td[4]/div/a"));
//    viewVoucherButton.click();
    Assert.assertEquals(actualUrl, expectedUrl, "My Booking link is not working");
    
}

@Test(priority=5)
public void testAddFundsLink() {
    // Click on the Add Funds link
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/ul/li[3]/a")).click();
    //driver.findElement(By.xpath("//a[@href='https://phptravels.net/account/add_funds']")).click();
    driver.findElement(By.cssSelector("a[href='https://phptravels.net/account/add_funds']"));
    // Verify that the user is on the Add Funds page
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = ADD_FUNDS_URL;
    Assert.assertEquals(actualUrl, expectedUrl, "Add Funds link is not working");
}

@Test(priority=6)
public void testMyProfileLink() {
    // Click on the My Profile link
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/ul/li[4]/a")).click();

    // Verify that the user is on the My Profile page
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = MY_PROFILE_URL;
    Assert.assertEquals(actualUrl, expectedUrl, "My Profile link is not working");
}


@Test(priority=7)
public void viewVoucher() {
	WebElement viewVoucherButton = driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/div/table/tbody/tr[1]/td[4]/div/a"));
    viewVoucherButton.click();
}
@Test(priority=8)
public void testPayPalPayment() {
    // Navigate to the PayPal website
   // driver.get(PAYPAL_URL);

    // Fill in the necessary information for the payment
    // ...

    // Click on the Pay button
    // ...

    // Verify that the payment was successful
    // ...
}

@Test(priority=9)
public void testBookingVoucher() {
    // Navigate to the My Booking page
    //driver.get(BOOKING_VOUCHER_URL);

    // Find the booking details and retrieve the voucher number
    //

}
@Test(priority=10)
public void testLogoutLink() {
    // Click on the Logout link
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    //driver.findElement(By.xpath("//a[@href='/account/logout']")).click();
	driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/ul/li[5]/a")).click();
	//driver.findElement(By.xpath("//a[contains(@href, 'https://phptravels.net/account/logout')]")).click();
	//driver.findElement(By.cssSelector("a[href*='https://phptravels.net/account/logout']")).click();
	

    // Verify that the user is logged out
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = LOGIN_URL;
    Assert.assertEquals(actualUrl, expectedUrl, "Logout link is not working");
}
}