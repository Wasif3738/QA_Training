package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SteamPage extends Form {
    private final IButton aboutTab = getElementFactory()
            .getButton(By.cssSelector("#global_header .supernav_container a[href*=about]"), "About Tab");

    public SteamPage() {
        super(By.xpath("//div[@id='responsive_store_nav_ctn']"), "Steam Page");
    }

    public boolean isAboutPageDisplayed() {
        return aboutTab.state().isDisplayed();
    }

    public void clickAboutTab() {
        aboutTab.click();
    }
}
