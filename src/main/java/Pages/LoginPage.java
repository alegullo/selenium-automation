package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[text()='New User Signup!']")
    WebElement newUserSingnupVisible;

    @FindBy(css = "[data-qa='signup-name']")
    WebElement newUserName;

    @FindBy(css = "[data-qa='signup-email']")
    WebElement newEmailName;

    @FindBy(css = "[data-qa='signup-button']")
    WebElement signupButton;

    @FindBy(xpath = "//*[text()='Login to your account']")
    WebElement newUserLoginVisible;

    @FindBy(css = "[data-qa='login-email']")
    WebElement emailLogin;

    @FindBy(css = "[data-qa='login-password']")
    WebElement passwordLogin;

    @FindBy(css = "[data-qa='login-button']")
    WebElement loginButton;





    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newUserSingnupVisible() {
        newUserSingnupVisible.isDisplayed();
    }

    public void enterNewUserName(String name) {
        newUserName.sendKeys(name);
    }

    public void enterNewEmail(String email) {
        newEmailName.sendKeys(email);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public void loginAccountVisible() {
        newUserLoginVisible.isDisplayed();
    }

    public void enterEmailLogin(String email) {
        emailLogin.sendKeys(email);
    }

    public void enterPasswordLogin(String password) {
        passwordLogin.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
