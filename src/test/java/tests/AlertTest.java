package tests;

import aquality.selenium.browser.AlertActions;
import pages.JavaScriptAlertsPage;
import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static io.qameta.allure.Allure.step;

public class AlertTest extends BaseTest {
    private final JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

    @Test
    public void alertTest() {
        step("Handle JavaScript Alert flow", () -> {

            step("Navigate to JavaScript Alerts page", () ->
                    mainPage.clickNavigationLink(MainPageNavigation.JAVASCRIPT_ALERT)
            );
            step("Click 'Click for JS Alert' button", javaScriptAlertsPage::clickForJsAlertBtn
            );
            step("Accept the alert popup", () ->
                    getBrowser().handleAlert(AlertActions.ACCEPT)
            );
            step("Verify success message is displayed", () ->
                    Assert.assertTrue(javaScriptAlertsPage.isSuccessLabelDisplayed(), "Success msg is not displayed")
            );
        });
    }
}
