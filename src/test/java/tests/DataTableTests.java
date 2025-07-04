package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataTableTests extends BaseTest {
    private final By sortableDataTables = By.xpath(String.format(PRECISE_TEXT_XPATH, "Sortable Data Tables"));
    private final By DueElementsLocator = By.xpath("//table[@id='table1']//td[4]");

    @Test
    public void dataTableTest() {
        driver.findElement(sortableDataTables).click();
        List<WebElement> dueList = driver.findElements(DueElementsLocator);
        double actualSum = 0.0;
        for (WebElement element : dueList) {
            String elementText = element.getText();
            String currencyRegex = "[^\\d.]";
            actualSum += Double.parseDouble(elementText.replaceAll(currencyRegex, ""));
        }
        double expectedSum = 251.0;
        Assert.assertEquals(actualSum, expectedSum, "sum is not correct");
        // todo: assert due sum
    }
}
