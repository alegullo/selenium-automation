package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    private WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    private WebElement getInTouchTitle;

    @FindBy(css = "[data-qa='name']")
    private WebElement inputName;

    @FindBy(css = "[data-qa='email']")
    private WebElement inputEmail;

    @FindBy(css = "[data-qa='subject']")
    private WebElement inputSubject;

    @FindBy(css = "[data-qa='message']")
    private WebElement inputMessage;

    @FindBy(name = "upload_file")
    private WebElement inputUploadFile;

    @FindBy(css = "[data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Success! Your details have been submitted successfully.')]")
    private WebElement successMessage;

    @FindBy(css = "[class='btn btn-success']")
    private WebElement homeButton;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isGetInTouchVisible() {
        return getInTouchTitle.isDisplayed();
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputSubject.sendKeys(subject);
        inputMessage.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        inputUploadFile.sendKeys(filePath);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isDisplayed();
    }

    public void clickHome() {
        homeButton.click();
    }
} 