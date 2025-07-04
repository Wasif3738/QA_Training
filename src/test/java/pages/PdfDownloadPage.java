package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PdfDownloadPage extends Form {
    private static final By PAGE_LOCATOR = By.cssSelector(".mw-electronpdfservice-selection-label-desc");
    private final ILabel fileNameLink = getElementFactory()
            .getLabel(PAGE_LOCATOR, "PDF File Link");
    private final IButton downloadButton = getElementFactory()
            .getButton(By.cssSelector("button[type='submit']"), "Download PDF Button");

    public PdfDownloadPage() {
        super(PAGE_LOCATOR, "PDF name");
    }

    @Step("Click on download button")
    public void clickDownloadButton() {
        downloadButton.state().waitForDisplayed();
        downloadButton.click();
    }

    @Step("Verify the downloaded file name")
    public String getFileName() {
        fileNameLink.state().waitForDisplayed();
        return fileNameLink.getText().trim();
    }
}
