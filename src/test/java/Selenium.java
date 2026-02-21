import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Selenium {

    @Test
    public void helloJayjay() {
        // inisialisasi browser driver
        WebDriver driver = WebDriverManager.chromedriver().create();

        // navigasi url
        driver.get("https://jayjay.co/");

        // get element attribute
        String text = driver.findElement(By.className("content-info")).getText();

        // assertion / pengecekan
        assertEquals("Belajar dari para ahli terbaik berdasarkan program Eropa", text);
    }


    @Test
    public void locatorTest () {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name"));
        driver.findElement(By.xpath("//*[@id=\"password\"]"));
        driver.findElement(By.id("login-button"));
    }

    @Test
    public void browserMethodTest() {
         WebDriver driver = WebDriverManager.chromedriver().create();
         driver.get("https://www.saucedemo.com/");

         String title = driver.getTitle();
         String currentURL = driver.getCurrentUrl();

         System.out.println("Title pada halaman web" + title);
         System.out.println("Title pada halaman web" + currentURL);

    }

    @Test
    public void sauceDemoTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertEquals("Sauce Labs Backpack", driver.findElement(By.className("inventory_item_name")).getText());

        Thread.sleep(2000);
    }

    @Test
    public void navigationMethodTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.navigate().refresh();
        driver.navigate().to("https://jayjay.co/");

        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Title pada halaman web" + title);
        System.out.println("Title pada halaman web" + currentURL);
    }

    @Test
    public void sauceDemoImplicitWait()  {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    @Test
    public void sauceDemoExplicitWait()  {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#user-name")));
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        driver.findElement(By.id("login-button")).click();

    }

    @Test
    public void sauceDemoFluentWait()  {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(100));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item_name")));

        assertEquals("Sauce Labs Backpack", driver.findElement(By.className("inventory_item_name")).getText());

    }


    //Page Object Model
    @Test
    public void loginTest() {
        // inisialisasi webdriver
        WebDriver driver = WebDriverManager.chromedriver().create();

        // inisialisasi page object
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        // action test
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        // test validation
        homePage.validateBackPackDisplated();


    }
}
