package SeleniumWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateAccount {
    WebDriver dr = new ChromeDriver();
    @Given("the user is on the register form page")
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        dr.get("http://training.skillo-bg.com:4200/users/register");
        dr.manage().window().maximize();
    }

    @When("the user enters a non existing username")
        public void enterUsername() throws InterruptedException {
        WebElement username = dr.findElement(By.name("username"));
        username.click();
        username.sendKeys("lyudmissl12066");
        Thread.sleep(2000);
    }

    @And("the user enters a non existing email")
    public void enterEmail() throws InterruptedException {
        WebElement email = dr.findElement(By.xpath("//input[@formcontrolname='email']"));
        email.click();
        email.sendKeys("ludmil66@abvssac.bg");
        Thread.sleep(2000);
    }
    @And("enters a password")
    public void enterPassword() throws InterruptedException {
        WebElement password = dr.findElement(By.id("defaultRegisterFormPassword"));
        password.click();
        password.sendKeys("123123");
        Thread.sleep(2000);
    }

    @And("confirms the password")
    public void confirmPassword() throws InterruptedException {
        WebElement confirmpassword = dr.findElement(By.id("defaultRegisterPhonePassword"));
        confirmpassword.click();
        confirmpassword.sendKeys("123123");
        Thread.sleep(2000);
    }

    @And("clicks on the Sign in button")
    public void signIn() throws InterruptedException {
        WebElement login = dr.findElement(By.id("sign-in-button"));
        login.click();
        Thread.sleep(2000);
    }

    @Then("if the user is signed in they should be able to click on the profile link")
    public void profileLink() throws InterruptedException {
        WebElement profile = dr.findElement(By.id("nav-link-profile"));
        profile.click();
        Thread.sleep(2000);
    }
}
