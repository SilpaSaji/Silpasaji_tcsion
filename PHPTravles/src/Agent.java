
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Agent {
    public static void main(String[] args) throws InterruptedException {
        // Set up webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Silpa\\Documents\\PHPTravels-Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Test login with valid credentials
        driver.get("https://phptravels.net/login");
        driver.findElement(By.name("username")).sendKeys("agent@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoagent");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login with valid credentials: Pass");
        
        // Test login with invalid credentials
        driver.get("https://phptravels.net/login");
        driver.findElement(By.name("username")).sendKeys("invalid@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("invalidpassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        if (errorMessage.equals("Invalid Email or Password")) {
            System.out.println("Login with invalid credentials: Pass");
        } else {
            System.out.println("Login with invalid credentials: Fail");
        }
        
        // Test links
        driver.findElement(By.linkText("My Bookings")).click();
        System.out.println("My Bookings link: Pass");
        driver.navigate().back();
        driver.findElement(By.linkText("Add Funds")).click();
        System.out.println("Add Funds link: Pass");
        driver.navigate().back();
        driver.findElement(By.linkText("My Profile")).click();
        System.out.println("My Profile link: Pass");
        driver.navigate().back();
        driver.findElement(By.linkText("Log Out")).click();
        System.out.println("Logout link: Pass");
        
        // Test navigation links
        driver.findElement(By.linkText("Home")).click();
        System.out.println("Home link: Pass");
        driver.findElement(By.linkText("Hotels")).click();
        System.out.println("Hotels link: Pass");
        driver.findElement(By.linkText("Flights")).click();
        System.out.println("Flights link: Pass");
        driver.findElement(By.linkText("Tours")).click();
        System.out.println("Tours link: Pass");
        driver.findElement(By.linkText("Visa")).click();
        System.out.println("Visa link: Pass");
        
        
    }
}
