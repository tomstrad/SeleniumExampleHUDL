package steps;

import PageViews.LoginPageView;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import pageObjects.LoginPage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LoginStepDefs implements En {
    public LoginStepDefs() {
        When("^I enter a invalid username and valid password$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.enterUsername("Banana"));
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.enterPassword("HudlLogin1"));
        });
        Given("^I am on the Login Page$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.getLoginPage());
            LoginPageView.getLoginPages().forEach(loginPage -> assertEquals("Log In - Hudl", loginPage.getPageTitle()));
        });
        When("^I enter valid credentials$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.enterUsername("tcneal91@yahoo.co.uk"));
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.enterPassword("HudlLogin1"));
        });
        And("^I click Login$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.clickLogIn());
        });
        Then("^I see the users dashboard$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> assertEquals("Home - Hudl", loginPage.getPageTitle()));
        });
        When("^I enter a valid username and invalid password$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.enterUsername("tcneal91@yahoo.co.uk"));
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.enterPassword("WrongPASSWORD"));
        });
        Then("^I see an unsuccessful login message$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> assertTrue(loginPage.getPageText().contains("We didn't recognize that email and/or password.")));
        });
        When("^I click Login without entering any information$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.blankFields());
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.clickLogIn());
        });
        When("^I click Need Help$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.clickNeedHelp());
        });
        Then("^The help information is displayed$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> assertTrue(loginPage.isResetButtonVisible()));
        });
        When("^I click the back arrow on the page$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> loginPage.clickBackButton());
        });
        Then("^I return to the Hudl homepage$", () -> {
            LoginPageView.getLoginPages().forEach(loginPage -> assertEquals("https://www.hudl.com/en_gb/", loginPage.getPageUrl()));
        });
    }
}
