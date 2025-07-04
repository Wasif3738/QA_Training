package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public abstract class BaseTest {
    protected static final String WIKIPEDIA_URL = "https://www.wikipedia.org/";
    protected static final int MAX_WAIT = 10;
    protected static final String RELATIVE_RESOURCE_PATH = "src/test/resources/";
    protected static final String ABSOLUTE_RESOURCE_PATH = new File(RELATIVE_RESOURCE_PATH).getAbsolutePath();
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", ABSOLUTE_RESOURCE_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(WIKIPEDIA_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
