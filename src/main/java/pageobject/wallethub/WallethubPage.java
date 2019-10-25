package pageobject.wallethub;

import base.BaseIT;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by smali
 */
public class WallethubPage extends BaseIT {

    @FindBy(name = "em")
    private WebElement emailAddress;

    @FindBy(name = "pw1")
    private WebElement password1;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginBtn;

    @FindBy(className = "btn blue-brds")
    private WebElement writeReviewBtn;

    @FindBy(css = "#reviews-section > modal-dialog > div > div > write-review > review-star > div > svg:nth-child(4)")
    private WebElement starIcon;

    @FindBy(css = "#reviews-section > modal-dialog > div > div > write-review > div > ng-dropdown > div > ul > li:nth-child(2)")
    private WebElement dropdownOptionHealthInsurance;

    @FindBy(xpath = "//span[class()='dropdown-placeholder']")
    private WebElement dropdown;

    @FindBy(xpath = "//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/sub-navigation/div/div[2]")
    private WebElement submitBtn;

    @FindBy(className = "android")
    private WebElement writeYourReview;


    // Initializing the Page Objects:
    public WallethubPage() {
        PageFactory.initElements(driver, this);
    }

    public void signInScreen(String username, String password) throws InterruptedException {
        driver.get(prop.getProperty("wallethuburl"));
        emailAddress.sendKeys(username);
        password1.sendKeys(password);
        Thread.sleep(5000);
        loginBtn.click();
    }

    public void writeRevieAndSetScore() throws InterruptedException, IOException {

        Thread.sleep(5000);
        driver.get(prop.getProperty("companyprofile"));
        writeReviewBtn.isDisplayed();
        writeReviewBtn.click();

        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.moveToElement(starIcon).perform();
        dropdown.click();
        dropdownOptionHealthInsurance.click();
        String reviewText = loadFile("G:\\wallethub-assessment\\src\\main\\resources\\review.txt");
        writeYourReview.sendKeys(reviewText);
        submitBtn.click();


    }
}
