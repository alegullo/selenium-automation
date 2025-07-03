package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id="slider-carousel")
    WebElement verifyHomePageVisible;

    @FindBy(css = "a[href='/login']")
    WebElement signupLoginButton;

    @FindBy(xpath = "//*[text()='New User Signup!']")
    WebElement newUserSingnupVisible;

    @FindBy(css = "[class='fa fa-user']")
    private WebElement userIcon;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(css = "[data-qa='account-deleted']")
    private WebElement verifyAccountDeleted;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        return isElementVisible(verifyHomePageVisible);
    }
    
    public void clickSignupLoginButton() {
        safeClick(signupLoginButton);
    }

    public void openHomePage() {
        driver.get("https://www.automationexercise.com/");
    }

    public void newUserSingnupVisible() {
        isElementVisible(newUserSingnupVisible);
    }

    public void userIconIsVisible() {
        isElementVisible(userIcon);
    }

    public void clickDeleteAccountButton() {
        safeClick(deleteAccountButton);
    }

    public void verifyAccountDeleted() {
        isElementVisible(verifyAccountDeleted);
    }
}
