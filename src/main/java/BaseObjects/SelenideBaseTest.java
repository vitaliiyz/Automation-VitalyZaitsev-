package BaseObjects;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class SelenideBaseTest {

    protected ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
    }

    protected <T> T getPage(Class<T> pageClass) {
        return driver().hasWebDriverStarted() ? page(pageClass) : open(context.getSuite().getParameter("url"), pageClass);
    }
}
