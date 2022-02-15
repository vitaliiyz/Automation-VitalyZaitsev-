package Lecture_8;

import BaseObjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Homework_8 extends BaseTest {

    @Test(enabled = false)
    public void htmlFileTest() {
        driver.get("C:\\Users\\abookBY\\IdeaProjects\\AutomationVitalyZaitsev\\src\\test\\java\\Lecture_8\\Index.html");
        //Elements
        List<WebElement> firstColumn = driver.findElements(By.xpath("//tr/td[1]"));
        WebElement input = driver.findElement(By.id("fname"));
        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        Select select = new Select(driver.findElement(By.tagName("select")));
        WebElement button = driver.findElement(By.tagName("button"));
        WebElement image = driver.findElement(By.tagName("img"));
        WebElement paragraph = driver.findElement(By.tagName("p"));
        WebElement link = driver.findElement(By.linkText("Visit W3Schools.com!"));
        //Actions
        input.sendKeys("Vitaly");
        checkbox.click();
        select.selectByValue("opel");
        button.click();
        Assert.assertTrue(image.isDisplayed());
        Assert.assertEquals(paragraph.getText(), "This is some text in a paragraph.");
        link.click();
        String newPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(newPageUrl, "https://www.w3schools.com/");
    }

    @Test
    public void tableTest() {
        driver.get("C:\\Users\\abookBY\\IdeaProjects\\AutomationVitalyZaitsev\\src\\test\\java\\Lecture_8\\Index.html");

        List<String> rows = driver.findElements(By.tagName("tr")).stream().map(WebElement::getText).collect(Collectors.toList());

        List<List<String>> tableData = new ArrayList<List<String>>();

        for (int i = 0; i < rows.size(); i++) {
            List<String> cell = driver.findElements(By.xpath("//tr[" + (i + 1) + "]/*")).stream().map(WebElement::getText).collect(Collectors.toList());
            tableData.add(cell);
        }
        System.out.println(tableData);
    }
}
