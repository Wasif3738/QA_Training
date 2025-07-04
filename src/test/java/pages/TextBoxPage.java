package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TextBoxPage extends Form {

    private final ITextBox nameInput = getElementFactory()
            .getTextBox(By.id("userName"), "Full Name");
    private final ITextBox emailInput = getElementFactory()
            .getTextBox(By.id("userEmail"), "Email");
    private final IButton submitButton = getElementFactory()
            .getButton(By.id("submit"), "Submit");
    private final ILabel outputBlock = getElementFactory()
            .getLabel(By.id("output"), "Output Block");

    public TextBoxPage() {
        super(By.className("text-field-container"), "Text Box Form");
    }

    public void enterFullName(String fullName) {
        nameInput.clearAndType(fullName);
    }

    public void enterEmail(String email) {
        emailInput.clearAndType(email);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isOutputDisplayed() {
        return outputBlock.state().waitForDisplayed();
    }

    public String getOutputText() {
        return outputBlock.getText();
    }
}
