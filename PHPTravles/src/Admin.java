

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admin {
    public static void main(String[] args) throws InterruptedException {
        // Initialize web driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Silpa\\Documents\\PHPTravels-Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to login page
        driver.get("https://www.phptravels.net/admin");

        // Login with valid credentials
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("admin@phptravels.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("demoadmin");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        // Check if login was successful
        WebElement dashboardText = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
        if (dashboardText.isDisplayed()) {
            System.out.println("Login was successful");
        } else {
            System.out.println("Login failed");
        }

        // Test the "Bookings" link
        WebElement bookingsLink = driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/admin/bookings/']"));
        bookingsLink.click();

        // Display invoice for a successful booking
        WebElement invoiceLink = driver.findElement(By.xpath("//a[contains(text(),'Invoice') and @class='btn btn-success btn-xs']"));
        invoiceLink.click();

        // Delete records with a "Cancelled" booking status
        WebElement cancelStatus = driver.findElement(By.xpath("//td[text()='Cancelled']"));
        WebElement cancelButton = cancelStatus.findElement(By.xpath("//a[text()='Cancel']"));
        cancelButton.click();
        driver.switchTo().alert().accept();

        // Change booking status from "Pending" to "Confirmed"
        WebElement pendingStatus = driver.findElement(By.xpath("//td[text()='Pending']"));
        WebElement confirmButton = pendingStatus.findElement(By.xpath("//a[text()='Confirm']"));
        confirmButton.click();

        // Verify count in dashboard
        WebElement confirmedBookingCount = driver.findElement(By.xpath("//span[@class='badge badge-success']"));
        int confirmedCount = Integer.parseInt(confirmedBookingCount.getText());
        if (confirmedCount > 0) {
            System.out.println("Booking status changed to Confirmed, count in dashboard: " + confirmedCount);
        } else {
            System.out.println("Booking status change failed");
        }

        // Check if "Website" link is working
        WebElement websiteLink = driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/']"));
        websiteLink.click();
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals("https://www.phptravels.net/")) {
            System.out.println("Website link redirects to: " + currentURL);
        } else {
            System.out.println("Website link not working");
        }

        // Close the driver
        driver.quit();
    }
}

