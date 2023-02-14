//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public @interface BeforeTest {
//
//}
//
//@Test(priority=2)
// public void testInvalidLoginEmail() {
//     // Enter the email and password
//     driver.findElement(By.name("username")).clear();
//     driver.findElement(By.name("password")).clear();
//     driver.findElement(By.name("username")).sendKeys("invaliduseer@email.com");
//     driver.findElement(By.name("password")).sendKeys("invaliddpassword");
//
//     // Click on the login button
//     driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//     // Verify that the user is not logged in
//     String actualUrl = driver.getCurrentUrl();
//     String expectedUrl = LOGIN_URL;
//     Assert.assertEquals(actualUrl, expectedUrl, "Invalid login should not be successful");
// }
//
//
//@Test(priority=3)
//public void testInvalidLogin() {
// // Enter the email and password
// driver.findElement(By.name("username")).clear();
// driver.findElement(By.name("password")).clear();
// driver.findElement(By.name("username")).sendKeys("invaliduser@email.com");
// driver.findElement(By.name("password")).sendKeys("invalidpassword");
//
// // Click on the login button
// driver.findElement(By.xpath("//button[@type='submit']")).click();
//
// // Assert error message
// boolean errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();
//Assert.assertTrue(errorMessage,"Invalid login should not be successful");
//}