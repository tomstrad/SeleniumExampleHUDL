package PageViews;

import browserDriver.DriverType;
import pageObjects.LoginPage;

import java.util.ArrayList;

public class LoginPageView {

    private static LoginPage edgeLoginPage;
    private static LoginPage chromeLoginPage;

    public synchronized static ArrayList<LoginPage> getLoginPages(){
        if(edgeLoginPage == null){
            edgeLoginPage = new LoginPage(DriverType.EDGE);
        }
        if(chromeLoginPage == null){
            chromeLoginPage = new LoginPage(DriverType.CHROME);
        }

        ArrayList<LoginPage> loginPages = new ArrayList();
        loginPages.add(edgeLoginPage);
        loginPages.add(chromeLoginPage);

        return loginPages;
    }


}
