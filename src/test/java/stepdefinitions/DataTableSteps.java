package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DataTablesPage;
import utils.StringUtils;

import static io.qameta.allure.Allure.step;

public class DataTableSteps {
    DataTablesPage dataTablesPage = new DataTablesPage();

    @Then("Sum of the due columns is {double}")
    public void checkSumOfColumns(Double sum) {
        step("Check that sum of the Due columns is " + sum);
        Double actualSum = 0.0;
        for(String due: dataTablesPage.getFirstDueList()) {
            actualSum += StringUtils.getDoubleFromString(due);
        }
        Assert.assertEquals(actualSum, sum, "Sum is not correct");
    }
}
