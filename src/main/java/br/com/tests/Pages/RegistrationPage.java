package br.com.tests.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInformationVisible;

    //  Informações da conta
    @FindBy(id = "id_gender1")
    private WebElement radioTitleMr;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "days")
    private WebElement dropdownDay;

    @FindBy(id = "months")
    private WebElement dropdownMonth;

    @FindBy(id = "years")
    private WebElement dropdownYear;

    @FindBy(id = "first_name")
    private WebElement inputFirstName;

    @FindBy(id = "last_name")
    private WebElement inputLastName;

    @FindBy(id = "address1")
    private WebElement inputAddress;

    @FindBy(id = "state")
    private WebElement inputState;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "zipcode")
    private WebElement inputZipcode;

    @FindBy(id = "mobile_number")
    private WebElement inputMobileNumber;

    @FindBy(css = "[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(css = "[data-qa='account-created']")
    private WebElement accountCreated;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTitleIsVisible() {
        enterAccountInformationVisible.isDisplayed();
    }
    
    public void enterAccountInformation(String password, String day, String month, String year, String firstName, String lastName, String address, String state, String city, String zipcode, String mobileNumber) {
        radioTitleMr.click();
        inputPassword.sendKeys(password);
        dropdownDay.sendKeys(day);
        dropdownMonth.sendKeys(month);
        dropdownYear.sendKeys(year);
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputAddress.sendKeys(address);
        inputState.sendKeys(state);
        inputCity.sendKeys(city);
        inputZipcode.sendKeys(zipcode);
        inputMobileNumber.sendKeys(mobileNumber);
        createAccountButton.click();
    }

    public void accountCreatedIsVisible() {
        accountCreated.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }


}
