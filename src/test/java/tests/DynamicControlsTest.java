package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.DynamicControlsPage;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.qameta.allure.Allure.step;

public class DynamicControlsTest extends BaseTest {
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private final String RANDOM_TEXT = UUID.randomUUID().toString();

    @Test
    public void dynamicControlsTest() {
        step("Navigate to Dynamic Controls page");
        mainPage.clickNavigationLink(MainPageNavigation.DYNAMIC_CONTROLS);
        dynamicControlsPage.clickEnableBtn();
        Assert.assertTrue(dynamicControlsPage.isInputEnabled(),"Input field is not enabled");
        dynamicControlsPage.inputText(RANDOM_TEXT);
        Assert.assertEquals(dynamicControlsPage.getInputTextValue(),RANDOM_TEXT, "Text is not displayed");
    }
}
