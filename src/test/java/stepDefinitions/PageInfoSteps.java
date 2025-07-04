package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.InfoPage;

public class PageInfoSteps {
    private final InfoPage infoPage = new InfoPage();

    @Then("The information page for {string} is displayed")
    public void isInformationPageDisplayed(String articleName) {
        String actualTitle = infoPage.getTitleText();
        Assert.assertTrue(actualTitle.contains(articleName), "Page title does not match expected article");
    }
}
