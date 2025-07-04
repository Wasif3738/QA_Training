package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ArticlePage extends Form {
    private final IComboBox toolsBlock = getElementFactory()
            .getComboBox(By.id("vector-page-tools-dropdown"), "Tools Menu");
    private final IButton pageInfoLink = getElementFactory()
            .getButton(By.id("t-info"), "Page Info");
    private final IButton downloadAsPdfButton = getElementFactory()
            .getButton(By.id("coll-download-as-rl"), "Download PDF");
    private final ILabel articleTitle = getElementFactory()
            .getLabel(By.id("firstHeading"), "Article Title");

    public ArticlePage() {
        super(By.id("mw-panel-toc-list"), "Article Page");
    }

    @Step("Click on menu Tools")
    public void openToolsMenu() {
        toolsBlock.state().waitForDisplayed();
        toolsBlock.click();
    }

    @Step("Select menu option: Page Information")
    public void clickPageInformation() {
        pageInfoLink.click();
    }

    @Step("Select menu option: Download as PDF")
    public void clickDownloadPdf() {
        downloadAsPdfButton.click();
    }

    @Step("Get article title text")
    public String getArticleTitleText() {
        articleTitle.state().waitForDisplayed();
        return articleTitle.getText().trim();
    }
}
