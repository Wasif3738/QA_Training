package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.EnvDataReader;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {

    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(EnvDataReader.getEnvData().getAccuWeatherUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
