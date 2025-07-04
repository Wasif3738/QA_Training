package tests;

import org.openqa.selenium.By;
import java.io.File;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.util.concurrent.TimeUnit;

public class FileDownloadTest extends BaseTest {
    private final String FILE_NAME = "test.txt";
    private final By FILE_DOWNLOAD = By.xpath("//a[text()='File Download']");
    private final By FILE_NAME_XPATH = By.xpath("//a[text()='" + FILE_NAME + "']");
    private final String FILE_PATH = RELATIVE_RESOURCE_PATH + FILE_NAME;
    private final File downloadedFile = new File(FILE_PATH);

    @Test
    public void fileDownloadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        Assert.assertTrue(isFileExists(downloadedFile), "File is not downloaded");
        // todo: assert file is downloaded
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

    // todo: delete file
    @AfterMethod
    public void deleteFile() {
        if (downloadedFile.exists()) {
            boolean isDeleted = downloadedFile.delete();
            if (!isDeleted) {
                System.out.println("Warning: Failed to delete the downloaded file.");
            }
        }
    }

}
