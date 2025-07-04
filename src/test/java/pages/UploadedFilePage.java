package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;


public class UploadedFilePage extends Form {
    private static final String NAME = "File Uploaded!";
    private final By UPLOADED_FILE = By.id("uploaded-files");

private final ILabel uploadedFileLbl= AqualityServices.getElementFactory().getLabel(UPLOADED_FILE,"File name");
    public UploadedFilePage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    public String getUploadedFileName() {
        return uploadedFileLbl.getText();
    }
}