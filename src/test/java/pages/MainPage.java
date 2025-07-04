package pages;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class MainPage extends Form {
    private final IButton consentBtn = getElementFactory()
            .getButton(By.xpath("//div[contains(@class,'policy-accept')]"), "Consent");
    private final ITextBox searchBox = getElementFactory()
            .getTextBox(By.xpath("//input[@name='query']"), "Search Box");
    private final ILabel searchResultsContainer = getElementFactory()
            .getLabel(By.xpath("//div[contains(@class,'results-container')]"), "Search Results Container");
    private final By searchResultLocator =
            By.cssSelector("div[class*='search-bar-result']");
    private final IButton headerMenu = getElementFactory()
            .getButton(By.xpath("//*[@data-qa='navigationMenu']"), "Menu");
    private final ILink settingsLink = getElementFactory()
            .getLink(By.xpath("//a[contains(@href,'/settings')]"), "Settings");
    private final ILabel  temperatureUnitLabel = getElementFactory()
            .getLabel(By.className("recent-location-temp-unit"), "Temperature Unit");


    public MainPage() {
        super(By.cssSelector("div.basic-header.is-hero.is-at-top"), "AccuWeather Home");
    }

    public void acceptConsent() {
        consentBtn.state().waitForDisplayed();
        consentBtn.click();
    }

    public void searchCity(String city) {
        searchBox.clearAndType(city);
    }

    public boolean isSearchResultVisible() {
        return searchResultsContainer.state().waitForDisplayed();
    }

    private List<ILabel> getSearchResults() {
        return getElementFactory().findElements(searchResultLocator, ILabel.class);
    }

    public void clickResultByIndex(int index) {
        List<ILabel> searchResults = getSearchResults();
        if (searchResults.isEmpty()) {
            throw new RuntimeException("No search results available");
        }
        if (index < 0 || index >= searchResults.size()) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for list size %d", index, searchResults.size())
            );
        }
        searchResults.get(index).click();
    }

    public void openSettings() {
        headerMenu.click();
        settingsLink.click();
    }

    public String getTemperatureUnitSymbol() {
        return temperatureUnitLabel.getText().trim();
    }
}
