package pages;

import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import constants.TemperatureUnit;

public class SettingsPage extends Form {
    private final IComboBox unitDropdown = getElementFactory().getComboBox(By.id("unit"), "Unit Dropdown");

    public SettingsPage() {
        super(By.id("unit"), "Settings Page");
    }

    public void selectTemperatureUnit(TemperatureUnit unit) {
        unitDropdown.selectByValue(unit.getSymbol());
    }
}
