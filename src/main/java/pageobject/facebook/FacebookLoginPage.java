package pageobject.facebook;

import base.BaseIT;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by smali
 */
public class FacebookLoginPage extends BaseIT {

    @FindBy(name = "email")
    private WebElement usernameField;

    @FindBy(name = "pass")
    private WebElement passwordField;

    @FindBy(css = "#loginbutton")
    private WebElement logInBtn;

    @FindBy(name = "xhpc_message")
    private WebElement postCreate;

    @FindBy(xpath = "//*[@type='submit']")
    private List<WebElement> submitBtn;


    // Initializing the Page Objects:
    public FacebookLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void logInScreen(String username, String password, String post) throws InterruptedException {
        driver.get(prop.getProperty("facebookurl"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInBtn.click();
        Thread.sleep(5000);
        postCreate.click();
        postCreate.sendKeys(post);

        for (WebElement element : submitBtn) {
            if (element.getText().contains("Post")) {
                element.click();
            }
        }

    }
}
