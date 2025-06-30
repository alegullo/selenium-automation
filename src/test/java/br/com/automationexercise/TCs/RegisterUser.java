package br.com.automationexercise.TCs;

import static com.codeborne.selenide.Condition.name;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tests.Pages.HomePage;
import br.com.tests.Pages.LoginPage;
import br.com.tests.Pages.RegistrationPage;

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
        registrationPage.enterAccountInformation(password, "10", "April", "1980", "First name", "Last Name", "Address", "State", "City", "123456", "1234567890");
}
}
