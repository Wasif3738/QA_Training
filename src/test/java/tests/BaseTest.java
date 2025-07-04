package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.EnvDataReader;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static org.testng.Assert.assertEquals;

public abstract class BaseTest {

    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(EnvDataReader.getEnvData().getUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }


    @Test(dataProvider = "additionData", dataProviderClass = Addition.class)
    public void testAddition (int a, int b, int expectedSum) {
        int totalSum = a + b;
        assertEquals(totalSum, expectedSum, "addition didnt work");
    }
}
