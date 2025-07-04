package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InfoPage extends Form {

    private final ILabel titleLabel = getElementFactory().getLabel(By.id("firstHeading"), "Page Title");

    public InfoPage() {
        super(By.id("mw-pageinfo-display-title"), "page information");
    }

    @Step("Verify information page title")
    public String getTitleText() {
        titleLabel.state().waitForDisplayed();
        return titleLabel.getText().trim();
    }
}
