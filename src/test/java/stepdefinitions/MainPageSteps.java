package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Given("I go to {string} on the main page")
    public void goTo(String page) {
        step("I go to " + page + " on the Main page");
        mainPage.clickNavigationLink(page);
    }
}
