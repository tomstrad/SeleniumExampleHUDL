package pageObjects;

import browserDriver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHQ {

    private final static String PAGE_URL="http://www.seleniumhq.org/";

    private final String pageTite ="Selenium";

    protected WebDriver edgeDriver;
    protected WebDriver chromeDriver;

    private By documentButton = By.linkText("Documentation");

    private By projectsButton = By.linkText("Projects");


    public SeleniumHQ(){
        edgeDriver = BrowserDriver.getEdgeDriver();
        chromeDriver = BrowserDriver.getChromeDriver();
    }

    public void navigateHome(){
        edgeDriver.get(PAGE_URL);
        chromeDriver.get(PAGE_URL);
    }

    public void clickProjectsButton() throws InterruptedException {
        System.out.println("clicking on projects button");
        WebElement projectsBtnElement= edgeDriver.findElement(projectsButton);
        if(projectsBtnElement.isDisplayed()||projectsBtnElement.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(edgeDriver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(projectsBtnElement));
            projectsBtnElement.click();
            System.out.println("Button Clicked");
        }
        else System.out.println("Element not found");

        System.out.println("clicking on projects button");
        WebElement chromeProjectsBtnElement= chromeDriver.findElement(projectsButton);
        if(chromeProjectsBtnElement.isDisplayed()||chromeProjectsBtnElement.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(chromeProjectsBtnElement));
            chromeProjectsBtnElement.click();
            System.out.println("Button Clicked");
        }
        else System.out.println("Element not found");
    }

    public void clickDocumentsButton() throws InterruptedException {
        System.out.println("clicking on Documentation button");
        WebElement docsBtnElement= edgeDriver.findElement(documentButton);
        if(docsBtnElement.isDisplayed()||docsBtnElement.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(edgeDriver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(docsBtnElement));
            docsBtnElement.click();
            System.out.println("Button Clicked");
        }
        else System.out.println("Element not found");

        System.out.println("clicking on Documentation button");
        WebElement chromeDocsBtnElement= chromeDriver.findElement(documentButton);
        if(chromeDocsBtnElement.isDisplayed()||chromeDocsBtnElement.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(chromeDocsBtnElement));
            chromeDocsBtnElement.click();
            System.out.println("Button Clicked");
        }
        else System.out.println("Element not found");
    }


    public boolean verifyPageTitle(){
        WebDriverWait wait = new WebDriverWait(edgeDriver, 30);
        wait.until(ExpectedConditions.titleContains(pageTite));
        WebDriverWait chromeWait = new WebDriverWait(chromeDriver, 30);
        chromeWait.until(ExpectedConditions.titleContains(pageTite));
        return getPageTitle().contains(pageTite) && chromeDriver.getTitle().contains(pageTite);

    }

    public String getPageTitle(){
        return edgeDriver.getTitle();
    }

}
