package tests;

import constants.MainPageNavigation;
import models.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasicAuthPage;
import utils.EnvDataReader;
import utils.TestDataReader;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BasicAuthTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    public void auth() {
        UserData userData= TestDataReader.getUserData();

        getBrowser().network().addBasicAuthentication(
                EnvDataReader.getEnvData().getDomain(),
                userData.getUsername(),
                userData.getPassword()
        );
    }

    @Test
    public void basicAuthTest() {
    mainPage.clickNavigationLink(MainPageNavigation.BASIC_AUTH);
        Assert.assertTrue(basicAuthPage.isSuccessMsgDisplayed(),"Success message is not displayed");
    }
}
