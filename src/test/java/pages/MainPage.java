package pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.Languages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final ITextBox searchBox = getElementFactory()
            .getTextBox(By.id("searchInput"), "Search box");
    private final IButton searchButton = getElementFactory()
            .getButton(By.xpath("//button[@type='submit']"), "Search button");
    private final IComboBox languageSelect = getElementFactory()
            .getComboBox(By.id("searchLanguage"), "Language dropdown", ElementState.EXISTS_IN_ANY_STATE);

    public MainPage() {
        super(By.id("www-wikipedia-org"), "Main Page");
    }

    @Step("Search for article: {query}")
    public void search(String query) {
        searchBox.clearAndType(query);
    }

    @Step("Click the search button")
    public void clickSearchButton() {
        searchButton.state().waitForDisplayed();
        searchButton.click();
    }

    @Step("Change the search language to: {language}")
    public void changeLanguage(Languages language) {
        languageSelect.state().waitForExist();
        languageSelect.selectByValue(language.getCode());
    }
}
