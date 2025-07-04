package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.SteamPage;
import utils.EnvDataReader;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class SteamTest extends BaseTest {

    private final String URL = EnvDataReader.getEnvData().getSteamUrl();

    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(URL);
    }

    @Test
    public void steamAboutAndPlayers() {
        SteamPage steamPage = new SteamPage();
        steamPage.clickAboutTab();

        Assert.assertTrue(steamPage.isAboutPageDisplayed(), "About page not loaded");

        AboutPage aboutPage = new AboutPage();
        Assert.assertTrue(aboutPage.isInstallSteamButtonDisplayed(), "Install Steam Button is not Displayed.");

        String onlineText = aboutPage.getOnlineNowText();
        String playingText = aboutPage.getPlayingNowText();

        int online = utils.StringUtils.extractLastNumber(onlineText);
        int playing = utils.StringUtils.extractLastNumber(playingText);
        Assert.assertTrue(online > playing, "Online players are not greater than playing now players.");
    }
}
