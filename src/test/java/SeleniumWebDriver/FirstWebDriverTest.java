package SeleniumWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;


public class FirstWebDriverTest {
    @Test
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver dr = new ChromeDriver();

        //Open the page
        System.out.println("Open the page");
        dr.get("http://training.skillo-bg.com:4200/posts/all");
        dr.manage().window().maximize();

        //Navigate to the login page
        System.out.println("Navigate to the login page");
        WebElement loginLink = dr.findElement(By.id("nav-link-login"));
        loginLink.click();
        Thread.sleep(2000);

        //Enter username
        System.out.println("Enter username");
        WebElement username = dr.findElement(By.id("defaultLoginFormUsername"));
        username.click();
        username.sendKeys("lyudmil1207");
        Thread.sleep(2000);

        //Enter password
        System.out.println("Enter password");
        WebElement password = dr.findElement(By.id("defaultLoginFormPassword"));
        password.click();
        password.sendKeys("123123");
        Thread.sleep(2000);

        //Click on the Sign In button
        System.out.println("Click on the Sign In button");
        WebElement loginButton = dr.findElement(By.id("sign-in-button"));
        loginButton.click();
        Thread.sleep(1000);

        //Check if the user has successfully logged in
        System.out.println("Check if the user has successfully logged in");
        WebElement successfulLogin = dr.findElement(By.xpath("//*[contains(text(), 'Successful login!')]"));

        if (successfulLogin.isDisplayed()) {
            System.out.println("Continue to post page");
        } else {
            System.out.println("The login was unsuccessful");
            dr.close();
        }
        Thread.sleep(1000);

        //Navigate to new post page
        System.out.println("Navigate to new post page");
        WebElement newPost = dr.findElement(By.id("nav-link-new-post"));
        newPost.click();
        Thread.sleep(2000);

        //Select the file you want to upload
        System.out.println("Select the file you want to upload");
        WebElement browseButton = dr.findElement(By.className("file"));
        browseButton.sendKeys("C:\\Users\\Lyudmil\\Desktop\\Newfolder\\javaAutomation.jpg");
        Thread.sleep(2000);

        //Enter a caption
        System.out.println("Enter a caption");
        WebElement caption = dr.findElement(By.name("caption"));
        caption.click();
        caption.sendKeys("Naj-posle se kachi");
        Thread.sleep(3000);

        //Create the new post
        System.out.println("Create the new post");
        WebElement submitButton = dr.findElement(By.id("create-post"));
        submitButton.click();
        Thread.sleep(3000);

        //Check if the post was successfully created
        System.out.println("Check if the post was successfully created");
        WebElement postCreated = dr.findElement(By.xpath("//*[contains(text(), 'Post created!')]"));

        if (postCreated.isDisplayed()) {
            System.out.println("Continue to profile page");
        } else {
            System.out.println("The upload was unsuccessful");
            dr.close();
        }
        Thread.sleep(1000);


        //If the pic is uploaded I should be redirected to my profile
        System.out.println("If the pic is uploaded I should be redirected to my profile");
        WebElement profilePicture = dr.findElement(By.className("profile-image-source"));

        if (profilePicture.isDisplayed()) {
            System.out.println("The user was redirected to profile page");
        } else {
            System.out.println("No posts were created!");
        }
            dr.close();

    }
}
