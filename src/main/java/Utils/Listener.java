package Utils;

import Configuration.PropertyReader;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.util.Properties;

public class Listener implements ITestListener {
    private static ITestContext context;

    @Override
    public void onStart(ITestContext context) {
        Listener.context = context;
        new PropertyReader(context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config"));
        Properties properties = PropertyReader.getProperties();
    }

    public static ITestContext getContext() {
        return context;
    }
}
