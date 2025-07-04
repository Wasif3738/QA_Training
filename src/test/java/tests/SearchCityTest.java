package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.CityWeatherPage;

public class SearchCityTest extends BaseTest {

    private static final String CITY = "New York";

    @Test
    public void testSearchCity() {
        MainPage homePage = new MainPage();

        homePage.acceptConsent();
        homePage.searchCity(CITY);

        Assert.assertTrue(homePage.isSearchResultVisible(), "Search result not visible");
        homePage.clickResultByIndex(1);

        CityWeatherPage cityPage = new CityWeatherPage();
        Assert.assertTrue(cityPage.state().waitForDisplayed(), "City weather page not loaded");

        Assert.assertTrue(
                cityPage.getHeaderCity().toLowerCase().contains(CITY.toLowerCase()),
                String.format("City name not found in header: %s", cityPage.getHeaderCity())
        );
    }
}
