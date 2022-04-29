package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before

    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test

    public void userSholdLoginSuccessfullyWithValidCredentials(){
        // Find log in link  and click on login link

        WebElement emailField = driver.findElement(By.id("txtUsername"));
        emailField.sendKeys("Admin");

        // Find the password field element
        WebElement passwordField = driver.findElement(By.name("txtPassword"));
        passwordField.sendKeys("admin123");

        WebElement loginLink = driver.findElement(By.id("btnLogin"));
        loginLink.click();

        // this is from requirement
        String expectedMessage = "Welcome";

        WebElement actualMessageElement = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
        String actualMessage = actualMessageElement.getText();
        String str = actualMessage.substring(0,7);
       // System.out.println(str);

        // validate actual and expected message
        Assert.assertEquals("Not nevigate to login page", expectedMessage,str);

    }
    @After
    public void tearDown() {

        closeBrowser();
    }
}
