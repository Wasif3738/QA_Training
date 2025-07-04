package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DynamicControlsPage extends Form {

    private static final String NAME = "Dynamic Controls";
    private final IElementFactory elementFactory= AqualityServices.getElementFactory();
    private final By ENABLE =By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH,"Enable"));
    private final By INPUT = By.xpath("//input[@type='text']");
    private final IButton enableBtn= elementFactory.getButton(ENABLE, "Status enable");
    private final ITextBox textField= elementFactory.getTextBox(INPUT, "Input field");

    public DynamicControlsPage(){
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH,NAME)), NAME);
    }

    @Step("Click the Enable button")
    public void clickEnableBtn() {
        enableBtn.click();
    }

    @Step("Check if the input field is enabled")
    public boolean isInputEnabled() {
        return textField.state().waitForEnabled();
    }

    @Step("Input text: {text}")
    public void inputText(String text) {
        textField.clearAndType(text);
    }

    @Step("Get the current value of the input field")
    public String getInputTextValue() {
        return textField.getValue();
    }
}
