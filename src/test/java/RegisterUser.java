

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;

public class RegisterUser {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String letras = "abcdefghijklmnopqrstuvwxyz";
    Random rand = new Random();
    String name = "Ale Teste" + rand.nextInt(1000);
    String email = "ale.teste" + rand.nextInt(1000) + "@gmail.com";
    String password = "123456789";

    @BeforeEach
	void start() {
        driver = new ChromeDriver();
		homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

    @AfterEach
	void finish() {
		driver.close();
	}

    @Test 
    @DisplayName("Register User")
    void registerUser() {
        
        homePage.openHomePage();
        homePage.isHomePageVisible();
        homePage.clickSignupLoginButton();
        loginPage.newUserSingnupVisible();
        loginPage.enterNewUserName(name);
        loginPage.enterNewEmail(email);
        loginPage.clickSignupButton();
        registrationPage.verifyTitleIsVisible();
        registrationPage.enterAccountInformation(password, "10", "April", "1980", "First name", "Last Name", "Address", "Canada", "City", "123456", "1234567890");
        registrationPage.accountCreatedIsVisible();
        registrationPage.clickContinueButton();
        homePage.userIconIsVisible();
        homePage.clickDeleteAccountButton();
    }

    @Test
    @DisplayName("Login User with correct credentials")
    void loginUserCorrectCredentials() {

        homePage.openHomePage();
        homePage.isHomePageVisible();
        homePage.clickSignupLoginButton();
        loginPage.loginAccountVisible();
        loginPage.enterEmailLogin("alexandre.qa@teste.com");
        loginPage.enterPasswordLogin("12345");
        loginPage.clickLoginButton();
        homePage.userIconIsVisible();

    }
}
