package integrationPackage.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
    //Singleton design Pattern
    //private constructor so that no one else can create object of this class
    private ExtentFactory() {

    }

    private static ExtentFactory instance  = new ExtentFactory();

    public static ExtentFactory getInstance() {
        CreateLogger.info("Get instance of Extent Factory");
        return instance;
    }


    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent() {
        CreateLogger.info("Return instance of Extent Test");
        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject) {
        CreateLogger.info("Set instance of Extent Test");
        extent.set(extentTestObject);
    }

    public void removeExtentObject() {
        CreateLogger.info("Remove instance of Extent Object");
        extent.remove();
    }
}
