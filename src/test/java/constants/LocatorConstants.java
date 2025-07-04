package constants;

import lombok.experimental.UtilityClass;

/*
This class is used in the training videos to demonstrate the basics of XPath and how to use String.format().
However, this approach is only suitable for that specific project, as the main page is static (unchanging) and uses a single localization (English).

For future projects (e.g., final tasks), it’s better to avoid this approach.

Elements should be stored in Page Object (PO) classes, and locators for those elements should be declared within the same classes.
There’s no need to store locators in a separate LocatorConstants class unless they are shared across multiple pages or components.

Additionally, locators don’t need to be stored in separate fields unless they are complex or reused multiple times within the class.
You can write complete locators directly in the element constructors. For example:
private final IButton loginButton = getElementFactory().getButton(By.xpath("//your_xpath_here"), "name_of_the_button")

This approach ensures that elements are encapsulated as part of the PO class, which improves maintainability and readability.
 */
@UtilityClass
public class LocatorConstants {
    public static final String PRECISE_TEXT_XPATH = "//*[text()='%s']";
    public final String PARTICULAR_TEXT_XPATH = "//*[contains(text(),'%s')]";
}
