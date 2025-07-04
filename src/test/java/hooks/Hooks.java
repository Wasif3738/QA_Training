package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.EnvDataReader;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class Hooks {

    @Before
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(EnvDataReader.getEnvData().getUrl());
    }

    @After
    public void teardown() {
        getBrowser().quit();
    }
}
