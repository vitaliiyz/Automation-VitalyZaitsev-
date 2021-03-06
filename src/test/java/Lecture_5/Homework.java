package Lecture_5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "data")
    public void smokeTest(String roomLth, String roomWth, String laminateLth, String laminateWth,
                          String inPkg, String prc, int selectDrctn, String shftngRows,
                          String wallDstnc, List<String> expectedData) {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        //WebElements
        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        WebElement laminateLength = driver.findElement(By.name("calc_lamwidth"));
        WebElement laminateWidth = driver.findElement(By.name("calc_lamheight"));
        WebElement inPackage = driver.findElement(By.name("calc_inpack"));
        WebElement price = driver.findElement(By.name("calc_price"));
        WebElement direction = driver.findElement(By.name("calc_direct"));
        Select selectDirection = new Select(direction);
        WebElement shiftingRows = driver.findElement(By.name("calc_bias"));
        WebElement wallDistance = driver.findElement(By.name("calc_walldist"));
        WebElement calcBtn = driver.findElement(By.cssSelector("div.calc .btn-lg"));
        List<WebElement> calcResults = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 whiteback']//div[@class='form_element']"));
        //Actions
        roomLength.sendKeys(Keys.chord(Keys.CONTROL, "a"), roomLth);
        roomWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), roomWth);
        laminateLength.sendKeys(Keys.chord(Keys.CONTROL, "a"), laminateLth);
        laminateWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), laminateWth);
        inPackage.sendKeys(Keys.chord(Keys.CONTROL, "a"), inPkg);
        price.sendKeys(Keys.chord(Keys.CONTROL, "a"), prc);
        selectDirection.selectByIndex(selectDrctn);
        shiftingRows.sendKeys(Keys.chord(Keys.CONTROL, "a"), shftngRows);
        wallDistance.sendKeys(Keys.chord(Keys.CONTROL, "a"), wallDstnc);
        calcBtn.click();
        //Results
        List<String> actualData = new ArrayList<>() {{
            calcResults.forEach((element) -> add(element.getText()));
        }};
        Assert.assertEquals(actualData, expectedData);
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"5", "4", "1000", "150", "10", "400", 0, "200", "5", new ArrayList<String>() {{
                    add("?????????????? ??????????????: 19.91 ??2.");
                    add("??????-???? ??????????????: 137 ????.");
                    add("??????-???? ????????????????: 14 ????.");
                    add("??????????????????: 8400 ??????.");
                    add("??????????????: 3 ????.");
                    add("??????????????: 10 ????.");
                }}},
                {"10", "7", "1500", "200", "30", "1000", 1, "500", "20", new ArrayList<String>() {{
                    add("?????????????? ??????????????: 69.32 ??2.");
                    add("??????-???? ??????????????: 234 ????.");
                    add("??????-???? ????????????????: 8 ????.");
                    add("??????????????????: 72000 ??????.");
                    add("??????????????: 6 ????.");
                    add("??????????????: 19 ????.");
                }}},
                {"1", "1", "100", "100", "3", "100", 0, "10", "2", new ArrayList<String>() {{
                    add("?????????????? ??????????????: 0.99 ??2.");
                    add("??????-???? ??????????????: 100 ????.");
                    add("??????-???? ????????????????: 34 ????.");
                    add("??????????????????: 102 ??????.");
                    add("??????????????: 2 ????.");
                    add("??????????????: 8 ????.");
                }}}
        };
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
