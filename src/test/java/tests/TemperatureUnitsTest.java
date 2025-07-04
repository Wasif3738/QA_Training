package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SettingsPage;
import constants.TemperatureUnit;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TemperatureUnitsTest extends BaseTest {

    @Test
    public void testChangeTemperatureUnits() {
        MainPage homePage = new MainPage();
        homePage.acceptConsent();

        Assert.assertEquals(
                homePage.getTemperatureUnitSymbol(),
                TemperatureUnit.CELSIUS.getSymbol(),
                String.format("Expected unit to be '%s' but got '%s'", TemperatureUnit.CELSIUS.getSymbol(), homePage.getTemperatureUnitSymbol())
        );

        homePage.openSettings();

        SettingsPage settingsPage = new SettingsPage();
        Assert.assertTrue(settingsPage.state().isDisplayed(), "Settings page not displayed");
        settingsPage.selectTemperatureUnit(TemperatureUnit.FAHRENHEIT);

        getBrowser().goBack();

        Assert.assertEquals(
                homePage.getTemperatureUnitSymbol(),
                TemperatureUnit.FAHRENHEIT.getSymbol(),
                String.format("Expected unit to be '%s' but got '%s'", TemperatureUnit.FAHRENHEIT.getSymbol(), homePage.getTemperatureUnitSymbol())
        );
    }
}
