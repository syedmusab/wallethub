package tests.wallethub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.wallethub.WallethubPage;
import tests.facebook.FacebookTest;

/**
 * Created by smali on 10/18/2019.
 */
public class WallethubTest extends WallethubPage {

    private static final Logger log = LoggerFactory.getLogger(FacebookTest.class);

    public WallethubTest(){
        super();
    }

    WallethubPage wallethubPage;

    @BeforeTest
    public void setUp() throws InterruptedException {
        initialization();
        wallethubPage = new WallethubPage();
    }

    @Test
    public void loginScreenValidation() throws InterruptedException {
        wallethubPage.signInScreen(prop.getProperty("usernamewallethub"), prop.getProperty("password"));
    }

}
