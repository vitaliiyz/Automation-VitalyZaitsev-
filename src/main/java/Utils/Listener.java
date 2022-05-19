package Utils;


import BaseObjects.DriverCreation;
import Configuration.PropertyReader;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.util.Properties;

public class Listener implements ITestListener {
    private static ITestContext context;
    private static Properties properties;

    @Override
    public void onStart(ITestContext context) {
        DriverCreation.createDriver();
        Listener.context = context;
        new PropertyReader(context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config"));
        properties = PropertyReader.getProperties();
    }

    public static ITestContext getContext() {
        return context;
    }

}