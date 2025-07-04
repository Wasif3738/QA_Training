package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TextBoxPage;

import static org.testng.Assert.assertTrue;

public class DemoqaDDTTest extends BaseTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {"Wasif Rahman", "m13rahman@a1qa.com"}
        };
    }

    @Test(dataProvider = "userData")
    public void testDemoqaForm(String fullName, String email) {
        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.clickSubmit();

        assertTrue(textBoxPage.isOutputDisplayed(), "Output is not visible.");
        String output = textBoxPage.getOutputText();
        assertTrue(output.contains(fullName), "Full name not in output");
        assertTrue(output.contains(email), "Email not in output");
    }
}
