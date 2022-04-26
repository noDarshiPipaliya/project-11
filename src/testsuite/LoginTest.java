package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        String expectedMessage = "Welcome Back!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to  area ", expectedMessage, actualMessage);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        sendTextToElement(By.id("user[email]"), "Devanshi@gmail.com");
        sendTextToElement(By.id("user[password]"), "1234");

        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        String expectedMessage = "Invalid email or password.";
        WebElement actualMessageelement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to  area ", expectedMessage, actualMessage);
    }
}
