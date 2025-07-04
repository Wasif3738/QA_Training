package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ArticlePage;

public class ArticlePageSteps {
    private final ArticlePage articlePage = new ArticlePage();

    @When("I click on the Tools menu")
    public void clickMenu() {
        articlePage.openToolsMenu();
    }

    @When("I select Page Information")
    public void selectPageInfoOption() {
        articlePage.clickPageInformation();
    }

    @When("I select option Download as PDF")
    public void selectDownloadOption() {
        articlePage.clickDownloadPdf();
    }

    @Then("The article page for {string} is displayed")
    public void verifyArticlePageDisplayed(String expectedTitle) {
        String actualTitle = articlePage.getArticleTitleText();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                String.format("The article page for '%s' was not displayed", expectedTitle));
    }
}
