package browserDriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserDriver {
    private static WebDriver edgeDriver;
    private static WebDriver chromeDriver;

    public synchronized static WebDriver getEdgeDriver(){
        if (edgeDriver == null) {
            try {
                System.setProperty("webdriver.edge.edgeDriver", "C:\\WebDrivers\\MicrosoftWebDriver.exe");
//                URL url = new URL("http://localhost:4447/wd/hub");
//                Capabilities capabilities = DesiredCapabilities.edge();
                edgeDriver = new EdgeDriver();

                //                edgeDriver = new RemoteWebDriver(url, capabilities);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
        }
        return edgeDriver;
    }

    public synchronized static WebDriver getChromeDriver(){
        if (chromeDriver == null) {
            try {
                System.setProperty("webdriver.chrome.edgeDriver", "C:\\WebDrivers\\ChromeDriver.exe");
//                URL url = new URL("http://localhost:4449/wd/hub");
//                Capabilities capabilities = DesiredCapabilities.chrome();
                chromeDriver = new ChromeDriver();
//                chromeDriver = new RemoteWebDriver(url, capabilities);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
            } finally {
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
        }
        return chromeDriver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.out.println("Closing the browser");
            close();
            }
    }

    public static void close(){
        try {
            getEdgeDriver().quit();
            edgeDriver = null;
            System.out.println("closing the browser");
        } catch (UnreachableBrowserException e) {
            System.out.println("cannot close browser: unreachable browser");
        }
    }


}