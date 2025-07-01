package br.com.tests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageVisible() {
        return verifyHomePageVisible.isDisplayed();
    }
    public void clickSignupLoginButton() {
        signupLoginButton.click();
    }

    public void openHomePage() {
        driver.get("https://www.automationexercise.com/");
    }

    public void newUserSingnupVisible() {
        newUserSingnupVisible.isDisplayed();
    }

    public void userIconIsVisible() {
        userIcon.isDisplayed();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void verifyAccountDeleted() {
        verifyAccountDeleted.isDisplayed();
    }
}
