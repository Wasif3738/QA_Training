package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private final By fileUpload = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));
    private final By chooseFile = By.id("file-upload");
    private final By fileSubmit = By.id("file-submit");
    private final By uploadedFile = By.id("uploaded-files");
    private final String fileName = "file.json";
    private final String filePath = RELATIVE_RESOURCE_PATH + fileName;


    @Test
    public void fileUploadTest() {
        driver.findElement(fileUpload).click();
        File fileToUpload = new File(filePath);
        driver.findElement(chooseFile).sendKeys(fileToUpload.getAbsolutePath());
        driver.findElement(fileSubmit).click();
        Assert.assertEquals(driver.findElement(uploadedFile).getText(), fileName, "File name is incorrect or missing");
    }
}
