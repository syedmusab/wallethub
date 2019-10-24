package tests.facebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.facebook.FacebookLoginPage;

/**
 * @author smali
 *
 */
public class FacebookTest extends FacebookLoginPage {

    private static final Logger log = LoggerFactory.getLogger(FacebookTest.class);

    FacebookLoginPage loginPage;

    public FacebookTest(){
        super();
    }

    @BeforeTest
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new FacebookLoginPage();
    }

    @Test
    public void loginScreenValidation() throws InterruptedException {
        loginPage.logInScreen(prop.getProperty("username"), prop.getProperty("password"), "Hello World!");
    }
}
