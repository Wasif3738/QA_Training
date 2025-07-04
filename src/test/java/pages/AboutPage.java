package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AboutPage extends Form {
    private final ILabel installSteamButton = getElementFactory()
            .getLabel(By.xpath("//div[@id='about_greeting']//a[@class='about_install_steam_link']"), "Install Steam Button");
    private final ILabel onlineNow = getElementFactory()
            .getLabel(By.xpath("//div[@class='online_stat' and .//div[@class='online_stat_label gamers_online']]"), "Online Now");
    private final ILabel playingNow = getElementFactory()
            .getLabel(By.xpath("//div[@class='online_stat' and .//div[@class='online_stat_label gamers_in_game']]"), "Playing Now");

    public AboutPage() {
        super(By.xpath("//div[@class='online_stats']"), "About Page");
    }

    public boolean isInstallSteamButtonDisplayed() {
        return installSteamButton.state().waitForDisplayed();
    }

    public String getOnlineNowText() {
        return onlineNow.getText();
    }

    public String getPlayingNowText() {
        return playingNow.getText();
    }
}
