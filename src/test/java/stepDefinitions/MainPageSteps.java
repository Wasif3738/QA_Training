package stepDefinitions;

import constants.Languages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage();

    @Then("The main page is displayed")
    public void openWikipediaMainPage() {
        step("I open the main page");
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Wikipedia main page was not displayed");
    }

    @When("I search for {string}")
    public void searchForArticle(String query) {
        mainPage.search(query);
    }

    @When("I change the search language to {string}")
    public void changeSearchLanguage(String language) {
        Languages langEnum = Languages.valueOf(language.toUpperCase());
        mainPage.changeLanguage(langEnum);
    }

    @When("I click the search button")
    public void clickSearchButton() {
        mainPage.clickSearchButton();
    }
}
