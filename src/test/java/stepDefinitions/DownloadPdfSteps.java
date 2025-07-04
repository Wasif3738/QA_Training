package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PdfDownloadPage;
import utils.FileUtils;

public class DownloadPdfSteps {
    private final PdfDownloadPage pdfDownloadPage = new PdfDownloadPage();

    @When("I click the Download button")
    public void clickDownloadButton() {
        pdfDownloadPage.clickDownloadButton();
    }

    @Then("The PDF file is downloaded successfully")
    public void verifyPdfDownload() {
        String expectedFileName = pdfDownloadPage.getFileName();
        boolean isDownloaded = FileUtils.isFileDownloaded(expectedFileName);

        Assert.assertTrue(isDownloaded, "Downloaded file is missing.");
    }

    @Given("^I have (\\d+) apples$")
    public void iHaveApples(int numberOfApples) {
        System.out.printf("I have %d apples%n", numberOfApples);
    }

    @When("I greet the user")
    public void greetUser() {
        String name = System.getProperty("name");
        System.out.printf("Hello, %s%n", name);
    }
}
