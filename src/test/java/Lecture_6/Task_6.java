package Lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Task_6 {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void login() {
        driver.get("https://www.saucedemo.com/");
        //Login credentials
        String usernameValue = "standard_user";
        String passwordValue = "secret_sauce";
        WebElement usernameField = driver.findElement(By.name("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector(".btn_action"));
        //Actions
        usernameField.sendKeys(usernameValue);
        passwordField.sendKeys(passwordValue);
        loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void addProductToCart() {
        login();
        //Elements on the main page
        WebElement productLink = driver.findElement(By.linkText("Sauce Labs Backpack"));
        String productName = driver.findElement(By.className("inventory_item_name")).getText();
        //Go to the product page
        productLink.click();
        //Elements on the product page
        String productNameOnProductPage = driver.findElement(By.xpath("//div[contains(@class, 'name large_size')]")).getText();
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        WebElement cartLink = driver.findElement(By.cssSelector(".shopping_cart_link"));
        String productPrice = driver.findElement(By.cssSelector("[class$=price]")).getText();
        Assert.assertEquals(productNameOnProductPage, productName); //Compare product name on inventory page and product page
        //Actions on the product page
        addToCartBtn.click();
        WebElement removeBtn = driver.findElement(By.cssSelector("button.btn_small"));
        Assert.assertEquals(removeBtn.getText(), "REMOVE");
        //Go to the cart page
        cartLink.click();
        WebElement cartTitle = driver.findElement(By.cssSelector("[class='title']"));
        String productPriceOnCartPage = driver.findElement(By.cssSelector("[class^=inventory_item_p]")).getText();
        WebElement productNameOnCartPage = driver.findElement(By.partialLinkText("Sauce"));
        Assert.assertEquals(cartTitle.getText(),"YOUR CART");
        Assert.assertEquals(productNameOnCartPage.getText(),productName);
        Assert.assertEquals(productPriceOnCartPage, productPrice);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}