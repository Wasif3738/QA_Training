package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.UploadedFilePage;
import utils.TestDataReader;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private final FileUploadPage fileUploadPage = new FileUploadPage();
    private final UploadedFilePage uploadedFilePage= new UploadedFilePage();
    private final String fileName = TestDataReader.getFileData().getUploadFile();
    private final String filePath = TestDataReader.TEST_DATA_PATH + fileName;

    @Test
    public void fileUploadTest() {
        mainPage.clickNavigationLink(MainPageNavigation.FILE_UPLOAD);
        fileUploadPage.uploadFile(new File(filePath).getAbsolutePath());
        fileUploadPage.clickSubmitBtn();
        Assert.assertEquals(uploadedFilePage.getUploadedFileName(), fileName, "File name is not correct or missed.");
    }
}
