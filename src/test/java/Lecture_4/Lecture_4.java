package Lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lecture_4 {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    public void searchByText(String text) {
        WebElement searchInput = driver.findElement(By.xpath("//input[@aria-label='Найти']"));

        searchInput.sendKeys(text);

        WebElement searchButton = driver.findElement(By.xpath("//div[@class=\"UUbT9\"]//input[@aria-label=\"Поиск в Google\"]"));

        webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    @Test(priority = 1)
    public void helloWorldSearch() {
        String inputText = "Привет, мир";

        searchByText(inputText);

        WebElement searchField = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        String textInField = searchField.getAttribute("value");

        Assert.assertEquals(textInField, inputText, "Введенный текст поиска не совпадает с результатом в поле!");

        String firstSearchResult = driver.findElement(By.xpath("//div[@class='g']/div/div/div/div/div/div/a/h3")).getText();

        Assert.assertTrue(firstSearchResult.toLowerCase().contains(inputText.toLowerCase()), "Первый результат не соответствует критериям поиска!");
    }

    @Test(priority = 2)
    public void symbolsSearch() {
        String inputText = "*//*";
        String notFoundText = "ничего не найдено";

        searchByText(inputText);

        WebElement heading = driver.findElement(By.xpath("//p[@role='heading']"));
        String headingText = heading.getText();

        Assert.assertTrue(headingText.contains(notFoundText));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
