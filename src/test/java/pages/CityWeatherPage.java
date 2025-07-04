package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CityWeatherPage extends Form {
    private final ILabel cityHeader = getElementFactory()
            .getLabel(By.xpath("//h1[contains(@class,'header-loc')]"), "City Name");

    public CityWeatherPage() {
        super(By.xpath("//a[starts-with(@class,'cur-con-weather-card')]"), "City Page");
    }

    public String getHeaderCity() {
        return cityHeader.getText();
    }
}
