package tests;

import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DownloadTest extends BaseTest {

    private final By languageDropdown = By.id("searchLanguage");
    private final By searchInput = By.id("searchInput");
    private final By searchButton = By.cssSelector("button[type='submit']");
    private final By toolsButton = By.id("vector-page-tools-dropdown");
    private final By downloadPdfOption = By.xpath("//li[@id='coll-download-as-rl']");
    private final By fileNameElement = By.cssSelector(".mw-electronpdfservice-selection-label-desc");
    private final By finalDownloadButton = By.cssSelector("button[type='submit']");

    private File downloadedFile;
    private final String languageValue = "en";
    private final String searchQuery = "Albert Einstein";

    @Test
    public void wikipediaDownloadTest() {
        WebElement mainPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        Assert.assertTrue(mainPageElement.isDisplayed(), "Main page is not displayed.");

        WebElement langDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(languageDropdown));
        new Select(langDropdown).selectByValue(languageValue);

        WebElement searchInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        searchInputElement.sendKeys(searchQuery);
        driver.findElement(searchButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(toolsButton)).click();
        driver.findElement(downloadPdfOption).click();

        String fileName = wait.until(ExpectedConditions.visibilityOfElementLocated(fileNameElement))
                .getText().trim();
        downloadedFile = new File(ABSOLUTE_RESOURCE_PATH + File.separator + fileName);
        driver.findElement(finalDownloadButton).click();

        Assert.assertTrue(isFileExists(downloadedFile), "File is not downloaded");
    }

    private boolean isFileExists(File file){
        try{
            Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        }
        catch (ConditionTimeoutException exception){
            return false;
        }
        return true;
    }

    @AfterMethod
    public void deleteFile() {
        if (downloadedFile.exists()) {
            downloadedFile.delete();
        }
    }
}
