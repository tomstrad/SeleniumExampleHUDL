package pageObjects;

import browserDriver.BrowserDriver;
import browserDriver.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final static String PAGE_URL="https://www.hudl.com/login";

    private WebDriver webdriver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By logInButton = By.id("logIn");
    private By needHelpButton = By.id("forgot-password-link");
    private By backButton = By.className("back-to-hudl-arrow");
    private By resetButton = By.id("resetBtn");

    public LoginPage(DriverType driverType){

        switch (driverType) {
            case EDGE:
                webdriver = BrowserDriver.getEdgeDriver();
                break;
            case CHROME:
                webdriver = BrowserDriver.getChromeDriver();
                break;
        }
    }

    public void getLoginPage(){
        webdriver.get(PAGE_URL);
    }

    public String getPageTitle(){
        return webdriver.getTitle();
    }

    public void enterPassword(String pwd){
        webdriver.findElement(passwordField).sendKeys(pwd);
    }

    public void enterUsername(String user){
        webdriver.findElement(usernameField).sendKeys(user);
    }

    public void clickLogIn(){
        webdriver.findElement(logInButton).click();
    }

    public void clickNeedHelp(){
        webdriver.findElement(needHelpButton).click();
    }

    public void blankFields(){
        webdriver.findElement(usernameField).clear();
        webdriver.findElement(passwordField).clear();
    }

    public String getPageUrl(){
        return webdriver.getCurrentUrl();
    }

    public void clickBackButton(){
        webdriver.findElement(backButton).click();
    }

    public boolean isResetButtonVisible(){
        return webdriver.findElement(resetButton).isDisplayed();
    }

    public String getPageText(){
        return webdriver.getPageSource();
    }






}
